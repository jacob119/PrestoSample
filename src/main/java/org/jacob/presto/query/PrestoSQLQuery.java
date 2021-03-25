package org.jacob.presto.query;

import org.jacob.presto.connection.PrestoServerConnection;
import org.jacob.presto.mapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class PrestoSQLQuery<T> extends PrestoServerConnection {
    public PrestoSQLQuery(String jdbcUrl, Properties properties) {
        super(jdbcUrl, properties);
    }

    public PrestoSQLQuery(String jdbcUrl, String userId) {
        super(jdbcUrl, userId);
    }

    public T exec(String sqlText, RowMapper<T> rowMapper) {
        int rowNum = 0;
        try (Statement stmt = connection().createStatement()) {
            ResultSet rs = stmt.executeQuery(sqlText);
            while (rs.next()) {
                return rowMapper.mapRow(rs, rowNum++);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}

