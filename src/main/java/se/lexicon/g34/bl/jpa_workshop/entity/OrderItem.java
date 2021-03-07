package se.lexicon.g34.bl.jpa_workshop.entity;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Objects;
//@Entity
public class OrderItem {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // means auto_increment
    private int ID;
    private int quantity;
    private Product product;
    private ProductOrder productOrder;

    //Constructors

    public OrderItem() {
    }

    public OrderItem(int ID, int quantity, Product product, ProductOrder productOrder) {
        this.ID = ID;
        this.quantity = quantity;
        this.product = product;
        this.productOrder = productOrder;
    }

    public OrderItem(int quantity, Product product, ProductOrder productOrder) {
        this.quantity = quantity;
        this.product = product;
        this.productOrder = productOrder;
    }
    //Methods
    public double getSubTotal(){
        return quantity*product.getPrice();
    }

    //Getters and Setters

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    //Overrides

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return ID == orderItem.ID && quantity == orderItem.quantity && Objects.equals(product, orderItem.product) && Objects.equals(productOrder, orderItem.productOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, quantity, product, productOrder);
    }
}
