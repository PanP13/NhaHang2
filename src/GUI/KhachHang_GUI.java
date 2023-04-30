/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.KhachHang_BUS;
import DTO.KhachHang;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
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

    /**
     * Creates new form NewJPanel
     */
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

//        dt.addColumn(lblID.getText());
//        dt.addColumn(lblName.getText());
//        dt.addColumn(lblSex.getText());
//        dt.addColumn(lblPhone.getText());
//        dt.addColumn(lblEmail.getText());
//        dt.addColumn(lblAddress.getText());
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
        for (KhachHang kh : khs) {
            if (kh.getGioiTinh() == 0) {
                dt.addRow(new Object[]{kh.getMaKH(), kh.getHoTen(), "Nữ", kh.getSdt(), kh.getEmail(), kh.getDiaChi()});
            } else {
                dt.addRow(new Object[]{kh.getMaKH(), kh.getHoTen(), "Nam", kh.getSdt(), kh.getEmail(), kh.getDiaChi()});
            }
        }
    }

    private void setTableData2(List<KhachHang> khs) {
        dt.setRowCount(0);
        setTableData(khs);
        Reset();
    }

    private boolean checkEmpty() {
        return txtName.getText().trim().isEmpty()
                || txtPhone.getText().trim().isEmpty()
                || txtEmail.getText().trim().isEmpty()
                || txtAddress.getText().trim().isEmpty();
    }

    private boolean checkName() {
        return txtName.getText().trim().matches(getRegexName());
    }

    private boolean checkPhone() {
        return !txtPhone.getText().trim().matches(getRegexPhone());
    }

    private boolean checkEmail() {
        return !txtEmail.getText().trim().matches(getRegexEmail());
    }

    private String getRegexID() {
        return "KH\\d{3}";
    }

    private String getRegexName() {
        return ".*\\d+.*";
    }

    private String getRegexPhone() {
        return "\\d{10}";
    }

    private String getRegexEmail() {
        return "^(\\w){3,}(@gmail\\.com)$";
    }

    private void Reset() {
        txtID.setText("");
        txtID.setEnabled(true);
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

        btnGroup_Sex = new javax.swing.ButtonGroup();
        contentPanel = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnlDetail = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblSex = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        rdoM = new javax.swing.JRadioButton();
        rdoF = new javax.swing.JRadioButton();
        txtPhone = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        pnlSEARCH = new javax.swing.JPanel();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSEARCH = new javax.swing.JButton();
        cbxSearch = new javax.swing.JComboBox<>();
        lblSearchType = new javax.swing.JLabel();
        pnlBTN = new javax.swing.JPanel();
        btnADD = new javax.swing.JButton();
        btnUP = new javax.swing.JButton();
        btnDEL = new javax.swing.JButton();
        btnREF = new javax.swing.JButton();
        btnBACK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 51, 153));

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setMaximumSize(new java.awt.Dimension(400, 32767));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("KHACH HANG");

        lblID.setText("Mã khách hàng");

        lblName.setText("Họ tên");

        lblSex.setText("Giới tính");

        btnGroup_Sex.add(rdoM);
        rdoM.setSelected(true);
        rdoM.setText("Nam");

        btnGroup_Sex.add(rdoF);
        rdoF.setText("Nữ");

        lblEmail.setText("Email");

        lblAddress.setText("Địa chỉ");

        lblPhone.setText("SĐT");

        lblSearch.setText("Tìm kiếm");

        btnSEARCH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btnSEARCH.setToolTipText("Tìm kiếm");
        btnSEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSEARCHActionPerformed(evt);
            }
        });

        cbxSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblSearchType.setText("Loại");

        javax.swing.GroupLayout pnlSEARCHLayout = new javax.swing.GroupLayout(pnlSEARCH);
        pnlSEARCH.setLayout(pnlSEARCHLayout);
        pnlSEARCHLayout.setHorizontalGroup(
            pnlSEARCHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSEARCHLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlSEARCHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSearch)
                    .addComponent(lblSearchType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSEARCHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxSearch, 0, 218, Short.MAX_VALUE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSEARCH, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSEARCHLayout.setVerticalGroup(
            pnlSEARCHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSEARCHLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSEARCHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSEARCH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlSEARCHLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlSEARCHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlSEARCHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlDetailLayout = new javax.swing.GroupLayout(pnlDetail);
        pnlDetail.setLayout(pnlDetailLayout);
        pnlDetailLayout.setHorizontalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSex, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblID)
                    .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID)
                    .addComponent(txtName)
                    .addGroup(pnlDetailLayout.createSequentialGroup()
                        .addComponent(rdoM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(9, 9, 9))
                    .addComponent(txtPhone)
                    .addComponent(txtEmail)
                    .addComponent(txtAddress))
                .addContainerGap())
            .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlSEARCH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDetailLayout.setVerticalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSex)
                    .addComponent(rdoM)
                    .addComponent(rdoF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetailLayout.createSequentialGroup()
                    .addGap(0, 331, Short.MAX_VALUE)
                    .addComponent(pnlSEARCH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlBTN.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        btnADD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnADD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/person_add.png"))); // NOI18N
        btnADD.setToolTipText("Thêm khách hàng");
        btnADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADDActionPerformed(evt);
            }
        });
        pnlBTN.add(btnADD);

        btnUP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnUP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/arrow_circle_up.png"))); // NOI18N
        btnUP.setToolTipText("Sửa khách hàng");
        btnUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUPActionPerformed(evt);
            }
        });
        pnlBTN.add(btnUP);

        btnDEL.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDEL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/person_remove.png"))); // NOI18N
        btnDEL.setToolTipText("Xóa khách hàng");
        btnDEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDELActionPerformed(evt);
            }
        });
        pnlBTN.add(btnDEL);

        btnREF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnREF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        btnREF.setToolTipText("Đặt lại và cập nhật");
        btnREF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnREFActionPerformed(evt);
            }
        });
        pnlBTN.add(btnREF);

        btnBACK.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBACK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home.png"))); // NOI18N
        btnBACK.setText("Menu");
        btnBACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBACKActionPerformed(evt);
            }
        });
        pnlBTN.add(btnBACK);

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(pnlDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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
        Table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSEARCHActionPerformed
        if (txtSearch.getText().isEmpty())
            JOptionPane.showMessageDialog(this, "Không được bỏ trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
        else {
            String s = txtSearch.getText();
            int t = cbxSearch.getSelectedIndex();
            if (t == 2) {
                if (s.matches("Nam|nam")) {
                    setTableData2(busKH.searchKH("1", 2));
                } else if (s.matches("Nữ|nữ|nu|Nu")) {
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
        if (checkEmpty())
            JOptionPane.showMessageDialog(this, "Vui lòng nhập dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
        else if (!txtID.getText().matches(getRegexID()))
            JOptionPane.showMessageDialog(this, "Sai mã khách hàng", "Thông báo", JOptionPane.ERROR_MESSAGE);
        else if (checkName() || checkPhone() || checkEmail()) {
            if (checkName()) {
                JOptionPane.showMessageDialog(this, "Sai họ tên", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else if (checkPhone()) {
                JOptionPane.showMessageDialog(this, "Sai số điện thoại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else if (checkEmail()) {
                JOptionPane.showMessageDialog(this, "Sai Email", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            boolean flag = false;
            for (KhachHang i : busKH.getAllKH()) {
                if (txtID.getText().equals(i.getMaKH())) {
                    JOptionPane.showMessageDialog(this, "Ma khach hang da ton tai", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                kh.setMaKH(txtID.getText());
                kh.setHoTen(txtName.getText());
                if (rdoM.isSelected()) {
                    kh.setGioiTinh(1);
                } else {
                    kh.setGioiTinh(0);
                }

                busKH.addKH(kh);
                JOptionPane.showMessageDialog(this, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                setTableData2(busKH.getAllKH());
            }
        }
    }//GEN-LAST:event_btnADDActionPerformed

    private void btnUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPActionPerformed
        int row = Table.getSelectedRow();
        if (row == -1)
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng", "Thông báo", JOptionPane.ERROR_MESSAGE);
        else {
            if (checkEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else if (checkName() || checkPhone() || checkEmail()) {
                if (checkName()) {
                    JOptionPane.showMessageDialog(this, "Sai họ tên", "Thông báo", JOptionPane.ERROR_MESSAGE);
                } else if (checkPhone()) {
                    JOptionPane.showMessageDialog(this, "Sai số điện thoại", "Thông báo", JOptionPane.ERROR_MESSAGE);
                } else if (checkEmail()) {
                    JOptionPane.showMessageDialog(this, "Sai Email", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                kh = new KhachHang();
                kh.setMaKH(String.valueOf(Table.getValueAt(row, 0)));
                kh.setHoTen(txtName.getText());
                if (rdoM.isSelected()) {
                    kh.setGioiTinh(1);
                } else {
                    kh.setGioiTinh(0);
                }
                kh.setSdt(txtPhone.getText().trim());
                kh.setEmail(txtEmail.getText().trim());
                kh.setDiaChi(txtAddress.getText().trim());
                busKH.updateKH(kh);
                JOptionPane.showMessageDialog(this, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                setTableData2(busKH.getAllKH());
            }
        }
    }//GEN-LAST:event_btnUPActionPerformed

    private void btnDELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELActionPerformed
        int row = Table.getSelectedRow();
        if (row == -1)
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng", "Thông báo", JOptionPane.ERROR_MESSAGE);
        else {
            int confirm = JOptionPane.showConfirmDialog(this, "Ban co muon xoa khong?");

            if (confirm == JOptionPane.YES_OPTION) {
                String id = String.valueOf(Table.getValueAt(row, 0));
                busKH.deleteKH(id);
                JOptionPane.showMessageDialog(this, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                setTableData2(busKH.getAllKH());
            }
        }
    }//GEN-LAST:event_btnDELActionPerformed

    private void btnREFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnREFActionPerformed
        setTableData2(busKH.getAllKH());
    }//GEN-LAST:event_btnREFActionPerformed

    private void btnBACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBACKActionPerformed
        //new MainFrame().setVisible(true);
        //this.dispose();
    }//GEN-LAST:event_btnBACKActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        int row = Table.getSelectedRow();

        if (row != -1) {
            txtID.setText(String.valueOf(Table.getValueAt(row, 0)));
            txtName.setText(String.valueOf(Table.getValueAt(row, 1)));
            if (String.valueOf(Table.getValueAt(row, 2)) == "Nam") {
                rdoM.setSelected(true);
            } else {
                rdoF.setSelected(true);
            }
            txtPhone.setText(String.valueOf(dt.getValueAt(row, 3)));
            txtEmail.setText(String.valueOf(dt.getValueAt(row, 4)));
            txtAddress.setText(String.valueOf(dt.getValueAt(row, 5)));
            txtID.setEnabled(false);
        }
    }//GEN-LAST:event_TableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton btnADD;
    private javax.swing.JButton btnBACK;
    private javax.swing.JButton btnDEL;
    private javax.swing.ButtonGroup btnGroup_Sex;
    private javax.swing.JButton btnREF;
    private javax.swing.JButton btnSEARCH;
    private javax.swing.JButton btnUP;
    private javax.swing.JComboBox<String> cbxSearch;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSearchType;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBTN;
    private javax.swing.JPanel pnlDetail;
    private javax.swing.JPanel pnlSEARCH;
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
