package com.example.demo.designpattern.template.callback.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户数据查询impl
 *
 * @author limh
 * @version 2020年06月16日 12:27 limh Exp $
 */
public class JdbcTemplateUserImpl extends JdbcTemplate {

    @Override
    protected Object doInStatement(ResultSet resultSet) {
        List<User> userList = new ArrayList<>();

        User user = null;
        try {
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setTelephone(resultSet.getString("telephone"));
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
