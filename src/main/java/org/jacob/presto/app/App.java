package org.jacob.presto.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Hello world!
 */
public class App {
    private static final String URL = "jdbc:presto://localhost:9080/hive/default";
    private static final String SOCKS_PROXY = "localhost:9080";
    private static final String USER = "user";
    private static final String QUERY = "select * from airline_delay_buckets limit 1 ";
//            "select count(*) as count from airline_delay_buckets ";

    public static void main(String[] args) {

        try {
            Properties properties = new Properties();
            properties.setProperty(USER, "fff");
//            properties.setProperty("ClientTags", "test app");
//            properties.setProperty("group", "global");
//            properties.setProperty()
//            properties.setProperty("socksProxy", SOCKS_PROXY);
            Connection connection = DriverManager.getConnection(URL, properties);

            try (Statement stmt = connection.createStatement()) {

                ResultSet rs = stmt.executeQuery(QUERY);
//                Thread.sleep(100000);
                while (rs.next()) {
//                   int count = rs.getInt("count");
                   int str = rs.getInt("year");
                  System.out.println("The number of long trips: " + str);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
