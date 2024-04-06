package Model;

public class DanhSachSanPhaminfo {
    private int sanPhamId;
    private String sanPhamName;
    private String fabricType;
    private String designs;
    private String size;
    private String color;
    private float money;
    private int quantity;

    public DanhSachSanPhaminfo() {
    }

    public DanhSachSanPhaminfo(int sanPhamId, String sanPhamName, String fabricType, String designs, String size, String color, float money, int quantity) {
        this.sanPhamId = sanPhamId;
        this.sanPhamName = sanPhamName;
        this.fabricType = fabricType;
        this.designs = designs;
        this.size = size;
        this.color = color;
        this.money = money;
        this.quantity = quantity;
    }

    public int getSanPhamId() {
        return sanPhamId;
    }

    public void setSanPhamId(int sanPhamId) {
        this.sanPhamId = sanPhamId;
    }

    public String getSanPhamName() {
        return sanPhamName;
    }

    public void setSanPhamName(String sanPhamName) {
        this.sanPhamName = sanPhamName;
    }

    public String getFabricType() {
        return fabricType;
    }

    public void setFabricType(String fabricType) {
        this.fabricType = fabricType;
    }

    public String getDesigns() {
        return designs;
    }

    public void setDesigns(String designs) {
        this.designs = designs;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "DanhSachSanPhaminfo{" + "sanPhamId=" + sanPhamId + ", sanPhamName=" + sanPhamName + ", fabricType=" + fabricType + ", designs=" + designs + ", size=" + size + ", color=" + color + ", money=" + money + ", quantity=" + quantity + '}';
    }

    public Object getProduct() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

   
}
