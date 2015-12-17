package model;

import exceptions.CustomerException;

/**
 * Created by Mikkel on 11/29/2015.
 * Class used for storing information on customers
 */
public class Customer {

    private String name;
    private String number;

    public Customer(String name, String number) throws CustomerException {

        if (assertIsName(name) && assertIsNumber(number.replaceAll(" ","")))
        {

            this.name = name;
            this.number = number.replaceAll(" ","");

        } else
        {
            throw new CustomerException("Name or number is invalid please reenter. Make sure Name does not contain numbers and number is a proper danish telephone number");

        }

    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    private boolean assertIsName(String name) {

        return !name.matches(".*\\d.*") && !name.matches("");

    }

    private boolean assertIsNumber(String number) {

        return !number.matches(".*[a-zA-z].*") && !number.matches("") && (number.length() == 8);

    }

}
