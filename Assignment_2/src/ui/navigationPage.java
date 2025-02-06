/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.OwnerDirectory;
import ui.service.Services;
import ui.service.ManageVehicles;
import ui.user.Vehicles_Owner;
;

/**
 *
 * @author archil
 */
public class NavigationPage extends javax.swing.JPanel {

    private JPanel mainWorkArea;
    private OwnerDirectory ownerDirectory;
   

    public NavigationPage(JPanel mainWorkArea, OwnerDirectory ownerDirectory) {
        initComponents(); // 仅初始化 UI
        this.mainWorkArea = mainWorkArea;
        this.ownerDirectory = ownerDirectory;
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
        btnServices = new javax.swing.JButton();
        btnVehicle_Owner = new javax.swing.JButton();
        btnManageVehicles = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitle.setText("Welcome to Vehicle Service Management Application");

        btnServices.setText("Services");
        btnServices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicesActionPerformed(evt);
            }
        });

        btnVehicle_Owner.setText("Vehicle & Owner");
        btnVehicle_Owner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVehicle_OwnerActionPerformed(evt);
            }
        });

        btnManageVehicles.setText("Manage Vehicles");
        btnManageVehicles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageVehiclesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVehicle_Owner, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnServices, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnManageVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(196, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lblTitle)
                .addGap(57, 57, 57)
                .addComponent(btnServices)
                .addGap(18, 18, 18)
                .addComponent(btnVehicle_Owner)
                .addGap(18, 18, 18)
                .addComponent(btnManageVehicles)
                .addContainerGap(345, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnServicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicesActionPerformed
        Services panel = new Services(mainWorkArea, ownerDirectory);
        mainWorkArea.add("ManageServicesPanel", panel);
        ((CardLayout) mainWorkArea.getLayout()).next(mainWorkArea);
    }//GEN-LAST:event_btnServicesActionPerformed

    private void btnVehicle_OwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVehicle_OwnerActionPerformed
        // TODO add your handling code here:
        Vehicles_Owner panel = new Vehicles_Owner(mainWorkArea, ownerDirectory);
        mainWorkArea.add("ManageOwnersPanel", panel);
        ((CardLayout) mainWorkArea.getLayout()).next(mainWorkArea);
    }//GEN-LAST:event_btnVehicle_OwnerActionPerformed

    private void btnManageVehiclesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageVehiclesActionPerformed
        // TODO add your handling code here:
        ManageVehicles panel = new ManageVehicles(mainWorkArea, od);
        mainWorkArea.add("ManageVehiclesPanel", panel);
        ((CardLayout) mainWorkArea.getLayout()).next(mainWorkArea);
    }//GEN-LAST:event_btnManageVehiclesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageVehicles;
    private javax.swing.JButton btnServices;
    private javax.swing.JButton btnVehicle_Owner;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables

}
