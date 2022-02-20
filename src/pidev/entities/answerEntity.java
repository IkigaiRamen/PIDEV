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
public class answerEntity {
    private Long idAnswer;
    private boolean correct;
    private Date dateCreation;
    private Date dateModification;
    private QuestionEntity question;
    //private QuizzEntity quizz;
}
