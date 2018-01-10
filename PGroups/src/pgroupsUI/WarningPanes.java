/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgroupsUI;

import javax.swing.JOptionPane;


/**
 *
 * @author katrinaeaton
 */
public class WarningPanes {
    public WarningPanes(){
        
    }
    
    public static void exceptionPane(Exception warning) {
        JOptionPane warningPane = new JOptionPane();
        String errorMessage = warning + "\n" + "Would you like to continue?";
        warningPane.showConfirmDialog(null, errorMessage, "Error", 
                warningPane.YES_NO_OPTION);

    }
}
