package ac.at.fhcampuswien.classes;

public class Article {
//creates a template for an article

    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;


    //creates an author and a title for the article class
    public Article(String author, String title, String description, String url, String urlToImage, String publishedAt, String content) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
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

    //sets a new description variable
    public void setDescription(String description) {
        this.description = description;
    }

    //sets a new Url variable
    public void setUrl(String url) {
        this.url = url;
    }

    //sets urlToImage variable
    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    //sets a publishedAt variable
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    //sets a content variable
    public void setContent(String content) {
        this.content = content;
    }

    //returns a new author variable
    public String getAuthor() {
        return author;
    }

    //returns a title variable
    public String getTitle() {
        return title;
    }

    //returns a description variable
    public String getDescription() {
        return description;
    }

    //returns a Url
    public String getUrl() {
        return url;
    }

    //returns a getUrlToImage variable
    public String getUrlToImage() {
        return urlToImage;
    }

    //returns a publishedAt Variable
    public String getPublishedAt() {
        return publishedAt;
    }

    //returns a content variable
    public String getContent() {
        return content;
    }

}