/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.KhachHang_BUS;
import DTO.KhachHang;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author panpa
 */
public class KhachHang_GUI extends javax.swing.JPanel {

    DefaultTableModel dt;
    KhachHang_BUS busKH;
    KhachHang kh;

    public KhachHang_GUI() {
        initComponents();
        busKH = new KhachHang_BUS();
        kh = new KhachHang();
        dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        Table.setModel(dt);

        cbxSearch.setEditable(false);
        cbxSearch.removeAllItems();

        String cbx[] = {"Mã khách hàng", "Họ tên", "Giới tính", "Số điện thoại", "Email", "Địa chỉ"};
        for (String s : cbx) {
            cbxSearch.addItem(s);
            dt.addColumn(s);
        };

        setTableData(busKH.getAllKH());
    }

    private void setTableData(List<KhachHang> khs) {
        dt.setRowCount(0);
        for (KhachHang kh : khs) {
            String gioiTinh = kh.getGioiTinh() == 0 ? "Nữ" : "Nam";
            dt.addRow(new Object[]{kh.getMaKH(), kh.getHoTen(), gioiTinh, kh.getSdt(), kh.getEmail(), kh.getDiaChi()});
        }
    }

    private void setTableData2(List<KhachHang> khs) {
        setTableData(khs);
        Reset();
    }

    private void check() throws Exception {
        String regID = "KH\\d{3}",
                regName = ".*\\d+.*",
                regPhone = "\\d{10}",
                regEmail = "^(\\w){3,}(@gmail\\.com)$";

        if (txtName.getText().trim().isEmpty()) {
            throw new Exception("Họ tên trống");
        } else if (txtPhone.getText().trim().isEmpty()) {
            throw new Exception("Số điện thoại trống");
        } else if (txtEmail.getText().trim().isEmpty()) {
            throw new Exception("Email trống");
        } else if (txtAddress.getText().trim().isEmpty()) {
            throw new Exception("Địa chỉ trống");
        } else if (!txtID.getText().trim().matches(regID)) {
            throw new Exception("Mã không đúng định đạng");
        } else if (txtName.getText().trim().matches(regName)) {
            throw new Exception("Họ tên không đúng");
        } else if (!txtPhone.getText().trim().matches(regPhone)) {
            throw new Exception("Số điện thoại không đúng");
        } else if (!txtEmail.getText().trim().matches(regEmail)) {
            throw new Exception("Email không đúng");
        }
    }

    private void Reset() {
        txtID.setText("");
        txtID.setEditable(true);
        txtName.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
        rdoM.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlDetails = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnlDetail = new javax.swing.JPanel();
        pnlTitle = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblSex = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        pnlTxt = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        rdoM = new javax.swing.JRadioButton();
        rdoF = new javax.swing.JRadioButton();
        txtPhone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        pnlFunction = new javax.swing.JPanel();
        pnlSearch = new javax.swing.JPanel();
        cbxSearch = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnSEARCH = new javax.swing.JButton();
        pnlBtn = new javax.swing.JPanel();
        btnADD = new javax.swing.JButton();
        btnUPDATE = new javax.swing.JButton();
        btnDELETE = new javax.swing.JButton();
        btnREFRESH = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        pnlDetails.setBackground(new java.awt.Color(255, 255, 255));
        pnlDetails.setLayout(new java.awt.BorderLayout());

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(159, 32, 66));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("KHÁCH HÀNG");
        pnlDetails.add(lblTitle, java.awt.BorderLayout.PAGE_START);

