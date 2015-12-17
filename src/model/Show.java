package model;


import exceptions.IllegalTimeAndDateFormatException;

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

    public Show(Theater theater, String film, String date, int time) throws IllegalTimeAndDateFormatException {

        this.theater = theater;
        this.film = film;

        if (assertProperTimeAndDateFormat(date, time)) {

            this.time = time;
            this.date = date.replaceAll("\\s", "");

        } else {

            throw new IllegalTimeAndDateFormatException("Database corrupt: Error in the time and date format");

        }

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

    private boolean assertProperTimeAndDateFormat(String date, int time) {

        String[] dateArray = date.replaceAll("\\s", "").split("-");

        if (!(dateArray.length == 3) || !(dateArray[0].length() == 4)) {

            return false;

        }  else if (!(dateArray[1].length() == 2 && dateArray[2].length() == 2)) {

            return false;

        } else {

            if (Integer.parseInt(dateArray[0])<0) {

                return false;

            } else if (Integer.parseInt(dateArray[1])<1 || !(dateArray[1].matches("[0-1][0-9]"))) {

                return false;

            } else if (Integer.parseInt(dateArray[2])<1 || !(dateArray[2].matches("[0-3][0-9]"))) {

                return false;

            }

        }

        String stringTime = String.valueOf(time);

        while(stringTime.length() < 4) {

            stringTime = "0" + stringTime;

        }

        boolean correctTimeFormat = !(stringTime.matches("[0-1][0-9][0-5][0-9]") || stringTime.matches("2[0-3][0-5][0-9]"));

        if (time < 0 || !(stringTime.length() == 4) || correctTimeFormat) {

            return false;

        }

        return true;

    }

}
