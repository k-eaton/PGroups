/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgroups;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author kaeaton
 */
public class WriteFile {
    
    private BufferedWriter cwdFile;
    private FileWriter file;
    private String CRet = System.getProperty("line.separator");
    
    public WriteFile(){
        
    }
    
    public void pGroups (String fileName) throws IOException {
        try {
            cwdFile = new BufferedWriter(new FileWriter(fileName));
        } catch (Exception ex) {
            System.out.println(ex); 
        }
    }
}
