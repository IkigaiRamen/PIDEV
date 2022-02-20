/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import pidev.Connexion;
import pidev.entities.Message;

/**
 *
 * @author khoualdi koussay
 */
public class MessageService {
        Connection mc;
    PreparedStatement ste;

    public MessageService() {
         mc=Connexion.getInstance().getMyConnection();
    }
    public void creerMessage(Message mes)
    { 
        try
        {
         String sql ="insert into message (contenu,date) Values(?,?)";
           ste=mc.prepareStatement(sql);
           ste.setString(1, mes.getContenu());
           ste.setDate(2, (Date) mes.getDateCreation());
           ste.executeUpdate();
           System.out.println("Message Ajoutée");
        }
        catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
        public void supprimerMessage(int id){
        String sql = "DELETE from message where id_message= '"+id+"' "; 
        try{
           Statement st= mc.createStatement();
           st.executeUpdate(sql);
           System.out.println("Message supprimée avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }
    
}
