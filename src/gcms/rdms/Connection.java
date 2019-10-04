/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcms.rdms;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Golf Course Management System (GCMS) enables employees of a golf course
 * to perform daily tasks such as completing transactions, storing employee and
 * member information, and scheduling grounds work.
 * 
 * This project has been designed and developed for course CIS4810 Systems
 * Development Project taught by Professor Mary Garrett. Project Team 1 consists
 * of the following team members: Michael Abbotts, Baron Amman, Ryan Cipullo,
 * Solomon Colley, and David Ward.
 * 
 * @author Solomon Colley
 * @see SDD for more information on system design and documentation
 * @since 9/23/2019
 * @version 1.0
 */
public class Connection {
    private static final String CONNECT_ERROR_MSG =
        "Could not connect to the database.";
    private static final String DISCONNECT_ERROR_MSG =
        "Could not disconnect from the database.";
    private static final String IS_VALID_ERROR_MSG =
        "Could not determine the validity of the database connection.";
    
    private static java.sql.Connection conn;
    
    /**
     * Connects to the database specified by the URL.
     * @param url the URL (file path) to the database
     */
    public static void connect(String url) {
        conn = null;
        
        // try connecting to the database with the given url
        // if connection fails, display appropriate exception
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), CONNECT_ERROR_MSG,
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "The class was not found.",
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } // end try-catch
    } // end connect
    
    /**
     * Disconnects from the database if a connection is currently valid.
     */
    public static void disconnect() {
        // try disconnecting from the database
        // if the connection is connected or not null, close it
        // if there is no connection, display appropriate exception
        try {
            if (isValidConnection() || conn != null)
                conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), DISCONNECT_ERROR_MSG,
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } // end try-catch
    } // end disconnect
    
    /**
     * Determines whether the connection is connected (valid) or not.
     * @return true if the connection is connected (valid), or false if not
     */
    public static boolean isValidConnection() {
        boolean isValid = false;
        
        // try testing for the validity of the connection
        // if the connection is not valid, display appropriate exception
        try {
            isValid = conn.isValid(0);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), IS_VALID_ERROR_MSG,
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } // end try-catch
        
        return isValid;
    } // end isConnected
    
    /**
     * Gets the connection object.
     * @return the connection object
     */
    public static java.sql.Connection getConnection() {
        return conn;
    } // end getConnection
} // end Connection
