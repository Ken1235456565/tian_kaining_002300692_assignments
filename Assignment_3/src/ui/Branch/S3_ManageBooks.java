/*
 * CreateProductJPanel.java
 *
 */
package ui.Branch;

import model.Product;
import model.Feature;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelEvent;
import model.Feature;

/**
 *
 * @author Rushabh
 */
public class S3_ManageBooks extends javax.swing.JPanel {

    JPanel workArea;
    Product product;
    Feature feature;

    /**
     * Creates new form CreateProductJPanel
     */
    public S3_ManageBooks(JPanel workArea, Product product) {
        initComponents();
        this.workArea = workArea;
        this.product = product;

        txtName.setText(this.product.getName());
        txtId.setText(String.valueOf(this.product.getId()));
        txtPrice.setText(String.valueOf(this.product.getPrice()));
        
        // Add table cell edit listener
        tblFeatures.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE && tblFeatures.isEnabled()) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                DefaultTableModel model = (DefaultTableModel) tblFeatures.getModel();
                String name = (model.getValueAt(row, 0) != null) ? model.getValueAt(row, 0).toString().trim() : "";
                Object value = (model.getValueAt(row, 1) != null) ? model.getValueAt(row, 1) : "N/A";

                // 确保 name 不为空
                if (!name.isEmpty()) {
                    Feature existingFeature = null;

                    // 遍历当前 Product 的 features 查找是否已经存在
                    for (Feature f : product.getFeatures()) {
                        if (f.getName().equals(name)) {
                            existingFeature = f;
                            break;
                        }
                    }

                    if (existingFeature != null) {
                        existingFeature.setValue(value); // 更新已有特性值
                    } else {
                        Feature feature = new Feature(product, name, value);
                        product.addFeature(feature);
                    }
                }
            }
        });


        refreshTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        btnAddFeature = new javax.swing.JButton();
        btnRemoveFeature = new javax.swing.JButton();
        backButton1 = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFeatures = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setText("Manage Books");

        lblName.setText("Branch Name:");

        btnAddFeature.setText("New Book");
        btnAddFeature.setEnabled(false);
        btnAddFeature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFeatureActionPerformed(evt);
            }
        });

        btnRemoveFeature.setText("Delete Boak");
        btnRemoveFeature.setEnabled(false);
        btnRemoveFeature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveFeatureActionPerformed(evt);
            }
        });

        backButton1.setText("<< Back");
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });

        btnSave.setText("View Details");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        tblFeatures.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial Numbe", "Book Name", "Registration Date", "Availability"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblFeatures.setEnabled(false);
        jScrollPane1.setViewportView(tblFeatures);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnAddFeature)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveFeature)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(backButton1)
                        .addGap(38, 38, 38)
                        .addComponent(lblTitle))
                    .addComponent(lblName, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(backButton1))
                .addGap(29, 29, 29)
                .addComponent(lblName)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnAddFeature)
                    .addComponent(btnRemoveFeature))
                .addContainerGap(177, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        // TODO add your handling code here:
        backAction();
    }//GEN-LAST:event_backButton1ActionPerformed

    private void backAction() {
        workArea.remove(this);
        Component[] componentArray = workArea.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManageProductCatalogJPanel manageProductCatalogJPanel = (ManageProductCatalogJPanel) component;
        manageProductCatalogJPanel.refreshTable();
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.previous(workArea);
    }
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        try {
        product.setName(txtName.getText());
        String priceText = txtPrice.getText().trim();
        if (!priceText.isEmpty()) {
            int price = Integer.parseInt(priceText);
            product.setPrice(price);
        }

        // 先保存特性
        saveFeatures();
        
        // 禁用编辑状态
        txtName.setEditable(false);
        txtPrice.setEditable(false);
        btnSave.setEnabled(false);
        tblFeatures.setEnabled(false);
        btnAddFeature.setEnabled(false);
        btnRemoveFeature.setEnabled(false);

        JOptionPane.showMessageDialog(this, 
            "Product information saved successfully!", 
            "Success", 
            JOptionPane.INFORMATION_MESSAGE);
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, 
            "Please enter a valid price", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void saveFeatures() {
    DefaultTableModel model = (DefaultTableModel) tblFeatures.getModel();
    
    // 用于存储最新的功能列表，避免重复
    List<Feature> updatedFeatures = new ArrayList<>();

    for (int i = 0; i < model.getRowCount(); i++) {
        String name = (model.getValueAt(i, 0) != null) ? model.getValueAt(i, 0).toString().trim() : "";
        Object value = model.getValueAt(i, 1);

        if (!name.isEmpty()) {
            Feature existingFeature = product.findFeatureByName(name);
            
            if (existingFeature != null) {
                existingFeature.setValue(value);  // 如果已经存在，更新值
                updatedFeatures.add(existingFeature);
            } else {
                Feature newFeature = new Feature(product, name, value);
                updatedFeatures.add(newFeature);
            }
        }
    }

    // 更新 Product 的 features
    product.getFeatures().clear();
    product.getFeatures().addAll(updatedFeatures);
}

    private void btnAddFeatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFeatureActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblFeatures.getModel();
        model.addRow(new Object[]{"", ""}); // 添加空行，用户可直接输入
    }//GEN-LAST:event_btnAddFeatureActionPerformed

    private void btnRemoveFeatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFeatureActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblFeatures.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a feature to remove", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String featureName = (String) tblFeatures.getValueAt(selectedRow, 0);
        Object featureValue = tblFeatures.getValueAt(selectedRow, 1);

        Feature featureToRemove = null;
        for (Feature feature : product.getFeatures()) {
            if (feature.getName().equals(featureName) && feature.getValue().equals(featureValue)) {
                featureToRemove = feature;
                break;
            }
        }

        if (featureToRemove != null) {
            product.removeFeature(featureToRemove); // 从 Product 的 features 列表中删除
        }

        ((DefaultTableModel) tblFeatures.getModel()).removeRow(selectedRow); // 从表格中删除
    }//GEN-LAST:event_btnRemoveFeatureActionPerformed

    public void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) tblFeatures.getModel();
        model.setRowCount(0);

        for (Feature feature : product.getFeatures()) {
            model.addRow(new Object[]{feature.getName(), feature.getValue()});
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton1;
    private javax.swing.JButton btnAddFeature;
    private javax.swing.JButton btnRemoveFeature;
    private javax.swing.JButton btnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblFeatures;
    // End of variables declaration//GEN-END:variables
}
