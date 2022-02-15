/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import pidev.entities.Commentaire;
import pidev.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommentaireService {
   
    Connection mc;
    PreparedStatement ste;

    public CommentaireService() {
         mc=Connexion.getInstance().getMyConnection();
    }
    
    // Fonction AJOUTER
    public void ajouterCommentaire(Commentaire com)
    { 
        try
        {
         String sql ="insert into commentaire(contenu,date) Values(?,?)";
           ste=mc.prepareStatement(sql);
           ste.setString(1, com.getcontenu());
           ste.setString(2,com.getdate());
           ste.executeUpdate();
           System.out.println("Commentaire Ajoutée");
        }
        catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
    
    public List<Commentaire> afficherCommentaire()
    {
      List<Commentaire> commentaire =  new ArrayList<>();
      String sql="select * from commentaire";
      
      try
      {
          ste=mc.prepareStatement(sql);
          
          ResultSet rs=ste.executeQuery();
                  while(rs.next()){
                      Commentaire com = new Commentaire();
                      com.setid_commentaire(rs.getInt("id_commentaire"));
                      com.setcontenu(rs.getString("contenu"));
                      com.setdate(rs.getString("date"));
                      commentaire.add(com);
                      System.out.println("ID : "+com.getid_commentaire()+"\n Contenu : "+com.getcontenu()+"\n Date : "+com.getdate());
                      //System.out.println("Afficher avec succés !");
                  }
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      return commentaire;
    }
    
  
    
    public void updateCommentaire(int id_commentaire, String contenu, String date){
       String sql= "UPDATE commentaire SET contenu='"+contenu+"',date= '"+date+"' where id_commentaire='"+id_commentaire+"'";
       
       try{
           Statement st= mc.createStatement();
           st.executeUpdate(sql);
           System.out.println(" commentaire modifiée avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }
    
    public void supprimerCommentaire(int id){
        String sql = "DELETE from commentaire where id_commentaire= '"+id+"' "; 
        try{
           Statement st= mc.createStatement();
           st.executeUpdate(sql);
           System.out.println("Commentaire supprimée avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }
    
}

    

