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
    private static java.sql.Connection conn;
    private static final String CONNECT_ERROR_MSG =
            "Could not connect to the database.";
    private static final String DISCONNECT_ERROR_MSG =
            "Could not disconnect from the database.";
    private static final String IS_VALID_ERROR_MSG =
            "Could not determine the validity of the database connection.";
    
    public static void connect(String url) {
        conn = null;
        
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(), CONNECT_ERROR_MSG,
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } // end try-catch // end try-catch
    } // end connect
    
    public static void disconnect() {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(), DISCONNECT_ERROR_MSG,
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } // end try-catch // end try-catch
    } // end disconnect
    
    public static boolean isConnected() {
        boolean isValid = false;
        
        try {
            isValid = conn.isValid(0);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(), IS_VALID_ERROR_MSG,
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } // end try-catch
        
        return isValid;
    } // end isConnected
    
    public static java.sql.Connection getConnection() {
        return conn;
    } // end getConnection
} // end Connection
