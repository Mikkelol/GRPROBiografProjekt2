package model;

import java.util.ArrayList;

/**
 * Created by scavenius on 12/1/15.
 * class that keeps track of what seats are reserved by a specific customer
 * */
public class Reservation {

    private Show show;
    private Customer customer;
    private ArrayList<int[]>seats;

    public Reservation(Show show, Customer customer, ArrayList<int[]> seats) {

        this.customer = customer;
        this.seats = seats;
        this.show = show;

    }

    //Essentially a setter
    public void changeReservation (ArrayList<int[]> seats) {

        this.seats = seats;

    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<int[]> getSeats() {
        return seats;
    }

    public Show getShow() {

        return show;

    }

}
