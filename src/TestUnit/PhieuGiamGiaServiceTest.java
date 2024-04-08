package TestUnit;

import Model.Phieugiamgia;
import Repository.GiamGiaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PhieuGiamGiaServiceTest {
    private PhieuGiamGiaService service;
    private Phieugiamgia phieuGiamGia;

    @BeforeEach
    void setUp() {
        service = new PhieuGiamGiaService();
        service.list = new ArrayList<>();
        phieuGiamGia = new Phieugiamgia(
                1, "PGG001", 10, new BigDecimal("100.00"), 100,
                "Chuong trinh giam gia mua he", Date.valueOf("2023-06-01"), Date.valueOf("2023-07-01")
        );
    }

    @Test
    void themPhieuGiamGia_ShouldReturnSuccessMessage() {
        Phieugiamgia phieuGiamGia = new Phieugiamgia(
                1, "PGG001", 10, new BigDecimal("100.00"), 100,
                "Chuong trinh giam gia mua he", Date.valueOf("2023-06-01"), Date.valueOf("2023-07-01")
        );

        // Assuming the list is empty and the ID is not duplicated
        String result = service.themPhieuGiamGia(phieuGiamGia);
        assertEquals("Them thanh cong", result);
    }

    @Test
    void themPhieuGiamGia_ShouldThrowIllegalArgumentExceptionForDuplicateID() {
        Phieugiamgia phieuGiamGia1 = new Phieugiamgia(
                1, "PGG001", 10, new BigDecimal("100.00"), 100,
                "Chuong trinh giam gia mua he", Date.valueOf("2023-06-01"), Date.valueOf("2023-07-01")
        );
        service.themPhieuGiamGia(phieuGiamGia1);

        Phieugiamgia phieuGiamGia2 = new Phieugiamgia(
                1, "PGG002", 20, new BigDecimal("200.00"), 200,
                "Chuong trinh giam gia mua dong", Date.valueOf("2023-12-01"), Date.valueOf("2024-01-01")
        );
        assertThrows(IllegalArgumentException.class, () -> service.themPhieuGiamGia(phieuGiamGia2));
    }
    @Test
    void capNhatPhieuGiamGia_WithValidData_ShouldUpdateSuccessfully() {
        service.list.add(phieuGiamGia);
        phieuGiamGia.setMucgiamgia(20);
        assertDoesNotThrow(() -> service.capNhatPhieuGiamGia(phieuGiamGia));
        assertEquals(20, service.list.get(0).getMucgiamgia());
    }

    @Test
    void capNhatPhieuGiamGia_WithInvalidData_ShouldThrowException() {
        service.list.add(phieuGiamGia);
        phieuGiamGia.setMucgiamgia(-10);
        assertThrows(IllegalArgumentException.class, () -> service.capNhatPhieuGiamGia(phieuGiamGia));
    }

    @Test
    void xoaPhieuGiamGia_WithExistingID_ShouldRemoveSuccessfully() {
        service.list.add(phieuGiamGia);
        assertDoesNotThrow(() -> service.xoaPhieuGiamGia(phieuGiamGia.getID()));
        assertTrue(service.list.isEmpty());
    }

    @Test
    void xoaPhieuGiamGia_WithNonExistingID_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> service.xoaPhieuGiamGia(999));
    }
}