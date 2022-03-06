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
import pidev.entities.Employeur;
import pidev.entities.Role;
import pidev.entities.User;

/**
 *
 * @author eya
 */
public class EmployeurService {
    Connection mc=Connexion.getInstance().getMyConnection();
    PreparedStatement ste;
    

          

    UserService us = new UserService();
    
    public void ajouterEmployeur(Employeur e){
        String sql ="insert into employeur(userName,email,password,nom,prenom,role,profession) Values(?,?,?,?,?,?,?)";
        try {
            ste=mc.prepareStatement(sql);
            ste.setString(1, e.getUserName());
            ste.setString(2, e.getEmail());
            ste.setString(3, e.getPassword());
            ste.setString(4, e.getNom());
            ste.setString(5, e.getPrenom());
            ste.setString(6, e.role.name());
            ste.setString(7, e.getProfession());
            ste.executeUpdate();
            System.out.println("Employeur Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        //Creation de user e
        User u= new User(e.getUserName(), e.getEmail(), e.getPassword(), e.getNom(), e.getPrenom());
        u.setRole(Role.Employeur);
        us.ajouterUser(u);
    }
    public List<Employeur> afficherEmployeur(){
        List<Employeur> employeurs = new ArrayList<>();
        String sql="select * from employeur";
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                Employeur e = new Employeur();
                e.setUserName(rs.getString("userName"));
                e.setEmail(rs.getString("email"));
                e.setPassword(rs.getString("password"));
                e.setNom(rs.getString("nom"));
                e.setPrenom(rs.getString("prenom"));
                e.setProfession(rs.getString("profession"));
                employeurs.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return employeurs;
    }    
    public void modifierEmployeur(int id,String email,String password, String nom,String prenom,String profession){
        String sql ="UPDATE employeur SET email '"+email
                +"', password '"+ password 
                +"', nom '"+ nom
                +"', prenom '" + prenom
                +"', profession '" + profession
                +"' where id="+ id ;
        try{
           Statement st= mc.createStatement();
           st.executeUpdate(sql);
           System.out.println(" Employeur modifiée avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
        //Modification de user e
        String sql2 = "Select * from user where username=( Select username from employeur where id= "+id+ ")";
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
    
    public void supprimerEmployeur(int id){
        //Supprimer user e
        
        String sql2 = "Select id from user where username=( Select username from employeur where id="+ id+")";
        try {
            ste=mc.prepareStatement(sql2);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                us.supprimerUser(rs.getInt("id"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
         String sql = "DELETE from employeur where id= '"+id+"' "; 
        try{
           Statement st= mc.createStatement();
           st.executeUpdate(sql);
           System.out.println("Employeur supprimée avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
    }
    public Employeur getEmpByUserName(String username){
        String sql="Select * from developpeur where username=?";
        Employeur e= new Employeur();
        try{
            ste=mc.prepareStatement(sql);
            ste.setString(1, username);
            ResultSet rs= ste.executeQuery();
            while(rs.next()){
                e.setId(rs.getInt("id"));
                e.setUserName(username);
                e.setEmail(rs.getString("email"));
                e.setNom(rs.getString("nom"));
                e.setPrenom(rs.getString("prenom"));
                e.setPassword(rs.getString("password"));
                e.setRole(Role.Employeur);
                e.setProfession(rs.getString("profession"));
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return e;
    }
 
}
