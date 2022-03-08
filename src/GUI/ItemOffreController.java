/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import pidev.entities.Offre;
import pidev.services.OffreServices;

/**
 * FXML Controller class
 *
 * @author khale
 */
public class ItemOffreController implements Initializable {

    @FXML
    private Label Titre;
    @FXML
    private Label Poste;
    @FXML
    private Label Salaire;
    @FXML
    private Label datelimite;
    @FXML
    private ImageView img1 ;
    @FXML
    private ImageView img2 ;
    @FXML
    private Button btn1 ;
    @FXML
    private Button btn2 ;
    OffreServices os = new OffreServices();
    private Offre o;
    ObservableList<Offre> list = FXCollections.observableArrayList(os.afficherOffre());
    int id ;
    public static int i;
    /**
     * Initializes the controller class.
     */
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LesOffresController mdc = new LesOffresController();
        
        int i=mdc.returnX();
       System.out.println("cest un test");
        o=list.get(i-1);
        id=o.getId();
        
        Titre.setText(o.getTitre());
        Titre.setWrapText(false);
        Poste.setText(o.getPosition());
        Poste.setWrapText(false);
        Salaire.setText(String.valueOf(o.getSalaire()));
        Salaire.setWrapText(false);
        //datelimite.setText(o.getDateFin().toString());
       // Poste.setWrapText(false);
        System.out.println("this is a test");
        
    }    

    public void setO(Offre o) {
        this.o = o;
    }

    public Offre getO() {
        return o;
    }

    public static int getI() {
        return i;
    }
    
    
    
    
    
    
    
}
