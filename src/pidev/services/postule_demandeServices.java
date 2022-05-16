/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pidev.Connexion;
import pidev.entities.Demande;
import pidev.entities.postule_demande;

/**
 *
 * @author Khammessi
 */
public class postule_demandeServices {
    
      Connection mc;
    PreparedStatement ste;

    public postule_demandeServices() {
         mc=Connexion.getInstance().getMyConnection();
    }
    
    public void ajoutePostuleDemande(postule_demande d) throws IOException 
    { 
        try
        {
         String sql ="insert into postule_demande(user_id,demande_id) Values(?,?)";
           ste=mc.prepareStatement(sql);
           ste.setInt(1, d.getUser_id());
           ste.setInt(2, d.getDemande_id());
           ste.executeUpdate();
           System.out.println("Postule Demande Ajoutée");
        }
        catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
   
   public postule_demande afficherDemande(int id){
   
   postule_demande d = new postule_demande();
        String sql="select * from postule_demande";
        
      
      try
      {
          ste=mc.prepareStatement(sql);
          ste.setInt(1, id);
          
          ResultSet rs=ste.executeQuery();
                      while(rs.next()) {
                      d.setId(rs.getInt("id"));
                      d.setUser_id(rs.getInt("user_id"));
                      d.setDemande_id(rs.getInt("demande_id"));
                      }
                  
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      return d;
   }
   
    public List<postule_demande> afficherPostuleDemande()
    {
      List<postule_demande> demande =  new ArrayList<>();
      String sql="select * from postule_demande";
      
      try
      {
          ste=mc.prepareStatement(sql);
          
          ResultSet rs=ste.executeQuery();
                  while(rs.next()){
                      postule_demande d = new postule_demande();
                       d.setId(rs.getInt("id"));
                      d.setUser_id(rs.getInt("user_id"));
                      d.setDemande_id(rs.getInt("demande_id"));
                      demande.add(d);
                  }
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      System.out.println(demande.size());
      return demande;
    }
    
    public void supprimerPostuleDemande(int id){
        String sql = "DELETE from postule_demande where id= '"+id+"' "; 
        try{
           Statement st= mc.createStatement();
           st.executeUpdate(sql);
           
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }
    
}
