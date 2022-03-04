/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import pidev.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pidev.Connexion;
import pidev.entities.Administrateur;
import pidev.entities.User;

/**
 *
 * @author eya
 */
public class AdminService {
    Connection mc;
    PreparedStatement ste;
    

    public AdminService() {
        mc=Connexion.getInstance().getMyConnection();
    }

    UserService us = new UserService();
    
    public void ajouterUser(Administrateur u){
        String sql ="insert into administrateur(userName,email,password,nom,prenom) Values(?,?,?,?,?)";
        try {
            ste=mc.prepareStatement(sql);
            ste.setString(1, u.getUserName());
            ste.setString(2, u.getEmail());
            ste.setString(3, u.getPassword());
            ste.setString(4, u.getNom());
            ste.setString(5, u.getPrenom());
            ste.executeUpdate();
            System.out.println("Admin Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    public List<User> afficherPersonne(){
        List<User> users = new ArrayList<>();
        String sql="select * from personne";
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                User p = new User();
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                users.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return users;
    }    
    public void modifierPassword(int id,String email,String password, String nom,String prenom){
        String sql ="UPDATE user SET email '"+email
                +"', password '"+ password 
                +"', nom '"+ nom
                +"', prenom '" + prenom
                +"' where id="+ id ;
        try{
           Statement st= mc.createStatement();
           st.executeUpdate(sql);
           System.out.println(" post modifiée avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    } 
    
    public void supprimerUser(int id){
         String sql = "DELETE from user where id= '"+id+"' "; 
        try{
           Statement st= mc.createStatement();
           st.executeUpdate(sql);
           System.out.println("Post supprimée avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
    }
    
}
