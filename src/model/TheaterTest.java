package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by Olaleo on 16-12-2015.
 */
public class TheaterTest {

    Theater testTheater;

    @Before
    public void setUp() throws Exception
    {

        testTheater = new Theater("fourByFour", 4, 5);
    }

    @After
    public void tearDown() throws Exception
    {

    }

    @Test
    public void testShouldNotThrowExceptionOnCorrectRowsAndCorrectColumns() throws Exception
    {
        try
        {
            new Theater("test", 4, 4);
        }
        catch (IllegalArgumentException e)
        {
            fail();
        }
    }

    @Test
    public void testShouldThrowExceptionOnCorrectRowsAndIncorrectColumnsOfValueZero() throws Exception
    {
        try
        {
            new Theater("test", 4, 0);
            assertFalse(true);
        }
        catch (IllegalArgumentException e)
        {

        }
    }

    @Test
    public void testShouldThrowExceptionOnCorrectRowsAndIncorrectColumnsOfNegativeValue() throws Exception
    {
        try
        {
            new Theater("test", 4, -4);
            assertFalse(true);
        }
        catch (IllegalArgumentException e)
        {

        }
    }

    @Test
    public void testShouldThrowExceptionOnIncorrectRowsOfValueZeroAndCorrectColumns() throws Exception
    {
        try
        {
            new Theater("test", 0, 4);
        }
        catch (IllegalArgumentException e)
        {

        }
    }
    @Test
    public void testShouldThrowExceptionOnInCorrectRowsOfValueZeroAndIncorrectColumnsOfValueZero() throws Exception
    {
        try
        {
            new Theater("test", 0, 0);
            assertFalse(true);
        }
        catch (IllegalArgumentException e)
        {

        }
    }

    @Test
    public void testShouldThrowExceptionOnInCorrectRowsOfValueZeroIncorrectColumnsOfNegativeValue() throws Exception
    {
        try
        {
            new Theater("test", 0, -4);
            assertFalse(true);
        }
        catch (IllegalArgumentException e)
        {

        }
    }

    @Test
    public void testShouldThrowExceptionOnIncorrectRowsOfNegativeValueAndCorrectColumns() throws Exception
    {
        try
        {
            new Theater("test", -4, 4);
        }
        catch (IllegalArgumentException e)
        {

        }
    }
    @Test
    public void testShouldThrowExceptionOnInCorrectRowsOfNegativeValueAndIncorrectColumnsOfValueZero() throws Exception
    {
        try
        {
            new Theater("test", -4, 0);
            assertFalse(true);
        }
        catch (IllegalArgumentException e)
        {

        }
    }

    @Test
    public void testShouldThrowExceptionOnInCorrectRowsOfNegativeValueIncorrectColumnsOfNegativeValue() throws Exception
    {
        try
        {
            new Theater("test", -4, -4);
            assertFalse(true);
        }
        catch (IllegalArgumentException e)
        {

        }
    }

    @Test
    public void testCopyConstructor() throws Exception
    {
        Theater theater1 = new Theater("test", 4, 5);
        Theater theater2 = new Theater(theater1);
        assertEquals(theater1.getIdentifier(),theater2.getIdentifier());
        assertEquals(theater1.getNumberOfRows(),theater2.getNumberOfRows());
        assertEquals(theater1.getNumberOFSeats(),theater2.getNumberOFSeats());
        assertEquals(theater1.getSeats().length,theater2.getSeats().length);
        assertEquals(theater1.getSeats()[0].length,theater2.getSeats()[0].length);
    }


    @Test
    public void testSetReservationTrue() throws Exception
    {
        for (int i = 0; i<testTheater.getSeats().length; i++)
        {
            for (int j = 0; j<testTheater.getSeats()[0].length;j++)
            {
                assertFalse(testTheater.getSeats()[i][j]);
                testTheater.setReservationTrue(i, j);
                assertTrue(testTheater.getSeats()[i][j]);
            }
        }
    }

    @Test
    public void testSetReservationFalse() throws Exception
    {
        for (int i = 0; i<testTheater.getSeats().length; i++)
        {
            for (int j = 0; j<testTheater.getSeats()[0].length;j++)
            {
                assertFalse(testTheater.getSeats()[i][j]);
                testTheater.setReservationTrue(i,j);
                assertTrue(testTheater.getSeats()[i][j]);
                testTheater.setReservationFalse(i, j);
                assertFalse(testTheater.getSeats()[i][j]);
            }
        }
    }

    @Test
    public void testGetSeats() throws Exception
    {
        int i = 4, j=5;
        Theater theater = new Theater("test", i,j);
        assertEquals(theater.getSeats().length,i);
        assertEquals(theater.getSeats()[0].length,j);
    }

    @Test
    public void testGetIdentifier() throws Exception
    {
        String test = "test";
        Theater testTheater = new Theater(test, 4,4);
        assertEquals(testTheater.getIdentifier(),test);
    }

    @Test
    public void testGetSpecificSeat() throws Exception
    {
        for (int i = 0; i<testTheater.getSeats().length; i++)
        {
            for (int j = 0; j<testTheater.getSeats()[0].length;j++)
            {
                assertFalse(testTheater.getSpecificSeat(i,j));
                testTheater.setReservationTrue(i, j);
                assertTrue(testTheater.getSpecificSeat(i,j));
            }
        }
    }


    @Test
    public void testGetNumberOFSeats() throws Exception
    {
        int seats = 4;
        Theater theater = new Theater("test", seats,5 );
        assertEquals(theater.getNumberOFSeats(),seats);
    }

    @Test
    public void testGetNumberOfRows() throws Exception
    {
        int rows = 4;
        Theater theater = new Theater("test", 5,rows );
        assertEquals(theater.getNumberOfRows(),rows);
    }
}