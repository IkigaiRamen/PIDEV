/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import pidev.entities.Post;
import pidev.services.PostService;

/**
 * FXML Controller class
 *
 * 
 */
public class AddPostController implements Initializable {

    @FXML
    private TextArea description;

    PostService ps = new PostService();
    @FXML
    private ImageView imv;
    
    int c;
    int file;
    File pDir;
    File pfile;
    String lien;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c = (int) (Math.random() * (300000 - 2 + 1)) + 2;
        pDir = new File("src/images/Profile" + c + ".jpg");
        lien = "Profile" + c + ".jpg";
        
        

    }    

    @FXML
    private void ajouter(ActionEvent event) {
        
        if (description.getText().equals("") || file == 0){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Complete vos cordnner", ButtonType.OK);
           alert.showAndWait();
        }
        else {
           Post p = new Post();
           p.setdescription(description.getText());
           LocalDate dd = LocalDate.now();
           Date date = java.sql.Date.valueOf(dd);
           p.setdate_p((java.sql.Date) date);
           copier(pfile,pDir);

           p.setImage(lien);
           p.setId_user(1);
          
            ps.ajouterPost(p);
        
            Parent root ;
        try {
            root = FXMLLoader.load(getClass().getResource("/GUI/ShowPosts.fxml"));
            Stage myWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            Logger.getLogger(AddPostController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        }
            
    }

    @FXML
    private void upload(ActionEvent event) throws MalformedURLException {
        
                          FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir une image: ");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("JPEG", "*.jpeg"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("BMP", "*.bmp")
        );
        Window stage = null;
        pfile = fileChooser.showOpenDialog(stage);

        /* - draw image */
        if (pfile != null) {
            file=1;
            Image image = new Image(pfile.toURI().toURL().toExternalForm());
            imv.setImage(image);
    }
        
    }
    
         public static boolean copier(File source, File dest) {
        try (InputStream sourceFile = new java.io.FileInputStream(source);
                OutputStream destinationFile = new FileOutputStream(dest)) {
            // Lecture par segment de 0.5Mo  
            byte buffer[] = new byte[512 * 1024];
            int nbLecture;
            while ((nbLecture = sourceFile.read(buffer)) != -1) {
                destinationFile.write(buffer, 0, nbLecture);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false; // Erreur 
        }
        return true; // Résultat OK   
    }

        
        
        
    
}
