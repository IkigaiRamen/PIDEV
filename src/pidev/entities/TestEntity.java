/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.sql.Date;

/**
 *
 * @author zewaf
 */
public class TestEntity {
    private int idTest;
    private int userId;
    private String titre;
    private String type;
    private int maxScore;
    private int nbrTentative;
    private int duree;
    private Date dateCreation;
    private Date dateModification;
    //private int interview;

    public TestEntity() {
    }
   
    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public int getNbrTentative() {
        return nbrTentative;
    }

    public void setNbrTentative(int nbrTentative) {
        this.nbrTentative = nbrTentative;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Override
    public String toString() {
        return "TestEntity{" + "idTest=" + idTest + ", userId=" + userId + ", titre=" + titre + ", type=" + type + ", maxScore=" + maxScore + ", nbrTentative=" + nbrTentative + ", duree=" + duree + ", dateCreation=" + dateCreation + ", dateModification=" + dateModification + '}';
    }






    
    
}