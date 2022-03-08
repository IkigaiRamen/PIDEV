/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatUI;

import ChatUI.ListeDiscussionCell;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import pidev.entities.Developpeur;
import pidev.entities.Discussion;
import pidev.entities.Employeur;
import pidev.entities.Role;
import pidev.entities.UserSession;
import pidev.services.DeveloppeurService;
import pidev.services.DiscussionService;
import pidev.services.EmployeurService;

/**
 * FXML Controller class
 *
 * @author khoualdi koussay
 */
public class ListeDiscussionController implements Initializable {

    @FXML
    private Button btn_Acceuil;
    @FXML
    private Button btn_Messagerie;
    @FXML
    private Button btn_Profile;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btn_listOffre;
    @FXML
    private Button btn_listOffre1;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnSignout;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlOverview;
    @FXML
    private TextField txtSearch;
    @FXML
    private ListView<Discussion> table;
    @FXML
    private Button mod;
    @FXML
    private Button sup;
    @FXML
    private Button aff;

    /**
     * Initializes the controller class.
     */
    
        ObservableList<Discussion> list ;
        String username= "duno";
        Role role = Role.Employeur;
    //String username=UserSession.userName;
    //Role role= UserSession.role;
    public static Discussion d;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               System.out.println(Role.Employeur.equals(role));

        if(Role.Employeur.equals(role)){
        
            try {
               
                EmployeurService es= new EmployeurService();
                Employeur em = es.getEmpByUserName(username);
                System.out.println(es.getDiscussions(em.getId()));
                table.setCellFactory(lv-> new ListeDiscussionCell());
                System.out.println( es.getEmpByUserName(username).getNom());
                List<String> l = new ArrayList();
                list= FXCollections.observableArrayList(es.getDiscussions(em.getId()));
                for(int i=0; i<list.size();i++){
                    l.add(String.valueOf(list.get(i).getIdDev()));
                }
                table.setItems(list);
            } catch (SQLException ex) {
                Logger.getLogger(ListeDiscussionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else {
            
            try {
               
                DeveloppeurService es= new DeveloppeurService();
                Developpeur em = es.getDevByUserName(username);
                System.out.println(es.getDiscussions(em.getId()));
                table.setCellFactory(lv-> new ListeDiscussionCell());
                System.out.println( es.getDevByUserName(username).getNom());
                List<String> l = new ArrayList();
                list= FXCollections.observableArrayList(es.getDiscussions(em.getId()));
                for(int i=0; i<list.size();i++){
                    l.add(String.valueOf(list.get(i).getIdDev()));
                }
                table.setItems(list);
            } catch (SQLException ex) {
                Logger.getLogger(ListeDiscussionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }    

    @FXML
    private void modif(ActionEvent event) {
    }

    @FXML
    private void deleteOffre(ActionEvent event) {
    }

    @FXML
    private void onclick_afficher(ActionEvent event) {
        d=table.getSelectionModel().getSelectedItem();
        DiscussionService ds= new DiscussionService();
        ds.creerDiscussion(d);
        ds.showDiscussion(d.getId());
    }
    
    
}