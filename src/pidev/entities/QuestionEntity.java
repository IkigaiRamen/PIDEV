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
public class QuestionEntity {
    private int idQuestion;
    private TestEntity test;  //foreign
    private int score;
    private String enonce;
    private Date dateModification;
    private Date dateCreation;


    public QuestionEntity() {
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public TestEntity getTest() {
        return test;
    }

    public void setTest(TestEntity test) {
        this.test = test;
    }

    
    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
    public String toString() {
        return "QuestionEntity{" + "idQuestion=" + idQuestion + ", test=" + test + ", score=" + score + ", enonce=" + enonce + ", dateModification=" + dateModification + ", dateCreation=" + dateCreation + '}';
    }

    
    
    
}
