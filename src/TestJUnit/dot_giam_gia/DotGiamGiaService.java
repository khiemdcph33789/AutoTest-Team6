package TestJUnit.dot_giam_gia;

import Model.DanhSachGiamGiaInfo;
import Repository.DoiGiamGiaRepository;

import java.util.ArrayList;

public class DotGiamGiaService {
    ArrayList<DanhSachGiamGiaInfo> list = new DoiGiamGiaRepository().getAllGiamGia();

    DoiGiamGiaRepository dgg = new DoiGiamGiaRepository();

    public String themDotGiamGia(DanhSachGiamGiaInfo giamGiaInfo) {
        for (DanhSachGiamGiaInfo x : list) {
            if (x.getMaGiamGia() == giamGiaInfo.getMaGiamGia()) {
                throw new IllegalArgumentException("Ma bi trung");
            }
        }
        if (giamGiaInfo.getMaGiamGia() == 0) {
            throw new IllegalArgumentException();
        } else if (giamGiaInfo.getNgayBatDau().compareTo(giamGiaInfo.getNgayKetThuc()) > 0) {
            throw new IllegalArgumentException();
        } else if (giamGiaInfo.getPhanTramGiamGia() < 0) {
            throw new IllegalArgumentException();
        } else if (giamGiaInfo.getTenDotGiamGia().length() > 50) {
            throw new IllegalArgumentException();
        } else {
            dgg.addGiamGia(giamGiaInfo);
            return "Add thanh cong";
        }
    }

    public void updateDotGiamGia(DanhSachGiamGiaInfo giamGiaInfo) {
        for (DanhSachGiamGiaInfo x : list) {
            if (giamGiaInfo.getTenDotGiamGia().isEmpty() || x.getMaGiamGia() != giamGiaInfo.getMaGiamGia()
                    || giamGiaInfo.getPhanTramGiamGia() < 0) {
                throw new IllegalArgumentException();
            } else {
                x.setTenDotGiamGia(giamGiaInfo.getTenDotGiamGia());
                x.setPhanTramGiamGia(giamGiaInfo.getPhanTramGiamGia());
                dgg.UpdateGiamGia(x);
            }
        }
    }

    public void deleteDotGiamGia(Integer id) {
        for (DanhSachGiamGiaInfo x : list) {
            if (x.getMaGiamGia() != id ) {
                throw new IllegalArgumentException();
            } else if ( id == null) {
                throw new NullPointerException();
            } else {
                dgg.deleteGiamGia(id);
            }
        }
    }

}
