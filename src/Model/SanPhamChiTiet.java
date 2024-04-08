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
public final class SanPhamChiTiet {

    private int Id;
    private int san_pham_Id;
    private String Barcode;
    private String Size;
    private String Color;
    private float SellPrice;
    private int Quantity;
    private String Note;

    public SanPhamChiTiet(int Id, int san_pham_Id, String Barcode, String Size, String Color, float SellPrice, int Quantity, String Note) {
        this.Id = Id;
        this.san_pham_Id = san_pham_Id;
        this.Barcode = Barcode;
        this.Size = Size;
        this.Color = Color;
        this.SellPrice = SellPrice;
        this.Quantity = Quantity;
        this.Note = Note;
    }

    public SanPhamChiTiet() {
        this.Barcode = this.generateBarcode();
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getSan_pham_Id() {
        return san_pham_Id;
    }

    public void setSan_pham_Id(int san_pham_Id) {
        this.san_pham_Id = san_pham_Id;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String Barcode) {
        this.Barcode = Barcode;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public float getSellPrice() {
        return SellPrice;
    }

    public void setSellPrice(float SellPrice) {
        this.SellPrice = SellPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public String generateBarcode() {
        // Sử dụng thời gian hiện tại
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new Date());

        // Sử dụng một số ngẫu nhiên
        Random random = new Random();
        int randomNum = random.nextInt(10000); // Số ngẫu nhiên trong khoảng 0-9999

        // Kết hợp thời gian và số ngẫu nhiên để tạo mã barcode
        String barcode = timestamp + String.format("%04d", randomNum);

        return barcode;
    }

  
    
    
    

    

}
