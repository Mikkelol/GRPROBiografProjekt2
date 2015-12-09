package model;

import java.util.ArrayList;

/**
 * Created by scavenius on 12/8/15.
 */
public class Shows {

    private ArrayList<Show> shows;

    public Shows() {

        shows = new ArrayList<Show>();

    }

    public void addShow(Show show) {

        shows.add(show);

    }

    public void deleteShow(Show show) {

        shows.remove(show);

    }

}
