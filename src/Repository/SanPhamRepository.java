/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.SanPham;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author khiem
 */
public class SanPhamRepository {
    private ArrayList<SanPham> list;
    Connection conn;
    Statement stm;
    PreparedStatement psm;

    public SanPhamRepository() {
        list = new ArrayList<>();
        conn = DBConnect.getConnection();
        GetListProduct();
    }

    public ArrayList<SanPham> getList() {
        return list;
    }

    public void setList(ArrayList<SanPham> list) {
        this.list = list;
    }
    public void GetListProduct() {
        list.clear();
        try {
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT sp.ID,sp.Name,FabricType,Designs,dm.Name from san_pham sp join danh_muc_san_pham dm on sp.danh_muc_san_pham_Id = dm.Id  ");
            while (rs.next()) {
                 int Id = rs.getInt(1);
                 String Name = rs.getString(2) ;
                 String FabricType = rs.getString(3) ;
                 String Designs = rs.getString(4) ;
                String danh_muc_SP = rs.getString(5);
                SanPham sp = new SanPham(Id, Name, FabricType, Designs,  danh_muc_SP);
                list.add(sp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
    
    public void InsertProduct(SanPham sp) {
        try {
            psm = conn.prepareStatement("Insert into san_pham (Name,FabricType,Designs,danh_muc_san_pham_Id)"
                      + "Values (?,?,?,?)");
            psm.setString(1, sp.getName());
            psm.setString(2, sp.getFabricType());
            psm.setString(3, sp.getDesigns());
            psm.setInt(4, ConvertDanhMucID(sp.getDanh_muc_id()));
            psm.execute();
            GetListProduct();
            
          

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    public void UpdateProduct(SanPham sp) {
        try {
            psm = conn.prepareStatement("Update san_pham SET Name = ? , FabricType = ?, Designs = ?, danh_muc_san_pham_Id = ? Where Id = ?");
            psm.setString(1, sp.getName());
            psm.setString(2, sp.getFabricType());
            psm.setString(3, sp.getDesigns());
            psm.setInt(4, ConvertDanhMucID(sp.getDanh_muc_id()));
            psm.setInt(5, sp.getId());
            psm.execute();
            GetListProduct();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    public int ConvertDanhMucID(String DanhMuc) {
        if (DanhMuc.equalsIgnoreCase("Chân váy")) {
            return 1;
        } else if (DanhMuc.equalsIgnoreCase("Váy liền")) {
            return 2;
        } else if (DanhMuc.equalsIgnoreCase("Váy thể thao")) {
            return 3;
        } else if (DanhMuc.equalsIgnoreCase("Váy công sở")) {
            return 4;
        }
        return 5;
    }

    public void DeleteProduct(int spID) {
        try {
            psm = conn.prepareStatement("DELETE FROM san_pham WHERE ID = ?");
            psm.setInt(1, spID);
            psm.execute();
            GetListProduct();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public String getName(int Id) {
        try {
            String tenKH = null;
            psm = conn.prepareStatement("Select name from san_pham WHERE Id = ?   ");
            psm.setInt(1, Id);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                tenKH = rs.getString(1);
            }
            return tenKH;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public String getFabricType(int Id) {
        try {
            String tenKH = null;
            psm = conn.prepareStatement("Select FabricType from san_pham WHERE Id = ?   ");
            psm.setInt(1, Id);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                tenKH = rs.getString(1);
            }
            return tenKH;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public String getDesigns(int Id) {
        try {
            String tenKH = null;
            psm = conn.prepareStatement("Select Designs from san_pham WHERE Id = ?   ");
            psm.setInt(1, Id);
            ResultSet rs = psm.executeQuery();
            while (rs.next()) {
                tenKH = rs.getString(1);
            }
            return tenKH;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    

}
