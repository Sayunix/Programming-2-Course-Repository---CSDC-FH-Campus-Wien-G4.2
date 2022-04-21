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

    public String getQ() {
        return "&q="+q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getCountry() {
        return "&country="+country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String generateURL(){
        String tmpURL;
        if (endpoint.equals("top-headlines")) {
            tmpURL = URL + getEndpoint() + apiKey + getQ() + getCountry();
        }else{
            tmpURL = URL + getEndpoint() + apiKey + getQ();
        }

        setQ("");
        setCountry("");
        setEndpoint("");

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
