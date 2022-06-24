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
    private Source source;

    //creates an Article with the a Builder
    public Article(Builder builder) {
        this.author = builder.author;
        this.title = builder.title;
        this.description = builder.description;
        this.url = builder.url;
        this.urlToImage = builder.urlToImage;
        this.publishedAt = builder.publishedAt;
        this.content = builder.content;
        this.source = builder.source;
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

    public Source getSource() {
        return source;
    }

    public void setDescription(String description) {this.description = description;}

    //Builder class
    public static class Builder{
        //must variables
        private final Source source;
        private final String title;

        //optional variables
        private String author;
        private String description;
        private String url;
        private String urlToImage;
        private String publishedAt;
        private String content;

        //Constructor for the must variables
        public Builder(Source source, String title){
            this.source = source;
            this.title = title;
        }

        //Constructor for the optional variables
        public Builder author(String author){
            this.author = author;
            return this;
        }
        public Builder description(String description){
            this.description = description;
            return this;
        }
        public Builder url(String url){
            this.url = url;
            return this;
        }
        public Builder urlToImage(String urlToImage){
            this.urlToImage = urlToImage;
            return this;
        }
        public Builder publishedAt(String publishedAt){
            this.publishedAt = publishedAt;
            return this;
        }
        public Builder content(String content){
            this.content = content;
            return this;
        }

        //builds the Article
        public Article build(){
            return new Article(this);
        }


    }
}