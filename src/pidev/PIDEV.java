/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import java.util.ArrayList;
import java.util.List;
import pidev.entities.Developpeur;
import pidev.entities.Employeur;

import pidev.entities.Role;
import pidev.entities.Societe;
import pidev.entities.User;
import pidev.services.DeveloppeurService;
import pidev.services.EmployeurService;
import pidev.services.SocieteService;

import pidev.services.UserService;

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
  //con.getCnx();
     
     //-------------------------------- Commentaire -------------------------------------------------//
        /*Commentaire C1 = new Commentaire(1,"dina","20/11/1999");
        List<Commentaire> cs= new ArrayList<>();
        CommentaireService CS= new CommentaireService();
        CS.ajouterCommentaire(C1);
        // cs=CS.afficherCommentaire();
     // CS.updateCommentaire( 3,"aa", "bbb"); 
      // CS.supprimerCommentaire(4); 
       
       
       
       //------------------------------ Post -------------------------------------------------//
       
       Post p1 = new Post(1,"aann","21/08/2000");
        Post p2 = new Post(2,"hjjhj","10/02/2020");
        PostService PS= new PostService();
        //PS.ajouterPost(p1); 
       // PS.ajouterPost(p2);
      //List<Post> liste_poste= PS.afficherPost(); 
      //PS.supprimerPost(2); 
     //PS.updatePost(2, "ner","20/08/2200"); 
     */
     /*User u1 = new User("ayachlibi", "ayachlibi@gmail.com", "123", "Chlibi", "aya");
        UserService userService = new UserService();
        userService.ajouterUser(u1);
        
          }
    
    List<User> users = new ArrayList<>();
    
    */
     //test ajout
     UserService us= new UserService();
     Employeur e1 =new Employeur("RH","flanflan","flanfaln@gamil.com","235","flan","flan");
     EmployeurService es= new EmployeurService();
     //es.ajouterEmployeur(e1);
     Developpeur d1 = new Developpeur ("education", "experience","bio","specialite","login","mdp","email","nom","prenom");
     DeveloppeurService ds = new DeveloppeurService();
     ds.ajouterDeveloppeur(d1);
     Societe s1= new Societe("Societe", "description", "adresse", "categorie", 1);
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
        System.out.println(u);
    }
}
