package ac.at.fhcampuswien;

public class Article {
//creates a template for an article

    private String author;
    private String title;

    //empty constructor
    public Article(){

    }

    //creates an author and a title for the article class
    public Article(String author, String title) {
        this.author = author;
        this.title = title;
    }

    //setter- & getter methods
    //sets a new author variable
    public void setAuthor(String author) {
        this.author = author;
    }

    //sets a new title variable
    public void setTitle(String title) {
        this.title = title;
    }

    //returns a new author variable
    public String getAuthor() {
        return author;
    }

    //returns a new title variable
    public String getTitle() {
        return title;
    }

    //overrrides the toString method
    @Override
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author + " ";
    }
}