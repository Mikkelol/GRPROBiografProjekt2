package model;

/**
 * Created by Tobias Scavenius on 29-11-2015.
 Class representing a specific theater in the cinema. It stores a String which works as its identifier and a boolean
 double array which represents the seats and rows in the theater. A boolean saying False is a seat not reserved and a
 boolean saying true is a reserved seat in the theater.
 */

public class Theater {

    private String identifier;
    private boolean[][] seats;

    public Theater(String identifier, int maxNumberOfColumns, int maxNumberOfRows) {

        this.seats = new boolean[maxNumberOfColumns][maxNumberOfRows];
        this.identifier = identifier;

    }

    public Theater(Theater t) {

        this.identifier = t.getIdentifier();
        this.seats = t.getSeats();

    }

    public void setReservationTrue(int column, int row) {
        seats[column][row] = true;
    }

    public void setReservationFalse(int column, int row) {
        seats[column][row] = false;
    }

    public boolean[][] getSeats() {
        return seats;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public boolean getSpecificSeat(int column, int row) {
        return seats[column][row];
    }
//main method of reserving or freeing up a seat
    public void flipReservation(int column, int row) {
        seats[column][row] = !seats[column][row];
    }

}