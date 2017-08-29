package testgui;

import pgroups.CWDAutomatedUpdate;  //import CWDAutomatedUpdate
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

/**
 *
 * @author MePerez
 */



// public class TestFrame extends javax.swing.JFrame {
public class TestFrame extends javax.swing.JFrame implements ItemListener {

    static HashSet selectionCache = new HashSet();
    //---GLOBAL VARIABLES---
    Listener Listener = new Listener();
    File writeDirectory;
    boolean showFiles = false;
    int filesToBuild = 0;
    int checkedBox;
    static JCheckBox checkboxes[] = new JCheckBox[4];
    JProgressBar progressBar;

    
    public static void main(String[] args) {
                
       System.out.println("test");
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestFrame().setVisible(true);
            }
        });
        // Locale defaultLocale = TestFrame.getDefaultLocale();
//        TestFrame testframe = new TestFrame();
//        testframe.initComponents();
//        initComponents();

    }
  //JProgressBar jProgressBar;
    // static final int MY_MINIMUM=0;
    // static final int MY_MAXIMUM=100;
    /**
     * Creates new form TestFrame
     */
    // public TestFrame() {
    public TestFrame() {
                

        initComponents();
      //  jProgressBar = new JProgressBar();
        // jProgressBar.setMinimum(MY_MINIMUM);
        // jProgressBar.setMaximum(MY_MAXIMUM);
        //  UploadingFrame.add(jProgressBar);
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   // public void updateBar(int newValue) {
    // jProgressBar.setValue(newValue);
    // }
//    static class Listener implements ItemListener {
    abstract class Listener implements ItemListener {

        private final int MAX_SELECTIONS = 3;
        private int selectionCounter = 0;

//        @Override
        public void itemStateChanged(JCheckBox e) {
//            JCheckBox source = (JCheckBox) e.getSource();
            if (e.getStateChange() == ItemEvent.SELECTED) {
                Alleles2.setSelected(false);
                Ggroups2.setSelected(false);
                Pgroups2.setSelected(false);
            }
//            int index = -1;
//            if (source.isSelected()) {
//                for (int i = 0; i < checkboxes.length; i++) {
//
//                    if (checkboxes[i].isSelected() == true) {
//                    }
//                }
//                selectionCounter++;
//                if (selectionCounter == MAX_SELECTIONS) {
//                    for (JCheckBox box : checkboxes) {
//                        if (!box.isSelected()) {
//
//                            box.setEnabled(false);
//                        }
//                    }
//                }
//            } else {
//                selectionCounter--;
//                for (int i = 0; i < checkboxes.length; i++) {
//
//                    if (checkboxes[i].isSelected() == false) {
//
//                        index = i;
//                        for (int k = 0; k < checkboxes.length; k++) {
//
//                        }
//
//                    }
//                }
//                if (selectionCounter < MAX_SELECTIONS) {
//                    for (JCheckBox box : checkboxes) {
//                        box.setEnabled(true);
//                    }
//                }
//            }
        }
    }   //dont think we need this.

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser = new javax.swing.JFileChooser();
        UploadingFrame = new javax.swing.JFrame();
        jProgressBar = new javax.swing.JProgressBar();
        Finished = new javax.swing.JButton();
        UploadingLabel = new javax.swing.JLabel();
        StartWarningDialog = new javax.swing.JDialog();
        Dialogokbutton = new javax.swing.JButton();
        DialogTxt1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        Pgroups2 = new javax.swing.JCheckBox();
        Ggroups2 = new javax.swing.JCheckBox();
        Alleles2 = new javax.swing.JCheckBox();
        Allcwd2 = new javax.swing.JCheckBox();
        ShowFiles2 = new javax.swing.JRadioButton();
        jSeparator5 = new javax.swing.JSeparator();
        Start2 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        SelectDirectoryLabel2 = new javax.swing.JLabel();
        SelectFilesLabel2 = new javax.swing.JLabel();
        ButtonsopenJfileChooser2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        CancelButton = new javax.swing.JButton();

        jFileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooserActionPerformed(evt);
            }
        });

        jProgressBar.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jProgressBarComponentAdded(evt);
            }
        });

        Finished.setText("Finished");
        Finished.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinishedActionPerformed(evt);
            }
        });

        UploadingLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UploadingLabel.setText("Uploading....");

        javax.swing.GroupLayout UploadingFrameLayout = new javax.swing.GroupLayout(UploadingFrame.getContentPane());
        UploadingFrame.getContentPane().setLayout(UploadingFrameLayout);
        UploadingFrameLayout.setHorizontalGroup(
            UploadingFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UploadingFrameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Finished)
                .addGap(38, 38, 38))
            .addGroup(UploadingFrameLayout.createSequentialGroup()
                .addGroup(UploadingFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UploadingFrameLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(UploadingLabel))
                    .addGroup(UploadingFrameLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        UploadingFrameLayout.setVerticalGroup(
            UploadingFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UploadingFrameLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(UploadingLabel)
                .addGap(29, 29, 29)
                .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(Finished)
                .addGap(22, 22, 22))
        );

        Dialogokbutton.setText("Ok");
        Dialogokbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DialogokbuttonActionPerformed(evt);
            }
        });

        DialogTxt1.setBackground(new java.awt.Color(240, 240, 240));
        DialogTxt1.setBorder(null);

        javax.swing.GroupLayout StartWarningDialogLayout = new javax.swing.GroupLayout(StartWarningDialog.getContentPane());
        StartWarningDialog.getContentPane().setLayout(StartWarningDialogLayout);
        StartWarningDialogLayout.setHorizontalGroup(
            StartWarningDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StartWarningDialogLayout.createSequentialGroup()
                .addGroup(StartWarningDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StartWarningDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(DialogTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(StartWarningDialogLayout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(Dialogokbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        StartWarningDialogLayout.setVerticalGroup(
            StartWarningDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StartWarningDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DialogTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Dialogokbutton)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MainFrame");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pgroups2.setText("P groups");
        Pgroups2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pgroups2ActionPerformed(evt);
            }
        });
        getContentPane().add(Pgroups2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 80, 20));

        Ggroups2.setText("G groups");
        Ggroups2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ggroups2ActionPerformed(evt);
            }
        });
        getContentPane().add(Ggroups2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 70, 20));

        Alleles2.setText("Alleles");
        Alleles2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Alleles2ActionPerformed(evt);
            }
        });
        getContentPane().add(Alleles2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 60, 20));

        Allcwd2.setSelected(true);
        Allcwd2.setText("All CWD Files");
        Allcwd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Allcwd2ActionPerformed(evt);
            }
        });
        getContentPane().add(Allcwd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        ShowFiles2.setText("Show File(s)");
        ShowFiles2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowFiles2ActionPerformed(evt);
            }
        });
        getContentPane().add(ShowFiles2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, -1, 30));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 349, -1));

        Start2.setText("Start");
        Start2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Start2ActionPerformed(evt);
            }
        });
        getContentPane().add(Start2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 70, -1));
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 349, -1));

        SelectDirectoryLabel2.setText("Select Destination Directory For New Files");
        getContentPane().add(SelectDirectoryLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 18, -1, -1));

        SelectFilesLabel2.setText("Select Files To Be Generated ");
        getContentPane().add(SelectFilesLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 119, -1, -1));

        ButtonsopenJfileChooser2.setText("Save to...");
        ButtonsopenJfileChooser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonsopenJfileChooser2ActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonsopenJfileChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 111, -1));

        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 370, 20));

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(CancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, -1, -1));

        setSize(new java.awt.Dimension(401, 413));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooserActionPerformed

      //         System.out.println("getCurrentDirectory(): " +  jFileChooser.getCurrentDirectory());
        //    System.out.println("getSelectedFile() : " +  jFileChooser.getSelectedFile());
        //  } else {
        //      System.out.println("No Selection ");
        //  }

    }//GEN-LAST:event_jFileChooserActionPerformed


    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // 
        //System.out.println("form Mouse Clicked");
    }//GEN-LAST:event_formMouseClicked
    
