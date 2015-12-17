package model;

import exceptions.CustomerException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Tobias Scavenius on 14-12-2015.
 */
public class CustomerTest {

    @Test
    public void testThrowsExceptionOnIncorrectName() {
        try {

            Customer testCustomer1 = new Customer("1337 H4x0r","51785962");
            Assert.fail();

        } catch (CustomerException e) {

        }
    }


    @Test
    public void testShouldNotThrowExceptionOnCorrectNameAndNumberWithSpaces() {

        try {

            Customer testCustomer2 = new Customer("Emil Hansen","51 78 56 32");

        } catch (CustomerException e) {
            Assert.fail();
        }
    }

    @Test
    public void testThrowsExceptionOnEmptyName() {


        try {

            Customer testCustomer3 = new Customer("","");
            Assert.fail();

        } catch (CustomerException e) {

        }


    }

    @Test
    public void testShouldNotThrowExceptionOnPerfectName() {

        try {

            Customer testCustomer0 = new Customer("Emil Hansen","51785632");

        } catch (CustomerException e) {
            Assert.fail();
        }

    }

}
