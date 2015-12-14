package model;

import java.util.IllegalFormatCodePointException;

/**
 * Created by Tobias Scavenius on 29-11-2015.
 Class representing a specific theater in the cinema. It stores a String which works as its identifier and a boolean
 double array which represents the seats and rows in the theater. A boolean saying False is a seat not reserved and a
 boolean saying true is a reserved seat in the theater.
 */

public class Theater {

    private String identifier;
    private boolean[][] seats;
    private int numberOfSeats;
    private int numberOfRows;

    public Theater(String identifier, int maxNumberOfColumns, int maxNumberOfRows) {

        if (assertProperSize(maxNumberOfColumns, maxNumberOfRows)) {

            numberOfRows = maxNumberOfRows;
            numberOfSeats = maxNumberOfColumns;

        } else {

            throw new IllegalArgumentException("Your column and rows cannot be less than one");

        }

        this.seats = new boolean[numberOfSeats][numberOfRows];
        this.identifier = identifier;

    }
    /*makes a theater by cloning an other one. used for keeping track of reserved seats for specific shows even though
    they are in the same theater*/
    public Theater(Theater t) {

        this.identifier = t.getIdentifier();
        numberOfRows = t.getNumberOfRows();
        numberOfSeats = t.getNumberOFSeats();
        this.seats = new boolean[numberOfSeats][numberOfRows];

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

    public int getNumberOFSeats() {return numberOfSeats;}

    public int getNumberOfRows() {return numberOfRows;}

    private boolean assertProperSize(int column, int row) {

        return column > 0 && row > 0;

    }

}