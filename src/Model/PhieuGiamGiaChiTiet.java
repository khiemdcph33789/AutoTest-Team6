/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.math.BigDecimal;

/**
 *
 * @author khiem
 */
public class PhieuGiamGiaChiTiet {
    private int muc_giam_gia;
    private BigDecimal dieu_kien;
    private boolean trang_thai;
    private String maphieu;
    public PhieuGiamGiaChiTiet() {
    }

    public PhieuGiamGiaChiTiet(int muc_giam_gia, BigDecimal dieu_kien, boolean trang_thai,String maphieu) {
        this.muc_giam_gia = muc_giam_gia;
        this.dieu_kien = dieu_kien;
        this.trang_thai = trang_thai;
        this.maphieu = maphieu;
    }

    public String getMaphieu() {
        return maphieu;
    }

    public void setMaphieu(String maphieu) {
        this.maphieu = maphieu;
    }

    public int getMuc_giam_gia() {
        return muc_giam_gia;
    }

    public void setMuc_giam_gia(int muc_giam_gia) {
        this.muc_giam_gia = muc_giam_gia;
    }

    public BigDecimal getDieu_kien() {
        return dieu_kien;
    }

    public void setDieu_kien(BigDecimal dieu_kien) {
        this.dieu_kien = dieu_kien;
    }

    public boolean isTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(boolean trang_thai) {
        this.trang_thai = trang_thai;
    }
    
    
}
