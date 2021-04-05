package org.jacob.presto.query;

import org.jacob.presto.mapper.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PrestoJdbcTemplate {
    private DataSource dataSource;

    public PrestoJdbcTemplate() {
    }

    public PrestoJdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Statement getStatement() throws SQLException {
        return this.dataSource.getConnection().createStatement();
    }

    public int delete(String sqlText) throws SQLException {
        return update(sqlText);
    }

    public int update(String sqlText) throws SQLException {
        return getStatement().executeUpdate(sqlText);
    }

    public <T> List<T> find(String sqlText, RowMapper<T> rowMapper) throws SQLException {
        int rowNum = 0;
        List<T> results = new ArrayList<>();
        ResultSet rs = getStatement().executeQuery(sqlText);
        while (rs.next()) {
            results.add(rowMapper.mapRow(rs, rowNum++));
        }
        return results;
    }

    public <T> T findOne(String sqlText, RowMapper<T> rowMapper) throws SQLException {
        return find(sqlText, rowMapper).get(0);
    }

}
