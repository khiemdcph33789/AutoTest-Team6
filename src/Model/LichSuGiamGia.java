
package Model;

import java.util.Date;

public class LichSuGiamGia {
    private int maLichSu;
    private String tenDot;
    private Date ngayTao;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private float mucGiamGia;
    private boolean trangThai;

    public LichSuGiamGia() {
    }

    public LichSuGiamGia(int maLichSu, String tenDot, Date ngayTao, Date ngayBatDau, Date ngayKetThuc, float mucGiamGia, boolean trangThai) {
        this.maLichSu = maLichSu;
        this.tenDot = tenDot;
        this.ngayTao = ngayTao;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.mucGiamGia = mucGiamGia;
        this.trangThai = trangThai;
    }

    public int getMaLichSu() {
        return maLichSu;
    }

    public void setMaLichSu(int maLichSu) {
        this.maLichSu = maLichSu;
    }

    public String getTenDot() {
        return tenDot;
    }

    public void setTenDot(String tenDot) {
        this.tenDot = tenDot;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public float getMucGiamGia() {
        return mucGiamGia;
    }

    public void setMucGiamGia(float mucGiamGia) {
        this.mucGiamGia = mucGiamGia;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "LichSuGiamGia{" + "maLichSu=" + maLichSu + ", tenDot=" + tenDot + ", ngayTao=" + ngayTao + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", mucGiamGia=" + mucGiamGia + ", trangThai=" + trangThai + '}';
    }
    
}
