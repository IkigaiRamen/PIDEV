/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pidev.Connexion;
import pidev.entities.Message;
import pidev.entities.UserSession;

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
                  Statement selectStmt = mc.createStatement();
            ResultSet rs = selectStmt
             .executeQuery("select idD from discussion ORDER BY idD desc LIMIT 1");
         if(rs.next()){
            int s = rs.getInt(1);
           
           String sql ="insert into message (contenu,idD,idSender) Values(?,?,?)";
           ste=mc.prepareStatement(sql);
             
         ste.setString(1, mes.getContenu());
         ste.setInt(2, s);
         ste.setInt(3, UserSession.id);
           ste.executeUpdate();
           
         
         } 

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
