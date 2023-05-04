package GUI;

import BUS.CTHD_BUS;
import BUS.HoaDon_BUS;
import DTO.HoaDon;
import DTO.TaiKhoan;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HoaDon_GUI extends javax.swing.JPanel {

    DefaultTableModel dt;
    HoaDon_BUS busHD;
    CTHD_BUS busCTHD;
    JFrame f;
    TaiKhoan user;

    public HoaDon_GUI(TaiKhoan user) {
        initComponents();

        busHD = new HoaDon_BUS();
        busCTHD = new CTHD_BUS();
        this.user = user;
        
        //Chỉnh table
        setTable();
        setTableData(busHD.getView());

        //Chỉnh comboBox tìm kiếm
        cbxSearch.removeAllItems();
        String search[] = {"Mã HĐ", "Mã KH", "Mã NV", "Mã bàn"};
        for (String i : search) {
            cbxSearch.addItem(i);
        }
    }

    //Hàm cấu hình table
    private void setTable() {
        dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        Table.setModel(dt);

        String tbl[] = {"Mã hóa đơn", "Mã khách hàng", "Mã nhân viên", "Mã bàn", "Trạng thái", "Tổng tiền"};
        for (String i : tbl) {
            dt.addColumn(i);
        }
    }

    //Hàm lấy dữ liệu table
    private void setTableData(List<String> hds) {
        dt.setRowCount(0);
        for (String i : hds) {
            String split[] = i.split(",");
            String status = split[4].equals("0") ? "Chưa thanh toán" : "Đã thanh toán";
            dt.addRow(new Object[]{split[0], split[1], split[2], split[3], status, split[5]});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDetails = new javax.swing.JPanel();
        pnlPadUp = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pnlBTN = new javax.swing.JPanel();
        btnADD = new javax.swing.JButton();
        btnUPDATE = new javax.swing.JButton();
        btnDELETE = new javax.swing.JButton();
        btnREFRESH = new javax.swing.JButton();
        pnlPadDown = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pnlTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        pnlSearch = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnSEARCH = new javax.swing.JButton();
        cbxSearch = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        pnlDetails.setBackground(new java.awt.Color(255, 255, 255));
        pnlDetails.setLayout(new java.awt.BorderLayout());

        pnlPadUp.setBackground(new java.awt.Color(255, 255, 255));
        pnlPadUp.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 94, Short.MAX_VALUE)
        );

        pnlPadUp.add(jPanel1, "card2");

        pnlDetails.add(pnlPadUp, java.awt.BorderLayout.PAGE_START);

        pnlBTN.setBackground(new java.awt.Color(255, 255, 255));
        pnlBTN.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(159, 32, 66))); // NOI18N
        pnlBTN.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        btnADD.setBackground(new java.awt.Color(159, 32, 66));
        btnADD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnADD.setForeground(new java.awt.Color(255, 255, 255));
        btnADD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btnADD.setText("Thêm");
        btnADD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnADD.setIconTextGap(20);
        btnADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADDActionPerformed(evt);
            }
        });
        pnlBTN.add(btnADD);

        btnUPDATE.setBackground(new java.awt.Color(159, 32, 66));
        btnUPDATE.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUPDATE.setForeground(new java.awt.Color(255, 255, 255));
        btnUPDATE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/arrow_circle_up.png"))); // NOI18N
        btnUPDATE.setText("Sửa");
        btnUPDATE.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUPDATE.setIconTextGap(20);
        btnUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUPDATEActionPerformed(evt);
            }
        });
        pnlBTN.add(btnUPDATE);

        btnDELETE.setBackground(new java.awt.Color(159, 32, 66));
        btnDELETE.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDELETE.setForeground(new java.awt.Color(255, 255, 255));
        btnDELETE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancel.png"))); // NOI18N
        btnDELETE.setText("Xóa");
        btnDELETE.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDELETE.setIconTextGap(20);
        btnDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDELETEActionPerformed(evt);
            }
        });
        pnlBTN.add(btnDELETE);

        btnREFRESH.setBackground(new java.awt.Color(159, 32, 66));
        btnREFRESH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnREFRESH.setForeground(new java.awt.Color(255, 255, 255));
        btnREFRESH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        btnREFRESH.setText("Cập nhật");
        btnREFRESH.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnREFRESH.setIconTextGap(20);
        btnREFRESH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnREFRESHActionPerformed(evt);
            }
        });
        pnlBTN.add(btnREFRESH);

        pnlDetails.add(pnlBTN, java.awt.BorderLayout.CENTER);

        pnlPadDown.setBackground(new java.awt.Color(255, 255, 255));
        pnlPadDown.setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnlPadDown.add(jPanel2, "card2");

        pnlDetails.add(pnlPadDown, java.awt.BorderLayout.PAGE_END);

        pnlTable.setLayout(new java.awt.BorderLayout(0, 5));

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

        pnlTable.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnlSearch.setBackground(new java.awt.Color(255, 255, 255));
        pnlSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(159, 32, 66))); // NOI18N
        pnlSearch.setLayout(new java.awt.BorderLayout(2, 0));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnlSearch.add(txtSearch, java.awt.BorderLayout.CENTER);

        btnSEARCH.setBackground(new java.awt.Color(159, 32, 66));
        btnSEARCH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSEARCH.setForeground(new java.awt.Color(255, 255, 255));
        btnSEARCH.setText("Tìm");
        btnSEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSEARCHActionPerformed(evt);
            }
        });
        pnlSearch.add(btnSEARCH, java.awt.BorderLayout.EAST);

        cbxSearch.setBackground(new java.awt.Color(159, 32, 66));
        cbxSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbxSearch.setForeground(new java.awt.Color(255, 255, 255));
        cbxSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlSearch.add(cbxSearch, java.awt.BorderLayout.WEST);

        pnlTable.add(pnlSearch, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDetails, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addComponent(pnlTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADDActionPerformed
        f = CTHDManager.getFrame1();
        if (f.isShowing()) {
            f.toFront();
        } else {
            f.setVisible(true);;
        }
    }//GEN-LAST:event_btnADDActionPerformed

    private void btnUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPDATEActionPerformed
        try {
            int row = Table.getSelectedRow();
            if (row == -1) {
                throw new Exception("Vui lòng chọn hóa đơn cần sửa");
            }

            HoaDon hd = busHD.getHDbyID(String.valueOf(dt.getValueAt(row, 0)));
            if(user.getLoaiTK()==1 && hd.getTrangThai()==1)
                throw new Exception("Bạn không thể sửa hóa dơn đã thanh toán");
            CTHDManager.getFrame2(user, hd).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUPDATEActionPerformed

    private void btnDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELETEActionPerformed
        try {
            int row = Table.getSelectedRow();
            String id = String.valueOf(dt.getValueAt(row, 0));
            if (row == -1)
                throw new Exception("Vui lòng chọn hóa đơn cần xóa");
            
            if(user.getLoaiTK()==1 && busHD.getHDbyID(id).getTrangThai()==1)
                throw new Exception("Bạn không thể xóa hóa đơn đã thanh toán");

            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa?");

            if (confirm == JOptionPane.YES_OPTION) {
                busCTHD.deleteCTHD(id);
                busHD.deleteHD(id);
                setTableData(busHD.getView());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDELETEActionPerformed

    private void btnREFRESHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnREFRESHActionPerformed
        setTableData(busHD.getView());
    }//GEN-LAST:event_btnREFRESHActionPerformed

    private void btnSEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSEARCHActionPerformed
        try {
            if (txtSearch.getText().trim().isEmpty()) {
                throw new Exception("Dữ liệu nhập trống");
            }
            int t = cbxSearch.getSelectedIndex();
            String s = txtSearch.getText().trim();
            if (busHD.searchHD(s, t).isEmpty()) {
                throw new Exception("Không tìm thấy hóa đơn");
            }
            //setTableData(busHD.searchHD(s, t));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSEARCHActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton btnADD;
    private javax.swing.JButton btnDELETE;
    private javax.swing.JButton btnREFRESH;
    private javax.swing.JButton btnSEARCH;
    private javax.swing.JButton btnUPDATE;
    private javax.swing.JComboBox<String> cbxSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlBTN;
    private javax.swing.JPanel pnlDetails;
    private javax.swing.JPanel pnlPadDown;
    private javax.swing.JPanel pnlPadUp;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
