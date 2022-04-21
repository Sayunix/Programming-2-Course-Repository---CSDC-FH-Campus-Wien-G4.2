package ac.at.fhcampuswien;

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

    //returns the amount of the Articles in the List
    public int getArticleCount() {
        return newsResponse.getTotalResults();
    }

    //returns a List with the top headlines
    public List<Article> getTopHeadlines(String q, String selectCountry) throws IOException {
        newsApi.setQ(q);
        newsApi.setCountry(selectCountry);
        newsApi.setEndpoint(endpoint.top_headlines.toString());

        newsResponse = newsApi.deserializeArticle(newsApi.generateURL());

        return newsResponse.getArticles();
    }

    //returns a List with Bitcoin News
    public List<Article> getAllNewsBitcoin() throws IOException {
        newsApi.setQ("bitcoin");
        newsApi.setEndpoint(endpoint.everything.toString());

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
