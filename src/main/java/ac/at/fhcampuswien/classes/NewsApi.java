package ac.at.fhcampuswien.classes;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class NewsApi {
    NewsResponse newsResponse = new NewsResponse();

    private String URL = "https://newsapi.org/v2/";
    private String apiKey = "?apiKey=1822ed653d964bf3b3b280eafc9b6a6b";

    private static String q;
    private static String endpoint;
    private static String country;
    private static String category;
    private static String language;
    private static String sortBy;

    public void setQ(String q) {
        this.q = q;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCategory(String category) {this.category = category;}

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setSortBy(String sortBy) {this.sortBy = sortBy;}

    public String getQ() {
        return "&q="+q;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getCountry() {
        return "&country="+country;
    }

    public String getCategory() {return "&category="+category; }

    public String getLanguage() {
        return "&language="+language;
    }

    public String getSortBy() {return "&sortBy="+sortBy; }

    public String generateURL(){
        String tmpURL;
        if (endpoint.equals("top-headlines")) {
            tmpURL = URL + getEndpoint() + apiKey + getQ() + getCountry() + getCategory();
        }else{
            tmpURL = URL + getEndpoint() + apiKey + getQ() + getSortBy() + getLanguage();
        }

        setQ("");
        setCountry("");
        setEndpoint("");
        setCategory("");
        setLanguage("");
        setSortBy("");

        return tmpURL;
    }

    public String run(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public NewsResponse deserializeArticle(String url) throws IOException {
        Gson gson = new Gson();

        newsResponse = gson.fromJson(run(url), NewsResponse.class);

        return newsResponse;
    }
}
