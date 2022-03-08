/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pidev.Connexion;
import pidev.entities.Societe;
import java.util.List;

/**
 *
 * @author eya
 */
public class SocieteService {
    Connection mc;
    PreparedStatement ste;
    

    public SocieteService() {
        mc=Connexion.getInstance().getMyConnection();
    }
    

    public void ajouterSociete(Societe s, int idEmp){
        String sql = "insert into societe (nom,description, adresse,categorie,telephone,email,idEmployeur) values (?,?,?,?,?,?,?,?)";
        try{
            ste = mc.prepareStatement(sql);
            ste.setString(1, s.getNom());
            ste.setString(2, s.getDescription());
            ste.setString(3, s.getAdresse());
            ste.setString(4, s.getCategorie());
            ste.setString(5, s.getTelephone());
            ste.setString(6, s.getEmail());
            ste.setInt(7, idEmp);
            ste.executeUpdate();
            System.out.println("Societe Ajoute");
            
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public List<Societe> afficherSociete(){
        List<Societe> societes = new ArrayList<>();
        String sql="select * from societe";
        try{
            ste= mc.prepareStatement(sql);
            ResultSet rs= ste.executeQuery();
            while(rs.next()){
                Societe s = new Societe();
                s.setId(rs.getInt("id"));
                s.setDescription(rs.getString("description"));
                s.setAdresse(rs.getString("adresse"));
                s.setCategorie(rs.getString("categorie"));
                societes.add(s);
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return societes;
    }
    public void modifierSociete(int id, String description, String adresse, String categorie, String telephone, String email ){
        String sql ="UPDATE employeur SET email =?, description=?, adresse=?, categorie=?,telephone=?  where id=?";
        try{
            ste=mc.prepareStatement(sql);
            ste.setString(1, email);
            ste.setString(2, description);
            ste.setString(3, adresse);
            ste.setString(4, categorie);
            ste.setString(5, telephone);
            ste.setInt(6, id);
            ste.executeUpdate();
            System.out.println("Societe modifiee avec succes");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    public void supprimerSociete(int id){
        String sql ="DELETE FROM Societe where id="+id;
        try{
           ste= mc.prepareStatement(sql);
           ste.executeUpdate(sql);
           System.out.println("Societe supprimée avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
    }
}
