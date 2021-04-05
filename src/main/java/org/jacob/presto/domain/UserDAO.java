package org.jacob.presto.domain;

import org.jacob.presto.query.PrestoJdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class UserDAO {
    private static final String URL = "jdbc:presto://localhost:8080/hive/default";
    PrestoJdbcTemplate prestoSQLQuery;

    public UserDAO(DataSource dataSource) {
        prestoSQLQuery = new PrestoJdbcTemplate(dataSource);
    }

    public UserInfo getUser(String userId) throws SQLException {

        return prestoSQLQuery.findOne("select 'jacob', '44' ",
                (rs, rowNum) -> new UserInfo(rs.getString(1),
                        Integer.parseInt(rs.getString(2))));

    }

    public List<UserInfo> getUsers(String userId) throws SQLException {
        return prestoSQLQuery.find("select 'jacob', '44' ",
                (rs, rowNum) -> new UserInfo(rs.getString(1),
                        Integer.parseInt(rs.getString(2))));
    }

    public int deleteUser(String userId) throws SQLException {
        return prestoSQLQuery.delete(String.format("delete from user where userid = '%s'" , userId));
    }

}
