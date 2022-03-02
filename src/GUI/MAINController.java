/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.converter.IntegerStringConverter;
import pidev.entities.TestEntity;
import pidev.services.TestService;

/**
 * FXML Controller class
 *
 * @author Khammessi
 */
public class MAINController implements Initializable {

    @FXML
    private Pane paneList;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnEdit;
    @FXML
    private TableView<TestEntity> tableTest;

    @FXML
    private TableColumn<TestEntity, Integer> clNumber;

    @FXML
    private TableColumn<TestEntity, String> clTitle;

    @FXML
    private TableColumn<TestEntity, Integer> clDuree;

    @FXML
    private TableColumn<TestEntity, Integer> clMaxScore;

    @FXML
    private TableColumn<TestEntity, Integer> clTentative;

    @FXML
    private TableColumn<TestEntity, Date> clDateCreation;

    @FXML
    private TableColumn<?, ?> clButtons;
    
    TestService ts = new TestService();
    ObservableList<TestEntity> obsList = FXCollections.observableList(ts.getAllTest());
    TestEntity currentSelected; 

    /////////////////////////////////////////////PANE AJOUTER TEST///////////////////////////////////////////////////////
    
    @FXML
    private ScrollPane paneAjouterTest;

    @FXML
    private Label lblTitre;

    @FXML
    private Label lblScoreMax;

    @FXML
    private Label lblNbrTentative;

    @FXML
    private Label lblduree;

    @FXML
    private TextField txtTitre;

    @FXML
    private TextField txtScoreMax;

    @FXML
    private TextField txtNbrTentative;

    @FXML
    private TextField txtDuree;
    
    @FXML
    private Button btnNext;

    @FXML
    private Button btnPrecedent;
    ///////////////////////////////////////////////Pane ajouter Questions//////////////////////////////////////
    @FXML
    private ScrollPane paneAjouterQuestions;
    
    
    
    
    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tableTest.setPlaceholder(new Label("pas des certifications à afficher"));

        clTitle.setCellValueFactory(new PropertyValueFactory<TestEntity, String>("titre"));
        clDuree.setCellValueFactory(new PropertyValueFactory<TestEntity, Integer>("duree"));
        clMaxScore.setCellValueFactory(new PropertyValueFactory<TestEntity, Integer>("maxScore"));
        clTentative.setCellValueFactory(new PropertyValueFactory<TestEntity, Integer>("nbrTentative"));
        clDateCreation.setCellValueFactory(new PropertyValueFactory<TestEntity, Date>("dateCreation"));
        tableTest.setItems(obsList);
        
        TableViewSelectionModel selectionModel = tableTest.getSelectionModel();

        ObservableList<TestEntity> selectedItems = selectionModel.getSelectedItems();
        
        selectedItems.addListener(new ListChangeListener<TestEntity>() {
          @Override
          public void onChanged(Change<? extends TestEntity> change) {
            currentSelected = change.getList().get(0);
            if(currentSelected != null){
                btnDelete.setDisable(false);
                btnEdit.setDisable(false);
            }
                
            System.out.println("Selection changed: " + currentSelected);
          }
        });
        /////////////////////////////////////////////////listener for numeric textfield////////////////////////////////////////////////
        
        UnaryOperator<Change> integerFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("-?([1-9][0-9]*)?")) { 
                return change;
            }
            return null;
        };

    txtScoreMax.setTextFormatter(
        new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
    txtNbrTentative.setTextFormatter(
        new TextFormatter<>(new IntegerStringConverter(), 0, integerFilter));
    txtDuree.setTextFormatter(
        new TextFormatter<>(new IntegerStringConverter(), 0, integerFilter));
        
        
    }    
    public void deleteQuizz(ActionEvent event){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("cette action est definitive");
        alert.setContentText("Voulez-vous vraiment supprimer le test " + currentSelected.getTitre() + "");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            //ts.supprimerTest(currentSelected.getIdTest());
            obsList.remove(currentSelected);
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }
    
    @FXML
    public void editQuizz(ActionEvent event) {

    }
    @FXML
    public void addQuizz(ActionEvent event){
        paneList.setVisible(false);
        paneAjouterTest.setVisible(true);
    }
    
    /////////////////////////////////////////////PANE AJOUTER TEST///////////////////////////////////////////////////////
    


    @FXML
    void goToCreateQuestions(ActionEvent event) {
        List<TextField> tfl = Arrays.asList(txtTitre,txtDuree,txtScoreMax,txtNbrTentative) ;
        int j = 0;
        boolean verified = true;
        while(j<4 && verified)
        {
            String ch = tfl.get(j).getText();
            if(ch.equals("") || ch.equals("0")){
                verified = false;
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Attention");
                alert.setHeaderText("Vérifier les données saisies svp");
                alert.setContentText("Attention tout les champs de saisie sont obligatoires");

                Optional<ButtonType> result = alert.showAndWait();
            }
            j++;
        }
        if(verified){
            paneAjouterTest.setVisible(false);
            paneAjouterQuestions.setVisible(true);
            TestEntity t2 = new TestEntity();
            //t2.setUserId(CURRENT_USER);///////to add later
            t2.setDuree(Integer.parseInt(txtDuree.getText()));
            t2.setNbrTentative(Integer.parseInt(txtNbrTentative.getText()));
            t2.setMaxScore(Integer.parseInt(txtScoreMax.getText()));
            t2.setTitre(txtTitre.getText());
            ts.ajouterTest(t2);
        }
               
        
        
    }
    @FXML
    void backToListTest(ActionEvent event) {
        paneAjouterTest.setVisible(false);
        paneList.setVisible(true);
    }
    @FXML
    void cleanTxtField(MouseEvent event) {
        TextField e = (TextField)event.getSource();
        if(e.getText().equals("0"))
            e.setText("");
        

    }
}
