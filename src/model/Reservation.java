package model;

/**
 * Created by scavenius on 12/1/15.
 */
public class Reservation {

    private Show show;
    private Customer customer;
    private int[][] seats;

    public Reservation(Show show, Customer customer, int[][] seats) {

        this.customer = customer;
        this.seats = seats;
        this.show = show;

    }

    //Essentially a setter
    public void changeReservation (int[][] seats) {

        this.seats = seats;

    }

    public Customer getCustomer() {
        return customer;
    }

    public int[][] getSeats() {
        return seats;
    }

    public Show getShow() {

        return show;

    }

}
