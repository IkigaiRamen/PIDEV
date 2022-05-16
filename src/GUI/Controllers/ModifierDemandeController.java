/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controllers;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
    import pidev.entities.Demande;
import pidev.services.DemandeServices;

/**
 * FXML Controller class
 *
 * @author Khammessi
 */
public class ModifierDemandeController implements Initializable {

   
    @FXML
    private TextField txttitle;
    @FXML
    private TextField txtsalairemin;
    @FXML
    private TextField txtsalairemax;   
    @FXML
    private TextField txtlocation;
    @FXML
    private TextArea txtdescription;
    @FXML
    private ChoiceBox<String> txtcategorie;
    @FXML
    public ChoiceBox<String> txtcity;
    @FXML
    private ChoiceBox<String> txttype;
    @FXML
    private ChoiceBox<String> txtexp;
    @FXML
    private ChoiceBox<String> txtqualification;
    @FXML
    private ChoiceBox<String> txtsex;
    @FXML
    private DatePicker txtdate;
    
   private final String[] typecat ={"Domaine","Administrateur/Administratrice de base de données" ,
                    "Administrateur/Administratrice de réseau",
                    "Architecte des systèmes d 'information",
                    "Architecte réseau", "Chef/Cheffe de projet informatique", 
                    "Consultant/Consultante en système d'information",
                    "Développeur/Développeuse informatique",
                    "Expert/Experte en sécurité informatique",
                    "Formateur/Formatrice en informatique",
                    "Gestionnaire de parc micro-informatique",
                    "Hot liner",
                    "Informaticien industriel/Informaticienne industrielle",
                    "Ingénieur/Ingénieure cloud computing",
                    "Ingénieur/Ingénieure en métrologie",
                    "Ingénieur/Ingénieure système",
                    "Ingénieur/Ingénieure télécoms et réseaux",
                    "Technicien/Technicienne de maintenance en informatique",
                    "Technicien/Technicienne télécoms et réseaux",
                    "Testeur/Testeuse","Testeur/Testeuse"};
    private final String[] typecity ={"Afghanistan" ,
                "Åland Islands" ,
                "Albania" ,
                "Algeria" ,
                "American Samoa" ,
                "Andorra" ,
                "Angola" ,
                "Anguilla" ,
                "Antarctica" ,
                "Antigua and Barbuda" ,
                "Argentina" ,
                "Armenia" ,
                "Aruba" ,
                "Australia" ,
                "Austria" ,
                "Azerbaijan" ,
                "Bahamas" ,
                "Bahrain" ,
                "Bangladesh" ,
                "Barbados" ,
                "Belarus" ,
                "Belgium" ,
                "Belize" ,
                "Benin" ,
                "Bermuda" ,
                "Bhutan" ,
                "Bolivia" ,
                "Bosnia and Herzegovina" ,
                "Botswana" ,
                "Bouvet Island" ,
                "Brazil" ,
                "British Indian Ocean Territory" ,
                "Brunei Darussalam" ,
                "Bulgaria" ,
                "Burkina Faso" ,
                "Burundi" ,
                "Cambodia" ,
                "Cameroon" ,
                "Canada" ,
                "Cape Verde" ,
                "Cayman Islands" ,
                "Central African Republic" ,
                "Chad" ,
                "Chile" ,
                "China" ,
                "Christmas Island" ,
                "Cocos (Keeling) Islands" ,
                "Colombia" ,
                "Comoros" ,
                "Congo" ,
                "Congo, The Democratic Republic of The" ,
                "Cook Islands" ,
                "Costa Rica" ,
                "Cote D ivoire" ,
                "Croatia" ,
                "Cuba" ,
                "Cyprus" ,
                "Czechia" ,
                "Denmark" ,
                "Djibouti" ,
                "Dominica" ,
                "Dominican Republic" ,
                "Ecuador" ,
                "Egypt" ,
                "El Salvador" ,
                "Equatorial Guinea" ,
                "Eritrea" ,
                "Estonia" ,
                "Ethiopia" ,
                "Falkland Islands (Malvinas)" ,
                "Faroe Islands" ,
                "Fiji" ,
                "Finland" ,
                "France" ,
                "French Guiana" ,
                "French Polynesia" ,
                "French Southern Territories" ,
                "Gabon" ,
                "Gambia" ,
                "Georgia" ,
                "Germany" ,
                "Ghana" ,
                "Gibraltar" ,
                "Greece" ,
                "Greenland" ,
                "Grenada" ,
                "Guadeloupe" ,
                "Guam" ,
                "Guatemala" ,
                "Guernsey" ,
                "Guinea" ,
                "Guinea-bissau" ,
                "Guyana" ,
                "Haiti" ,
                "Heard Island and Mcdonald Islands" ,
                "Holy See (Vatican City State)" ,
                "Honduras" ,
                "Hong Kong" ,
                "Hungary" ,
                "Iceland" ,
                "India" ,
                "Indonesia" ,
                "Iran, Islamic Republic of" ,
                "Iraq" ,
                "Ireland" ,
                "Isle of Man" ,
                "Israel" ,
                "Italy" ,
                "Jamaica" ,
                "Japan" ,
                "Jersey" ,
                "Jordan" ,
                "Kazakhstan" ,
                "Kenya" ,
                "Kiribati" ,
                "Korea, Democratic People s Republic of" ,
                "Korea, Republic of" ,
                "Kuwait" ,
                "Kyrgyzstan" ,
                "Lao People s Democratic Republic" ,
                "Latvia" ,
                "Lebanon" ,
                "Lesotho" ,
                "Liberia" ,
                "Libyan Arab Jamahiriya" ,
                "Liechtenstein" ,
                "Lithuania" ,
                "Luxembourg" ,
                "Macao" ,
                "Macedonia, The Former Yugoslav Republic of" ,
                "Madagascar" ,
                "Malawi" ,
                "Malaysia" ,
                "Maldives" ,
                "Mali" ,
                "Malta" ,
                "Marshall Islands" ,
                "Martinique" ,
                "Mauritania" ,
                "Mauritius" ,
                "Mayotte" ,
                "Mexico" ,
                "Micronesia, Federated States of" ,
                "Moldova, Republic of" ,
                "Monaco" ,
                "Mongolia" ,
                "Montenegro" ,
                "Montserrat" ,
                "Morocco" ,
                "Mozambique" ,
                "Myanmar" ,
                "Namibia" ,
                "Nauru" ,
                "Nepal" ,
                "Netherlands" ,
                "Netherlands Antilles" ,
                "New Caledonia" ,
                "New Zealand" ,
                "Nicaragua" ,
                "Niger" ,
                "Nigeria" ,
                "Niue" ,
                "Norfolk Island" ,
                "Northern Mariana Islands" ,
                "Norway" ,
                "Oman" ,
                "Pakistan" ,
                "Palau" ,
                "Palestinian Territory, Occupied" ,
                "Panama" ,
                "Papua New Guinea" ,
                "Paraguay" ,
                "Peru" ,
                "Philippines" ,
                "Pitcairn" ,
                "Poland" ,
                "Portugal" ,
                "Puerto Rico" ,
                "Qatar" ,
                "Reunion" ,
                "Romania" ,
                "Russian Federation" ,
                "Rwanda" ,
                "Saint Helena" ,
                "Saint Kitts and Nevis" ,
                "Saint Lucia" ,
                "Saint Pierre and Miquelon" ,
                "Saint Vincent and The Grenadines" ,
                "Samoa" ,
                "San Marino" ,
                "Sao Tome and Principe" ,
                "Saudi Arabia" ,
                "Senegal" ,
                "Serbia" ,
                "Seychelles" ,
                "Sierra Leone" ,
                "Singapore" ,
                "Slovakia" ,
                "Slovenia" ,
                "Solomon Islands" ,
                "Somalia" ,
                "South Africa" ,
                "South Georgia and The South Sandwich Islands" ,
                "Spain" ,
                "Sri Lanka" ,
                "Sudan" ,
                "Suriname" ,
                "Svalbard and Jan Mayen" ,
                "Swaziland" ,
                "Sweden" ,
                "Switzerland" ,
                "Syrian Arab Republic" ,
                "Taiwan, Province of China" ,
                "Tajikistan" ,
                "Tanzania, United Republic of" ,
                "Thailand" ,
                "Timor-leste" ,
                "Togo" ,
                "Tokelau" ,
                "Tonga" ,
                "Trinidad and Tobago" ,
                "Tunisia" ,
                "Turkey" ,
                "Turkmenistan" ,
                "Turks and Caicos Islands" ,
                "Tuvalu" ,
                "Uganda" ,
                "Ukraine" ,
                "United Arab Emirates" ,
                "United Kingdom" ,
                "United States" ,
                "United States Minor Outlying Islands" ,
                "Uruguay" ,
                "Uzbekistan" ,
                "Vanuatu" ,
                "Venezuela" ,
                "Viet Nam" ,
                "Virgin Islands, British" ,
                "Virgin Islands, U.S." ,
                "Wallis and Futuna" ,
                "Western Sahara" ,
                "Yemen" ,
                "Zambia" ,
                "Zimbabwe" ,};
    private final String[] typetype ={"A plein temps","A temps Partiel","Freelance","Permenant"};
    private final String[] typeexp ={"Experience","Moins d un an","2 Années","3 Années","4 Années","Plus que 5 ans"};
    private final String[] typequal ={"Qualification","Immatriculation","Intérmediare","Diplomé"};
    private final String[] typesex ={"Choisir votre sexe ","Homme","Femme"};


