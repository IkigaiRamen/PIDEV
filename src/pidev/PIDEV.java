/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import pidev.entities.QuestionEntity;
import pidev.entities.TestEntity;
import pidev.services.QuestionService;
import pidev.services.TestService;

/**
 *
 * @author Khammessi
 */
public class PIDEV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestService t = new TestService();
        
        ///test ajouter
        /*
        TestEntity q = new TestEntity();
        q.setDuree(60);
        q.setTitre("evaluation");
        q.setType("javaScript");
        q.setMaxScore(100);
        q.setNbrTentative(4);
        q.setUserId(5);
        t.ajouterTest(q);
        */
        
        //t.supprimerTest(1);
        
        //test modifier
        /*
        TestEntity q2 = new TestEntity();
        q2.setIdTest(3);
        q2.setDuree(60);
        q2.setTitre("certification modifié");
        q2.setType("java");
        q2.setMaxScore(100);
        q2.setNbrTentative(4);
        q2.setUserId(8);
        t.ModifierTest(q2);
*/
        //test getBYID
        //System.out.println(t.getByIdTest(3).toString());
        
        //test getAll
        //System.out.println(t.getAllTest().toString());
        
        //test getByType
        //System.out.println(t.getByTypeTest("java").toString());
        
        /////test Question//
        /*
        QuestionEntity q = new QuestionEntity();
        q.setEnonce("reponds moi maintenant ou pas de travail");
        q.setIdTest(3);
        QuestionService s2 = new QuestionService();
        s2.ajouterQuestion(q);
*/
    }
    
}
