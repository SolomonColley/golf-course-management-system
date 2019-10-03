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
public class UpdateUtility {
    /**
     * Operation UPDATE Calendar of the GCMS's CRUD design. Connects to the
     * internal database, selects the Calendar table, and updates the specified
     * rows into the database table.
     * @param formTable the form's table with selected records to be inserted
     */
    public static void updateCalendar(JTable formTable) {
        // cannot update a table of key values
        JOptionPane.showMessageDialog(new JFrame(), UPDATE_ERROR_MSG,
            "Dialog", JOptionPane.ERROR_MESSAGE);
    } // end updateCalendar
    
    /**
     * Operation UPDATE EmplSchedule of the GCMS's CRUD design. Connects to the
     * internal database, selects the EmplSchedule table, and updates the specified
     * rows into the database table.
     * @param formTable the form's table with selected records to be inserted
     */
    public static void updateEmplSchedule(JTable formTable) {
        DefaultTableModel tableModel = (DefaultTableModel) formTable.getModel();
        int selectedRowCount = formTable.getSelectedRowCount();
        int[] selectedRowIndices = formTable.getSelectedRows();
        int dayValue, emplID;
        String jobValue;
        String sql = "UPDATE EmplSchedule SET Job = ?, EmplID = ? WHERE Day = ?";
        
        // connect to the database
        Connection.connect(CONNECTION_STR);
        
        try (PreparedStatement pstmt = Connection.getConnection().prepareStatement(sql)) {
            for (int i = 0; i < selectedRowCount; i++) {
                // get the value in the Day, Job, and EmpID columns at the selected row index
                dayValue = Integer.parseInt(tableModel.getValueAt(selectedRowIndices[i], 0).toString());
                jobValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 1));
                emplID = Integer.parseInt(tableModel.getValueAt(selectedRowIndices[i], 2).toString());
                
                // prepare the values for updating and execute the query
                pstmt.setString(1, jobValue);
                pstmt.setInt(2, emplID);
                pstmt.setInt(3, dayValue);
                pstmt.executeUpdate();
            } // end for
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), UPDATE_ERROR_MSG,
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } // end try-catch
        
        // disconnect from the database
        Connection.disconnect();
    } // end updateEmplSchedule
    
    /**
     * Operation UPDATE Employees of the GCMS's CRUD design. Connects to the
     * internal database, selects the Employees table, and updates the specified
     * rows into the database table.
     * @param formTable the form's table with selected records to be inserted
     */
    public static void updateEmployees(JTable formTable) {
        DefaultTableModel tableModel = (DefaultTableModel) formTable.getModel();
        int selectedRowCount = formTable.getSelectedRowCount();
        int[] selectedRowIndices = formTable.getSelectedRows();
        int empIDValue;
        String lNameValue, fNameValue, streetValue, cityValue, stateValue, emailValue, phoneValue;
        int zipValue;
        double payRateValue;
        String sql = "UPDATE Employees SET LName = ?, FName = ?, Street = ?, City = ?, State = ?, Zip = ?, Email = ?, Phone = ?, PayRate = ? WHERE EmplID = ?";
        
        // connect to the database
        Connection.connect(CONNECTION_STR);
        
        try (PreparedStatement pstmt = Connection.getConnection().prepareStatement(sql)) {
            for (int i = 0; i < selectedRowCount; i++) {
                /* get the value in the EmplID, LName, FName, Street, City, State,
                Zip, Email, Phone, and PayRate columns at the selected row index */
                empIDValue = Integer.parseInt(tableModel.getValueAt(selectedRowIndices[i], 0).toString());
                lNameValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 1));
                fNameValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 2));
                streetValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 3));
                cityValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 4));
                stateValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 5));
                zipValue = Integer.parseInt(tableModel.getValueAt(selectedRowIndices[i], 6).toString());
                emailValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 7));
                phoneValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 8));
                payRateValue = Double.parseDouble(tableModel.getValueAt(selectedRowIndices[i], 9).toString());
                
                // prepare the values for updating and execute the query
                pstmt.setString(1, lNameValue);
                pstmt.setString(2, fNameValue);
                pstmt.setString(3, streetValue);
                pstmt.setString(4, cityValue);
                pstmt.setString(5, stateValue);
                pstmt.setInt(6, zipValue);
                pstmt.setString(7, emailValue);
                pstmt.setString(8, phoneValue);
                pstmt.setDouble(9, payRateValue);
                pstmt.setInt(10, empIDValue);
                pstmt.executeUpdate();
            } // end for
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), UPDATE_ERROR_MSG,
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } // end try-catch
        
        // disconnect from the database
        Connection.disconnect();
    } // end updateEmployees
    
    /**
     * Operation UPDATE JobList of the GCMS's CRUD design. Connects to the
     * internal database, selects the JobList table, and updates the specified
     * rows into the database table.
     * @param formTable the form's table with selected records to be inserted
     */
    public static void updateJobList(JTable formTable) {
        // cannot update a table of key values
        JOptionPane.showMessageDialog(new JFrame(), UPDATE_ERROR_MSG,
            "Dialog", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Operation UPDATE Members of the GCMS's CRUD design. Connects to the
     * internal database, selects the Members table, and updates the specified
     * rows into the database table.
     * @param formTable the form's table with selected records to be inserted
     */
    public static void updateMembers(JTable formTable) {
        DefaultTableModel tableModel = (DefaultTableModel) formTable.getModel();
        int selectedRowCount = formTable.getSelectedRowCount();
        int[] selectedRowIndices = formTable.getSelectedRows();
        int memIDValue;
        String lNameValue, fNameValue, streetValue, cityValue, stateValue, emailValue, phoneValue;
        int zipValue, expDateValue;
        String sql = "UPDATE Members SET LName = ?, FName = ?, Street = ?, City = ?, State = ?, Zip = ?, Email = ?, Phone = ?, ExpDate = ? WHERE MemberID = ?";
        
        // connect to the database
        Connection.connect(CONNECTION_STR);
        
        try (PreparedStatement pstmt = Connection.getConnection().prepareStatement(sql)) {
            for (int i = 0; i < selectedRowCount; i++) {
                /* get the value in the EmplID, LName, FName, Street, City, State,
                Zip, Email, Phone, and ExpDate columns at the selected row index */
                memIDValue = Integer.parseInt(tableModel.getValueAt(selectedRowIndices[i], 0).toString());
                lNameValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 1));
                fNameValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 2));
                streetValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 3));
                cityValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 4));
                stateValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 5));
                zipValue = Integer.parseInt(tableModel.getValueAt(selectedRowIndices[i], 6).toString());
                emailValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 7));
                phoneValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 8));
                expDateValue = Integer.valueOf(tableModel.getValueAt(selectedRowIndices[i], 9).toString());
                
                // prepare the values for updating and execute the query
                pstmt.setString(1, lNameValue);
                pstmt.setString(2, fNameValue);
                pstmt.setString(3, streetValue);
                pstmt.setString(4, cityValue);
                pstmt.setString(5, stateValue);
                pstmt.setInt(6, zipValue);
                pstmt.setString(7, emailValue);
                pstmt.setString(8, phoneValue);
                pstmt.setInt(9, expDateValue);
                pstmt.setInt(10, memIDValue);
                pstmt.executeUpdate();
            } // end for
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), UPDATE_ERROR_MSG,
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } // end try-catch
        
        // disconnect from the database
        Connection.disconnect();
    } // end updateMembers
    
    /**
     * Operation UPDATE Purchase of the GCMS's CRUD design. Connects to the
     * internal database, selects the Purchase table, and updates the specified
     * rows into the database table.
     * @param formTable the form's table with selected records to be inserted
     */
    public static void updatePurchase(JTable formTable) {
        DefaultTableModel tableModel = (DefaultTableModel) formTable.getModel();
        int selectedRowCount = formTable.getSelectedRowCount();
        int[] selectedRowIndices = formTable.getSelectedRows();
        int transNumValue, dayValue, memIDValue;
        String lNameValue, fNameValue;
        double totalAmountValue;
        String sql = "UPDATE Purchase SET Day = ?, MemberID = ?, LName = ?, FName = ?, TotalAmt = ? WHERE TransNum = ?";
        
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
                
                // prepare the values for updating and execute the query
                pstmt.setInt(1, dayValue);
                pstmt.setInt(2, memIDValue);
                pstmt.setString(3, lNameValue);
                pstmt.setString(4, fNameValue);
                pstmt.setDouble(5, totalAmountValue);
                pstmt.setInt(6, transNumValue);
                pstmt.executeUpdate();
            } // end for
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), UPDATE_ERROR_MSG,
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } // end try-catch
        
        // disconnect from the database
        Connection.disconnect();
    } // end updatePurchase
    
    /**
     * Operation UPDATE PurchaseLine of the GCMS's CRUD design. Connects to the
     * internal database, selects the PurchaseLine table, and updates the specified
     * rows into the database table.
     * @param formTable the form's table with selected records to be inserted
     */
    public static void updatePurchaseLine(JTable formTable) {
        DefaultTableModel tableModel = (DefaultTableModel) formTable.getModel();
        int selectedRowCount = formTable.getSelectedRowCount();
        int[] selectedRowIndices = formTable.getSelectedRows();
        int transNumValue, purchLineNumValue;
        String itemValue;
        int quantityValue;
        String sql = "UPDATE PurchaseLine SET TransNum = ?, Item = ?, Qty = ? WHERE PurchLineNum = ?";
        
        // connect to the database
        Connection.connect(CONNECTION_STR);
        
        try (PreparedStatement pstmt = Connection.getConnection().prepareStatement(sql)) {
            for (int i = 0; i < selectedRowCount; i++) {
                transNumValue = Integer.parseInt(tableModel.getValueAt(selectedRowIndices[i], 0).toString());
                purchLineNumValue = Integer.parseInt(tableModel.getValueAt(selectedRowIndices[i], 1).toString());
                itemValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 2));
                quantityValue = Integer.parseInt(tableModel.getValueAt(selectedRowIndices[i], 3).toString());
                
                // prepare the values for updating and execute the query
                pstmt.setInt(1, transNumValue);
                pstmt.setString(2, itemValue);
                pstmt.setInt(3, quantityValue);
                pstmt.setInt(4, purchLineNumValue);
                pstmt.executeUpdate();
            } // end for
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), UPDATE_ERROR_MSG,
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } // end try-catch
        
        // disconnect from the database
        Connection.disconnect();
    } // end updatePurchaseLine
    
    /**
     * Operation UPDATE Rates of the GCMS's CRUD design. Connects to the
     * internal database, selects the Rates table, and updates the specified
     * rows into the database table.
     * @param formTable the form's table with selected records to be inserted
     */
    public static void updateRates(JTable formTable) {
        DefaultTableModel tableModel = (DefaultTableModel) formTable.getModel();
        int selectedRowCount = formTable.getSelectedRowCount();
        int[] selectedRowIndices = formTable.getSelectedRows();
        String itemValue;
        double priceValue;
        String sql = "UPDATE Rates SET Price = ? WHERE Item = ?";
        
        // connect to the database
        Connection.connect(CONNECTION_STR);
        
        try (PreparedStatement pstmt = Connection.getConnection().prepareStatement(sql)) {
            for (int i = 0; i < selectedRowCount; i++) {
                // get the values in the Item and Price columns at the selected row index
                itemValue = String.valueOf(tableModel.getValueAt(selectedRowIndices[i], 0));
                priceValue = Double.valueOf(tableModel.getValueAt(selectedRowIndices[i], 1).toString());
                
                // prepare the values for updating and execute the query
                pstmt.setDouble(1, priceValue);
                pstmt.setString(2, itemValue);
                pstmt.executeUpdate();
            } // end for
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), UPDATE_ERROR_MSG,
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } // end try-catch
        
        // disconnect from the database
        Connection.disconnect();
    } // end updateRates
    
    /**
     * Operation UPDATE TeeSchedule of the GCMS's CRUD design. Connects to the
     * internal database, selects the TeeSchedule table, and updates the specified
     * rows into the database table.
     * @param formTable the form's table with selected records to be inserted
     */
    public static void updateTeeSchedule(JTable formTable) {
        DefaultTableModel tableModel = (DefaultTableModel) formTable.getModel();
        int selectedRowCount = formTable.getSelectedRowCount();
        int[] selectedRowIndices = formTable.getSelectedRows();
        int dayValue, timeValue, memIDValue;
        String lNameValue, fNameValue;
        String sql = "UPDATE TeeSchedule SET Time = ?, MemberID = ?, LName = ?, FName = ? WHERE Day = ?";
        
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
                
                // prepare the values for updating and execute the query
                pstmt.setInt(1, timeValue);
                pstmt.setInt(2, memIDValue);
                pstmt.setString(3, lNameValue);
                pstmt.setString(4, fNameValue);
                pstmt.setInt(5, dayValue);
                pstmt.executeUpdate();
            } // end for
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), UPDATE_ERROR_MSG,
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } // end try-catch
        
        // disconnect from the database
        Connection.disconnect();
    } // end updateTeeSchedule
    
    /**
     * Operation UPDATE TeeTimes of the GCMS's CRUD design. Connects to the
     * internal database, selects the TeeTimes table, and updates the specified
     * rows into the database table.
     * @param formTable the form's table with selected records to be inserted
     */
    public static void updateTeeTimes(JTable formTable) {
        // cannot update a table of key values
        JOptionPane.showMessageDialog(new JFrame(), UPDATE_ERROR_MSG,
            "Dialog", JOptionPane.ERROR_MESSAGE);
    } // end updateTeeTimes
    
    private static final String CONNECTION_STR =
        "jdbc:sqlite:data/gcms_db.db";
    private static final String UPDATE_ERROR_MSG =
        "Cannot update the selected rows in the database.";
} // end UpdateUtility
