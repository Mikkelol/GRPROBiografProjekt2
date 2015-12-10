package controller;

import model.*;

import java.util.ArrayList;

/**
 * Created by Mikkel on 12/1/2015.
 */
public class Controller {

    private Reservations reservations;
    //private ArrayList<Reservation> reservations;
    private Shows shows;
    //private ArrayList<Show> shows;

    public Controller(){

        this.reservations = new Reservations();
        this.shows = new Shows();
        //this.shows = new ArrayList<Show>();

    }

    public void addreservation(Reservation reservation) {

        Theater theater = reservation.getShow().getTheater();

        for (int[] seat: reservation.getSeats() ) {

            theater.flipReservation(seat[0], seat[1]);

        }

        reservations.add(reservation);

    }

    public Reservation findReservation(Customer customer, Show show) {

        for (Reservation r: reservations.getReservationList()) {

            if(customer.equals(r.getCustomer()) && show.equals(r.getShow())) {

                return r;

            }

        }

        System.out.println("Controller.findReservation: No reservation found");
        return null;

    }

    public void changeReservation(Customer customer, Show show, ArrayList<int[]> seats) {

        for (Reservation r: reservations.getReservationList()) {

            if(customer.equals(r.getCustomer()) && show.equals(r.getShow())) {

                Theater theater = r.getShow().getTheater();

                // reverts the prior resaervations
                for (int[] seat: r.getSeats() ) {

                    theater.flipReservation(seat[0], seat[1]);

                }

                r.changeReservation(seats);

                // notifies theater of the new reservations
                for (int[] seat: r.getSeats() ) {

                    theater.flipReservation(seat[0], seat[1]);

                }

            }

        }

    }



}
