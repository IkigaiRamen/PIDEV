/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.io.InputStream;
import java.util.Objects;


public class Employeur extends User{
    
    private String profession;

    public InputStream getImg_sbp() {
        return img_sbp;
    }

    public void setImg_sbp(InputStream img_sbp) {
        this.img_sbp = img_sbp;
    }
    
    private InputStream img_sbp;


    private int id_Societe;
    
    public Employeur() {
    }

    public Employeur(String profession, String userName, String email, String password, String nom, String prenom) {
        super(userName, email, password, nom, prenom);
        this.profession = profession;
        this.role= Role.Employeur;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.profession);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employeur other = (Employeur) obj;
        if (!Objects.equals(this.profession, other.profession)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employeur{" + "profession=" + profession + '}';
    }

    public int getId_Societe() {
        return id_Societe;
    }

    public void setId_Societe(int id_Societe) {
        this.id_Societe = id_Societe;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    
}
