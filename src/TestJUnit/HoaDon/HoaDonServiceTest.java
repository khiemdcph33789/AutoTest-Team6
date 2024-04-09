package TestJUnit.HoaDon;


import Model.HoaDon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;



public class HoaDonServiceTest {
    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=DuAn1;encrypt=true;trustServerCertificate=true; ";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "admin";

    @Test
    public void testTaoHoaDon_SuccessfulCreation() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            HoaDonService hoaDonService = new HoaDonService(conn);

            // Prepare valid HoaDon object
            HoaDon hoaDon = new HoaDon();
            hoaDon.setNgayMua(new Date());
            hoaDon.setTong_tien(new BigDecimal("100.00"));
            hoaDon.setTrangThai(1);

            // Perform creation
            String result = hoaDonService.taoHoaDon(hoaDon);

            // Assert
            Assertions.assertEquals("Hóa đơn đã được tạo thành công", result);
        } catch (SQLException ex) {
            Assertions.fail("SQLException occurred: " + ex.getMessage());
        }
    }

    @Test
    public void testTaoHoaDon_NullObject() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            HoaDonService hoaDonService = new HoaDonService(conn);

            // Perform creation with null HoaDon object
            String result = hoaDonService.taoHoaDon(null);

            // Assert
            Assertions.assertEquals("HoaDon object cannot be null", result);
        } catch (SQLException ex) {
            Assertions.fail("SQLException occurred: " + ex.getMessage());
        }
    }

}
