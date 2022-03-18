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

    public void click_Headline(){
        lbl_Information.setText("");
        tbx_News.setText(controller.getTopHeadlinesAustria().toString());
    }

    public void click_Bitcoin(){
        lbl_Information.setText("");
        tbx_News.setText(controller.getAllNewsBitcoin().toString());
    }

    public void click_Amount(){
        tbx_News.setText("");
        lbl_Information.setText("Amount of Articles: " + controller.getArticleCount());

    }

    public void click_Exit(){
        System.exit(0);
    }
}
