/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidev.entities.DemandeTravail;
import pidev.services.DemandeServices;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Khammessi
 */
public class GestionDemandeController implements Initializable {

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
     private TableView<DemandeTravail> table;
    @FXML
    private TableColumn<DemandeTravail, String> title;
    @FXML
    private TableColumn<DemandeTravail, String> type;
    @FXML
    private TableColumn<DemandeTravail, String> category;
    @FXML
    private TableColumn<DemandeTravail, String> salaire;
    @FXML
    private TableColumn<DemandeTravail, String> etat;
                 int index = -1;
                  DemandeServices ds= new DemandeServices();

        ObservableList<DemandeTravail> list = FXCollections.observableArrayList();

    

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
                  list=(ObservableList<DemandeTravail>) ds.afficherDemande();

            title.setCellValueFactory(new PropertyValueFactory<DemandeTravail,String>("title"));
            type.setCellValueFactory(new PropertyValueFactory<DemandeTravail,String>("type"));
            category.setCellValueFactory(new PropertyValueFactory<DemandeTravail,String>("category"));
            salaire.setCellValueFactory(new PropertyValueFactory<DemandeTravail,String>("salaire"));
            etat.setCellValueFactory(new PropertyValueFactory<DemandeTravail,String>("total"));


            table.setItems(list);   

        }
        else
        {}

        }

        @FXML
         public void edit(ActionEvent event){
           try {
               Connection mc = MyConnection.getInstance().getCnx();
                int value1 = Integer.parseInt(txt_id.getText());
                String value2 = txt_nom.getText();
                String value3 = txt_prix.getText();

               String sql = "update panier set id='"+value1+"',nom= '"+value2+"',qte='"+value3+"' where id='"+value1+"' ";
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

             Connection mc = MyConnection.getInstance().getCnx();
             String sql = "delete from panier where id = ?";
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
            tray = new TrayNotification("produit supprimer", "Votre produit a ete supprimer avec succes ,Merci ", NotificationType.SUCCESS);

            tray.showAndDismiss(javafx.util.Duration.seconds(5));
         }



        /**
         * Initializes the controller class.
         */

        @Override
        public void initialize(URL url, ResourceBundle rb) {
              refresh(true);
             
                  list = (ObservableList<DemandeTravail>) ds.afficherDemande();
                  refresh(true);


                  System.out.println(ex.getMessage());
              }             
        }    




  







        public void setTextID(String message) {
            this.id.setText(message);
        }

        public void setTextNom(String message) {
            this.nom.setText(message);
        }

        public void setTextPrix(String message) {
            this.prix.setText(message);
        }

        void setTextqte(String message) {
            this.qte.setText(message);
        }

        void setTexttotale(String message) {
           this.total.setText(message);
        }


       

        @FXML
        private void event(ActionEvent event) {
        }

        @FXML
        private void produit(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("GestionProduit.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }

     

        @FXML
        private void Retour(ActionEvent event) {
              try {
               Parent exercices_parent = FXMLLoader.load(getClass().getResource("GestionPanier.fxml"));
               Scene ex_section_scene = new Scene(exercices_parent);
               Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();

               second_stage.setScene(ex_section_scene);
               second_stage.show();


                       } catch (IOException ex) {

           }
        }
    
    
    
}