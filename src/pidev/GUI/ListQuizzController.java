/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import pidev.entities.TestEntity;
import pidev.services.TestService;

/**
 * FXML Controller class
 *
 * @author zewaf
 */
public class ListQuizzController implements Initializable {

    @FXML
    private Pane paneList;
    @FXML
    private Button btnPasser;
    @FXML
    private TextField txtSearch;

    @FXML
    private TableView<TestEntity> tableCertif;
    
    @FXML
    private GridPane grid;

    @FXML
    private TableColumn<TestEntity, String> clTitre;

    @FXML
    private TableColumn<TestEntity, Integer> clDuree;

    @FXML
    private TableColumn<TestEntity, Integer> clTentatives;
    
    @FXML
    private Button btnBack;
    
    @FXML
    private ListView<TestEntity> listview;
    
    @FXML
    private AnchorPane navbar;

    
    
    TestEntity currentSelected;
    TestService ts = new TestService();
    
    List<TestEntity> allList = ts.getQuizzDispo(21);
    
    //List<TestEntity> allList = ts.getByTypeTest("Quizz");
    ObservableList<TestEntity> obsList = FXCollections.observableList(allList);
    
    
    public void setData(){
    }
    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(allList.toString());
        listview.setCellFactory(lv-> new CellListCertification());
            
        listview.setItems(obsList);
                 
        SelectionModel selectionModel = listview.getSelectionModel();
            
        listview.setPlaceholder(new Label("pas des Quizz à afficher"));
        
        
        
    }    

    

    
    
    @FXML
    void goBack(ActionEvent event) {  /////incomplete change previous page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterCertification.fxml"));
            Parent root;
        try {
            root = loader.load();
            //AjouterCertificationController ajouterController = loader.getController();
            btnPasser.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(GestionCertificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void passerCertif(ActionEvent event) {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Le Quiz est chronométré");
        alert.setContentText("faire attention au minutaire, le temps alloué pour cette Quiz: '" + 
                currentSelected.getTitre() + "' est : " + currentSelected.getDuree() + " minutes.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PasserCertification.fxml"));
            Parent root;
            try {
                root = loader.load();
                PasserCertificationController passerCertifController = loader.getController();
                passerCertifController.setData(currentSelected);
                passerCertifController.setM(currentSelected.getDuree());
                passerCertifController.setQuestions(currentSelected.getIdTest());
                
                btnBack.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(GestionCertificationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // ... user chose CANCEL or closed the dialog
        }
        
        
    }
    
}
    

