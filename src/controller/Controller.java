package controller;

import exceptions.CustomerException;
import exceptions.IllegalArrayListException;
import model.*;

import java.util.ArrayList;

/**
 * Created by Mikkel on 12/1/2015.
 * Main controller class. In charge of storing and altering the arraylists of reservations and shows.
 */
public class Controller {

    private ArrayList<Reservation> reservations;
    private ArrayList<Show> shows;



    public Controller(){

        this.reservations = new ArrayList<Reservation>();
        this.shows = Instanciator.createShowlist();

    }
    //sets the seats to the given show as reserved and stores the reservation in the list of reservations.
    public void addReservation(Reservation reservation) {

        Theater theater = reservation.getShow().getTheater();

        notifyTheater(theater, reservation.getSeats());

        reservations.add(reservation);

    }
    //finds a reservation with a costumers name, phone number and show
    public Reservation findReservation(Customer customer, Show show) {

        for (Reservation r: reservations) {

            if(customer.equals(r.getCustomer()) && show.equals(r.getShow())) {

                return r;

            }

        }

        System.out.println("Controller.findReservation: No reservation found");
        return null;

    }

    public ArrayList<Reservation> getReservationList(Customer customer)
    {
        ArrayList<Reservation> returnList = new ArrayList<Reservation>();

        for (Reservation r: reservations)
        {
            if (customer.getName().equals(r.getCustomer().getName()) && customer.getNumber().equals(r.getCustomer().getNumber()))
            {
                returnList.add(returnList.size(),r);
            }
        }

        return returnList;
    }

    // method that overwrites a costumer's old reservation with the new one.
    public void changeReservation(Customer customer, Show show, ArrayList<int[]> seats) {


        //finds the reservation
        Reservation r = findReservation(customer, show);
        // Finds the theater
        Theater theater = r.getShow().getTheater();
        //sets the previously reserved seats to not reserved
        notifyTheater(theater, r.getSeats());
        //stores the new selected seats in the reservation
        r.changeReservation(seats);
        //sets the new selected seats as reserved
        notifyTheater(theater, seats);

    }


    /*method for reserving seats. The ArrayList of seats will be the seats selected by the clerk when she presses the reserve
       button. */
    private void notifyTheater(Theater theater, ArrayList<int[]> seats) {

        for (int[] seat: seats) {

            theater.flipReservation(seat[0], seat[1]);

        }

    }
    public void saveReservation(Show s, String name, String number, ArrayList<int[]> Seats)
    {
        try {
            Customer c = new Customer(name, number);

            Reservation r = new Reservation(s, c, Seats);
            addReservation(r);
        }
        catch(CustomerException | IllegalArrayListException r){
            System.out.println("invalid input");
        }
    }

    public ArrayList<Show> getShows()
    {
        return shows;
    }
}
