/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

/**
 *
 * @author Khammessi
 */
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import pidev.Connexion;

/**
 *
 * @author moh
 */
public class DemandeMailing {
     private Connection mc;
    private Statement ste;

        
    public DemandeMailing() {
       
         mc=Connexion.getInstance().getMyConnection();

    }
    
    
      
             
    public static void mailing(String recipient) throws Exception{
     
    Properties prop = new Properties();
     final String  moncompteEmail = "Ram.Khammessi@esprit.tn";
    final String psw = "213JMT9532";
    prop.put ("mail.smtp.host","smtp.gmail.com");
     prop.put ("mail.smtp.port","587");
    prop.put ("mail.smtp.auth","true");
    prop.put ("mail.smtp.starttls.enable","true");
   
   
    
    Session ses = Session.getInstance(prop,new javax.mail.Authenticator(){
     
    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(moncompteEmail, psw);
    } 
    } ); 
    
    try {
        
        Message msg = new MimeMessage(ses);
        msg.setFrom(new InternetAddress(moncompteEmail));
        msg.setRecipient(Message.RecipientType.TO,new InternetAddress(recipient));
        msg.setSubject("information");
        msg.setContent("<h1> Bonjour Mr/Mme <h1>"
                + " <h2> Vous avez ajouter une nouvelle demande<h2>","text/html");
        
        Transport.send(msg);
        
    } catch(MessagingException ex) {
        Logger.getLogger(DemandeMailing.class.getName()).log(Level.SEVERE, null, ex);   
    }
   
}
     public static void mailing2(String recipient) throws Exception{
     
    Properties prop = new Properties();
     final String  moncompteEmail = "Ram.Khammessi@esprit.tn";
    final String psw = "213JMT9532";
    prop.put ("mail.smtp.host","smtp.gmail.com");
     prop.put ("mail.smtp.port","587");
    prop.put ("mail.smtp.auth","true");
    prop.put ("mail.smtp.starttls.enable","true");
   
   
    
    Session ses = Session.getInstance(prop,new javax.mail.Authenticator(){
     
    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(moncompteEmail, psw);
    } 
    } ); 
    
    try {
        
        Message msg = new MimeMessage(ses);
        msg.setFrom(new InternetAddress(moncompteEmail));
        msg.setRecipient(Message.RecipientType.TO,new InternetAddress(recipient));
        msg.setSubject("information");
        msg.setContent("<h1> Bonjour Mr/Mme <h1>"
                + " <h2> Vous avez ajouter un nouveu Offre<h2>","text/html");
        
        Transport.send(msg);
        
    } catch(MessagingException ex) {
        Logger.getLogger(DemandeMailing.class.getName()).log(Level.SEVERE, null, ex);   
    }
   
}
     
    public static void mailing3(String recipient) throws Exception
    {   
        Properties prop = new Properties();
        final String  moncompteEmail = "Ram.Khammessi@esprit.tn";
        final String psw = "213JMT9532";
        prop.put ("mail.smtp.host","smtp.gmail.com");
        prop.put ("mail.smtp.port","587");
        prop.put ("mail.smtp.auth","true");
        prop.put ("mail.smtp.starttls.enable","true");



        Session ses = Session.getInstance(prop,new javax.mail.Authenticator(){

        @Override
        protected PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication(moncompteEmail, psw);
        } 
        } ); 

        try {

            Message msg = new MimeMessage(ses);
            msg.setFrom(new InternetAddress(moncompteEmail));
            msg.setRecipient(Message.RecipientType.TO,new InternetAddress("faouez.marzouk@esprit.tn"));
            msg.setSubject("information");
            msg.setContent("<h1> Bonjour Mr/Mme <h1>"
                + " <h2> Vous avez ajouter une nouvelle demande<h2>","text/html");
            /*String content = "<h1> Bonjour Mr/Mme <h1>"
                    + " <h2>Felicitation Vous avez Réussi,</h2> <br>"
                    + "<h2> votre score est : " + score + "/" + nbrQuestion + "<h2>";
            msg.setContent(content,"text/html");*/

            Transport.send(msg);

        } catch(MessagingException ex) {
            Logger.getLogger(DemandeMailing.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }
}