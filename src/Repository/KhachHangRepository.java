/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;


import Model.KhachHang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class KhachHangRepository {
    private ArrayList<KhachHang> lists;
    Connection conn;
    Statement stm;
    PreparedStatement psm;

    public KhachHangRepository() {
        lists = new ArrayList<>();
        conn = DBConnect.getConnection();
        getListKhachHang();
    }
    
    public void getListKhachHang(){
        lists.clear();
        try {
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("Select * from khach_hang");
            while (rs.next()) {                
                int maKhachHang = rs.getInt(1);
                String tenKhachHang = rs.getString(2);
                int gioiTinh = rs.getInt(3);
                String diaChi = rs.getString(4);
                String soDienThoai = rs.getString(5);
                int trangThai = rs.getInt(6);
                String ngayTao = rs.getString(7);
                KhachHang kh = new KhachHang(maKhachHang, tenKhachHang, gioiTinh, diaChi, soDienThoai, trangThai, ngayTao);
                lists.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<KhachHang> getAll(){
        return lists;
    }

    public ArrayList<KhachHang> getLists() {
        return lists;
    }

    public void setLists(ArrayList<KhachHang> lists) {
        this.lists = lists;
    }

   
    
    public void insert(KhachHang kh){
        try {
            psm = conn.prepareStatement("Insert into khach_hang (User_name,Gender,Address,PNumber,Status,Create_date) values (?,?,?,?,?,?)");
            psm.setString(1, kh.getTenKhachHang());
            psm.setInt(2, kh.getGioiTinh());
            psm.setString(3, kh.getDiaChi());
            psm.setString(4, kh.getSoDienThoai());
            psm.setInt(5, kh.getTrangThai());
            psm.setString(6, kh.getNgayTao());
            psm.execute();
            getListKhachHang();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(KhachHang kh){   
        try {
            psm = conn.prepareStatement("Update khach_hang set User_name = ?, Gender = ?, Address = ?, PNumber = ?, Status = ?,Create_date = ?  WHERE Id = ?   ");
            psm.setString(1, kh.getTenKhachHang());
            psm.setInt(2, kh.getGioiTinh());
            psm.setString(3, kh.getDiaChi());
            psm.setString(4, kh.getSoDienThoai());
            psm.setInt(5, kh.getTrangThai());
            psm.setString(6, kh.getNgayTao());
            psm.setInt(7, kh.getMaKhachHang());
            psm.execute();
            getListKhachHang();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String getNameKhachHang(int Id) {
        try {
            String tenKH = null;
            psm = conn.prepareStatement("Select User_name from khach_hang WHERE Id = ?   ");
            psm.setInt(1, Id);
            ResultSet rs = psm.executeQuery();
            while(rs.next()){
                tenKH = rs.getString(1);
            }
            return tenKH;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public int getKhachHangID(String PNumber) {
        try {
            int KhachHangID = 0;
            psm = conn.prepareStatement("Select Id from khach_hang WHERE PNumber = ?   ");
            psm.setString(1, PNumber);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                KhachHangID = rs.getInt(1);
            }
            return KhachHangID;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public String getPNumber(int khachHangID) {
        try {
            String PNumber = "";
            psm = conn.prepareStatement("Select  PNumber from khach_hang WHERE Id = ?   ");
            psm.setInt(1, khachHangID);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                PNumber = rs.getString(1);
            }
            return PNumber;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
       
    
}

    
    

