/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcms.rdms;

import gcms.rdms.Connection;

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
    public static void connect(String url) {
        Connection.connect(url);
    }
    
    public static void disconnect() {
        Connection.disconnect();
    }
    
    public static void create() {
        
    }
    
    public static void read() {
        
    }
    
    public static void update() {
        
    }
    
    public static void delete() {
        
    }
}
