package org.example.db;

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/Crypto";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/InversmentManagementSystem";
    private static final String ADMIN = "root";
    private static final String PASSWORD = "";
    private static Connection connection;


    public static void connectionJDBC() {
        //Step 2: Driver Load;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, ADMIN, PASSWORD);
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
            System.out.println("ForName class found failed");
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("JDBC Connection Failed");
        }
    }

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        }
        connectionJDBC();
        System.out.println("Database connection done");
        return connection;
    }
}