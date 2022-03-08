/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                    ste.executeUpdate();
                    
                }
            public InputStream getImg(int id) throws SQLException{
                InputStream img;
                int length;
            String query="select * from developpeur where id="+id;
            ste=mc.prepareStatement(query);
            ResultSet rs=ste.executeQuery();
            rs.next();
                img= rs.getBinaryStream("imageprofile");
            
            return img;
            }
            
            }

