/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgroups;

import pgroupsUI.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 *
 * @author katrinaeaton
 */
public class pgroups {
    
    public pgroups(String args[], boolean[] toggles ) {
        String xmlDirectory = args[0];
        System.out.println(xmlDirectory + " initialization (not main)");
        System.out.println(args[1]);
        System.out.println(toggles[0]);
        System.out.println(toggles[1]);
        System.out.println(toggles[2]);
        
        
    }

/**
 *
 * @author MePerez
 */
    /**
     *
     * @param versionNum
     * @return
     */
    public static String VersionUpdate(String versionNum) { // Takes the current CWD version captured from the CWD Allele's file, and updates the second field by 1 
        int startPos = versionNum.indexOf('.');
        int endPos = versionNum.indexOf('.',startPos+1);
         
         CharSequence currStart = versionNum.subSequence(0, startPos);
         CharSequence currMid = versionNum.subSequence(startPos+1, endPos);
         String newMid = Integer.toString(Integer.parseInt(currMid.toString())+1);
                 
         return currStart + "." + newMid + "." + "0";
    } 
  
    /**
     *
     * @param argument
     * @param hashedData
     * @return
     */
    public static String CWDhashRead(int argument, String hashedData){
        return hashedData.split("\t",2)[argument];
    }

    /**
     *
     * @param key
     * @param gid
     * @param cwdstatus
     * @param hashname
     */
    public static void CWDhashWrite(String key, String gid, String cwdstatus, HashMap hashname){
      // hashMap should be the allcwdgroups hashmap
      // Key should be the gGroup name
      // gid should be the GID
      // cwdstatus should be c or wd
     hashname.put(key, cwdstatus + "\t" + gid);
    }
 
    /**
     *
     * @param releaseVersion
     * @return
     */
    public static String Punctuate(String releaseVersion) {
         //Adds periods to IMGT/HLA Database release versions (e.g., 3210 -> 3.21.0)
        String punctuated = new String();
        switch (releaseVersion.length()) {
            case 3: 
                punctuated =  releaseVersion.substring(0,1) + "." + releaseVersion.substring(1,2) + "." + releaseVersion.substring(2);
                break;
            case 4:
                punctuated =  releaseVersion.substring(0,1) + "." + releaseVersion.substring(1,3) + "." + releaseVersion.substring(3);
                break;
        }
        return punctuated; 
    }
        
    /**
     *
     * @param num
     * @return
     */
    public static String IDGenerator(Integer num){
        int Len = num.toString().length();
        switch (Len){
            case 1: 
                return "0000"+ num.toString();
        
            case 2: 
                return "000"+ num.toString();
        
            case 3: 
                return  "00"+ num.toString();
        
            case 4: 
                return "0"+ num.toString();
        
            case 5: 
                return ""+ num.toString();
            
            default: 
                return "ERROR" + num.toString();
        }
    }
  
    
     //-----Start of trying to download xml  

    /**
     *
     * @param filename
     * @param urlString
     * @throws MalformedURLException
     * @throws IOException
     */
    
   
    public static void saveUrl(final String filename, final String urlString)
        throws MalformedURLException, IOException {
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        try {
            in = new BufferedInputStream(new URL(urlString).openStream());
            fout = new FileOutputStream(filename);

            final byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (fout != null) {
                fout.close();
            }
        }
    }
    
 
    
  
    //-----Start of trying to unzip xml  
    private static final int BUFFER_SIZE = 4096;
    
