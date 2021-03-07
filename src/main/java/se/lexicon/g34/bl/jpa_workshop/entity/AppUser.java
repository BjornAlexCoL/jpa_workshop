package se.lexicon.g34.bl.jpa_workshop.entity;


import javax.persistence.*;
import java.util.Objects;
//@Entity
public class AppUser {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // means auto_increment
    private int ID;
    //@Column(nullable = false)
    private String firstMame;
    //@Column(nullable = false)
    private String lastName;
    //@Column(nullable = false,unique = true)
    private String email;

//Construktors

    public AppUser() {
    }

    public AppUser(int ID, String firstMame, String lastName, String email) {
        this.ID = ID;
        this.firstMame = firstMame;
        this.lastName = lastName;
        this.email = email;
    }

    public AppUser(String firstMame, String lastName, String email) {
        this.firstMame = firstMame;
        this.lastName = lastName;
        this.email = email;
    }
    //Getter and Setters

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstMame() {
        return firstMame;
    }

    public void setFirstMame(String firstMame) {
        this.firstMame = firstMame;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//Overrides

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return ID == appUser.ID && Objects.equals(firstMame, appUser.firstMame) && Objects.equals(lastName, appUser.lastName) && Objects.equals(email, appUser.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, firstMame, lastName, email);
    }
}
