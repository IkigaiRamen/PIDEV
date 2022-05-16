/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.Connexion;
import pidev.entities.Demande;
        import java.sql.Date;

/**
 *
 * @author Khammessi
 */
public class DemandeServices {
    
     Connection mc;
    PreparedStatement ste;

    public DemandeServices() {
         mc=Connexion.getInstance().getMyConnection();
    }
    
    // Fonction AJOUTER
    public void ajouterDemande(Demande d) throws IOException 
    { 
        
     
        try
        {
         String sql ="insert into demande(user_id,titre,exp, description ,expire,type,salairemin,salairemax,qualification,sex,city,categorie,location) Values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
           ste=mc.prepareStatement(sql);
           ste.setInt(1, d.getUser_id());
           ste.setString(2, d.getTitre());
           ste.setString(3,d.getExp());
           ste.setString(4,d.getDescription());
           ste.setDate(5,d.getExpire());
           ste.setString(6, d.getType());
           ste.setInt(7, d.getSalairemin());
           ste.setInt(8, d.getSalairemax());
           ste.setString(9, d.getQualification());
           ste.setString(10, d.getSex());
           ste.setString(11, d.getCity());
           ste.setString(12, d.getCategorie());
           ste.setString(13, d.getLocation());
         
           ste.executeUpdate();
           System.out.println("Demande Ajoutée");
        }
        catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
    
    public int AfficherTotal(){
        int count=0;
         try {
             String sql="select count(*) from demande ";
             ste=mc.prepareStatement(sql);
             ResultSet rs=ste.executeQuery();
             rs.next();
              count= rs.getInt(1);
             
         } catch (SQLException ex) {
             Logger.getLogger(DemandeServices.class.getName()).log(Level.SEVERE, null, ex);
         }
         return count;
         
    }
    
   public int AfficherActive(int id ){
        int count=0;
        LocalDate d= java.time.LocalDate.now();
        java.sql.Date sqlDate=java.sql.Date.valueOf( d );
         try {
             String sql="select count(*) from demande where expire >'"+sqlDate+"'and id='"+id+"'";
             ste=mc.prepareStatement(sql);
             ResultSet rs=ste.executeQuery();
             rs.next();
              count= rs.getInt(1);
             
         } catch (SQLException ex) {
             Logger.getLogger(DemandeServices.class.getName()).log(Level.SEVERE, null, ex);
         }
         return count;
         
    }
    
    public int AfficherInactive(int id){
        int count=0;
            LocalDate d= java.time.LocalDate.now();
           java.sql.Date sqlDate=java.sql.Date.valueOf( d );
         try {
             String sql="select count(*) from demande where expire <'"+sqlDate+"'and id='"+id+"'";
             ste=mc.prepareStatement(sql);
             ResultSet rs=ste.executeQuery();
             rs.next();
              count= rs.getInt(1);
             
         } catch (SQLException ex) {
             Logger.getLogger(DemandeServices.class.getName()).log(Level.SEVERE, null, ex);
         }
         return count;
         
    }
    
      public Demande afficherDemandeById(int id)
    {
        Demande d = new Demande();
        String sql="select * from demande where id=?";
        
      
      try
      {
          ste=mc.prepareStatement(sql);
          ste.setInt(1, id);
          
          ResultSet rs=ste.executeQuery();
                      while(rs.next()) {
                      d.setId(rs.getInt("id"));
                      d.setUser_id(rs.getInt("user_id"));
                      d.setTitre(rs.getString("titre"));
                      d.setExp(rs.getString("exp"));
                      d.setDescription(rs.getString("description"));
                      d.setExpire(rs.getDate("expire"));
                      d.setType(rs.getString("type"));
                      d.setSalairemin(rs.getInt("salairemin"));
                      d.setSalairemax(rs.getInt("salairemax"));
                      d.setQualification(rs.getString("qualification"));
                      d.setSex(rs.getString("sex"));
                      d.setCity(rs.getString("city"));
                      d.setCategorie(rs.getString("categorie"));
                      d.setLocation(rs.getString("location"));
                      d.setCreated_at(rs.getDate("created_at"));
                      }
                  
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      return d;
    }
    
    public List<Demande> afficherDemande()
    {
      List<Demande> demande =  new ArrayList<>();
      String sql="select * from demande";
      
      try
      {
          ste=mc.prepareStatement(sql);
          
          ResultSet rs=ste.executeQuery();
                  while(rs.next()){
                      Demande d = new Demande();
                       d.setId(rs.getInt("id"));
                      d.setUser_id(rs.getInt("user_id"));
                      d.setTitre(rs.getString("titre"));
                      d.setExp(rs.getString("exp"));
                      d.setDescription(rs.getString("description"));
                      d.setExpire(rs.getDate("expire"));
                      d.setType(rs.getString("type"));
                      d.setSalairemin(rs.getInt("salairemin"));
                      d.setSalairemax(rs.getInt("salairemax"));
                      d.setQualification(rs.getString("qualification"));
                      d.setSex(rs.getString("sex"));
                      d.setCity(rs.getString("city"));
                      d.setCategorie(rs.getString("categorie"));
                      d.setLocation(rs.getString("location"));
                      d.setCreated_at(rs.getDate("created_at"));
                      demande.add(d);
                  }
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      return demande;
    }
    
  /*  public void desactiverDemande(int id){
         try {
             String sql = "update demande set etat = false where id='"+id+"'";
             Statement st=mc.createStatement();
             st.executeUpdate(sql);
             System.out.println(" demande désactivé");

         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
         }
    
    }
    
        public void activerDemande(int id){
         try {
             String sql = "update demande set etat = true where id='"+id+"'";
             Statement st=mc.createStatement();
             st.executeUpdate(sql);
             System.out.println(" demande activée");

         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
         }
    
    }*/
    
  
    
    public void updateDemande(Demande d){
        try{
            String test ="UPDATE demande SET titre=?, exp=?, description=?, expire=?, type=?, salairemin=?,salairemax=?,qualification=?,sex=?,city=?,categorie=?,location=? WHERE id=?";
             ste= mc.prepareStatement(test);
           ste.setString(1, d.getTitre());
           ste.setString(2,d.getExp());
           ste.setString(3,d.getDescription());
           ste.setDate(4,d.getExpire());
           ste.setString(5, d.getType());
           ste.setInt(6, d.getSalairemin());
           ste.setInt(7, d.getSalairemax());
           ste.setString(8, d.getQualification());
           ste.setString(9, d.getSex());
           ste.setString(10, d.getCity());
           ste.setString(11, d.getCategorie());
           ste.setString(12, d.getLocation());
           ste.setInt(13,d.getId());
           
                 System.out.println(d.getId()+"this is the id");             

           ste.executeUpdate();
           System.out.println(" demande modifiée avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }
    
    public void supprimerDemande(int id){
        String sql = "DELETE from demande where id= '"+id+"' "; 
        try{
           Statement st= mc.createStatement();
           st.executeUpdate(sql);
           
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }
    
}
