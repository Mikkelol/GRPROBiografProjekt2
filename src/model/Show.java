package model;


/**
 * Created by scavenius on 12/1/15.
 * Class storing a specific combination of a film, time, date and theater. Each show's theater object keeps track of
 * which seats are reserved for that specific show.
 *
 */
public class Show {

    private Theater theater;
    private String film;
    private String date;
    private int time;

    public Show(Theater theater, String film, String date, int time) {
        this.theater = theater;
        this.film = film;
        this.time = time;
    }

    public Theater getTheater() {
        return theater;
    }

    public String getFilm() {
        return film;
    }

    public String getDate() {

        return date;

    }

    public int getTime() {
        return time;
    }
}
