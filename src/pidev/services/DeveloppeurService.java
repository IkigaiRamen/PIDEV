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
import pidev.entities.Developpeur;
import pidev.entities.Discussion;
import pidev.entities.Role;
import pidev.entities.User;

/**
 *
 * @author eya
 */
public class DeveloppeurService {
    Connection mc;
    PreparedStatement ste;
    

    public DeveloppeurService() {
        mc=Connexion.getInstance().getMyConnection();
    }

    UserService us = new UserService();
    
    public void ajouterDeveloppeur(Developpeur d){
        String sql ="insert into developpeur(userName,email,password,nom,prenom,role,education,experience,bio,specialite) Values(?,?,?,?,?,?,?,?,?,?)";
        try {
            ste=mc.prepareStatement(sql);
            ste.setString(1, d.getUserName());
            ste.setString(2, d.getEmail());
            ste.setString(3, d.getPassword());
            ste.setString(4, d.getNom());
            ste.setString(5, d.getPrenom());
            ste.setString(6, d.role.name());
            ste.setString(7, d.getEducation());
            ste.setString(8, d.getExperience());
            ste.setString(9, d.getBio());
            ste.setString(10, d.getSpecialite());
            ste.executeUpdate();
            System.out.println("Developpeur Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        //Creation de user e
        User u= new User(d.getUserName(), d.getEmail(), d.getPassword(), d.getNom(), d.getPrenom());
        u.setRole(Role.Developpeur);
        us.ajouterUser(u);
    }
    public List<Developpeur> afficherDeveloppeur(){
        List<Developpeur> developpeurs = new ArrayList<>();
        String sql="select * from developpeur";
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                Developpeur d= new Developpeur();
                d.setId(rs.getInt("id"));
                d.setUserName(rs.getString("userName"));
                d.setEmail(rs.getString("email"));
                d.setPassword(rs.getString("password"));
                d.setNom(rs.getString("nom"));
                d.setPrenom(rs.getString("prenom"));
                d.setEducation(rs.getString("education"));
                d.setExperience(rs.getString("experience"));
                d.setBio(rs.getString("bio"));
                d.setSpecialite(rs.getString("specialite"));
                
                developpeurs.add(d);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return developpeurs;
    }    
        
         public List<Discussion> getDiscussions(int id) throws SQLException{
        String sql="Select * from discussion where idDeveloppeur=?";
        List<Discussion> discussions = new ArrayList();
        ste=mc.prepareStatement(sql);
        ste.setInt(1, id);
        ResultSet rs= ste.executeQuery();
        while(rs.next()){
            Discussion discussion = new Discussion();
            discussion.setId(rs.getInt("idD"));
            discussion.setIdDev(rs.getInt("idDeveloppeur"));
            discussion.setIdEmp(rs.getInt("idEmployeur"));
            discussions.add(discussion);
            }
        return discussions;
    }
    public void modifierDeveloppeur(int id,String email,String password, String nom,String prenom,String education, String experience,String bio,String specialite){
        String sql ="UPDATE developpeur SET email =?, password=?, nom=?,prenom=?, education=?, experience=?, bio=?, specialite=? where id=?";
        try{
            ste=mc.prepareStatement(sql);
            ste.setString(1, email);
            ste.setString(2, password);
            ste.setString(3, nom);
            ste.setString(4, prenom);
            ste.setString(5, education);
            ste.setString(6, experience);
            ste.setString(7, bio);
            ste.setString(8, specialite);
            ste.setInt(9, id);
            ste.executeUpdate();
            System.out.println(" Developpeur modifiée avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
        //Modification de user d
        String sql2 = "Select * from user where username=( Select username from developpeur where id="+ id+")";
        User user = new User();
        try {
            ste=mc.prepareStatement(sql2);
            ResultSet rs=ste.executeQuery(sql2);
            while(rs.next()){
                us.modifierUser(rs.getInt("id"), email, password, nom, prenom);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    } 
    
    public void supprimerDeveloppeur(int id){
        //Supprimer user d
        
        String sql2 = "Select id from user where username=( Select username from developpeur where id=?) ";
        
        try {
            ste=mc.prepareStatement(sql2);
            ste.setInt(1, id);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                us.supprimerUser(rs.getInt("id"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
         String sql = "DELETE from developpeur where id= '"+id+"' "; 
        try{
           Statement st= mc.createStatement();
           st.executeUpdate(sql);
           System.out.println("Developpeur supprimée avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
    }
    public Developpeur getDevByUserName(String username){
        String sql="Select * from developpeur where username=?";
        Developpeur d = new Developpeur();
        try{
            ste=mc.prepareStatement(sql);
            ste.setString(1, username);
            ResultSet rs= ste.executeQuery();
            while(rs.next()){
                d.setId(rs.getInt("id"));
                d.setUserName(username);
                d.setEmail(rs.getString("email"));
                d.setNom(rs.getString("nom"));
                d.setPrenom(rs.getString("prenom"));
                d.setPassword(rs.getString("password"));
                d.setSpecialite(rs.getString("specialite"));
                d.setBio(rs.getString("bio"));
                d.setExperience(rs.getString("experience"));
                d.setEducation(rs.getString("education"));
                d.setRole(Role.Developpeur);
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return d;
    }
    
    public Developpeur getDevById(int id) throws SQLException{
        String sql="Select * from developpeur where id=?";
        Developpeur d = new Developpeur();
        ste= mc.prepareStatement(sql);
        ste.setInt(1, id);
        ResultSet rs=ste.executeQuery();
        while(rs.next()){
            d.setId(rs.getInt("id"));
                d.setUserName("userName");
                d.setEmail(rs.getString("email"));
                d.setNom(rs.getString("nom"));
                d.setPrenom(rs.getString("prenom"));
                d.setPassword(rs.getString("password"));
                d.setSpecialite(rs.getString("specialite"));
                d.setBio(rs.getString("bio"));
                d.setExperience(rs.getString("experience"));
                d.setEducation(rs.getString("education"));
                d.setRole(Role.Developpeur);
        }
        return d;
    }
}
