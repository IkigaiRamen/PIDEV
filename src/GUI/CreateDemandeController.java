/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import pidev.Connexion;
import pidev.entities.Demande;
import pidev.services.DemandeServices;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Khammessi
 */
public class CreateDemandeController implements Initializable {

    @FXML
    private Button event;
    @FXML
    private Button abonnement;
    @FXML
    private Button planning;
    @FXML
    private Label imagePath;
    
   
    @FXML
    private TextField txt_id;
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_prix;
    
    
    
    @FXML
    private Button tfModifier;
    @FXML
    private Button tfSupprimer;
    @FXML
    private Button export;
    @FXML
    private Button user;
    @FXML
    private Button Retour;

    @FXML
     private TableView<Demande> table;
    @FXML
    private TableColumn<Demande, String> title;
    @FXML
    private TableColumn<Demande, String> type;
    @FXML
    private TableColumn<Demande, String> category;
    @FXML
    private TableColumn<Demande, String> salaire;
    @FXML
    private TableColumn<Demande, String> etat;
                 int index = -1;
                  DemandeServices ds= new DemandeServices();

        ObservableList<Demande> list = FXCollections.observableArrayList();

    

      void getSelected(MouseEvent event){
            index = table.getSelectionModel().getSelectedIndex();
            if(index <= -1){

                return;
            }
            txt_id.setText(title.getCellData(index).toString());
            txt_nom.setText(type.getCellData(index).toString());
            txt_prix.setText(category.getCellData(index).toString());
        }
      
       public void refresh(boolean x){
        if(x==true){
                  list=(ObservableList<Demande>) ds.afficherDemande();

            title.setCellValueFactory(new PropertyValueFactory<Demande,String>("title"));
            type.setCellValueFactory(new PropertyValueFactory<Demande,String>("type"));
            category.setCellValueFactory(new PropertyValueFactory<Demande,String>("category"));
            salaire.setCellValueFactory(new PropertyValueFactory<Demande,String>("salaire"));
            etat.setCellValueFactory(new PropertyValueFactory<Demande,String>("etat"));


            table.setItems(list);   

        }
        else
        {}

        }

        @FXML
         public void edit(ActionEvent event){
           try {
               Connection mc = Connexion.getInstance().getMyConnection();
               
                String value1 = txt_id.getText();
                String value2 = txt_nom.getText();
                String value3 = txt_prix.getText();

               String sql = "update demande set titre='"+value1+"',description= '"+value2+"',type='"+value3+"' where titre='"+value1+"' ";
               PreparedStatement pst = mc.prepareStatement(sql);
               pst= mc.prepareStatement(sql);
               pst.execute();

               int responce=JOptionPane.showConfirmDialog(null, "voulez-vous modifier ?","vérification",JOptionPane.YES_NO_OPTION);
                if (responce==JOptionPane.YES_OPTION){
                      table.getItems().clear();
                refresh(true);
                 TrayNotification tray = null;
            tray = new TrayNotification("produit modifiee", "Votre produit a ete modifiee avec succes ,Merci ", NotificationType.SUCCESS);

            tray.showAndDismiss(javafx.util.Duration.seconds(5));

                } else{
                    System.out.println("modification annuler");
                }

               //JOptionPane.showMessageDialog(null, "update");
               //refresh(true);

           } catch (Exception e) {
               JOptionPane.showMessageDialog(null, e);
            }    
        }

        @FXML
         public void delete(){

             Connection mc = Connexion.getInstance().getMyConnection();
             String sql = "delete from demande where titre = ?";
             try {
                 PreparedStatement pst = mc.prepareStatement(sql);
                 pst.setString(1,txt_id.getText());
                 pst.execute();
                 

    int responce=JOptionPane.showConfirmDialog(null, "voulez-vous supprimer ?","vérification",JOptionPane.YES_NO_OPTION);
                if (responce==JOptionPane.YES_OPTION){
                      table.getItems().clear();
                refresh(true);



                } else{
                    System.out.println("modification annuler");
                }

    // JOptionPane.showMessageDialog(null, "supprimer");
                 //refresh(true);

             } catch (Exception e) {
                  JOptionPane.showMessageDialog(null, e);
             }
                  TrayNotification tray = null;
            tray = new TrayNotification("Demande supprimer", "Votre produit a ete supprimer avec succes ,Merci ", NotificationType.SUCCESS);

            tray.showAndDismiss(javafx.util.Duration.seconds(5));
         }

 public void setTextID(String message) {
            this.title.setText(message);
        }

        public void setTextNom(String message) {
            this.type.setText(message);
        }

        public void setTextPrix(String message) {
            this.category.setText(message);
        }

        void setTextqte(String message) {
            this.salaire.setText(message);
        }

        void setTexttotale(String message) {
           this.etat.setText(message);
        }

        /**
         * Initializes the controller class.
         */

        @Override
        public void initialize(URL url, ResourceBundle rb) {
              refresh(true);
             
                  list = (ObservableList<Demande>) ds.afficherDemande();
                  refresh(true);

              }             
        }    

       


       

 

  