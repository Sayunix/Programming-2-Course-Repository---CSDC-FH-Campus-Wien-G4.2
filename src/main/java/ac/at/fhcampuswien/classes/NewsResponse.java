package ac.at.fhcampuswien.classes;

import java.util.List;

public class NewsResponse {
    //gets the Results from the API

    private String status;
    private int totalResults;
    private List<Article> articles;

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

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
