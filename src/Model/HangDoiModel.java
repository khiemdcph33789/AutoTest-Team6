 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import java.util.Date;

/**
 *
 * @author Administrator
 */
public class HangDoiModel {
    private int ID ;
    private int Hoa_don_ID;
    private Date Date;
    private String LyDo;
    private String TrangThai;

    public HangDoiModel() {
    }

    public HangDoiModel(int ID, int Hoa_don_ID, Date Date, String LyDo, String TrangThai) {
        this.ID = ID;
        this.Hoa_don_ID = Hoa_don_ID;
        this.Date = Date;
        this.LyDo = LyDo;
        this.TrangThai = TrangThai;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getHoa_don_ID() {
        return Hoa_don_ID;
    }

    public void setHoa_don_ID(int Hoa_don_ID) {
        this.Hoa_don_ID = Hoa_don_ID;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public String getLyDo() {
        return LyDo;
    }

    public void setLyDo(String LyDo) {
        this.LyDo = LyDo;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
