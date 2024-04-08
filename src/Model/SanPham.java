/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author khiem
 */
public final class SanPham {
    private int Id;
    private String Name;
    private String FabricType;
    private String Designs;
    private String danh_muc_SP;

    public SanPham() {
    }

    public SanPham(int Id, String Name, String FabricType, String Designs, String danh_muc_SP) {
        this.Id = Id;
        this.Name = Name;
        this.FabricType = FabricType;
        this.Designs = Designs;
        this.danh_muc_SP = danh_muc_SP;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getFabricType() {
        return FabricType;
    }

    public void setFabricType(String FabricType) {
        this.FabricType = FabricType;
    }

    public String getDesigns() {
        return Designs;
    }

    public void setDesigns(String Designs) {
        this.Designs = Designs;
    }

    public String getDanh_muc_id() {
        return danh_muc_SP;
    }

    public void setDanh_muc_id(String danh_muc_id) {
        this.danh_muc_SP = danh_muc_id;
    }
        
    
}
