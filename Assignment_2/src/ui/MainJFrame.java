/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.CardLayout;
import java.time.LocalDate;
import model.Owner;
import model.OwnerDirectory;
import model.VehicleCatalog;
import model.Service;
import model.Vehicle;
import model.ServiceCatalog;

/**
 *
 * @author archil
 */
public class MainJFrame extends javax.swing.JFrame {
    private OwnerDirectory ownerDirectory;
    private Service service;
    private VehicleCatalog vehicleCatalog;
    private ServiceCatalog serviceCatalog;
    
    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents(); // NetBeans 生成的 UI 代码
        ownerDirectory = new OwnerDirectory(); // 初始化车主目录
        mainWorkArea = new javax.swing.JPanel();
        mainWorkArea.setLayout(new CardLayout());
        
        // basic setings
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        getContentPane().add(mainWorkArea); // 加载导航界面

        populateDemoData(); // 预填充测试数据
        setNavigationPage(); // 设置导航页面
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainWorkArea = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainWorkArea.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainWorkArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainWorkArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    private void setNavigationPage() {
        mainWorkArea.removeAll(); // 清空当前面板
        mainWorkArea.revalidate();
        mainWorkArea.repaint();
        
        NavigationPage ls = new NavigationPage(mainWorkArea, ownerDirectory);
        ls.setEnabled(true); // 确保页面可编辑
        mainWorkArea.add("NavigationPage", ls);
        
        CardLayout layout = (CardLayout) mainWorkArea.getLayout();
        layout.show(mainWorkArea, "NavigationPage"); // 确保正确切换
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainWorkArea;
    // End of variables declaration//GEN-END:variables

    private void populateDemoData() {

    // 创建 Owner（车主）
    Owner owner1 = new Owner();
    owner1.setOwnerID(1);
    owner1.setOwnerFirstName("John");
    owner1.setOwnerLastName("Doe");

    Owner owner2 = new Owner();
    owner2.setOwnerID(2);
    owner2.setOwnerFirstName("Alice");
    owner2.setOwnerLastName("Smith");

    Owner owner3 = new Owner();
    owner3.setOwnerID(3);
    owner3.setOwnerFirstName("Michael");
    owner3.setOwnerLastName("Johnson");

    Owner owner4 = new Owner();
    owner4.setOwnerID(4);
    owner4.setOwnerFirstName("Emily");
    owner4.setOwnerLastName("Davis");

    Owner owner5 = new Owner();
    owner5.setOwnerID(5);
    owner5.setOwnerFirstName("David");
    owner5.setOwnerLastName("Brown");

    // 添加 Owner 到目录
    ownerDirectory.addOwner(owner1);
    ownerDirectory.addOwner(owner2);
    ownerDirectory.addOwner(owner3);
    ownerDirectory.addOwner(owner4);
    ownerDirectory.addOwner(owner5);

    // 创建 Service（服务）
    Service service1 = new Service(101, "Oil Change", 50.0, "Mike", 30);
    Service service2 = new Service(102, "Car Wash", 20.0, "Sara", 15);
    Service service3 = new Service(103, "Tire Replacement", 80.0, "Tom", 60);

    // 添加 Service 到 ServiceCatalog
    serviceCatalog.addService(service1);
    serviceCatalog.addService(service2);
    serviceCatalog.addService(service3);

    // 创建 Vehicle（车辆）并绑定到 Owner 和 Service
    Vehicle vehicle1 = new Vehicle("Toyota", "Camry", 2020, "ABC123");
    vehicle1.addService(service1);
    owner1.getVehicleCatalog().addVehicle(vehicle1);

    Vehicle vehicle2 = new Vehicle("Honda", "Civic", 2019, "XYZ789");
    vehicle2.addService(service2);
    owner2.getVehicleCatalog().addVehicle(vehicle2);

    Vehicle vehicle3 = new Vehicle("Toyota", "Camry", 2021, "LMN456"); // 车型与 vehicle1 相同
    vehicle3.addService(service3);
    owner3.getVehicleCatalog().addVehicle(vehicle3);

    Vehicle vehicle4 = new Vehicle("Ford", "Mustang", 2018, "PQR678");
    vehicle4.addService(service1);
    owner4.getVehicleCatalog().addVehicle(vehicle4);

    Vehicle vehicle5 = new Vehicle("BMW", "X5", 2022, "DEF345");
    vehicle5.addService(service2);
    owner5.getVehicleCatalog().addVehicle(vehicle5);

    // 添加 Vehicle 到 VehicleCatalog
    vehicleCatalog.addVehicle(vehicle1);
    vehicleCatalog.addVehicle(vehicle2);
    vehicleCatalog.addVehicle(vehicle3);
    vehicleCatalog.addVehicle(vehicle4);
    vehicleCatalog.addVehicle(vehicle5);
    }   
}
