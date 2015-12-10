package controller;

import model.Show;
import model.Theater;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by Mikkel lamhauge on 10-12-2015.
 * test class for Instanciators methods
 */
public class InstanciatorTest {

    @org.junit.Test
    public void testCreateTheaterMap() throws Exception {
        HashMap<String, Theater> theater = Instanciator.createTheaterMap();
        System.out.println(""+theater);
    }

    @org.junit.Test
    public void testCreateShowlist() throws Exception {
        ArrayList<Show> show = Instanciator.createShowlist();
        for(Show s: show) {
            System.out.println(s.getFilm());
        }
    }
}