/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testbookingsystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Static variable to hold the single instance of the class
    private static DatabaseConnection instance;
    
    private static final String URL = "jdbc:mysql://localhost:3306/testbookingsystem1"; // Replace with your database URL
    private static final String USERNAME = "root"; // Replace with your database username
    private static final String PASSWORD = "apple1"; // Replace with your database password

    // Private constructor to prevent instantiation from other classes
    private DatabaseConnection() {}

    // Public static method to provide access to the instance
    public static DatabaseConnection getInstance() {
        // Check if instance is null, if so, create a new instance
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // Method to get the database connection
    public Connection getConnection() throws SQLException {
        try {
            // Register the JDBC driver (optional with new drivers, but kept for compatibility)
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish and return the database connection
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Database driver not found: " + e.getMessage());
            throw new SQLException("Database driver error.");
        }
    }
}

/**
 *
 * @author hp
 */

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/testbookingsystem1"; // replace with your database URL
    private static final String USERNAME = "root"; // replace with your username
    private static final String PASSWORD = "apple1"; // replace with your password
    private static Connection connection;

    // Method to establish a connection
    public static synchronized Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Connected to the database successfully!");
            } catch (SQLException e) {
                System.out.println("Failed to connect to the database.");
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Method to close the connection
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
                connection = null; // Set to null after closing
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}*/


/*

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/testbookingsystem1"; // replace with your database URL
    private static final String USERNAME = "root"; // replace with your username
    private static final String PASSWORD = "apple1"; // replace with your password

    private static Connection connection;

    // Private constructor to prevent instantiation
    private DatabaseConnection() {}

    // Method to establish a connection using the Singleton pattern
    public static Connection getConnection() {
        if (connection == null) {
            synchronized (DatabaseConnection.class) {
                if (connection == null) { // Double-checked locking
                    try {
                        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                        System.out.println("Connected to the database successfully!");
                    } catch (SQLException e) {
                        System.out.println("Failed to connect to the database.");
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }

    // Method to close the connection
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
                connection = null; // Set to null after closing
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
*/

/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/testbookingsystem1"; // replace with your database URL
    private static final String USERNAME = "root"; // replace with your username
    private static final String PASSWORD = "apple1"; // replace with your password
    
    private static DatabaseConnection instance; // Singleton instance of DatabaseConnection
    private Connection connection; // The actual database connection object

    // Private constructor to prevent instantiation
    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }

    // Method to get the singleton instance of DatabaseConnection
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // Method to get the database connection
    public Connection getConnection() {
        return connection;
    }

    // Method to close the connection
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
                connection = null; // Set to null after closing
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
*/

/*public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/testbookingsystem1"; // Replace with your database URL
    private static final String USERNAME = "root"; // Replace with your username
    private static final String PASSWORD = "apple1"; // Replace with your password

    // The Singleton instance
    private static DatabaseConnection instance;
    private Connection connection;

    // Private constructor to prevent instantiation
    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }

    // Method to retrieve the single instance of DatabaseConnection
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // Method to get the database connection
    public Connection getConnection() {
        return connection;
    }

    // Method to close the connection
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
                connection = null; // Set to null after closing
                instance = null; // Reset the instance to allow re-connection if needed
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
/*
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/testbookingsystem1";
    private String username = "root";
    private String password = "apple1";

    private DatabaseConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
*/