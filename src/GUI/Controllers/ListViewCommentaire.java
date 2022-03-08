/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controllers;



import javafx.scene.control.ListCell;
import pidev.entities.Commentaire;

/**
 *
 * 
 */
public class ListViewCommentaire extends ListCell<Commentaire> {
    
    
     @Override
     public void updateItem(Commentaire e, boolean empty)
    {
        super.updateItem(e,empty);
        if(e != null)
        {
            
            CommentItemController data = new CommentItemController();
            data.setInfo(e);
            setGraphic(data.getBox());
        }
    }
    
}