    Demande d ;
    int id;
    @FXML
    private Button btnvalider;
    @FXML
    private Button retour;
    @FXML
    private TextArea descs;
    @FXML
    private ImageView profilimg;
    @FXML
    private Button btn_Acceuil;
    @FXML
    private Button btn_Messagerie;
    @FXML
    private Button btn_Profile;
    @FXML
    private Button btn_listOffre;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    ItemController item= new ItemController();
    int id=item.getId();
    DemandeServices ds = new DemandeServices();
    d= ds.afficherDemandeById(id);     
    System.out.println(d.toString());
      
        txttitle.setText(d.getTitre());
        txtsalairemin.setText(String.valueOf(d.getSalairemin()));
        txtsalairemax.setText(String.valueOf(d.getSalairemax()));   
        txtlocation.setText(d.getLocation());
        txtdescription.setText(d.getDescription());
        txtdate.setValue(d.getExpire().toLocalDate());
    
        txtcategorie.getItems().addAll(typecat);
        txtcity.getItems().addAll(typecity);
        txttype.getItems().addAll(typetype);
        txtexp.getItems().addAll(typeexp);
        txtqualification.getItems().addAll(typequal);
        txtsex.getItems().addAll(typesex);
        
        
        txtcategorie.setValue(d.getCategorie());
        txtcity.getSelectionModel().setSelect
        txttype
        txtexp
        txtqualification
        txtsex        
       // Date mockdate=d.getDateFin();
       // LocalDate ld = convert(mockdate);
        //dateFin.setValue(ld);
    }    
    
  



    @FXML
    private void Retour(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/Home.fxml"));
            retour.getScene().setRoot(root);
         } catch (IOException ex) {
          //   Logger.getLogger(AjoutDemandeController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
        
    

    

    @FXML
    private void modifierDemande(ActionEvent event) throws ParseException {
    ItemController item= new ItemController();
    int iddemande=item.getId();
    String titre=txttitle.getText();
    String description=txtdescription.getText();
    String type=txttype.getSelectionModel().getSelectedItem();
    String exp=txtexp.getSelectionModel().getSelectedItem();
    String cats=txtcategorie.getSelectionModel().getSelectedItem();
    String city=txtcity.getSelectionModel().getSelectedItem();
    String Qual=txtqualification.getSelectionModel().getSelectedItem();
    String sex =txtsex.getSelectionModel().getSelectedItem();
    int salairemin= Integer.parseInt(txtsalairemin.getText());
    int salairemax= Integer.parseInt(txtsalairemax.getText());
    String location= txtlocation.getText();
    java.sql.Date date=java.sql.Date.valueOf(txtdate.getValue());
    
  Demande dmock= new Demande(iddemande,22,titre,exp,  type,description,  Qual,  city,  sex,  cats,  location, salairemin, salairemax, date);
    DemandeServices ds=new DemandeServices();
    System.out.println("id number" +id);        
    ds.updateDemande(dmock);
      try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/Home.fxml"));
            retour.getScene().setRoot(root);
         } catch (IOException ex) {
    
    }
      
 
    }
      @FXML
    private void Acceuil(ActionEvent event) throws IOException {
        
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/AjouterDemande.fxml"));
            btn_Acceuil.getScene().setRoot(root);
    }

    @FXML
    private void Messagerie(ActionEvent event) throws IOException {
       /*   Parent root = FXMLLoader.load(getClass().getResource("/ChatUI/ListDiscussion.fxml"));
            btn_Acceuil.getScene().setRoot(root);*/
    }

    @FXML
    private void Profile(ActionEvent event) throws IOException {
        /*  Parent root = FXMLLoader.load(getClass().getResource("/GUI/AjouterDemande.fxml"));
            btn_Acceuil.getScene().setRoot(root);*/
    }

    @FXML
    private void Demandes(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("/GUI/Home.fxml"));
            btn_Acceuil.getScene().setRoot(root);
    }

    @FXML
    private void Certificat(ActionEvent event) throws IOException {
         /* Parent root = FXMLLoader.load(getClass().getResource("/GUI/AjouterDemande.fxml"));
            btn_Acceuil.getScene().setRoot(root);*/
    }
}

