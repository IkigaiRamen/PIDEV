/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pidev.Connexion;


public class ImagesServices {
         Connection mc;
        PreparedStatement ste;
    
            public ImagesServices(){
             mc=Connexion.getInstance().getMyConnection();
}
            public void updateImg (InputStream img,int id,int length) throws SQLException{
                
                    String query ="update developpeur set imageprofile=? where id= "+id;
                    ste= mc.prepareStatement(query);
                    ste.setBinaryStream(1,img,length);
                    ste.setInt(2, id);
                    ste.executeUpdate();
                    
                }
            }

