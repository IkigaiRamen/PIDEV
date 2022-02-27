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
         String sql ="insert into commentaire(contenu,date,idPost) Values(?,?,?)";
           ste=mc.prepareStatement(sql);
           ste.setString(1, com.getContenu());
           ste.setString(2,com.getDate());
           ste.setInt(3,com.getIdpost());
           ste.executeUpdate();
           System.out.println("Commentaire Ajoutée");
        }
        catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
    
    public List<Commentaire> afficherCommentaire()
    {
      List<Commentaire> lst =  new ArrayList<>();
      
      try
      {
          String sql="select * from commentaire";

          ste=mc.prepareStatement(sql);
          
          ResultSet rs=ste.executeQuery();
                  while(rs.next()){
                   lst.add(new Commentaire(rs.getInt("id_commentaire"), rs.getString("contenu"),rs.getString("date"),rs.getInt("idPost")));
                  }
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      return lst;
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

    

