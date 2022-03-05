/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
    import pidev.entities.DemandeTravail;
import pidev.services.DemandeServices;

/**
 * FXML Controller class
 *
 * @author Khammessi
 */
public class ModifierDemandeController implements Initializable {

    @FXML
    private Button btnOverview;
    @FXML
    private Button btnOrders;
    @FXML
    private Button btnCustomers;
    @FXML
    private Button btnMenus;
    @FXML
    private Button btnPackages;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnSignout;
    @FXML
    private Pane pnlOverview;
    @FXML
    private TextField titreid;
    @FXML
    private TextField desc;
    @FXML
    private Button btnvalider1;
    @FXML
    private Button retour;
    @FXML
    private TextField sal;
    @FXML
    private TextField adr;
    @FXML
    private ChoiceBox<String> type;
    @FXML
    private ChoiceBox<String> cat;
    @FXML
    private DatePicker dateFin;
    @FXML
    private Button btnCV;
    private final String[] catC ={"Design","Front-end","Back-end","Intégrateur","Full-Stack","Mern"};
    private final String[] typeC ={"A plein temps","A temps Partiel","Freelance","Permenant"};
    DemandeTravail d ;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MesDemandesController mdc = new MesDemandesController();
        d=mdc.getD();
        type.getItems().addAll(typeC);
        cat.getItems().addAll(catC);
        titreid.setText(d.getTitle());
        cat.setValue(d.getCategory());
        type.setValue(d.getType());
        desc.setText(d.getDescription());
        adr.setText(d.getLocation());
        sal.setText(String.valueOf(d.getSalaire()));
       // Date mockdate=d.getDateFin();
       // LocalDate ld = convert(mockdate);
        //dateFin.setValue(ld);
    }    
    
  

    @FXML
    private void handleClicks(ActionEvent event) {
    }


    @FXML
    private void Retour(ActionEvent event) {
    }

    @FXML
    private void singleFileChooser(ActionEvent event) {
    }

    @FXML
    private void modifierDemande(ActionEvent event) {
    int ida=d.getId();
    String titre=titreid.getText();
    String description=desc.getText();
    String types=type.getSelectionModel().getSelectedItem();
    String cats=cat.getSelectionModel().getSelectedItem();
    Float salaire=Float.valueOf(sal.getText());
    String adresse= adr.getText();
    java.sql.Date date=java.sql.Date.valueOf(dateFin.getValue());
    
    DemandeTravail dmock= new DemandeTravail(ida,titre,description ,cats,types,adresse,salaire,date);
    DemandeServices ds=new DemandeServices();
    System.out.println(ida);        
    System.out.println(dmock.getDescription());
    System.out.println(dmock.getType());
    System.out.println(dmock.getCategory());
    System.out.println(dmock.getSalaire());
    System.out.println(dmock.getLocation());

    ds.updateDemande(dmock);
    
    }
 
}
