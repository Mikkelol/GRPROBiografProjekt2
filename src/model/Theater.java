package model;

/**
 * Created by Tobias Scavenius on 29-11-2015.
 */
public class Theater {

    private String identifier;
    private boolean[][] seats;

    public Theater(String identifier, int maxNumberOfColumns, int maxNumberOfRows) {

        this.seats = new boolean[maxNumberOfColumns][maxNumberOfRows];

    }

    public Theater(String identifier, int maxNumber) {

        this.seats = new boolean[maxNumber][maxNumber];

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

    public boolean getSpecificSeat(int column, int row) {
        return seats[column][row];
    }

    public void flipReservation(int column, int row) {
        seats[column][row] = !seats[column][row];
    }

}