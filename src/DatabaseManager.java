
/*
 * Name: Lacey Roof
 * Date: November 1, 2026
 * Assignment: SDC330L Week 4 Project
 * Purpose: Connects to SQLite and creates
 * the contacts table used to store contact information.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    //Private constant for SQLite database URL
    private static final String URL = "jdbc:sqlite:fieldledger_contacts.db";

    //Public method allows other classes to connect to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);}

    //Create contacts table
    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS contacts (" +
            "contact_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "contact_type TEXT NOT NULL, " +
            "first_name TEXT NOT NULL, " +
            "last_name TEXT NOT NULL, " +
            "phone TEXT, " +
            "email TEXT, " +
            "company_name TEXT, " +
            "additional_info TEXT)";

        //Connect to database and execute SQL statement to create the table  
        //Try-with-resources ensures the connection and statement are closed automatically  
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {stmt.execute(sql);
            System.out.println("Database ready.");
        } 
        //Handle database connection errors
        catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());}
    }
}
