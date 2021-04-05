package org.jacob.presto.connection;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class PrestoDataSource implements DataSource {

    Properties properties = new Properties();

    private Connection connection;

    private String driverClassName;
    private String url;
    private String userName;
    private String password;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        if(url.isEmpty())
            return "jdbc:presto://localhost:8080/hive/default";
        else
            return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Connection getConnection() throws SQLException {
        if (connection == null)
            return getConnection(getUserName(), getPassword());
        else
            return connection;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        properties.setProperty("user", username);
        return connection = DriverManager.getConnection(getUrl(), this.properties);
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        throw new SQLFeatureNotSupportedException("This version is not supported functions!!!");
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        throw new SQLFeatureNotSupportedException("This version is not supported functions!!!");
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        throw new SQLFeatureNotSupportedException("This version is not supported functions!!!");
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        throw new SQLFeatureNotSupportedException("This version is not supported functions!!!");
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException("This version is not supported functions!!!");
    }

    public boolean close() {
        if (connection != null) {
            return close();
        }
        return false;
    }
}
