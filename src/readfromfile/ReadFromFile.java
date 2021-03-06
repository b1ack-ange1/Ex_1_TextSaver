/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readfromfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author s.nedelko
 */
public class ReadFromFile extends javax.swing.JFrame {

    final static long MB10 = 1000 * 1000 * 10;
    JFileChooser jFileChooser;
    private File file;

    /**
     * Creates new form NewJFrame
     */
    public ReadFromFile() {
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

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("textSaver");
        setLocationByPlatform(true);
        setResizable(false);

        jFileChooser = new javax.swing.JFileChooser();

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Кнопкой Open File загружаем текстовый файл, кнопкой Save File сохраняем его в любой другой.\nЛибо же сохраняем в файл, любой, набранный текст.\n");
        jTextArea1.setToolTipText("");
        jTextArea1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(0, 255, 255)));
        jTextArea1.setDragEnabled(true);
        jTextArea1.setMaximumSize(new java.awt.Dimension(600, 600));
        jTextArea1.setSelectionColor(new java.awt.Color(204, 204, 255));
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Save File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Open File");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(81, 81, 81))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Сохраняем файл
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int returnVal;
        returnVal = jFileChooser.showSaveDialog(ReadFromFile.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File fileOut = jFileChooser.getSelectedFile();
            String filePath = fileOut.getPath();
            if (!filePath.toLowerCase().endsWith(".zip")) {
                fileOut = new File(filePath + ".zip");
            }
            try (FileOutputStream fos = new FileOutputStream(file, true);
                    BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
                    ) {
                long size = fos.getChannel().size();
                //Если размер файла больше 10Мб, то сжимаем его
                if (size > MB10) {
                    try (FileInputStream fis = new FileInputStream(file);
                            FileOutputStream fosGZIP = new FileOutputStream(fileOut);
                            GZIPOutputStream gzipOS = new GZIPOutputStream(fosGZIP);) {
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = fis.read(buffer)) != -1) {
                            gzipOS.write(buffer, 0, len);
                        }

                    } catch (IOException e) {
                        jLabel1.setText(e.getLocalizedMessage());
                        e.printStackTrace();
                    }
                } else {
                    String[] lines = jTextArea1.getText().split("\n");
                    for (int i = 0; i < lines.length; i++) {
                        bWriter.append(lines[i]);
                        bWriter.append(System.getProperty("line.separator"));
                    }
                    bWriter.flush();
                }
            } catch (IOException e) {
                jLabel1.setText(e.getLocalizedMessage());
                e.printStackTrace();
            }

            jLabel1.setText("Saving file: " + fileOut.getName() + " completed " + "\n");
        } else {
            jLabel1.setText("Save command cancelled by User" + "\n");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    //Открываем файл
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        FileNameExtensionFilter filter = new FileNameExtensionFilter(null, "txt");
        jFileChooser.setFileFilter(filter);
        int returnVal;
        returnVal = jFileChooser.showOpenDialog(ReadFromFile.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = jFileChooser.getSelectedFile();
            jTextArea1.setText("");
            String line = null;
            long size = file.length();
            //Если размер файла больше 10Мб, то не выводим его
            if (size < MB10) {
                try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file.getAbsolutePath()), "cp1251");
                        BufferedReader fileReader = new BufferedReader(isr)) {
                    while ((line = fileReader.readLine()) != null) {
                        jTextArea1.append(line + "\n");
                    }
                } catch (FileNotFoundException | UnsupportedEncodingException ex) {
                    jTextArea1.append(ex.getMessage());
                } catch (IOException ex) {
                    jTextArea1.append(ex.getMessage());
                }

                String fullText = jTextArea1.getText();
                StringTokenizer stk = new StringTokenizer(fullText, " ");
                int tokenCount = stk.countTokens();
                jLabel1.setText("Read " + String.valueOf(tokenCount) + " words from "
                        + jFileChooser.getSelectedFile().getAbsolutePath() + "\n completed!");
            } else {
                jLabel1.setText("File is bigger than 10 Mb!");
            }

        } else {
            jLabel1.setText("Open command cancelled by user." + "\n");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            /*
             for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
             if ("Nimbus".equals(info.getName())) {
             javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
             break;
             }
             }
             */

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReadFromFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReadFromFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReadFromFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReadFromFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReadFromFile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
