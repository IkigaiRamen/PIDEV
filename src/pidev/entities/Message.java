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
public class Message {


  private  int id_message ;
  private  Date dateCreation ;
  private  Date dateModification ;
  private  String contenu ;

    public Message(int id_message, Date dateCreation, Date dateModification, String contenu) {
        this.id_message = id_message ;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
        this.contenu = contenu;
    }
        public int getId() {
        return id_message;
    }

    public void setId(int id_message) {
        this.id_message = id_message;
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

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id_message;
        hash = 71 * hash + Objects.hashCode(this.dateCreation);
        hash = 71 * hash + Objects.hashCode(this.dateModification);
        hash = 71 * hash + Objects.hashCode(this.contenu);
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
        final Message other = (Message) obj;
        if (this.id_message != other.id_message) {
            return false;
        }
        if (!Objects.equals(this.contenu, other.contenu)) {
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
        return "Message{" + "id=" + id_message + ", dateCreation=" + dateCreation + ", dateModification=" + dateModification + ", contenu=" + contenu + '}';
    }
    
    
    
}