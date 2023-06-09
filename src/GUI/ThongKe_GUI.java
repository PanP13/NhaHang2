package GUI;

import BUS.ThongKe_BUS;
import javax.swing.table.DefaultTableModel;

public class ThongKe_GUI extends javax.swing.JPanel {

    ThongKe_BUS busTKE;
    DefaultTableModel dt;

    public ThongKe_GUI() {
        initComponents();
        busTKE = new ThongKe_BUS();

        lblKH.setText("Tổng KH: " + busTKE.getTongKH());
        lblNV.setText("Tổng NV: " + busTKE.getTongNV());
        lblBan.setText("Tổng bàn: " + busTKE.getTongBan());
        lblSP.setText("Tổng SP: " + busTKE.getTongSP());
        lblHD.setText("Tổng HD: " + busTKE.getTongHD());
        setTable();
    }

    //Hàm chỉnh bảng
    private void setTable() {
        dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Table.setModel(dt);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTitle = new javax.swing.JPanel();
        pnlKH = new javax.swing.JPanel();
        iconKH = new javax.swing.JLabel();
        lblKH = new javax.swing.JLabel();
        pnlNV = new javax.swing.JPanel();
        iconNV = new javax.swing.JLabel();
        lblNV = new javax.swing.JLabel();
        pnlBan = new javax.swing.JPanel();
        iconBan = new javax.swing.JLabel();
        lblBan = new javax.swing.JLabel();
        pnlSP = new javax.swing.JPanel();
        iconSP = new javax.swing.JLabel();
        lblSP = new javax.swing.JLabel();
        pnlHD = new javax.swing.JPanel();
        iconHD = new javax.swing.JLabel();
        lblHD = new javax.swing.JLabel();
        pnlShow = new javax.swing.JPanel();
        pnlTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        pnlSide = new javax.swing.JPanel();
        pnlBTN = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout(0, 5));

        pnlTitle.setBackground(new java.awt.Color(255, 255, 255));
        pnlTitle.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        pnlKH.setBackground(new java.awt.Color(255, 199, 89));
        pnlKH.setLayout(new java.awt.BorderLayout(0, 4));

        iconKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        iconKH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/person.png"))); // NOI18N
        pnlKH.add(iconKH, java.awt.BorderLayout.PAGE_START);

        lblKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblKH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlKH.add(lblKH, java.awt.BorderLayout.CENTER);

        pnlTitle.add(pnlKH);

        pnlNV.setBackground(new java.awt.Color(231, 111, 81));
        pnlNV.setLayout(new java.awt.BorderLayout());

        iconNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        iconNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/staff.png"))); // NOI18N
        pnlNV.add(iconNV, java.awt.BorderLayout.PAGE_START);

        lblNV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlNV.add(lblNV, java.awt.BorderLayout.CENTER);

        pnlTitle.add(pnlNV);

        pnlBan.setBackground(new java.awt.Color(191, 209, 229));
        pnlBan.setLayout(new java.awt.BorderLayout());

        iconBan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        iconBan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/table.png"))); // NOI18N
        pnlBan.add(iconBan, java.awt.BorderLayout.PAGE_START);

        lblBan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblBan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlBan.add(lblBan, java.awt.BorderLayout.CENTER);

        pnlTitle.add(pnlBan);

        pnlSP.setBackground(new java.awt.Color(218, 255, 239));
        pnlSP.setLayout(new java.awt.BorderLayout());

        iconSP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        iconSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/product.png"))); // NOI18N
        pnlSP.add(iconSP, java.awt.BorderLayout.PAGE_START);

        lblSP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlSP.add(lblSP, java.awt.BorderLayout.CENTER);

        pnlTitle.add(pnlSP);

        pnlHD.setBackground(new java.awt.Color(100, 182, 172));
        pnlHD.setLayout(new java.awt.BorderLayout());

        iconHD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        iconHD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/receipt.png"))); // NOI18N
        pnlHD.add(iconHD, java.awt.BorderLayout.PAGE_START);

        lblHD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlHD.add(lblHD, java.awt.BorderLayout.CENTER);

        pnlTitle.add(pnlHD);

        add(pnlTitle, java.awt.BorderLayout.PAGE_START);

        pnlShow.setBackground(new java.awt.Color(255, 255, 255));

        pnlTable.setBackground(new java.awt.Color(255, 255, 255));
        pnlTable.setLayout(new java.awt.CardLayout());

        Table.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table.setRowHeight(30);
        Table.setSelectionBackground(new java.awt.Color(159, 32, 66));
        Table.setSelectionForeground(new java.awt.Color(255, 255, 255));
        Table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Table);

        pnlTable.add(jScrollPane1, "card2");

        pnlSide.setBackground(new java.awt.Color(159, 32, 66));
        pnlSide.setLayout(new java.awt.BorderLayout());

        pnlBTN.setBackground(new java.awt.Color(159, 32, 66));
        pnlBTN.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlBTN.setForeground(new java.awt.Color(255, 255, 255));
        pnlBTN.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(159, 32, 66));
        jButton1.setText("Doanh thu KH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlBTN.add(jButton1);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(159, 32, 66));
        jButton2.setText("Doanh thu SP");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnlBTN.add(jButton2);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(159, 32, 66));
        jButton3.setText("Tổng doanh thu");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        pnlBTN.add(jButton3);

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(159, 32, 66));
        jButton4.setText("Nút");
        pnlBTN.add(jButton4);

        pnlSide.add(pnlBTN, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout pnlShowLayout = new javax.swing.GroupLayout(pnlShow);
        pnlShow.setLayout(pnlShowLayout);
        pnlShowLayout.setHorizontalGroup(
            pnlShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlShowLayout.createSequentialGroup()
                .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlShowLayout.setVerticalGroup(
            pnlShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
            .addComponent(pnlSide, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(pnlShow, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dt.setColumnCount(0);
        dt.setRowCount(0);

        dt.addColumn("Mã khách hàng");
        dt.addColumn("Tổng số hóa đơn");
        dt.addColumn("Tổng giá trị hóa đơn");

        for (String i : busTKE.getTKHDbyKH()) {
            String data[] = i.split(",");
            dt.addRow(data);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dt.setColumnCount(0);
        dt.setRowCount(0);

        String header[] = {"Mã sản phẩm", "Đơn giá", "Số sản phẩm đã bán", "Doanh thu"};
        for (String i : header) {
            dt.addColumn(i);
        }

        for (String i : busTKE.getTKHDbySP()) {
            String data[] = i.split(",");
            dt.addRow(data);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dt.setColumnCount(0);
        dt.setRowCount(0);
        dt.addColumn("Tổng doanh thu");
        dt.addRow(new Object[]{busTKE.getTong()});
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JLabel iconBan;
    private javax.swing.JLabel iconHD;
    private javax.swing.JLabel iconKH;
    private javax.swing.JLabel iconNV;
    private javax.swing.JLabel iconSP;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBan;
    private javax.swing.JLabel lblHD;
    private javax.swing.JLabel lblKH;
    private javax.swing.JLabel lblNV;
    private javax.swing.JLabel lblSP;
    private javax.swing.JPanel pnlBTN;
    private javax.swing.JPanel pnlBan;
    private javax.swing.JPanel pnlHD;
    private javax.swing.JPanel pnlKH;
    private javax.swing.JPanel pnlNV;
    private javax.swing.JPanel pnlSP;
    private javax.swing.JPanel pnlShow;
    private javax.swing.JPanel pnlSide;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JPanel pnlTitle;
    // End of variables declaration//GEN-END:variables
}
