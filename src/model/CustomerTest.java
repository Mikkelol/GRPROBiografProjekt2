package model;

import exceptions.CustomerException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

/**
 * Created by Tobias Scavenius on 14-12-2015.
 */
public class CustomerTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = CustomerException.class)
    public void testThrowsExceptionOnIncorrectName() {

        thrown.expect(new  CustomerException());
        Customer testCustomer1 = new Customer("1337 H4x0r","51785 962");

    }

    @Test(expected = CustomerException.class)
    public void testThrowsExceptionOnCorrectName() {

        Customer testCustomer2 = new Customer("Emil Hansen","51 78 56 32");

    }

    @Test(expected = CustomerException.class)
    public void testThrowsExceptionOnEmptyName() {

        Customer testCustomer3 = new Customer("","");

    }

    @Test(expected = CustomerException.class)
    public void testThrowsExceptionOnPerfectName() {

        Customer testCustomer0 = new Customer("Emil Hansen","51785632");

    }

    // method recreated because private classes cannot be tested remotely
    private boolean assertIsName(Customer customer) {

        return !customer.getName().matches(".*[a-zA-z].*") && !customer.getName().matches(".*[a-zA-z].*");

    }

    @org.junit.Test
    public void testGetNumber() throws Exception {

        try {

            //Make the necessary components
            Customer testCustomer0 = new Customer("Emil Hansen","51785632");
            Customer testCustomer1 = new Customer("1337 H4x0r","51785 962");
            Customer testCustomer2 = new Customer("Emil Hansen","51 78 56 32");
            Customer testCustomer3 = new Customer("","");

        } catch (CustomerException e) {

        }


    }

}
