package controller;

import model.Show;
import model.Theater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Mikkel lamhauge on 10-12-2015.
 * test class for Instanciators methods
 */
public class InstanciatorTest {


    @org.junit.Test
    public void testCreateTheaterMap() throws Exception {
        HashMap<String, Theater> theater = Instanciator.createTheaterMap();
        /*following 6 lines greatly inspired by http://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
        * for help iterating through a HashMap*/
        Iterator it = theater.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            assertTrue(pair.getKey()!=null);
            assertTrue(pair.getValue()!=null);
            it.remove(); // avoids a ConcurrentModificationException
        }

    }

    @org.junit.Test
    //tests that all shows in the showList has been made correctly(at least has some value)
    public void testCreateShowList() throws Exception {
        ArrayList<Show> show = Instanciator.createShowlist();
        for(Show s: show) {
            assertTrue(s!=null);
            assertTrue(s.getFilm()!=null);
            assertTrue(s.getDate()!=null);
            assertTrue(s.getTime()!=0);
            assertTrue(s.getTheater()!=null);
        }
    }
}