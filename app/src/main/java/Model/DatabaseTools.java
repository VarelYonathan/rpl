/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseTools {
    private String driver = "com.mysql.jdbc.Driver";
    private String user = "root";
    private String password = "";
    private Connection connection;
    private String connectionUrl = "jdbc:mysql://localhost:3306/peminjamanruang";
//    private String connectionUrl = 
//            "jdbc:mysql://localhost:3306/peminjamanruang;" + 
//            "database=peminjamanruang; " + 
//            "user=" + user + ";" + 
//            "password=" + password + ";" +
//            "loginTimeout=30;";

    public DatabaseTools() {
        connectToSqlServer();
    }
    
    public Connection getConnection() {
        return this.connection;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
    
    public void changeDatabaseUserPassword(String user, String password) {
        this.user = user;
        this.password = password;
    }
    
    public ResultSet runQuery(String query) throws SQLException {
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        return rs;
    }
    
    public void runUpdateQuery(String query) throws SQLException {
        Statement st = connection.createStatement();
        st.executeUpdate(query);
    }
    
    private void connectToSqlServer() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(connectionUrl, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void beginTransaction() throws SQLException {
        this.connection.setAutoCommit(false);
    }
    
    public void commitTransaction() throws SQLException {
        this.connection.commit();
        this.connection.setAutoCommit(true);
    }
    
    public void rollbackTransaction() throws SQLException {
        this.connection.rollback();
        this.connection.setAutoCommit(true);
    }
    
    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseTools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

