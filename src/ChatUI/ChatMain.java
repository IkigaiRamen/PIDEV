/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author khoualdi koussay
 */
public class ChatMain extends Application {
         
    @Override
    public void start(Stage primaryStage) {
        try {
            
            
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/ChatUI/ListDiscussion.fxml"));
           Parent root = loader.load();
           //ListeDiscussionController controller = loader.getController();
           //controller.lance();
           Scene scene = new Scene(root);
           primaryStage.setTitle("Chat");
           primaryStage.setScene(scene);
           primaryStage.show();
           
          
        } catch (IOException ex) {
            Logger.getLogger(ex.getMessage());
        }
        
    }

   
    public static void main(String[] args) {
        
        try {
             
          
            Socket sock_client = new Socket("localhost",9000);
            
            //recuperation du flux de lecture avec le serveur
            InputStream is = sock_client.getInputStream();
            InputStreamReader ipsr = new InputStreamReader(is);
            final BufferedReader reader = new BufferedReader(ipsr);
            // recuperation du flux d'ecriture avec le serveur
            OutputStream os = sock_client.getOutputStream();
            final PrintWriter writer = new PrintWriter(os,true);
            Thread reception = new Thread (new Runnable(){
                String msg;
                
                @Override
                public void run()
                {
                    while (true)
                    {
                        try
                        {
                            msg = reader.readLine();
                            if(msg!=null)System.err.println(msg);
                        }catch(IOException e){}
                    }
                }
            });
            
            Thread emission = new Thread(new Runnable(){
                private Scanner sc;
                @Override
                public void run(){
                    while(true){
                        
                        sc = new Scanner(System.in);
                        //pour lire a partir de l'entré standard
                        
                        String str = sc.nextLine();
                        //envoyer ce qui est été lu
                        writer.println(str);
                    }
                }
            });
            emission.start();
            reception.start();
        } catch (IOException ex) {
            Logger.getLogger(ChatMain.class.getName()).log(Level.SEVERE, null, ex);
        }
           launch(args);
      }
    }
    
