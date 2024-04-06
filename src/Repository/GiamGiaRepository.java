/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import Model.HoaDon;
import Model.PhieuGiamGiaChiTiet;
import Repository.DBConnect;

import Model.Phieugiamgia;
import java.math.BigDecimal;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 *
 * @author Admin
 */
public class GiamGiaRepository {
    private ArrayList<Phieugiamgia> list;
    private Connection conn;
    private Statement stm;
    private PreparedStatement psm;

    public GiamGiaRepository() {
        list = new ArrayList<>();
        conn = DBConnect.getConnection();
        GetData();    }

    public ArrayList<Phieugiamgia> getList() {
        return list;
    }

    public void setList(ArrayList<Phieugiamgia> list) {
        this.list = list;
    }

    public void GetData() {
        list.clear();
        try {
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select *  from phieu_giam_gia");
            while (rs.next()) {
                int ID = rs.getInt(1);
                String maphieu = rs.getString(2);
                int mucgiamgia = rs.getInt(3);
                int soluong = rs.getInt(7);
                String chuongtrinh = rs.getString(4);
    
                Date ngaybatdau = rs.getDate(5);
                Date ngaykethuc = rs.getDate(6);
                BigDecimal dk = rs.getBigDecimal(8);
               
                
               Phieugiamgia pg = new Phieugiamgia(ID, maphieu, mucgiamgia, dk, soluong, chuongtrinh, ngaybatdau, ngaykethuc);
                list.add(pg);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void Add(Phieugiamgia M) {
        list.clear();
        try {
            psm = conn.prepareStatement("Insert into phieu_giam_gia(ma_phieu,muc_giam_gia,chuong_trinh,ngay_bat_dau,ngay_ket_thuc,so_luong,dieukien) values (?,?,?,?,?,?,?)");
            psm.setString(1,M.getMaPhieu());
            psm.setInt(2, M.getMucgiamgia());
            psm.setString(3, M.getChuongtrinh());
            psm.setObject(4, M.getNgaybatdau());
            psm.setObject(5, M.getNgayketthuc());
            psm.setInt(6, M.getSoluong());
            psm.setBigDecimal(7, M.getDk());
            psm.execute();
            GetData();

        } catch (Exception e) {
            e.printStackTrace();
        }
    
}
//
//    
    public boolean Delete(int ID) {
        try {
            psm = conn.prepareStatement("Delete from phieu_giam_gia where ID = ?");
            psm.setInt(1, ID);
            psm.execute();
//            GetData();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void UpdateQuantity(int ID, int soluong){
        try {
            psm = conn.prepareStatement("""
                                        UPDATE phieu_giam_gia
                                        SET so_luong = ?
                                        WHERE ID = ?;""");
            psm.setInt(1, soluong);
            psm.setInt(2, ID);
            
            psm.execute();
            GetData();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public PhieuGiamGiaChiTiet GetPercentDiscount(String MaPhieu, int KhachHangID){
        System.out.println(MaPhieu);
        System.out.println(KhachHangID);
        try {
            psm = conn.prepareStatement("""
                                         SELECT muc_giam_gia,dieukien,status FROM phieu_giam_gia pgg 
                                        right join phieu_giam_gia_chi_tiet ct on pgg.Id = ct.ID_phieu_giam_gia
                                        where ID_Khach_hang = ? and ma_phieu = ? and (ngay_ket_thuc > CONVERT( date, GETDATE()) or ngay_ket_thuc = CONVERT(date, GETDATE()))""");
            psm.setString(2, MaPhieu);
            psm.setInt(1, KhachHangID);
            ResultSet rs = psm.executeQuery();
            PhieuGiamGiaChiTiet PhieuGiamGiaCT = null;
            while(rs.next()){
                int PercentDiscount = rs.getInt(1);
                BigDecimal dieu_kien = rs.getBigDecimal(2);
                boolean status = rs.getBoolean(3);
                PhieuGiamGiaCT = new PhieuGiamGiaChiTiet(PercentDiscount, dieu_kien, status,MaPhieu);
            }
            
            return PhieuGiamGiaCT;
//            GetData();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
