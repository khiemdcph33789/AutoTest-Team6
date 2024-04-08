/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import CustomCantainers.Header;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javaswingdev.drawer.EventDrawer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author khiem
 */
public class NhanVienFrame extends javax.swing.JFrame {

    private JPanel panelSanPham;
    private JPanel panelHoaDon;
    private JPanel panelDotGG;
    private JPanel panelKhachHang;
    private JPanel panelPhieuGG;
    private DrawerController drawer;

    /**
     * Creates new form MainFrame
     */
    public NhanVienFrame() {
        initComponents();
        GetPanel();
        drawer = Drawer.newDrawer(this)
                  .header(new Header())
                  .separator(2, new Color(173, 173, 173))
                  .drawerBackground(new Color(245, 245, 245))
                  .backgroundTransparent(0.3f)
                  .itemHeight(60)
                  .addChild(new DrawerItem("Hóa đơn").icon(new ImageIcon(getClass().getResource("/Icon/bill.png"))).build())
                  .addChild(new DrawerItem("Sản phẩm").icon(new ImageIcon(getClass().getResource("/Icon/ProductICON.png"))).build())
                  .addChild(new DrawerItem("Khách hàng").icon(new ImageIcon(getClass().getResource("/Icon/people.png"))).build())
                  .addFooter(new DrawerItem("Exit").icon(new ImageIcon(getClass().getResource("/Icon/exit.png"))).build())
                  .event(new EventDrawer() {

                      @Override
                      public void selected(int i, DrawerItem di) {
                          if(i == 0){
                              ShowHoaDon();
                          }
                          if(i == 1){
                              ShowSanPham();
                          }
                          if(i == 2){
                              ShowKhachHang();
                          }
                          if(i == 3){
                              System.exit(0);
                          }
                          
                      }
                  })
                  .build();
    }

    public void GetPanel() {

        FrameSanPham frameSanPham = new FrameSanPham();
        panelSanPham = frameSanPham.getSanPhamPanel();
        panelSanPham.setVisible(false);
        panelSanPham.setBounds(0, 0, 1300, 700);
        
        JFrameHoaDon frameHoaDon = new JFrameHoaDon();
        panelHoaDon = frameHoaDon.getHoaDonPanel();
        panelHoaDon.setVisible(true);
        panelHoaDon.setBounds(0, 0, 1300, 700);
        
        FramePhieuGiamGia framePhieuGG = new FramePhieuGiamGia();
        panelPhieuGG = framePhieuGG.getPhieuGGPanel();
        panelPhieuGG.setVisible(false);
        panelPhieuGG.setBounds(0, 0, 1300, 700);

        FrameDotGiamGia frameDotGG = new FrameDotGiamGia();
        panelDotGG = frameDotGG.getPanelDotGG();
        panelDotGG.setVisible(false);
        panelDotGG.setBounds(0, 0, 1300, 700);

        FrameKhachHang frameKhachHang = new FrameKhachHang();
        panelKhachHang = frameKhachHang.getKhachHangPanel();
        panelKhachHang.setVisible(false);
        panelKhachHang.setBounds(0, 0, 1300, 700);

        MainPanel.add(panelSanPham);
        MainPanel.add(panelDotGG);
        MainPanel.add(panelKhachHang);
        MainPanel.add(panelPhieuGG);
        MainPanel.add(panelHoaDon);

        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        MainPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bán Váy");

        MainPanel.setPreferredSize(new java.awt.Dimension(1300, 700));

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/list.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (drawer.isShow()) {
            drawer.hide();
        } else {
            drawer.show();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
        public void ShowHoaDon(){
            panelSanPham.setVisible(false);
            panelHoaDon.setVisible(true);
            panelPhieuGG.setVisible(false);
            panelDotGG.setVisible(false);
            panelKhachHang.setVisible(false);

        }
        public void ShowSanPham(){
            panelSanPham.setVisible(true);
            panelHoaDon.setVisible(false);
            panelPhieuGG.setVisible(false);
            panelDotGG.setVisible(false);
            panelKhachHang.setVisible(false);

        }
        public void ShowKhachHang(){
            panelSanPham.setVisible(false);
            panelHoaDon.setVisible(false);
            panelPhieuGG.setVisible(false);
            panelDotGG.setVisible(false);
            panelKhachHang.setVisible(true);

        }
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
            java.util.logging.Logger.getLogger(NhanVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanVienFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
