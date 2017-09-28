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
import javax.swing.SwingWorker;
import pgroupsUI.StatusBar;



/**
 *
 * @author Katrina Eaton & Melinda Perez
 */
public class SaveUrl extends SwingWorker<FileOutputStream, Void>{
    
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
    
    @Override
    protected void done() {
        try {
            get();

            System.out.println("done");
        //can call other gui update code here
        } catch (Throwable t) {
        //do something with the exception
         }
    }
    
//    public FileOutputStream output() throws MalformedURLException, IOException {
    @Override
    public FileOutputStream doInBackground() throws MalformedURLException, IOException {
        try {
            System.out.println("beginning of save url");
    setProgress(35);
            final byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
        } finally {
    setProgress(37);
            if (in != null) {
                in.close();
            }
    setProgress(38);
            if (fout != null) {
                fout.close();
            }
        }
    setProgress(39);
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
    

