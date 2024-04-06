/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.math.BigDecimal;

/**
 *
 * @author khiem
 */
public class HoaDonChiTiet {
    private int HoaDonCTID;
    private int ProductDetailID;
    private String NameProduct;
    private int quantity;
    private BigDecimal price;
    private BigDecimal intoMoney;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int HoaDonCTID,int ProductDetailID,String NameProduct, int quantity, BigDecimal price) {
        this.HoaDonCTID = HoaDonCTID;
        this.ProductDetailID = ProductDetailID;
        this.NameProduct = NameProduct;
        this.quantity = quantity;
        this.price = price;
        this.intoMoney = price.multiply(BigDecimal.valueOf(quantity));
    }

    public int getHoaDonCTID() {
        return HoaDonCTID;
    }

    public void setHoaDonCTID(int HoaDonCTID) {
        this.HoaDonCTID = HoaDonCTID;
    }

    public int getProductDetailID() {
        return ProductDetailID;
    }

    public void setProductDetailID(int ProductDetailID) {
        this.ProductDetailID = ProductDetailID;
    }

    public String getNameProduct() {
        return NameProduct;
    }

    public void setNameProduct(String NameProduct) {
        this.NameProduct = NameProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getIntoMoney() {
        return intoMoney;
    }

    public void setIntoMoney(BigDecimal intoMoney) {
        this.intoMoney = intoMoney;
    }
    
     
}
