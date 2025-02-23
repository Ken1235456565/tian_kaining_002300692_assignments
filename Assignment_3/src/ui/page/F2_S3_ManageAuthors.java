package ui.page;

import java.awt.CardLayout;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.*;

public class F2_S3_ManageAuthors extends javax.swing.JPanel {

    private JPanel workArea;
    private User branchManager;
    private List<Author> authors;
    private AuthorDirectory authorDirectory;

    public F2_S3_ManageAuthors(JPanel workArea, User branchManager) {
        initComponents();
        this.workArea = workArea;
        this.branchManager = branchManager;
        
        // Get the author directory from the APP singleton
        APP app = APP.getInstance();
        this.authorDirectory = app.getAuthorDirectory();
        
        refreshTable();
    }
    
    private void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) tblFeatures.getModel();
        model.setRowCount(0); // Clear existing rows
        
        // Get all authors from the directory
        List<Author> authors = authorDirectory.getAuthors();
        
        // Populate the table with author data
        for (Author author : authors) {
            Object[] row = new Object[3];
            row[0] = author.getAuthorId();
            row[1] = author.getName();
            
            // If the author has books, show the first book name or "Multiple books"
            List<Book> books = author.getBooks();
            if (books != null && !books.isEmpty()) {
                if (books.size() == 1) {
                    row[2] = books.get(0).getName();
                } else {
                    row[2] = "Multiple books (" + books.size() + ")";
                }
            } else {
                row[2] = "No books";
            }
            
            model.addRow(row);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnNewAuthor = new javax.swing.JButton();
        btnDeleteAuthor = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFeatures = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setText("Manage Authors");

        btnNewAuthor.setText("New Author");
        btnNewAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewAuthorActionPerformed(evt);
            }
        });

        btnDeleteAuthor.setText("Delete Author");
        btnDeleteAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAuthorActionPerformed(evt);
            }
        });

        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        tblFeatures.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Author ID", "Author Name", "Book Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFeatures);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnNewAuthor)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteAuthor))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addGap(38, 38, 38)
                        .addComponent(lblTitle)))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(backButton))
                .addGap(64, 64, 64)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewAuthor)
                    .addComponent(btnDeleteAuthor))
                .addContainerGap(177, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) workArea.getLayout();
    layout.show(workArea, "BranchManagerPanel");
    }//GEN-LAST:event_backButtonActionPerformed
   

    private void btnNewAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewAuthorActionPerformed
        F2_S4_Add_Author addAuthorPanel = new F2_S4_Add_Author(workArea, authorDirectory);
        workArea.add("AddAuthorPanel", addAuthorPanel);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.show(workArea, "AddAuthorPanel");
    }//GEN-LAST:event_btnNewAuthorActionPerformed

    private void btnDeleteAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAuthorActionPerformed
        // Get the selected row
        int selectedRow = tblFeatures.getSelectedRow();
        
        // Check if a row is selected
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an author to remove.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Get the author ID from the selected row
        String authorId = (String) tblFeatures.getValueAt(selectedRow, 0);
        
        // Find the author in the directory
        Author authorToRemove = authorDirectory.findAuthorById(authorId);
        
        // Check if author has any books
        if (authorToRemove != null && !authorToRemove.getBooks().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Cannot remove author with existing books. Please remove the books first.", 
                "Removal Failed", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Confirm removal
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to remove author " + authorToRemove.getName() + "?", 
            "Confirm Removal", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION && authorToRemove != null) {
            // Remove the author from the directory
            authorDirectory.getAuthors().remove(authorToRemove);
            JOptionPane.showMessageDialog(this, "Author removed successfully.");
            refreshTable(); // Refresh the table to reflect changes
        }
    }//GEN-LAST:event_btnDeleteAuthorActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton btnDeleteAuthor;
    private javax.swing.JButton btnNewAuthor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblFeatures;
    // End of variables declaration//GEN-END:variables
}
