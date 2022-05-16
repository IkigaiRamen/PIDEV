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
    
    int id;
    int user_id;
    String titre;
    String Description;
    String responsiblilties;
    String eduxp;
    String exp;
    String type;
    String qualification;
    String city;
    String sex;
    String categorie;
    String autres;
    int salairemin;
    int salairemax;
    Date created_at;
    java.sql.Date expire;
   
    public Offre() {
    }

    public Offre(int user_id, String titre, String Description, String responsiblilties, String eduxp, String exp, String type, String qualification, String city, String sex, String categorie, int salairemin, int salairemax, Date created_at, Date expire) {
        this.user_id = user_id;
        this.titre = titre;
        this.Description = Description;
        this.responsiblilties = responsiblilties;
        this.eduxp = eduxp;
        this.exp = exp;
        this.type = type;
        this.qualification = qualification;
        this.city = city;
        this.sex = sex;
        this.categorie = categorie;
        this.salairemin = salairemin;
        this.salairemax = salairemax;
        this.created_at = created_at;
        this.expire = expire;
    }

    public Offre(int id, int user_id, String titre, String Description, String responsiblilties, String eduxp, String exp, String type, String qualification, String city, String sex, String categorie, int salairemin, int salairemax, Date created_at, Date expire) {
        this.id = id;
        this.user_id = user_id;
        this.titre = titre;
        this.Description = Description;
        this.responsiblilties = responsiblilties;
        this.eduxp = eduxp;
        this.exp = exp;
        this.type = type;
        this.qualification = qualification;
        this.city = city;
        this.sex = sex;
        this.categorie = categorie;
        this.salairemin = salairemin;
        this.salairemax = salairemax;
        this.created_at = created_at;
        this.expire = expire;
    }

    public Offre(int id, int user_id, String titre, String Description, String responsiblilties, String eduxp, String exp, String type, String qualification, String city, String sex, String categorie, String autres, int salairemin, int salairemax, Date created_at, Date expire) {
        this.id = id;
        this.user_id = user_id;
        this.titre = titre;
        this.Description = Description;
        this.responsiblilties = responsiblilties;
        this.eduxp = eduxp;
        this.exp = exp;
        this.type = type;
        this.qualification = qualification;
        this.city = city;
        this.sex = sex;
        this.categorie = categorie;
        this.autres = autres;
        this.salairemin = salairemin;
        this.salairemax = salairemax;
        this.created_at = created_at;
        this.expire = expire;
    }

    
    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return Description;
    }

    public String getResponsiblilties() {
        return responsiblilties;
    }

    public String getEduxp() {
        return eduxp;
    }

    public String getExp() {
        return exp;
    }

    public String getType() {
        return type;
    }

    public String getQualification() {
        return qualification;
    }

    public String getCity() {
        return city;
    }

    public String getSex() {
        return sex;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getAutres() {
        return autres;
    }

    

    public int getSalairemin() {
        return salairemin;
    }

    public int getSalairemax() {
        return salairemax;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getExpire() {
        return expire;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setResponsiblilties(String responsiblilties) {
        this.responsiblilties = responsiblilties;
    }

    public void setEduxp(String eduxp) {
        this.eduxp = eduxp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setAutres(String autres) {
        this.autres = autres;
    }


    public void setSalairemin(int salairemin) {
        this.salairemin = salairemin;
    }

    public void setSalairemax(int salairemax) {
        this.salairemax = salairemax;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }
    

    



  
  


    
    
    
    
    
    
    
}
