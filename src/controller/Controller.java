package controller;

import model.*;

import java.util.ArrayList;

/**
 * Created by Mikkel on 12/1/2015.
 *
 */
public class Controller {

private ArrayList<Reservation> reservations;
private ArrayList<Show> shows;



    public Controller(){

        this.reservations = new ArrayList<Reservation>();
        this.shows = Instanciator.createShowlist();

    }

    public void addreservation(Reservation reservation) {

        Theater theater = reservation.getShow().getTheater();

        notifyTheater(theater, reservation.getSeats());

        reservations.add(reservation);

    }

    public Reservation findReservation(Customer customer, Show show) {

        for (Reservation r: reservations) {

            if(customer.equals(r.getCustomer()) && show.equals(r.getShow())) {

                return r;

            }

        }

        System.out.println("Controller.findReservation: No reservation found");
        return null;

    }
// method for adding to and removing from a reservation.
    public void changeReservation(Customer customer, Show show, ArrayList<int[]> seats) {

        for (Reservation r: reservations) {

            if(customer.equals(r.getCustomer()) && show.equals(r.getShow())) {

                Theater theater = r.getShow().getTheater();

                notifyTheater(theater, r.getSeats());

                r.changeReservation(seats);

                notifyTheater(theater, seats);

            }

        }

    }
/*method for reserving seats. The ArrayList of seats will be the seats selected by the clerk when she presses the reserve
   button. */
    private void notifyTheater(Theater theater, ArrayList<int[]> seats) {

        for (int[] seat: seats) {

            theater.flipReservation(seat[0], seat[1]);

        }

    }

    public ArrayList<Show> getShows()
    {
        return shows;
    }
}
