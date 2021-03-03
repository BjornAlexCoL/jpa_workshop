package se.lexicon.g34.bl.jpa_workshop.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductTest {
    Product productTest;

    @BeforeEach
    public void setup() {
        productTest = new Product(1, "Mjölk", 13.25f);
    }


    @Test
    @DisplayName("Test 1: create appuser object")
    public void test_successfully_created() {
        Assertions.assertEquals(1, productTest.getID());
        Assertions.assertEquals("Mjölk", productTest.getName());
        Assertions.assertEquals(13.25f, productTest.getPrice());
    }

    @Test
    @DisplayName("Test 2:Set the values")
    public void test_setValues() {
        productTest.setID(2);
        productTest.setName("Ost");
        productTest.setPrice(14.50f);
        Assertions.assertEquals(2, productTest.getID());
        Assertions.assertEquals("Ost", productTest.getName());
        Assertions.assertEquals(14.50f, productTest.getPrice());
    }

    @Test
    @DisplayName("Test 3: test equal method")
    public void test_equals() {
        Product expected = new Product(
                1,
                "Mjölk",
                13.25f);
        Product actual = productTest;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test 4: test hash codeof student object")
    public void test_hashCode() {
        Product expected = new Product(
                1,
                "Mjölk",
                13.25f);
        Product actual = productTest;
        Assertions.assertEquals(expected.hashCode(), actual.hashCode());

    }
}
