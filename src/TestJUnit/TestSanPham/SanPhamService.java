package TestJUnit.TestSanPham;


import Model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class SanPhamService {
    private List<SanPham> sanPhams = new ArrayList<>();

    public SanPhamService() {
        sanPhams.add(new SanPham(1,"chân váy  jean","jean","kiểu dáng chứ A","jean"));
        sanPhams.add(new SanPham(2,"chân váy dạ","dạ","kiểu dáng chữ A","dạ"));
    }

    public void addSanPham(SanPham sanPham) {
        for (SanPham sp : sanPhams) {
            if (sp.getId() == sanPham.getId()) {
                throw new IllegalArgumentException(" đã có ID này ");
            }
        }
        // Kiểm tra kiểu dữ liệu của thuộc tính name
        if (!(sanPham.getName() instanceof String)) {
            throw new IllegalArgumentException("Tên phải là một chuỗi");
        }
        sanPhams.add(sanPham);
    }

    public void editSanPham(SanPham sanPham) {
        for (SanPham sp : sanPhams) {
            if (sp.getId() == sanPham.getId()) {
                sp.setName(sanPham.getName());
                sp.setFabricType(sanPham.getFabricType());
                sp.setDesigns(sanPham.getDesigns());
                sp.setDanh_muc_id(sanPham.getDanh_muc_id());
                return;
            }
        }
    }


    public void removeSanPham(int id) {
        for (int i = 0; i < sanPhams.size(); i++) {
            if (sanPhams.get(i).getId() == id) {
                sanPhams.remove(i);
                return;
            }

        }
    }
    public SanPham searchByName(String name) {
        for (SanPham sp : sanPhams) {
            if (sp.getName().equals(name)) {
                return sp;
            }
        }
        return null;
    }

//

    public List<SanPham> getDanhSachSanPhams() {
        return sanPhams;
    }
}
