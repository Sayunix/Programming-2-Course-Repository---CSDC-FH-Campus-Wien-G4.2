package ac.at.fhcampuswien.classes;

import ac.at.fhcampuswien.enums.endpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppController {
    NewsApi newsApi = new NewsApi();
    NewsResponse newsResponse = new NewsResponse();

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

        return newsResponse.getArticles();
    }

    //creates a URL for the Request and returns a List with the Bitcoin-News, which is Responsed from the API
    public List<Article> getAllNewsBitcoin(String selectedLanguage, String selectedSortBy) throws IOException {
        newsApi.setQ("bitcoin");
        newsApi.setEndpoint(endpoint.everything.toString());
        newsApi.setLanguage(selectedLanguage);
        newsApi.setSortBy(selectedSortBy);

        newsResponse = newsApi.deserializeArticle(newsApi.generateURL());

        return newsResponse.getArticles();
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
