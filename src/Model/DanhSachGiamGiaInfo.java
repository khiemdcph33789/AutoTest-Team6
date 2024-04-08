
package Model;

import java.util.Date;

public class DanhSachGiamGiaInfo {
    private int maGiamGia;
    private String tenDotGiamGia;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private float phanTramGiamGia;
    private boolean trangThai;
    public DanhSachGiamGiaInfo() {
    }

    public DanhSachGiamGiaInfo(int maGiamGia, String tenDotGiamGia, Date ngayBatDau, Date ngayKetThuc, float phanTramGiamGia, boolean trangThai) {
        this.maGiamGia = maGiamGia;
        this.tenDotGiamGia = tenDotGiamGia;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.phanTramGiamGia = phanTramGiamGia;
        this.trangThai = trangThai;
    }

    public int getMaGiamGia() {
        return maGiamGia;
    }

    public void setMaGiamGia(int maGiamGia) {
        this.maGiamGia = maGiamGia;
    }

    public String getTenDotGiamGia() {
        return tenDotGiamGia;
    }

    public void setTenDotGiamGia(String tenDotGiamGia) {
        this.tenDotGiamGia = tenDotGiamGia;
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

    public float getPhanTramGiamGia() {
        return phanTramGiamGia;
    }

    public void setPhanTramGiamGia(float phanTramGiamGia) {
        this.phanTramGiamGia = phanTramGiamGia;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "DanhSachGiamGiaInfo{" + "maGiamGia=" + maGiamGia + ", tenDotGiamGia=" + tenDotGiamGia + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", phanTramGiamGia=" + phanTramGiamGia + ", trangThai=" + trangThai + '}';
    }
    
  
}
