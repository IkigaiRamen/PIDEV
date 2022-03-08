/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import pidev.entities.Commentaire;
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
import pidev.entities.Post;

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
         String sql ="insert into commentaire(contenu,date,idPost,id_user) Values(?,?,?,?)";
           ste=mc.prepareStatement(sql);
           ste.setString(1, com.getContenu());
           ste.setDate(2,com.getDate());
           ste.setInt(3,com.getIdpost());
           ste.setInt(4,com.getId_user());
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
                   lst.add(new Commentaire(rs.getInt("id_commentaire"), rs.getString("contenu"),rs.getDate("date"),rs.getInt("idPost"),rs.getInt("id_user ")));
                  }
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      return lst;
    }
    
  
    
    public void updateCommentaire(int id_commentaire, String contenu, Date date){
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
    
        public ObservableList<Commentaire> getAllCommentByIdPostObs(int id) throws SQLDataException {

        
        List<Commentaire> list =new ArrayList<Commentaire>();
        int count =0;
        
          String sql="select * from commentaire where idpost="+id;
           try{
                ste=mc.prepareStatement(sql);
          
                 ResultSet rs=ste.executeQuery();
                  while(rs.next()){
                      Commentaire p = new Commentaire();
                      p.setId_commentaire(rs.getInt("id_commentaire"));
                      p.setDate(rs.getDate("date"));
                      p.setContenu(rs.getString("contenu"));
                      p.setIdpost(rs.getInt("idpost"));
                       p.setIdpost(rs.getInt("id_user"));

                      list.add(p);
                      //System.out.println("Afficher avec succés !");
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
        
             
          public Commentaire findCommentId(int id)
    {
        Commentaire p = new Commentaire();
        
           
        String requete="select * from commentaire where id_commentaire="+id;
        try{
                ste=mc.prepareStatement(requete);
          
                 ResultSet rs=ste.executeQuery();
            while(rs.next())
            {  
                
                      p.setId_commentaire(rs.getInt("id_commentaire"));
                      p.setDate(rs.getDate("date"));
                      p.setContenu(rs.getString("contenu"));
                      p.setIdpost(rs.getInt("idpost"));
                      p.setId_user(rs.getInt("id_user"));
            }
           
               
            
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
   }
      
    
}

    

