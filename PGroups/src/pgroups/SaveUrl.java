/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgroups;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * @author Katrina Eaton & Melinda Perez
 */

public class SaveUrl{
    
    public BufferedInputStream in;
    public FileOutputStream fout;
    
    public SaveUrl(String filename, String urlString)
        throws MalformedURLException, IOException {
            try {
                in = new BufferedInputStream(new URL(urlString).openStream());
                fout = new FileOutputStream(filename);
            } catch (Exception ex)
            {
                System.out.println(ex);
            }
    }
    
    public FileOutputStream saveTheUrl() throws MalformedURLException, IOException {
        try {
            System.out.println("beginning of save url");
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
        System.out.println("end of save url");
        return fout;
    }
}

////    public FileOutputStream SaveUrl(final String filename, final String urlString)
//    throws MalformedURLException, IOException {
//        BufferedInputStream in = null;
//        FileOutputStream fout = null;
//        try {
////    setProgress(35);
//
//            in = new BufferedInputStream(new URL(urlString).openStream());
//            fout = new FileOutputStream(filename);
//
//            final byte data[] = new byte[1024];
//            int count;
//            while ((count = in.read(data, 0, 1024)) != -1) {
//                fout.write(data, 0, count);
//            }
//        } finally {
////    setProgress(37);    
//            if (in != null) {
//                in.close();
////    setProgress(38);
//            }
//            if (fout != null) {
//                fout.close();
////    setProgress(39);
//            }
//        }
////        return fout;
//    }
    