//    @Override
//    public void itemStateChanged(ItemEvent e) {
//    if (e.getStateChange() == ItemEvent.SELECTED) {
//        Alleles2.setSelected(false);
//        Ggroups2.setSelected(false);
//        Pgroups2.setSelected(false);
//    } // else {
//        label.setVisible(false);
//    }
//}
    
    private void FileSelection() {
        boolean ischecked = false;
        int i;
        selectionCache.clear();

//        Allcwd2.addItemListener(this);
        
        for (i = 0; i <= 5; i++) {

            switch (i) {

                case 0:
                    
                    
//                    if (Allcwd2.isSelected()) {
////                        selectionCache.add(i);
////                        ischecked = true;
//                    };
                    break;
                    
                case 1:
                    if (itemStateChanged(Allcwd2)) {
////                    if (e.getStateChange() == ItemEvent.SELECTED)
////                    if (Allcwd2.itemStateChanged(this)) {
//                        selectionCache.add(i);
////                        ischecked = true;
//                        Alleles2.setSelected(false);
//                        Ggroups2.setSelected(false);
//                        Pgroups2.setSelected(false);
//                    } else {
//                        Allcwd2.setSelected(false);
//                    }
                    break;
                case 2:
                    if (Alleles2.isSelected()) {
                        selectionCache.add(i);
                        ischecked = true;
//                        Allcwd2.setSelected(false);
                        
                    }
                    break;
                case 3:
                    if (Ggroups2.isSelected()) {
                        selectionCache.add(i);
                        ischecked = true;
//                        Allcwd2.setSelected(false);
                    }
                    break;
                case 4:
                    if (Pgroups2.isSelected()) {
                        selectionCache.add(i);
                        ischecked = true;
//                        Allcwd2.setSelected(false);
                    }
                    break;
//                case 5:
//                    if (Allcwd2.isSelected()) {
//                        selectionCache.add(i);
//                        ischecked = true;
//                        Alleles2.setSelected(false);
//                        Ggroups2.setSelected(false);
//                        Pgroups2.setSelected(false);
//                    }
//                    break;
            }

        }
        System.out.println(selectionCache);
        if (ischecked != true) {
            Allcwd2.setSelected(true);
        }

//        List<JCheckBox> subgroup = new ArrayList<>();
//        subgroup.add(Alleles2);
//        subgroup.add(Ggroups2);
//        subgroup.add(Pgroups2);

        
        
    }

   //     System.out.println(Boolean.toString(Pgroups2.isSelected())); // + Ggroups2.isSelected() + Alleles2.isSelected() + Allcwd2.isSelected());

    private void Pgroups2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pgroups2ActionPerformed
        // TODO add your handling code here:
        FileSelection(); // item 3
    }//GEN-LAST:event_Pgroups2ActionPerformed

    private void Ggroups2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ggroups2ActionPerformed
        // TODO add your handling code here:
        FileSelection(); // item 2 
    }//GEN-LAST:event_Ggroups2ActionPerformed

    private void Alleles2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Alleles2ActionPerformed
        // TODO add your handling code here:
        FileSelection(); // item 1
    }//GEN-LAST:event_Alleles2ActionPerformed

    private void Allcwd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Allcwd2ActionPerformed
        // TODO add your handling code here:
