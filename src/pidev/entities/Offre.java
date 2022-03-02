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
       int idO;
       String position ;
       String description ;
       String condition ;
      // float salaire ;

    public Offre() {
    }

    public Offre(String position, String description, String condition) {
        this.position = position;
        this.description = description;
        this.condition = condition;
        //this.salaire = salaire;
    }

    public int getIdO() {
        return idO;
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

    //public float getSalaire() {
     //   return salaire;
  //  }

    public void setIdO(int idO) {
      this.idO = idO;
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

   // public void setSalaire(float salaire) {
     //   this.salaire = salaire;
    //}
      
    
       
    
}
