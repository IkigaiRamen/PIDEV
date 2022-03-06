/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

/**
 *
 
 */
public class Administrateur extends User{
    
    public Administrateur(String userName, String email, String password, String nom, String prenom) {
        super(userName, email, password, nom, prenom);
        this.role=Role.Administrateur;
    }

    
    
    
    
}
