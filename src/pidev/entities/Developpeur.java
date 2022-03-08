/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.io.InputStream;
import java.util.Objects;

/**
 *
 * @author eya
 */

public class Developpeur extends User{
    private String education;
    private String experience;
    private String bio;
    private String specialite;
    private InputStream img_sbp;

    public InputStream getImg_sbp() {
        return img_sbp;
    }

    public void setImg_sbp(InputStream img_sbp) {
        this.img_sbp = img_sbp;
    }

    public Developpeur() {
    }

    public Developpeur(String education, String experience, String bio, String specificate, String userName, String email, String password, String nom, String prenom) {
        super(userName, email, password, nom, prenom);
        this.education = education;
        this.experience = experience;
        this.bio = bio;
        this.specialite = specificate;
        this.role= Role.Developpeur;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    @Override
    public String toString() {
        return "Developpeur{" + "education=" + education + ", experience=" + experience + ", bio=" + bio + ", specialite=" + specialite + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.education);
        hash = 23 * hash + Objects.hashCode(this.experience);
        hash = 23 * hash + Objects.hashCode(this.bio);
        hash = 23 * hash + Objects.hashCode(this.specialite);
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
        final Developpeur other = (Developpeur) obj;
        if (!Objects.equals(this.education, other.education)) {
            return false;
        }
        if (!Objects.equals(this.experience, other.experience)) {
            return false;
        }
        if (!Objects.equals(this.bio, other.bio)) {
            return false;
        }
        if (!Objects.equals(this.specialite, other.specialite)) {
            return false;
        }
        return true;
    }
    
}
