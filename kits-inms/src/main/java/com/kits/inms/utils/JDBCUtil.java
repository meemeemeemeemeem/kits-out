package com.kits.inms.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil implements AutoCloseable {
    private String url;
    private String user;
    private String password;
    private Connection conn;

//    public JDBCUtil(Tbdt010 dt010) throws ClassNotFoundException {
//        Class.forName(dt010.getJdbcDriver());
//        this.url = dt010.getJdbcUrl();
//        this.user = dt010.getJdbcUserName();
//        this.password = dt010.getJdbcPassword();
//    }

    public JDBCUtil(String driver, String url, String user, String password) throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection getConn() throws SQLException {
        return conn = DriverManager.getConnection(url, user, password);
    }

    @Override
    public void close() throws Exception {
        conn.close();
    }
}
