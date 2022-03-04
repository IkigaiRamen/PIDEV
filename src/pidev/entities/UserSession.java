/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

/**
 *
 * @author eya
 */
public final class UserSession {
    
    private static UserSession instance;
    private static int id;
    private static String userName;
    private static Role role;

    public UserSession(int id, String userName, Role role) {
        UserSession.id = id;
        UserSession.userName = userName;
        UserSession.role = role;
    }
    
    
    public UserSession(String userName, Role role) {
        UserSession.userName = userName;
        UserSession.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        UserSession.id = id;
    }
    
    
    
    public static UserSession getInstace(String userName, Role role) {
        if(instance == null) {
            instance = new UserSession(userName, role);
        }
        return instance;
    }

    public String getUserName() {
        return userName;
    }

    public Role getRole() {
        return role;
    }

    public void cleanUserSession() {
        userName = "";
        role = null;
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "userName='" + userName + '\'' +
                ", role=" + role +
                '}';
    }
    
}
