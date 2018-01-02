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
    
    public static File writeFile(String version, String type){
        cwdFile = new BufferedWriter(new FileWriter(directory[0] 
                + System.getProperty("file.separator") 
                + "cwd_"  
                + (version.replace(".", "")).replace(".","")
                + "_" + type + ".txt"));
        return file;
    }
    
    //--START write file: cwdXXX_P-groups.txt    
//        if(makePgroups){  
//            System.out.println("Running P-Groups");
//
//            SSkeys = new TreeSet<>(Allpgroups.keySet());
//            SSkeysIt =  SSkeys.iterator();
//            lineNumber = 0;               
//
//            OldPgroupSourceName = OldPgroup.getFile().substring(6);
//            try {  
////        setProgress(80);
//                BufferedWriter cwdFile;
//                if (StringUtils.isNotBlank(oldAllelesNewVersion)){
//                    cwdFile = new BufferedWriter(new FileWriter(directory[0] + System.getProperty("file.separator") + "cwd"  + (oldAllelesNewVersion.replace(".", "")).replace(".","") + "_p-groups.txt"));
//                } else {
//                    cwdFile = new BufferedWriter(new FileWriter(directory[0] + System.getProperty("file.separator") + "cwd000_p-groups.txt"));
//                }
//                cwdFile.write("# Categories for P Groups in the CWD " + oldAllelesNewVersion + " Catalogue" + CRet);
//                cwdFile.write("# Derived from: " + oldAllelesSourceName + " version:" + oldAllelesSourceVersion + " and "  + OldPgroupSourceName + " version:" + OldPgroupSourceVersion + " Dated:" + OldPgroupSourceDate + "\t" + "\t"  + CRet);
//                cwdFile.write("Locus" + " IMGT/HLA" + ALhistorySourceVersion  + "\t"  + "P Group" + "\t"  + "CWD " + oldSourceVersion + "Category"+ "\t"  + "Pid" + CRet);
//
//                while(SSkeysIt.hasNext()) {
//                    lineNumber++;
//                    key = SSkeysIt.next();
//
//                    if( !Allpgroups.get(key).split("\t")[0].equals("NONE")){
//                        Locusletter = key.substring(0, key.indexOf("*"));
//                        cwdFile.write(Locusletter + "\t" + key + "\t" + Allpgroups.get(key).split("\t")[0] + "\t" + Allpgroups.get(key).split("\t")[1] + CRet);
//                    }
//                    lineNumber++;        
//                }
//                cwdFile.close();
//                
//                // Open the file if the user chooses to
//                if (runMe[3] == true) {
//                    String pgroupsFileLocation = directory[0] 
//                            + System.getProperty("file.separator") 
//                            + "cwd" 
//                            // finds proper version in file name
//                            + (oldAllelesNewVersion.replace(".", "")).replace(".","")
//                            + "_p-groups.txt";
//                    
//                    // I know I should be able to consolodate these two lines,
//                    // but the program no longer recognizes File as an object
//                    // when I do.
//                    File fileToOpen = new File(pgroupsFileLocation);
//                    Desktop.getDesktop().open(fileToOpen);
//                }
//
//            } catch (IOException e) {
//                System.out.println(e);
//            }
//
//        }
}
