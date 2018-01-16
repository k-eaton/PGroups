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

//            try {
////                pgroups.errorState = true;
////                pgroupsUI.fileGenerator.cancel(true);
//            } catch (Exception ex) {
//                System.out.println(ex);
//            }
        }
        return false;
    }
    
    public static void warningPane(Exception ex) {
        JOptionPane warningPane = new JOptionPane();
//        String errorMessage = ex.toString();
        warningPane.showMessageDialog(null, ex, 
                "This is seriously pooched",  JOptionPane.WARNING_MESSAGE);
//        if (result == 1){
//            System.out.println("Chose no.");
            System.exit(0);
//            pgroupsUI.fileGenerator.cancel(true);
//        }

    }
}
