/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pidev.Connexion;
import pidev.entities.ReponseEntity;

/**
 *
 * @author zewaf
 */
public class ReponseService {
    Connection mc = Connexion.getInstance().getMyConnection();
    
    
    public void ajouterReponse(ReponseEntity c){
        final String INSERT_QUERY = "INSERT INTO reponse (`idUser`,`idTest`,`idChoix`) VALUES (?,?,?)";
        try{
            
            PreparedStatement statement = mc.prepareStatement(INSERT_QUERY);
            statement.setInt(1, c.getIdUser());
            statement.setInt(2, c.getIdTest());
            statement.setInt(3, c.getIdChoix());
            statement.executeUpdate();
            System.out.println("Reponse Ajoutée");
            
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }       
        public Integer ModifierReponse(ReponseEntity c){

        final String UPDATE_QUERY = "UPDATE reponse SET idUser='" + c.getIdUser()+ 
                "', idTest='" + c.getIdTest()+
                "', idChoix='" + c.getIdChoix() +
                "' where idReponse=" + c.getIdReponse();
        try{
            PreparedStatement statement = mc.prepareStatement(UPDATE_QUERY);
            int count = statement.executeUpdate();
            if(count == 0){
                System.out.println("Modification echoué");
            }else{
                System.out.println("Reponse modifiée avec succes");
                return c.getIdReponse();
            }
                
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
        
    public void supprimerReponse(int id){
        final String DELETE_QUERY = "delete from reponse where idReponse=?";
        try{
            PreparedStatement statement = mc.prepareStatement(DELETE_QUERY);
            statement.setInt(1,id);
            int count = statement.executeUpdate();
            if(count == 0){
                System.out.println("suppression echouée");
            }else
                System.out.println("Reponse supprimé avec succes");                
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }            
    }
    
    public ReponseEntity getByIdReponse(int id){
        final String SELECT_QUERY = "select * from reponse where idReponse=?";
        ReponseEntity r = null;
        try{
            PreparedStatement statement = mc.prepareStatement(SELECT_QUERY);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                r = new ReponseEntity();
                r.setIdReponse(rs.getInt("idReponse"));
                r.setIdUser(rs.getInt("idUser"));
                r.setIdTest(rs.getInt("idTest"));
                r.setIdChoix(rs.getInt("idChoix"));
            }   
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        if(r == null)
            System.out.println("no choice found");
        return r;
    }
    public List<ReponseEntity> getAllReponse(){
        final String SELECT_QUERY = "select * from reponse";
        List<ReponseEntity> l = new ArrayList();
        try{
            PreparedStatement statement = mc.prepareStatement(SELECT_QUERY);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                ReponseEntity r = new ReponseEntity();
                r.setIdReponse(rs.getInt("idReponse"));
                r.setIdTest(rs.getInt("idUser"));
                r.setIdTest(rs.getInt("idTest"));
                r.setIdChoix(rs.getInt("idChoix"));
                l.add(r);
            }              
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return l;
    }
        public List<ReponseEntity> getByUserAndTest(int idUser, int idQuestion){
        final String SELECT_QUERY = "select * from reponse where idQuestion=? and idUser=?";
        List<ReponseEntity> l = new ArrayList();
        try{
            PreparedStatement statement = mc.prepareStatement(SELECT_QUERY);
            statement.setInt(1,idUser);
            statement.setInt(2,idQuestion);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                ReponseEntity r = new ReponseEntity();
                r.setIdReponse(rs.getInt("idReponse"));
                r.setIdTest(rs.getInt("idUser"));
                r.setIdTest(rs.getInt("idTest"));
                r.setIdChoix(rs.getInt("idChoix"));
                l.add(r);
            }              
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return l;
    }
}
