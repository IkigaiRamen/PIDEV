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
public class User {
    
    private int id;
    private String userName;
    private String email;
    private String password;
    private String nom;
    private String prenom;
    public Role role;
    
    
    public User() {
    
    }

    public User(String userName, String email, String password, String nom, String prenom) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        
    }
    
    
    public Role getRole() {
            return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public User(int id, String userName, String email, String password, String nom, String prenom, Role role) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
    }

   
    
}
