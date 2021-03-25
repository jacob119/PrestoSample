package org.jacob.presto.app;

import org.jacob.presto.domain.UserInfo;
import org.jacob.presto.mapper.RowMapper;
import org.jacob.presto.query.PrestoSQLQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrestoSQLApp {
    private static final String URL = "jdbc:presto://localhost:8080/hive/default";

    public static void main(String[] args) throws SQLException {
        PrestoSQLQuery<UserInfo> prestoSQLQuery = new PrestoSQLQuery<UserInfo>(URL, "21071098");
        UserInfo userInfo = prestoSQLQuery.exec("select 'jacob', '44' ", new RowMapper<UserInfo>() {
            @Override
            public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new UserInfo(rs.getString(1), Integer.parseInt(rs.getString(2)));
            }
        });
        System.out.println(userInfo.toString());


//        UserInfo user = new UserInfo(null, null);
//        List<UserInfo> users = user.getUserInfo();
    }
}


