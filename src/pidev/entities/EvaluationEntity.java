/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

/**
 *
 * @author zewaf
 */
public class EvaluationEntity {
    private int idEvaluation;
    private int idUser;
    private TestEntity test;
    private int score;
    private int nbrQuestion;

    public EvaluationEntity() {
    }

    public int getIdEvaluation() {
        return idEvaluation;
    }

    public void setIdEvaluation(int idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public TestEntity getTest() {
        return test;
    }

    public void setTest(TestEntity test) {
        this.test = test;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNbrQuestion() {
        return nbrQuestion;
    }

    public void setNbrQuestion(int nbrQuestion) {
        this.nbrQuestion = nbrQuestion;
    }

    @Override
    public String toString() {
        return "EvaluationEntity{" + "idEvaluation=" + idEvaluation + ", idUser=" + idUser + ", idTest=" + test.getIdTest() + ", score=" + score + ", nbrQuestion=" + nbrQuestion + '}';
    }
    

    
    
    
}
