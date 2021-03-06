/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author khaled
 */
public class Offre {
    
   private  int id ; 
   private String titre ;
   private String position ; 
   private String description ;
   private String education ;
   private String adresse ;
   private String mission ;
   private float salaire ; 
   private String etat ;
   private Date dateCreation; 
   private Date dateFin; 
   

    public Offre() {
    }

    public Offre(int id,String titre, String position, String description, String education, String adresse, String mission, float salaire, String etat ,Date dateFin) {
        this.id = id;
        this.titre= titre;
        this.position = position;
        this.description = description;
        this.education = education;
        this.adresse = adresse;
        this.mission = mission;
        this.salaire = salaire;
        this.etat = etat;
        this.dateFin = dateFin;
    }

    public Offre(String titre,String position, String description, String education, String adresse, String mission, float salaire, String etat, Date dateFin) {
        this.titre= titre;
        this.position = position;
        this.description = description;
        this.education = education;
        this.adresse = adresse;
        this.mission = mission;
        this.salaire = salaire;
        this.etat = etat;
        this.dateFin = dateFin;
    }

    public Offre(String position, String description, String education, String adresse, String mission, float salaire, String etat) {
        this.position = position;
        this.description = description;
        this.education = education;
        this.adresse = adresse;
        this.mission = mission;
        this.salaire = salaire;
        this.etat = etat;
    }
 

  
  
   


    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getPosition() {
        return position;
    }

    public String getDescription() {
        return description;
    }

    public String getEtat() {
        return etat;
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

    public Date getDateCreation() {
        return dateCreation;
    }

   
   
    public Date getDateFin() {
        return dateFin;
    }

    
     

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEtat(String etat) {
        this.etat = etat;
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

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

 
   

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    
  

  

  
    
    
          
    
    
    
    
    
    
    
    
}
