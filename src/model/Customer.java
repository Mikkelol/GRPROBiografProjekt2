package model;

/**
 * Created by Mikkel on 11/29/2015.
 * Class used for storing information on customers
 */
public class Customer {

    private String name;
    private String number;

    public Customer(String name, String number) {

        this.name = name;
        this.number = number;

    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

}
