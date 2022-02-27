package pidev;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Connexion {
    private static String url = "jdbc:Mysql://localhost:3306/pidev";
    private static String username = "root";
    private static String pwd="";
    public static Connexion m;
    
    Connection cnx;

    private Connexion() {
        try {
            cnx = DriverManager.getConnection(url, username, pwd);
                        System.out.print("Connexion Réussi \n");

        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }
    public static Connexion getInstance(){
    if (m==null)
        m= new Connexion();
    return m;
    }
    
    public Connection getMyConnection(){
    return cnx;
    }
}
