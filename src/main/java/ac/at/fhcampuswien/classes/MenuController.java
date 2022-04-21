package ac.at.fhcampuswien.classes;

import ac.at.fhcampuswien.enums.country;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    String q;
    AppController controller = new AppController();

    @FXML
    Button btn_Headlines, btn_Exit, btn_ArticleCount, btn_search, btn_Bitcoin;

    @FXML
    Label lbl_Information;


    @FXML
    TextField txf_search;

    @FXML
    ComboBox cbx_country;

    @FXML
    TableView<Article> tbv_News;

    @FXML
    TableColumn<Article,String> tbc_author,tbc_title, tbc_description,tbc_url, tbc_urlimage, tbc_published, tbc_content;

    public void click_search() throws IOException{
        tbv_News.getItems().clear();
        if (txf_search.equals("")){
            q = txf_search.getPromptText();
        }else {
            q = txf_search.getText();
        }

        if(cbx_country.getSelectionModel().isEmpty()){
            cbx_country.setValue(country.at);
        }
        country selectedcountry = (country) cbx_country.getSelectionModel().getSelectedItem();


        ObservableList<Article> ob = FXCollections.observableArrayList(controller.getTopHeadlines(q,selectedcountry.name()));
        tbv_News.setItems(ob);

        lbl_Information.setText("");

        txf_search.setDisable(true);
        btn_search.setDisable(true);
        btn_Headlines.setDisable(false);
        btn_Bitcoin.setDisable(false);
        btn_ArticleCount.setDisable(false);
        cbx_country.setDisable(true);
    }

    //shows top headline articles in the textbox
    public void click_Headline() throws IOException {

        txf_search.setDisable(false);
        btn_search.setDisable(false);
        btn_Headlines.setDisable(true);
        btn_Bitcoin.setDisable(true);
        btn_ArticleCount.setDisable(true);
        cbx_country.setDisable(false);
    }

    //shows bitcoin articles in the textbox
    public void click_Bitcoin() throws IOException {
        tbv_News.getItems().clear();

        ObservableList<Article> ob = FXCollections.observableArrayList(controller.getAllNewsBitcoin());
        tbv_News.setItems(ob);

        lbl_Information.setText("");
    }

    //shows the amount of articles
    public void click_Amount(){
        lbl_Information.setText("Amount of Articles: " + controller.getArticleCount());
    }

    //Closes the Application
    public void click_Exit(){
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbx_country.setItems(FXCollections.observableArrayList(country.values()));

        tbc_author.setCellValueFactory(new PropertyValueFactory<>("author"));
        tbc_title.setCellValueFactory(new PropertyValueFactory<>("title"));
        tbc_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        tbc_url.setCellValueFactory(new PropertyValueFactory<>("url"));
        tbc_urlimage.setCellValueFactory(new PropertyValueFactory<>("urlToImage"));
        tbc_published.setCellValueFactory(new PropertyValueFactory<>("publishedAt"));
        tbc_content.setCellValueFactory(new PropertyValueFactory<>("content"));
    }
}
