/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.HoaDon;
import Model.HoaDonChiTiet;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author khiem
 */
public class HoaDonChiTietRepository {
    private ArrayList<HoaDonChiTiet> list;
    private Connection conn;
    private Statement stm;
    private PreparedStatement psm;

    public HoaDonChiTietRepository() {
        list = new ArrayList<>();
        conn = DBConnect.getConnection();
    }

    public ArrayList<HoaDonChiTiet> getList() {
        return list;
    }

    public void setList(ArrayList<HoaDonChiTiet> list) {
        this.list = list;
    }

    public ArrayList<HoaDonChiTiet> GetListBill(int hoadonId) {
        list.clear();
        try {
            psm = conn.prepareStatement("""
                                        SELECT Name,hdct.quantity,hdct.priceProduct,spct.Id,hdct.Id FROM hoa_don_chi_tiet hdct 
                                        left join san_pham_chi_tiet spct on hdct.san_pham_ID = spct.Id
                                        left join san_pham sp on spct.san_pham_Id = sp.Id where hdct.hoa_don_ID = ?;""");
            psm.setInt(1,hoadonId);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                String NameProduct = rs.getString(1);
                int quantity = rs.getInt(2);
                BigDecimal price = rs.getBigDecimal(3);
                int ProductDetailID = rs.getInt(4);
                int HoaDonCTID = rs.getInt(5);
                HoaDonChiTiet hdct = new HoaDonChiTiet(HoaDonCTID,ProductDetailID,NameProduct, quantity, price);
                list.add(hdct);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public void InsertHDCT(int hoadonId, int sanphamCTID,int quantity,BigDecimal Price) {
        list.clear();
        try {
            psm = conn.prepareStatement("""
                                        Insert into hoa_don_chi_tiet (hoa_don_ID,san_pham_ID,quantity,priceProduct)
                                        values (?,?,?,?) """);
            System.out.println("HD ID : " + hoadonId);
            System.out.println("sanphamCTID : " + sanphamCTID);
            System.out.println("quantity : " + quantity);
            System.out.println("Price : " + Price);
            psm.setInt(1, hoadonId);
            psm.setInt(2, sanphamCTID);
            psm.setInt(3, quantity);
            psm.setBigDecimal(4, Price);
            psm.executeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    public void UpdateHDCT(int quantity,int hoaDonCTID) {
        list.clear();
        try {
            psm = conn.prepareStatement("""
                                        update hoa_don_chi_tiet set quantity = ? where Id = ?""");

            psm.setInt(1, quantity);
            psm.setInt(2, hoaDonCTID);
            psm.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    public void RemoveHDCT(int hoaDonCTID) {
        list.clear();
        try {
            psm = conn.prepareStatement("""
                                        Delete from hoa_don_chi_tiet where Id = ?""");

            psm.setInt(1, hoaDonCTID);
            psm.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

   
    
}
