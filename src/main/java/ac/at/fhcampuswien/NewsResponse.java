package ac.at.fhcampuswien;

import java.util.List;

public class NewsResponse {

    //gets the Results from the API

    private String status;
    private int totalResults;
    private List<Article> articles;

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public List<Article> getArticles() {
        return articles;
    }

}
