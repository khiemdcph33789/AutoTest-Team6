/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.math.BigDecimal;
import java.util.Date;


/**
 *
 * @author Admin
 */
public class Phieugiamgia {
    private int ID;
    private String MaPhieu;
    private int mucgiamgia;
    private BigDecimal dk;
    private int soluong;
    private String chuongtrinh;
    private Date ngaybatdau;
    private Date ngayketthuc;

    public Phieugiamgia() {
    }

    public Phieugiamgia(int ID, String MaPhieu, int mucgiamgia, BigDecimal dk, int soluong, String chuongtrinh, Date ngaybatdau, Date ngayketthuc) {
        this.ID = ID;
        this.MaPhieu = MaPhieu;
        this.mucgiamgia = mucgiamgia;
        this.dk = dk;
        this.soluong = soluong;
        this.chuongtrinh = chuongtrinh;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaPhieu() {
        return MaPhieu;
    }

    public void setMaPhieu(String MaPhieu) {
        this.MaPhieu = MaPhieu;
    }

    public int getMucgiamgia() {
        return mucgiamgia;
    }

    public void setMucgiamgia(int mucgiamgia) {
        this.mucgiamgia = mucgiamgia;
    }

    public BigDecimal getDk() {
        return dk;
    }

    public void setDk(BigDecimal dk) {
        this.dk = dk;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getChuongtrinh() {
        return chuongtrinh;
    }

    public void setChuongtrinh(String chuongtrinh) {
        this.chuongtrinh = chuongtrinh;
    }

    public Date getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(Date ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public Date getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(Date ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    
    

}
    