package ac.at.fhcampuswien.classes;

import java.util.List;

public class NewsResponse {
    //Singleton instance
    private static NewsResponse _instance = null;

    //gets the Results from the API
    private String status;
    private int totalResults;
    private List<Article> articles;

    //private Constructor for Singelton
    private NewsResponse(){};

    //set a instance if there is no instance
    public static NewsResponse getInstance(){
        if (_instance == null){
            _instance = new NewsResponse();
        }
        return _instance;
    }

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
