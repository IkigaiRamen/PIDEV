/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import pidev.entities.Post;
import pidev.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
         String sql ="insert into post(description,date_p,reaction,image,id_user ) Values(?,?,?,?,?)";
           ste=mc.prepareStatement(sql);
           ste.setString(1, p.getdescription());
           ste.setDate(2,p.getdate_p());
           ste.setInt(3, p.getReaction());
           ste.setString(4, p.getImage());
           ste.setInt(5, p.getId_user());
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
                      p.setImage(rs.getString("image"));
                      p.setId_user(rs.getInt("id_user"));
                      p.setdate_p(rs.getDate("date_p"));
                      post.add(p);
                      System.out.println("ID : "+p.getid_post()+"\n Description : "+p.getdescription()+"\n Date : "+p.getdate_p());
                      //System.out.println("Afficher avec succés !");
                  }
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      return post;
    }
    
  
    
    public void updatePost(int id_post, String description, Date date_p){
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
    
    
      public ObservableList<Post> getAllPostObs() throws SQLDataException {

        
        List<Post> list =new ArrayList<Post>();
        int count =0;
        
          String sql="select * from post";
           try{
                ste=mc.prepareStatement(sql);
          
                 ResultSet rs=ste.executeQuery();
                  while(rs.next()){
                      Post p = new Post();
                      p.setid_post(rs.getInt("id_post"));
                      p.setdescription(rs.getString("description"));
                      p.setImage(rs.getString("image"));
                      p.setId_user(rs.getInt("id_user"));
                      p.setdate_p(rs.getDate("date_p"));
                      list.add(p);
                      System.out.println("ID : "+p.getid_post()+"\n Description : "+p.getdescription()+"\n Date : "+p.getdate_p());
                      System.out.println("Afficher avec succés !");
                 count ++;
                  
                  }
            if(count == 0){
                return null;
           }else{
             ObservableList lc_final = FXCollections.observableArrayList(list);

               return lc_final;
            
           
        }
         }
        catch (SQLException ex) {
            Logger.getLogger(PostService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
   
           
}
      
          public Post findPostId(int id)
    {
        Post p = new Post();
        
           
        String requete="select * from post where id_post="+id;
        try{
                ste=mc.prepareStatement(requete);
          
                 ResultSet rs=ste.executeQuery();
            while(rs.next())
            {  
                
                      p.setid_post(rs.getInt("id_post"));
                      p.setdescription(rs.getString("description"));
                      p.setImage(rs.getString("image"));
                      p.setId_user(rs.getInt("id_user"));
                      p.setdate_p(rs.getDate("date_p"));
                
            }
           
               
            
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
   }
    
}

    

