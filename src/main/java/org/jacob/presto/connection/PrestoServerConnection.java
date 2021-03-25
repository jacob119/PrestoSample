package org.jacob.presto.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class PrestoServerConnection {

    private String jdbcUrl = "";
    private  Properties properties = new Properties();
    protected Connection connection;
    public PrestoServerConnection(String jdbcUrl, Properties properties) {
        this.jdbcUrl = jdbcUrl;
        this.properties = properties;
    }

    public PrestoServerConnection(String jdbcUrl, String user){
        this.jdbcUrl = jdbcUrl;
        properties.setProperty("user", user);
    }
    public Connection connection() throws SQLException {
        return connection = DriverManager.getConnection(this.jdbcUrl , this.properties);
    }

    public boolean close() {
        if(connection != null){
           return  close();
        }
        return false;
    }
}
