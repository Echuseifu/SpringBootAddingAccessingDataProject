package com.tts.SpringBootAddingAddition.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

// this indicate we want to store our data in database
// it indicates Subscriber is a JPA entity,
// it is assumed this entity will be mapped to a table named Subscriber
//JPA is a Java specification for managing relational data in Java applications.
// it needs an empty constructor to create a new instance via the persistence framework
@Entity
public class Subscriber {

    // our database table that will align to Subscriber will need a primary key
    // that primary key will align with the field id
    // we don't want to set the id manually
    // so we delegate that responsibility to H2 and Java
    // @Id JPA will recognize it as the object's primary key
    //@GenerateValue indicate that the ID should be generated automatically
        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private Date signedUp;

    public Subscriber(String firstName, String lastName, String userName, Date signedUp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.signedUp = signedUp;
    }

    // empty constructors are utilized for beans
    // this class will be picked up as a java bean example @Entity
    // they need to be serializable
    // necessary for the JPA
    public Subscriber() {
    }

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getSignedUp() {
        return signedUp;
    }

    public void setSignedUp(Date signedUp) {
        this.signedUp = signedUp;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", signedUp=" + signedUp +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscriber that = (Subscriber) o;
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(userName, that.userName) && Objects.equals(signedUp, that.signedUp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, userName, signedUp);
    }

}
