package TestJUnit.KhachHang;
import Model.KhachHang;
import Repository.KhachHangRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KhachHangServiceTest {

    private KhachHangService khachHangService;
    private KhachHangRepository khachHangRepository;

    @BeforeEach
    public void setUp() {
        khachHangRepository = new KhachHangRepository();
        khachHangService = new KhachHangService();
    }

    @Test
    public void testThemKhachHang() {
        KhachHang khachHang = new KhachHang();
        khachHang.setTenKhachHang("haha");
        khachHang.setSoDienThoai("047547854");
        khachHang.setDiaChi("hihi");
        khachHang.setGioiTinh(1);
        khachHangRepository.insert(khachHang);


        String result = khachHangService.capNhatKhachHang(khachHang);

        assertEquals("Cập nhật khách hàng thành công", result);
    }


    @Test
    public void testCapNhatKhachHang() {
        KhachHang khachHang = new KhachHang();
        khachHang.setTenKhachHang("haha");
        khachHang.setSoDienThoai("047547854");
        khachHang.setDiaChi("hihi");
        khachHang.setGioiTinh(1);
        khachHangRepository.insert(khachHang);
        String result = khachHangService.capNhatKhachHang(khachHang);
        assertEquals("Cập nhật khách hàng thành công", result);
    }

}

