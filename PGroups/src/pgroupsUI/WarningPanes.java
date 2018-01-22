/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgroupsUI;

import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import pgroups.pgroups;


/**
 *
 * @author katrinaeaton
 */
public class WarningPanes {
    public WarningPanes(){
        
    }
    
    public boolean exceptionPane(Exception warning) {
        JOptionPane warningPane = new JOptionPane();
        String errorMessage = warning + "\n" + "Would you like to continue?";
        int result = warningPane.showConfirmDialog(null, errorMessage, "Houston, we have a problem", 
                warningPane.YES_NO_OPTION, 2);
        if (result == 1){
            System.out.println("Chose no.");
            return true;
        }
        return false;
    }
    
    public static void warningPane(String message) {
        JOptionPane warningPane = new JOptionPane();
//        String errorMessage = ex.toString();
        warningPane.showMessageDialog(null, message, 
                "This is seriously pooched",  JOptionPane.ERROR_MESSAGE);
//        if (result == 1){
//            System.out.println("Chose no.");
            System.exit(0);
//            pgroupsUI.fileGenerator.cancel(true);
//        }

    }
}
