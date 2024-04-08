package TestJUnit.TestSanPham;


import Model.SanPhamChiTiet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SanPhamChiTietServiceTest {
    private SanPhamChiTietService sanPhamChiTietService;

    @BeforeEach
    public void setUp() {
        sanPhamChiTietService = new SanPhamChiTietService();
    }

    @Test
    public void testThemSanPhamChiTiet() {
        SanPhamChiTiet sp = new SanPhamChiTiet(/*Thông tin sản phẩm*/);
        sanPhamChiTietService.themSanPhamChiTiet(sp);
        Assertions.assertTrue(sanPhamChiTietService.getSanPhamChiTiets().contains(sp));
    }

    @Test
    public void testSuaSanPhamChiTiet() {
        // Khởi tạo danh sách các sản phẩm và thêm sản phẩm vào danh sách
        SanPhamChiTiet sp = new SanPhamChiTiet(/*Thông tin sản phẩm*/);
        sanPhamChiTietService.themSanPhamChiTiet(sp);

        // Sửa đổi thông tin sản phẩm
        SanPhamChiTiet spMoi = new SanPhamChiTiet(/*Thông tin sản phẩm mới*/);
        sanPhamChiTietService.suaSanPhamChiTiet(0, spMoi);

        Assertions.assertEquals(spMoi, sanPhamChiTietService.getSanPhamChiTiets().get(0));
    }

    @Test
    public void testXoaSanPhamChiTiet() {
        // Khởi tạo danh sách các sản phẩm và thêm sản phẩm vào danh sách
        SanPhamChiTiet sp = new SanPhamChiTiet(/*Thông tin sản phẩm*/);
        sanPhamChiTietService.themSanPhamChiTiet(sp);

        // Xóa sản phẩm
        sanPhamChiTietService.xoaSanPhamChiTiet(0);

        Assertions.assertTrue(sanPhamChiTietService.getSanPhamChiTiets().isEmpty());
    }

    @Test
    public void testThemSanPhamChiTiet_GiaAm() {
        SanPhamChiTiet sp = new SanPhamChiTiet(/*Thông tin sản phẩm*/);
        sp.setSellPrice(-100); // Đặt SellPrice là số âm
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            sanPhamChiTietService.themSanPhamChiTiet(sp);
        });
    }

    @Test
    public void testThemSanPhamChiTiet_SoAm() {
        SanPhamChiTiet sp = new SanPhamChiTiet(/*Thông tin sản phẩm*/);
        sp.setQuantity(-10); // Đặt Quantity là số âm
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            sanPhamChiTietService.themSanPhamChiTiet(sp);
        });
    }


}