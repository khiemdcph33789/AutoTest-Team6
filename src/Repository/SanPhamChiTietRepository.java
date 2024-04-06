/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.SanPhamChiTiet;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author khiem
 */
public class SanPhamChiTietRepository {

    private ArrayList<SanPhamChiTiet> list;
    
    Connection conn;
    Statement stm;
    PreparedStatement psm;

    public SanPhamChiTietRepository() {
        list = new ArrayList<>();
        conn = DBConnect.getConnection();
        GetListProductDetail();

    }

    public ArrayList<SanPhamChiTiet> getList() {
        return list;
    }

    public void setList(ArrayList<SanPhamChiTiet> list) {
        this.list = list;
    }

    public void GetListProductDetail() {
        list.clear();
        try {
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM san_pham_chi_tiet");
            while (rs.next()) {
                int Id = rs.getInt(1);
                int san_pham_Id = rs.getInt(2);
                String Barcode = rs.getString(3);
                String Size = rs.getString(4);
                String Color = rs.getString(5);
                float SellPrice = rs.getFloat(6);
                int Quantity = rs.getInt(7);
                String Note = rs.getString(8);
                SanPhamChiTiet spct = new SanPhamChiTiet(Id, san_pham_Id, Barcode, Size, Color, SellPrice, Quantity, Note);
                list.add(spct);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void InsertProductDetail(SanPhamChiTiet spct) {
        try {
            psm = conn.prepareStatement("""
                                        Insert into san_pham_chi_tiet (san_pham_Id,Barcode,Size,Color,SellPrice,Quantity,Notes)
                                        Values (?,?,?,?,?,?,?)""");
            psm.setInt(1, spct.getSan_pham_Id());
            psm.setString(2, spct.getBarcode());
            psm.setString(3, spct.getSize());
            psm.setString(4, spct.getColor());
            psm.setFloat(5, spct.getSellPrice());
            psm.setInt(6, spct.getQuantity());
            psm.setString(7, spct.getNote());
            psm.execute();
            GetListProductDetail();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void UpdateSPCT(SanPhamChiTiet spct) {
        try {
            psm = conn.prepareStatement("UPDATE san_pham_chi_tiet SET san_pham_Id = ?, Size = ?, Color = ?,SellPrice = ? , Quantity = ?,Notes = ?"
                      + " WHERE Id = ?;");
            System.out.println();
            psm.setInt(1, spct.getSan_pham_Id());
            psm.setString(2, spct.getSize());
            psm.setString(3, spct.getColor());
            psm.setFloat(4, spct.getSellPrice());
            psm.setInt(5, spct.getQuantity());
            psm.setString(6, spct.getNote());
            psm.setInt(7, spct.getId());
            psm.execute();
            GetListProductDetail();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void DeleteSPCT(int spctID) {
        try {
            psm = conn.prepareStatement("DELETE FROM san_pham_chi_tiet WHERE ID = ?;");
            psm.setInt(1, spctID);
            psm.execute();
            GetListProductDetail();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void DeleteSPCTs(int spID) {
        try {
            psm = conn.prepareStatement("DELETE FROM san_pham_chi_tiet WHERE san_pham_Id = ?;");
            psm.setInt(1, spID);
            psm.execute();
            GetListProductDetail();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void MinusQuantity(int spctID,int quantity) {
        try {
            psm = conn.prepareStatement("Update san_pham_chi_tiet set Quantity = ? where Id = ?");
            psm.setInt(1, quantity);
            psm.setInt(2, spctID);
            psm.execute();
            GetListProductDetail();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
}
