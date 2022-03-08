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

    PreparedStatement ste;
    
  Connection mc = Connexion.getInstance().getMyConnection();
      
    public void ajouterUser(User u){
        String sql ="insert into user(userName,email,password,nom,prenom,role) Values(?,?,?,?,?,?)";

        try {
            ste=mc.prepareStatement(sql);
            ste.setString(1, u.getUserName());
            ste.setString(2, u.getEmail());
            ste.setString(3, u.getPassword());
            ste.setString(4, u.getNom());
            ste.setString(5, u.getPrenom());
            ste.setString(6, u.getRole().toString());
            ste.executeUpdate();
            System.out.println("User Ajoutée");
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
    
    public String Login(String userName, String password) throws SQLException{
       String valid= null;
       String sql = "Select count(*) as total from user where username=? and password=?";
       ste= mc.prepareStatement(sql);
       ste.setString(1, userName);
       ste.setString(2, password);
       ResultSet rs=ste.executeQuery();
       rs.next();
       int doesitexist = rs.getInt("total");
       rs.close();
       if(doesitexist !=1){
           valid="user non valide";
       }
       else valid="user valide";
       
       return valid;
       
    }
    
    public User getUser(String username, String password) throws SQLException{
        User u= new User();
        String sql = "Select * from user where username=? and password=?";
        ste = mc.prepareStatement(sql);
        ste.setString(1, username);
        ste.setString(2, password);
        ResultSet rs= ste.executeQuery();
        while (rs.next()){
            u.setId(rs.getInt("id"));
            u.setUserName(rs.getString("userName"));
            u.setEmail(rs.getString("email"));
            u.setPassword(rs.getString("password"));
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
            u.setRole(Role.valueOf(rs.getString("role")));
        }
        return u;
    }
    
    public boolean VerifyEmail(String email) throws SQLException{
        boolean v;
        String sql = "Select count(*) total from user where email=?";
        ste = mc.prepareStatement(sql);
        ste.setString(1, email);
        ResultSet rs=ste.executeQuery();
       rs.next();
       int doesitexist = rs.getInt("total");
       rs.close();
        System.out.println(doesitexist);
       if(doesitexist !=1){
           v=false;
       }
       else v=true;
       
       return v; 
    }
    
    public String getEmail(String email) throws SQLException{
        String email1="";
        String sql="Select email fron user where email=?";
        ste= mc.prepareStatement(sql);
        ste.setString(1,email);
        ResultSet rs= ste.executeQuery();
        while (rs.next()){
            email1= rs.getString("email");
        }
        return email1;
    }
    
    public String md5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
            } catch (java.security.NoSuchAlgorithmException e) {
            }
    return null;
}
}

      

