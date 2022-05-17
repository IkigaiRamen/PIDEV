/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pidev.Connexion;
import pidev.entities.Offre;

/**
 *
 * @author khaled
 */
public class OffreServices {
    
       Connection mc;
    PreparedStatement ste;

    public OffreServices() {
         mc=Connexion.getInstance().getMyConnection();
    }
    
    public void ajoutOffre(Offre off){
    try
        {
          String sql ="insert into offre(user_id,titre,description ,exp,responsibilities,eduexp,expire,type,salairemin,salairemax,qualification,sex,city,categorie,autres) Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
           ste=mc.prepareStatement(sql);
           ste.setInt(1, off.getUser_id());
           ste.setString(2, off.getTitre());
           ste.setString(3,off.getDescription());
           ste.setString(4,off.getExp());
           ste.setString(5,off.getResponsiblilties());
           ste.setString(6, off.getEduxp());
           ste.setDate(7,off.getExpire());
           ste.setString(8, off.getType());
           ste.setInt(9, off.getSalairemin());
           ste.setInt(10, off.getSalairemax());
           ste.setString(11, off.getQualification());
           ste.setString(12, off.getSex());
           ste.setString(13, off.getCity());
           ste.setString(14, off.getCategorie());
           ste.setString(15, off.getAutres());
         
           ste.executeUpdate();
           System.out.println("Offre Ajoutée");
        }
        catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    
    
    }
    
    public List<Offre>  afficherOffre(){
        List<Offre> offre =  new ArrayList<>();
      String sql="select * from offre";
      try
      {
          ste=mc.prepareStatement(sql);
          
          ResultSet rs=ste.executeQuery();
                  while(rs.next()){
                    Offre o = new Offre();
                      o.setId(rs.getInt("id"));
                      o.setUser_id(rs.getInt("user_id"));
                      o.setTitre(rs.getString("tire"));
                      o.setDescription(rs.getString("description"));
                      o.setAutres("autres");
                      o.setResponsiblilties(rs.getString("responsibilities"));
                      o.setEduxp(rs.getString("eduxp"));
                      o.setExpire(rs.getDate("expire"));
                      o.setCategorie(rs.getString("categorie"));
                      o.setType(rs.getString("type"));
                      o.setSalairemin(rs.getInt("salairemib"));
                      o.setSalairemax(rs.getInt("salairemax"));
                      o.setExp(rs.getString("exp"));
                      o.setQualification(rs.getString("qualification"));
                      o.setSex(rs.getString("sex"));
                      o.setCity(rs.getString("city"));
                      o.setCreated_at(rs.getDate("created_at"));
                      offre.add(o);
                  }
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      return offre;
    
    }
    public Offre  afficherOffrebyId(int id){
      Offre off = new Offre();
        String sql="select * from offre where id=?";
        
      
      try
      {
          ste=mc.prepareStatement(sql);
          ste.setInt(1, id);
          
          ResultSet rs=ste.executeQuery();
                      while(rs.next()) {
                      off.setId(rs.getInt("id"));
                      off.setUser_id(rs.getInt("user_id"));
                      off.setTitre(rs.getString("tire"));
                      off.setDescription(rs.getString("description"));
                      off.setResponsiblilties(rs.getString("responsibilities"));
                      off.setEduxp(rs.getString("eduxp"));
                      off.setExpire(rs.getDate("expire"));
                      off.setCategorie(rs.getString("categorie"));
                      off.setType(rs.getString("type"));
                      off.setSalairemin(rs.getInt("salairemib"));
                      off.setSalairemax(rs.getInt("salairemax"));
                      off.setExp(rs.getString("exp"));
                      off.setQualification(rs.getString("qualification"));
                      off.setSex(rs.getString("sex"));
                      off.setCity(rs.getString("city"));   
                      off.setCreated_at(rs.getDate("created_at"));
                      }
                  
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      return off;
    
    }
    
    
    public void SupprimerOffre(int id){
    String sql = "DELETE from offre where id= '"+id+"' "; 
        try{
           Statement st= mc.createStatement();
           st.executeUpdate(sql);
           System.out.println("Offre supprimée avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }
             
    public void modifierOffre(Offre off){
  
       
       
       try{      
           String test ="UPDATE offre SET titre=?, description=?, exp=?,responsibilities=?,eduxp=? ,expire=?, type=?, salairemin=?,salairemax=?,qualification=?,sex=?,city=?,categorie=? WHERE id=?";
       ste= mc.prepareStatement(test);
           
           ste.setString(1, off.getTitre());
           ste.setString(2,off.getDescription());
           ste.setString(3,off.getExp());
           ste.setString(4,off.getResponsiblilties());
           ste.setString(5, off.getEduxp());
           ste.setDate(6,off.getExpire());
           ste.setString(7, off.getType());
           ste.setInt(8, off.getSalairemin());
           ste.setInt(9, off.getSalairemax());
           ste.setString(10, off.getQualification());
           ste.setString(11, off.getSex());
           ste.setString(12, off.getCity());
           ste.setString(13, off.getCategorie());
           ste.setInt(14, off.getUser_id());
           
       
                ste.executeUpdate();
           System.out.println(" offre modifiée avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
       
       
       
       
       
    }
    
}
