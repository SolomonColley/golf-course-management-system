/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcms.rdms;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
public class InsertUtility {
    /**
     * Operation INSERT Calendar of the GCMS's CRUD design. Connects to the
     * internal database, selects the Calendar table, and inserts the specified
     * rows into the database table.
     * @param formTable the form's table with selected records to be inserted
     */
    public static void insertToCalendar(JTable formTable) {
        DefaultTableModel tableModel = (DefaultTableModel) formTable.getModel();
        int selectedRowCount = formTable.getSelectedRowCount();
        int[] selectedRowIndices = formTable.getSelectedRows();
        int dayValue;
        String sql = "INSERT INTO Calendar(Day) VALUES(?)";
        
        // connect to the database
        Connection.connect(CONNECTION_STR);
        
        try (PreparedStatement pstmt = Connection.getConnection().prepareStatement(sql)) {
            for (int i = 0; i < selectedRowCount; i++) {
                // get the value in the day column at the selected row index
                dayValue = Integer.parseInt(tableModel.getValueAt(selectedRowIndices[i], 0).toString());
                
                // prepare the value for insertion and execute the query
                pstmt.setInt(1, dayValue);
                pstmt.executeUpdate();
            } // end for
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), CREATE_ERROR_MSG,
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } // end try-catch

        // disconnect from the database
        Connection.disconnect();
    } // end insertToCalendar
    
    /**
     * Operation INSERT Calendar of the GCMS's CRUD design. Connects to the
     * internal database, selects the EmplSchedule table, and inserts the specified
     * rows into the database table.
     * @param formTable the form's table with selected records to be inserted
     */
    public static void insertToEmplSchedule(JTable formTable) {
        DefaultTableModel tableModel = (DefaultTableModel) formTable.getModel();
        int selectedRowCount = formTable.getSelectedRowCount();
        int[] selectedRowIndices = formTable.getSelectedRows();
        int dayValue, emplID;
        String jobValue;
        String sql = "INSERT INTO EmplSchedule(Day, Job, EmplID) VALUES(?, ?, ?)";
        
        // connect to the database
        Connection.connect(CONNECTION_STR);
        
        try (PreparedStatement pstmt = Connection.getConnection().prepareStatement(sql)) {
            for (int i = 0; i < selectedRowCount; i++) {
                // get the value in the Day, Job, and EmpID columns at the selected row index
                dayValue = Integer.parseInt(tableModel.getValueAt(selectedRowIndices[i], 0).toString());
                jobValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 1).toString());
                emplID = Integer.parseInt(tableModel.getValueAt(selectedRowIndices[i], 2).toString());
                
                // prepare the values for insertion and execute the query
                pstmt.setInt(1, dayValue);
                pstmt.setString(2, jobValue);
                pstmt.setInt(3, emplID);
                pstmt.executeUpdate();
            } // end for
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), CREATE_ERROR_MSG,
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } // end try-catch
        
        // disconnect from the database
        Connection.disconnect();
    } // end insertToEmplSchedule
    
    public static void insertToEmployees(JTable formTable) {
        
    }
    
    /**
     * Operation INSERT Calendar of the GCMS's CRUD design. Connects to the
     * internal database, selects the JobList table, and inserts the specified
     * rows into the database table.
     * @param formTable the form's table with selected records to be inserted
     */
    public static void insertToJobList(JTable formTable) {
        DefaultTableModel tableModel = (DefaultTableModel) formTable.getModel();
        int selectedRowCount = formTable.getSelectedRowCount();
        int[] selectedRowIndices = formTable.getSelectedRows();
        String jobValue;
        String sql = "INSERT INTO JobList(Job) VALUES(?)";
        
        // connect to the database
        Connection.connect(CONNECTION_STR);
        
        try (PreparedStatement pstmt = Connection.getConnection().prepareStatement(sql)) {
            for (int i = 0; i < selectedRowCount; i++) {
                // get the value in the Job column at the selected row index
                jobValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 0).toString());
                
                // prepare the value for insertion and execute the query
                pstmt.setString(1, jobValue);
                pstmt.executeUpdate();
            } // end for
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), CREATE_ERROR_MSG,
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } // end try-catch
        
        // disconnect from the database
        Connection.disconnect();
    } // end insertToJobList
    
    public static void insertToMembers(JTable formTable) {
        
    }
    
    public static void insertToPurchase(JTable formTable) {
        
    }
    
    public static void insertToPurchaseLine(JTable formTable) {
        
    }
    
    public static void insertToRates(JTable formTable) {
        
    }
    
    public static void insertToTeeSchedule(JTable formTable) {
        
    }
    
    public static void insertToTeeTimes(JTable formTable) {
        
    }
    
    private static final String CONNECTION_STR =
        "jdbc:sqlite:data/gcms_db.db";
    private static final String CREATE_ERROR_MSG =
        "Cannot insert the selected rows into the database.";
} // end InsertUtility
