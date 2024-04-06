package Repository;

import Model.DanhSachGiamGiaInfo;
import Model.DanhSachSanPhaminfo;
import Repository.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;
import jdk.jfr.Percentage;

public class DoiGiamGiaRepository {

    public ArrayList<DanhSachSanPhaminfo> getAllSanPham() {
        String sql = "SELECT san_pham.id, san_pham.Name, san_pham.FabricType, san_pham.Designs, san_pham_chi_tiet.Size, san_pham_chi_tiet.Color, san_pham_chi_tiet.SellPrice, san_pham_chi_tiet.Quantity FROM san_pham JOIN san_pham_chi_tiet ON san_pham_chi_tiet.id = san_pham.id ";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<DanhSachSanPhaminfo> list = new ArrayList<>();
            while (rs.next()) {
                DanhSachSanPhaminfo ds = new DanhSachSanPhaminfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getFloat(7), rs.getInt(8));
                list.add(ds);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<DanhSachGiamGiaInfo> getAllGiamGia() {
        String sql = "select id, ten_dot_giam_gia,ngay_bat_dau,ngay_ket_thuc,phan_tram_giam_gia,trang_thai from Dot_Giam_Gia";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<DanhSachGiamGiaInfo> list = new ArrayList<>();
            while (rs.next()) {
                DanhSachGiamGiaInfo ds = new DanhSachGiamGiaInfo(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getFloat(5), rs.getBoolean(6));
                list.add(ds);
            };
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addGiamGia(DanhSachGiamGiaInfo ds) {
        String sql = "INSERT INTO Dot_Giam_Gia (ngay_bat_dau, ngay_ket_thuc, phan_tram_giam_gia, ten_dot_giam_gia) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ds.getNgayBatDau());
            ps.setObject(2, ds.getNgayKetThuc());
            ps.setObject(3, ds.getPhanTramGiamGia());
            ps.setObject(4, ds.getTenDotGiamGia());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateGiamGia(DanhSachGiamGiaInfo ds) {
        String sql = "UPDATE Dot_Giam_Gia SET ngay_bat_dau=?, ngay_ket_thuc=?, phan_tram_giam_gia=?, ten_dot_giam_gia=?, trang_thai=? WHERE id=?";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            // Assuming that getNgayBatDau() and getNgayKetThuc() return java.util.Date objects
            // You may need to adjust this based on your actual implementation

            // Set the date values using Timestamp to include both date and time parts
            ps.setTimestamp(1, new java.sql.Timestamp(ds.getNgayBatDau().getTime()));
            ps.setTimestamp(2, new java.sql.Timestamp(ds.getNgayKetThuc().getTime()));
            ps.setObject(3, ds.getPhanTramGiamGia());
            ps.setObject(4, ds.getTenDotGiamGia());
            ps.setObject(5, ds.isTrangThai());
            ps.setObject(6, ds.getMaGiamGia());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            int rowsAffected = ps.executeUpdate();

            // Commit the transaction
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteGiamGia(int id) {
        String sql = "DELETE FROM Dot_Giam_Gia WHERE id=?";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DanhSachGiamGiaInfo getGiamGiaById(int id) {
        String sql = "SELECT id, ten_dot_giam_gia, ngay_bat_dau, ngay_ket_thuc, phan_tram_giam_gia, trang_thai FROM Dot_Giam_Gia WHERE id = ?";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                DanhSachGiamGiaInfo ds = new DanhSachGiamGiaInfo(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getFloat(5), rs.getBoolean(6));
                return ds;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void themSanPhamtoDotGG(int chiTietSanPhamId, int dotGiamGiaId) {
        System.out.println(chiTietSanPhamId);
        String sql = "INSERT INTO chi_tiet_dot_giam_gia ( chi_tiet_san_pham_id, dot_giam_gia_id) VALUES ( ?, ?)";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(2, dotGiamGiaId);
            ps.setInt(1, chiTietSanPhamId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> getAllSPtoGG(int dotGGID) {
        String sql = "select chi_tiet_san_pham_id from chi_tiet_dot_giam_gia where dot_giam_gia_id = ? ";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dotGGID);
            ResultSet rs = ps.executeQuery();
            ArrayList<Integer> list = new ArrayList<>();
            while (rs.next()) {
                list.add(rs.getInt(1));
            };
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void xoaSanPhamKhoiDotGG(int chiTietSanPhamId, int dotGiamGiaId) {
        String sql = "DELETE FROM chi_tiet_dot_giam_gia WHERE chi_tiet_san_pham_id = ? AND dot_giam_gia_id = ?";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, chiTietSanPhamId);
            ps.setInt(2, dotGiamGiaId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int GetPercentDiscount() {
        int PercentDiscount = 0;

        try {
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("""
                         select phan_tram_giam_gia
                           from Dot_Giam_Gia where trang_thai = 1 and (ngay_ket_thuc > CONVERT(date, GETDATE()) or ngay_ket_thuc = CONVERT(date, GETDATE()))""");
            while(rs.next()){
                PercentDiscount =  rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        return PercentDiscount;

    }
}
