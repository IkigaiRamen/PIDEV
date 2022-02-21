/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import pidev.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pidev.entities.Role;
import pidev.entities.User;

/**
 *
 * @author eya
 */
public class UserService {
    Connection mc;
    PreparedStatement ste;
    

    public UserService() {
        mc=Connexion.getInstance().getMyConnection();
    }

    
    public void ajouterUser(User u){
        String sql ="insert into user(userName,email,password,nom,prenom,role) Values(?,?,?,?,?,?)";
        try {
            ste=mc.prepareStatement(sql);
            ste.setString(1, u.getUserName());
            ste.setString(2, u.getEmail());
            ste.setString(3, u.getPassword());
            ste.setString(4, u.getNom());
            ste.setString(5, u.getPrenom());
            ste.setString(6,u.role.name());
            ste.executeUpdate();
            System.out.println("User Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    public List<User> afficherUsers(){
        List<User> users = new ArrayList<>();
        String sql="select * from user";
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUserName(rs.getString("userName"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                u.setRole(Role.valueOf((rs.getString("role"))));
                
                users.add(u);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return users;
    }    
    public void modifierUser(int id,String email,String password, String nom,String prenom){
        String sql ="UPDATE user SET email '"+email
                +"', password '"+ password 
                +"', nom '"+ nom
                +"', prenom '" + prenom
                +"' where id="+ id ;
        try{
           Statement st= mc.createStatement();
           st.executeUpdate(sql);
           System.out.println(" User modifiée avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    } 
    
    public void supprimerUser(int id){
         String sql = "DELETE from user where id= '"+id+"' "; 
        try{
           Statement st= mc.createStatement();
           st.executeUpdate(sql);
           System.out.println("User supprimée avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
    }
    
    public User getUserByUserName(String userName){
        User user= new User();
        String sql="select * from user where userName='" + userName+ "'";
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setRole(Role.valueOf(rs.getString("role")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }
}