//        Pgroups2.setSelected(true);
//        Ggroups2.setSelected(true);
//        Alleles2.setSelected(true);
        FileSelection(); // item 0
    }//GEN-LAST:event_Allcwd2ActionPerformed

    private void ShowFiles2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowFiles2ActionPerformed
        // TODO add your handling code here:
        showFiles = ShowFiles2.isSelected();
        System.out.println("Show me those files again?!");
    }//GEN-LAST:event_ShowFiles2ActionPerformed

    private void Start2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Start2ActionPerformed
        if (writeDirectory == null || writeDirectory.toString() == "") {
            StartWarningDialog.setVisible(true);
            StartWarningDialog.setSize(200, 100);
            StartWarningDialog.setTitle("Please Select Destination Folder");
            StartWarningDialog.setLocation(500, 400); // distqance in pixels from the top-left chroner of the screen
            StartWarningDialog.setAlwaysOnTop(true);
            StartWarningDialog.pack();
            StartWarningDialog.setVisible(true);

            DialogTxt1.setText("Please select a directory where the new CWD files to be written.");
        } else {

            if (selectionCache.contains(0)) {
                filesToBuild = 0;
            } else {
                if (selectionCache.contains(1) && selectionCache.contains(2)) {
                    filesToBuild = 4;
                } // defined in cwdautomatedupdate.java
                else if (selectionCache.contains(1) && selectionCache.contains(3)) {
                    filesToBuild = 5;
                } // defined in cwdautomatedupdate.java
                else if (selectionCache.contains(3) && selectionCache.contains(2)) {
                    filesToBuild = 6;
                } // defined in cwdautomatedupdate.java
                else if (selectionCache.contains(1)) {
                    filesToBuild = 1;
                } else if (selectionCache.contains(2)) {
                    filesToBuild = 2;
                } else if (selectionCache.contains(3)) {
                    filesToBuild = 3;
                }

            }
        }
        System.out.println(selectionCache);
        System.out.println(filesToBuild);


    }//GEN-LAST:event_Start2ActionPerformed

    private void ButtonsopenJfileChooser2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonsopenJfileChooser2ActionPerformed
        jFileChooser.setApproveButtonText("Select Directory");
        jFileChooser.setDialogTitle("Choose A Destination Directory");
        jFileChooser.setCurrentDirectory(new java.io.File("."));
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jFileChooser.setAcceptAllFileFilterUsed(false);

        int returnVal = jFileChooser.showOpenDialog(this);
        //  System.out.println("|"+returnVal+"|");
        if (returnVal == 0) {
            writeDirectory = jFileChooser.getSelectedFile();
            updateTextArea(writeDirectory.toString());

        } else {
            updateTextArea("");
        } //cancelled   
    }//GEN-LAST:event_ButtonsopenJfileChooser2ActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        //  System.exit(0); To close the whole program
        System.exit(0);
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void DialogokbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DialogokbuttonActionPerformed
        StartWarningDialog.setVisible(false);  //exits Dialog window
    }//GEN-LAST:event_DialogokbuttonActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void FinishedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinishedActionPerformed
        JFrame frame = new JFrame("Uploading Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //show files chosen
    }//GEN-LAST:event_FinishedActionPerformed

    private void jProgressBarComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jProgressBarComponentAdded
        // TODO add your handling code here:
        //  progressBar = new JProgressBar(0, task.getLengthOfTask());
        //   progressBar.setValue(0);
        //   progressBar.setStringPainted(true);
    }//GEN-LAST:event_jProgressBarComponentAdded

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Allcwd2;
    private javax.swing.JCheckBox Alleles2;
    private javax.swing.JButton ButtonsopenJfileChooser2;
    private static javax.swing.JButton CancelButton;
    private javax.swing.JTextField DialogTxt1;
    private javax.swing.JButton Dialogokbutton;
    private javax.swing.JButton Finished;
    private javax.swing.JCheckBox Ggroups2;
    private javax.swing.JCheckBox Pgroups2;
    private javax.swing.JLabel SelectDirectoryLabel2;
    private javax.swing.JLabel SelectFilesLabel2;
    private javax.swing.JRadioButton ShowFiles2;
    private javax.swing.JButton Start2;
    private javax.swing.JDialog StartWarningDialog;
    private javax.swing.JFrame UploadingFrame;
    private javax.swing.JLabel UploadingLabel;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private static javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    public void run() {
        redirectSystemStreams();
        System.out.println("THIS IS A DEMO FOR REDIRECTING OUTPUT TO GUI");

        System.out.println("--------------------------------------------");

        for (int i = 0; i < 30; i++) {
            System.out.print(Math.random() + "\t");
            System.out.println("<<End");
        }

        System.out.println("--------------------------------------------");

    }

