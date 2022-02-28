/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

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
        // TODO code application logic here
 // con.getCnx();
     
     //-------------------------------- Commentaire -------------------------------------------------//
   // CommentaireService cs = new CommentaireService();
   //cs.ajouterCommentaire(new Commentaire("comm2","20-2-2022",2));

       // System.out.println(cs.afficherCommentaire());
     // CS.updateCommentaire( 3,"aa", "bbb"); 
      // CS.supprimerCommentaire(4); 
       
       
       
       //------------------------------ Post -------------------------------------------------//
       
       Post p= new Post("Post 2 ", "17-02-2022");
        PostService PS= new PostService();
       PS.ajouterPost(p);
        //PS.ajouterPost(p1); 
       // PS.ajouterPost(p2);
      //List<Post> liste_poste= PS.afficherPost(); 
      //PS.supprimerPost(2); 
     //PS.updatePost(2, "ner","20/08/2200"); 
     
        
          }
    
}
