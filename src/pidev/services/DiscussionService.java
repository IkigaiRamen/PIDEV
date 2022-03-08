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
import pidev.entities.Discussion;
import pidev.entities.Message;

/**
 *
 * @author khoualdi koussay
 */
public class DiscussionService {
    
            Connection mc;
    PreparedStatement ste;

    public void getMessages(){
     try
        {
          Statement selectStmt = mc.createStatement();
            ResultSet rs = selectStmt
             .executeQuery("select * from message where idD=107");
            System.out.println("zqehfoqzeh");
          
             
        }
        catch (SQLException ex) {
           //System.out.println(ex.getMessage());
            
        }

    
    }
    public DiscussionService() {
         mc=Connexion.getInstance().getMyConnection();
    }
    public  void creerDiscussion(Discussion dis)
    { 
        try
        {
         String sql ="insert into discussion (dateCreation) Values(?)";
           ste=mc.prepareStatement(sql);
           ste.setDate(1, (Date) dis.getDateCreation());
           ste.executeUpdate();
          
             
        }
        catch (SQLException ex) {
           System.out.println(ex.getMessage());
            
        }
    }

    
        public void supprimerDiscussion(int id){
        String sql = "DELETE from message where id_discussion= '"+id+"' "; 
        try{
           Statement st= mc.createStatement();
           st.executeUpdate(sql);
           System.out.println("Discussion supprimée avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }
}
