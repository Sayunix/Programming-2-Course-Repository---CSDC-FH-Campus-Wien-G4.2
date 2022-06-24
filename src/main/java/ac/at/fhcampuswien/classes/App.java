package ac.at.fhcampuswien.classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application{

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("NewsApp");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

        //For testing Builder
        /*Article article = new Article.Builder(new Source("probe","ich"), "title")
                .author("Safa")
                .description("description")
                .url("www")
                .publishedAt("heute")
                .content("was cooles")
                .build();

        System.out.println(article.toString());*/

    }
}
