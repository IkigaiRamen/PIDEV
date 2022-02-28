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
        Connection mc =Connexion.getInstance().getMyConnection();
    PreparedStatement ste;

   
    public void creerMessage(Message mes)
    { 
        try
        {
         String sql ="insert into message (dateCreation,contenu) Values(?,?)";
           ste=mc.prepareStatement(sql);
             ste.setDate(1, (Date) mes.getDateCreation());
         ste.setString(2, mes.getContenu());
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
