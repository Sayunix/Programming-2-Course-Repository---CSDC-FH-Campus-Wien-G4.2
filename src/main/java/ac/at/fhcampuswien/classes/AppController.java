package ac.at.fhcampuswien.classes;

import ac.at.fhcampuswien.enums.endpoint;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AppController {
    NewsApi newsApi = new NewsApi();
    NewsResponse newsResponse = new NewsResponse();
    Source source = new Source();

    private int counter = 0;
    private List<Article> articles;
    private int amountArticleUnder15;

    //The constructor greats a new List
    public AppController() {
        articles = new ArrayList<Article>();
    }


    public void setAmountArticlesUnder15(int number){
        this.amountArticleUnder15 = number;
    }

    public int getAmountArticlesUnder15(){
        return this.amountArticleUnder15;
    }

    //setter for the articles
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    //returns the amount of the Articles, which is taken from an attribute from NewsResponse
    public int getArticleCount() {
        return newsResponse.getTotalResults();
    }

    //creates a URL for the Request and returns a List with the top headlines, which is Responsed from the API
    public List<Article> getTopHeadlines(String q, String selectCountry, String selectedCategory) throws NoInternetException, NewsAPIException {
        newsApi.setQ(q);
        newsApi.setCountry(selectCountry);
        newsApi.setEndpoint(endpoint.top_headlines.toString());
        newsApi.setCategory(selectedCategory);

        newsResponse = newsApi.deserializeArticle(newsApi.generateURL());
        if (newsResponse.getStatus().equals("error")) {
            newsApi.setApiKey("?apiKey=743488a1ac334f79a8e70e2267d25e21");
            if (counter == 1){
                throw new NewsAPIException();
            }
            counter++;
            getTopHeadlines(q, selectCountry, selectedCategory);
        }
        counter = 0;
        setArticles(newsResponse.getArticles());
        return articles;
    }

    //creates a URL for the Request and returns a List with the Bitcoin-News, which is Responsed from the API
    public List<Article> getAllNewsBitcoin(String selectedLanguage, String selectedSortBy) throws NoInternetException, NewsAPIException{
        newsApi.setQ("bitcoin");
        newsApi.setEndpoint(endpoint.everything.toString());
        newsApi.setLanguage(selectedLanguage);
        newsApi.setSortBy(selectedSortBy);

        newsResponse = newsApi.deserializeArticle(newsApi.generateURL());
        if (newsResponse.getStatus().equals("error")) {
            newsApi.setApiKey("?apiKey=743488a1ac334f79a8e70e2267d25e21");
            if (counter == 1){
                throw new NewsAPIException();
            }
            counter++;
            getAllNewsBitcoin(selectedLanguage, selectedSortBy);
        }
        counter = 0;
        setArticles(newsResponse.getArticles());
        return articles;
    }

    //filters the list for articles that contain the phrase "New York Times"
    //then counts the amount of articles with that phrase and returns the amount as string,so we can output it in the label
    public String printAmountNYTArticles() {
        if (!articles.isEmpty()) {
            return "" + articles.stream().filter(article -> article.getSource().getName().equals("New York Times"))
                    .count();
        } else {
            return "No Articles in the List!";
        }
    }

    //Group articles with the same source name and counts how many times those are in the list
    //sets a map and assigns values to the map
    //adds a stream to the map and searches for the max value of a element(the name that is used the most)
    //gives the key(location) of most common element and returns that element
    public String printMostSource() {
        if (!articles.isEmpty()) {
            return articles.stream()
                    //Quelle:https://stackoverflow.com/questions/22989806/find-the-most-common-string-in-arraylist User:ChandraBhan Singh
                    .collect(Collectors.groupingBy(article -> article.getSource().getName(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue())
                    .get()
                    .getKey();
        } else {
            return "No Articles in the List!";
        }
    }

    //first removes every article without a known author
    //then returns the author with the longest name
    public String printLongestAuthorName() {
        if (!articles.isEmpty()) {
            return articles.stream()
                    .filter(article -> article.getAuthor() != null)
                    .max(Comparator.comparing(article -> article.getAuthor().length()))
                    .get().getAuthor();
        } else {
            return "No Articles in the List!";
        }
    }

    //filters list of articles for every article that has a title which is shorter than 15 characters
    //after filtering returns a list to caller with filtered elements
    public List<Article> printHeadlinesUnder15() {
        if (!articles.isEmpty()) {
            setArticles(articles.stream()
                    .filter(article -> article.getTitle()
                            .length() < 15).collect(Collectors.toList()));
            setAmountArticlesUnder15(articles.size());
            return articles;
        } else {
            return new ArrayList<>();
        }
    }

    //changes the description of every article that does not have a description to ""
    //then sorts articles by the length of their description
    //if length of the descriptions are same, filters by descriptions alphabetically
    public List<Article> longestDescription() {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getDescription() == null) {
                articles.get(i).setDescription("");
            }
        }
        if (!articles.isEmpty()) {
            setArticles(articles.stream()
//                    .filter(article -> article.getDescription() != null)   //if we want to remove all articles with no description
                    .sorted(Comparator.comparingInt((Article article) -> article.getDescription().length())
                            .thenComparing(Article::getDescription))
                    .collect(Collectors.toList()));
            return articles;

        } else {
            return new ArrayList<>();
        }
    }


    /**  //returns a List for a specified Word in the News
     protected List<Article> filterList(String query, List<Article> articles) {
     List<Article> filteredList = new ArrayList<Article>();

     for (int i = 0; i < articles.size(); i++) {
     if (articles.get(i).toString().toLowerCase().contains(query.toLowerCase())) {
     filteredList.add(articles.get(i));
     }
     }
     return  filteredList;
     }**/
}
