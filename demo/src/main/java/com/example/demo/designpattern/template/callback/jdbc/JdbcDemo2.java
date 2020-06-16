package com.example.demo.designpattern.template.callback.jdbc;

import java.util.List;

/**
 * @author limh
 * @version 2020年06月16日 12:34 limh Exp $
 */
public class JdbcDemo2 {

    public static void main(String[] args) {
        String sql = "select * from user";
        JdbcTemplate jdbcTemplate = new JdbcTemplateUserImpl();
        List<User> userList = (List<User>)jdbcTemplate.excute(sql);
    }
}
