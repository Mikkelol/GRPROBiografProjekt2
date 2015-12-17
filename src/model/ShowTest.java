package model;

import exceptions.IllegalTimeAndDateFormatException;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import static org.junit.Assert.*;

/**
 * Created by Olaleo on 17-12-2015.
 */
public class ShowTest {


    @Test
    public void testShouldNotThrowExceptionOnCorrectTheaterAndFilmAndTimeAndDate()
    {
        try
        {
            new Show(new Theater("test",4,5),"testFilm", "2015-06-24", 1600);
        }
        catch (IllegalTimeAndDateFormatException e)
        {

        }
    }

    @Test
    public void testShouldThrowExceptionOnCorrectTheaterAndFilmAndTimeAndInCorrectDateByMissingOneSplit()
    {
        try
        {
            new Show(new Theater("test",4,5),"testFilm", "2015-0624", 1600);
            assertFalse(true);
        }
        catch (IllegalTimeAndDateFormatException e)
        {

        }
    }

    @Test
    public void testShouldThrowExceptionOnCorrectTheaterAndFilmAndTimeAndInCorrectDateByMissingTwoSplit()
    {
        try
        {
            new Show(new Theater("test",4,5),"testFilm", "20150624", 1600);
            fail();
        }
        catch (IllegalTimeAndDateFormatException e)
        {

        }
    }

    @Test
    public void testShouldThrowExceptionOnCorrectTheaterAndFilmAndTimeAndInCorrectDateByOneSplitTooMany()
    {
        try
        {
            new Show(new Theater("test",4,5),"testFilm", "2015-06-2-4", 1600);
            fail();
        }
        catch (IllegalTimeAndDateFormatException e)
        {

        }
    }

    @Test
    public void testShouldThrowExceptionOnCorrectTheaterAndFilmAndIncorrectTimeByFirstDigitTooBigAndCorrectDate()
    {
        try
        {
            new Show(new Theater("test",4,5),"testFilm", "2015-06-24", 3600);
            fail();
        }
        catch (IllegalTimeAndDateFormatException e)
        {

        }
    }

    @Test
    public void testShouldThrowExceptionOnCorrectTheaterAndFilmAndIncorrectTimeBySecondDigitTooBigWhenFirstDigitIsTwoAndCorrectDate()
    {
        try
        {
            new Show(new Theater("test",4,5),"testFilm", "2015-06-24", 2600);
            fail();
        }
        catch (IllegalTimeAndDateFormatException e)
        {

        }
    }

    @Test
    public void testShouldThrowExceptionOnCorrectTheaterAndFilmAndIncorrectTimeByThirdDigitTooBigAndCorrectDate()
    {
        try
        {
            new Show(new Theater("test",4,5),"testFilm", "2015-06-24", 2660);
            fail();
        }
        catch (IllegalTimeAndDateFormatException e)
        {

        }
    }

    @Test
    public void testGetTheater() throws Exception
    {
        Theater theater = new Theater("test",4,5);
        Show show = new Show(theater,"test","2015-06-24", 1600);
        assertEquals(show.getTheater(),theater);
    }

    @Test
    public void testGetFilm() throws Exception
    {
        String film = "Film";
        Show show = new Show(new  Theater("test",4,5),film,"2015-06-24", 1600);
        assertEquals(show.getFilm(),film);
    }

    @Test
    public void testGetDate() throws Exception
    {
        String date = "2015-06-24";
        Show show = new Show(new  Theater("test",4,5),"test",date, 1600);
        assertEquals(show.getDate(), date);
    }

    @Test
    public void testGetTime() throws Exception
    {
        int time = 1600;
        Show show = new Show(new  Theater("test",4,5),"test","2015-06-24", time);
        assertEquals(show.getTime(), time);
    }
}