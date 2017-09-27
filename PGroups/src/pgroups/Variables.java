/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgroups;

/**
 *
 * @author kaeaton
 */
public class Variables {
    private boolean[] runMe;
    private String[] directory;
    
    public Variables(boolean[] running, String[] location){
        runMe = running;
        directory = location; 
    }
    
    public boolean[] getRunMe() { return runMe; }
    public String[] getDirectory() { return directory; }

}
