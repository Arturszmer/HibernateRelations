package com.example.HybernateRelations;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String street;
    private String zipCode;
    private String house_nr;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Person person;

    public Address(String city, String street, String zipCode, String house_nr) {
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.house_nr = house_nr;
    }

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getHouse_nr() {
        return house_nr;
    }

    public void setHouse_nr(String house_nr) {
        this.house_nr = house_nr;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", house_nr='" + house_nr + '\'' +
                ", person=" + person +
                '}';
    }
    public void removePerson(){
        person.setAdress(null);
        this.person = null;
    }
}