    /**
     *
     * @param zipFilePath
     * @param destDirectory
     * @throws IOException
     */
    public static void unzip(String zipFilePath, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry entry = zipIn.getNextEntry();
        // iterates over entries in the zip file
        
        while (entry != null) {
            String filePath = destDirectory + File.separator + entry.getName();
            
            if (!entry.isDirectory()) {
                // if the entry is a file, extracts it
                extractFile(zipIn, filePath);
            } else {
                // if the entry is a directory, make the directory
                File dir = new File(filePath);
                dir.mkdir();
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
        zipIn.close();
    }
    /**
     * Extracts a zip entry (file entry)
     * @param zipIn
     * @param filePath
     * @throws IOException
     */
    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }
 //-----end of trying to unzip xml 
    /*
 public class GlobalVariables{
         String line; 
         int lineNumber = 1; 
       Scanner scnr;
       String CurrentCWDStatus = new String(); //
       String CurrentCWDStatus; 
        String ReadCWDStatus = new String();    // String that cwdStat will go into
        ReadCWDStatus = ""; 
        String key;
        SortedSet SSkeys = new TreeSet<>();
        String CRet = System.getProperty("line.separator");
        String Locusletter = "";
        Iterator<String> SSkeysIt = SSkeys.iterator();
        String[] Pdata = new String[3]; 
        String NewVersionNum;
        
        boolean makePgroups = true;
        boolean makeAlleles = true;
         boolean makeGgroups = true;

        public GlobalVariables() {
            this.CurrentCWDStatus = "";
            this.CurrentCWDStatus = "";
        }
 }
    */
    /**
     *
     * @param args
     * @throws FileNotFoundException
     * @throws SAXException
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws ParseException
     */
    @SuppressWarnings("empty-statement") 
    public static void main(String[] args, boolean[] toggles) throws FileNotFoundException, SAXException, IOException, ParserConfigurationException, ParseException{
       //---All Urls used to get Files---
    //  URL OldPgroup = new URL("http://hla.alleles.org/wmda/hla_nom_p.txt");  //hla_nom_p.txt
        URL OldPgroup = new URL("https://raw.githubusercontent.com/ANHIG/IMGTHLA/Latest/wmda/hla_nom_p.txt");  //hla_nom_p.txt
        URL oldAlleles = new URL("http://igdawg.org/pubs/cwd200_alleles.txt"); //cwd200_alleles.txt
        URL ALhistory = new URL("https://raw.githubusercontent.com/jrob119/IMGTHLA/Latest/Allelelist_history.txt"); //Allelelist_history.txt
        URL Versionupdatetable = new URL("http://igdawg.org/pubs/cwdv.upd");  //version_update_table.txt
        String ambigsXMLsource = "https://raw.githubusercontent.com/jrob119/IMGTHLA/Latest/xml/hla_ambigs.xml.zip"; //source path to hla_ambigs.xml.zip
      
 //---All Hashmaps---
        HashMap<String, String> AlleleList = new HashMap<>(); // contains the ACC#s and reference allele names for the current database release version = ALhistory file
        HashMap<String, String> Allcwdalleles = new HashMap<>(); // contains the ACC#s for CWD alleles and their C/WD status 
        HashMap<String, String> Updatedcwdalleles = new HashMap<>(); // contains the updated list  // pull key: allelename , value: CWD status(Pcwddata[5])
        HashMap<String, String> ReverseHash = new HashMap<>();  // for the purpose of sorting by allele name
        HashMap<String, String> Allcwdgroups = new HashMap<>();  // Steve's version
        HashMap<String, String> Allpgroups = new HashMap<>(); // key=Pgroup name; value = CWDstatus (C, WD, or NONE) + PID
        HashMap<String, String> updatetable = new HashMap<>();
 //---General Variables---
        String FileNameList[]; 
        String xmlSourceName;
        Integer FileNameIndex;
        String xmlSourceNameList[];
        String xmlSourceNameConvert;
        Integer xmlSourceNameIndex;
        
        String Xml = args[0] + "\\hla_ambigs.xml.zip"; //xmlDirectory + "hla_ambigs.xml.zip";
        System.out.println(args[0] + " (main)");
//        String Xml = "R:\\Lab Folder\\HLA\\Melinda_P\\Development\\hla_ambigs.xml.zip"; //this is the hardcoded destination for the zip file
//        String Xml = "/Users/katrinaeaton/NewFolder/hla_ambigs.xml.zip";
        
        String line; 
        int lineNumber = 1; 
        Scanner scnr;
        String CurrentCWDStatus = new String(); //
        CurrentCWDStatus = ""; 
        String ReadCWDStatus = new String();    // String that cwdStat will go into
        ReadCWDStatus = ""; 
        String key;
        SortedSet SSkeys = new TreeSet<>();
        String CRet = System.getProperty("line.separator");
        String Locusletter = "";
        Iterator<String> SSkeysIt = SSkeys.iterator();
        String[] Pdata = new String[3]; 
        String NewVersionNum;
 
        boolean makeAlleles = toggles[0];
        boolean makeGgroups = toggles[1];
        boolean makePgroups = toggles[2];

       
        
 //---starts to read Version update Table file   
   //System.out.println("-----------1-----------------");     
        scnr = new Scanner (Versionupdatetable.openStream());
        lineNumber = 1;
        scnr.nextLine(); //skips header//skips header//skips header//skips header
        while(scnr.hasNextLine()){  
            NewVersionNum = scnr.nextLine();
           // System.out.println(NewVersionNum);
            updatetable.put(NewVersionNum.split("\t")[0], NewVersionNum.split("\t")[1]);
            lineNumber++;
        } 
        scnr.close();
        //System.out.println("-----------1-----------------");
        
//--end of reading Version update Table file   
      
//---starts to read Allelelist_history.txt
        scnr = new Scanner(ALhistory.openStream()); 
        String ALhistorySourceName = new String(); 
        String ALhistorySourceVersion = new String(); 
        String TextNewVersion = new String(); 
        ALhistorySourceName = ALhistory.getFile();
        FileNameList = ALhistorySourceName.split("/");
        FileNameIndex = FileNameList.length;
        ALhistorySourceName = FileNameList[FileNameIndex - 1];
        ALhistorySourceVersion = Punctuate(scnr.nextLine().split("\t")[1]);
       
        while (scnr.hasNextLine()) {
            line = scnr.nextLine();
            String[] Data = line.split("\t");
            // NOTE: Here, we could specify which database version to use as a reference allele list 
            // by changing which column of data goes into the hash Value
            int ALcolumn = 1;
            AlleleList.put(Data[0], Data[ALcolumn]);
            lineNumber++;
        }
        scnr.close(); // I think we need to close the scanner in the reading of the versionupdatetable
//-- Finished reading from the Allelelist_history file
        
//--- starts to read from cwd200_alleles.txt
        scnr = new Scanner(oldAlleles.openStream()); 
        
        String oldAllelesSourceName;   
        String oldAllelesSourceVersion; 
        String oldAllelesNewVersion;
        String oldSourceVersion;
        int cwdColumn = 3;
              
        oldAllelesSourceName = oldAlleles.getFile();
        FileNameList = oldAllelesSourceName.split("/");
        FileNameIndex = FileNameList.length; 
        oldAllelesSourceName = FileNameList[FileNameIndex - 1];
        oldAllelesSourceVersion = scnr.nextLine().split("\t")[0];  //Line 1
        oldAllelesSourceVersion = oldAllelesSourceVersion.substring(oldAllelesSourceVersion.indexOf("CWD")+3, oldAllelesSourceVersion.indexOf("Catalogue")-1).trim();
        // this is the version of the previoius CWD catalogue
         
        // oldAllelesNewVersion = updatetable.get(xmlSourceVersion); 
         
        if ("2.0.0".equals(oldAllelesSourceVersion)) { cwdColumn = 5; } else scnr.nextLine(); //this is the comment line
        line = scnr.nextLine();  // this is the header line
        oldSourceVersion = line.split("\t")[cwdColumn + 1];         
        oldSourceVersion = oldSourceVersion.substring(oldSourceVersion.indexOf("to")+3,oldSourceVersion.length());
        // From the name extended column, this is the version of the old file
        String AlleleSourceVersion = line.split("\t")[2]; 
        AlleleSourceVersion = AlleleSourceVersion.substring(AlleleSourceVersion.indexOf("HLA")+4, AlleleSourceVersion.indexOf("Allele")-1).trim();  
        
        while (scnr.hasNextLine()) {
            line= scnr.nextLine();
            if (!line.equals("")) {
                Allcwdalleles.put(line.split("\t")[1], line.split("\t")[2] + "\t" + line.split("\t")[cwdColumn]); // 7/1/2015 Steve uncommented this
                lineNumber++;
            }
          // System.out.println("-----------2----------------"); //Remove
        }
        scnr.close();
//--- finished reading from cwd200_alleles.txt
    
//--- START Downloading/unzip/READING xml FILE    
     //    String Xml = "R:\\Lab Folder\\HLA\\Melinda_P\\Development\\hla_ambigs.xml.zip";
     // 12-04-2015 commented out the above and moved it higher to the declarations  
     // if (false) { //no need to redo this once the xml file has been unzipped
       
     // saveUrl(Xml,"https://raw.githubusercontent.com/jrob119/IMGTHLA/Latest/xml/hla_ambigs.xml.zip" );
// 12-04-2015 commented out the above and added a new variable at the top for the source of the hla_ambigs.xml.zip file        
        saveUrl(Xml,ambigsXMLsource );
            
      // }
        unzip(args[0] + "\\hla_ambigs.xml.zip",args[0]);

//        unzip("R:\\Lab Folder\\HLA\\Melinda_P\\Development\\hla_ambigs.xml.zip","R:\\Lab Folder\\HLA\\Melinda_P\\Development");
//        unzip("/Users/katrinaeaton/NewFolder/hla_ambigs.xml.zip","/Users/katrinaeaton/NewFolder/");

        Xml = args[0] + "\\hla_ambigs.xml";
//        Xml = "R:\\Lab Folder\\HLA\\Melinda_P\\Development\\hla_ambigs.xml";
//        Xml = "/Users/katrinaeaton/NewFolder/hla_ambigs.xml";

        String xmlSourceVersion = new String(); 
        String xmlSourceDate = new String(); 
    
        DocumentBuilderFactory dbFactorys = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilders;
        dBuilders = dbFactorys.newDocumentBuilder();
        Document docs = dBuilders.parse(Xml);
                //.parse(zipxmlurl);
        docs.getDocumentElement().normalize();
        NodeList nLists = docs.getElementsByTagName("tns:gGroup");
        
        NodeList nSource = docs.getElementsByTagName("tns:releaseVersion"); //SM-07/03/2015 This section is new, for pulling documentation of the source files//SM-07/03/2015 This section is new, for pulling documentation of the source files//SM-07/03/2015 This section is new, for pulling documentation of the source files//SM-07/03/2015 This section is new, for pulling documentation of the source files
        if (nSource.item(0).getNodeType() == Node.ELEMENT_NODE) { // assumes source documentation only occurs once in the xml file. 
            Element eSource = (Element) nSource.item(0);
            xmlSourceVersion = eSource.getAttribute("currentRelease");
            xmlSourceDate = eSource.getAttribute("date");       
        } 
            // xmlSourceName = Xml.getFile(); //SM-07/03/2015 End of new section
        System.out.println(Xml);
        xmlSourceNameConvert = Xml.replace("\\", "/");
        System.out.println(xmlSourceNameConvert);
        xmlSourceNameList = xmlSourceNameConvert.split("/");
        xmlSourceNameIndex = xmlSourceNameList.length;
        xmlSourceName = xmlSourceNameList[xmlSourceNameIndex-1];
        System.out.println(xmlSourceName);
            
        //FileNameList = OldPgroup.getFile().split("/");
        //FileNameIndex = FileNameList.length; 
        oldAllelesNewVersion = updatetable.get(xmlSourceVersion);         
        String gGroupName = new String(); 
        String gGroupGID = new String();  
        // System.out.println("----------3-----------------"); // Remove         //    System.out.println("----------3-----------------");          //    System.out.println("----------3-----------------");          //    System.out.println("----------3-----------------");   

        for (int i = 0; i < nLists.getLength(); i++) {
            Node nNodes = nLists.item(i); 
         
            if (nNodes.getNodeType() == Node.ELEMENT_NODE) {
                
                Element eElements = (Element) nNodes;
                gGroupName = eElements.getAttribute("name"); 
                gGroupGID = eElements.getAttribute("gid");   
            }      
            if (nNodes.hasChildNodes()){
                //ChildNode begins
                NodeList childList = nLists.item(i).getChildNodes();
                // clear the cwd-status variable (null) for the new g-group (nNodes)          
                CurrentCWDStatus = ""; 
                String childNodename; //SM: declare these outside of the for loop and IF statement
                String childNodealleleid; // and initialize them as null

                for (int j = 0; j < childList.getLength(); j++) {

                    Node childNode = childList.item(j);
                    if (childNode.getNodeType() == 1)  {
                        childNodename = childNode.getAttributes().getNamedItem("name").getNodeValue(); //SM: looks like we don't need this
                        childNodealleleid = childNode.getAttributes().getNamedItem("alleleid").getNodeValue();

                        if (Allcwdalleles.keySet().contains(childNodealleleid)){              // is current alleleid contained on the allcwdalleles hash?

                            ReadCWDStatus = CWDhashRead(1,Allcwdalleles.get(childNodealleleid)); // yes? retrieve the cwd-status from that allele from the allcwdalleles hash (using the cwdhasmodule)

                            switch (CurrentCWDStatus) {
                            // String('C');
                                case "" : 
                                    CurrentCWDStatus = ReadCWDStatus;
                                    break;
                                case "WD": 
                                    CurrentCWDStatus = ReadCWDStatus;
                                    break;                                     // yes? overwrite cwd-status variable with the new retrieved cwd-status
                                case "C":                                               // no? (tehrefore, it is c) do nothing
                            //do nothing
                                    break;      
                            }

                        }else{
                            childNode.getNextSibling();
                        } // no? go on to the next sibling
                    } 
                }  
        
            } else { 
                System.out.println("NO CHILD FOUND for: "+ nLists);
            }  
            //ChildNode ends
            
            if ("".equals(CurrentCWDStatus)){    // cwdStat should never be 'null' it should either have a C or WD value or ""
                nNodes.getNextSibling();   // yes: go on to next nNode
            } else {
                  
                CWDhashWrite(gGroupName,gGroupGID,CurrentCWDStatus,Allcwdgroups); //SM: use CWDhashWrite to do all the work 
                nNodes.getNextSibling();                                                               
                // No: add this gGroup to the ggroups hash, using the gGroup name as the key, with the gid and the cwd-status as Value, using CWDhashWrite
            }
        }
        //--- FINISHED Downloading/unzip/READING xml FILE         
       
        //--START  UPDATED CWD ALLELES LIST       
        Iterator<String> keyIt = Allcwdalleles.keySet().iterator();
        
        while (keyIt.hasNext()) {
            key = keyIt.next();

            Updatedcwdalleles.put(key, AlleleList.get(key));
            if (Allcwdalleles.get(key).split("\t")[0].equals(Updatedcwdalleles.get(key))) {
                Updatedcwdalleles.put(key, AlleleList.get(key) + "\t" + "NO");
            } else {
                Updatedcwdalleles.put(key, AlleleList.get(key) + "\t" + "YES");
            }
            //This allows for returning the value for the key(Succesion ID) either Allelename(0) or CWD status(1)
            lineNumber++;
       // System.out.println("-----------5-----------------");    // Remove 
        }
        Set keys = Updatedcwdalleles.keySet();
        Iterator<String> keysIt = keys.iterator();
        
        while (keysIt.hasNext()) {
            key = keysIt.next();
            ReverseHash.put(Updatedcwdalleles.get(key).split("\t")[0], key + "\t" + Allcwdalleles.get(key).split("\t")[1]); // added CWD status to reverse updated CWD list
            lineNumber++;
        } 
 //--FINISH UPDATED CWD ALLELES LIST          //--FINISH UPDATED CWD ALLELES LIST          //--FINISH UPDATED CWD ALLELES LIST          //--FINISH UPDATED CWD ALLELES LIST         
       

     
//---Read from hla_nom_p.txt   <--Pgroup    
        //if (makePgroups){
        //   System.out.println("--Im in HLA_nom_p----"); // remove
               
        scnr = new Scanner(OldPgroup.openStream());       
        lineNumber = 0;       
        if (scnr.hasNextLine()){ 
            System.out.println("--Nextline--"); 
        } else {
            System.out.println("--no nextline----");
        }
            
        line = scnr.nextLine();  //line1
        //System.out.println("--"+scnr.toString());
        ReadCWDStatus = ""; 
        CurrentCWDStatus = ("NONE");
     
        String OldPgroupSourceName; 
        String OldPgroupSourceVersion;
        String OldPgroupSourceDate;
        String OldPgroupNewVersion = new String(); 
        String PgroupSourceName = new String();   
        String PgroupNewVersion = new String(); 
        //substring(0, key.indexOf("*")); 
        
        
        FileNameList = OldPgroup.getFile().split("/");
        FileNameIndex = FileNameList.length; 
        // System.out.println(" //"+ OldPgroup.getFile() +"||" + OldPgroupSourceName+"\\"); // figure out h0w to fix this
        // figure out a dynamic way to always get ONLY the file name from result of getFile, which is just the file name. From last /
        OldPgroupSourceName = FileNameList[FileNameIndex -1];
              
        line = scnr.nextLine();  //line2 date          
        OldPgroupSourceDate = line.substring(line.indexOf(":")+2, line.length());  // figure out h0w to fix this
        System.out.println("| //"+ OldPgroupSourceDate+ "\\ |");
        line = scnr.nextLine();           //line3 version
        OldPgroupSourceVersion = line.substring(line.indexOf("HLA")+4, line.length());
        System.out.println(" //"+ OldPgroupSourceVersion+ "\\");
        scnr.nextLine();          //skips: # origin: http://hla.alleles.org/wmda/hla_nom_p.txt
        scnr.nextLine();          //skips: repository: https://raw.githubusercontent.com/ANHIG/IMGTHLA/Latest/wmda/hla_nom_p.txt

        scnr.nextLine();          //skips: # author: WHO, Steven G. E. Marsh (steven.marsh@ucl.ac.uk)   
             
        while(scnr.hasNextLine()){
            line = scnr.nextLine();
                     
            if (!line.endsWith(";")) {
                Pdata = line.split(";");   //[0]= Locus, [1]=allele, [2]= Pgroup 
                lineNumber++;
                Integer n;

                for(n = 0; n < Pdata[1].trim().split("/").length; n++) {
                    //check hashmap; compare alleles in pgroup list to cwdalleles to see whats in this list, give it the value
                    if (ReverseHash.keySet().contains(Pdata[0]+Pdata[1].trim().split("/")[n])){              // is current allele contained on the allcwdalleles hash?
                        ReadCWDStatus = ReverseHash.get(Pdata[0]+Pdata[1].trim().split("/")[n]).split("\t")[1]; // yes? retrieve the cwd-status from that allele from the allcwdalleles hash (using the cwdhasmodule)

                        switch (CurrentCWDStatus) {
                            case "NONE" : 
                                CurrentCWDStatus = ReadCWDStatus;
                                break;
                            case "WD": 
                                CurrentCWDStatus = ReadCWDStatus;
                                break;                                     // yes? overwrite cwd-status variable with the new retrieved cwd-status
                            case "C":                                        // no? (tehrefore, it is c) do nothing
                                //do nothing
                                break;      
                        }   
                    }               
                }    
                CWDhashWrite(Pdata[0]+Pdata[2], "PGI" + IDGenerator(lineNumber), CurrentCWDStatus, Allpgroups);  // key=Pgroup name; value = CWDstatus (C, WD, or NONE) + PID
                CurrentCWDStatus = "NONE";   
                //  System.out.println("|"+Allpgroups.get(Pdata[0]+Pdata[2]));
            }           
        }   
        
        scnr.close();
          //  System.out.println("--Im out HLA_nom_p----");
      //} 
  //----Finished reading from hla_nom_p.txt   //----Finished reading from hla_nom_p.txt   //----Finished reading from hla_nom_p.txt   //----Finished reading from hla_nom_p.txt 
     
        
  //--START delete xml & .zip file here
        boolean deleted; 
        File xmlDown = new File(args[0] + "\\hla_ambigs.xml.zip"); //#1
//        File xmlDown = new File("R:\\Lab Folder\\HLA\\Melinda_P\\Development\\hla_ambigs.xml.zip"); //#1
//        File xmlDown = new File("/Users/katrinaeaton/hla_ambigs.xml.zip"); //#1

        while (!xmlDown.toString().equals("")){
            System.out.println("About to delete file: " + xmlDown);
                deleted = xmlDown.delete();
            System.out.println("File Deleted!: " + xmlDown + " = " + deleted);
            System.out.println("testingtesting");
            switch (xmlDown.toString().charAt(xmlDown.toString().length()-3)) {
                case 'z': 
                    xmlDown = new File(xmlDown.toString().replace(".zip", "")); 
                    break; 
                case 'x': 
                    xmlDown = new File(""); 
                    break; 
            }    
        }
            
//-- FINISHED delete xml & .zip file here 
           
//--START write cwd Ggroups file     
        if (makeGgroups){
            String gGroupLocus; // need to catch the locus for the file
            SSkeys = new TreeSet<>(Allcwdgroups.keySet());
            SSkeysIt = SSkeys.iterator();
    //   System.out.println("-----------4-----------------");   
            try{
                BufferedWriter cwdFile = new BufferedWriter(new FileWriter(args[0] + "\\cwd" + (oldAllelesNewVersion.replace(".", "")).replace(".","") + "_g-groups.txt"));
//                BufferedWriter cwdFile = new BufferedWriter(new FileWriter("R:\\Lab Folder\\HLA\\Melinda_P\\Development\\cwd" + (oldAllelesNewVersion.replace(".", "")).replace(".","") + "_g-groups.txt"));
//                BufferedWriter cwdFile = new BufferedWriter(new FileWriter("/Users/katrinaeaton/NewFolder/CWD/" + (oldAllelesNewVersion.replace(".", "")).replace(".","") + "_g-groups.txt"));

                cwdFile.write("# Categories for G Groups in the CWD "+ oldAllelesNewVersion + " Catalogue" + CRet);
                cwdFile.write("# Derived from: " + oldAllelesSourceName + " version:" + oldAllelesSourceVersion + " and " + xmlSourceName + " version:" + xmlSourceVersion + " Dated:" + xmlSourceDate + CRet);
                cwdFile.write("Locus" + "\t" + "IMGT/HLA " + xmlSourceVersion + " G Group" + "\t" + "CWD " + oldAllelesNewVersion + "Status" + "\t" + "GID" + CRet);

                while(SSkeysIt.hasNext()) {             
                    key = SSkeysIt.next(); // key is the gGroup Name
                    gGroupLocus = key.substring(0, key.indexOf("*")); 
                    cwdFile.write(gGroupLocus + "\t" + key + "\t" + CWDhashRead(0,Allcwdgroups.get(key)) + "\t" + CWDhashRead(1,Allcwdgroups.get(key)) + CRet);
                }
                cwdFile.close();     
            } catch (IOException e) {}  
        }
//--FINISH write file: cwd210_g-groups.txt//--FINISH write file: cwd210_g-groups.txt//--FINISH write file: cwd210_g-groups.txt//--FINISH write file: cwd210_g-groups.txt
          
//--START write UPDATED CWD ALLELES file     
        if (makeAlleles){     
            try {         
                BufferedWriter Newcwdfile = new BufferedWriter(new FileWriter(args[0] + "\\cwd" + (oldAllelesNewVersion.replace(".", "")).replace(".","") + "_alleles.txt"));
    //             BufferedWriter Newcwdfile = new BufferedWriter(new FileWriter("/Users/katrinaeaton/NewFolder/CWD/"   + (oldAllelesNewVersion.replace(".", "")).replace(".","") + "_alleles.txt"));

                Newcwdfile.write("# HLA Alleles in the CWD "+ oldAllelesNewVersion + " Catalogue" + "\t" + "\t" + "\t" + "\t" + CRet); //HLA Alleles in the CWD 2.0.0 Catalogue	
                Newcwdfile.write("# Derived from: " + oldAllelesSourceName + " version:" + oldAllelesSourceVersion + " and "  + ALhistorySourceName + " version:" + ALhistorySourceVersion + "\t" + "\t" + "\t" + "\t" + CRet);
                Newcwdfile.write("Locus" + "\t" + "IMGT/HLA Accession Number " + ALhistorySourceVersion + "\t" + "Allele" + "\t" + "CWD " + oldAllelesNewVersion + " Category" + "\t" + "Name Extended from IMGT/HLA " + oldSourceVersion + " to " + ALhistorySourceVersion + CRet);
                lineNumber = 0;

                SSkeys = new TreeSet<>(ReverseHash.keySet()); // all keys (allelenames) for reverse hash sorted by allelenames
                Iterator<String> RHkeysIt = SSkeys.iterator();
                while (RHkeysIt.hasNext()) {                     
                    key = ReverseHash.get(RHkeysIt.next()).split("\t")[0];  // "real key" here would have to be split away from updated CWD status
                    Locusletter = Allcwdalleles.get(key).split("\t")[0].substring(0, Allcwdalleles.get(key).split("\t")[0].indexOf("*"));
                    Newcwdfile.write(Locusletter + "\t" + key + "\t" + Updatedcwdalleles.get(key).split("\t")[0] + "\t" + Allcwdalleles.get(key).split("\t")[1] + "\t" + Updatedcwdalleles.get(key).split("\t")[1] + CRet);
                    lineNumber++;
                } Newcwdfile.close();
            } catch (IOException e) {} 
        }
//--FINISH MAKE UPDATED CWD ALLELES FILE       //--FINISH MAKE UPDATED CWD ALLELES FILE       //--FINISH MAKE UPDATED CWD ALLELES FILE       //--FINISH MAKE UPDATED CWD ALLELES FILE       
 
//--START write file: cwd210_P-groups.txt    
        if(makePgroups){  
            SSkeys = new TreeSet<>(Allpgroups.keySet());
            SSkeysIt =  SSkeys.iterator();
            lineNumber = 0;               
    //        line = scnr.nextLine(); //try to get line back to top line of hla_nom_p but this line prevents the file from being written
    //        String OldPgroupSourceDate = ""; //line.substring(line.indexOf(":")+2, line.length());
    //        String OldPgroupSourceVersion = "";  //line.substring(line.indexOf("HLA")+4, line.length());
    //        String OldPgroupSourceName = OldPgroup.getUserInfo();

            OldPgroupSourceName = OldPgroup.getFile().substring(6);
            try {  
                BufferedWriter NewPgrpcwdfile = new BufferedWriter(new FileWriter(args[0] + "\\cwd"  + (oldAllelesNewVersion.replace(".", "")).replace(".","") + "p-groups.txt"));
                NewPgrpcwdfile.write("# Categories for P Groups in the CWD " + oldAllelesNewVersion + " Catalogue" + CRet);
                NewPgrpcwdfile.write("# Derived from: " + oldAllelesSourceName + " version:" + oldAllelesSourceVersion + " and "  + OldPgroupSourceName + " version:" + OldPgroupSourceVersion + " Dated:" + OldPgroupSourceDate + "\t" + "\t"  + CRet);
                NewPgrpcwdfile.write("Locus" + " IMGT/HLA" + ALhistorySourceVersion  + "\t"  + "P Group" + "\t"  + "CWD " + oldSourceVersion + "Category"+ "\t"  + "Pid" + CRet);

                while(SSkeysIt.hasNext()) {
                    lineNumber++;
                    key = SSkeysIt.next();

                    if( !Allpgroups.get(key).split("\t")[0].equals("NONE")){
                        Locusletter = key.substring(0, key.indexOf("*"));
                        NewPgrpcwdfile.write(Locusletter + "\t" + key + "\t" + Allpgroups.get(key).split("\t")[0] + "\t" + Allpgroups.get(key).split("\t")[1] + CRet);
                    }
                    lineNumber++;        
                }
                NewPgrpcwdfile.close();
            } catch (IOException e) {}
        }
//--FINISH write file: cwd210_P-groups.txt     
    }
}
