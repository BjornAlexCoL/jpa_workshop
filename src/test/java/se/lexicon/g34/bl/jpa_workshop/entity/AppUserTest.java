package se.lexicon.g34.bl.jpa_workshop.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppUserTest {
    AppUser appUserTest;

    @BeforeEach
    public void setup() {
        appUserTest = new AppUser(1,"Björn", "Larsson", "bjorn.nykalt@gmail.com");
    }


    @Test
    @DisplayName("Test 1: create appuser object")
    public void test_successfully_created() {
        Assertions.assertEquals(1, appUserTest.getID());
        Assertions.assertEquals("Björn", appUserTest.getFirstMame());
        Assertions.assertEquals("Larsson", appUserTest.getLastName());
        Assertions.assertEquals("bjorn.nykalt@gmail.com", appUserTest.getEmail());
    }
    @Test
    @DisplayName("Test 2:Set the values")
    public void test_setValues(){
        appUserTest.setID(2);
        appUserTest.setFirstMame("Sven");
        appUserTest.setLastName("Ohlsson");
        appUserTest.setEmail("no.valid.email.not");
        Assertions.assertEquals(2, appUserTest.getID());
        Assertions.assertEquals("Sven", appUserTest.getFirstMame());
        Assertions.assertEquals("Ohlsson", appUserTest.getLastName());
        Assertions.assertEquals("no.valid.email.not", appUserTest.getEmail());
    }

    @Test
    @DisplayName("Test 3: test equal method")
    public void test_equals() {
        AppUser expected = new AppUser(
                1,
                "Björn",
                "Larsson",
                "bjorn.nykalt@gmail.com");
        AppUser actual = appUserTest;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test 4: test hash codeof student object")
    public void test_hashCode() {
        AppUser expected = new AppUser(
                1,
                "Björn",
                "Larsson",
                "bjorn.nykalt@gmail.com");


        AppUser actual = appUserTest;
        Assertions.assertEquals(expected.hashCode(), actual.hashCode());

    }
}
