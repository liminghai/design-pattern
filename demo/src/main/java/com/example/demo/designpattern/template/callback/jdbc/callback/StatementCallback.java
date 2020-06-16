package com.example.demo.designpattern.template.callback.jdbc.callback;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author limh
 * @version 2020年06月16日 19:57 limh Exp $
 */
public interface StatementCallback {

    Object doInStatement(Statement stmt) throws SQLException;
}
