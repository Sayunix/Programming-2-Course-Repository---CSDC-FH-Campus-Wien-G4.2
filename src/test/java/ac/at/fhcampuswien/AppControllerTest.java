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
    // checks if setter works
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
    //checks if the method getArticleCount returns the right value of number of articles in list
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
    //checks if the method getArticleCount returns zero if the list is empty
    public void getArticleCount_empty(){
        ac.setArticles(articles);

        int actual = ac.getArticleCount();
        int expected = 0;

        assertEquals(expected,actual);
    }
    @Test
    // checks if the getTopHeadlinesAustria method returns the right list of articles
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
    // tests if the getAllNewsBitcoin method returns a list that only contains articles with the word "bitcoin" in it
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
    //tests if it returns an empty list if the list does not contain articles with "bitcoin" in it
    public void noBitcoinNews(){
        a1.setAuthor("Mr Test");
        a1.setTitle("The future of testing.");
        articles.add(a1);
        a2.setAuthor("Wolfgang A. Mozart");
        a2.setTitle("How Dogecoin revived me from the dead!");
        articles.add(a2);


        ac.setArticles(articles);
        List<Article> actual = ac.getAllNewsBitcoin();
        List<Article> expected = new ArrayList<>();

        assertEquals(expected,actual);
    }
    @Test
    //checks if the filterList methods returns a list with only articles that contain the word that is past as query
    public void filterList1(){
        a1.setAuthor("Mr Test");
        a1.setTitle("The future of testing.");
        articles.add(a1);
        a2.setAuthor("Wolfgang A. Mozart");
        a2.setTitle("How Dogecoin revived me from the dead!");
        articles.add(a2);

        ac.setArticles(articles);
        List<Article> actual= ac.filterList("me", articles);
        articles.remove(a1);
        List<Article> expected = articles;

        assertEquals(expected,actual);
    }
    @Test
    // checks if the method also uses the author for filtering
    public void filterList2(){
        a1.setAuthor("Mr Test");
        a1.setTitle("The future of testing.");
        articles.add(a1);
        a2.setAuthor("Wolfgang A. Mozart");
        a2.setTitle("How Dogecoin revived me from the dead!");
        articles.add(a2);

        ac.setArticles(articles);
        articles.remove(a2);
        List<Article> actual= ac.filterList("Mr", articles);
        List<Article> expected = articles;

        assertEquals(expected,actual);
    }
    @Test
    // tests if the method does not differentiate between words starting with upper and lower case
    public void filterList3(){
        a1.setAuthor("Mr Test");
        a1.setTitle("The future of testing.");
        articles.add(a1);
        a2.setAuthor("Wolfgang A. Mozart");
        a2.setTitle("How dogecoin revived me from the dead!");
        articles.add(a2);

        ac.setArticles(articles);
        List<Article> actual= ac.filterList("Doge", articles);
        articles.remove(a1);
        List<Article> expected = articles;

        assertEquals(expected,actual);
    }
    @Test
    // tests if the method does not differentiate between words starting with upper and lower case
    public void filterList4(){
        a1.setAuthor("Mr Test");
        a1.setTitle("The future of testing.");
        articles.add(a1);
        a2.setAuthor("Wolfgang A. Mozart");
        a2.setTitle("How dogecoin revived me from the dead!");
        articles.add(a2);

        ac.setArticles(articles);
        List<Article> actual= ac.filterList("doge", articles);
        articles.remove(a1);
        List<Article> expected = articles;

        assertEquals(expected,actual);
    }
}
