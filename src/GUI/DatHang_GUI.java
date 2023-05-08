package GUI;

import BUS.*;
import DTO.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DatHang_GUI extends javax.swing.JFrame {

    DefaultTableModel dProduct, dOrder;
    HoaDon_BUS busHD;
    CTHD_BUS busCTHD;
    NhanVien_BUS busNV;
    KhachHang_BUS busKH;
    Ban_BUS busBan;
    SanPham_BUS busSP;
    LoaiSP_BUS busLSP;
    TaiKhoan user;
    HoaDon hd;

    public DatHang_GUI() {
        initComponents();
        setPanel();
    }

    public DatHang_GUI(TaiKhoan user, HoaDon hd) {
        initComponents();
        setPanel();
        this.user = user;
        this.hd = hd;

        //Lấy dữ liệu bảng chi tiết
        setDataOrder(busCTHD.getCTHDbyID(hd.getMaHD()));
        setTotal();

        //Lấy thông tin hóa đơn
        txtHD.setText(hd.getMaHD());
        cbxKH.setSelectedItem(hd.getMaKH());
        
        cbxStatus.setSelectedIndex(hd.getTrangThai());
        dcTime.setDate(hd.getThoiGian());

        //Chỉnh thông tin nhân viên
        if (user.getLoaiTK() == 1) {
            cbxNV.setSelectedItem(user.getMaTK());
            cbxNV.setEnabled(false);
        }
        
        //Chỉnh thông tin bàn
        cbxBan.addItem(hd.getMaBan());
        cbxBan.setSelectedItem(hd.getMaBan());
        cbxBan.setEnabled(false);

        //Cấu hỉnh
        txtHD.setEditable(false);
    }

    //Hàm khởi tạo
    private void setPanel() {
        //Gọi hàm khởi tạo
        busHD = new HoaDon_BUS();
        busCTHD = new CTHD_BUS();
        busNV = new NhanVien_BUS();
        busKH = new KhachHang_BUS();
        busBan = new Ban_BUS();
        busSP = new SanPham_BUS();
        busLSP = new LoaiSP_BUS();

        //Cấu hình table
        setDProduct();
        setDOrder();

        //Lấy dữ liệu table
        setDataProduct(busSP.getSP());

        //Cấu hình các comboBox
        setCBX();
        dcTime.setDate(new Date());
        dcTime.setEnabled(false);
    }

    //Hàm cấu hình table
    private void setDProduct() {
        dProduct = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblProduct.setModel(dProduct);
        dProduct.addColumn("Mã SP");
        dProduct.addColumn("Tên SP");
    }

    private void setDOrder() {
        dOrder = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblOrder.setModel(dOrder);
        String order[] = {"Mã SP", "Tên SP", "Đơn giá", "Số lượng", "Thành tiền"};
        for (String i : order) {
            dOrder.addColumn(i);
        }
    }

    //Hàm lấy dữ liệu cho table
    private void setDataProduct(List<String> sps) {
        dProduct.setRowCount(0);
        for (String i : sps) {
            String data[] = i.split(",");
            dProduct.addRow(new Object[]{data[0], data[1]});
        }
    }

    private void setDataOrder(List<CTHD> cts) {
        dOrder.setRowCount(0);
        for (CTHD i : cts) {
            SanPham sp = busSP.getSPbyID(i.getMaSP());
            int money = sp.getDonGia() * i.getSoLuong();
            dOrder.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(), sp.getDonGia(), i.getSoLuong(), money});
        }
    }

    //Hàm cấu hình comboBox
    private void setCBX() {
        //comboBox phân loại
        cbxSort.removeAllItems();
        cbxSort.addItem("All");
        for (LoaiSP i : busLSP.getAllLSP()) {
            cbxSort.addItem(i.getTenLSP());
        }

        //comboBox khách hàng
        cbxKH.removeAllItems();
        for (KhachHang i : busKH.getAllKH()) {
            cbxKH.addItem(i.getMaKH());
        }

        //comboBox nhân viên
        cbxNV.removeAllItems();
        for (NhanVien i : busNV.getAllNV()) {
            cbxNV.addItem(i.getMaNV());
        }

        //comboBox bàn
        cbxBan.removeAllItems();
        for (Ban i : busBan.getAllBan()) {
            if (i.getTrangThai() == 0) {
                cbxBan.addItem(i.getMaBan());
            }
        }

        //comboBox trạng thái
        cbxStatus.removeAllItems();
        cbxStatus.addItem("Chưa thanh toán");
        cbxStatus.addItem("Đã thanh toán");
    }

    //Hàm chỉnh textfield
    private void setChange(boolean b) {
        txtSP.setEditable(b);
        txtName.setEditable(b);
        txtPrice.setEditable(b);
    }

    //Hàm reset
    private void Reset() {
        txtSP.setText("");
        txtName.setText("");
        txtPrice.setText("");
        txtQuantity.setText("");
        setChange(true);

        tblProduct.clearSelection();
        tblOrder.clearSelection();
    }

    //Hàm kiểm tra và ném lỗi
    private void checkOrder() throws Exception {
        if (txtQuantity.getText().trim().isEmpty()) {
            throw new Exception("Số lượng trống");
        } else if (!txtQuantity.getText().trim().matches("\\d+")) {
            throw new Exception("Số lượng phải là số");
        }
    }

    private void checkReceipt() throws Exception {
        if (!txtHD.getText().trim().matches("^HD\\d{3}$")
                && !txtHD.getText().trim().isEmpty()) {
            throw new Exception("Mã hóa đơn không đúng");
        } else if (busHD.getHDbyID(txtHD.getText().trim()) != null
                && txtHD.isEditable()) {
            throw new Exception("Mã hóa đơn đã tồn tại");
        } else if (dOrder.getRowCount() == 0) {
            throw new Exception("Chi tiết hóa đơn trống");
        }
    }

    //Hàm lấy tổng
    private void setTotal() {
        lblTotal.setText("0");

        if (dOrder.getRowCount() != 0) {
            int total = 0;
            for (int i = 0; i < dOrder.getRowCount(); i++) {
                total += Integer.parseInt(String.valueOf(dOrder.getValueAt(i, 4)));
            }
            lblTotal.setText(String.valueOf(total));
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

        pnlBackGround = new javax.swing.JPanel();
        pnlProduct = new javax.swing.JPanel();
        pnlSort = new javax.swing.JPanel();
        pnlCBXSort = new javax.swing.JPanel();
        cbxSort = new javax.swing.JComboBox<>();
        pnlSearch = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnSEARCH = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        pnlDetails = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnlDetail = new javax.swing.JPanel();
        pnlReceipt = new javax.swing.JPanel();
        pnlReceiptTitle = new javax.swing.JPanel();
        lblHD = new javax.swing.JLabel();
        lblKH = new javax.swing.JLabel();
        lblNV = new javax.swing.JLabel();
        lblBan = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        pnlReceiptText = new javax.swing.JPanel();
        txtHD = new javax.swing.JTextField();
        cbxKH = new javax.swing.JComboBox<>();
        cbxNV = new javax.swing.JComboBox<>();
        cbxBan = new javax.swing.JComboBox<>();
        cbxStatus = new javax.swing.JComboBox<>();
        dcTime = new com.toedter.calendar.JDateChooser();
        pnlOrder = new javax.swing.JPanel();
        pnlOrderTitle = new javax.swing.JPanel();
        lblSP = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        pnlOrderText = new javax.swing.JPanel();
        txtSP = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        pnlBTN = new javax.swing.JPanel();
        btnADD = new javax.swing.JButton();
        btnUPDATE = new javax.swing.JButton();
        btnDELETE = new javax.swing.JButton();
        btnREFRESH = new javax.swing.JButton();
        btnCONFIRM = new javax.swing.JButton();
        btnCANCEL = new javax.swing.JButton();
        pnlOrderTBL = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        pnlTotal = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Đặt hàng");
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new java.awt.CardLayout());

        pnlBackGround.setBackground(new java.awt.Color(255, 255, 255));

        pnlProduct.setLayout(new java.awt.BorderLayout(0, 5));

        pnlSort.setBackground(new java.awt.Color(255, 255, 255));
        pnlSort.setLayout(new java.awt.GridLayout(0, 1, 0, 2));

        pnlCBXSort.setBackground(new java.awt.Color(255, 255, 255));
        pnlCBXSort.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phân loại", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(159, 32, 66))); // NOI18N
        pnlCBXSort.setLayout(new java.awt.GridLayout(1, 0));

        cbxSort.setBackground(new java.awt.Color(159, 32, 66));
        cbxSort.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbxSort.setForeground(new java.awt.Color(255, 255, 255));
        cbxSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSortActionPerformed(evt);
            }
        });
        pnlCBXSort.add(cbxSort);

        pnlSort.add(pnlCBXSort);

        pnlSearch.setBackground(new java.awt.Color(255, 255, 255));
        pnlSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(159, 32, 66))); // NOI18N
        pnlSearch.setLayout(new java.awt.BorderLayout(2, 0));
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

        pnlSort.add(pnlSearch);

        pnlProduct.add(pnlSort, java.awt.BorderLayout.PAGE_START);

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tblProduct.setRowHeight(30);
        tblProduct.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProduct.getTableHeader().setReorderingAllowed(false);
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduct);

        pnlProduct.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnlDetails.setBackground(new java.awt.Color(255, 255, 255));
        pnlDetails.setLayout(new java.awt.BorderLayout());

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(159, 32, 66));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("ĐẶT HÀNG");
        pnlDetails.add(lblTitle, java.awt.BorderLayout.PAGE_START);

        pnlDetail.setBackground(new java.awt.Color(255, 255, 255));

        pnlReceipt.setBackground(new java.awt.Color(255, 255, 255));
        pnlReceipt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(159, 32, 66))); // NOI18N

        pnlReceiptTitle.setBackground(new java.awt.Color(255, 255, 255));
        pnlReceiptTitle.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        lblHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHD.setForeground(new java.awt.Color(159, 32, 66));
        lblHD.setText("Mã HĐ");
        pnlReceiptTitle.add(lblHD);

        lblKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblKH.setForeground(new java.awt.Color(159, 32, 66));
        lblKH.setText("Mã KH");
        pnlReceiptTitle.add(lblKH);

        lblNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNV.setForeground(new java.awt.Color(159, 32, 66));
        lblNV.setText("Mã NV");
        pnlReceiptTitle.add(lblNV);

        lblBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBan.setForeground(new java.awt.Color(159, 32, 66));
        lblBan.setText("Mã bàn");
        pnlReceiptTitle.add(lblBan);

        lblStatus.setFont(lblHD.getFont());
        lblStatus.setForeground(new java.awt.Color(159, 32, 66));
        lblStatus.setText("Trạng thái");
        pnlReceiptTitle.add(lblStatus);

        lblTime.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTime.setForeground(new java.awt.Color(159, 32, 66));
        lblTime.setText("Thời gian");
        pnlReceiptTitle.add(lblTime);

        pnlReceiptText.setBackground(new java.awt.Color(255, 255, 255));
        pnlReceiptText.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        txtHD.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pnlReceiptText.add(txtHD);

        cbxKH.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbxKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlReceiptText.add(cbxKH);

        cbxNV.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbxNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlReceiptText.add(cbxNV);

        cbxBan.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbxBan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlReceiptText.add(cbxBan);

        cbxStatus.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlReceiptText.add(cbxStatus);

        dcTime.setBackground(new java.awt.Color(255, 255, 255));
        dcTime.setDateFormatString("dd-MM-yyyy");
        dcTime.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        pnlReceiptText.add(dcTime);

        javax.swing.GroupLayout pnlReceiptLayout = new javax.swing.GroupLayout(pnlReceipt);
        pnlReceipt.setLayout(pnlReceiptLayout);
        pnlReceiptLayout.setHorizontalGroup(
            pnlReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReceiptLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlReceiptTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlReceiptText, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlReceiptLayout.setVerticalGroup(
            pnlReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReceiptLayout.createSequentialGroup()
                .addGroup(pnlReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlReceiptTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlReceiptText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlOrder.setBackground(new java.awt.Color(255, 255, 255));
        pnlOrder.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(159, 32, 66))); // NOI18N

        pnlOrderTitle.setBackground(new java.awt.Color(255, 255, 255));
        pnlOrderTitle.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        lblSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSP.setForeground(new java.awt.Color(159, 32, 66));
        lblSP.setText("Mã SP");
        pnlOrderTitle.add(lblSP);

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(159, 32, 66));
        lblName.setText("Tên SP");
        pnlOrderTitle.add(lblName);

        lblPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPrice.setForeground(new java.awt.Color(159, 32, 66));
        lblPrice.setText("Đơn giá");
        pnlOrderTitle.add(lblPrice);

        lblQuantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblQuantity.setForeground(new java.awt.Color(159, 32, 66));
        lblQuantity.setText("Số lượng");
        pnlOrderTitle.add(lblQuantity);

        pnlOrderText.setBackground(new java.awt.Color(255, 255, 255));
        pnlOrderText.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        txtSP.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pnlOrderText.add(txtSP);

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pnlOrderText.add(txtName);

        txtPrice.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pnlOrderText.add(txtPrice);

        txtQuantity.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pnlOrderText.add(txtQuantity);

        javax.swing.GroupLayout pnlOrderLayout = new javax.swing.GroupLayout(pnlOrder);
        pnlOrder.setLayout(pnlOrderLayout);
        pnlOrderLayout.setHorizontalGroup(
            pnlOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlOrderTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlOrderText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlOrderLayout.setVerticalGroup(
            pnlOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrderLayout.createSequentialGroup()
                .addGroup(pnlOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlOrderTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlOrderText, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlDetailLayout = new javax.swing.GroupLayout(pnlDetail);
        pnlDetail.setLayout(pnlDetailLayout);
        pnlDetailLayout.setHorizontalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlReceipt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlDetailLayout.setVerticalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailLayout.createSequentialGroup()
                .addComponent(pnlReceipt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlDetails.add(pnlDetail, java.awt.BorderLayout.CENTER);

        pnlBTN.setBackground(new java.awt.Color(255, 255, 255));
        pnlBTN.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(159, 32, 66))); // NOI18N
        pnlBTN.setLayout(new java.awt.GridLayout(3, 2, 5, 5));

        btnADD.setBackground(new java.awt.Color(159, 32, 66));
        btnADD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnADD.setForeground(new java.awt.Color(255, 255, 255));
        btnADD.setText("Thêm");
        btnADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADDActionPerformed(evt);
            }
        });
        pnlBTN.add(btnADD);

        btnUPDATE.setBackground(new java.awt.Color(159, 32, 66));
        btnUPDATE.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUPDATE.setForeground(new java.awt.Color(255, 255, 255));
        btnUPDATE.setText("Sửa");
        btnUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUPDATEActionPerformed(evt);
            }
        });
        pnlBTN.add(btnUPDATE);

        btnDELETE.setBackground(new java.awt.Color(159, 32, 66));
        btnDELETE.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDELETE.setForeground(new java.awt.Color(255, 255, 255));
        btnDELETE.setText("Xóa");
        btnDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDELETEActionPerformed(evt);
            }
        });
        pnlBTN.add(btnDELETE);

        btnREFRESH.setBackground(new java.awt.Color(159, 32, 66));
        btnREFRESH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnREFRESH.setForeground(new java.awt.Color(255, 255, 255));
        btnREFRESH.setText("Đặt lại");
        btnREFRESH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnREFRESHActionPerformed(evt);
            }
        });
        pnlBTN.add(btnREFRESH);

        btnCONFIRM.setBackground(new java.awt.Color(159, 32, 66));
        btnCONFIRM.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCONFIRM.setForeground(new java.awt.Color(255, 255, 255));
        btnCONFIRM.setText("Xác nhận");
        btnCONFIRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCONFIRMActionPerformed(evt);
            }
        });
        pnlBTN.add(btnCONFIRM);

        btnCANCEL.setBackground(new java.awt.Color(159, 32, 66));
        btnCANCEL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCANCEL.setForeground(new java.awt.Color(255, 255, 255));
        btnCANCEL.setText("Hủy");
        btnCANCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCANCELActionPerformed(evt);
            }
        });
        pnlBTN.add(btnCANCEL);

        pnlDetails.add(pnlBTN, java.awt.BorderLayout.PAGE_END);

        pnlOrderTBL.setBackground(new java.awt.Color(255, 255, 255));
        pnlOrderTBL.setLayout(new java.awt.BorderLayout(0, 5));

        tblOrder.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
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
        tblOrder.setRowHeight(30);
        tblOrder.setShowGrid(false);
        tblOrder.getTableHeader().setReorderingAllowed(false);
        tblOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblOrder);

        pnlOrderTBL.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pnlTotal.setBackground(new java.awt.Color(255, 255, 255));
        pnlTotal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tổng tiền", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(159, 32, 66))); // NOI18N
        pnlTotal.setLayout(new java.awt.GridLayout(1, 0));

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(159, 32, 66));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setText("0");
        pnlTotal.add(lblTotal);

        pnlOrderTBL.add(pnlTotal, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout pnlBackGroundLayout = new javax.swing.GroupLayout(pnlBackGround);
        pnlBackGround.setLayout(pnlBackGroundLayout);
        pnlBackGroundLayout.setHorizontalGroup(
            pnlBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackGroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlOrderTBL, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlBackGroundLayout.setVerticalGroup(
            pnlBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackGroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlOrderTBL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pnlDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(pnlBackGround, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSortActionPerformed
        String sort = String.valueOf(cbxSort.getSelectedIndex());
        if (sort.equals("0")) {
            setDataProduct(busSP.getSP());
        } else {
            setDataProduct(busSP.searchSP(sort, 3));
        }
    }//GEN-LAST:event_cbxSortActionPerformed

    private void btnSEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSEARCHActionPerformed
        try {
            if (txtSearch.getText().trim().isEmpty()) {
                throw new Exception("Dữ liệu nhập trống");
            }

            String search = txtSearch.getText().trim();

            if (search.matches("^SP\\d{3}|\\d+")) {
                setDataProduct(busSP.searchSP(search, 0));
            } else {
                setDataProduct(busSP.searchSP(search, 1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSEARCHActionPerformed

    private void tblProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMouseClicked
        int row = tblProduct.getSelectedRow();
        tblOrder.clearSelection();
        if (row != -1) {
            SanPham sp = busSP.getSPbyID(String.valueOf(dProduct.getValueAt(row, 0)));
            txtSP.setText(sp.getMaSP());
            txtName.setText(sp.getTenSP());
            txtPrice.setText(String.valueOf(sp.getDonGia()));
            setChange(false);
            txtQuantity.setText("");
        }
    }//GEN-LAST:event_tblProductMouseClicked

    private void btnADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADDActionPerformed
        try {
            //Kiểm tra lỗi
            if (tblProduct.getSelectedRow() == -1) {
                throw new Exception("Vui lòng chọn sản phẩm");
            }
            checkOrder();

            //Khai báo biến
            String id = txtSP.getText(), name = txtName.getText();
            int price = Integer.parseInt(txtPrice.getText()),
                    number = Integer.parseInt(txtQuantity.getText()),
                    money = price * number;
            boolean flag = true;

            //Kiểm tra đã tồn tại sản phẩm
            if (dProduct.getRowCount() != 0) {
                for (int i = dOrder.getRowCount(); i > 0; i--) {
                    String idSP = String.valueOf(dOrder.getValueAt(i - 1, 0));
                    if (idSP.equals(txtSP.getText())) {
                        flag = false;
                        number += Integer.parseInt(String.valueOf(dOrder.getValueAt(i - 1, 3)));
                        money = price * number;
                        dOrder.setValueAt(number, i - 1, 3);
                        dOrder.setValueAt(money, i - 1, 4);
                        break;
                    }
                }

                if (flag) {
                    dOrder.addRow(new Object[]{id, name, price, number, money});
                }
            }

            setTotal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnADDActionPerformed

    private void btnUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPDATEActionPerformed
        try {
            int row = tblOrder.getSelectedRow();
            if (row == -1) {
                throw new Exception("Vui lòng chọn chi tiết cần sửa");
            }
            checkOrder();

            //Khai báo biến
            int price = Integer.parseInt(txtPrice.getText()),
                    number = Integer.parseInt(txtQuantity.getText()),
                    money = price * number;

            //Sửa bảng
            dOrder.setValueAt(number, row, 3);
            dOrder.setValueAt(money, row, 4);

            //Reset và tính tổng
            Reset();
            setTotal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUPDATEActionPerformed

    private void btnDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELETEActionPerformed
        try {
            int row = tblOrder.getSelectedRow();
            if (row == -1) {
                throw new Exception("Vui lòng chọn chi tiết cần xóa");
            }

            dOrder.removeRow(row);

            setTotal();
            Reset();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDELETEActionPerformed

    private void btnREFRESHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnREFRESHActionPerformed
        Reset();
    }//GEN-LAST:event_btnREFRESHActionPerformed

    private void tblOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderMouseClicked
        int row = tblOrder.getSelectedRow();
        tblProduct.clearSelection();
        if (row != -1) {
            txtSP.setText(String.valueOf(dOrder.getValueAt(row, 0)));
            txtName.setText(String.valueOf(dOrder.getValueAt(row, 1)));
            txtPrice.setText(String.valueOf(dOrder.getValueAt(row, 2)));
            txtQuantity.setText(String.valueOf(dOrder.getValueAt(row, 3)));

            setChange(false);
        }
    }//GEN-LAST:event_tblOrderMouseClicked

    private void btnCANCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCANCELActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCANCELActionPerformed

    private void btnCONFIRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCONFIRMActionPerformed
        try {
            checkReceipt();

            //Hàm tự động điền mã hóa đơn
            String maHD = txtHD.getText().trim();
            if (maHD.isEmpty()) {
                int id = busHD.getAllHD().size();
                do {
                    maHD = id < 10 ? "HD00" : id < 100 ? "HD0" : "HD";
                    maHD = maHD + String.valueOf(id);
                    id++;
                } while (busHD.getHDbyID(maHD) != null);
            }

            HoaDon temp = new HoaDon();
            temp.setMaHD(maHD);
            temp.setMaKH(String.valueOf(cbxKH.getSelectedItem()));
            temp.setMaNV(String.valueOf(cbxNV.getSelectedItem()));
            temp.setMaBan(String.valueOf(cbxBan.getSelectedItem()));
            temp.setTrangThai(cbxStatus.getSelectedIndex());
            temp.setThoiGian(dcTime.getDate());

            List<CTHD> cts = new ArrayList<>();
            for (int i = 0; i < dOrder.getRowCount(); i++) {
                CTHD ct = new CTHD();
                ct.setMaHD(temp.getMaHD());
                ct.setMaSP(String.valueOf(dOrder.getValueAt(i, 0)));
                ct.setSoLuong(Integer.parseInt(String.valueOf(dOrder.getValueAt(i, 3))));
                cts.add(ct);
            }
            //Thực hiện chức năng hóa đơn
            if (txtHD.isEditable()) {
                busHD.addHD(temp);
                busCTHD.addCTHD(cts);
                JOptionPane.showMessageDialog(this, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                busHD.updateHD(temp);
                busCTHD.updateCTHD(cts);
                JOptionPane.showMessageDialog(this, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            //Thực hiện ràng buộc bàn
            if (temp.getTrangThai()==0){
                Ban b = busBan.getBanbyID(temp.getMaBan());
                b.setTrangThai(1);
                busBan.updateBan(b);
            } else {
                Ban b = busBan.getBanbyID(temp.getMaBan());
                b.setTrangThai(0);
                busBan.updateBan(b);
            }
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCONFIRMActionPerformed

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
            java.util.logging.Logger.getLogger(DatHang_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatHang_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatHang_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatHang_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatHang_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnADD;
    private javax.swing.JButton btnCANCEL;
    private javax.swing.JButton btnCONFIRM;
    private javax.swing.JButton btnDELETE;
    private javax.swing.JButton btnREFRESH;
    private javax.swing.JButton btnSEARCH;
    private javax.swing.JButton btnUPDATE;
    private javax.swing.JComboBox<String> cbxBan;
    private javax.swing.JComboBox<String> cbxKH;
    private javax.swing.JComboBox<String> cbxNV;
    private javax.swing.JComboBox<String> cbxSort;
    private javax.swing.JComboBox<String> cbxStatus;
    private com.toedter.calendar.JDateChooser dcTime;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBan;
    private javax.swing.JLabel lblHD;
    private javax.swing.JLabel lblKH;
    private javax.swing.JLabel lblNV;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblSP;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlBTN;
    private javax.swing.JPanel pnlBackGround;
    private javax.swing.JPanel pnlCBXSort;
    private javax.swing.JPanel pnlDetail;
    private javax.swing.JPanel pnlDetails;
    private javax.swing.JPanel pnlOrder;
    private javax.swing.JPanel pnlOrderTBL;
    private javax.swing.JPanel pnlOrderText;
    private javax.swing.JPanel pnlOrderTitle;
    private javax.swing.JPanel pnlProduct;
    private javax.swing.JPanel pnlReceipt;
    private javax.swing.JPanel pnlReceiptText;
    private javax.swing.JPanel pnlReceiptTitle;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JPanel pnlSort;
    private javax.swing.JPanel pnlTotal;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTextField txtHD;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSP;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
