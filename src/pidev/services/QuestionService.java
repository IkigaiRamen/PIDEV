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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pidev.Connexion;
import pidev.entities.QuestionEntity;

/**
 *
 * @author zewaf
 */
public class QuestionService {
    Connection mc = Connexion.getInstance().getMyConnection();
    
    
    public Integer ajouterQuestion(QuestionEntity q){
        final String INSERT_QUERY = "INSERT INTO question (`test`,`score`,`enonce`) VALUES (?,?,?)";
        try{
            
            PreparedStatement statement = mc.prepareStatement(INSERT_QUERY);
            statement.setInt(1, q.getTest().getIdTest());
            statement.setInt(2, q.getScore());
            statement.setString(3, q.getEnonce());
            statement.executeUpdate();
            System.out.println("Question Ajoutée");
            
            //return inserted id
            Statement statementId = mc.createStatement();
            ResultSet rsId = statementId.executeQuery("select LAST_INSERT_ID()");
            rsId.first();
            int insertedId = rsId.getInt(1);
            System.out.println("Question Ajouté" + " new id is : " + insertedId );
            return insertedId;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }       
        public Integer ModifierQuestion(QuestionEntity q){
            
            
        final String UPDATE_QUERY = "UPDATE question SET test='" + q.getTest().getIdTest()+ 
                "', score='" + q.getScore() + "', enonce='" + q.getEnonce()+
                "' where idQuestion=" + q.getIdQuestion();
        try{
            PreparedStatement statement = mc.prepareStatement(UPDATE_QUERY);
            int count = statement.executeUpdate();
            if(count == 0){
                System.out.println("Modification echoué");
            }else{
                System.out.println("Question modifié avec succes");
                return q.getIdQuestion();
            }
                
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
        
    public void supprimerQuestion(int id){
        final String DELETE_QUERY = "delete from question where idQuestion=?";
        try{
            PreparedStatement statement = mc.prepareStatement(DELETE_QUERY);
            statement.setInt(1,id);
            int count = statement.executeUpdate();
            if(count == 0){
                System.out.println("suppression echouée");
            }else
                System.out.println("question supprimé avec succes");                
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }            
    }
    
    public void supprimerByTest(int id){
        final String DELETE_QUERY = "delete from choix where test=?";
        try{
            PreparedStatement statement = mc.prepareStatement(DELETE_QUERY);
            statement.setInt(1,id);
            int count = statement.executeUpdate();
            if(count == 0){
                System.out.println("suppression echouée");
            }else
                System.out.println("Test supprimé avec succes");                
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }            
    }
    
    public QuestionEntity getByIdQuestion(int id){
        final String SELECT_QUERY = "select * from question where idQuestion=?";
        QuestionEntity q = null;
        try{
            PreparedStatement statement = mc.prepareStatement(SELECT_QUERY);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                q = new QuestionEntity();
                q.setIdQuestion(rs.getInt("idQuestion"));
                int idTest =  rs.getInt("test");
                TestService ts = new TestService();
                q.setTest(ts.getByIdTest(idTest));
                q.setEnonce(rs.getString("enonce"));
                q.setScore(rs.getInt("score"));
                q.setDateModification(rs.getDate("dateModification"));
                q.setDateCreation(rs.getDate("dateCreation"));
            }   
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        if(q == null)
            System.out.println("no question found");
        return q;
    }
    
    public List<QuestionEntity> getAllQuestion(){
        final String SELECT_QUERY = "select * from question";
        List<QuestionEntity> l = new ArrayList();
        try{
            PreparedStatement statement = mc.prepareStatement(SELECT_QUERY);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                QuestionEntity q = new QuestionEntity();
                q.setIdQuestion(rs.getInt("idQuestion"));
                int idTest =  rs.getInt("test");
                TestService ts = new TestService();
                q.setTest(ts.getByIdTest(idTest));
                q.setEnonce(rs.getString("enonce"));
                q.setScore(rs.getInt("score"));
                q.setDateModification(rs.getDate("dateModification"));
                q.setDateCreation(rs.getDate("dateCreation"));
                l.add(q);
            }              
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return l;
    }
    
        public List<QuestionEntity> getbyTest(int idTest){
        final String SELECT_QUERY = "select * from question where test=?";
        List<QuestionEntity> l = new ArrayList();
        try{
            PreparedStatement statement = mc.prepareStatement(SELECT_QUERY);
            statement.setInt(1,idTest);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                QuestionEntity q = new QuestionEntity();
                q.setIdQuestion(rs.getInt("idQuestion"));
                int id =  rs.getInt("test");
                TestService ts = new TestService();
                q.setTest(ts.getByIdTest(id));
                q.setEnonce(rs.getString("enonce"));
                q.setScore(rs.getInt("score"));
                q.setDateModification(rs.getDate("dateModification"));
                q.setDateCreation(rs.getDate("dateCreation"));
                l.add(q);
            }              
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return l;
    }
}
