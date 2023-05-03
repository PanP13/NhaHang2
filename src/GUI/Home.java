/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DTO.TaiKhoan;
import javax.swing.JPanel;

/**
 *
 * @author panpa
 */
public class Home extends javax.swing.JFrame {

    TaiKhoan user = new TaiKhoan();

    public Home() {
        initComponents();
    }

    public Home(TaiKhoan user, String name) {
        initComponents();

        if (user.getLoaiTK() == 1) {
            pnlMenuBTN.remove(btnKH);
            pnlMenuBTN.remove(btnNV);
        }
        txtUser.setText(name);
        this.user = user;
    }

    private void Reset() {
        pnlContent.repaint();
        pnlContent.revalidate();
    }
    
    public JPanel getContentPanel(){
        return pnlContent;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackGround = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        pnlMenuBTN = new javax.swing.JPanel();
        btnTK = new javax.swing.JButton();
        btnKH = new javax.swing.JButton();
        btnNV = new javax.swing.JButton();
        btnBan = new javax.swing.JButton();
        btnSP = new javax.swing.JButton();
        btnBH = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        pnlAccDetails = new javax.swing.JPanel();
        txtUser = new javax.swing.JLabel();
        pnlContent = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new java.awt.CardLayout());

        pnlBackGround.setBackground(new java.awt.Color(255, 255, 255));

        pnlMenu.setBackground(new java.awt.Color(159, 32, 66));

        pnlMenuBTN.setBackground(pnlMenu.getBackground());
        pnlMenuBTN.setLayout(new java.awt.GridLayout(0, 1, 5, 10));

        btnTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/account.png"))); // NOI18N
        btnTK.setToolTipText("Tài khoản");
        btnTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKActionPerformed(evt);
            }
        });
        pnlMenuBTN.add(btnTK);

        btnKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/person.png"))); // NOI18N
        btnKH.setToolTipText("Khách hàng");
        btnKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKHActionPerformed(evt);
            }
        });
        pnlMenuBTN.add(btnKH);

        btnNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/staff.png"))); // NOI18N
        btnNV.setToolTipText("Nhân viên");
        btnNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNVActionPerformed(evt);
            }
        });
        pnlMenuBTN.add(btnNV);

        btnBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/table.png"))); // NOI18N
        btnBan.setToolTipText("Bàn");
        btnBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanActionPerformed(evt);
            }
        });
        pnlMenuBTN.add(btnBan);

        btnSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/product.png"))); // NOI18N
        btnSP.setToolTipText("Sản phẩm");
        btnSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPActionPerformed(evt);
            }
        });
        pnlMenuBTN.add(btnSP);

        btnBH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/order.png"))); // NOI18N
        btnBH.setToolTipText("Hóa đơn");
        btnBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBHActionPerformed(evt);
            }
        });
        pnlMenuBTN.add(btnBH);

        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        btnLogOut.setToolTipText("Đăng xuất");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        pnlMenuBTN.add(btnLogOut);

        pnlAccDetails.setBackground(new java.awt.Color(159, 32, 66));

        txtUser.setBackground(new java.awt.Color(255, 255, 255));
        txtUser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtUser.setForeground(new java.awt.Color(255, 255, 255));
        txtUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtUser.setText("Admin");

        javax.swing.GroupLayout pnlAccDetailsLayout = new javax.swing.GroupLayout(pnlAccDetails);
        pnlAccDetails.setLayout(pnlAccDetailsLayout);
        pnlAccDetailsLayout.setHorizontalGroup(
            pnlAccDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlAccDetailsLayout.setVerticalGroup(
            pnlAccDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlMenuBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(pnlAccDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlAccDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMenuBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlContent.setBackground(new java.awt.Color(255, 255, 255));
        pnlContent.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1036, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 788, Short.MAX_VALUE)
        );

        pnlContent.add(jPanel1, "card2");

        javax.swing.GroupLayout pnlBackGroundLayout = new javax.swing.GroupLayout(pnlBackGround);
        pnlBackGround.setLayout(pnlBackGroundLayout);
        pnlBackGroundLayout.setHorizontalGroup(
            pnlBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackGroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, 1036, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlBackGroundLayout.setVerticalGroup(
            pnlBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackGroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(pnlBackGround, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKHActionPerformed
        pnlContent.removeAll();
        Reset();

        pnlContent.add(new KhachHang_GUI());
        Reset();
    }//GEN-LAST:event_btnKHActionPerformed

    private void btnSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSPActionPerformed
        pnlContent.removeAll();
        Reset();

        pnlContent.add(new SanPham_GUI());
        Reset();
    }//GEN-LAST:event_btnSPActionPerformed

    private void btnNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNVActionPerformed
        pnlContent.removeAll();
        Reset();

        pnlContent.add(new NhanVien_GUI());
        Reset();
    }//GEN-LAST:event_btnNVActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanActionPerformed
        pnlContent.removeAll();
        Reset();

        pnlContent.add(new Ban_GUI());
        Reset();
    }//GEN-LAST:event_btnBanActionPerformed

    private void btnBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBHActionPerformed
        pnlContent.removeAll();
        Reset();
        
        pnlContent.add(new HoaDon_GUI());
        System.out.println(pnlContent.getComponentCount());
        Reset();
    }//GEN-LAST:event_btnBHActionPerformed

    private void btnTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKActionPerformed
        pnlContent.removeAll();
        Reset();

        pnlContent.add(new TaiKhoan_GUI(user));
        Reset();
    }//GEN-LAST:event_btnTKActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBH;
    private javax.swing.JButton btnBan;
    private javax.swing.JButton btnKH;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnNV;
    private javax.swing.JButton btnSP;
    private javax.swing.JButton btnTK;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlAccDetails;
    private javax.swing.JPanel pnlBackGround;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlMenuBTN;
    private javax.swing.JLabel txtUser;
    // End of variables declaration//GEN-END:variables
}
