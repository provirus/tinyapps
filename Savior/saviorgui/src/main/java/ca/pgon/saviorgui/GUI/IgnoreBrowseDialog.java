/*
    Tinyapps
    https://github.com/provirus/tinyapps
    Copyright (c) 2014-2021 Foilen (https://foilen.com)

    The MIT License
    http://opensource.org/licenses/MIT

 */
package ca.pgon.saviorgui.GUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.AbstractListModel;

import ca.pgon.saviorlib.FileSystems.FileEntry;
import ca.pgon.saviorlib.FileSystems.FileSystemTools;

@SuppressWarnings("serial")
public class IgnoreBrowseDialog extends javax.swing.JDialog {
    private FileEntry fileEntry;
    public boolean okpressed = false;
    public List<FileEntry> entries;

    /** Creates new form BrowseDialog */
    public IgnoreBrowseDialog(java.awt.Frame parent, boolean modal, FileEntry fileEntry) {
        super(parent, modal);
        initComponents();

        this.fileEntry = fileEntry;

        updateFileList();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pathList = new javax.swing.JList<>();
        choose = new javax.swing.JButton();
        currentPath = new javax.swing.JLabel();
        parentButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);

        jLabel1.setText("Current path:");

        pathList.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pathListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(pathList);

        choose.setText("Choose");
        choose.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseActionPerformed(evt);
            }
        });

        parentButton.setText("Parent");
        parentButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE).addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel1).addComponent(choose, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(currentPath))
                        .addComponent(parentButton)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(currentPath))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(parentButton).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(choose)
                        .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chooseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_chooseActionPerformed
        entries = new ArrayList<>();
        okpressed = true;

        for (FileEntry o : pathList.getSelectedValuesList()) {
            entries.add(o);
        }

        if (entries.isEmpty()) {
            entries.add(fileEntry);
        }

        dispose();
    }// GEN-LAST:event_chooseActionPerformed

    private void pathListMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_pathListMouseClicked
        if (evt.getClickCount() != 2)
            return;

        fileEntry = getSelectedFileEntry();

        // Use this entry if it is a file
        if (!fileEntry.isDirectory) {
            entries = new ArrayList<>();
            entries.add(fileEntry);
            okpressed = true;
            dispose();
        }

        updateFileList();
    }// GEN-LAST:event_pathListMouseClicked

    private void parentButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_parentButtonActionPerformed
        String[] parts = fileEntry.path.split("/");
        StringBuilder newPath = new StringBuilder();
        for (int i = 0; i < parts.length - 1; ++i) {
            newPath.append(parts[i]);
            if (i != parts.length - 2)
                newPath.append('/');
        }

        fileEntry.path = newPath.toString();
        fileEntry.name = parts[parts.length - 1];

        updateFileList();
    }// GEN-LAST:event_parentButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton choose;
    private javax.swing.JLabel currentPath;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton parentButton;
    private javax.swing.JList<FileEntry> pathList;
    // End of variables declaration//GEN-END:variables

    private FileEntry getSelectedFileEntry() {
        int index = pathList.getMinSelectionIndex();
        if (index == -1)
            return fileEntry;
        return pathList.getModel().getElementAt(index);
    }

    private void updateFileList() {
        currentPath.setText(FileSystemTools.getAbsolutePath(fileEntry));
        final List<FileEntry> allFiles = fileEntry.fileSystem.listDirectory(fileEntry);

        Collections.sort(allFiles);

        pathList.setModel(new AbstractListModel<FileEntry>() {
            List<FileEntry> dir = allFiles;

            @Override
            public int getSize() {
                return dir.size();
            }

            @Override
            public FileEntry getElementAt(int index) {
                return dir.get(index);
            }
        });
    }
}
