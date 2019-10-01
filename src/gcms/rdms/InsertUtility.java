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
                jobValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 1));
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
    
    /**
     * Operation INSERT Calendar of the GCMS's CRUD design. Connects to the
     * internal database, selects the Employees table, and inserts the specified
     * rows into the database table.
     * @param formTable the form's table with selected records to be inserted
     */
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
                jobValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 0));
                
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
    
    /**
     * Operation INSERT Calendar of the GCMS's CRUD design. Connects to the
     * internal database, selects the Members table, and inserts the specified
     * rows into the database table.
     * @param formTable the form's table with selected records to be inserted
     */
    public static void insertToMembers(JTable formTable) {
        
    }
    
    /**
     * Operation INSERT Calendar of the GCMS's CRUD design. Connects to the
     * internal database, selects the Purchase table, and inserts the specified
     * rows into the database table.
     * @param formTable the form's table with selected records to be inserted
     */
    public static void insertToPurchase(JTable formTable) {
        DefaultTableModel tableModel = (DefaultTableModel) formTable.getModel();
        int selectedRowCount = formTable.getSelectedRowCount();
        int[] selectedRowIndices = formTable.getSelectedRows();
        int transNumValue, dayValue, memIDValue;
        String lNameValue, fNameValue;
        double totalAmountValue;
        String sql = "INSERT INTO Purchase(TransNum, Day, MemberID, LName, FName, TotalAmt) VALUES(?, ?, ?, ?, ?, ?)";
        
        // connect to the database
        Connection.connect(CONNECTION_STR);
        
        try (PreparedStatement pstmt = Connection.getConnection().prepareStatement(sql)) {
            for (int i = 0; i < selectedRowCount; i++) {
                /* get the values in the TransNum, Day, MemberID, LName, FName,
                and TotalAmt columns at the selected row index */
                transNumValue = Integer.parseInt(tableModel.getValueAt(selectedRowIndices[i], 0).toString());
                dayValue = Integer.parseInt(tableModel.getValueAt(selectedRowIndices[i], 1).toString());
                memIDValue = Integer.parseInt(tableModel.getValueAt(selectedRowIndices[i], 2).toString());
                lNameValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 3));
                fNameValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 4));
                totalAmountValue = Double.parseDouble(tableModel.getValueAt(selectedRowIndices[i], 5).toString());
                
                // prepare the values for insertion and execute the query
                pstmt.setInt(1, transNumValue);
                pstmt.setInt(2, dayValue);
                pstmt.setInt(3, memIDValue);
                pstmt.setString(4, lNameValue);
                pstmt.setString(5, fNameValue);
                pstmt.setDouble(6, totalAmountValue);
                pstmt.executeUpdate();
            } // end for
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), CREATE_ERROR_MSG,
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } // end try-catch
        
        // disconnect from the database
        Connection.disconnect();
    } // end insertToPurchase
    
    /**
     * Operation INSERT Calendar of the GCMS's CRUD design. Connects to the
     * internal database, selects the PurchaseLine table, and inserts the specified
     * rows into the database table.
     * @param formTable the form's table with selected records to be inserted
     */
    public static void insertToPurchaseLine(JTable formTable) {
        DefaultTableModel tableModel = (DefaultTableModel) formTable.getModel();
        int selectedRowCount = formTable.getSelectedRowCount();
        int[] selectedRowIndices = formTable.getSelectedRows();
        int transNumValue, purchLineNumValue;
        String itemValue;
        int quantityValue;
        String sql = "INSERT INTO PurchaseLine(TransNum, PurchLineNum, Item, Qty) VALUES(?, ?, ?, ?)";
        
        // connect to the database
        Connection.connect(CONNECTION_STR);
        
        try (PreparedStatement pstmt = Connection.getConnection().prepareStatement(sql)) {
            /* get the values in the TransNum, PurchaseLineNum, Item, and Qty
            columns at the selected row index */
            for (int i = 0; i < selectedRowCount; i++) {
                transNumValue = Integer.parseInt(tableModel.getValueAt(selectedRowIndices[i], 0).toString());
                purchLineNumValue = Integer.parseInt(tableModel.getValueAt(selectedRowIndices[i], 1).toString());
                itemValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 2));
                quantityValue = Integer.parseInt(tableModel.getValueAt(selectedRowIndices[i], 3).toString());
                
                // prepare the values for insertion and execute the query
                pstmt.setInt(1, transNumValue);
                pstmt.setInt(2, purchLineNumValue);
                pstmt.setString(3, itemValue);
                pstmt.setInt(4, quantityValue);
                pstmt.executeUpdate();
            } // end for
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), CREATE_ERROR_MSG,
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } // end try-catch
        
        // disconnect from the database
        Connection.disconnect();
    } // end insertToPurchaseLine
    
    /**
     * Operation INSERT Calendar of the GCMS's CRUD design. Connects to the
     * internal database, selects the Rates table, and inserts the specified
     * rows into the database table.
     * @param formTable the form's table with selected records to be inserted
     */
    public static void insertToRates(JTable formTable) {
        DefaultTableModel tableModel = (DefaultTableModel) formTable.getModel();
        int selectedRowCount = formTable.getSelectedRowCount();
        int[] selectedRowIndices = formTable.getSelectedRows();
        String itemValue;
        double priceValue;
        String sql = "INSERT INTO Rates(Item, Price) VALUES(?, ?)";
        
        // connect to the database
        Connection.connect(CONNECTION_STR);
        
        try (PreparedStatement pstmt = Connection.getConnection().prepareStatement(sql)) {
            for (int i = 0; i < selectedRowCount; i++) {
                // get the values in the Item and Price columns at the selected row index
                itemValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 0));
                priceValue = Double.valueOf(tableModel.getValueAt(selectedRowIndices[i], 1).toString());
                
                // prepare the values for insertion and execute the query
                pstmt.setString(1, itemValue);
                pstmt.setDouble(2, priceValue);
                pstmt.executeUpdate();
            } // end for
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), CREATE_ERROR_MSG,
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } // end try-catch
        
        // disconnect from the database
        Connection.disconnect();
    } // end insertToRates
    
    /**
     * Operation INSERT Calendar of the GCMS's CRUD design. Connects to the
     * internal database, selects the TeeSchedule table, and inserts the specified
     * rows into the database table.
     * @param formTable the form's table with selected records to be inserted
     */
    public static void insertToTeeSchedule(JTable formTable) {
        DefaultTableModel tableModel = (DefaultTableModel) formTable.getModel();
        int selectedRowCount = formTable.getSelectedRowCount();
        int[] selectedRowIndices = formTable.getSelectedRows();
        int dayValue, timeValue, memIDValue;
        String lNameValue, fNameValue;
        String sql = "INSERT INTO TeeSchedule(Day, Time, MemberID, LName, FName) VALUES(?, ?, ?, ?, ?)";
        
        // connect to the database
        Connection.connect(CONNECTION_STR);
        
        try (PreparedStatement pstmt = Connection.getConnection().prepareStatement(sql)) {
            for (int i = 0; i < selectedRowCount; i++) {
                /* get the values in the Day, Time, MemberID, LName, and FName
                columns at the selected row indices */
                dayValue = Integer.parseInt(tableModel.getValueAt(selectedRowIndices[i], 0).toString());
                timeValue = Integer.parseInt(tableModel.getValueAt(selectedRowIndices[i], 1).toString());
                memIDValue = Integer.parseInt(tableModel.getValueAt(selectedRowIndices[i], 2).toString());
                lNameValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 3));
                fNameValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 4));
                
                // prepare the values for insertion and execute the query
                pstmt.setInt(1, dayValue);
                pstmt.setInt(2, timeValue);
                pstmt.setInt(3, memIDValue);
                pstmt.setString(4, lNameValue);
                pstmt.setString(5, fNameValue);
                pstmt.executeUpdate();
            } // end for
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), CREATE_ERROR_MSG,
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } // end try-catch
        
        // disconnect from the database
        Connection.disconnect();
    } // end insertToTeeSchedule
    
    /**
     * Operation INSERT Calendar of the GCMS's CRUD design. Connects to the
     * internal database, selects the TeeTimes table, and inserts the specified
     * rows into the database table.
     * @param formTable the form's table with selected records to be inserted
     */
    public static void insertToTeeTimes(JTable formTable) {
        DefaultTableModel tableModel = (DefaultTableModel) formTable.getModel();
        int selectedRowCount = formTable.getSelectedRowCount();
        int[] selectedRowIndices = formTable.getSelectedRows();
        int timeValue;
        String sql = "INSERT INTO TeeTimes(Time) VALUES(?)";
        
        // connect to the database
        Connection.connect(CONNECTION_STR);
        
        try (PreparedStatement pstmt = Connection.getConnection().prepareStatement(sql)) {
            for (int i = 0; i < selectedRowCount; i++) {
                // get the values in the Time column at the selected row index
                timeValue = Integer.parseInt(tableModel.getValueAt(selectedRowIndices[i], 0).toString());
                
                // prepare the value for insertion and execute the query
                pstmt.setInt(1, timeValue);
                pstmt.executeUpdate();
            } // end for
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), CREATE_ERROR_MSG,
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } // end try-catch
        
        // disconnect from the database
        Connection.disconnect();
    } // end insertToTeeTimes
    
    private static final String CONNECTION_STR =
        "jdbc:sqlite:data/gcms_db.db";
    private static final String CREATE_ERROR_MSG =
        "Cannot insert the selected rows into the database.";
} // end InsertUtility
