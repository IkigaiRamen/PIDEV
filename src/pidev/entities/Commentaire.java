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
    private int idpost;
    private static int nbrCom;
    public Commentaire() {
        ++nbrCom;
    }
    

    public Commentaire(int id_commentaire, String contenu, String date, int idpost ) {
        this.id_commentaire = id_commentaire;
        this.contenu = contenu;
        this.date = date;
        this.idpost = idpost;
            }
    
    
    public Commentaire(String contenu, String date, int idpost) {
        this.contenu = contenu;
        this.date = date;
        this.idpost = idpost;
    }

    public int getId_commentaire() {
        return id_commentaire;
    }

    public void setId_commentaire(int id_commentaire) {
        this.id_commentaire = id_commentaire;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIdpost() {
        return idpost;
    }

    public void setIdpost(int idpost) {
        this.idpost = idpost;
    }

    @Override
    public String toString() {
        return "\n Commentaire" + id_commentaire + ", contenu=" + contenu + ", date=" + date + ", idpost=" + idpost + '}';
    }
    
   
    
}