        pnlDetail.setBackground(new java.awt.Color(255, 255, 255));
        pnlDetail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(159, 32, 66))); // NOI18N

        pnlTitle.setBackground(new java.awt.Color(255, 255, 255));
        pnlTitle.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        lblID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblID.setForeground(new java.awt.Color(159, 32, 66));
        lblID.setText("Mã KH");
        pnlTitle.add(lblID);

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(159, 32, 66));
        lblName.setText("Họ Tên");
        pnlTitle.add(lblName);

        lblSex.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSex.setForeground(new java.awt.Color(159, 32, 66));
        lblSex.setText("Giới tính");
        pnlTitle.add(lblSex);

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPhone.setForeground(new java.awt.Color(159, 32, 66));
        lblPhone.setText("SĐT");
        pnlTitle.add(lblPhone);

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(159, 32, 66));
        lblEmail.setText("Email");
        pnlTitle.add(lblEmail);

        lblAddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(159, 32, 66));
        lblAddress.setText("Địa chỉ");
        pnlTitle.add(lblAddress);

        pnlTxt.setBackground(new java.awt.Color(255, 255, 255));
        pnlTxt.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        txtID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        pnlTxt.add(txtID);

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnlTxt.add(txtName);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout());

        rdoM.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoM);
        rdoM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoM.setForeground(new java.awt.Color(159, 32, 66));
        rdoM.setText("Nam");
        jPanel1.add(rdoM);

        rdoF.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoF);
        rdoF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoF.setForeground(new java.awt.Color(159, 32, 66));
        rdoF.setText("Nữ");
        jPanel1.add(rdoF);

        pnlTxt.add(jPanel1);

        txtPhone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnlTxt.add(txtPhone);

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnlTxt.add(txtEmail);

        txtAddress.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnlTxt.add(txtAddress);

        javax.swing.GroupLayout pnlDetailLayout = new javax.swing.GroupLayout(pnlDetail);
        pnlDetail.setLayout(pnlDetailLayout);
        pnlDetailLayout.setHorizontalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDetailLayout.setVerticalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailLayout.createSequentialGroup()
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlDetails.add(pnlDetail, java.awt.BorderLayout.CENTER);

        pnlFunction.setLayout(new java.awt.BorderLayout());

        pnlSearch.setBackground(new java.awt.Color(255, 255, 255));
        pnlSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(159, 32, 66))); // NOI18N
        pnlSearch.setLayout(new java.awt.BorderLayout());

        cbxSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlSearch.add(cbxSearch, java.awt.BorderLayout.WEST);

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnlSearch.add(txtSearch, java.awt.BorderLayout.CENTER);

        btnSEARCH.setBackground(new java.awt.Color(159, 32, 66));
        btnSEARCH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSEARCH.setForeground(new java.awt.Color(255, 255, 255));
        btnSEARCH.setText("Tìm");
        btnSEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSEARCHActionPerformed(evt);
            }
        });
        pnlSearch.add(btnSEARCH, java.awt.BorderLayout.EAST);

        pnlFunction.add(pnlSearch, java.awt.BorderLayout.PAGE_START);

        pnlBtn.setBackground(new java.awt.Color(255, 255, 255));
        pnlBtn.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(159, 32, 66))); // NOI18N
        pnlBtn.setMinimumSize(new java.awt.Dimension(175, 100));
        pnlBtn.setPreferredSize(new java.awt.Dimension(186, 100));
        pnlBtn.setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        btnADD.setBackground(new java.awt.Color(159, 32, 66));
        btnADD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnADD.setForeground(new java.awt.Color(255, 255, 255));
        btnADD.setText("Thêm");
        btnADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADDActionPerformed(evt);
            }
        });
        pnlBtn.add(btnADD);

        btnUPDATE.setBackground(new java.awt.Color(159, 32, 66));
        btnUPDATE.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUPDATE.setForeground(new java.awt.Color(255, 255, 255));
        btnUPDATE.setText("Sửa");
        btnUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUPDATEActionPerformed(evt);
            }
        });
        pnlBtn.add(btnUPDATE);

        btnDELETE.setBackground(new java.awt.Color(159, 32, 66));
        btnDELETE.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDELETE.setForeground(new java.awt.Color(255, 255, 255));
        btnDELETE.setText("Xóa");
        btnDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDELETEActionPerformed(evt);
            }
        });
        pnlBtn.add(btnDELETE);

        btnREFRESH.setBackground(new java.awt.Color(159, 32, 66));
        btnREFRESH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnREFRESH.setForeground(new java.awt.Color(255, 255, 255));
        btnREFRESH.setText("Refresh");
        btnREFRESH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnREFRESHActionPerformed(evt);
            }
        });
        pnlBtn.add(btnREFRESH);

        pnlFunction.add(pnlBtn, java.awt.BorderLayout.PAGE_END);

        pnlDetails.add(pnlFunction, java.awt.BorderLayout.PAGE_END);

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
        Table.getTableHeader().setReorderingAllowed(false);
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDetails, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDetails, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnSEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSEARCHActionPerformed
        if (txtSearch.getText().isEmpty())
            JOptionPane.showMessageDialog(this, "Không được bỏ trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
        else {
            String s = txtSearch.getText();
            int t = cbxSearch.getSelectedIndex();
            if (t == 2) {
                if (s.matches("Nam|nam|1")) {
                    setTableData2(busKH.searchKH("1", 2));
                } else if (s.matches("Nữ|nữ|nu|Nu|0")) {
                    setTableData2(busKH.searchKH("0", 2));
                } else {
                    JOptionPane.showMessageDialog(this, "Không tìm được khách hàng", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            } else if (busKH.searchKH(s, t).isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không tìm được khách hàng", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else {
                setTableData2(busKH.searchKH(s, t));
            }
        }
    }//GEN-LAST:event_btnSEARCHActionPerformed

    private void btnADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADDActionPerformed
        try {
            check();
            String id = txtID.getText().trim();

            if (busKH.getKHbyID(id) != null) {
                JOptionPane.showMessageDialog(this, "Mã khách hàng đã tồn tại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else {
                kh = new KhachHang();
                kh.setMaKH(txtID.getText());
                kh.setHoTen(txtName.getText());
                int gioiTinh = rdoM.isSelected() ? 1 : 0;
                kh.setGioiTinh(gioiTinh);
                kh.setSdt(txtPhone.getText().trim());
                kh.setEmail(txtEmail.getText().trim());
                kh.setDiaChi(txtAddress.getText().trim());

                busKH.addKH(kh);
                JOptionPane.showMessageDialog(this, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                setTableData2(busKH.getAllKH());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnADDActionPerformed

    private void btnUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPDATEActionPerformed
        int row = Table.getSelectedRow();
        if (row == -1)
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng", "Thông báo", JOptionPane.ERROR_MESSAGE);
        else {
            try {
                check();

                kh = new KhachHang();
                kh.setMaKH(String.valueOf(Table.getValueAt(row, 0)));
                kh.setHoTen(txtName.getText());
                int gioiTinh = rdoM.isSelected() ? 1 : 0;
                kh.setGioiTinh(gioiTinh);
                kh.setSdt(txtPhone.getText().trim());
                kh.setEmail(txtEmail.getText().trim());
                kh.setDiaChi(txtAddress.getText().trim());

                //Thực hiện truy vấn database
                busKH.updateKH(kh);

                //Xuất thông báo
                JOptionPane.showMessageDialog(this, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

                //Cập nhật bảng
                setTableData2(busKH.getAllKH());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnUPDATEActionPerformed

    private void btnDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELETEActionPerformed
        try {
            int row = Table.getSelectedRow();
            if (row == -1) {
                throw new Exception("Vui lòng chọn khách hàng cần xóa");
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa không?");

            if (confirm == JOptionPane.YES_OPTION) {
                String id = String.valueOf(Table.getValueAt(row, 0));
                if (busKH.getHD(id)) {
                    throw new Exception("Không thể xóa");
                }
                busKH.deleteKH(id);
                JOptionPane.showMessageDialog(this, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                setTableData2(busKH.getAllKH());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDELETEActionPerformed

    private void btnREFRESHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnREFRESHActionPerformed
        setTableData2(busKH.getAllKH());
    }//GEN-LAST:event_btnREFRESHActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        int row = Table.getSelectedRow();

        if (row != -1) {
            txtID.setText(String.valueOf(Table.getValueAt(row, 0)));
            txtName.setText(String.valueOf(Table.getValueAt(row, 1)));
            if (String.valueOf(Table.getValueAt(row, 2)).equals("Nam")) {
                rdoM.setSelected(true);
            } else {
                rdoF.setSelected(true);
            }
            txtID.setEditable(false);
            txtPhone.setText(String.valueOf(Table.getValueAt(row, 3)));
            txtEmail.setText(String.valueOf(Table.getValueAt(row, 4)));
            txtAddress.setText(String.valueOf(Table.getValueAt(row, 5)));
        }
    }//GEN-LAST:event_TableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton btnADD;
    private javax.swing.JButton btnDELETE;
    private javax.swing.JButton btnREFRESH;
    private javax.swing.JButton btnSEARCH;
    private javax.swing.JButton btnUPDATE;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBtn;
    private javax.swing.JPanel pnlDetail;
    private javax.swing.JPanel pnlDetails;
    private javax.swing.JPanel pnlFunction;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JPanel pnlTxt;
    private javax.swing.JRadioButton rdoF;
    private javax.swing.JRadioButton rdoM;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
