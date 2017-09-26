/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgroupsUI;

import javax.swing.SwingWorker;
import pgroups.pgroups;

/**
 *
 * @author kaeaton
 */
public class StatusBar extends SwingWorker<StatusBar, Void>{
    
    @Override
    protected StatusBar doInBackground(){
        
        System.out.println("doInBackground is running");
        
//        StatusBar test = new StatusBar();
//        pgroups fileGenerator = new pgroups(passMeOn, whatWeAreRunning);
//        fileGenerator.main(passMeOn, whatWeAreRunning);
        for(int i=0; i<=20 ;i++) {
            try {
                Thread.sleep(500);
                setProgress(5 * i);
                System.out.println(i);
                if (i == 9){
                    System.out.println("Half way there!");
//                    jProgressBar1.setString("Half way there!");
                }
            }
            catch(InterruptedException e) {
                System.out.println(e);
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println("StatusBar main method is called");
        StatusBar test = new StatusBar();
        test.run();
    }
    
}
