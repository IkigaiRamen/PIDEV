/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.sql.Date;

/**
 *
 * @author Khammessi
 */
public class postule_demande {
    int id;
    int demande_id;
    int user_id;
    java.sql.Date created_at ;

    public postule_demande() {
    }

    public postule_demande(int id, int demande_id, int user_id) {
        this.id = id;
        this.demande_id = demande_id;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDemande_id() {
        return demande_id;
    }

    public void setDemande_id(int demande_id) {
        this.demande_id = demande_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
    
    
           
}