package se.lexicon.g34.bl.jpa_workshop.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class ProductOrder {
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int ID;
//    @Column(nullable = false)
    LocalDate orderDateTime;
//    @Column(nullable = false)
    List<OrderItem> orderItems=new ArrayList<>();
//    @Column(nullable = false)
    AppUser customer;

    //Constructors
    public ProductOrder() {
    }

    public ProductOrder(int ID, LocalDate orderDateTime, List<OrderItem> orderItems, AppUser customer) {
        this.ID = ID;
        this.orderDateTime = orderDateTime;
        this.orderItems = orderItems;
        this.customer = customer;
    }

    public ProductOrder(LocalDate orderDateTime, List<OrderItem> orderItems, AppUser customer) {
        this.orderDateTime = orderDateTime;
        this.orderItems = orderItems;
        this.customer = customer;
    }

    //Methods
    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
    }

    public void removeOrderItem(OrderItem orderItem){
        orderItems.remove(orderItem);
    }

    public double getOrderSum(){
       return orderItems.stream().mapToDouble(OrderItem::getSubTotal).sum();
    }
    //Getters and Setters

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDate getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDate orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public AppUser getCustomer() {
        return customer;
    }

    public void setCustomer(AppUser customer) {
        this.customer = customer;
    }
}
