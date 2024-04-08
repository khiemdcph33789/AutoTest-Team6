package TestJUnit.TestSanPham;


import Model.SanPham;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

public class SanPhamServiceTest {
    SanPhamService sanPhamService = new SanPhamService();
    private List<SanPham> sanPhams=sanPhamService.getDanhSachSanPhams();

    @Test
    void testAddSanPham_Sucess() {
        int expected=3;
        SanPham newSP = new SanPham(3, "chân váy tennis", "umi", "dáng ngắn ", "Fashion");
        sanPhamService.addSanPham(newSP);
        int actual=sanPhams.size();
        Assertions.assertEquals(expected,actual);

    }
    @Test
    void testAddSP_IDtrunglap(){
        SanPham sp=new SanPham(2,"chân váy xếp ly","vải","chan vay chu A","vải");
        Assertions.assertThrows(IllegalArgumentException.class,()->sanPhamService.addSanPham(sp));
    }



    @Test
    void testEditSanPham() {
        SanPhamService sanPhamService = new SanPhamService();
        // Create a new product
        SanPham newSP = new SanPham(3, "Áo thun", "Cotton", "Pattern A", "Fashion");
        // Test adding the product
        sanPhamService.addSanPham(newSP);
        assertEquals(3, sanPhamService.getDanhSachSanPhams().size()); // Check the number of products after adding
        // Kiểm tra xem nó có ném ngoại lệ cho id trùng lặp không
        assertThrows(IllegalArgumentException.class, () -> {
            // Tạo một sản phẩm mới với id hiện có
            SanPham update = new SanPham(3, "Áo sơ mi", "Silk", "Plain", "Fashion");
            sanPhamService.addSanPham(update);
        });
    }
    @Test
    public void testDeleteSanPhamById() {
        // Arrange
        SanPhamService sanPhamService = new SanPhamService();
        SanPham sanPham1 = new SanPham(4, "chân váy công sở", "vải cao cấp", "dáng dài ", "Fashion");
        SanPham sanPham2 = new SanPham(5, "Product 2", "Type 2", "Design 2", "bbb");
        sanPhamService.addSanPham(sanPham1);
        sanPhamService.addSanPham(sanPham2);
        sanPhamService.removeSanPham(4);
        assertEquals(3, sanPhamService.getDanhSachSanPhams().size());
        assertFalse(sanPhamService.getDanhSachSanPhams().contains(sanPham1));
    }
    @Test
    public void testSearchBy_TenSP() {
        SanPhamService sanPhamService = new SanPhamService();
        SanPham sanPham1 = new SanPham(6, "váy dự tiệc", "vải cao cấp", "dáng vừa", "umi hàn cao cấp");
        SanPham sanPham2 = new SanPham(7, "đầm suông", "vải cao cấp", "dáng vừa", "umi hàn cao cấp");
        sanPhamService.addSanPham(sanPham1);
        sanPhamService.addSanPham(sanPham2);

        assertEquals("váy dự tiệc", sanPhamService.searchByName("váy dự tiệc").getName());
        assertEquals("đầm suông", sanPhamService.searchByName("đầm suông").getName());
        assertNull(sanPhamService.searchByName("Product 3")); // Expecting null for non-existing product
    }

}