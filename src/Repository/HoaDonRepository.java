package Repository;

import Model.SanPham;
import Model.HoaDon;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class HoaDonRepository {

    private ArrayList<HoaDon> list;
    private Connection conn;
    private Statement stm;
    private PreparedStatement psm;

    public HoaDonRepository() {
        list = new ArrayList<>();
        conn = DBConnect.getConnection();
        GetListBill();
    }

    public ArrayList<HoaDon> getList() {
        return list;
    }

    public void setList(ArrayList<HoaDon> list) {
        this.list = list;
    }

    public void GetListBill() {
        list.clear();
        try {
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("Select * from hoa_don");
            while (rs.next()) {
                int maHoaDon = rs.getInt(1);
                int khach_hang_id = rs.getInt(2);
                Date ngayMua = rs.getDate(3);
                int trangThai = rs.getInt(5);
                BigDecimal tong_tien = rs.getBigDecimal(4);
                BigDecimal so_tien_giam_gia = rs.getBigDecimal(6);
                BigDecimal tien_khach_dua = rs.getBigDecimal(7);
                BigDecimal tien_thua = rs.getBigDecimal(8);
                String ma_giam_gia = rs.getString(9);
                HoaDon hd = new HoaDon(maHoaDon, khach_hang_id, ngayMua, trangThai, tong_tien, so_tien_giam_gia, tien_khach_dua,  tien_thua,ma_giam_gia);
                list.add(hd);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void InsertProduct(HoaDon hd) {
        try {
            psm = conn.prepareStatement("Insert into hoa_don (Ngay_Mua,Tong_Tien,Trang_Thai)"
                    + "Values (?,?,?)");
            psm.setDate(1, new java.sql.Date(hd.getNgayMua().getTime()));
            psm.setBigDecimal(2, hd.getTong_tien());
            psm.setInt(3, hd.getTrangThai());
            
                        psm.execute();
            GetListBill();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

}
    public int ConvertTrangThai(String TrangThai) {
        if (TrangThai.equalsIgnoreCase("Đã Thanh Toán")) {
            return 1;
        } else if (TrangThai.equalsIgnoreCase("Hoá Đơn Chờ")) {
            return 2;
        } 
         return 3;
        
    }
    public void UpdateTotalPrice(HoaDon hd){
        try {
            psm = conn.prepareStatement("update hoa_don set Tong_tien = ?,so_tien_giam_gia = ?,tien_khach_dua= ?,tien_thua = ?, ma_giam_gia = ? where Id = ?");
            psm.setBigDecimal(1, hd.getTong_tien());
            psm.setBigDecimal(2, hd.getSo_tien_giam_gia());
            psm.setBigDecimal(3, hd.getTien_khac_dua());
            psm.setBigDecimal(4, hd.getTien_thua());
            psm.setInt(6, hd.getMaHoaDon());
            psm.setString(5, hd.getMa_giam_gia());

            psm.execute();
            GetListBill();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void UpdateStatus(HoaDon hd) {
        try {
            psm = conn.prepareStatement("update hoa_don set Trang_Thai = ?,khach_hang_id = ? where Id = ?");
            
       
            psm.setInt(1, hd.getTrangThai());
            if(hd.getKhach_hang_id() == 0){
                psm.setNull(2, java.sql.Types.INTEGER);
            }else{
                psm.setInt(2, hd.getKhach_hang_id());
            }
            psm.setInt(3, hd.getMaHoaDon());

            psm.execute();
            GetListBill();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}