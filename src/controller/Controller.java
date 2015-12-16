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

        reserveSeats(theater, reservation.getSeats());

        reservations.add(reservation);

    }
    //finds a reservation with a costumers name, phone number and show
    public Reservation findReservation(Customer customer, Show show) {

        for (Reservation r: reservations) {

            if(customer.getName().equals(r.getCustomer().getName()) && customer.getNumber().equals(r.getCustomer().getNumber()) && show.getFilm().equals(r.getShow().getFilm())&&show.getDate().equals(r.getShow().getDate())&& show.getTheater().equals(r.getShow().getTheater())&& show.getTime()== r.getShow().getTime())
            {

                return r;

            }

        }

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
        unreserveSeats(theater, r.getSeats());
        //stores the new selected seats in the reservation
        r.changeReservation(seats);
        //sets the new selected seats as reserved
        reserveSeats(theater, seats);
    }



    private void reserveSeats(Theater theater, ArrayList<int[]> seats) {

        for (int[] seat: seats) {

            theater.setReservationTrue(seat[0], seat[1]);

        }

    }
    private void unreserveSeats(Theater theater, ArrayList<int[]> seats) {

        for (int[] seat: seats) {

            theater.setReservationFalse(seat[0], seat[1]);

        }

    }
    public void saveReservation(Show s, String name, String number, ArrayList<int[]> seats) throws CustomerException
    {
        try {
            Customer c = new Customer(name, number);
            if(findReservation(c,s)== null) {
                Reservation r = new Reservation(s, c, seats);
                addReservation(r);
            }
            else{
                changeReservation(c,s,seats);
            }
        }
        catch(IllegalArrayListException r){
            System.out.println("invalid input");
        }

    }

    public ArrayList<Show> getShows()
    {
        return shows;
    }
    public void removeReservation(Reservation reservation){
        int i=0;
        boolean isFound=false;
        while(!isFound){
            if(reservations.get(i).equals(reservation)) {
                unreserveSeats(reservation.getShow().getTheater(), reservation.getSeats());
                reservations.remove(reservation);
                isFound=true;
            }
            i++;
        }
    }
}
