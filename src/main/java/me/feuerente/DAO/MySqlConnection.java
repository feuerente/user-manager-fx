package me.feuerente.DAO;

import java.sql.*;

/**
 * Represents a connection to a MySQL database.
 */
public class MySqlConnection {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";

    private static final String USER = "root";
    private static final String PASS = "root";

    private Connection conn;
    private Statement stmtSQL;

    /**
     * Open a connection with a driver.
     */
    public void openConnection() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmtSQL = conn.createStatement();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    /**
     * Update database with an sql statement.
     *
     * @param sql the sql statement
     * @return true if the update was successful, false otherwise
     */
    public boolean update(String sql) {
        try {
            System.out.println("Executing sql: " + sql);
            stmtSQL.executeUpdate(sql);
            return true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return false;
        }
    }

    /**
     * Read from database with an sql statement.
     *
     * @param sql the sql statement
     * @return the query result if successful, null otherwise
     */
    public ResultSet read(String sql) {
        ResultSet rs;
        try {
            System.out.println("Reading sql: " + sql);
            rs = stmtSQL.executeQuery(sql);
            return rs;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            rs = null;
            return rs;
        }
    }

    /**
     * Close the connection.
     */
    public void closeConnection() {
        try {
            stmtSQL.close();
            conn.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
