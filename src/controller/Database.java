package controller;

import java.sql.*;

public class Database {
    //  controller.Database credentials
    static final String DB = "ProjectCinema";
    static final String USER = "ATM";
    static final String PASS = "a97531";

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://mysql.itu.dk/" + DB;


    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver()); // STEP 2: Register JDBC driver
            connection = DriverManager.getConnection(DB_URL, USER, PASS); // STEP 3: Open a connection
            statement = connection.createStatement(); // STEP 4: Execute a query

            String sql = "SELECT * FROM theaters";
            ResultSet rs = statement.executeQuery(sql);
            //STEP 5: Extract data from result set
            while (rs.next()) { //Retrieve by column name
                // int id  = rs.getInt("id");
                String theater = rs.getString("theater_identifier");
                //String name = rs.getString("seats");
                //Display values
                System.out.println("theater: '" + theater + "'");
            }
            rs.close();
            connection.close();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }
}

