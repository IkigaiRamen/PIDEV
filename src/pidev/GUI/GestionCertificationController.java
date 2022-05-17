/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.layout.Pane;
import pidev.entities.TestEntity;
import pidev.services.QuestionService;
import pidev.services.TestService;

/**
 * FXML Controller class
 *
 * @author zewaf
 */
public class GestionCertificationController implements Initializable {

    
    @FXML
    private Pane paneList;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnBack;

    @FXML
    private ListView<TestEntity> listview;
    
    TestService ts = new TestService();
    ObservableList<TestEntity> obsList = FXCollections.observableList(ts.getAllTest());
    TestEntity currentSelected;
    
    QuestionService qs = new QuestionService();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        listview.setPlaceholder(new Label("pas des certifications à afficher"));
        listview.setCellFactory(lv -> new CellGestionCertification());
        listview.setItems(obsList);
        
        listview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TestEntity>() {
            @Override
            public void changed(ObservableValue<? extends TestEntity> observable, TestEntity oldValue, TestEntity newValue) {
                currentSelected = newValue;
                if(currentSelected != null){
                    btnDelete.setDisable(false);
                    btnEdit.setDisable(false);
                }
                System.out.println("hooooooooooooooooooo" + currentSelected.toString());
            }
        });
        
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
    
    @FXML
    public void editQuizz(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierCertification.fxml"));
            Parent root;
        try {
            root = loader.load();
            ModifierCertificationController modifierController = loader.getController();
            modifierController.setData(currentSelected);
            btnAdd.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(GestionCertificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void addQuizz(ActionEvent event){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterCertification.fxml"));
            Parent root;
        try {
            root = loader.load();
            //AjouterCertificationController ajouterController = loader.getController();
            btnAdd.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(GestionCertificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    @FXML
    void goBack(ActionEvent event) {
          
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CertificationList.fxml"));
            Parent root;
        try {
            root = loader.load();
            //AjouterCertificationController ajouterController = loader.getController();
            btnAdd.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(GestionCertificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
