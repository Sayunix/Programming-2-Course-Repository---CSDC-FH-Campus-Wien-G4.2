package ac.at.fhcampuswien.classes;

import ac.at.fhcampuswien.enums.endpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AppController {
    NewsApi newsApi = new NewsApi();
    NewsResponse newsResponse = new NewsResponse();
    Source source = new Source();

    private List<Article> articles;

    //The constructor greats a new List
    public AppController(){
        articles = new ArrayList<Article>();
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
    public List<Article> getTopHeadlines(String q, String selectCountry, String selectedCategory) throws IOException {
        newsApi.setQ(q);
        newsApi.setCountry(selectCountry);
        newsApi.setEndpoint(endpoint.top_headlines.toString());
        newsApi.setCategory(selectedCategory);

        newsResponse = newsApi.deserializeArticle(newsApi.generateURL());
        setArticles(newsResponse.getArticles());

        return articles;
    }

    //creates a URL for the Request and returns a List with the Bitcoin-News, which is Responsed from the API
    public List<Article> getAllNewsBitcoin(String selectedLanguage, String selectedSortBy) throws IOException {
        newsApi.setQ("bitcoin");
        newsApi.setEndpoint(endpoint.everything.toString());
        newsApi.setLanguage(selectedLanguage);
        newsApi.setSortBy(selectedSortBy);

        newsResponse = newsApi.deserializeArticle(newsApi.generateURL());
        setArticles(newsResponse.getArticles());

        return articles;
    }

    public String printAmountNYTArticles(){
        if (articles != null){
            return ""+articles.stream().filter(article -> article.getSource().getName().equals("New York Times"))
                            .count();
        }else{
            return "No Articles in the List!";

        }
    }

    public String printMostSource(){
        if (articles != null){
            return  articles.stream()
                    .max(Comparator.comparing(article -> article.getSource().getName()))
                    .get().getSource().getName();
        }else{
            return "No Articles in the List!";
        }
    }

    public String printLongestAuthorName(){
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getAuthor() == null){
                articles.get(i).setAuthor("");
            }
        }
        if (articles.size() != 0){
            return  articles
                    .stream()
                    .max(Comparator.comparing(article -> article.getAuthor().length()))
                    .get().getAuthor();
        }else{
            return "No Articles in the List!";
        }
    }

    public List<Article> printHeadlinesUnder15(){
        if (articles != null){
            setArticles(articles.stream()
                    .filter(article -> article.getTitle()
                            .length() < 15).collect(Collectors.toList()));
            newsResponse.setTotalResults(articles.size());
            return articles;
        }
        else{
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
