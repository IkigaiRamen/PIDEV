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
import java.util.ArrayList;
import java.util.List;
import pidev.entities.User;

/**
 *
 * @author eya
 */
public class UserService {
    Connection mc;
    PreparedStatement ste;
    

    public UserService(Connection mc) {
        mc=Connexion.getInstance().getMyConnection();
    }
    public void ajouterUser(User u){    
        String sql ="insert into users(userName,email,password,nom,prenom) Values(?,?)";
        try {
            ste=mc.prepareStatement(sql);
            ste.setString(1, u.getUserName());
            ste.setString(2, u.getEmail());
            ste.setString(3, u.getPassword());
            ste.setString(4, u.getNom());
            ste.setString(5, u.getPrenom());
            ste.executeUpdate();
            System.out.println("User Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    public List<User> afficherPersonne(){
        List<User> personnes = new ArrayList<>();
        String sql="select * from personne";
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                User p = new User();
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                personnes.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return personnes;
    }    
    
}
