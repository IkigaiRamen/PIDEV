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
    

    public void ajouterSociete(Societe s){
        String sql = "insert into societe (description, adresse,categorie,id_Employeur) values (?,?,?,?)";
        try{
            ste = mc.prepareStatement(sql);
            ste.setString(1, s.getDescription());
            ste.setString(2, s.getAdresse());
            ste.setString(3, s.getCategorie());
            ste.setInt(4, s.getIdEmployeur());
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
                s.setIdEmployeur(rs.getInt("idEmployeur"));
                societes.add(s);
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return societes;
    }
    public void modifierSociete(int id, String description, String adresse, String categorie, int idEmployeur ){
        String sql= "UPDATE societe SET description '"+ description
                +"' , adresse '"+adresse
                +"' , categorie'"+ categorie
                +"' , idEmployeur '"+ idEmployeur
                +"' where id = "+ id;
        try{
            Statement st = mc.createStatement();
            st.executeUpdate(sql);
            System.out.println("Societe modifiee avec succes");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    public void supprimerSociete(int id){
        String sql ="DELETE FROM Societe where id="+id;
        
    }
}
