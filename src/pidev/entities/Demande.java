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
import pidev.services.DemandeServices;

/**
 *
 * @author Khammessi
 */
public class Demande {
    int id;
    int user_id;
    String titre;
    String exp;
    String type;
    String Description;
    String qualification;
    String city;
    String sex;
    String categorie;
    String location;
    int salairemin;
    int salairemax;
    Date created_at;
    java.sql.Date expire;

    public Demande ( int user_id, String titre, String exp, String type, String Description, String qualification, String city, String sex, String categorie, String location, int salairemin, int salairemax, java.sql.Date expire) {
        this.user_id = user_id;
        this.titre = titre;
        this.exp = exp;
        this.type = type;
        this.Description = Description;
        this.qualification = qualification;
        this.city = city;
        this.sex = sex;
        this.categorie = categorie;
        this.location = location;
        this.salairemin = salairemin;
        this.salairemax = salairemax;
        this.expire = expire;
    }

    public Demande(int id,int user_id, String titre, String exp, String type, String Description, String qualification, String city, String sex, String categorie, String location, int salairemin, int salairemax, java.sql.Date expire) {
        this.id = id;
        this.user_id = user_id;
        this.titre = titre;
        this.exp = exp;
        this.type = type;
        this.Description = Description;
        this.qualification = qualification;
        this.city = city;
        this.sex = sex;
        this.categorie = categorie;
        this.location = location;
        this.salairemin = salairemin;
        this.salairemax = salairemax;
        this.expire = expire;
    }

    public Demande() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSalairemin() {
        return salairemin;
    }

    public void setSalairemin(int salairemin) {
        this.salairemin = salairemin;
    }

    public int getSalairemax() {
        return salairemax;
    }

    public void setSalairemax(int salairemax) {
        this.salairemax = salairemax;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    @Override
    public String toString() {
        return "Demande{" + "id=" + id + ", user_id=" + user_id + ", titre=" + titre + ", exp=" + exp + ", type=" + type + ", Description=" + Description + ", qualification=" + qualification + ", city=" + city + ", sex=" + sex + ", categorie=" + categorie + ", location=" + location + ", salairemin=" + salairemin + ", salairemax=" + salairemax + ", created_at=" + created_at + ", expire=" + expire + '}';
    }

  
    
    
}

