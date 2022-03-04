/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controllers;
import java.io.IOException;
import pidev.services.DemandeServices;
import pidev.entities.DemandeTravail;
import java.net.URL;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Khammessi
 */
public class ItemController implements Initializable {
    int i;
    @FXML
    private Label idtitre;
    @FXML
    private HBox itemC;
    @FXML
    private Label idtype;
    @FXML
    private Label iddomaine;
    @FXML
    private Label offre;
    @FXML
    private Label idmodifier;
    DemandeTravail d;

    public DemandeTravail getD() {
        return d;
    }

    public void setD(DemandeTravail d) {
        this.d = d;
    }
    @FXML
    private void receiveData(MouseEvent event) {
  String title = this.d.getTitle();
  String type = this.d.getType();
}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
       DemandeServices ds=new DemandeServices();
     List <DemandeTravail> list =new ArrayList(ds.afficherDemande());
     
    
     idtitre.setText(d.getTitle());
     idtype.setText(d.getType());
     iddomaine.setText(d.getCategory());
     
     
     
     
    }    
    
}
