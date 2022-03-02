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
    Connection mc =Connexion.getInstance().getMyConnection();
    PreparedStatement ste;
    public void AjouterOffre(Offre off){
        try
        {
         String sql ="insert into offre(position,description,condition) values (?,?,?)";
            ste=mc.prepareStatement(sql);
             ste.setString(1,off.getPosition());
             ste.setString(2, off.getDescription());
             ste.setString(3, off.getCondition());
             
            // ste.setFloat(4, off.getSalaire());
            
             ste.executeUpdate();
           System.out.println("Offre Ajoutée");
        }
        catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        

            }

}
