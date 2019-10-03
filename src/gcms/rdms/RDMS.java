/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcms.rdms;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
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
public class RDMS {
        /**
     * Operation CREATE of the GCMS's CRUD design. Connects to the internal
     * database, selects the user-specified table, and inserts the specified
     * rows into the database table.
     * @param dbTable the user-selected database table
     * @param formTable the form's table with selected records to be inserted
     */
    public static void create(String dbTable, JTable formTable) {        
        switch (dbTable) {
            case "Calendar":
                InsertUtility.insertToCalendar(formTable);
                break;
            case "EmplSchedule":
                InsertUtility.insertToEmplSchedule(formTable);
                break;
            case "Employees":
                InsertUtility.insertToEmployees(formTable);
                break;
            case "JobList":
                InsertUtility.insertToJobList(formTable);
                break;
            case "Members":
                InsertUtility.insertToMembers(formTable);
                break;
            case "Purchase":
                InsertUtility.insertToPurchase(formTable);
                break;
            case "PurchaseLine":
                InsertUtility.insertToPurchaseLine(formTable);
                break;
            case "Rates":
                InsertUtility.insertToRates(formTable);
                break;
            case "TeeSchedule":
                InsertUtility.insertToTeeSchedule(formTable);
                break;
            case "TeeTimes":
                InsertUtility.insertToTeeTimes(formTable);
                break;
            default:
                break;
        } // end switch-case
    } // end create
    
    /**
     * Operation READ of the GCMS's CRUD design. Connects to the internal
     * database, selects a user-specified table, and reads that table's
     * information into the destination JTable. The JTable will reflect the
     * corresponding database table.
     * @param dbTable the user-selected database table (read from)
     * @param formTable the form's table to be populated with records (read to)
     */
    public static void read(Object dbTable, JTable formTable) {
        try {
            Connection.connect(CONNECTION_STR);
            try (Statement statement = Connection.getConnection().createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM [" + dbTable + "];")) {
                
                // get information about the table's columns
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int columnCount = resultSetMetaData.getColumnCount();
                
                // table model helps with changing the column and row model
                DefaultTableModel tableModel = (DefaultTableModel) formTable.getModel();
                
                // reset the table's column count
                tableModel.setColumnCount(0);
                
                // add the source table's columns to the destination table
                for (int i = 1; i <= columnCount; i++)
                    tableModel.addColumn(resultSetMetaData.getColumnName(i)); // end for
                
                // reset the table's row count
                tableModel.setRowCount(0);
                
                // while there are rows to add, populate the table with information
                while (resultSet.next()) {
                    String[] a = new String[columnCount];
                    
                    for (int i = 0; i < columnCount; i++)
                        a[i] = resultSet.getString(i + 1); // end for
                    
                    tableModel.addRow(a);
                } // end while
                
                tableModel.fireTableDataChanged();
            }
            Connection.disconnect();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), READ_ERROR_MSG,
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } // end try-catch
    } // end read
    
    /**
     * Operation UPDATE of the GCMS's CRUD design. Connects to the internal
     * database, selects the user-specified table, and updates the specified
     * rows from the table.
     * @param dbTable the user-selected database table
     * @param formTable the form's table with selected records to be deleted
     */
    public static void update(String dbTable, JTable formTable) {
        switch (dbTable) {
            case "Calendar":
                UpdateUtility.updateCalendar(formTable);
                break;
            case "EmplSchedule":
                UpdateUtility.updateEmplSchedule(formTable);
                break;
            case "Employees":
                UpdateUtility.updateEmployees(formTable);
                break;
            case "JobList":
                UpdateUtility.updateJobList(formTable);
                break;
            case "Members":
                UpdateUtility.updateMembers(formTable);
                break;
            case "Purchase":
                UpdateUtility.updatePurchase(formTable);
                break;
            case "PurchaseLine":
                UpdateUtility.updatePurchaseLine(formTable);
                break;
            case "Rates":
                UpdateUtility.updateRates(formTable);
                break;
            case "TeeSchedule":
                UpdateUtility.updateTeeSchedule(formTable);
                break;
            case "TeeTimes":
                UpdateUtility.updateTeeTimes(formTable);
                break;
            default:
                break;
        } // end switch-case
    } // end update
    
    /**
     * Operation DELETE of the GCMS's CRUD design. Connects to the internal
     * database, selects the user-specified table, and deletes the specified
     * rows from the table.
     * @param dbTable the user-selected database table
     * @param formTable the form's table with selected records to be deleted
     */
    public static void delete(Object dbTable, JTable formTable) {
        DefaultTableModel tableModel = (DefaultTableModel) formTable.getModel();
        int selectedRowCount = formTable.getSelectedRowCount();
        int[] selectedRowIndices = formTable.getSelectedRows();
        String colIDName = formTable.getColumnName(0);
        String sql;
        Object[] selectedRowIDs = new Object[selectedRowCount];
        
        // connect to the database
        Connection.connect(CONNECTION_STR);
        
        try (Statement statement = Connection.getConnection().createStatement()) {
            // for the number of selected rows, remove the selected rows from the database
            for (int i = 0; i < selectedRowCount; i++) {
                selectedRowIDs[i] = tableModel.getValueAt(selectedRowIndices[i], 0);
                
                // if the selected row id is a string, format sql query as such
                // else use base object for sql query
                if (isString(selectedRowIDs[i]))
                    sql = "DELETE FROM " + dbTable + " WHERE " + colIDName
                            + " = '" + selectedRowIDs[i].toString() + "'";
                else
                    sql = "DELETE FROM " + dbTable + " WHERE " + colIDName
                            + " = " + selectedRowIDs[i]; // end if-else
                
                // execute the query
                statement.executeUpdate(sql);
            } // end for
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), DELETE_ERROR_MSG,
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } // end try-catch
        
        // disconnect from the database
        Connection.disconnect();
    } // end delete
    
    /**
     * Determines if an object is a String or not.
     * @return true if the object is a String, or false if not.
     */
    private static boolean isString(Object obj) {
        return obj instanceof String;
    } // end isString
    
    private static final String CONNECTION_STR =
        "jdbc:sqlite:data/gcms_db.db";
    private static final String READ_ERROR_MSG =
        "Cannot populate the table with records.";
    private static final String DELETE_ERROR_MSG =
        "Cannot delete the selected records from the table.";
    private static final String COMMIT_ERROR_MSG =
        "Cannot commit table changes.";
} // end RDMS
