    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.io.File;
import java.nio.file.Path;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Khammessi
 */
public class DemandeTravail {
    int id;
    String title;
    String Category;
    String Description;
    String type;
    String location;
    float salaire;
    Date dateCréation;
    Date dateFin;
   
    //String cv;
    String etat = "true";

    public DemandeTravail() {
      
    }

    public DemandeTravail(int id, String title, String Description,String type , String category, String location,float salaire) {
        this.id = id;
        this.title = title;
        this.Description = Description;
        this.type=type;
        this.Category=category;
        this.location=location;
        this.salaire=salaire;
    }
    

    public DemandeTravail(String title, String Descrption ,String Category, String type, String location, float salaire,Date dateFin) {
        
        this.title = title;
        this.Description=Descrption;
        this.Category = Category;
        this.type = type;
        this.location = location;
        this.salaire = salaire;
        this.dateFin=dateFin;
       
       
    }
    
    public DemandeTravail(int id,String title, String Descrption ,String Category, String type, String location, float salaire,Date dateFin) {
        this.id=id;
        this.title = title;
        this.Description=Descrption;
        this.Category = Category;
        this.type = type;
        this.location = location;
        this.salaire = salaire;
        this.dateFin=dateFin;
       
       
    }



    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Date getDateCréation() {
        return dateCréation;
    }

    public void setDateCréation(Date dateCréation) {
        this.dateCréation = dateCréation;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
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
    
     public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }
    

   /* public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }
*/

    @Override
    public String toString() {
        return "DemandeTravail{" + "id=" + id + ", title=" + title + ", Category=" + Category + ", Description=" + Description + ", type=" + type + ", location=" + location + ", salaire=" + salaire + ", dateCr\u00e9ation=" + dateCréation + ", dateFin=" + dateFin + ", etat=" + etat + '}';
    }
  
    
    
    
    
    
    
    
}
