/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;
import pidev.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pidev.entities.User;

/**
 *
 * @author eya
 */
public class UserService {

    PreparedStatement ste;
    
    Connection mc = Connexion.getInstance().getMyConnection();
    
//Creer un utilisateur
    
    public void ajouterUser(User u) throws SQLException{
        String sql="Insert into User (email,username,lastname,firstname,password,role,telephone) values(?,?,?,?,?,?,?)";
        ste= mc.prepareStatement(sql);
        ste.setString(1,u.getEmail());
        ste.setString(2,u.getUsername());
        ste.setString(3,u.getName());
        ste.setString(4,u.getFirstname());
        ste.setString(5,u.getPassword());
        ste.setString(6,u.getRoles());
        ste.setInt(7,u.getTelephone());
        ste.executeQuery();
        System.out.println("Utilisateur ajoute avec succes");
    }
    
//Liste des developpeurs
    
    public List<User> afficherDeveloppeurs() throws SQLException{
        List<User> developpeurs = new ArrayList<>();
        String sql="Select * from user where roles='[\\ROLE_TRAVAILLEUR\\]'";
        ste = mc.prepareStatement(sql);
        ResultSet rs =ste.executeQuery();
        while(rs.next()){
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setUsername(rs.getString("username"));
            u.setName(rs.getString("lastname"));
            u.setFirstname(rs.getString("firstname"));
            u.setRoles(rs.getString("roles"));
            u.setTelephone(rs.getInt("telephone"));
            u.setBio(rs.getString("bio"));
            u.setExperience(rs.getString("exp"));
            u.setTitre1(rs.getString("titre1"));
            u.setInstitut1(rs.getString("institut1"));
            u.setPeriode1(rs.getString("periode1"));
            u.setDescription1(rs.getString("description1"));
            u.setTitre2(rs.getString("titre2"));
            u.setInstitut2(rs.getString("institut2"));
            u.setPeriode2(rs.getString("periode2"));
            u.setDescription2(rs.getString("description2"));
            u.setTitre2(rs.getString("titre2"));
            u.setCompany1(rs.getString("company1"));
            u.setWorkperiod1(rs.getString("workperiod1"));
            u.setWorkdescription1(rs.getString("workdescription1"));
            u.setWork1(rs.getString("work1"));
            u.setCompany2(rs.getString("company2"));
            u.setWorkperiod1(rs.getString("workperiod2"));
            u.setWorkdescription1(rs.getString("workdescription2"));
            u.setWork1(rs.getString("work2"));
            u.setQualification1(rs.getString("qualification1"));
            u.setQualification2(rs.getString("qualification2"));
            u.setQualification3(rs.getString("qualification3"));
            u.setQualification4(rs.getString("qualification4"));
            u.setSpecialite(rs.getString("job"));
            developpeurs.add(u);
        }
        return developpeurs;
    }
    //Liste des employeurs
    
    public List<User> afficherEmployeurs() throws SQLException{
        List<User> employeurs = new ArrayList<>();
        String sql="Select * from user where roles='[\\ROLE_EMPLOYEUR\\]'";
        ste = mc.prepareStatement(sql);
        ResultSet rs =ste.executeQuery();
        while(rs.next()){
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setUsername(rs.getString("username"));
            u.setName(rs.getString("lastname"));
            u.setFirstname(rs.getString("firstname"));
            u.setRoles(rs.getString("roles"));
            u.setTelephone(rs.getInt("telephone"));
            u.setProfession(rs.getString("job"));
            u.setBio(rs.getString("bio"));
            u.setSociete(rs.getString("societe"));
            u.setSiteWeb(rs.getString("siteweb"));
            employeurs.add(u);
        }
        return employeurs;
    }
    //supprimer un utilisateur
    
    public void supprimerUser(int id) throws SQLException{
        String sql= "Delete from user where id=?";
        ste= mc.prepareStatement(sql);
        ste.setInt(1, id);
        ste.executeUpdate();
        System.out.println("User supprimer");
    }
    
