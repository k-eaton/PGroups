/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgroups;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
/**
 *
 * @author katrinaeaton
 */
public class VersionMatcher {
    public VersionMatcher(){
        
    }
    
    static String ALhistoryMatchVersion(Scanner scnr){
        String version = new String();
        String scannerLine = new String();
        
        // find version pattern 3.XX.0
        Pattern pVersion = Pattern.compile("\\b[3]\\.\\d+\\.[0]$");
        
        // find header line by #
        Pattern pHeader = Pattern.compile("^#");
        
        Matcher mVersion; // = pVersion.matcher(scannerLine);
        Matcher mHeader; // = pHeader.matcher(scannerLine);
        
        // read a line
        scannerLine = scnr.nextLine();
        int i = 1;
        
        do {
            
            // just checking
            System.out.println("Line " + i + ": " + scannerLine);
            i++;
            
            // check the line for the version number
            mVersion = pVersion.matcher(scannerLine);
            
            // if it matches the version regex, assign version
            if (mVersion.find()) {
                version = mVersion.group();
                System.out.println("Version: " + version);
            }
            
            // read the next line
            scannerLine = scnr.nextLine();
            System.out.println("Line " + i + ": " + scannerLine);
            
            // check the line for # to indicate it's a header
            mHeader = pHeader.matcher(scannerLine);
            System.out.println(mHeader.lookingAt());
            
            
        } while (mHeader.lookingAt());
        
        return version;
    }
}
