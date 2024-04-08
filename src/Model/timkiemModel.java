/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class timkiemModel {
    private int ID;
    private String ID_SP;
    private String ID_KH;
    private String Ten_KH;
    private String Ten_SP;
    private int sdt;
    private String size;
    private String loai_vai;
    private String kieu;
    private String mau;
    private String gia;
    private String Ngaymua;

    public timkiemModel() {
    }

    public timkiemModel(int ID,String ID_SP, String ID_KH, String Ten_KH, String Ten_SP,int sdt, String size, String loai_vai, String kieu, String mau, String gia, String Ngaymua) {
        this.ID = ID;
        this.ID_SP = ID_SP;
        this.ID_KH = ID_KH;
        this.Ten_KH = Ten_KH;
        this.Ten_SP = Ten_SP;
        this.sdt = sdt;
        this.size = size;
        this.loai_vai = loai_vai;
        this.kieu = kieu;
        this.mau = mau;
        this.gia = gia;
        this.Ngaymua = Ngaymua;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    

    public String getID_SP() {
        return ID_SP;
    }

    public void setID_SP(String ID_SP) {
        this.ID_SP = ID_SP;
    }

    public String getID_KH() {
        return ID_KH;
    }

    public void setID_KH(String ID_KH) {
        this.ID_KH = ID_KH;
    }

    public String getTen_KH() {
        return Ten_KH;
    }

    public void setTen_KH(String Ten_KH) {
        this.Ten_KH = Ten_KH;
    }

    public String getTen_SP() {
        return Ten_SP;
    }

    public void setTen_SP(String Ten_SP) {
        this.Ten_SP = Ten_SP;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLoai_vai() {
        return loai_vai;
    }

    public void setLoai_vai(String loai_vai) {
        this.loai_vai = loai_vai;
    }

    public String getKieu() {
        return kieu;
    }

    public void setKieu(String kieu) {
        this.kieu = kieu;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getNgaymua() {
        return Ngaymua;
    }

    public void setNgaymua(String Ngaymua) {
        this.Ngaymua = Ngaymua;
    }
    
}
