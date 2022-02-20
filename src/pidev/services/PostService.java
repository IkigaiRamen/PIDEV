/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import pidev.entities.Post;
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

public class PostService {
   
    Connection mc;
    PreparedStatement ste;

    public PostService() {
         mc=Connexion.getInstance().getMyConnection();
    }
    
    // Fonction AJOUTER
    public void ajouterPost(Post p)
    { 
        try
        {
         String sql ="insert into post(description,date_p) Values(?,?)";
           ste=mc.prepareStatement(sql);
           ste.setString(1, p.getdescription());
           ste.setString(2,p.getdate_p());
           ste.executeUpdate();
           System.out.println("Post Ajoutée");
        }
        catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
    
    public List<Post> afficherPost()
    {
      List<Post> post =  new ArrayList<>();
      String sql="select * from post";
      
      try
      {
          ste=mc.prepareStatement(sql);
          
          ResultSet rs=ste.executeQuery();
                  while(rs.next()){
                      Post p = new Post();
                      p.setid_post(rs.getInt("id_post"));
                      p.setdescription(rs.getString("description"));
                      p.setdate_p(rs.getString("date_p"));
                      post.add(p);
                      System.out.println("ID : "+p.getid_post()+"\n Description : "+p.getdescription()+"\n Date : "+p.getdate_p());
                      //System.out.println("Afficher avec succés !");
                  }
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      return post;
    }
    
  
    
    public void updatePost(int id_post, String description, String date_p){
       String sql= "UPDATE post SET description='"+description+"',date_p= '"+date_p+"' where id_post='"+id_post+"'";
       
       try{
           Statement st= mc.createStatement();
           st.executeUpdate(sql);
           System.out.println(" post modifiée avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }
    
    public void supprimerPost(int id){
        String sql = "DELETE from post where id_post= '"+id+"' "; 
        try{
           Statement st= mc.createStatement();
           st.executeUpdate(sql);
           System.out.println("Post supprimée avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }
    
}

    

