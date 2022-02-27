package pidev.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class Post {
     private int id_post;
    private String description;
    private String date_p;

    public Post() {
    }

    public Post(int id_post, String description, String date_p) {
        this.id_post = id_post;
        this.description = description;
        this.date_p = date_p;
       
    }

    public Post(String description, String date_p) {
        this.description = description;
        this.date_p = date_p;
    }

    public int getid_post() {
        return id_post;
    }

    public void setid_post(int id_post) {
        this.id_post= id_post;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public String getdate_p() {
        return date_p;
    }

    public void setdate_p(String date) {
        this.date_p = date;
    }
    @Override
    public String toString() {
        return "Post{" + "id_post=" + id_post + ",description=" + description + ", date_p=" + date_p + '}';
    }
    
    public boolean contains() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
