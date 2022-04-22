package ac.at.fhcampuswien.classes;

import ac.at.fhcampuswien.enums.category;
import ac.at.fhcampuswien.enums.country;
import ac.at.fhcampuswien.enums.language;
import ac.at.fhcampuswien.enums.sortBy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    String q;
    AppController controller = new AppController();

    @FXML
    Button btn_Headlines, btn_Exit, btn_ArticleCount, btn_searchheadlines, btn_searchbitcoin, btn_Bitcoin;

    @FXML
    Label lbl_Information;


    @FXML
    TextField txf_search;

    @FXML
    ComboBox cbx_country,cbx_category,cbx_language, cbx_sortby;

    @FXML
    TableView<Article> tbv_News;

    @FXML
    TableColumn<Article,String> tbc_author,tbc_title, tbc_description,tbc_url, tbc_urlimage, tbc_published, tbc_content;

    @FXML
    Pane pn_headlines, pn_bitcoin;

    public void click_search() throws IOException{
        tbv_News.getItems().clear();


        if (pn_headlines.isVisible()) {
            q = txf_search.getText();

            if (cbx_country.getSelectionModel().isEmpty()) {
                cbx_country.setValue(country.all);
            }

            if (cbx_category.getSelectionModel().isEmpty()) {
                cbx_category.setValue(category.general);
            }

            country selectedcountry = (country) cbx_country.getSelectionModel().getSelectedItem();

            category selectedcategory = (category) cbx_category.getSelectionModel().getSelectedItem();

            ObservableList<Article> ob = FXCollections.observableArrayList(controller.getTopHeadlines(q, selectedcountry.name(), selectedcategory.name()));
            tbv_News.setItems(ob);
        }else{
            if (cbx_language.getSelectionModel().isEmpty()) {
                cbx_language.setValue(language.all);
            }

            if (cbx_sortby.getSelectionModel().isEmpty()) {
                cbx_sortby.setValue(sortBy.publishedAt);
            }

            language selectedlanguage = (language) cbx_language.getSelectionModel().getSelectedItem();

            sortBy selectedsortby = (sortBy) cbx_sortby.getSelectionModel().getSelectedItem();

            ObservableList<Article> ob = FXCollections.observableArrayList(controller.getAllNewsBitcoin(selectedlanguage.name(), selectedsortby.name()));
            tbv_News.setItems(ob);
        }

        pn_bitcoin.setVisible(false);
        pn_headlines.setVisible(false);


        btn_Headlines.setDisable(false);
        btn_Bitcoin.setDisable(false);
        btn_ArticleCount.setDisable(false);

        cbx_language.setDisable(true);
        cbx_sortby.setDisable(true);
        cbx_country.setDisable(true);
        cbx_category.setDisable(true);
        txf_search.setDisable(true);
        btn_searchheadlines.setDisable(true);
        btn_searchbitcoin.setDisable(true);
    }

    //shows top headline articles in the textbox
    public void click_Headline() throws IOException {
        lbl_Information.setText("");

        pn_bitcoin.setVisible(false);

        pn_headlines.setVisible(true);

        btn_Headlines.setDisable(true);
        btn_Bitcoin.setDisable(true);
        btn_ArticleCount.setDisable(true);
        cbx_sortby.setDisable(true);
        cbx_language.setDisable(true);
        btn_searchbitcoin.setDisable(true);

        cbx_country.setDisable(false);
        cbx_category.setDisable(false);
        txf_search.setDisable(false);
        btn_searchheadlines.setDisable(false);
    }

    //shows bitcoin articles in the textbox
    public void click_Bitcoin() throws IOException {
        lbl_Information.setText("");


        pn_headlines.setVisible(false);

        pn_bitcoin.setVisible(true);


        btn_Headlines.setDisable(true);
        btn_Bitcoin.setDisable(true);
        btn_ArticleCount.setDisable(true);
        txf_search.setDisable(true);
        cbx_country.setDisable(true);
        cbx_category.setDisable(true);
        btn_searchheadlines.setDisable(true);

        cbx_language.setDisable(false);
        cbx_sortby.setDisable(false);
        btn_searchbitcoin.setDisable(false);
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
        cbx_category.setItems(FXCollections.observableArrayList(category.values()));
        cbx_language.setItems(FXCollections.observableArrayList(language.values()));
        cbx_sortby.setItems(FXCollections.observableArrayList(sortBy.values()));


        tbc_author.setCellValueFactory(new PropertyValueFactory<>("author"));
        tbc_title.setCellValueFactory(new PropertyValueFactory<>("title"));
        tbc_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        tbc_url.setCellValueFactory(new PropertyValueFactory<>("url"));
        tbc_urlimage.setCellValueFactory(new PropertyValueFactory<>("urlToImage"));
        tbc_published.setCellValueFactory(new PropertyValueFactory<>("publishedAt"));
        tbc_content.setCellValueFactory(new PropertyValueFactory<>("content"));
    }
}
