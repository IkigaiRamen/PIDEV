/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

/**
 *
 * @author eya
 */
public class Societe {
    private int id;
    private String description;
    private String adresse;
    private String categorie;
    private int id_Employeur;

    public Societe() {
    }

    public Societe(String description, String adresse, String categorie, int idEmployeur) {
        this.description = description;
        this.adresse = adresse;
        this.categorie = categorie;
        this.id_Employeur = idEmployeur;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getIdEmployeur() {
        return id_Employeur;
    }

    public void setIdEmployeur(int idEmployeur) {
        this.id_Employeur = idEmployeur;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
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
        final Societe other = (Societe) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Societe{" + "id=" + id + ", description=" + description + ", adresse=" + adresse + ", categorie=" + categorie + '}';
    }
    
    
}
