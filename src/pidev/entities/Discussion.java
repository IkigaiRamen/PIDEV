/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author khoualdi koussay
 */
public class Discussion {
    private int id_discussion   ;
    private int idEmp;
    private int idDev;

    public Discussion(int id_discussion, int idEmp, int idDev) {
        this.id_discussion = id_discussion;
        this.idEmp = idEmp;
        this.idDev = idDev;
    }
    
    public Discussion(){
        
    }
    

    public int getId_discussion() {
        return id_discussion;
    }

    public void setId_discussion(int id_discussion) {
        this.id_discussion = id_discussion;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    public int getIdDev() {
        return idDev;
    }

    public void setIdDev(int idDev) {
        this.idDev = idDev;
    }


    public int getId() {
        return id_discussion;
    }

    public void setId(int id_discussion) {
        this.id_discussion = id_discussion;
    }

    


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id_discussion;
        
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
        final Discussion other = (Discussion) obj;
        if (this.id_discussion != other.id_discussion) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "Discussion{" + "id=" + id_discussion + " '}'";
    }
   
    
    
}
