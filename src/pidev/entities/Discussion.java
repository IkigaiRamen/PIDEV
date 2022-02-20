/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author khoualdi koussay
 */
public class Discussion {
    private  int id_discussion ;
    private  Date dateCreation ;
    private  Date dateModification ;

    public Discussion(int id_discussion, Date dateCreation, Date dateModification) {
        this.id_discussion = id_discussion;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
    }

    public int getId() {
        return id_discussion;
    }

    public void setId(int id_discussion) {
        this.id_discussion = id_discussion;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id_discussion;
        hash = 47 * hash + Objects.hashCode(this.dateCreation);
        hash = 47 * hash + Objects.hashCode(this.dateModification);
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
        final Discussion other = (Discussion) obj;
        if (this.id_discussion != other.id_discussion) {
            return false;
        }
        if (!Objects.equals(this.dateCreation, other.dateCreation)) {
            return false;
        }
        if (!Objects.equals(this.dateModification, other.dateModification)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Discussion{" + "id=" + id_discussion + ", dateCreation=" + dateCreation + ", dateModification=" + dateModification + '}';
    }
   
    
    
}
