package TestJUnit.HoaDon;
import Model.HoaDon;
import Repository.HoaDonRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class HoaDonService {
    private Connection conn;

    public HoaDonService(Connection conn) {
        this.conn = conn;
    }

    public String taoHoaDon(HoaDon hoaDon) {
        String result = "";
        try {
            if (hoaDon == null) {
                throw new IllegalArgumentException("HoaDon object cannot be null");
            }

            PreparedStatement psm = conn.prepareStatement("INSERT INTO hoa_don (Ngay_Mua, Tong_Tien, Trang_Thai) VALUES (?, ?, ?)");
            psm.setDate(1, new java.sql.Date(hoaDon.getNgayMua().getTime()));
            psm.setBigDecimal(2, hoaDon.getTong_tien());
            psm.setInt(3, hoaDon.getTrangThai());

            psm.executeUpdate();
            result = "Hóa đơn đã được tạo thành công";
        } catch (SQLException ex) {
            result = "Đã xảy ra lỗi khi tạo hóa đơn: " + ex.getMessage();
        } catch (IllegalArgumentException ex) {
            result = ex.getMessage();
        }
        return result;
    }
}
