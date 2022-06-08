package server;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
//    private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
//    private static final String user = "iulian";
//    private static final String password = "iulian";
//
//    private static Connection connection = null;
//
//    private static HikariConfig config = new HikariConfig("src/main/resources/db.properties");
//    private static HikariDataSource dataSource = new HikariDataSource(config);

    private static OracleDataSource dataSource = null;
    static {
        try {
            dataSource = new OracleDataSource();
            dataSource.setURL("jdbc:oracle:thin:@localhost:1521:XE");
            dataSource.setUser("iulian");
            dataSource.setPassword("iulian");
            dataSource.setImplicitCachingEnabled(true);
            dataSource.setConnectionProperty("MinLimit", "3");
            dataSource.setConnectionProperty("MaxLimit", "15");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private DataSource() {
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
//
//    private static void createConnection()
//    {
//        try {
//            connection = DriverManager.getConnection(url, user, password);
//            connection.setAutoCommit(false);
//
//        } catch (SQLException e) {
//            System.err.println(e);
//        }
//    }
//
//    public void closeConnection()
//    {
//        if(connection != null) {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}

