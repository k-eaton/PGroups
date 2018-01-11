/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgroupsUI;

import javax.swing.JOptionPane;
import pgroups.pgroups;


/**
 *
 * @author katrinaeaton
 */
public class WarningPanes {
    public WarningPanes(){
        
    }
    
    public void exceptionPane(Exception warning) {
        JOptionPane warningPane = new JOptionPane();
        String errorMessage = warning + "\n" + "Would you like to continue?";
        int result = warningPane.showConfirmDialog(null, errorMessage, "Houston, we have a problem", 
                warningPane.YES_NO_OPTION, 2);
        if (result == 1){
            System.out.println("Chose no.");
            try {
//                pgroupsUI.fileGenerator.cancel(true);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

    }
    
    public static void warningPane(Exception warning) {
        JOptionPane warningPane = new JOptionPane();
        String errorMessage = warning + "\n" + "Would you like to continue?";
        int result = warningPane.showConfirmDialog(null, errorMessage, "Error", 0, 0);
//        if (result == 1){
//            System.out.println("Chose no.");
            System.exit(0);
//            pgroupsUI.fileGenerator.cancel(true);
//        }

    }
}
