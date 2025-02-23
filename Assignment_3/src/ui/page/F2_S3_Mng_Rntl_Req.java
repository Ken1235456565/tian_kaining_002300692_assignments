/*
 * CreateProductJPanel.java
 *
 */
package ui.page;


import java.awt.CardLayout;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelEvent;
import model.APP;
import model.Branch;
import model.RentalRequest;
import model.User;


/**
 *
 * @author Rushabh
 */
public class F2_S3_Mng_Rntl_Req extends javax.swing.JPanel {

    private JPanel workArea;
    private User branchManager;
    private Branch branch;
    private List<RentalRequest> rentalRequests;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    /**
     * Creates new form CreateProductJPanel
     */
    public F2_S3_Mng_Rntl_Req(JPanel workArea, User branchManager) {
        initComponents();
        this.workArea = workArea;
        this.branchManager = branchManager;
        
        // Get the branch associated with this branch manager
        APP app = APP.getInstance();
        for (Branch b : app.getBranches()) {
            if (b.getManagerName().equals(branchManager.getUsername())) {
                this.branch = b;
                break;
            }
        }
        
        // If no branch found, create a default one (this should not happen in practice)
        if (this.branch == null) {
            JOptionPane.showMessageDialog(this, 
                "No branch found for this manager. Please contact system administrator.", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Get rental requests for this branch
        this.rentalRequests = branch.getRentalRequests();
        
        refreshTable();
    }
    
    public void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) tblFeatures.getModel();
        model.setRowCount(0); // Clear existing rows
        
        // Populate the table with rental request data
        for (RentalRequest request : rentalRequests) {
            Object[] row = new Object[5];
            row[0] = branch.getName();
            row[1] = request.getRequestId();
            row[2] = String.format("$%.2f", request.getPrice());
            row[3] = request.getStatus();
            row[4] = request.getRentDuration() + " days";
            
            model.addRow(row);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnApproveRent = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        btnViewRent = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFeatures = new javax.swing.JTable();
        btnDeclineRent = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setText("Manage rental requirement");

        btnApproveRent.setText("Approve Rent");
        btnApproveRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveRentActionPerformed(evt);
            }
        });

        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        btnViewRent.setText("View Rent");
        btnViewRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewRentActionPerformed(evt);
            }
        });

        tblFeatures.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Branch", "ID", "Price", "Status", "Rent duration"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFeatures);

        btnDeclineRent.setText("Decline Rent");
        btnDeclineRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeclineRentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnApproveRent)
                        .addGap(7, 7, 7)
                        .addComponent(btnDeclineRent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewRent))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApproveRent)
                    .addComponent(btnViewRent)
                    .addComponent(btnDeclineRent))
                .addContainerGap(171, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) workArea.getLayout();
    layout.show(workArea, "BranchManagerPanel");
    }//GEN-LAST:event_backButtonActionPerformed

    private void btnApproveRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveRentActionPerformed
        int selectedRow = tblFeatures.getSelectedRow();
    
    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, 
            "Please select a rental request to approve.", 
            "No Selection", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    String requestId = (String) tblFeatures.getValueAt(selectedRow, 1);
    String status = (String) tblFeatures.getValueAt(selectedRow, 3);
    
    if (!status.equals("PENDING")) {
        JOptionPane.showMessageDialog(this, 
            "Only pending requests can be approved.", 
            "Invalid Operation", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    RentalRequest selectedRequest = null;
    for (RentalRequest request : rentalRequests) {
        if (request.getRequestId().equals(requestId)) {
            selectedRequest = request;
            break;
        }
    }
    
    if (selectedRequest != null) {
        selectedRequest.updateStatus("APPROVED");
        JOptionPane.showMessageDialog(this, "Rental request approved successfully.");
        refreshTable();
    }
    }//GEN-LAST:event_btnApproveRentActionPerformed

    private void btnViewRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewRentActionPerformed
        // TODO add your handling code here:
        // 获取选定行
    int selectedRow = tblFeatures.getSelectedRow();
    
    // 检查是否有选定行
    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, 
            "Please select a rental request to view.", 
            "No Selection", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // 获取请求ID
    String requestId = (String) tblFeatures.getValueAt(selectedRow, 1);
    
    // 找到对应的租借请求
    RentalRequest selectedRequest = null;
    for (RentalRequest request : rentalRequests) {
        if (request.getRequestId().equals(requestId)) {
            selectedRequest = request;
            break;
        }
    }
    
    if (selectedRequest != null) {
        // 显示租借详情
        StringBuilder details = new StringBuilder();
        details.append("Request ID: ").append(selectedRequest.getRequestId()).append("\n");
        details.append("Book: ").append(selectedRequest.getBook().getName()).append("\n");
        details.append("Customer: ").append(selectedRequest.getCustomer().getUser().getUsername()).append("\n");
        details.append("Status: ").append(selectedRequest.getStatus()).append("\n");
        details.append("Request Date: ").append(dateFormat.format(selectedRequest.getRequestDate())).append("\n");
        details.append("Return Date: ").append(dateFormat.format(selectedRequest.getReturnDate())).append("\n");
        details.append("Duration: ").append(selectedRequest.getRentDuration()).append(" days\n");
        details.append("Price: $").append(String.format("%.2f", selectedRequest.getPrice())).append("\n");
        
        // 判断是否逾期
        if (selectedRequest.isOverdue()) {
            details.append("\nWARNING: This rental is OVERDUE!");
        }
        
        // 如果状态是待定，提供选项按钮
        if (selectedRequest.getStatus().equals("PENDING")) {
            int option = JOptionPane.showOptionDialog(
                this,
                details.toString(),
                "Rental Request Details",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Approve", "Reject", "Close"},
                "Close"
            );
            
            if (option == 0) { // Approve
                selectedRequest.updateStatus("APPROVED");
                JOptionPane.showMessageDialog(this, "Rental request approved successfully.");
                refreshTable();
            } else if (option == 1) { // Reject
                selectedRequest.updateStatus("REJECTED");
                selectedRequest.getBook().setAvailability(true); // 归还书籍
                JOptionPane.showMessageDialog(this, "Rental request rejected.");
                refreshTable();
            }
        } else {
            JOptionPane.showMessageDialog(this, details.toString(), "Rental Request Details", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    }//GEN-LAST:event_btnViewRentActionPerformed

    private void btnDeclineRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeclineRentActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblFeatures.getSelectedRow();
    
    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, 
            "Please select a rental request to decline.", 
            "No Selection", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    String requestId = (String) tblFeatures.getValueAt(selectedRow, 1);
    String status = (String) tblFeatures.getValueAt(selectedRow, 3);
    
    if (!status.equals("PENDING")) {
        JOptionPane.showMessageDialog(this, 
            "Only pending requests can be declined.", 
            "Invalid Operation", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    RentalRequest selectedRequest = null;
    for (RentalRequest request : rentalRequests) {
        if (request.getRequestId().equals(requestId)) {
            selectedRequest = request;
            break;
        }
    }
    
    if (selectedRequest != null) {
        selectedRequest.updateStatus("REJECTED");
        // 当拒绝请求时，需要将书籍设为可用状态
        selectedRequest.getBook().setAvailability(true);
        JOptionPane.showMessageDialog(this, "Rental request declined.");
        refreshTable();
    }
    }//GEN-LAST:event_btnDeclineRentActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton btnApproveRent;
    private javax.swing.JButton btnDeclineRent;
    private javax.swing.JButton btnViewRent;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblFeatures;
    // End of variables declaration//GEN-END:variables
}
