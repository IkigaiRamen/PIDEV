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
import pidev.entities.ChoixEntity;

/**
 *
 * @author zewaf
 */
public class ChoixService {
    Connection mc = Connexion.getInstance().getMyConnection();
    
    
    public void ajouterChoix(ChoixEntity c){
        final String INSERT_QUERY = "INSERT INTO choix (`question`,`correct`,`contenu`) VALUES (?,?,?)";
        try{
            
            PreparedStatement statement = mc.prepareStatement(INSERT_QUERY);
            statement.setInt(1, c.getQuestion().getIdQuestion());
            statement.setBoolean(2, c.isCorrect());
            statement.setString(3, c.getContenu());
            statement.executeUpdate();
            System.out.println("choix Ajoutée");
            
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }       
        public Integer ModifierChoix(ChoixEntity c){
            
            
        final String UPDATE_QUERY = "UPDATE choix SET idChoix='" + c.getIdChoix()+ 
                "', idQuestion='" + c.getQuestion().getIdQuestion()+
                "', correct='" + c.isCorrect() + "', contenu='" + c.getContenu()+
                "' where idChoix=" + c.getIdChoix();
        try{
            PreparedStatement statement = mc.prepareStatement(UPDATE_QUERY);
            int count = statement.executeUpdate();
            if(count == 0){
                System.out.println("Modification echoué");
            }else{
                System.out.println("Choix modifié avec succes");
                return c.getIdChoix();
            }
                
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
        
    public void supprimerChoix(int id){
        final String DELETE_QUERY = "delete from choix where idChoix=?";
        try{
            PreparedStatement statement = mc.prepareStatement(DELETE_QUERY);
            statement.setInt(1,id);
            int count = statement.executeUpdate();
            if(count == 0){
                System.out.println("suppression echouée");
            }else
                System.out.println("choix supprimé avec succes");                
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }            
    }
    
    public ChoixEntity getByIdChoix(int id){
        final String SELECT_QUERY = "select * from choix where idChoix=?";
        ChoixEntity c = null;
        try{
            PreparedStatement statement = mc.prepareStatement(SELECT_QUERY);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                c = new ChoixEntity();
                int idQuestion = rs.getInt("question");
                QuestionService qs = new QuestionService();
                c.setQuestion(qs.getByIdQuestion(idQuestion));
                c.setIdChoix(rs.getInt("idChoix"));
                c.setContenu(rs.getString("contenu"));
                c.setCorrect(rs.getBoolean("correct"));
                
            }   
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        if(c == null)
            System.out.println("no choice found");
        return c;
    }
    public List<ChoixEntity> getAllChoix(){
        final String SELECT_QUERY = "select * from choix";
        List<ChoixEntity> l = new ArrayList();
        try{
            PreparedStatement statement = mc.prepareStatement(SELECT_QUERY);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                ChoixEntity c = new ChoixEntity();
                int idQuestion = rs.getInt("question");
                QuestionService qs = new QuestionService();
                c.setQuestion(qs.getByIdQuestion(idQuestion));
                c.setIdChoix(rs.getInt("idChoix"));
                c.setContenu(rs.getString("contenu"));
                c.setCorrect(rs.getBoolean("correct"));
                l.add(c);
            }              
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return l;
    }
        public List<ChoixEntity> getByQuestion(int idQuestion){
        final String SELECT_QUERY = "select * from choix where question=?";
        List<ChoixEntity> l = new ArrayList();
        try{
            PreparedStatement statement = mc.prepareStatement(SELECT_QUERY);
            statement.setInt(1,idQuestion);
            ResultSet rs = statement.executeQuery();
            System.out.println("yyyyyyyyyyyyyyyyyyyyy" + rs.toString());
            while(rs.next()) {
                ChoixEntity c = new ChoixEntity();
                int id = rs.getInt("question");
                QuestionService qs = new QuestionService();
                c.setQuestion(qs.getByIdQuestion(id));
                c.setIdChoix(rs.getInt("idChoix"));
                c.setContenu(rs.getString("contenu"));
                c.setCorrect(rs.getBoolean("correct"));
                l.add(c);
                
            }              
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return l;
    }
}
