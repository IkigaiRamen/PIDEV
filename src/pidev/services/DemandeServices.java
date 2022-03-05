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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.Connexion;
import pidev.entities.DemandeTravail;
import pidev.entities.Post;

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
    public void ajouterDemande(DemandeTravail d) throws IOException 
    { 
        
     
        try
        {
         String sql ="insert into demande(title, description ,category,type,location,salaire,dateFin) Values(?,?,?,?,?,?,?,?)";
           ste=mc.prepareStatement(sql);
           ste.setString(1, d.getTitle());
           ste.setString(2,d.getDescription());
           ste.setString(3,d.getCategory());
           ste.setString(4,d.getType());
           ste.setString(5, d.getLocation());
           ste.setFloat(6, d.getSalaire());
           ste.setDate(7,d.getDateFin());
         
           
           ste.executeUpdate();
           System.out.println("Demande Ajoutée");
        }
        catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
    
      public DemandeTravail afficherDemandeById(int id)
    {
        DemandeTravail d = new DemandeTravail();
        String sql="select * from demande where id=?";
        
      
      try
      {
          ste=mc.prepareStatement(sql);
          ste.setInt(1, id);
          ResultSet rs=ste.executeQuery();
                      
                      d.setTitle(rs.getString("title"));
                      d.setLocation(rs.getString("location"));
                      d.setDescription(rs.getString("description"));
                      d.setCategory(rs.getString("category"));
                      d.setType(rs.getString("type"));
                      d.setLocation(rs.getString("location"));
                      d.setSalaire(rs.getFloat("salaire"));
                      d.setDateFin(rs.getDate("dateFin"));
                     
                  
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      return d;
    }
    
    public List<DemandeTravail> afficherDemande()
    {
      List<DemandeTravail> demande =  new ArrayList<>();
      String sql="select * from demande";
      
      try
      {
          ste=mc.prepareStatement(sql);
          
          ResultSet rs=ste.executeQuery();
                  while(rs.next()){
                      DemandeTravail d = new DemandeTravail();
                      d.setTitle(rs.getString("title"));
                      d.setDescription(rs.getString("description"));
                      d.setCategory(rs.getString("category"));
                      d.setType(rs.getString("type"));
                      d.setLocation(rs.getString("location"));
                      d.setSalaire(rs.getFloat("salaire"));
                      d.setDateFin(rs.getDate("dateFin"));
                      demande.add(d);
                  }
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      System.out.println(demande.size());
      return demande;
    }
    
    public void desactiverDemande(int id){
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
    
    }
    
  
    
    public void updateDemande(DemandeTravail d){
        try{
            String test ="UPDATE demande SET title=?, description=?, type=?, category=?, location=?, salaire=?, dateFin=? WHERE id=?";
             ste= mc.prepareStatement(test);
     /*    String sssql ="UPDATE demande SET title '"+d.getTitle()
                   +"', description '" + d.getDescription()*/
                 ste.setString(1, d.getTitle());
                 ste.setString(2,d.getDescription());
                 ste.setString(3, d.getType());
                 ste.setString(4, d.getCategory());
                 ste.setString(5,d.getLocation());
                 ste.setFloat(6,d.getSalaire());
                 ste.setDate(7,d.getDateFin());
                 ste.setInt(8,d.getId());
              /*  +"', type '"+ d.getType()
                +"', category '"+ d.getCategory()
                 +"', location '"+ d.getLocation()
                 +"', salaire'"+d.getSalaire()
                +"', dateFin '"+ d.getDateFin()*/
              //   +"' where id="+ d.getId() ;
      /* String sql= "UPDATE demande SET title='"+d.getTitle()+"',category='"+d.getCategory()+"',type= '"+d.getType()+"',location='"+d.getLocation()+"',dateFin='"+d.getDateFin()+"',salaire'"+d.getSalaire()
               +"',description='"+d.getDescription()+"'where id='"+d.getId()+"'";
               
        String s="update demande set title='"+d.getTitle()+"',description='"+d.getDescription()+"',type='"+d.getType()+"',category='"+d.getCategory()+"',salaire='"+d.getSalaire()+"',location='"+d.getLocation()+
                "',dateFin='"+d.getDateFin()+"'where id='"+d.getId()+"'";*/


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
           
           System.out.println(id);
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }
    
}
