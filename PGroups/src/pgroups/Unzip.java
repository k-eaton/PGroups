/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgroups;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
 * @author Katrina Eaton & Melinda Perez
 */
public class Unzip {
    
    public File destDir;
    public String destDirectory;
    public ZipEntry entry;
    public String filePath;
    public ZipInputStream zipIn;
    
    public final int BUFFER_SIZE = 4096;
    
    public Unzip(String zipFilePath, String desDirectory) throws IOException {
        try {
            destDirectory = desDirectory;
            destDir = new File(desDirectory);
            if (!destDir.exists()) {
                destDir.mkdir();
            }
            zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
            
            // iterates over entries in the zip file
            entry = zipIn.getNextEntry();
            filePath = destDirectory + File.separator + entry.getName();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        try{
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
            byte[] bytesIn = new byte[BUFFER_SIZE];
            int read = 0;
            while ((read = zipIn.read(bytesIn)) != -1) {
                bos.write(bytesIn, 0, read);
            }
            bos.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void unzipTheFile() throws IOException {
        try {
            while (entry != null) {
                filePath = destDirectory + File.separator + entry.getName();

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
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
}
//public void unzip(String zipfilePath, String destDirectory) throws IOException {
//        File destDir = new File(destDirectory);
//        if (!destDir.exists()) {
//            destDir.mkdir();
//        }
//        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
//        ZipEntry entry = zipIn.getNextEntry();
//        // iterates over entries in the zip file
//        
//        while (entry != null) {
//            String filePath = destDirectory + File.separator + entry.getName();
//            
//            if (!entry.isDirectory()) {
//                // if the entry is a file, extracts it
//                extractFile(zipIn, filePath);
//            } else {
//                // if the entry is a directory, make the directory
//                File dir = new File(filePath);
//                dir.mkdir();
//            }
//            zipIn.closeEntry();
//            entry = zipIn.getNextEntry();
//        }
//        zipIn.close();
//    }

//    private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
//        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
//        byte[] bytesIn = new byte[BUFFER_SIZE];
//        int read = 0;
//        while ((read = zipIn.read(bytesIn)) != -1) {
//            bos.write(bytesIn, 0, read);
//        }
//        bos.close();
//    }
 //-----end of trying to unzip xml 