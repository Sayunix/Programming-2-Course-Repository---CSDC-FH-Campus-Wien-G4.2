package ac.at.fhcampuswien;

import java.util.ArrayList;
import java.util.List;

public class AppController {
    private List<Article> articles;

    public AppController() {
        articles = new ArrayList<Article>();
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public int getArticleCount() {
        if (articles.size() != 0) {
            return articles.size();
        } else {
            return 0;
        }
    }

    public List<Article> getTopHeadlinesAustria() {
        if (articles != null) {
            return articles;
        } else {
            return new ArrayList<Article>();
        }
    }

    public List<Article> getAllNewsBitcoin() {
        return filterList("bitcoin",articles);
    }

    protected List<Article> filterList(String query, List<Article> articles) {
        List<Article> filteredList = new ArrayList<Article>();
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).toString().toLowerCase().contains(query)) {
                filteredList.add(articles.get(i));
            }
        }
        return  filteredList;
    }
}
