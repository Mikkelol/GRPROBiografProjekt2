package model;

import exceptions.IllegalArrayListException;

import java.util.ArrayList;

/**
 * Created by scavenius on 12/1/15.
 * class that keeps track of what seats are reserved by a specific customer
 * */
public class Reservation {

    private Show show;
    private Customer customer;
    private ArrayList<int[]>seats;

    public Reservation(Show show, Customer customer, ArrayList<int[]> seats) throws IllegalArrayListException {

            this.customer = customer;
            this.show = show;

            if (assertCorrectArrayList(seats)) {

                this.seats = seats;

            } else {

                throw new IllegalArrayListException();

            }

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

    private boolean assertCorrectArrayList(ArrayList<int[]> seats) {

        boolean lengthCheck = true;

        for (int[] i: seats) {

            if (!(i.length == 2)) {

                lengthCheck = false;

            }

        }

        return seats.size()>0 && lengthCheck;

    }

}
