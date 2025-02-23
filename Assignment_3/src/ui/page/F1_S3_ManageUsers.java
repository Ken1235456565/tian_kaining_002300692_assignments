package ui.page;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelEvent;
import model.Profile;
import model.Role;
import model.User;
import model.UserDirectory;

/**
 *
 * @author Rushabh
 */
public class F1_S3_ManageUsers extends javax.swing.JPanel {

    private JPanel workArea;
    private UserDirectory userDirectory;

    public F1_S3_ManageUsers(JPanel workArea, UserDirectory userDirectory) {
        initComponents();
        this.workArea = workArea;
        this.userDirectory = userDirectory;
        refreshTable();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnAddUser = new javax.swing.JButton();
        btnRemoveUser = new javax.swing.JButton();
        backButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setText("Manage Users");

        btnAddUser.setText("New User");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        btnRemoveUser.setText("Delete User");
        btnRemoveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveUserActionPerformed(evt);
            }
        });

        backButton1.setText("<< Back");
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });

        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserID", "UserName", "Role", "Branch"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUsers);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnAddUser)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveUser))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(backButton1)
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
                    .addComponent(backButton1))
                .addGap(64, 64, 64)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddUser)
                    .addComponent(btnRemoveUser))
                .addContainerGap(177, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        CardLayout layout = (CardLayout) workArea.getLayout();
layout.show(workArea, "AdminPanel");
    }//GEN-LAST:event_backButton1ActionPerformed


    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        F1_S4_AddUser addUserPanel = new F1_S4_AddUser(workArea, userDirectory);
        workArea.add("AddUserPanel", addUserPanel);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.show(workArea, "AddUserPanel");
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void btnRemoveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveUserActionPerformed
        int selectedRow = tblUsers.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a user to delete.");
            return;
        }
        
        String username = (String) tblUsers.getValueAt(selectedRow, 1);
        User userToRemove = userDirectory.findUserByUsername(username);
        
        if (userToRemove != null) {
            userDirectory.removeUser(userToRemove);
            JOptionPane.showMessageDialog(this, "User removed successfully.");
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(this, "User not found.");
        }
    }//GEN-LAST:event_btnRemoveUserActionPerformed

    public void refreshTable() {
    // Create a new model instead of clearing the existing one
    DefaultTableModel model = new DefaultTableModel(
        new Object[][] {}, // Empty data
        new String[] {"UserID", "UserName", "Role", "Branch"} // Your column names
    ) {
        // Define column types if needed
        Class[] types = new Class[] {
            java.lang.String.class, java.lang.String.class, 
            java.lang.Object.class, java.lang.Object.class
        };
        
        @Override
        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }
        
        // Make cells non-editable if desired
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    // Add all users at once to the new model
    for (User user : userDirectory.getUsers()) {
        model.addRow(new Object[] {
            user.getProfile().getuserID(),
            user.getUsername(),
            user.getProfile().getRole().getRoleName(),
            "" // Branch info if available
        });
    }
    
    // Replace the old model with the new one in a single operation
    tblUsers.setModel(model);
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton1;
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnRemoveUser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblUsers;
    // End of variables declaration//GEN-END:variables
 
}
