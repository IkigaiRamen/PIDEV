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
import java.util.ArrayList;
import java.util.List;
import pidev.entities.Developpeur;
import pidev.entities.Employeur;

import pidev.entities.Role;
import pidev.entities.Societe;
import pidev.entities.User;
import pidev.entities.*;
import pidev.services.DeveloppeurService;
import pidev.services.EmployeurService;
import pidev.services.SocieteService;

import pidev.services.UserService;

/**
 *
 * @author Khammessi
 */
import java.util.ArrayList;
import java.util.List;
import pidev.entities.Commentaire;
import pidev.entities.Post;
import pidev.services.CommentaireService;
import pidev.services.PostService;

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
        // TODO code application logic here
 // con.getCnx();
     
     //-------------------------------- Commentaire -------------------------------------------------//
<<<<<<< Updated upstream
   // CommentaireService cs = new CommentaireService();
   //cs.ajouterCommentaire(new Commentaire("comm2","20-2-2022",2));

      //  System.out.println(cs.afficherCommentaire());
=======
     CommentaireService cs = new CommentaireService();
    //cs.ajouterCommentaire(new Commentaire("comm2","20-2-2022",2));

       // System.out.println(cs.afficherCommentaire());
<<<<<<< HEAD
<<<<<<< HEAD

  //con.getCnx();
     
     //-------------------------------- Commentaire -------------------------------------------------//
        /*Commentaire C1 = new Commentaire(1,"dina","20/11/1999");
        List<Commentaire> cs= new ArrayList<>();
        CommentaireService CS= new CommentaireService();
        CS.ajouterCommentaire(C1);
        // cs=CS.afficherCommentaire();
<<<<<<< HEAD
=======
=======
>>>>>>> Stashed changes
>>>>>>> parent of b345677 (main fixes)
=======
>>>>>>> Stashed changes
>>>>>>> parent of b345677 (main fixes)
>>>>>>> master
     // CS.updateCommentaire( 3,"aa", "bbb"); 
      // CS.supprimerCommentaire(4); 
       
       
       
       //------------------------------ Post -------------------------------------------------//
       
<<<<<<< Updated upstream
      // Post p= new Post("Post 2 ", "17-02-2022");
      // PostService PS= new PostService();
      // PS.ajouterPost(p);
=======
       
       // PostService PS= new PostService();
      // PS.ajouterPost(new Post("Post 2 ", "17-02-2022"));
>>>>>>> Stashed changes
        //PS.ajouterPost(p1); 
       // PS.ajouterPost(p2);
     // List<Post> liste_poste= PS.afficherPost(); 
      //PS.supprimerPost(2); 
     //PS.updatePost(2, "ner","20/08/2200"); 
     */
     /*User u1 = new User("ayachlibi", "ayachlibi@gmail.com", "123", "Chlibi", "aya");
        UserService userService = new UserService();
        userService.ajouterUser(u1);
        
          }
    
//}
<<<<<<< HEAD
<<<<<<< HEAD
    
    

    List<User> users = new ArrayList<>();
    
    */
     //test ajout
     UserService us= new UserService();
     Employeur e1 =new Employeur("RH","flanflan","flanfaln@gamil.com","235","flan","flan");
     EmployeurService es= new EmployeurService();
     //es.ajouterEmployeur(e1);
     Developpeur d1 = new Developpeur ("education", "experience","bio","specialite","login","mdp","email","nom","prenom");
     DeveloppeurService ds = new DeveloppeurService();
     /*     ds.ajouterDeveloppeur(d1);*/     Societe s1= new Societe("Societe", "description", "adresse", "categorie", 1);
     SocieteService ss= new SocieteService();
     //ss.ajouterSociete(s1);
     //test affichage
     //List<Employeur >employeurs = es.afficherEmployeur();
     //System.out.println(employeurs);
     //System.out.println(us.afficherUsers());
     //System.out.println(ss.afficherSociete());
//test delete 
    
    //ds.supprimerDeveloppeur(1);
     //ss.supprimerSociete(1);
     //es.supprimerEmployeur(1);
    User u=us.getUserByUserName("login");
       /* System.out.println(u);*/
    }
<<<<<<< HEAD

=======
}
=======
>>>>>>> parent of b345677 (main fixes)
=======
>>>>>>> parent of b345677 (main fixes)
>>>>>>> master
