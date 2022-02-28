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
import pidev.entities.EvaluationEntity;

/**
 *
 * @author zewaf
 */
public class EvaluationService {
    Connection mc = Connexion.getInstance().getMyConnection();
    
    
    public void ajouterEvaluation(EvaluationEntity e){
        final String INSERT_QUERY = "INSERT INTO evaluation (`idUser`,`idTest`,`score`) VALUES (?,?,?)";
        try{
            
            PreparedStatement statement = mc.prepareStatement(INSERT_QUERY);
            statement.setInt(1, e.getIdUser());
            statement.setInt(2, e.getIdTest());
            statement.setInt(3, e.getScore());
            statement.executeUpdate();
            System.out.println("Evaluation Ajoutée");
            
            
        }catch(SQLException er){
            System.out.println(er.getMessage());
        }
    }       
        public Integer ModifierEvaluation(EvaluationEntity ev){

        final String UPDATE_QUERY = "UPDATE evaluation SET idUser='" + ev.getIdUser()+ 
                "', idTest='" + ev.getIdTest()+ "', score='" + ev.getScore()+ 
                "' where idEvaluation=" + ev.getIdEvaluation();
        try{
            PreparedStatement statement = mc.prepareStatement(UPDATE_QUERY);
            int count = statement.executeUpdate();
            if(count == 0){
                System.out.println("Modification echoué");
            }else{
                System.out.println("Reponse modifiée avec succes");
                return ev.getIdEvaluation();
            }
                
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
        
    public void supprimerEvaluation(int id){
        final String DELETE_QUERY = "delete from evaluation where idEvaluation=?";
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
    
    public EvaluationEntity getByIdEvaluation(int id){
        final String SELECT_QUERY = "select * from evaluation where idEvaluation=?";
        EvaluationEntity ev = null;
        try{
            PreparedStatement statement = mc.prepareStatement(SELECT_QUERY);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                ev = new EvaluationEntity();
                ev.setIdEvaluation(rs.getInt("idEvaluation"));
                ev.setIdTest(rs.getInt("idUser"));
                ev.setIdTest(rs.getInt("idTest"));
                ev.setScore(rs.getInt("score"));
            }   
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        if(ev == null)
            System.out.println("no evaluation found");
        return ev;
    }
    public List<EvaluationEntity> getAllEvaluation(){
        final String SELECT_QUERY = "select * from evaluation";
        List<EvaluationEntity> l = new ArrayList();
        try{
            PreparedStatement statement = mc.prepareStatement(SELECT_QUERY);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                EvaluationEntity ev = new EvaluationEntity();
                ev.setIdEvaluation(rs.getInt("idEvaluation"));
                ev.setIdTest(rs.getInt("idUser"));
                ev.setIdTest(rs.getInt("idTest"));
                ev.setScore(rs.getInt("score"));
                l.add(ev);
            }              
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return l;
    }
        public List<EvaluationEntity> getByUserAndTest(int idUser, int idQuestion){
        final String SELECT_QUERY = "select * from evaluation where idQuestion=? and idUser=?";
        List<EvaluationEntity> l = new ArrayList();
        try{
            PreparedStatement statement = mc.prepareStatement(SELECT_QUERY);
            statement.setInt(1,idUser);
            statement.setInt(2,idQuestion);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                EvaluationEntity ev = new EvaluationEntity();
                ev.setIdEvaluation(rs.getInt("idEvaluation"));
                ev.setIdTest(rs.getInt("idUser"));
                ev.setIdTest(rs.getInt("idTest"));
                ev.setScore(rs.getInt("score"));
                l.add(ev);
            }              
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return l;
    }
}
