package se.lexicon.g34.bl.jpa_workshop.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductOrderTest {

    ProductOrder productOrder;


    @BeforeEach
    public void Setup() {
        productOrder = new ProductOrder();
        productOrder.setID(1);
        productOrder.setCustomer(new AppUser( "Björn", "Larsson", "bjorn@nykalt.se"));
        productOrder.addOrderItem(new OrderItem(3,new Product("Mjölk", 13.50d),productOrder));
        productOrder.addOrderItem(new OrderItem(2,new Product("Ost", 14.50d),productOrder));

    }

    @Test
    public void addOrderItemTest() {
        double expected = 3 * 13.50d + 2 * 14.50d + 4 * 27.00d;
        productOrder.getOrderItems().forEach(System.out::println);
        productOrder.addOrderItem(new OrderItem(4,new Product( "Tidning", 27d),productOrder));
        List<OrderItem> orderItemsList = productOrder.getOrderItems();
        System.out.println("-----------------------");
        productOrder.getOrderItems().forEach(System.out::println);
        Assertions.assertEquals(expected, productOrder.getOrderSum());
    }


    @Test
    public void removeOrderItemTest() {
        double expected = 3 * 13.50d + 2 * 14.50d ;
        OrderItem orderItem=new OrderItem(4,new Product( "Tidning", 27d),productOrder);
        System.out.println("---------Startlist--------------");
        productOrder.getOrderItems().forEach(System.out::println);
        System.out.println("--------Add Order Item---------------");
        productOrder.addOrderItem(orderItem);
        System.out.println(productOrder.getOrderSum());
        productOrder.getOrderItems().forEach(System.out::println);
        Assertions.assertEquals(expected+4*27, productOrder.getOrderSum());

        System.out.println("--------Remove OrderItem---------------");
        productOrder.removeOrderItem(orderItem);
        productOrder.getOrderItems().forEach(System.out::println);
        System.out.println("-------OrderItem removed----------------");
        System.out.println(productOrder.getOrderSum());
        productOrder.getOrderItems().forEach(System.out::println);
        Assertions.assertEquals(expected, productOrder.getOrderSum());
    }

    @Test
    public void getOrderSumTest() {

        double expected = 3 * 13.50d + 2 * 14.50d;
        Assertions.assertEquals(expected, productOrder.getOrderSum());
    }
}