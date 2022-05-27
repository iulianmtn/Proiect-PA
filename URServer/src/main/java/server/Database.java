package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String url = "jdbc:oracle:thin@localhost:xe";
    private static final String user = "iulian";
    private static final String password = "iulian";
    private static Connection connection = null;

    private Database() {
    }

    public static Connection getConnection()
    {
        if(connection == null)
            createConnection();

        return connection;
    }

    private static void createConnection()
    {
        try {
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void closeConnection()
    {
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