    //Modifier un developpeur
    public void modifierDeveloppeur(int id,
            String email, 
            String name, 
            String firstname,
            int telephone,
            String bio,
            String experience,
            String education,
            String specialite,
            String titre1,
            String institut1,
            String periode1,
            String description1,
            String titre2,
            String institut2,
            String periode2,
            String description2,
            String work1,
            String company1,
            String workperiod1,
            String workdescription1,
            String work2,
            String company2,
            String workperiod2,
            String workdescription2,
            String qualification1,
            String qualification2,
            String qualification3,
            String qualification4
   ) throws SQLException{
        String sql="update user set email = ? , lastname= ? , firstname=? , telephone=?, bio=? , experience=?  , specialite=?, titre1=? , institut1=? , periode1=? , description1=?, titre2=? , institut2=? , periode2=? , description2=?, work1=?, campany1=?, workperiod1=? , workdescription1=? , work2=?, campany2=?, workperiod2=? , workdescription2=? , qualification1=? , qualification2=? , qualification3=? , qualification4=? where id=? ";
        ste = mc.prepareStatement(sql);
        ste.setString(1,email);
        ste.setString(2,name);
        ste.setString(3,firstname);
        ste.setInt(4, telephone);
        ste.setString(5, bio);
        ste.setString(6, experience);
        ste.setString(7,specialite);
        ste.setString(8, titre1);
        ste.setString(9,institut1);
        ste.setString(10,periode1);
        ste.setString(11, description1);
        ste.setString(12, titre2);
        ste.setString(13,institut2);
        ste.setString(14,periode2);
        ste.setString(15, description2);
        ste.setString(16, work1);
        ste.setString(17,company1);
        ste.setString(18,workperiod1);
        ste.setString(19, workdescription1);
        ste.setString(20, work2);
        ste.setString(21,company2);
        ste.setString(22,workperiod2);
        ste.setString(23, workdescription2);
        ste.setString(24, qualification1);
        ste.setString(25, qualification2);
        ste.setString(26, qualification3);
        ste.setString(27, qualification4);
        ste.setInt(28, id);
        ste.executeUpdate();
        System.out.println("Developpeur Modifie");
        
    }
    //Modifier un employeur
    public void modifierEmployeur(int id,
            String email, 
            String name, 
            String firstname,
            int telephone,
            String profession,
            String bio,
            String societe,
            String siteweb) throws SQLException{
        String sql="update user set email = ? , lastname= ? , firstname=? , telephone=?, job=? bio=? , societe=? , siteweb=? where id=? ";
        ste = mc.prepareStatement(sql);
        ste.setString(1,email);
        ste.setString(2,name);
        ste.setString(3,firstname);
        ste.setInt(4, telephone);
        ste.setString(5, profession);
        ste.setString(6, bio );
        ste.setString(7, societe);
        ste.setString(8, siteweb);
        ste.setInt(9, id);
        ste.executeUpdate();
        System.out.println("Employeur Modifie");
        
    }
    
    //get a user by his id
    public User getUserById(int id) throws SQLException{
        User u = new User();
        String sql= "select * from user where id=?";
        ste= mc.prepareStatement(sql);
        ste.setInt(1, id);
        ResultSet rs = ste.executeQuery();
        while (rs.next()){
            u.setId(id);
            u.setEmail(rs.getString("email"));
            u.setUsername(rs.getString("username"));
            u.setName(rs.getString("name"));
            u.setFirstname(rs.getString("firstname"));
            u.setPassword(rs.getString("password"));
            u.setRoles(rs.getString("roles"));
            u.setTelephone(rs.getInt("telephone"));
            if(u.getRoles().equals("[\\ROLES_TRAVAILLEUR\\]")){
                u.setBio(rs.getString("bio"));
                u.setExperience(rs.getString("exp"));
                u.setEducation(rs.getString("qualification"));
                u.setSpecialite(rs.getString("job"));
                u.setTitre1(rs.getString("titre1"));
                u.setInstitut1(rs.getString("institut1"));
                u.setPeriode1(rs.getString("periode1"));
                u.setDescription1(rs.getString("description1"));
                u.setTitre2(rs.getString("titre2"));
                u.setInstitut2(rs.getString("institut2"));
                u.setPeriode2(rs.getString("periode2"));
                u.setDescription2(rs.getString("description2"));
                u.setWork1(rs.getString("work1"));
                u.setCompany1(rs.getString("company1"));
                u.setWorkdescription1(rs.getString("workdescription1"));
                u.setWorkperiod1(rs.getString("workperiod1"));
                u.setWork2(rs.getString("work2"));
                u.setCompany2(rs.getString("company2"));
                u.setWorkdescription2(rs.getString("workdescription2"));
                u.setWorkperiod2(rs.getString("workperiod2"));
                u.setQualification1(rs.getString("qualification1"));
                u.setQualification2(rs.getString("qualification2"));
                u.setQualification3(rs.getString("qualification3"));
                u.setQualification4(rs.getString("qualification4"));
                
                
            }
            if(u.getRoles().equals("[\\ROLES_EMPLOYEUR\\]")){
                u.setProfession(rs.getString("job"));
                u.setBio(rs.getString("bio"));
                u.setSiteWeb(rs.getString("siteweb"));
                u.setSociete(rs.getString("societe"));
            }
            
        }
        return u;
    }
    
    //
    
    
    public boolean verifyLogin(String email,String pw) throws SQLException{
        String sql="count(*) as total from user where email=? and pasword=? ";
        ste=mc.prepareStatement(sql);
        ste.setString(1, email);
        ste.setString(2, pw);
        int total;
        ResultSet rs= ste.executeQuery();
        rs.next();
        total= rs.getInt("total");
        rs.close();
        return (total ==1);
    }
    
