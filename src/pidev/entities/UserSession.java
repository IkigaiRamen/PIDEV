/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

/**
 *
 * @author Khammessi
 */
public final class UserSession {
    
    private static UserSession instance;
    public static int id;
    public static String userName;
    public static String roles;
    public static String email;

    public UserSession(int id, String userName, String roles, String email) {
        UserSession.id = id;
        UserSession.userName = userName;
        UserSession.roles = roles;
        UserSession.email=email;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        UserSession.email = email;
    }
    
    
    public UserSession(String email, String roles) {
        UserSession.email = email;
        UserSession.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        UserSession.id = id;
    }
    
    
    
    public static UserSession getInstace(String userName, String role) {
        if(instance == null) {
            instance = new UserSession(userName, role);
        }
        return instance;
    }

    public String getUserName() {
        return userName;
    }

    public String getRole() {
        return roles;
    }

    public void cleanUserSession() {
        userName = null;
        roles = null;
        email=null;
        id=0;
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "userName='" + userName + '\'' +
                ", role=" + roles +
                '}';
    }
    
}
