package TestJUnit.dot_giam_gia;

import Model.DanhSachGiamGiaInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DotGiamGiaServiceTest {
    private static DotGiamGiaService dgg;

    @BeforeClass
    public static void setup() {
        dgg = new DotGiamGiaService();
    }

    @Test
    public void themDotGiamGia() throws ParseException {
        String actual = dgg.themDotGiamGia(new DanhSachGiamGiaInfo(10, "mgg1",
                new SimpleDateFormat("yyyy/MM/dd").parse("2024/01/01"),
                new SimpleDateFormat("yyyy/MM/dd").parse("2024/10/10"),
                10, true));
        String expect = "Add thanh cong";
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void themDotGiamGiaTrungMa() throws ParseException {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            dgg.themDotGiamGia(new DanhSachGiamGiaInfo(1, "mgg1",
                    new SimpleDateFormat("yyyy/MM/dd").parse("2024/01/01"),
                    new SimpleDateFormat("yyyy/MM/dd").parse("2024/10/10"),
                    10, true));
        });
    }

    @Test
    public void themDotGiamGiaMaBang0() throws ParseException {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            dgg.themDotGiamGia(new DanhSachGiamGiaInfo(0, "mgg1",
                    new SimpleDateFormat("yyyy/MM/dd").parse("2024/01/01"),
                    new SimpleDateFormat("yyyy/MM/dd").parse("2024/10/10"),
                    10, true));
        });
    }

    @Test
    public void themDotGiamGiaPhanTramBeHon0() throws ParseException {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            dgg.themDotGiamGia(new DanhSachGiamGiaInfo(9, "mgg1",
                    new SimpleDateFormat("yyyy/MM/dd").parse("2024/01/01"),
                    new SimpleDateFormat("yyyy/MM/dd").parse("2024/10/10"),
                    -2, true));
        });
    }

    @Test
    public void themDotGiamGiaDateKhongHople() throws ParseException {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            dgg.themDotGiamGia(new DanhSachGiamGiaInfo(9, "mgg1",
                    new SimpleDateFormat("yyyy/MM/dd").parse("2024/11/11"),
                    new SimpleDateFormat("yyyy/MM/dd").parse("2024/10/10"),
                    6, true));
        });
    }

    @Test
    public void updateDotGiamGia() throws ParseException {
        dgg.updateDotGiamGia(new DanhSachGiamGiaInfo(5, "mgg5",
                new SimpleDateFormat("yyyy/MM/dd").parse("2024/01/01"),
                new SimpleDateFormat("yyyy/MM/dd").parse("2024/10/10"),
                16, false));
    }

    @Test
    public void updateDotGiamGiaKhongTonTaiMaGG() throws ParseException {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            dgg.updateDotGiamGia(new DanhSachGiamGiaInfo(100, "mgg test",
                    new SimpleDateFormat("yyyy/MM/dd").parse("2024/11/11"),
                    new SimpleDateFormat("yyyy/MM/dd").parse("2024/10/10"),
                    3, true));
        });
    }

    @Test
    public void updateDotGiamGiaTenKhongHople() throws ParseException {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            dgg.updateDotGiamGia(new DanhSachGiamGiaInfo(3, "",
                    new SimpleDateFormat("yyyy/MM/dd").parse("2024/11/11"),
                    new SimpleDateFormat("yyyy/MM/dd").parse("2024/10/10"),
                    6, true));
        });
    }

    @Test
    public void updateDotGiamGiaPhanTramKhongHople() throws ParseException {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            dgg.updateDotGiamGia(new DanhSachGiamGiaInfo(3, "mgg test",
                    new SimpleDateFormat("yyyy/MM/dd").parse("2024/11/11"),
                    new SimpleDateFormat("yyyy/MM/dd").parse("2024/10/10"),
                    -3, true));
        });
    }

    @Test
    public void xoaDotGiamGia(){
        dgg.deleteDotGiamGia(7);
    }
    @Test
    public void xoaDotGiamGiaIdKhongHople() throws ParseException {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            dgg.deleteDotGiamGia(10);
        });
    }

    @Test
    public void xoaDotGiamGiaIdNull() throws ParseException {
        Assert.assertThrows(NullPointerException.class, () -> {
            dgg.deleteDotGiamGia(null);
        });
    }

    @Test
    public void xoaDotGiamGiaIdRong() throws ParseException {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            dgg.deleteDotGiamGia(Integer.valueOf(""));
        });
    }
}