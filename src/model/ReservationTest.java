package model;

import exceptions.IllegalArrayListException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Olaleo on 16-12-2015.
 */
public class ReservationTest {

    @Test
    public void testShouldNotThrowExceptionOnCorrectShowAndCustomerAndSeats()throws Exception
    {
        try
        {
            int[] test = new int[]{0,0};
            ArrayList<int[]> testList = new ArrayList<>();
            testList.add(test);
            Customer customer = new Customer("Jens Hansen","12345678");
            Theater theater = new Theater("test",4,5);
            Show show = new Show(theater,"testFilm","2015-06-12",1600);
            new Reservation(show,customer,testList);
        }
        catch (IllegalArrayListException e)
        {
            fail();
        }
    }

    @Test
    public void testShouldThrowExceptionOnCorrectShowAndCustomerAndIncorrectSeatsAsTooSmall()throws Exception
    {
        try
        {
            int[] test = new int[]{0};
            ArrayList<int[]> testList = new ArrayList<>();
            testList.add(test);
            Customer customer = new Customer("Jens Hansen","12345678");
            Theater theater = new Theater("test",4,5);
            Show show = new Show(theater,"testFilm","2015-06-12",1600);
            new Reservation(show,customer,testList);
            fail();
        }
        catch (IllegalArrayListException e)
        {

        }
    }

    @Test
    public void testShouldThrowExceptionOnCorrectShowAndCustomerAndIncorrectSeatsAsTooBig()throws Exception
    {
        try
        {
            int[] test = new int[]{0,0,0};
            ArrayList<int[]> testList = new ArrayList<>();
            testList.add(test);
            Customer customer = new Customer("Jens Hansen","12345678");
            Theater theater = new Theater("test",4,5);
            Show show = new Show(theater,"testFilm","2015-06-12",1600);
            new Reservation(show,customer,testList);
            fail();
        }
        catch (IllegalArrayListException e)
        {

        }
    }




    @Test
    public void testChangeReservation() throws Exception
    {
        int[] test = new int[]{0,0};
        ArrayList<int[]> testList = new ArrayList<int[]>();
        testList.add(test);
        Customer customer = new Customer("Jens Hansen","12345678");
        Theater theater = new Theater("test",4,5);
        Show show = new Show(theater,"testFilm","2015-06-12",1600);
        Reservation reservation = new Reservation(show,customer,testList);
        assertEquals(reservation.getSeats(),testList);
        ArrayList<int[]> testList2 = new ArrayList<>();
        testList2.add(new int[]{1,1});
        reservation.changeReservation(testList2);
        assertEquals(reservation.getSeats(),testList2);
    }

    @Test
    public void testGetCustomer() throws Exception
    {
        int[] test = new int[]{0,0};
        ArrayList<int[]> testList = new ArrayList<>();
        testList.add(test);
        Customer customer = new Customer("Jens Hansen","12345678");
        Theater theater = new Theater("test",4,5);
        Show show = new Show(theater,"testFilm","2015-06-12",1600);
        Reservation reservation = new Reservation(show,customer,testList);
        assertEquals(reservation.getCustomer(),customer);
    }

    @Test
    public void testGetSeats() throws Exception
    {
        int[] test = new int[]{0,0};
        ArrayList<int[]> testList = new ArrayList<>();
        testList.add(test);
        Customer customer = new Customer("Jens Hansen","12345678");
        Theater theater = new Theater("test",4,5);
        Show show = new Show(theater,"testFilm","2015-06-12",1600);
        Reservation reservation = new Reservation(show,customer,testList);
        assertEquals(reservation.getSeats(), testList);
    }

    @Test
    public void testGetShow() throws Exception
    {
        int[] test = new int[]{0,0};
        ArrayList<int[]> testList = new ArrayList<>();
        testList.add(test);
        Customer customer = new Customer("Jens Hansen","12345678");
        Theater theater = new Theater("test",4,5);
        Show show = new Show(theater,"testFilm","2015-06-12",1600);
        Reservation reservation = new Reservation(show,customer,testList);
        assertEquals(reservation.getShow(), show);
    }
}