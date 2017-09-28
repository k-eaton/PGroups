/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgroups;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author Katrina Eaton & Melinda Perez
 */
public class Unzip {
    
}
//public void unzip(String zipFilePath, String destDirectory) throws IOException {
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