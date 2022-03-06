/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import pidev.entities.Offre;
import pidev.entities.TestEntity;
import pidev.services.OffreServices;

/**
 * FXML Controller class
 *
 * @author khale
 */
public class ListeOffreController implements Initializable {

    @FXML
    private ListView<Offre> table;
    
    @FXML
    private Button btn_Acceuil;
    @FXML
    private Button btn_Messagerie;
    @FXML
    private Button btn_Profile;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btn_listOffre;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnSignout;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlOverview;
    @FXML
    private Button mod;
    @FXML
    private TextField txtSearch;
    
     OffreServices os= new OffreServices(); 
       ObservableList<Offre> list = FXCollections.observableArrayList(os.afficherOffre());
     public static Offre o ;
       
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       table.setCellFactory(lv -> new OffreListeCell());
       table.setItems(list);
   

            
                 
            btnAjouter.setOnAction(e->{  
            Parent root ;
         try {
             root=FXMLLoader.load(getClass().getResource("AjouterOffre.fxml"));
             btnAjouter.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(AjouterOffreController.class.getName()).log(Level.SEVERE, null, ex);
         }
            
             });
            
            mod.setOnAction(e->{
                
            
            o = table.getSelectionModel().getSelectedItem();
            if (!(o == null)) {
                try {
                    Parent root;
                    root = FXMLLoader.load(getClass().getResource("/GUI/Modifieroffre.fxml"));
                    mod.getScene().setRoot(root);
                } catch (IOException ex) {
                   System.out.print(ex);
                }
            }
            });
        }
      

    
    
    
    
     public Offre getO(){
     return o;
     }
    
     /*private void searchQuery(KeyEvent event) {
        table = ts.getByTypeTest("Certification");
        String searchPhrase = txtSearch.getText();
        //searchPhrase = searchPhrase + event.getCharacter();
        System.out.println("search phrase : :::::::::::::" + searchPhrase);
        System.out.println(txtSearch.getText().isEmpty());
        if(txtSearch.getText().isEmpty()){
            obsList.clear();
            obsList = FXCollections.observableList(allList);
            //System.out.println("////////////////search is empty");
            //System.out.println(obsList.toString());
            table.setItems(obsList);
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
        tableCertif.setItems(obsList);
    }*/
     
     
    }    


     
    
   

  
    
   
    
