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
public class ChoixEntity {
    private int idChoix;
    //foreign key
    private int idQuestion;
    private boolean correct;
    private String contenu;

    public ChoixEntity() {
    }

    public int getIdChoix() {
        return idChoix;
    }

    public void setIdChoix(int idChoix) {
        this.idChoix = idChoix;
    }

    public String getContenu() {
        return contenu;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "ChoixEntity{" + "idChoix=" + idChoix + ", idQuestion=" + idQuestion + ", correct=" + correct + ", contenu=" + contenu + '}';
    }


    
    
}
