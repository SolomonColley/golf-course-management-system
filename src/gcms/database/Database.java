/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcms.database;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
public class Database {
    private final String PATH_TO_BACKUP_DB =
        ".backup/gcms_db.db";
    private final String PATH_TO_WORKING_DB =
        "data/gcms_db.db";
    private final String COPY_ERROR_MSG =
        "Cannot copy the backup database to the working directory.";
    
    /**
     * The default class constructor.
     */
    public Database() { } // end default constructor
    
    /**
     * Determines whether the working database file exists within the data
     * folder or not.
     * @return true if the working database exists, or false if not
     */
    public boolean exists() {
        File workingDatabase = new File(PATH_TO_WORKING_DB);
        
        return workingDatabase.exists();
    } // end exists
    
    /**
     * Copies the backup database file to the working database file. If the
     * working database already exists and this method is called, the backup
     * database file will overwrite it.
     */
    public void copyBackupDatabase() {
        Path backupDatabasePath = Paths.get(PATH_TO_BACKUP_DB);
        Path workingDatabasePath = Paths.get(PATH_TO_WORKING_DB);
        
        try {
            // copy the backup database file to the working database file
            Files.copy(backupDatabasePath, workingDatabasePath,
                StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(new JFrame(), COPY_ERROR_MSG,
                "Dialog", JOptionPane.ERROR_MESSAGE);
        } // end try-catch
    } // end copyBackupDatabase
} // end Database
