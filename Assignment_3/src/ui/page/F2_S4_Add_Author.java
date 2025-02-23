/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.page;

import java.awt.CardLayout;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Author;
import model.AuthorDirectory;
import model.User;

/**
 *
 * @author archil
 */
public class F2_S4_Add_Author extends javax.swing.JPanel {
    private JPanel mainWorkArea;
    private AuthorDirectory authorDirectory;
    
    /**
     * Creates new form LoginScreen
     */
    public F2_S4_Add_Author(JPanel mainWorkArea, AuthorDirectory authorDirectory) {
        initComponents();
        this.mainWorkArea = mainWorkArea;
        this.authorDirectory = authorDirectory;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblBranchName = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        lblBranchSupplier = new javax.swing.JLabel();
        txtAuthorID = new javax.swing.JTextField();
        txtAuthorName = new javax.swing.JTextField();
        lblBranchID = new javax.swing.JLabel();
        txtBook = new javax.swing.JTextField();
        backButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitle.setText("New Author");

        lblBranchName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBranchName.setText("Author Name:");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblBranchSupplier.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBranchSupplier.setText("Book:");

        lblBranchID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBranchID.setText("Author ID:");

        backButton1.setText("<< Back");
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblBranchName)
                            .addComponent(lblBranchID))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAuthorName, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAuthorID, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(backButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBranchSupplier)
                        .addGap(18, 18, 18)
                        .addComponent(txtBook, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(380, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblBranchName, lblBranchSupplier});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(backButton1)
                .addGap(38, 38, 38)
                .addComponent(lblTitle)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAuthorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBranchID))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAuthorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBranchName))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBranchSupplier))
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addGap(271, 271, 271))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // Get input values
        String authorId = txtAuthorID.getText().trim();
        String authorName = txtAuthorName.getText().trim();
        String bookName = txtBook.getText().trim();
        
        // Validate inputs
        if (authorId.isEmpty() || authorName.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Author ID and Author Name are required fields.", 
                "Missing Information", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Check if author ID already exists
        for (Author existingAuthor : authorDirectory.getAuthors()) {
            if (existingAuthor.getAuthorId().equals(authorId)) {
                JOptionPane.showMessageDialog(this, 
                    "Author ID already exists. Please use a different ID.", 
                    "Duplicate ID", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        // Create a new author
        Author newAuthor = new Author(authorId, authorName, new Date(), "Not specified");
        
        // Add the author to the directory
        authorDirectory.addAuthor(newAuthor);
        
        JOptionPane.showMessageDialog(this, "Author added successfully!");
        
        // Go back to the previous panel
        backButton1ActionPerformed(evt);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        // Go back to the previous panel
        CardLayout layout = (CardLayout) mainWorkArea.getLayout();
    layout.show(mainWorkArea, "ManageAuthorsPanel");
    }//GEN-LAST:event_backButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton1;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblBranchID;
    private javax.swing.JLabel lblBranchName;
    private javax.swing.JLabel lblBranchSupplier;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtAuthorID;
    private javax.swing.JTextField txtAuthorName;
    private javax.swing.JTextField txtBook;
    // End of variables declaration//GEN-END:variables
    
}
