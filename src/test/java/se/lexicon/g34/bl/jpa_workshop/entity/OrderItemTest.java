package se.lexicon.g34.bl.jpa_workshop.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderItemTest {
    Product productTest;
    ProductOrder productOrderTest;
    OrderItem orderItemTest;

    @BeforeEach
    public void setup() {
        productTest = new Product(1, "Mjölk", 13.25f);
        productOrderTest = new ProductOrder();
        orderItemTest = new OrderItem(1, 3, productTest, productOrderTest);
    }


    @Test
    @DisplayName("Test 1: create appuser object")
    public void test_successfully_created() {
        Assertions.assertEquals(1, productTest.getID());
        Assertions.assertEquals(3, orderItemTest.getQuantity());
        Assertions.assertEquals(productTest, orderItemTest.getProduct());
        Assertions.assertEquals(productOrderTest, orderItemTest.getProductOrder());
    }

    @Test
    @DisplayName("Test 2:Set the values")
    public void test_setValues() {
        Product newProduct = new Product(2, "Ost", 14.50f);
        ProductOrder newProductOrder = new ProductOrder();
        orderItemTest.setID(2);
        orderItemTest.setQuantity(4);
        orderItemTest.setProduct(newProduct);
        orderItemTest.setProductOrder(newProductOrder);
        Assertions.assertEquals(2, orderItemTest.getID());
        Assertions.assertEquals(4, orderItemTest.getQuantity());
        Assertions.assertEquals(newProduct, orderItemTest.getProduct());
        Assertions.assertEquals(newProductOrder, orderItemTest.getProductOrder());
    }

    @Test
    @DisplayName("Test 3: test equal method")
    public void test_equals() {

        OrderItem expected = new OrderItem(1, 3, productTest, productOrderTest);
        OrderItem actual = orderItemTest;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test 4: test hash codeof student object")
    public void test_hashCode() {
        OrderItem expected = new OrderItem(1, 3, productTest, productOrderTest);
        OrderItem actual = orderItemTest;
        Assertions.assertEquals(expected.hashCode(), actual.hashCode());

    }

    @Test
    @DisplayName("Test 5: Test subtotal")
    public void test_subTotal(){
        float expexted= orderItemTest.getQuantity()*orderItemTest.getProduct().getPrice();
        OrderItem actual =orderItemTest;
        Assertions.assertEquals(expexted,actual.getSubTotal());
    }

}
