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
import java.util.function.Predicate;
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
public class CertificationListController implements Initializable {

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
    
    List<TestEntity> allList = ts.getCertifDispo(21);  //INCOMPLETE
    ObservableList<TestEntity> obsList = FXCollections.observableList(allList);
    
    
    public void setData(){
    
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        listview.setCellFactory(lv-> new CellListCertification());
            
        listview.setItems(obsList);
                 
        SelectionModel selectionModel = listview.getSelectionModel();
            
        listview.setPlaceholder(new Label("pas des certifications à afficher"));
        
        
        
    }    

    

    @FXML
    private void searchQuery(KeyEvent event) {
        allList = ts.getCertifDispo(21);  //INCOMPLETE
        String searchPhrase = txtSearch.getText();
        //searchPhrase = searchPhrase + event.getCharacter();
        System.out.println("search phrase : :::::::::::::" + searchPhrase);
        //System.out.println(txtSearch.getText().isEmpty());
        if(txtSearch.getText().isEmpty()){
            obsList.clear();
            obsList = FXCollections.observableList(allList);
            //System.out.println("////////////////search is empty");
            //System.out.println(obsList.toString());
            listview.setItems(obsList);
            return;
        }else{
            
        List<String> searchWordsArray = Arrays.asList(searchPhrase.trim().split(" "));
        //System.out.println("1111111111" + searchWordsArray.toString());
        
        Predicate<TestEntity> predicate = (e) -> {
            return searchWordsArray.stream().allMatch(word ->
                    e.getTitre().toLowerCase().contains(word.toLowerCase()));
        
        };
        //System.out.println("bbbbbbbbbb" + allList.toString());
        List<TestEntity> list = allList.stream().filter(predicate).collect(Collectors.toList());
        //System.out.println("list is 222222222 " + list.toString());
        obsList.clear();
        obsList = FXCollections.observableList(list);
        }
        //System.out.println("obsList is : 33333" + obsList.toString());
        listview.setItems(obsList);  //grid
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
        alert.setHeaderText("La certification est chronométré");
        alert.setContentText("faire attention au minutaire, le temps alloué pour cette certification: '" + 
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


/*tableCertif.setPlaceholder(new Label("pas des certifications à afficher"));

        clTitre.setCellValueFactory(new PropertyValueFactory<TestEntity, String>("titre"));
        clDuree.setCellValueFactory(new PropertyValueFactory<TestEntity, Integer>("duree"));
        clTentatives.setCellValueFactory(new PropertyValueFactory<TestEntity, Integer>("nbrTentative"));
        tableCertif.setItems(obsList);
        
        TableView.TableViewSelectionModel selectionModel = tableCertif.getSelectionModel();
        
        ObservableList<TestEntity> selectedItems = selectionModel.getSelectedItems();
        
        selectedItems.addListener(new ListChangeListener<TestEntity>() {
          @Override
          public void onChanged(ListChangeListener.Change<? extends TestEntity> change) {
            currentSelected = change.getList().get(0);
            if(currentSelected != null){
                btnPasser.setDisable(false);

            }
                
            System.out.println("Selection changed: " + currentSelected);
          }
        });*/

            /*Label label = new Label("Titre");
            grid.add(label, 0, 0);
            GridPane.setMargin(label, new Insets(10));
            
            label = new Label("Durée");
            grid.add(label, 1, 0);
            GridPane.setMargin(label, new Insets(10));
            
            label = new Label("Tentatives");
            grid.add(label, 2, 0);
            GridPane.setMargin(label, new Insets(10));
            
            
        
        
                    
        
        int col = 0;
        int row = 1;
        if(allList != null)
            for(int i=0; i<allList.size(); i++){
                
                    label = new Label(allList.get(i).getTitre());
                    grid.add(label, col++, row);
                    GridPane.setMargin(label, new Insets(10));
                    label = new Label(allList.get(i).getTitre());
                    grid.add(label, col++, row);
                    GridPane.setMargin(label, new Insets(10));
                    
                    label = new Label(allList.get(i).getTitre());
                    grid.add(label, col++, row++);
                    GridPane.setMargin(label, new Insets(10));
                    if(col == 3)
                        col =0;
                
            }
        */