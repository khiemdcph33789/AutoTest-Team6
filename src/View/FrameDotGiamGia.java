package View;

import Model.DanhSachGiamGiaInfo;
import Model.DanhSachSanPhaminfo;
import Model.LichSuGiamGia;
import Repository.DoiGiamGiaRepository;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FrameDotGiamGia extends javax.swing.JFrame {

    private DefaultTableModel dtm1 = new DefaultTableModel();
    private DefaultTableModel dtm2 = new DefaultTableModel();
    private ArrayList<DanhSachSanPhaminfo> listSP = new ArrayList<>();
    private ArrayList<LichSuGiamGia> ListLS = new ArrayList<>();
    private ArrayList<DanhSachGiamGiaInfo> listGG = new ArrayList<>();
    private List<DanhSachSanPhaminfo> selectedProductsList = new ArrayList<>();
    private List<ProductWithQuantity> selectedProductsListt = new ArrayList<>();

    private DoiGiamGiaRepository listSV = new DoiGiamGiaRepository();

    public FrameDotGiamGia() {
        initComponents();
        dtm2 = (DefaultTableModel) tblDSGG.getModel();
        LoadTable2();
    }

    public void LoadTable2() {
        dtm2.setRowCount(0);
        listGG = listSV.getAllGiamGia();
        for (DanhSachGiamGiaInfo ds : listGG) {
            Object[] rowdata = {
                ds.getMaGiamGia(),
                ds.getTenDotGiamGia(),
                ds.getNgayBatDau(),
                ds.getNgayKetThuc(),
                ds.getPhanTramGiamGia(),
                ds.isTrangThai() ? "Đang hoạt động" : "Đã kết thúc"
            };
            dtm2.addRow(rowdata);
        }
    }

    public void loadTable1() {
        dtm1.setRowCount(0);
        listSP = listSV.getAllSanPham();
        for (DanhSachSanPhaminfo ds : listSP) {
            Object[] rowdata = {
                ds.getSanPhamId(),
                ds.getSanPhamName(),
                ds.getFabricType(),
                ds.getDesigns(),
                ds.getSize(),
                ds.getColor(),
                ds.getMoney(),
                ds.getQuantity()
            };
            dtm1.addRow(rowdata);
        }
    }

    private class ProductWithQuantity {

        private DanhSachSanPhaminfo product;
        private int quantity;

        public ProductWithQuantity(DanhSachSanPhaminfo product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public DanhSachSanPhaminfo getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }
    }

    private boolean containsProductID(int productID, DefaultTableModel model) {
        // Check if the product ID already exists in the table
        for (int row = 0; row < model.getRowCount(); row++) {
            if ((int) model.getValueAt(row, 0) == productID) {
                return true; // Product ID already exists in the table
            }
        }
        return false; // Product ID does not exist in the table
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        DoiGGPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSGG = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtTenDotGiamGia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMucGiamGia = new javax.swing.JTextField();
        btnLuu = new javax.swing.JButton();
        btnTaoMoi = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rdoDangHoatDong = new javax.swing.JRadioButton();
        rdoDaKetThuc = new javax.swing.JRadioButton();
        jdcNgayBatDau = new com.toedter.calendar.JDateChooser();
        jdcNgayKetThuc = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đợt giảm giá");
        setBackground(new java.awt.Color(204, 255, 255));
        setIconImages(null);

        DoiGGPanel.setPreferredSize(new java.awt.Dimension(1300, 700));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblDSGG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đợt giảm giá", "Tên đợt giảm giá", "Ngày bắt đầu", "Ngày kết thúc", "Mức giảm giá", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSGG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSGGMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDSGG);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Danh sách giảm giá");

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setText("Tên đợt giảm giá:");

        jLabel7.setText("Mức giảm giá (%):");

        txtMucGiamGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMucGiamGiaActionPerformed(evt);
            }
        });

        btnLuu.setBackground(new java.awt.Color(255, 204, 204));
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Add.png"))); // NOI18N
        btnLuu.setText("Thêm đợt");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnTaoMoi.setBackground(new java.awt.Color(255, 204, 204));
        btnTaoMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Refresh.png"))); // NOI18N
        btnTaoMoi.setText("Làm mới");
        btnTaoMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMoiActionPerformed(evt);
            }
        });

        btnCapNhat.setBackground(new java.awt.Color(255, 204, 204));
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/updated (1).png"))); // NOI18N
        btnCapNhat.setText("Sửa đợt");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 204, 204));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delete.png"))); // NOI18N
        btnXoa.setText("Xóa đợt");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel8.setText("Ngày bắt đầu:");

        jLabel9.setText("Ngày kết thúc:");

        jLabel10.setText("Trạng thái:");

        buttonGroup1.add(rdoDangHoatDong);
        rdoDangHoatDong.setText("Đang hoạt động");

        buttonGroup1.add(rdoDaKetThuc);
        rdoDaKetThuc.setText("Đã kết thúc");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenDotGiamGia)
                    .addComponent(txtMucGiamGia)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7)
                            .addComponent(jdcNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(rdoDangHoatDong)
                                .addGap(18, 18, 18)
                                .addComponent(rdoDaKetThuc))
                            .addComponent(jdcNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTaoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenDotGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoDangHoatDong)
                    .addComponent(rdoDaKetThuc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(271, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Tạo đợt giảm giá");

        javax.swing.GroupLayout DoiGGPanelLayout = new javax.swing.GroupLayout(DoiGGPanel);
        DoiGGPanel.setLayout(DoiGGPanelLayout);
        DoiGGPanelLayout.setHorizontalGroup(
            DoiGGPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoiGGPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DoiGGPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1016, Short.MAX_VALUE)
                    .addGroup(DoiGGPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DoiGGPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(0, 0, 0))
        );
        DoiGGPanelLayout.setVerticalGroup(
            DoiGGPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DoiGGPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(DoiGGPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DoiGGPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DoiGGPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(DoiGGPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMoiActionPerformed
        txtTenDotGiamGia.setText("");
        jdcNgayBatDau.setDate(null);
        jdcNgayKetThuc.setDate(null);
        txtMucGiamGia.setText("");
        buttonGroup1.clearSelection();
    }//GEN-LAST:event_btnTaoMoiActionPerformed

    private void tblDSGGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSGGMouseClicked
        int selectedRow = tblDSGG.getSelectedRow();

        // Kiểm tra nếu có dòng được chọn
        if (selectedRow >= 0) {
            // Lấy thông tin từ dòng được chọn
            DanhSachGiamGiaInfo selectedDiscount = listGG.get(selectedRow);

            // Hiển thị thông tin lên các trường dữ liệu khác
            txtTenDotGiamGia.setText(selectedDiscount.getTenDotGiamGia());
            txtMucGiamGia.setText(String.valueOf(selectedDiscount.getPhanTramGiamGia()));

            // Xử lý ngày bắt đầu và ngày kết thúc
            Date startDate = selectedDiscount.getNgayBatDau();
            Date endDate = selectedDiscount.getNgayKetThuc();
            jdcNgayBatDau.setDate(startDate);
            jdcNgayKetThuc.setDate(endDate);

            // Xử lý trạng thái
            if (selectedDiscount.isTrangThai()) {
                rdoDangHoatDong.setSelected(true);
            } else {
                rdoDaKetThuc.setSelected(true);
            }
        }
    }//GEN-LAST:event_tblDSGGMouseClicked

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        String tenDotGiamGia = txtTenDotGiamGia.getText().trim();
        String mucGiamGiaStr = txtMucGiamGia.getText().trim();
        Date ngayBatDau = jdcNgayBatDau.getDate();
        Date ngayKetThuc = jdcNgayKetThuc.getDate();

        // Xác thực rằng các trường bắt buộc không rỗng
        if (tenDotGiamGia.isEmpty() || mucGiamGiaStr.isEmpty() || ngayBatDau == null || ngayKetThuc == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Chuyển đổi giá trị số sau khi xác thực
            float phanTramGiamGia = Float.parseFloat(mucGiamGiaStr);

            // Kiểm tra xem ngày bắt đầu có nằm trong khoảng từ năm hiện tại đến năm 2024 không
            LocalDate currentDate = LocalDate.now();
            LocalDate startDateInput = ngayBatDau.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if (startDateInput.isBefore(currentDate) || startDateInput.getYear() > 2024) {
                JOptionPane.showMessageDialog(this, "Ngày bắt đầu không thể nhỏ hơn ngày hiện tại và không được lớn hơn năm 2024.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Kiểm tra xem ngày kết thúc có nằm trong khoảng từ năm hiện tại đến năm 2024 không
            LocalDate endDateInput = ngayKetThuc.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate endOfYear2024 = LocalDate.of(2024, 12, 31);

            if (endDateInput.isBefore(startDateInput)) {
                JOptionPane.showMessageDialog(this, "Ngày kết thúc không thể nhỏ hơn ngày bắt đầu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (endDateInput.isAfter(endOfYear2024)) {
                JOptionPane.showMessageDialog(this, "Ngày kết thúc không được lớn hơn năm 2024.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            DanhSachGiamGiaInfo discountInfo = new DanhSachGiamGiaInfo(0, tenDotGiamGia, ngayBatDau, ngayKetThuc, phanTramGiamGia, rootPaneCheckingEnabled);

            // Gọi phương thức addGiamGia từ lớp DoiGiamGiaRepository để lưu thông tin vào cơ sở dữ liệu
            DoiGiamGiaRepository service = new DoiGiamGiaRepository();
            service.addGiamGia(discountInfo);

            // Làm mới bảng sau khi thêm một ưu đãi mới
            LoadTable2();

            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(this, "Thêm đợt giảm giá thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá trị số không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int selectedRowIndex = tblDSGG.getSelectedRow();

        if (selectedRowIndex != -1) {
            int confirmation = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa đợt giảm giá này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                int maGiamGia = (int) tblDSGG.getValueAt(selectedRowIndex, 0);
                listSV.deleteGiamGia(maGiamGia);
                LoadTable2(); // Refresh the table after deletion

                // Display a success message
                JOptionPane.showMessageDialog(null, "Xóa đợt giảm giá thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một đợt giảm giá để xóa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        int selectedRowIndex = tblDSGG.getSelectedRow();

        if (selectedRowIndex != -1) {
            // Lấy giá trị nhập từ các thành phần giao diện người dùng
            String tenDotGiamGia = txtTenDotGiamGia.getText().trim();
            String mucGiamGiaStr = txtMucGiamGia.getText().trim();
            Date ngayBatDau = jdcNgayBatDau.getDate();
            Date ngayKetThuc = jdcNgayKetThuc.getDate();

            // Xác thực rằng các trường bắt buộc không rỗng
            if (tenDotGiamGia.isEmpty() || mucGiamGiaStr.isEmpty() || ngayBatDau == null || ngayKetThuc == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                // Chuyển đổi giá trị số sau khi xác thực
                float phanTramGiamGia = Float.parseFloat(mucGiamGiaStr);

                // Kiểm tra xem mức giảm giá nằm trong khoảng từ 1 đến 100
                if (phanTramGiamGia < 1 || phanTramGiamGia > 100) {
                    JOptionPane.showMessageDialog(this, "Mức giảm giá phải nằm trong khoảng từ 1 đến 100.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Kiểm tra ngày bắt đầu
                LocalDate currentDate = LocalDate.now();
                LocalDate startDateInput = ngayBatDau.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                if (startDateInput.isBefore(currentDate) || startDateInput.getYear() > 2024) {
                    JOptionPane.showMessageDialog(this, "Ngày bắt đầu không thể nhỏ hơn ngày hiện tại và không được lớn hơn năm 2024.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Kiểm tra ngày kết thúc
                LocalDate endDateInput = ngayKetThuc.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate endOfYear2024 = LocalDate.of(2024, 12, 31);

                if (endDateInput.isBefore(startDateInput) || endDateInput.isAfter(endOfYear2024)) {
                    if (endDateInput.isBefore(startDateInput)) {
                        JOptionPane.showMessageDialog(this, "Ngày kết thúc không thể nhỏ hơn ngày bắt đầu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Ngày kết thúc không được lớn hơn năm 2024.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                    return;
                }

                // Lấy mã giảm giá từ dòng đã chọn trong bảng
                int maGiamGia = (int) tblDSGG.getValueAt(selectedRowIndex, 0);

                // Xác định trạng thái dựa trên radio buttons
                boolean trangThai = rdoDangHoatDong.isSelected();

                // Tạo một đối tượng DanhSachGiamGiaInfo với các giá trị đã lấy
                DanhSachGiamGiaInfo discountInfo = new DanhSachGiamGiaInfo(maGiamGia, tenDotGiamGia, ngayBatDau, ngayKetThuc, phanTramGiamGia, trangThai);

                // Gọi phương thức updateGiamGia từ lớp DoiGiamGiaRepository để cập nhật thông tin vào cơ sở dữ liệu
                DoiGiamGiaRepository service = new DoiGiamGiaRepository();
                service.UpdateGiamGia(discountInfo);
                LoadTable2();

                // Hiển thị thông báo thành công
                JOptionPane.showMessageDialog(this, "Cập nhật đợt giảm giá thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Giá trị số không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một đợt giảm giá để cập nhật.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void txtMucGiamGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMucGiamGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMucGiamGiaActionPerformed

    public JPanel getPanelDotGG() {
        return this.DoiGGPanel;
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
            java.util.logging.Logger.getLogger(FrameDotGiamGia.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameDotGiamGia.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameDotGiamGia.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameDotGiamGia.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameDotGiamGia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DoiGGPanel;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnTaoMoi;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcNgayBatDau;
    private com.toedter.calendar.JDateChooser jdcNgayKetThuc;
    private javax.swing.JRadioButton rdoDaKetThuc;
    private javax.swing.JRadioButton rdoDangHoatDong;
    private javax.swing.JTable tblDSGG;
    private javax.swing.JTextField txtMucGiamGia;
    private javax.swing.JTextField txtTenDotGiamGia;
    // End of variables declaration//GEN-END:variables

}
