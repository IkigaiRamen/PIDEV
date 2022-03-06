/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controllers;
import GUI.DemandeListCell;
import pidev.services.DemandeServices;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.JOptionPane;
import pidev.entities.DemandeTravail;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Khammessi
 */
public class MesDemandesController implements Initializable {
    
    @FXML
    public Button btnOverview;
    @FXML
    private Button btnOrders;
    @FXML
    private Button btnCustomers;
    @FXML
    private Button btnMenus;
    @FXML
    private Button btnPackages;
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
    
    int index =-1;
    DemandeServices ds = new DemandeServices();
    public static DemandeTravail d ;
    ObservableList<DemandeTravail> list = FXCollections.observableArrayList(ds.afficherDemande());
    @FXML
    private ListView<DemandeTravail> listview;
    @FXML
    private Button btnmodifier;
 
    
 /* public void refresh(boolean x){
        if(x==true){
             DemandeServices ds = new DemandeServices();
                   
            idtitre.setCellValueFactory(new PropertyValueFactory<>("title"));
            idtype.setCellValueFactory(new PropertyValueFactory<>("type"));
            idcat.setCellValueFactory(new PropertyValueFactory<>("Category"));
            iddate.setCellValueFactory(new PropertyValueFactory<>("date"));
            idetat.setCellValueFactory(new PropertyValueFactory<>("etat"));
            table2.setItems(list);  
        }
            
        else
        {}

        }*/

   /*private void addButtonToTable() {
        TableColumn<DemandeTravail, Void> colBtn;
        colBtn = new TableColumn("Supprimer");

        Callback<TableColumn<DemandeTravail, Void>, TableCell<DemandeTravail, Void>> cellFactory = (final TableColumn<DemandeTravail, Void> param) -> {
            final TableCell<DemandeTravail, Void> cell = new TableCell<DemandeTravail, Void>() {
                
                private final Button btn = new Button("Supprimer");
                {
                    btn.setOnAction((ActionEvent event) -> {
                        delete();
                        refresh(true);
                    });
                }
                @Override
                public void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(btn);
                    }
                }
            };
            return cell;
        };

        colBtn.setCellFactory(cellFactory);

        table2.getColumns().add(colBtn);
                        refresh(true);

    }*/
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            // refresh(true);
            
             listview.setCellFactory(lv-> new DemandeListCell());
            
            listview.setItems(list);
          // refresh(true);
                  btnmodifier.setOnAction(e -> {
            //(String id,String nom, String adresse, String prix, String surface,String capacite)

            d = listview.getSelectionModel().getSelectedItem();
            System.out.println(d.getId());
                        System.out.println("test");

            if (!(d == null)) {
                try {
                    Parent root;
                    root = FXMLLoader.load(getClass().getResource("/GUI/modifierDemande.fxml"));
                    btnmodifier.getScene().setRoot(root);
                } catch (IOException ex) {
                   System.out.print(ex);
                }
            }
        }); 
      

    } 
    
    
    
     public DemandeTravail getD(){
     return d;
     }
     
      /*   public void delete(){

          int id= table2.getSelectionModel().getSelectedItem().getId();
          System.out.println(id);
    int responce=JOptionPane.showConfirmDialog(null, "voulez-vous supprimer ?","vérification",JOptionPane.YES_NO_OPTION);
                if (responce==JOptionPane.YES_OPTION){
                    ds.supprimerDemande(id);
                      table2.getItems().clear();
                } else{
                    System.out.println("modification annuler");
                }
                  TrayNotification tray = null;
                                       refresh(true);

            tray = new TrayNotification("Demande supprimer", "Votre demande a ete supprimer avec succes ,Merci ", NotificationType.SUCCESS);
            tray.showAndDismiss(javafx.util.Duration.seconds(5));
                                    refresh(true);

         }


*/
   

    
    

     

    @FXML
      public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnCustomers) {
            pnlCustomer.setStyle("-fx-background-color : #1620A1");
            pnlCustomer.toFront();
        }
        if (actionEvent.getSource() == btnMenus) {
            pnlMenus.setStyle("-fx-background-color : #53639F");
            pnlMenus.toFront();
        }
        if (actionEvent.getSource() == btnOverview) {
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
        }
        if(actionEvent.getSource()==btnOrders)
        {
            pnlOrders.setStyle("-fx-background-color : #464F67");
            pnlOrders.toFront();
        }
      
      }

      
    
       
        
   
       
        
    
    
    }
      