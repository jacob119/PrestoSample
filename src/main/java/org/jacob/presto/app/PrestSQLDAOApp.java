package org.jacob.presto.app;

import org.jacob.presto.connection.PrestoDataSource;
import org.jacob.presto.domain.UserDAO;

import java.sql.SQLException;

public class PrestSQLDAOApp {
    public static void main(String[] args) throws SQLException {
        PrestoDataSource dataSource = new PrestoDataSource();
        UserDAO userDAO = new UserDAO(dataSource);
        System.out.println(userDAO.getUser("user"));

        UserDAO users = new UserDAO(dataSource);
        System.out.println(users.getUsers("user"));
    }
}