    public User Login(String email, String password) throws SQLException{
        User u= new User();
        String sql ="select * from user where email=? and password=?";
        ste= mc.prepareStatement(sql);
        ste.setString(1, email);
        ste.setString(2, password);
        ResultSet rs= ste.executeQuery();
        rs.next();
        u.setId(rs.getInt("id"));
        u.setUsername(rs.getString("username"));
        u.setName(rs.getString("lastname"));
        u.setFirstname(rs.getString("firstname"));
        u.setEmail(rs.getString("email"));
        u.setRoles(rs.getString("roles"));
        u.setPassword(rs.getString("password"));
        u.setTelephone(rs.getInt("num_tell"));
        
        return u;
    }
    public User Session(String email) throws SQLException{
        User u = new User();
        String sql= "select * from user where email=?";
        ste= mc.prepareStatement(sql);
        ste.setString(1, email);
        ResultSet rs = ste.executeQuery();
        while (rs.next()){
            u.setId(rs.getInt("id"));
            u.setEmail(rs.getString("email"));
            u.setUsername(rs.getString("username"));
            u.setName(rs.getString("name"));
            u.setFirstname(rs.getString("firstname"));
            u.setPassword(rs.getString("password"));
            u.setRoles(rs.getString("roles"));
            u.setTelephone(rs.getInt("telephone"));
            if(u.getRoles().equals("[\\ROLES_TRAVAILLEUR\\]")){
                u.setBio(rs.getString("bio"));
                u.setExperience(rs.getString("exp"));
                u.setEducation(rs.getString("qualification"));
                u.setSpecialite(rs.getString("job"));
                u.setTitre1(rs.getString("titre1"));
                u.setInstitut1(rs.getString("institut1"));
                u.setPeriode1(rs.getString("periode1"));
                u.setDescription1(rs.getString("description1"));
                u.setTitre2(rs.getString("titre2"));
                u.setInstitut2(rs.getString("institut2"));
                u.setPeriode2(rs.getString("periode2"));
                u.setDescription2(rs.getString("description2"));
                u.setWork1(rs.getString("work1"));
                u.setCompany1(rs.getString("company1"));
                u.setWorkdescription1(rs.getString("workdescription1"));
                u.setWorkperiod1(rs.getString("workperiod1"));
                u.setWork2(rs.getString("work2"));
                u.setCompany2(rs.getString("company2"));
                u.setWorkdescription2(rs.getString("workdescription2"));
                u.setWorkperiod2(rs.getString("workperiod2"));
                u.setQualification1(rs.getString("qualification1"));
                u.setQualification2(rs.getString("qualification2"));
                u.setQualification3(rs.getString("qualification3"));
                u.setQualification4(rs.getString("qualification4"));
                
                
            }
            if(u.getRoles().equals("[\\ROLES_EMPLOYEUR\\]")){
                u.setProfession(rs.getString("job"));
                u.setBio(rs.getString("bio"));
                u.setSiteWeb(rs.getString("siteweb"));
                u.setSociete(rs.getString("societe"));
            }
            
        }
        return u;
    
    }
    
    
    public String md5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
            } catch (java.security.NoSuchAlgorithmException e) {
            }
    return null;
    }
    /**
    public void updatePassword(String email, String password) throws SQLException{
        String sql= "update user set password=? where email=?";
        ste= mc.prepareStatement(sql);
        ste.setString(1, password);
        ste.setString(2, this.md5(password));
        ste.executeUpdate();
        System.out.println("Mot de passe modifie");
    }
    
    **/
    public boolean getUserByEmail(String email) throws SQLException{
        String sql="count(*) as total from user where email=?  ";
        ste=mc.prepareStatement(sql);
        ste.setString(1, email);
        int total;
        ResultSet rs= ste.executeQuery();
        rs.next();
        total= rs.getInt("total");
        rs.close();
        return (total ==1);
    }
    
    public boolean getUserByUsername(String username) throws SQLException{
        String sql="count(*) as total from user where username=?  ";
        ste=mc.prepareStatement(sql);
        ste.setString(1, username);
        int total;
        ResultSet rs= ste.executeQuery();
        rs.next();
        total= rs.getInt("total");
        rs.close();
        return (total ==1);
    }
    
    
    
    
    public boolean VerifyEmail(String email) throws SQLException{
        boolean v;
        String sql = "Select count(*) total from user where email=?";
        ste = mc.prepareStatement(sql);
        ste.setString(1, email);
        ResultSet rs=ste.executeQuery();
       rs.next();
       int doesitexist = rs.getInt("total");
       rs.close();
        System.out.println(doesitexist);
       if(doesitexist !=1){
           v=false;
       }
       else v=true;
       
       return v; 
    }
    
    public String getEmail(String email) throws SQLException{
        String email1="";
        String sql="Select email fron user where email=?";
        ste= mc.prepareStatement(sql);
        ste.setString(1,email);
        ResultSet rs= ste.executeQuery();
        while (rs.next()){
            email1= rs.getString("email");
        }
        return email1;
    }
    
    
    public void UpdatePassword(String password, String email) throws SQLException{
        String sql="Update user set password=? where email=";
        ste=mc.prepareStatement(sql);
        ste.setString(1,password);
        ste.setString(2, email);
        ste.executeUpdate();
    }
}

