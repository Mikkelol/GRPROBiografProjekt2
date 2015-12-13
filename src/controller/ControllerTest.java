package controller;
import model.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Mikkel on 12/11/2015.
 * Test class for the controllers methods.
 */
public class ControllerTest {

    @Test
    public void testAddreservation() throws Exception {
        //Make the neccesary components for the method
        Controller controller = new Controller();
        Customer c = new Customer("Søren Andersen","30205060");
        Show s = new Show(new Theater("Theater 1",20,20),"Find Dorry","2015-12-18",1600);
        ArrayList<int[]> seats = new ArrayList<int[]>();
        seats.add(new int[]{2,2});
        seats.add(new int[]{2,1});
        seats.add(new int[]{2,3});
        seats.add(new int[]{2,4});
        Reservation r = new Reservation(s,c,seats);

        //call the method
        controller.addreservation(r);
        //checking if the seats get reserved
        assertTrue(r.getShow().getTheater().getSpecificSeat(2,2));
        assertTrue(r.getShow().getTheater().getSpecificSeat(2,1));
        assertTrue(r.getShow().getTheater().getSpecificSeat(2,3));
        assertTrue(r.getShow().getTheater().getSpecificSeat(2,4));
        // checking if the reservation correctly gets added to the reservation list
        assertEquals(r, controller.findReservation(c, s));
    }

    @Test
    public void testFindReservation() throws Exception {
        //make the components
        Controller controller = new Controller();
        Customer c = new Customer("Søren Andersen","30205060");
        Show s = new Show(new Theater("Theater 1",20,20),"Find Dorry","2015-12-18",1600);
        ArrayList<int[]> seats = new ArrayList<int[]>();
        seats.add(new int[]{2,2});
        seats.add(new int[]{2,1});
        seats.add(new int[]{2,3});
        seats.add(new int[]{2,4});
        Reservation r = new Reservation(s,c,seats);
        // call method and chekc if the reservation added is the same as the one returned by the method
        controller.addreservation(r);
        assertEquals(r, controller.findReservation(c, s));
    }

    @Test
    public void testChangeReservation() throws Exception {
        Controller controller = new Controller();
        Customer c = new Customer("Søren Andersen","30205060");
        Show s = new Show(new Theater("Theater 1",20,20),"Find Dorry","2015-12-18",1600);
        ArrayList<int[]> seats = new ArrayList<int[]>();
        seats.add(new int[]{2,2});
        seats.add(new int[]{2,1});
        seats.add(new int[]{2,3});
        seats.add(new int[]{2,4});
        Reservation r = new Reservation(s,c,seats);

        controller.addreservation(r);
        //are the seats still reserved if you use change reservation and do not change anything
        controller.changeReservation(c,s,seats);
        assertTrue(r.getShow().getTheater().getSpecificSeat(2,2));
        assertTrue(r.getShow().getTheater().getSpecificSeat(2,1));
        assertTrue(r.getShow().getTheater().getSpecificSeat(2,3));
        assertTrue(r.getShow().getTheater().getSpecificSeat(2,4));

        //does the method properly change the reserved seats?
        ArrayList<int[]> newSeats = new ArrayList<int[]>();
        newSeats.add(new int[]{5,5});
        newSeats.add(new int[]{4,5});
        newSeats.add(new int[]{5,4});
        newSeats.add(new int[]{3,3});

        controller.changeReservation(c,s,newSeats);
        //the old seats must not be reserved anymore
        assertFalse(r.getShow().getTheater().getSpecificSeat(2,2));
        assertFalse(r.getShow().getTheater().getSpecificSeat(2,1));
        assertFalse(r.getShow().getTheater().getSpecificSeat(2,3));
        assertFalse(r.getShow().getTheater().getSpecificSeat(2,4));
        //and the new ones must be reserved
        assertTrue(r.getShow().getTheater().getSpecificSeat(5,5));
        assertTrue(r.getShow().getTheater().getSpecificSeat(4,5));
        assertTrue(r.getShow().getTheater().getSpecificSeat(5,4));
        assertTrue(r.getShow().getTheater().getSpecificSeat(3,3));

    }


}