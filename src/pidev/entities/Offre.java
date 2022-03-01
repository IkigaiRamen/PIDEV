/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author khaled
 */
public class Offre {
    
   private  int id ; 
   private String position ; 
   private String description ;
   private String condition ;
   private String education ;
   private String adresse ;
   private String mission ;
   private float salaire ; 
   private String etat ;
   private String dateCreation; 
   private String dateFin; 
   

    public Offre() {
    }

    public Offre(String position, String description, String condition, String education, 
            String adresse, String mission, float salaire, String etat, String dateCreation, String dateFin) {
        this.position = position;
        this.description = description;
        this.condition = condition;
        this.education = education;
        this.adresse = adresse;
        this.mission = mission;
        this.salaire = salaire;
        this.etat = etat;
        this.dateCreation = dateCreation;
        this.dateFin = dateFin;
    }

   


    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public String getDescription() {
        return description;
    }

    public String getCondition() {
        return condition;
    }

    public String getEducation() {
        return education;
    }

    public String getAdresse() {
        return adresse;
    }
    public String getMission() {
        return mission;
    }

    public float getSalaire() {
        return salaire;
    }

    public String getEtat() {
        return etat;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public String getDateFin() {
        return dateFin;
    }
       
     

    public void setId(int id) {
        this.id = id;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
     public void setMission(String mission) {
        this.mission = mission;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }
    
    
  

    @Override
    public String toString() {
        return "Offre{" + "id=" + id + ", position=" + position + ", description=" + description + ", condition=" + condition + ", education=" + education + ", adresse=" + adresse + ", mission=" + mission + ", salaire=" + salaire + ", etat=" + etat + ", dateCreation=" + dateCreation + ", dateFin=" + dateFin + '}';
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
        final Offre other = (Offre) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.salaire) != Float.floatToIntBits(other.salaire)) {
            return false;
        }
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.condition, other.condition)) {
            return false;
        }
        if (!Objects.equals(this.education, other.education)) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        if (!Objects.equals(this.mission, other.mission)) {
            return false;
        }
        if (!Objects.equals(this.etat, other.etat)) {
            return false;
        }
        if (!Objects.equals(this.dateCreation, other.dateCreation)) {
            return false;
        }
        if (!Objects.equals(this.dateFin, other.dateFin)) {
            return false;
        }
       
        return true;
    }

    


  
    
    
          
    
    
    
    
    
    
    
    
}
