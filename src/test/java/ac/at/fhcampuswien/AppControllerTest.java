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
    private Article a1;
    private Article a2;

    @BeforeEach
     void setup(){
        articles = new ArrayList<>();
        a1 = new Article();
        a2 = new Article();
    }

    @Test
    //@DisplayName("tests set article method")
    public void setArticles(){
        a1.setAuthor("Mr Test");
        a1.setTitle("The future of testing.");
        articles.add(a1);
        a2.setAuthor("Wolfgang A. Mozart");
        a2.setTitle("How bitcoin revived me from the dead!");
        articles.add(a2);

        ac.setArticles(articles);
        List<Article> actual = ac.getTopHeadlinesAustria();

        assertEquals(articles,actual);
    }
    @Test
    public void getArticleCount(){
        a1.setAuthor("Mr Test");
        a1.setTitle("The future of testing.");
        articles.add(a1);
        a2.setAuthor("Wolfgang A. Mozart");
        a2.setTitle("How bitcoin revived me from the dead!");
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
        a1.setAuthor("Mr Test");
        a1.setTitle("The future of testing.");
        articles.add(a1);
        a2.setAuthor("Wolfgang A. Mozart");
        a2.setTitle("How bitcoin revived me from the dead!");
        articles.add(a2);

        ac.setArticles(articles);
        List<Article> expected = articles;

        assertEquals(expected, ac.getTopHeadlinesAustria());
    }
    @Test
    public void getAllNewsBitcoin(){
        a1.setAuthor("Mr Test");
        a1.setTitle("The future of testing.");
        articles.add(a1);
        a2.setAuthor("Wolfgang A. Mozart");
        a2.setTitle("How bitcoin revived me from the dead!");
        articles.add(a2);

        ac.setArticles(articles);
        articles.remove(0);

        List<Article> expected = articles;

        assertEquals(expected,ac.getAllNewsBitcoin());
    }
    @Test
    public void noBitcoinNews(){
        a1.setAuthor("Mr Test");
        a1.setTitle("The future of testing.");
        articles.add(a1);
        a2.setAuthor("Wolfgang A. Mozart");
        a2.setTitle("How Dogecoin revived me from the dead!");

        ac.setArticles(articles);
        List<Article> actual = ac.getAllNewsBitcoin();
        List<Article> expected = new ArrayList<>();

        assertEquals(expected,actual);
    }
    @Test
    public void filterList1(){
        a1.setAuthor("Mr Test");
        a1.setTitle("The future of testing.");
        articles.add(a1);
        a2.setAuthor("Wolfgang A. Mozart");
        a2.setTitle("How Dogecoin revived me from the dead!");

        ac.setArticles(articles);
        List<Article> actual= ac.filterList("the", articles);
        List<Article> expected = articles;

        assertEquals(expected,actual);
    }
    @Test
    public void filterList2(){
        a1.setAuthor("Mr Test");
        a1.setTitle("The future of testing.");
        articles.add(a1);
        a2.setAuthor("Wolfgang A. Mozart");
        a2.setTitle("How Dogecoin revived me from the dead!");

        ac.setArticles(articles);
        List<Article> actual= ac.filterList("me", articles);
        articles.remove(a1);
        List<Article> expected = articles;

        assertEquals(expected,actual);
    }

    @Test
    public void filterList3(){
        a1.setAuthor("Mr Test");
        a1.setTitle("The future of testing.");
        articles.add(a1);
        a2.setAuthor("Wolfgang A. Mozart");
        a2.setTitle("How dogecoin revived me from the dead!");

        ac.setArticles(articles);
        List<Article> actual= ac.filterList("Doge", articles);
        articles.remove(a1);
        List<Article> expected = articles;

        assertEquals(expected,actual);
    }
}
