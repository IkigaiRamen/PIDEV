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
         String sql ="insert into offre(position,description,salaire,etat,dateCreation,dateFin,mission,education,adresse) VALUES(?,?,?,?,?,?,?,?,?)";
         
         
         
         
         ste=mc.prepareStatement(sql);
           ste.setString(1, off.getPosition());
           ste.setString(2,off.getDescription());
           ste.setFloat(3,off.getSalaire());
           ste.setString(4, off.getEtat());
           ste.setDate(5,off.getDateCreation());
           ste.setDate(6,off.getDateFin());
           ste.setString(7,off.getMission());
           ste.setString(8,off.getEducation());
           ste.setString(9,off.getAdresse());
           
        
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
                      Offre off = new Offre();
                      off.setId(rs.getInt("id"));
                      off.setPosition(rs.getString("position"));
                      off.setDescription(rs.getString("description"));
                      off.setEducation(rs.getString("education"));
                      off.setAdresse(rs.getString("adresse"));
                      off.setMission(rs.getString("mission"));
                      off.setSalaire(rs.getFloat("salaire"));
                      off.setEtat(rs.getString("etat"));
                     
                      off.setDateFin(rs.getDate("dateFin"));
                      offre.add(off);
                      
                      System.out.println("ID : "+off.getId()+"\n Position : "+off.getPosition()+"\n Description : "+off.getDescription()+
                              "\n Education : "+off.getEducation()+"\n Adresse : "+off.getAdresse()+
                              "\n Mission : "+off.getMission()+"\n Salaire : "+off.getSalaire()+"\n Etat : "+off.getEtat()+"\n DateCreation : "
                              +off.getDateCreation()+"\n DateFin : "+off.getDateFin());
                      
                  }
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      return offre;
    
    }
    public Offre  afficherOffrebyId(int id){
        Offre off = new Offre();
      String sql="select * from offre where id= +id ";
      try
      {
          ste=mc.prepareStatement(sql);
          
          ResultSet rs=ste.executeQuery();
                  {
                     
                      off.setId(rs.getInt("id"));
                      off.setPosition(rs.getString("position"));
                      off.setDescription(rs.getString("description"));
                      off.setEducation(rs.getString("education"));
                      off.setAdresse(rs.getString("adresse"));
                      off.setMission(rs.getString("mission"));
                      off.setSalaire(rs.getFloat("salaire"));
                      off.setEtat(rs.getString("etat"));
                     
                      off.setDateFin(rs.getDate("dateFin"));
                      
                      
                     
                      
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
             
    public void modifierOffre(int id,String position,String description,String condition,String education,
            String adresse,String mission, float salaire, String etat,String dateCreation,String dateFin,String dateModification){
    String sql= "UPDATE offre SET position='"+position+"',description= '"+description+"',"
            + "education= '"+education+"',adresse= '"+adresse+"',mission= '"+mission+"',salaire= '"+salaire+"',etat= '"+etat+"',"
            + "dateCreation= '"+dateCreation+"',dateFin= '"+dateFin+"' where id='"+id+"'";
       
       try{
           Statement st= mc.createStatement();
           st.executeUpdate(sql);
           System.out.println(" Offre modifiée avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }
    
}