//The following codes set where the text get redirected. In this case, jTextArea1    
    private void updateTextArea(String text) {

        // text = jFileChooser.getSelectedFile().toString();
        jTextArea1.setText(text);

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

            }
        });
    }

//Followings are The Methods that do the Redirect, you can simply Ignore them. 
    private void redirectSystemStreams() {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                updateTextArea(String.valueOf((char) b));
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                updateTextArea(new String(b, off, len));
            }

            @Override
            public void write(byte[] b) throws IOException {
                write(b, 0, b.length);
            }
        };

        System.setOut(new PrintStream(out, true));
        System.setErr(new PrintStream(out, true));
    }


// main class
    public static void main(String WritePath, String Showfiles, int FilesToBeWritten) {
        System.out.println("hi");

        JFrame f = new TestFrame();
        f.setSize(400, 400);
        f.setTitle("CWDUpdater v0.0.1.alpha");
        f.setLocation(500, 400); // distqance in pixels from the top-left chroner of the screen
        f.setAlwaysOnTop(true);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        FilesToBeWritten = 0 - 6;

        switch (FilesToBeWritten) {
            case 0:
                //makeAlleles = true;
              //  makePgroups = true;
               // makeGgroups = true;
                break;

        }

       
//call "program" (initComponets? TestFrame?)
    }

}
