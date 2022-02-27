    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.io.File;

/**
 *
 * @author Khammessi
 */
public class DemandeTravail {
    int id;
    String title;
    String Category;
    String type;
    String location;
    String salaire;
    String cv;
    boolean etat;

    public DemandeTravail() {
        this.etat = true;
    }
    

    public DemandeTravail(String title, String Category, String type, String location, String salaire, String cv) {
        this.etat = true;
        this.title = title;
        this.Category = Category;
        this.type = type;
        this.location = location;
        this.salaire = salaire;
        this.cv = cv;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalaire() {
        return salaire;
    }

    public void setSalaire(String salaire) {
        this.salaire = salaire;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

  
    
    
    
    
    
    
    
}
