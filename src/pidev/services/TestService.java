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
import pidev.entities.TestEntity;

/**
 *
 * @author zewaf
 */
public class TestService {
    
    Connection mc = Connexion.getInstance().getMyConnection();
    
    
    public Integer ajouterTest(TestEntity q){
        final String INSERT_QUERY = "INSERT INTO test (`idUser`,`titre`,`type`,`maxScore`,`nbrTentative`,`duree`) VALUES (?,?,?,?,?,?)";
        try{
            
            PreparedStatement statement = mc.prepareStatement(INSERT_QUERY);
            statement.setInt(1, q.getUserId());
            statement.setString(2, q.getTitre());
            statement.setString(3, q.getType());
            //statement.setInt(4, q.getMaxScore());
            statement.setInt(4, 100);
            statement.setInt(5, q.getNbrTentative());
            statement.setInt(6, q.getDuree());
            statement.executeUpdate();
            //return inserted id
            Statement statementId = mc.createStatement();
            ResultSet rsId = statementId.executeQuery("select LAST_INSERT_ID()");
            rsId.first();
            System.out.println("Test Ajouté" + " new id is : " + rsId.getInt(1));
            return rsId.getInt(1);
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }       
    
    public Integer ModifierTest(TestEntity q){
        final String UPDATE_QUERY = "UPDATE test SET type='" + q.getType() + 
                "', titre='" + q.getTitre() + "', maxScore='" + 100 + //q.getMaxScore() + 
                "', nbrTentative= '" + q.getNbrTentative() + "', duree='" + q.getDuree() +
                "' where idTest=" + q.getIdTest() ;
        //System.out.println(UPDATE_QUERY);
        try{
            PreparedStatement statement = mc.prepareStatement(UPDATE_QUERY);
            int count = statement.executeUpdate();
            if(count == 0){
                System.out.println("Modification echoué");
            }else{
                System.out.println("Test modifié avec succes");
                return q.getIdTest();
            }
                
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
        
    public void supprimerTest(int id){
        final String DELETE_QUERY = "delete from test where idtest=?";
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
    
    
    
    public TestEntity getByIdTest(int id){
        final String SELECT_QUERY = "select * from test where idTest=?";
        TestEntity t = null;
        try{
            PreparedStatement statement = mc.prepareStatement(SELECT_QUERY);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                t = new TestEntity();
                t.setIdTest(rs.getInt("idTest"));
                t.setUserId(rs.getInt("idUser"));
                t.setDuree(rs.getInt("duree"));
                t.setDateCreation(rs.getDate("dateCreation"));
                t.setDateModification(rs.getDate("dateModification"));
                //t.setMaxScore(rs.getInt("maxScore"));
                
                t.setNbrTentative(rs.getInt("nbrTentative"));
                t.setType(rs.getString("type"));
                t.setTitre(rs.getString("titre"));
            }   
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        if(t == null)
            System.out.println("no test found");
        return t;
    }
    
    public List<TestEntity> getCertifDispo(int userId){
        System.out.println("bbbbbbbbbbbbbbb");
        final String SELECT_QUERY = "select * from test where type=(?)";
        List<TestEntity> l = new ArrayList();
        try{
            PreparedStatement statement = mc.prepareStatement(SELECT_QUERY);
            statement.setString(1, "Certification");
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                TestEntity t = new TestEntity();
                t.setIdTest(rs.getInt("idTest"));
                t.setUserId(rs.getInt("idUser"));
                t.setDuree(rs.getInt("duree"));
                t.setDateCreation(rs.getDate("dateCreation"));
                t.setDateModification(rs.getDate("dateModification"));
                //t.setMaxScore(rs.getInt("maxScore"));
                t.setNbrTentative(rs.getInt("nbrTentative"));
                t.setType(rs.getString("type"));
                t.setTitre(rs.getString("titre"));
                l.add(t);
            }              
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        final String SELECT_QUERY2 = "select count(*) as count from evaluation where idTest=(?) AND idUser=(?)";
        for(int i=0; i<l.size();i++){
            try{
                PreparedStatement statement = mc.prepareStatement(SELECT_QUERY2);
                statement.setInt(1,l.get(i).getIdTest());
                statement.setInt(2, userId);
                ResultSet rs = statement.executeQuery();
                if(rs.first()) {
                    TestEntity t = l.get(i);
                    l.get(i).setNbrTentative(t.getNbrTentative()-rs.getInt("count"));
                    if(l.get(i).getNbrTentative() == 0)
                        l.remove(i);
                }              
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        
        return l;
    }
    
    public List<TestEntity> getAllTest(){
        final String SELECT_QUERY = "select * from test";
        System.out.println("aaaaaaaaaaaaaaaaa");
        List<TestEntity> l = new ArrayList();
        try{
            PreparedStatement statement = mc.prepareStatement(SELECT_QUERY);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                TestEntity t = new TestEntity();
                t.setIdTest(rs.getInt("idTest"));
                t.setUserId(rs.getInt("idUser"));
                t.setDuree(rs.getInt("duree"));
                t.setDateCreation(rs.getDate("dateCreation"));
                t.setDateModification(rs.getDate("dateModification"));
                //t.setMaxScore(rs.getInt("maxScore"));
                t.setNbrTentative(rs.getInt("nbrTentative"));
                t.setType(rs.getString("type"));
                t.setTitre(rs.getString("titre"));

                l.add(t);
            }              
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return l;
    }
    
    public List<TestEntity> getQuizzDispo(int userId){
         //System.out.println("llllllllllllll");
        final String SELECT_QUERYY = "select * from test where type='Quizz'";
        List<TestEntity> l = new ArrayList();
        try{
            PreparedStatement statement = mc.prepareStatement(SELECT_QUERYY);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                TestEntity t = new TestEntity();
                t.setIdTest(rs.getInt("idTest"));
                t.setUserId(rs.getInt("idUser"));
                t.setDuree(rs.getInt("duree"));
                t.setDateCreation(rs.getDate("dateCreation"));
                t.setDateModification(rs.getDate("dateModification"));
                //t.setMaxScore(rs.getInt("maxScore"));
                t.setNbrTentative(rs.getInt("nbrTentative"));
                t.setType(rs.getString("type"));
                t.setTitre(rs.getString("titre"));
                System.out.println(t.toString());
                l.add(t);
            }              
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        final String SELECT_QUERY2 = "select count(*) as count from evaluation where idTest=(?) AND idUser=(?)";
        for(int i=0; i<l.size();i++){
            try{
                PreparedStatement statement = mc.prepareStatement(SELECT_QUERY2);
                statement.setInt(1,l.get(i).getIdTest());
                statement.setInt(2, userId);
                ResultSet rs = statement.executeQuery();
                if(rs.first()){
                    TestEntity t = l.get(i);
                    l.get(i).setNbrTentative(t.getNbrTentative()-rs.getInt("count"));
                    if(l.get(i).getNbrTentative() == 0)
                        l.remove(i);
                }              
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        
        
        return l;
    }
    
    public List<TestEntity> getMesQuizz(int userId){
         //System.out.println("llllllllllllll");
        final String SELECT_QUERYY = "select * from test where type='Quizz' AND idUser=(?)";
        
        List<TestEntity> l = new ArrayList();
        try{
            PreparedStatement statement = mc.prepareStatement(SELECT_QUERYY);
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                TestEntity t = new TestEntity();
                t.setIdTest(rs.getInt("idTest"));
                t.setUserId(rs.getInt("idUser"));
                t.setDuree(rs.getInt("duree"));
                t.setDateCreation(rs.getDate("dateCreation"));
                t.setDateModification(rs.getDate("dateModification"));
                //t.setMaxScore(rs.getInt("maxScore"));
                t.setNbrTentative(rs.getInt("nbrTentative"));
                t.setType(rs.getString("type"));
                t.setTitre(rs.getString("titre"));
                System.out.println(t.toString());
                l.add(t);
            }              
        }catch(SQLException e){
            System.out.println(e.getMessage());
        } 
        return l;
    }
}
