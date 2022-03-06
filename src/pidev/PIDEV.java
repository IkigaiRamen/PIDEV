/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import GUI.NewFXMain;
import GUI.NewFXnotMain;
import pidev.entities.Commentaire;
import pidev.entities.DemandeTravail;
import pidev.entities.Post;
import pidev.services.CommentaireService;
import pidev.services.DemandeServices;
import pidev.services.PostService;
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
        // TODO code application logic here
           TestService t = new TestService();
           NewFXnotMain.main(args);
        
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
    
        // TODO code application logic here
 // con.getCnx();


   /*CommentaireService cs = new CommentaireService();
  cs.ajouterCommentaire(new Commentaire("comm2","20-2-2022",1));*/

      //  System.out.println(cs.afficherCommentaire());

    // CommentaireService cs = new CommentaireService();
    //cs.ajouterCommentaire(new Commentaire("comm2","20-2-2022",2));

       // System.out.println(cs.afficherCommentaire());


    //cs.ajouterCommentaire(new Commentaire("comm2","20-2-2022",2));


     // CS.updateCommentaire( 3,"aa", "bbb"); 
      // CS.supprimerCommentaire(4); 
       
       
       
       //------------------------------ Post -------------------------------------------------//

     //PostService aa = new PostService();
     //aa.ajouterPost(new Post("aa","22-258745"));       // PostService PS= new PostService();

       // PostService PS= new PostService();
      // PS.ajouterPost(new Post("Post 2 ", "17-02-2022"));

        //PS.ajouterPost(p1); 
       // PS.ajouterPost(p2);
     // List<Post> liste_poste= PS.afficherPost(); 
      //PS.supprimerPost(2); 
     //PS.updatePost(2, "ner","20/08/2200"); 
     
    }
    
    

}