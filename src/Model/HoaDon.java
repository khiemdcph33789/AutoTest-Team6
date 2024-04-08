/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Repository.DoiGiamGiaRepository;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class HoaDon {

    private int maHoaDon;
    private int khach_hang_id;
    private Date ngayMua;
    private int trangThai; 
    private BigDecimal tong_tien;
    private BigDecimal so_tien_giam_gia;
    private BigDecimal tien_khac_dua;
    private BigDecimal tien_thua;
    private String ma_giam_gia;

    public String getMa_giam_gia() {
        return ma_giam_gia;
    }

    public void setMa_giam_gia(String ma_giam_gia) {
        this.ma_giam_gia = ma_giam_gia;
    }
    public HoaDon() {
        this.ngayMua = new Date();
    }

    public HoaDon(int maHoaDon, int khach_hang_id, Date ngayMua, int trangThai, BigDecimal tong_tien, BigDecimal so_tien_giam_gia, BigDecimal tien_khac_dua, BigDecimal tien_thua,String ma_giam_gia) {
        this.maHoaDon = maHoaDon;
        this.khach_hang_id = khach_hang_id;
        this.ngayMua = ngayMua;
        this.trangThai = trangThai;
        this.tong_tien = tong_tien;
        this.so_tien_giam_gia = so_tien_giam_gia;
        this.tien_khac_dua = tien_khac_dua;
        this.tien_thua = tien_thua;
        this.ma_giam_gia = ma_giam_gia;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getKhach_hang_id() {
        return khach_hang_id;
    }

    public void setKhach_hang_id(int khach_hang_id) {
        this.khach_hang_id = khach_hang_id;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public BigDecimal getTong_tien() {
        return tong_tien;
    }

    public void setTong_tien(BigDecimal tong_tien) {
        this.tong_tien = tong_tien;
    }

    public BigDecimal getSo_tien_giam_gia() {
        return so_tien_giam_gia;
    }

    public void setSo_tien_giam_gia(BigDecimal so_tien_giam_gia) {
        this.so_tien_giam_gia = so_tien_giam_gia;
    }

    public BigDecimal getTien_khac_dua() {
        return tien_khac_dua;
    }

    public void setTien_khac_dua(BigDecimal tien_khac_dua) {
        this.tien_khac_dua = tien_khac_dua;
    }

    public BigDecimal getTien_thua() {
        return tien_thua;
    }

    public void setTien_thua(BigDecimal tien_thua) {
        this.tien_thua = tien_thua;
    }

    
}
