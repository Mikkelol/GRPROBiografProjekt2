package model;

import java.util.ArrayList;

/**
 * Created by scavenius on 12/8/15.
 */
public class Reservations {

    private ArrayList<Reservation> reservationList;

    public Reservations() {

        reservationList = new ArrayList<Reservation>();

    }

    public void add(Reservation reservation) {

        reservationList.add(reservation);

    }

    public void delete(Reservation reservation) {

        reservationList.remove(reservation);

    }

    public ArrayList<Reservation> getReservationList() {
        return reservationList;
    }
}
