/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.util.Objects;

/**
 *
 * @author eya
 */
public class User {
    
      
    private int id;
    private String email;
    private String username;
    private String name;
    private String firstname;
    private String password;
    private String roles;
    private int telephone;
    private String bio;
    private String experience;
    private String education;
    private String specialite;
    private String profession;
    private String titre1;
    private String institut1;
    private String periode1;
    private String description1;
    private String titre2;
    private String institut2;
    private String periode2;
    private String description2;
    private String work1;
    private String company1;
    private String workperiod1;
    private String workdescription1;
    private String work2;
    private String company2;
    private String workperiod2;
    private String workdescription2;
    private String qualification1;
    private String qualification2;
    private String qualification3;
    private String qualification4;
    private String societe;
    private String siteWeb;

    

    public User() {
    }

    public User(String email, String username, String name, String firstname, String password) {
        this.email = email;
        this.username = username;
        this.name = name;
        this.firstname = firstname;
        this.password = password;
        this.roles = "[\\ROLES_ADMIN\\]" ;
    }
    
    public User(String email, String username, String name, String firstname, String password, int telephone) {
        this.email = email;
        this.username = username;
        this.name = name;
        this.firstname = firstname;
        this.password = password;
        this.telephone= telephone;
    }

    public User(String email, String username, String name, String firstname, String password, int telephone, String bio, String experience, String specialite, String titre1, String institut1, String periode1, String description1, String titre2, String institut2, String periode2, String description2, String work1, String company1, String workperiod1, String workdescription1, String work2, String company2, String workperiod2, String workdescription2, String qualification1, String qualification2, String qualification3, String qualification4) {
        this.email = email;
        this.username = username;
        this.name = name;
        this.firstname = firstname;
        this.password = password;
        this.telephone = telephone;
        this.bio = bio;
        this.experience = experience;
        this.specialite = specialite;
        this.titre1 = titre1;
        this.institut1 = institut1;
        this.periode1 = periode1;
        this.description1 = description1;
        this.titre2 = titre2;
        this.institut2 = institut2;
        this.periode2 = periode2;
        this.description2 = description2;
        this.work1 = work1;
        this.company1 = company1;
        this.workperiod1 = workperiod1;
        this.workdescription1 = workdescription1;
        this.work2 = work2;
        this.company2 = company2;
        this.workperiod2 = workperiod2;
        this.workdescription2 = workdescription2;
        this.qualification1 = qualification1;
        this.qualification2 = qualification2;
        this.qualification3 = qualification3;
        this.qualification4 = qualification4;
        this.roles="[\\ROLES_TRAVAILLEUR\\]";
    }

    public User(String email, String username, String name, String firstname, String password, String bio, int telephone, String societe, String siteWeb, String profession) {
        this.email = email;
        this.username = username;
        this.name = name;
        this.firstname = firstname;
        this.bio=bio;
        this.password = password;
            this.roles = "[\\ROLES_EMPLOYEUR\\]";
        this.telephone = telephone;
        this.societe = societe;
        this.siteWeb = siteWeb;
        this.profession= profession;
        
    }

    

    

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.username);
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
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    public String getTitre1() {
        return titre1;
    }

    public void setTitre1(String titre1) {
        this.titre1 = titre1;
    }

    public String getInstitut1() {
        return institut1;
    }

    public void setInstitut1(String institut1) {
        this.institut1 = institut1;
    }

    public String getPeriode1() {
        return periode1;
    }

    public void setPeriode1(String periode1) {
        this.periode1 = periode1;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getTitre2() {
        return titre2;
    }

    public void setTitre2(String titre2) {
        this.titre2 = titre2;
    }

    public String getInstitut2() {
        return institut2;
    }

    public void setInstitut2(String institut2) {
        this.institut2 = institut2;
    }

    public String getPeriode2() {
        return periode2;
    }

    public void setPeriode2(String periode2) {
        this.periode2 = periode2;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getWork1() {
        return work1;
    }

    public void setWork1(String work1) {
        this.work1 = work1;
    }

    public String getCompany1() {
        return company1;
    }

    public void setCompany1(String company1) {
        this.company1 = company1;
    }

    public String getWorkperiod1() {
        return workperiod1;
    }

    public void setWorkperiod1(String workperiod1) {
        this.workperiod1 = workperiod1;
    }

    public String getWorkdescription1() {
        return workdescription1;
    }

    public void setWorkdescription1(String workdescription1) {
        this.workdescription1 = workdescription1;
    }

    public String getWork2() {
        return work2;
    }

    public void setWork2(String work2) {
        this.work2 = work2;
    }

    public String getCompany2() {
        return company2;
    }

    public void setCompany2(String company2) {
        this.company2 = company2;
    }

    public String getWorkperiod2() {
        return workperiod2;
    }

    public void setWorkperiod2(String workperiod2) {
        this.workperiod2 = workperiod2;
    }

    public String getWorkdescription2() {
        return workdescription2;
    }

    public void setWorkdescription2(String workdescription2) {
        this.workdescription2 = workdescription2;
    }

    public String getQualification1() {
        return qualification1;
    }

    public void setQualification1(String qualification1) {
        this.qualification1 = qualification1;
    }

    public String getQualification2() {
        return qualification2;
    }

    public void setQualification2(String qualification2) {
        this.qualification2 = qualification2;
    }

    public String getQualification3() {
        return qualification3;
    }

    public void setQualification3(String qualification3) {
        this.qualification3 = qualification3;
    }

    public String getQualification4() {
        return qualification4;
    }

    public void setQualification4(String qualification4) {
        this.qualification4 = qualification4;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    
    
    
}
