package cargomanage;

import java.sql.*;

public class DataBase {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/goods";
    private static final String USER = "root";
    private static final String PWD = "LKD2020.0921.";
    static{
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Connection getConn() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,USER,PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public void close(ResultSet rs, Statement state, Connection conn) {
        try {
            if(rs != null) {
                rs.close();
            }
            if(state != null) {
                state.close();
            }
            if(conn !=null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
