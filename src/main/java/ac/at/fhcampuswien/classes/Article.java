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



    //empty constructor
    public Article(){
    }

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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public void setContent(String content) {
        this.content = content;
    }
    //returns a new author variable
    public String getAuthor() {
        return author;
    }

    //returns a new title variable
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getContent() {
        return content;
    }

    //overrrides the toString method

    @Override
    public String toString() {
        return  author +"#"+
                title + "#" +
                description + "#" +
                url + "#" +
                urlToImage +"#" +
                publishedAt +"#" +
                content+"#";
    }
}