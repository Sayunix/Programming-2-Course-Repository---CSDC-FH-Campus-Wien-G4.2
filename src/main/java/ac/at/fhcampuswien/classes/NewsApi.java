package ac.at.fhcampuswien.classes;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class NewsApi {
    NewsResponse newsResponse = new NewsResponse();

    private String URL = "https://newsapi.org/v2/";
    private String apiKey = "?apiKey=5010f35b2673443ca4dd94c9064d03d2";

    private static String q;
    private static String endpoint;
    private static String country;
    private static String category;
    private static String language;
    private static String sortBy;

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    //sets the value for our query
    public void setQ(String q) {
        this.q = q;
    }

    //sets the value of our endpoint
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    //sets the value for the country we want news for
    public void setCountry(String country) {
        this.country = country;
    }

    //sets the category that we want news from
    public void setCategory(String category) {
        this.category = category;
    }

    //sets the language our news should be in
    public void setLanguage(String language) {
        this.language = language;
    }

    //sets a value that should be sorted by, that can be used by the api
    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    // returns the query value with the needed prefix to make a url out of it
    public String getQ() {
        return "&q=" + q;
    }

    // returns the value of our endpoint as string
    public String getEndpoint() {
        return endpoint;
    }

    // returns a string that contains the value of the country that we want plus the prefix needed to put it in the url
    public String getCountry() {
        return "&country=" + country;
    }

    // returns a string that contains the value of the category plus the prefix needed to put it in the url
    public String getCategory() {
        return "&category=" + category;
    }

    // returns a string that contains information of the language that we want plus prefix to put in url
    public String getLanguage() {
        return "&language=" + language;
    }

    // returns the value that should be sorted by plus prefix to put as url
    public String getSortBy() {
        return "&sortBy=" + sortBy;
    }

    //generates a url but checks first if the endpoint we need is "top-headlines" because different endpoints need
    //different values in the url
    //then it generates a link with the needed values and returns that url as a String
    //after the url is generated all values are reset
    public String generateURL() {
        String tmpURL;
        if (endpoint.equals("top-headlines")) {
            if (country.equals("all")) {
                setCountry("");
            }
            tmpURL = URL + getEndpoint() + apiKey + getQ() + getCountry() + getCategory();
        } else {
            if (language.equals("all")) {
                setLanguage("");
            }
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

    // takes a url as and sends a request to the api using that link and processes the response from the api
    // to a string
    public String run(String url) throws NoInternetException {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            throw new NoInternetException();
        }
    }

    //calls the run method with a string url as parametric and converts the response from the newsapi
    //from json into a java object using gson
    public NewsResponse deserializeArticle(String url) throws NoInternetException {
        Gson gson = new Gson();
        newsResponse = gson.fromJson(run(url), NewsResponse.class);
        return newsResponse;
    }
}
