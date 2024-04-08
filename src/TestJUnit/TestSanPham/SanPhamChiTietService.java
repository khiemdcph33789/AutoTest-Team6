package TestJUnit.TestSanPham;


import Model.SanPhamChiTiet;

import java.util.ArrayList;
import java.util.List;

public class SanPhamChiTietService {
    private List<SanPhamChiTiet> sanPhamChiTiets;

    public SanPhamChiTietService() {
        this.sanPhamChiTiets = new ArrayList<>();
    }

    public void themSanPhamChiTiet(SanPhamChiTiet sanPhamChiTiet) {
        if (sanPhamChiTiet.getSellPrice() < 0 || sanPhamChiTiet.getQuantity() < 0) {
            throw new IllegalArgumentException("SellPrice và Quantity không thể là số âm.");
        }
        sanPhamChiTiets.add(sanPhamChiTiet);
    }

    public void suaSanPhamChiTiet(int index, SanPhamChiTiet sanPhamChiTietMoi) {
        if (sanPhamChiTietMoi.getSellPrice() < 0 || sanPhamChiTietMoi.getQuantity() < 0) {
            throw new IllegalArgumentException("SellPrice và Quantity không thể là số âm.");
        }
        sanPhamChiTiets.set(index, sanPhamChiTietMoi);
    }

    public void xoaSanPhamChiTiet(int index) {
        sanPhamChiTiets.remove(index);
    }
    public  List<SanPhamChiTiet> getSanPhamChiTiets(){
        return sanPhamChiTiets;
    }

}
