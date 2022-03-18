package ac.at.fhcampuswien;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.AnnotatedType;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppControllerTest {
    private AppController ac = new AppController();
    private List<Article> articles;

    @BeforeEach
     void setup(){
        articles = new ArrayList<>();
    }

    @Test
    //@DisplayName("tests set article method")
    public void setArticles(){
        Article a1 = new Article("Fabian Schneider","The future of Irish football.");
        articles.add(a1);
        Article a2 = new Article("Wolfgang A. Mozart","How bitcoin revived me from the dead!");
        articles.add(a2);

        ac.setArticles(articles);
        List<Article> actual = ac.getTopHeadlinesAustria();

        assertEquals(articles,actual);
    }
    @Test
    public void getArticleCount(){
        Article a1 = new Article("Fabian Schneider","The future of Irish football.");
        articles.add(a1);
        Article a2 = new Article("Wolfgang A. Mozart","How bitcoin revived me from the dead!");
        articles.add(a2);
        ac.setArticles(articles);

        int actual = ac.getArticleCount();
        int expected = 2;

        assertEquals(expected,actual);
    }
    @Test
    public void getArticleCount_empty(){
        ac.setArticles(articles);

        int actual = ac.getArticleCount();
        int expected = 0;

        assertEquals(expected,actual);
    }
    @Test
    public void getTopHeadlinesAustria(){
        Article a1 = new Article("Fabian Schneider","The future of Irish football.");
        articles.add(a1);
        Article a2 = new Article("Wolfgang A. Mozart","How bitcoin revived me from the dead!");
        articles.add(a2);
        ac.setArticles(articles);

        List<Article> expected = articles;

        assertEquals(expected, ac.getTopHeadlinesAustria());
    }
    @Test
    public void getAllNewsBitcoin(){
        Article a1 = new Article("Fabian Schneider","The future of Irish football.");
        articles.add(a1);
        Article a2 = new Article("Wolfgang A. Mozart","How bitcoin revived me from the dead!");
        articles.add(a2);

        ac.setArticles(articles);
        articles.remove(0);

        List<Article> expected = articles;

        assertEquals(expected,ac.getAllNewsBitcoin());
    }
    @Test
    public void noBitcoinNews(){
        Article a1 = new Article("Fabian Schneider","The future of Irish football.");
        articles.add(a1);
        Article a2 = new Article("Wolfgang A. Mozart","How Dogecoin revived me from the dead!");
        articles.add(a2);

        ac.setArticles(articles);
        List<Article> actual = ac.getAllNewsBitcoin();
        List<Article> expected = new ArrayList<>();

        assertEquals(expected,actual);
    }
    @Test
    public void filterList1(){
        Article a1 = new Article("Fabian Schneider","The future of Irish football.");
        articles.add(a1);
        Article a2 = new Article("Wolfgang A. Mozart","How Dogecoin revived me from the dead!");
        articles.add(a2);
        ac.setArticles(articles);

        List<Article> actual= ac.filterList("the", articles);
        List<Article> expected = articles;

        assertEquals(expected,actual);
    }
    @Test
    public void filterList2(){
        Article a1 = new Article("Fabian Schneider","The future of Irish football.");
        articles.add(a1);
        Article a2 = new Article("Wolfgang A. Mozart","How Dogecoin revived me from the dead!");
        articles.add(a2);
        ac.setArticles(articles);

        List<Article> actual= ac.filterList("me", articles);
        articles.remove(a1);
        List<Article> expected = articles;

        assertEquals(expected,actual);
    }

    @Test
    public void filterList3(){
        Article a1 = new Article("Fabian Schneider","The future of Irish football.");
        articles.add(a1);
        Article a2 = new Article("Wolfgang A. Mozart","How dogecoin revived me from the dead!");
        articles.add(a2);
        ac.setArticles(articles);

        List<Article> actual= ac.filterList("Doge", articles);
        articles.remove(a1);
        List<Article> expected = articles;

        assertEquals(expected,actual);
    }
}
