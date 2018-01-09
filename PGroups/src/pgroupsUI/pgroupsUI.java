/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgroupsUI;

import pgroups.*;

import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane.*;
import javax.swing.SwingWorker;
import org.apache.commons.io.FileUtils;



/**
 *
 * @author Katrina Eaton
 */
public class pgroupsUI extends javax.swing.JFrame {

    
    /**
     * Creates new form pgroupsUI
     */
    
    public pgroupsUI() {
        
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DirectoryChooser = new javax.swing.JFileChooser();
        jCheckBox1 = new javax.swing.JCheckBox();
        jOptionPane1 = new javax.swing.JOptionPane();
        String theMessage = "There is no version and or date listed in hla_ambigs.xml. Would you like to continue?";
        jOptionPane2 = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        Alleles = new javax.swing.JCheckBox();
        GGroups = new javax.swing.JCheckBox();
        PGroups = new javax.swing.JCheckBox();
        ShowFiles = new javax.swing.JRadioButton();
        SelectDirectoryLabel = new javax.swing.JLabel();
        SaveDirectoryLabel = new javax.swing.JLabel();
        jSeparatorFileSave = new javax.swing.JSeparator();
        SelectDirectoryButton = new javax.swing.JButton();
        SelectFilesLabel2 = new javax.swing.JLabel();
        jSeparatorStartButton = new javax.swing.JSeparator();
        Start = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        DirectoryChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        jCheckBox1.setText("jCheckBox1");

        jOptionPane2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jOptionPane2PropertyChange(evt);
            }
        });

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Alleles.setSelected(true);
        Alleles.setText("Alleles");
        Alleles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllelesActionPerformed(evt);
            }
        });

        GGroups.setSelected(true);
        GGroups.setText("G Groups");
        GGroups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GGroupsActionPerformed(evt);
            }
        });

        PGroups.setSelected(true);
        PGroups.setText("P Groups");
        PGroups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PGroupsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GGroups)
                    .addComponent(Alleles)
                    .addComponent(PGroups))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Alleles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GGroups)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PGroups)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        ShowFiles.setText("Show File(s)");
        ShowFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowFilesActionPerformed(evt);
            }
        });

        SelectDirectoryLabel.setText("Select Destination Directory For New Files");

        SaveDirectoryLabel.setText(System.getProperty("user.home") + System.getProperty("file.separator")+ "Documents");

        SelectDirectoryButton.setText("Save to...");
        SelectDirectoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectDirectoryButtonActionPerformed(evt);
            }
        });

        SelectFilesLabel2.setText("Select Files To Be Generated ");

        Start.setText("Start");
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });

        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        jProgressBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        jProgressBar1.setFocusable(false);
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparatorStartButton)
                    .addComponent(SaveDirectoryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SelectDirectoryLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparatorFileSave))
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(ShowFiles)
                .addGap(61, 61, 61))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(SelectDirectoryButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SelectFilesLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Start, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(124, 124, 124))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(SelectDirectoryLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SelectDirectoryButton)
                .addGap(12, 12, 12)
                .addComponent(SaveDirectoryLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparatorFileSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(SelectFilesLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparatorStartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(ShowFiles, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Start)
                    .addComponent(Cancel))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AllelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllelesActionPerformed

    }//GEN-LAST:event_AllelesActionPerformed

    private void GGroupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GGroupsActionPerformed

    }//GEN-LAST:event_GGroupsActionPerformed

    private void PGroupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PGroupsActionPerformed

    }//GEN-LAST:event_PGroupsActionPerformed

    private void ShowFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowFilesActionPerformed
    }//GEN-LAST:event_ShowFilesActionPerformed

    private void SelectDirectoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectDirectoryButtonActionPerformed
        
        int option = DirectoryChooser.showOpenDialog(this);
        File directory = DirectoryChooser.getSelectedFile();
        String directoryLocation = directory.getAbsolutePath();
        SaveDirectoryLabel.setText( directoryLocation );
        System.out.println(directory);
        
        // SaveDirectoryLabel (where we're getting our directory from for start button) 
        // defaults to home documents directory. See custom code in design window.
        // System.getProperty("user.home") + System.getProperty("file.separator")+ "Documents"
        
    }//GEN-LAST:event_SelectDirectoryButtonActionPerformed

    protected void process(String v) {
      System.out.println("process() receiving values: "+v);
    }
    
    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed

        try {
            String location;
            location = SaveDirectoryLabel.getText();
            
            boolean allelesToggle = Alleles.isSelected();
            boolean ggroupsToggle = GGroups.isSelected();
            boolean pgroupsToggle = PGroups.isSelected();
            boolean showMeTheFiles = ShowFiles.isSelected();
            
            if (!allelesToggle && !ggroupsToggle && !pgroupsToggle){
                jOptionPane1.showMessageDialog(this, "No options are selected");
            } else {
            
                boolean[] whatWeAreRunning = {allelesToggle, ggroupsToggle, pgroupsToggle, showMeTheFiles};

                String[] passMeOn = {location, "test"};

                pgroups fileGenerator = new pgroups(passMeOn, whatWeAreRunning);

                fileGenerator.addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt){
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
    //                        String test = fileGenerator.process();
                            jProgressBar1.setValue(progress);
    //                        jProgressBar1.setString("Your total is " + progress);
                            repaint();
                        }
                    }
                });

                fileGenerator.execute();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
    }//GEN-LAST:event_StartActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        // TODO add your handling code here:   
        File xmlDown = new File(SaveDirectoryLabel.getText() 
                + System.getProperty("file.separator") + "hla_ambigs.xml");
        File xmlDownZip = new File(SaveDirectoryLabel.getText() 
                + System.getProperty("file.separator") + "hla_ambigs.xml.zip");
        try {
            FileUtils.forceDelete(xmlDownZip);        
            FileUtils.forceDelete(xmlDown);        
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            
        }

        System.exit(0);
    }//GEN-LAST:event_CancelActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        File xmlDown = new File(SaveDirectoryLabel.getText() 
                + System.getProperty("file.separator") + "hla_ambigs.xml");
        File xmlDownZip = new File(SaveDirectoryLabel.getText() 
                + System.getProperty("file.separator") + "hla_ambigs.xml.zip");
        try {
            FileUtils.forceDelete(xmlDownZip);        
            FileUtils.forceDelete(xmlDown);        
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jOptionPane2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jOptionPane2PropertyChange
        System.out.println(jOptionPane2.YES_OPTION);
        System.out.println(jOptionPane2.NO_OPTION);

        if (jOptionPane2.NO_OPTION == 1) {
            System.exit(0);
        }

    }//GEN-LAST:event_jOptionPane2PropertyChange

   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pgroupsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pgroupsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pgroupsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pgroupsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pgroupsUI().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Alleles;
    private javax.swing.JButton Cancel;
    private javax.swing.JFileChooser DirectoryChooser;
    private javax.swing.JCheckBox GGroups;
    private javax.swing.JCheckBox PGroups;
    private javax.swing.JLabel SaveDirectoryLabel;
    private javax.swing.JButton SelectDirectoryButton;
    private javax.swing.JLabel SelectDirectoryLabel;
    private javax.swing.JLabel SelectFilesLabel2;
    private javax.swing.JRadioButton ShowFiles;
    private javax.swing.JButton Start;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JOptionPane jOptionPane1;
    public static javax.swing.JOptionPane jOptionPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparatorFileSave;
    private javax.swing.JSeparator jSeparatorStartButton;
    // End of variables declaration//GEN-END:variables
}
