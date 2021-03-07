package se.lexicon.g34.bl.jpa_workshop.entity;

import javax.persistence.*;
import java.util.Objects;

//@Entity
public class Product {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // means auto_increment
    public int ID;
//    @Column(nullable = false)
    String name;
//    @Column(nullable = false)
    double price;


//Constructors
    public Product() {
    }

    public Product(int ID, String name, double price) {
        this.ID = ID;
        this.name = name;
        this.price = price;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    //Getters and Setters

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


//Overrides

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return ID == product.ID && Double.compare(product.price, price) == 0 && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, price);
    }
}