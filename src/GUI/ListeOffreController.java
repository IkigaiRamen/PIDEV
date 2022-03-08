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
import java.util.Optional;

import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
import javax.swing.JOptionPane;
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
    private Button ajj;
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
    private Button sup;
    @FXML
    private Button aff;
    @FXML
    private TextField txtSearch;
    
    
     OffreServices os= new OffreServices(); 
       ObservableList<Offre> list = FXCollections.observableArrayList(os.afficherOffre());
      List<Offre> allList = os.afficherOffre();
        
     public static Offre o ;
    
       
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       table.setCellFactory(lv -> new OffreListeCell());
       table.setItems(list);
   
                
          
            
             
           ajj.setOnAction(e->{  
            Parent root ;
         try {
             root=FXMLLoader.load(getClass().getResource("AjouterOffre.fxml"));
             ajj.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(AjouterOffreController.class.getName()).log(Level.SEVERE, null, ex);
         }
            
             });
            
          /*  mod.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent e) {
               o = table.getSelectionModel().getSelectedItem();
               if (!(o == null)) {
                   try {
                       Parent root;
                       root = FXMLLoader.load(ListeOffreController.this.getClass().getResource("/GUI/Modifieroffre.fxml"));
                       mod.getScene().setRoot(root);
                   }catch (IOException ex) {
                       System.out.print(ex);
                   }
               }
           }
       });*/

    
    }
    public void modif (ActionEvent event) throws IOException{
        o = table.getSelectionModel().getSelectedItem();
               if (!(o == null)) {
                   try {
                       Parent root;
                       root = FXMLLoader.load(ListeOffreController.this.getClass().getResource("/GUI/Modifieroffre.fxml"));
                       mod.getScene().setRoot(root);
                   }catch (IOException ex) {
                       System.out.print(ex);
                   }
               }
    }
    
   
    public void deleteOffre(ActionEvent event) throws IOException { 
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        
        alert.setContentText("Voulez-vous vraiment supprimer l'offre " );

        Optional<ButtonType> result = alert.showAndWait();
        
        if (result.get() == ButtonType.OK){
            o = table.getSelectionModel().getSelectedItem();
            os.SupprimerOffre(o.getId());
            list.remove(o);
            Parent root;
                    root = FXMLLoader.load(getClass().getResource("/GUI/ListeOffre.fxml"));
                    sup.getScene().setRoot(root);
            
        } else {
            // ... user chose CANCEL or closed the dialog
        }
       
        }
    
    public void AffichageO (ActionEvent event){
        o = table.getSelectionModel().getSelectedItem();
               if (!(o == null)) {
        Parent root ;
         try {
             root=FXMLLoader.load(getClass().getResource("AffichageOffre.fxml"));
             aff.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(AjouterOffreController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    }
      

    
     public Offre getO(){
     return o;
     }
   
    @FXML
     private void searchO(KeyEvent event) {
      
        String searchPhrase = txtSearch.getText();
        //searchPhrase = searchPhrase + event.getCharacter();
        System.out.println("search phrase : :::::::::::::" + searchPhrase);
        System.out.println(txtSearch.getText().isEmpty());
        if(txtSearch.getText().isEmpty()){
            list.clear();
            list = FXCollections.observableList(allList);
            //System.out.println("////////////////search is empty");
            //System.out.println(obsList.toString());
            table.setItems(list);
            return;
        }else{
            
        List<String> searchWordsArray = Arrays.asList(searchPhrase.trim().split(" "));
        //System.out.println("1111111111" + searchWordsArray.toString());
        
        Predicate<Offre> predicate = (e) -> {
            return searchWordsArray.stream().allMatch(word ->
                    e.getTitre().toLowerCase().contains(word.toLowerCase()));
        
        };
        //System.out.println("bbbbbbbbbb" + allList.toString());
        List<Offre> listee = allList.stream().filter(predicate).collect(Collectors.toList());
        //System.out.println("list is 222222222 " + list.toString());
        list.clear();
        list = FXCollections.observableList(listee);
        }
        //System.out.println("obsList is : 33333" + obsList.toString());
        table.setItems(list);
    }
     
     
    }    


     
    


  
    
   
    

