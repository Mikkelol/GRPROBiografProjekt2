package controller;
import exceptions.IllegalTimeAndDateFormatException;
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
    public void testAddReservation() throws Exception {
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
        controller.addReservation(r);
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
        //very much like testAddReservation, but allows us to narrow down where it went wrong if addReservation test fails
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
        // call method and check if the reservation added is the same as the one returned by the method
        controller.addReservation(r);
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

        controller.addReservation(r);
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
    @Test
    public void testSaveReservation()throws Exception{
        Controller controller = new Controller();
        String name = "Peter Pann";
        String number = "12138975";
        Show s = new Show(new Theater("Theater 1",20,20),"Find Dorry","2015-12-18",1600);
        ArrayList<int[]> seats = new ArrayList<int[]>();
        seats.add(new int[]{0,0});
        seats.add(new int[]{15,11});
        seats.add(new int[]{19,13});
        seats.add(new int[]{12,10});
        Customer c = new Customer("Peter Pann","12138975");
        // has the reservation been added and the seats reserved?
        controller.saveReservation(s,name,number,seats);

        Reservation r = controller.findReservation(c,s);

        assertNotEquals(null,r,s);
        assertTrue(r.getShow().getTheater().getSpecificSeat(0,0));
        assertTrue(r.getShow().getTheater().getSpecificSeat(15,11));
        assertTrue(r.getShow().getTheater().getSpecificSeat(19,13));
        assertTrue(r.getShow().getTheater().getSpecificSeat(12,10));

        // if a new reservation is saved to the same show the old one should be removed and replaced.

        Reservation r1 = controller.findReservation(c,s);
        ArrayList<int[]> newSeats = new ArrayList<int[]>();
        newSeats.add(new int[]{5,5});
        newSeats.add(new int[]{4,5});
        newSeats.add(new int[]{5,4});
        newSeats.add(new int[]{3,3});

        controller.saveReservation(s,name,number,newSeats);
        assertEquals(1,controller.getReservationList(c).size());

        assertFalse(r.getShow().getTheater().getSpecificSeat(0,0));
        assertFalse(r.getShow().getTheater().getSpecificSeat(15,11));
        assertFalse(r.getShow().getTheater().getSpecificSeat(19,13));
        assertFalse(r.getShow().getTheater().getSpecificSeat(12,10));

        assertTrue(r1.getShow().getTheater().getSpecificSeat(5,5));
        assertTrue(r1.getShow().getTheater().getSpecificSeat(4,5));
        assertTrue(r1.getShow().getTheater().getSpecificSeat(5,4));
        assertTrue(r1.getShow().getTheater().getSpecificSeat(3,3));

    }
    @Test
    public void testGetReservationList() throws Exception{
         Controller controller = new Controller();
        Customer c = new Customer("Gertrud Petersen", "76543234");
        Customer c2 = new Customer("Mordekai Derpsen", "43234567");
        Show s = new Show(new Theater("Theater 1",20,20),"Find Dorry","2015-12-18",1600);
        Show s2 = new Show(new Theater("Theater 1",20,20),"Find Dorry","2015-12-19",1600);
        Show s3 = new Show(new Theater("Theater 1",20,20),"Dorry-ception","2015-12-20",1600);
        ArrayList<int[]> seats = new ArrayList<int[]>();
        seats.add(new int[]{0,0});
        seats.add(new int[]{15,11});
        seats.add(new int[]{19,13});
        seats.add(new int[]{12,10});
         Reservation r = new Reservation(s,c,seats);
        ArrayList<int[]> newSeats = new ArrayList<int[]>();
        newSeats.add(new int[]{5,5});
        newSeats.add(new int[]{4,5});
        newSeats.add(new int[]{5,4});
        newSeats.add(new int[]{3,3});
        Reservation r1 = new Reservation(s2,c,newSeats);

        controller.addReservation(r1);
        controller.addReservation(r);
        /*the size of the ArrayList given by getReservationList should be equal to the amount of added reservations by
          a customer. */
        assertEquals(2,controller.getReservationList(c).size());
        //the size of the ArrayList should not change if an other customer makes a reservation
        Reservation r2 = new Reservation(s3,c2,seats);
        controller.addReservation(r2);

        assertEquals(2,controller.getReservationList(c).size());
    }
    @Test
    public void testRemoveReservation()throws Exception
    {
        Controller controller = new Controller();
        Customer c = new Customer("Gertrud Petersen", "76543234");
        Show s = new Show(new Theater("Theater 1",20,20),"Find Dorry","2015-12-18",1600);
        Show s2 = new Show(new Theater("Theater 1",20,20),"Find Dorry","2015-12-19",1600);
        ArrayList<int[]> seats = new ArrayList<int[]>();
        seats.add(new int[]{0,0});
        seats.add(new int[]{15,11});
        seats.add(new int[]{19,13});
        seats.add(new int[]{12,10});
        Reservation r = new Reservation(s,c,seats);
        ArrayList<int[]> newSeats = new ArrayList<int[]>();
        newSeats.add(new int[]{5,5});
        newSeats.add(new int[]{4,5});
        newSeats.add(new int[]{5,4});
        newSeats.add(new int[]{3,3});
        Reservation r1 = new Reservation(s2,c,newSeats);

        //add reservations
        controller.addReservation(r1);
        controller.addReservation(r);
        //make sure they are added properly
        assertEquals(2,controller.getReservationList(c).size());
        assertTrue(r.getShow().getTheater().getSpecificSeat(0,0));
        assertTrue(r.getShow().getTheater().getSpecificSeat(15,11));
        assertTrue(r.getShow().getTheater().getSpecificSeat(19,13));
        assertTrue(r.getShow().getTheater().getSpecificSeat(12,10));

        assertTrue(r1.getShow().getTheater().getSpecificSeat(5,5));
        assertTrue(r1.getShow().getTheater().getSpecificSeat(4,5));
        assertTrue(r1.getShow().getTheater().getSpecificSeat(5,4));
        assertTrue(r1.getShow().getTheater().getSpecificSeat(3,3));

        //call remove on one
        controller.removeReservation(r);
        //make sure its been removed and not the other
        assertEquals(1,controller.getReservationList(c).size());
        assertFalse(r.getShow().getTheater().getSpecificSeat(0,0));
        assertFalse(r.getShow().getTheater().getSpecificSeat(15,11));
        assertFalse(r.getShow().getTheater().getSpecificSeat(19,13));
        assertFalse(r.getShow().getTheater().getSpecificSeat(12,10));
        assertTrue(r1.getShow().getTheater().getSpecificSeat(5,5));
        assertTrue(r1.getShow().getTheater().getSpecificSeat(4,5));
        assertTrue(r1.getShow().getTheater().getSpecificSeat(5,4));
        assertTrue(r1.getShow().getTheater().getSpecificSeat(3,3));

        //remove the other and make sure all has been removed
        controller.removeReservation(r1);
        assertEquals(0,controller.getReservationList(c).size());
        assertFalse(r.getShow().getTheater().getSpecificSeat(0,0));
        assertFalse(r.getShow().getTheater().getSpecificSeat(15,11));
        assertFalse(r.getShow().getTheater().getSpecificSeat(19,13));
        assertFalse(r.getShow().getTheater().getSpecificSeat(12,10));
        assertFalse(r1.getShow().getTheater().getSpecificSeat(5,5));
        assertFalse(r1.getShow().getTheater().getSpecificSeat(4,5));
        assertFalse(r1.getShow().getTheater().getSpecificSeat(5,4));
        assertFalse(r1.getShow().getTheater().getSpecificSeat(3,3));
    }
}