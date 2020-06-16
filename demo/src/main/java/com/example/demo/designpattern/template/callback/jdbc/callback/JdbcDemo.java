package com.example.demo.designpattern.template.callback.jdbc.callback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.designpattern.template.callback.jdbc.User;

/**
 * @author limh
 * @version 2020年06月16日 20:16 limh Exp $
 */
public class JdbcDemo {

    public static void main(String[] args) {
        String sql = "select * from user";
        System.out.println(new JdbcDemo().query(sql));
    }

    public Object query(String sql) {
        class QueryStatementCallback implements StatementCallback {
            @Override
            public Object doInStatement(Statement stmt) throws SQLException {
                ResultSet rs = stmt.executeQuery(sql);
                List<User> userList = new ArrayList<>();

                User user = null;
                while (rs.next()) {
                    user = new User();
                    user.setId(rs.getLong("id"));
                    user.setName(rs.getString("name"));
                    user.setTelephone(rs.getString("telephone"));
                    userList.add(user);
                }
                return userList;
            }
        }

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        return jdbcTemplate.excute(new QueryStatementCallback());
    }
}
