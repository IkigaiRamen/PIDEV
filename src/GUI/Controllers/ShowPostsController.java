/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controllers;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLDataException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import pidev.entities.Post;
import pidev.services.PostService;


/**
 * FXML Controller class
 *
 * 
 */
public class ShowPostsController implements Initializable {

    @FXML
    private ListView<Post> listView;
   
    ObservableList<Post> data ;
    
    public static int idE ;
    
    PostService ds = new PostService();

   
    @FXML
    private Button partager;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            PostService cs = new PostService();
            data = (ObservableList<Post>) cs.getAllPostObs();   
            listView.setItems(data);
            listView.setCellFactory((ListView<Post> param) -> new ListViewPost());
            
            
            // TODO
        } catch (SQLDataException ex) {
            Logger.getLogger(ShowPostsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    




    @FXML
    private void handleClose(ActionEvent event) {
    }

    public void delete(){
    
    ObservableList<Post> e;
            e = listView.getSelectionModel().getSelectedItems();
    for (Post m : e) 
          idE=m.getid_post();
          ds.supprimerPost(idE);
          
                  try {
       Parent root = FXMLLoader.load(getClass().getResource("/GUI/ShowPosts.fxml"));
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
    private void Annuler(ActionEvent event) throws SQLDataException {
        
            delete();
          

            
        
    }

    @FXML
    private void modifier(ActionEvent event) {
        
           
                            ObservableList<Post> e;
            e = listView.getSelectionModel().getSelectedItems();

            
          for (Post m : e) 
          idE=m.getid_post();
          System.out.println("controller.ShowDonationsController.modifier()"+idE);
          
                            try {
       Parent root = FXMLLoader.load(getClass().getResource("/GUI/MofierPost.fxml"));
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
    private void details(ActionEvent event) {
        
        
        ObservableList<Post> e;
            e = listView.getSelectionModel().getSelectedItems();

            
          for (Post m : e) 
          idE=m.getid_post();
          System.out.println("this is the first test"+ idE);
          
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

    }

    

