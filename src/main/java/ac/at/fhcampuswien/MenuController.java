package ac.at.fhcampuswien;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class MenuController {
    AppController controller = new AppController();

    @FXML
    Button btn_Bitcoin, btn_Headlines, btn_Exit, btn_ArticleCount;

    @FXML
    Label lbl_Information;

    @FXML
    TextArea tbx_News;

    //shows top headline articles in the textbox
    public void click_Headline(){
        lbl_Information.setText("");
        tbx_News.setText(controller.getTopHeadlinesAustria().toString());
    }

    //shows bitcoin articles in the textbox
    public void click_Bitcoin(){
        lbl_Information.setText("");
        tbx_News.setText(controller.getAllNewsBitcoin().toString());
    }

    //shows the amount of articles
    public void click_Amount(){
        tbx_News.setText("");
        lbl_Information.setText("Amount of Articles: " + controller.getArticleCount());

    }

    //Closes the Application
    public void click_Exit(){
        System.exit(0);
    }
}
