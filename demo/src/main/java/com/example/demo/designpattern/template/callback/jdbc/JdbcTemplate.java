package com.example.demo.designpattern.template.callback.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 这个抽象类，封装了SUN JDBC API的主要流程，而遍历ResultSetz这一步奏则放到抽象方法doInStatement()中，由子类实现。
 * @author limh
 * @version 2020年06月16日 11:55 limh Exp $
 */
public abstract class JdbcTemplate {

    // 模板方法
    public final Object excute(String sql){
        Connection conn = null;
        Statement stmt = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "xzg", "xzg");

            //2.创建statement类对象，用来执行SQL语句
            stmt = conn.createStatement();

            //3.ResultSet类，用来存放获取的结果集
            ResultSet resultSet = stmt.executeQuery(sql);

            //抽象方法(定制方法，需要子类实现)
            Object result = doInStatement(resultSet);
            return result;
        } catch (ClassNotFoundException e) {
            // TODO: log...
        } catch (SQLException e) {
            // TODO: log...
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO: log...
                }
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        // TODO: log...
                    }
                }
            }
            return null;
        }
    }

    /**
     * 抽象方法（定制方法）
     * @param resultSet
     * @return
     */
    protected abstract Object doInStatement(ResultSet resultSet);
}
