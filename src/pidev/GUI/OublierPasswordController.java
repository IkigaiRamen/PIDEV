/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import pidev.services.UserService;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class OublierPasswordController implements Initializable {

    @FXML
    private Button btnVerifier;

    static int numeroVelidation= (int)(Math.random()*9999);
    @FXML
    private TextField txt;
    /**
     * Initializes the controller class.
     */
    public static String email ;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void verifier(ActionEvent event) {
        UserService us= new UserService();
        email =txt.getText();
        if(email.isEmpty()){
            btnVerifier.setOnAction( new EventHandler<ActionEvent>(){
                @Override
                    public void handle(ActionEvent event) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Champ vide");
                        alert.setHeaderText("Placer le code s'il vous plait");
                        alert.showAndWait();
                    }
            });
        }
        try{
            if(!(us.VerifyEmail(email))){
                btnVerifier.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Email non Valide");
                        alert.setHeaderText("Verifiez votre email s'il vous plait");
                        alert.showAndWait();
                    }
                });
                }
            else{
                try{
                    String host ="smtp.gmail.com";
                    String user = "devjobs@gmail.com";
                    String pass="devjobs";
                    String to=email;
                    String from="devjobs@gmail.com";
                    String subject="Code de verification: mot de passe oublie" ;
                    String messageText="Bonjour,\n le code de verification pour le changement de votre mot de passe est :"+numeroVelidation;
                    boolean sessionDebug= false;
                    
                    Properties props= System.getProperties();
                    props.put("mail.smtp.starttls.enable","true");
                    props.put("mail.smtp.host",host);
                    props.put("mail.smtp.port","587");
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.starttls.required", "true");
                    
                    java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                    Session mailSession = Session.getDefaultInstance(props,null);
                    mailSession.setDebug(sessionDebug);
                    MimeMessage msg= new MimeMessage(mailSession); 
                    msg.setFrom(new InternetAddress(from));
                    msg.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));
                    msg.setSubject(subject);
                    msg.setSentDate(new Date());
                    msg.setText(messageText);
                    
                    Transport transport =mailSession.getTransport("smtp");
                    transport.connect(host, user, pass);
                    transport.sendMessage(msg, msg.getAllRecipients());
                    transport.close();
                    
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                try{
                    Parent root = FXMLLoader.load(getClass().getResource("OublierPasswordCode.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
            
                }
                catch(IOException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
}
