package GUI;

import DTO.*;
import BUS.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BanHang_GUI extends javax.swing.JPanel {

    DefaultTableModel d1, d2;
    HoaDon_BUS busHD;
    CTHD_BUS busCTHD;
    LoaiSP_BUS busLSP;
    SanPham_BUS busSP;

    public BanHang_GUI() {
        initComponents();

        //Khai báo các biến
        busHD = new HoaDon_BUS();
        busCTHD = new CTHD_BUS();
        busLSP = new LoaiSP_BUS();
        busSP = new SanPham_BUS();

        //Cấu hình Table d1;
        setD1();
        setDataD1(busSP.getAllSP());

        //Cấu hình Table d2;
        setD2();
        setDataD2();

        //Cấu hình ComboBox Phân loại
        setCBXSort();

        //Cấu hình Textfield
        setChangeEnable(false);
    }
    //Các hàm cấu hình Table
    private void setD1() {
        d1 = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        TableProduct.setModel(d1);
        d1.addColumn("Tên sản phẩm");
    }

    private void setD2() {
        d2 = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        TableDetails.setModel(d2);
        String[] dx = {"Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng", "Thành tiền"};
        for (String i : dx) {
            d2.addColumn(i);
        }
    }

    private void setDataD1(List<SanPham> sps) {
        d1.setRowCount(0);
        for (SanPham i : sps) {
            d1.addRow(new Object[]{i.getTenSP()});
        }
    }

    private void setDataD2() {

    }
    //Hàm Combobox
    private void setCBXSort() {
        cbxSort.removeAllItems();
        cbxSort.addItem("All");
        for (LoaiSP i : busLSP.getAllLSP()) {
            cbxSort.addItem(i.getTenLSP());
        }
    }
    
    //Hàm reset
    private void Reset() {
        txtID.setText("");
        txtName.setText("");
        txtPrice.setText("");
        txtQuantinty.setText("");
        txtMoney.setText("");

        //setChangeEnable(true);
    }
    
    //Hàm cấu hình textfield
    private void setChangeEnable(boolean i) {
        if (i) {
            txtID.setEditable(true);
            txtName.setEditable(true);
            txtPrice.setEditable(true);
            txtMoney.setEditable(true);
        } else {
            txtID.setEditable(false);
            txtName.setEditable(false);
            txtPrice.setEditable(false);
            txtMoney.setEditable(false);
        }
    }
    
    //Hàm tính tổng
    private void setTotal(){
        int i = d2.getRowCount();
        
        if (i==0)
            lblT.setText("0");
        else {
            int sum = 0;
            for(; i>0; i--){
                sum+=Integer.parseInt(String.valueOf(d2.getValueAt(i-1, 4)));
            }
            lblT.setText(String.valueOf(sum));
        }
            
    }

    //Các hàm kiểm tra dữ liệu nhập
    private boolean checkQuantity() {
        return txtQuantinty.getText().trim().matches("^[1-9]{1}\\d*");
    }

    private boolean checkEmpty() {
        return txtID.getText().trim().isEmpty()
                || txtName.getText().trim().isEmpty()
                || txtPrice.getText().trim().isEmpty()
                || txtQuantinty.getText().trim().isEmpty();
        //|| txtMoney.getText().trim().isEmpty();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlButton = new javax.swing.JPanel();
        btnADD = new javax.swing.JButton();
        btnUP = new javax.swing.JButton();
        btnDEL = new javax.swing.JButton();
        btnREF = new javax.swing.JButton();
        btnDONE = new javax.swing.JButton();
        pnlSort = new javax.swing.JPanel();
        cbxSort = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableProduct = new javax.swing.JTable();
        pnlDetail = new javax.swing.JPanel();
        pnlD = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        lblMoney = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtQuantinty = new javax.swing.JTextField();
        txtMoney = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pnlMoneyBtn = new javax.swing.JPanel();
        btnMONEY = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableDetails = new javax.swing.JTable();
        pnlTotal = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        lblT = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(255, 255, 255));

        pnlButton.setBackground(new java.awt.Color(0, 0, 0));
        pnlButton.setForeground(new java.awt.Color(255, 255, 255));
        pnlButton.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        btnADD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btnADD.setToolTipText("Thêm chi tiết hóa đơn");
        btnADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADDActionPerformed(evt);
            }
        });
        pnlButton.add(btnADD);

        btnUP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/arrow_circle_up.png"))); // NOI18N
        btnUP.setToolTipText("Sửa");
        btnUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUPActionPerformed(evt);
            }
        });
        pnlButton.add(btnUP);

        btnDEL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancel.png"))); // NOI18N
        btnDEL.setToolTipText("Xóa sản phẩm");
        btnDEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDELActionPerformed(evt);
            }
        });
        pnlButton.add(btnDEL);

        btnREF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        btnREF.setToolTipText("Đặt lại");
        btnREF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnREFActionPerformed(evt);
            }
        });
        pnlButton.add(btnREF);

        btnDONE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/receipt.png"))); // NOI18N
        btnDONE.setToolTipText("Xuất hóa đơn");
        pnlButton.add(btnDONE);

        pnlSort.setBackground(new java.awt.Color(0, 0, 153));
        pnlSort.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phân loại", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlSort.setMaximumSize(new java.awt.Dimension(32767, 200));
        pnlSort.setLayout(new java.awt.BorderLayout());

        cbxSort.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbxSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSortActionPerformed(evt);
            }
        });
        pnlSort.add(cbxSort, java.awt.BorderLayout.CENTER);

        TableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TableProduct.setRowHeight(30);
        TableProduct.getTableHeader().setReorderingAllowed(false);
        TableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableProduct);

        pnlDetail.setBackground(new java.awt.Color(0, 0, 153));

        pnlD.setBackground(new java.awt.Color(0, 0, 153));
        pnlD.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlD.setForeground(new java.awt.Color(255, 255, 255));

        lblID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setText("Mã SP");

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Tên SP");

        lblPrice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPrice.setForeground(new java.awt.Color(255, 255, 255));
        lblPrice.setText("Đơn giá");

        lblQuantity.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblQuantity.setForeground(new java.awt.Color(255, 255, 255));
        lblQuantity.setText("Số lượng");

        lblMoney.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMoney.setForeground(new java.awt.Color(255, 255, 255));
        lblMoney.setText("Thành tiền");

        txtID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtPrice.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtQuantinty.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtQuantinty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantintyActionPerformed(evt);
            }
        });
        txtQuantinty.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtQuantintyPropertyChange(evt);
            }
        });

        txtMoney.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnlDLayout = new javax.swing.GroupLayout(pnlD);
        pnlD.setLayout(pnlDLayout);
        pnlDLayout.setHorizontalGroup(
            pnlDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID)
                    .addComponent(txtName)
                    .addComponent(txtPrice)
                    .addComponent(txtQuantinty, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMoney))
                .addContainerGap())
        );
        pnlDLayout.setVerticalGroup(
            pnlDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDLayout.createSequentialGroup()
                .addGroup(pnlDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtName)
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPrice)
                    .addComponent(lblPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtQuantinty)
                    .addComponent(lblQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMoney)
                    .addComponent(lblMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel2.setBackground(new java.awt.Color(0, 0, 153));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CHI TIẾT HÓA ĐƠN");

        pnlMoneyBtn.setBackground(new java.awt.Color(0, 0, 153));
        pnlMoneyBtn.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tính tiền", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlMoneyBtn.setLayout(new java.awt.GridLayout(1, 0));

        btnMONEY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/money.png"))); // NOI18N
        btnMONEY.setToolTipText("Cập nhật tiền");
        btnMONEY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMONEYActionPerformed(evt);
            }
        });
        pnlMoneyBtn.add(btnMONEY);

        javax.swing.GroupLayout pnlDetailLayout = new javax.swing.GroupLayout(pnlDetail);
        pnlDetail.setLayout(pnlDetailLayout);
        pnlDetailLayout.setHorizontalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(pnlMoneyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlDetailLayout.setVerticalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMoneyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        TableDetails.setModel(new javax.swing.table.DefaultTableModel(
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
        TableDetails.setRowHeight(30);
        TableDetails.getTableHeader().setReorderingAllowed(false);
        TableDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableDetails);

        pnlTotal.setBackground(new java.awt.Color(0, 0, 153));
        pnlTotal.setLayout(new java.awt.GridLayout(1, 0));

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTotal.setText("Tổng cộng");
        pnlTotal.add(lblTotal);

        lblT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblT.setForeground(new java.awt.Color(255, 255, 255));
        lblT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblT.setText("0");
        pnlTotal.add(lblT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(pnlSort, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(pnlTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(pnlButton, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(pnlDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSortActionPerformed
        String sort = String.valueOf(cbxSort.getSelectedItem());
        d1.setRowCount(0);

        if (sort.equals("All")) {
            setDataD1(busSP.getAllSP());
        } else {
            for (LoaiSP j : busLSP.getAllLSP()) {
                if (j.getTenLSP().equals(sort)) {
                    sort = j.getMaLSP();
                    break;
                }
            }

            for (SanPham i : busSP.getAllSP()) {
                if (i.getMaLSP().equals(sort)) {
                    d1.addRow(new Object[]{i.getTenSP()});
                }
            }
        }
    }//GEN-LAST:event_cbxSortActionPerformed

    private void txtQuantintyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantintyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantintyActionPerformed

    private void TableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProductMouseClicked
        int row = TableProduct.getSelectedRow();
        String s = String.valueOf(d1.getValueAt(row, 0));

        for (SanPham i : busSP.getAllSP()) {
            if (i.getTenSP().equals(s)) {
                Reset();
                txtID.setText(i.getMaSP());
                txtName.setText(i.getTenSP());
                txtPrice.setText(String.valueOf(i.getDonGia()));
                break;
            }
        }
    }//GEN-LAST:event_TableProductMouseClicked

    private void txtQuantintyPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtQuantintyPropertyChange

    }//GEN-LAST:event_txtQuantintyPropertyChange

    private void btnMONEYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMONEYActionPerformed
        if (!checkQuantity())
            JOptionPane.showMessageDialog(this, "Số lượng phải là số", "Thông báo", JOptionPane.ERROR_MESSAGE);
        else {
            int money = Integer.parseInt(txtPrice.getText()) * Integer.parseInt(txtQuantinty.getText().trim());
            txtMoney.setText(String.valueOf(money));
        }
    }//GEN-LAST:event_btnMONEYActionPerformed

    private void btnADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADDActionPerformed
        if (checkEmpty()) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không được trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else if (!checkQuantity()) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            boolean flag = true;

            if (d2.getRowCount() != 0) {
                for (int i = d2.getRowCount(); i > 0; i--) {
                    String s = String.valueOf(d2.getValueAt(i - 1, 0));
                    if (s.equals(txtID.getText())) {
                        flag = false;

                        int temp1 = Integer.parseInt(String.valueOf(d2.getValueAt(i - 1, 3))) + Integer.parseInt(txtQuantinty.getText().trim());
                        int temp2 = temp1 * Integer.parseInt(txtPrice.getText());
                        d2.setValueAt(temp1, i - 1, 3);
                        d2.setValueAt(temp2, i - 1, 4);

                        break;
                    }
                }
            }
            if (flag) {
                int money = Integer.parseInt(txtQuantinty.getText().trim()) * Integer.parseInt(txtPrice.getText());
                d2.addRow(new Object[]{txtID.getText(), txtName.getText(), txtPrice.getText(), txtQuantinty.getText().trim(), money});
            }
            setTotal();
        }
    }//GEN-LAST:event_btnADDActionPerformed

    private void btnUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPActionPerformed
        if (!checkEmpty()) {
            if (!checkQuantity()) {
                JOptionPane.showMessageDialog(this, "Số lượng phải là số", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else if (d2.getRowCount() != 0) {
                for (int i = d2.getRowCount(); i > 0; i--) {
                    String s = String.valueOf(d2.getValueAt(i - 1, 0));

                    if (s.equals(txtID.getText())) {
                        int temp1 = Integer.parseInt(txtQuantinty.getText().trim());
                        int temp2 = temp1 * Integer.parseInt(txtPrice.getText());
                        d2.setValueAt(temp1, i - 1, 3);
                        d2.setValueAt(temp2, i - 1, 4);

                        break;
                    }
                }
            }
        } else
            JOptionPane.showMessageDialog(this, "Dữ liệu không được trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
        setTotal();
    }//GEN-LAST:event_btnUPActionPerformed

    private void TableDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableDetailsMouseClicked
        int row = TableDetails.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn chi tiết hóa đơn", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            Reset();

            txtID.setText(String.valueOf(d2.getValueAt(row, 0)));
            txtName.setText(String.valueOf(d2.getValueAt(row, 1)));
            txtPrice.setText(String.valueOf(d2.getValueAt(row, 2)));
            txtQuantinty.setText(String.valueOf(d2.getValueAt(row, 3)));
            txtMoney.setText(String.valueOf(d2.getValueAt(row, 4)));

        }
    }//GEN-LAST:event_TableDetailsMouseClicked

    private void btnREFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnREFActionPerformed
        Reset();
    }//GEN-LAST:event_btnREFActionPerformed

    private void btnDELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELActionPerformed
        if (!txtID.getText().trim().isEmpty()) {
            for (int i = d2.getRowCount(); i > 0; i--) {
                if (String.valueOf(d2.getValueAt(i - 1, 0)).equals(txtID.getText().trim())) {
                    d2.removeRow(i - 1);
                    Reset();
                    break;
                }
            }
            setTotal();
        }
    }//GEN-LAST:event_btnDELActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableDetails;
    private javax.swing.JTable TableProduct;
    private javax.swing.JButton btnADD;
    private javax.swing.JButton btnDEL;
    private javax.swing.JButton btnDONE;
    private javax.swing.JButton btnMONEY;
    private javax.swing.JButton btnREF;
    private javax.swing.JButton btnUP;
    private javax.swing.JComboBox<String> cbxSort;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblMoney;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblT;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlD;
    private javax.swing.JPanel pnlDetail;
    private javax.swing.JPanel pnlMoneyBtn;
    private javax.swing.JPanel pnlSort;
    private javax.swing.JPanel pnlTotal;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMoney;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantinty;
    // End of variables declaration//GEN-END:variables
}
