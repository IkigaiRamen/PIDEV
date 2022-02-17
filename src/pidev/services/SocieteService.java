/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import pidev.Connexion;
import pidev.entities.Societe;

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
        String sql = "insert into societe ()";
    }

}
