package controller;

import model.Show;
import model.Theater;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Scavenius on 12/8/15.
 *
 * most of the code was taken from https://learnit.itu.dk/pluginfile.php/142213/mod_resource/content/0/MySQL.java
 *
 */
public final class Instanciator {

    //  Database credentials
    static final String DB = "ProjectCinema";
    static final String USER = "ATM";
    static final String PASS = "a97531";

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://mysql.itu.dk/" + DB;

    //method that creates a hashmap of theater identifiers and theaters from the data in the "theaters" table in the
    //database
    public static HashMap<String, Theater> createTheaterMap() {

        Connection connection = null;
        Statement statement = null;
        HashMap<String, Theater> returnMap = new HashMap<String, Theater>();

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver()); // STEP 2: Register JDBC driver
            connection = DriverManager.getConnection(DB_URL, USER, PASS); // STEP 3: Open a connection
            statement = connection.createStatement(); // STEP 4: Execute a query

            String sql = "SELECT * FROM theaters ORDER BY theater_identifier ASC LIMIT 0 , 30";
            ResultSet rs = statement.executeQuery(sql);
            //STEP 5: Extract data from result set

            while (rs.next()) { //Retrieve by column name

                int seats = rs.getInt("seats");
                int rows = rs.getInt("rows");
                String identifier = rs.getString("theater_identifier");

                returnMap.put(identifier, new Theater(identifier, seats, rows));

            }

            rs.close();
            connection.close();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

        return returnMap;
    }
    // creates a list of shows useing the data from the "shows" table in the database and the createTheaterMap method
    public static ArrayList<Show> createShowlist() {

        Connection connection = null;
        Statement statement = null;
        ArrayList<Show> returnArray = new ArrayList<Show>();

        HashMap<String, Theater> theaterMap = createTheaterMap();

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver()); // STEP 2: Register JDBC driver
            connection = DriverManager.getConnection(DB_URL, USER, PASS); // STEP 3: Open a connection
            statement = connection.createStatement(); // STEP 4: Execute a query

            String sql = "SELECT * FROM shows ORDER BY date ASC LIMIT 0 , 30";
            ResultSet rs = statement.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) { //Retrieve by column name

                int time = rs.getInt("time");
                String date = rs.getString("date");
                String film = rs.getString("Film");
                String theater = rs.getString("Theater");

                returnArray.add(new Show(theaterMap.get(theater), film, date, time));

            }
            rs.close();
            connection.close();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

        return returnArray;
    }

}
