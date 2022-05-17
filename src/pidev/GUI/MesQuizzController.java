/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
public class MesQuizzController implements Initializable {

    @FXML
    private Pane paneList;


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
    
    @FXML
    private Button btnDelete;

    
    
    TestEntity currentSelected;
    TestService ts = new TestService();
    
    List<TestEntity> allList = ts.getMesQuizz(37);
    
    ObservableList<TestEntity> obsList = FXCollections.observableList(allList);
    
    
    public void setData(){
    }
    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(allList.toString());
        listview.setCellFactory(lv-> new CellListMesQuizz());            
        listview.setItems(obsList);
                 
        SelectionModel selectionModel = listview.getSelectionModel();
            
        listview.setPlaceholder(new Label("pas des Quizz à afficher"));
        listview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TestEntity>() {
            @Override
            public void changed(ObservableValue<? extends TestEntity> observable, TestEntity oldValue, TestEntity newValue) {
                currentSelected = newValue;
                if(currentSelected != null){
                    btnDelete.setDisable(false);
                }
                System.out.println("hooooooooooooooooooo" + currentSelected.toString());
            }
        });
        
        
    }    

    

    
    
    @FXML
    void goBack(ActionEvent event) {  /////incomplete change previous page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterCertification.fxml"));
            Parent root;
        try {
            root = loader.load();
            //AjouterCertificationController ajouterController = loader.getController();
            listview.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(GestionCertificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteQuizz(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("cette action est definitive");
        alert.setContentText("Voulez-vous vraiment supprimer le test " + currentSelected.getTitre() + "");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            ts.supprimerTest(currentSelected.getIdTest());
            obsList.remove(currentSelected);
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }
    
        
    
}
