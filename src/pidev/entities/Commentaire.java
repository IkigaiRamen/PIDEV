/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;



public class Commentaire {
    private int id_commentaire;
    private String contenu;
    private String date;

    public Commentaire() {
    }

    public Commentaire(int id_commentaire, String contenu, String date) {
        this.id_commentaire = id_commentaire;
        this.contenu = contenu;
        this.date = date;
       
    }

    public int getid_commentaire() {
        return id_commentaire;
    }

    public void setid_commentaire(int id_commentaire) {
        this.id_commentaire= id_commentaire;
    }

    public String getcontenu() {
        return contenu;
    }

    public void setcontenu(String contenu) {
        this.contenu = contenu;
    }

    public String getdate() {
        return date;
    }

    public void setdate(String date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "Commentaire{" + "id_commentaire=" + id_commentaire + ",contenu=" + contenu + ", date=" + date + '}';
    }
    
    public boolean contains() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
