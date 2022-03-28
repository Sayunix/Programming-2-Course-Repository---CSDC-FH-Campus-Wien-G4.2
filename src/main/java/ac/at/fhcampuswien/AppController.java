package ac.at.fhcampuswien;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AppController {
    private List<Article> articles;

    //The constructor greats a new List and in Exercise 1 articles get filled by the generateMockList() method
    public AppController() {
        articles = new ArrayList<Article>();
        articles = generateMockList();
    }

    //setter for the articles
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    //returns the amount of the Articles in the List
    public int getArticleCount() {
        if (articles.size() != 0) {
            return articles.size();
        } else {
            return 0;
        }
    }

    //returns a List with the top headlines
    public List<Article> getTopHeadlinesAustria() {
        if (articles != null) {
            return articles;
        } else {
            return new ArrayList<Article>();
        }
    }

    //returns a List with Bitcoin News
    public List<Article> getAllNewsBitcoin() {
        return filterList("bitcoin",articles);
    }


    //returns a List for a specified Word in the News
    protected List<Article> filterList(String query, List<Article> articles) {
        List<Article> filteredList = new ArrayList<Article>();

        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).toString().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(articles.get(i));
            }
        }
        return  filteredList;
    }

    //generated Mock List for the Exercise 1
    private List<Article> generateMockList(){
        Article a1 = new Article("New York Times", "Eric Adams, a Bitcoin Booster, Is Taking First Paycheck in Crypto");
        articles.add(a1);
        Article a2 = new Article("News Sky", "Irishman held against his will in China for 3 years reunited with 'unbelievably happy' family");
        articles.add(a2);
        Article a3 = new Article("News Sky", "Mother who won £127,000 tells how she still ended up homeless");
        articles.add(a3);

        return articles;
    }
}
