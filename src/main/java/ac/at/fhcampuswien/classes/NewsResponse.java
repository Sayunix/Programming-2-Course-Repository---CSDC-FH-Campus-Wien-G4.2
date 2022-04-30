package ac.at.fhcampuswien.classes;

import java.util.List;

public class NewsResponse {

    //gets the Results from the API

    private String status;
    private int totalResults;
    private List<Article> articles;

    //returns status
    public String getStatus() {
        return status;
    }

    //returns total results
    public int getTotalResults() {
        return totalResults;
    }

    //returns list of articles
    public List<Article> getArticles() {
        return articles;
    }

}
