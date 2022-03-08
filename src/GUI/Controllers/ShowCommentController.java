/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controllers;

import static GUI.Controllers.ShowPostsController.idE;
import GUI.Home2Controller;
//import com.github.plushaze.traynotification.notification.Notifications;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pidev.entities.BadWords;
import pidev.entities.Commentaire;
import pidev.entities.Post;
import pidev.entities.Vote;
import pidev.services.CommentaireService;
import pidev.services.PostService;
import pidev.services.ServiceVote;

/**
 * FXML Controller class
 *
 * 
 */
public class ShowCommentController implements Initializable {

    @FXML
    private ListView<Commentaire> listView;
    @FXML
    private Button partager;
    
        ObservableList<Commentaire> data;
    
    public static int idc ;
    @FXML
    private TextField cmt;
    
    CommentaireService sc = new CommentaireService();
    @FXML
    private Label label;
    @FXML
    private ImageView imv;
    
    PostService ps = new PostService();
    @FXML
    private Label Nbrlike;
    @FXML
    private Label nbrDeslike;

    ServiceVote vs = new ServiceVote();
    @FXML
    private Button partager1;
    @FXML
    private Button partager11;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          Post p = ps.findPostId(Home2Controller.idE);
         imv.setImage(new Image("images/" + p.getImage()));
          label.setText(p.getDescription());
          try {
            CommentaireService cs = new CommentaireService();
            data = (ObservableList<Commentaire>) cs.getAllCommentByIdPostObs(Home2Controller.idE);   
            listView.setItems(data);
            listView.setCellFactory((ListView<Commentaire> param) -> new ListViewCommentaire());

            Nbrlike.setText(String.valueOf(vs.NumLike(Home2Controller.idE)));
            nbrDeslike.setText(String.valueOf(vs.NumdeLike(Home2Controller.idE)));            
            
            // TODO
        } catch (SQLDataException ex) {
            Logger.getLogger(Home2Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ShowCommentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void handleClose(ActionEvent event) {
    }

    @FXML
    private void Modefier(ActionEvent event) {
        
        
            ObservableList<Commentaire> e;
            e = listView.getSelectionModel().getSelectedItems();

            
          for (Commentaire m : e) 
          idc=m.getId_commentaire();
          
          
                  try {
       Parent root = FXMLLoader.load(getClass().getResource("/GUI/ModefierComment.fxml"));
            Stage myWindow =  (Stage) partager.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("");
            myWindow.show();
           
        } catch (IOException ex) {
           // Logger.getLogger(ReponseItemController.class.getName()).log(Level.SEVERE,null,ex);
        }
    
        
    
    }

    @FXML
    private void Supprimer(ActionEvent event) {
        
                ObservableList<Commentaire> e;
            e = listView.getSelectionModel().getSelectedItems();

            
          for (Commentaire m : e) 
          idc=m.getId_commentaire();
          sc.supprimerCommentaire(idc);
      
          
                  try {
       Parent root = FXMLLoader.load(getClass().getResource("/GUI/ShowComment.fxml"));
            Stage myWindow =  (Stage) partager.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("");
            myWindow.show();
           
        } catch (IOException ex) {
           // Logger.getLogger(ReponseItemController.class.getName()).log(Level.SEVERE,null,ex);
        }
                  
          

    }

    @FXML
    private void commenter(ActionEvent event) {
        
         BadWords.loadConfigs();
         
         
         
        Commentaire c = new Commentaire();
        c.setIdpost(ShowPostsController.idE);
        c.setContenu(cmt.getText());
         LocalDate dd = LocalDate.now();
         Date date = java.sql.Date.valueOf(dd);
        c.setDate(date);
        c.setId_user(1);
        
       if (BadWords.filterText(cmt.getText())) {
            
           Alert alert = new Alert(Alert.AlertType.ERROR, "cette application n'autorise pas ces termes", ButtonType.OK);
           alert.showAndWait();  
       }else{
        
        sc.ajouterCommentaire(c);
       }
                 try {
       Parent root = FXMLLoader.load(getClass().getResource("/GUI/ShowComment.fxml"));
            Stage myWindow =  (Stage) partager.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("");
            myWindow.show();
           
        } catch (IOException ex) {
           // Logger.getLogger(ReponseItemController.class.getName()).log(Level.SEVERE,null,ex);
        }

        
        
    }

    @FXML
    private void like(ActionEvent event) throws SQLException {
        
            
        Vote v = new Vote();
       ServiceVote vs = new ServiceVote();
       v.setId_client(1);
       v.setId_post(idE);
       v.setType_vote(2);
              vs.addVote(v);

         
        try {
       Parent root = FXMLLoader.load(getClass().getResource("/GUI/ShowComment.fxml"));
            Stage myWindow =  (Stage) cmt.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("");
            myWindow.show();
           
        } catch (IOException ex) {
           // Logger.getLogger(ReponseItemController.class.getName()).log(Level.SEVERE,null,ex);
        }
    
        
    }

    @FXML
    private void deslike(ActionEvent event) throws SQLException {
        
              
        Vote v = new Vote();
       ServiceVote vs = new ServiceVote();
      // vs.getAllVote(idE, 1);
       v.setId_client(1);
       v.setId_post(idE);
       v.setType_vote(1);
       vs.addVote(v);
         
        try {
       Parent root = FXMLLoader.load(getClass().getResource("/GUI/ShowComment.fxml"));
            Stage myWindow =  (Stage) nbrDeslike.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("");
            myWindow.show();
           
        } catch (IOException ex) {
           // Logger.getLogger(ReponseItemController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
}
