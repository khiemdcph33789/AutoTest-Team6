package TestUnit;


import Model.Phieugiamgia;
import Repository.GiamGiaRepository;

import java.util.ArrayList;

public class PhieuGiamGiaService {
    ArrayList<Phieugiamgia> list = new GiamGiaRepository().getList();

    GiamGiaRepository giamGiaRepo = new GiamGiaRepository();

    public String themPhieuGiamGia(Phieugiamgia phieuGiamGia) {
        for (Phieugiamgia pg : list) {
            if (pg.getID() == phieuGiamGia.getID()) {
                throw new IllegalArgumentException("ID bi trung");
            }
        }
        if (phieuGiamGia.getMaPhieu().isEmpty()) {
            throw new IllegalArgumentException("Ma phieu khong duoc de trong");
        } else if (phieuGiamGia.getNgaybatdau().compareTo(phieuGiamGia.getNgayketthuc()) > 0) {
            throw new IllegalArgumentException("Ngay bat dau phai truoc ngay ket thuc");
        } else if (phieuGiamGia.getMucgiamgia() < 0) {
            throw new IllegalArgumentException("Muc giam gia phai lon hon 0");
        } else {
            giamGiaRepo.Add(phieuGiamGia);
            return "Them thanh cong";
        }
    }

    public void capNhatPhieuGiamGia(Phieugiamgia phieuGiamGia) {
        for (Phieugiamgia pg : list) {
            if (pg.getID() == phieuGiamGia.getID()) {
                if (phieuGiamGia.getMaPhieu().isEmpty() || phieuGiamGia.getMucgiamgia() < 0) {
                    throw new IllegalArgumentException("Thong tin khong hop le");
                } else {
                    pg.setMaPhieu(phieuGiamGia.getMaPhieu());
                    pg.setMucgiamgia(phieuGiamGia.getMucgiamgia());
                    pg.setChuongtrinh(phieuGiamGia.getChuongtrinh());
                    pg.setNgaybatdau(phieuGiamGia.getNgaybatdau());
                    pg.setNgayketthuc(phieuGiamGia.getNgayketthuc());
                    pg.setSoluong(phieuGiamGia.getSoluong());
                    pg.setDk(phieuGiamGia.getDk());
                    giamGiaRepo.UpdateQuantity(pg.getID(), pg.getSoluong());
                    return;
                }
            }
        }
        throw new IllegalArgumentException("Phieu giam gia khong ton tai");
    }

    public void xoaPhieuGiamGia(int ID) {
        for (Phieugiamgia pg : list) {
            if (pg.getID() == ID) {
                giamGiaRepo.Delete(ID);
                return;
            }
        }
        throw new IllegalArgumentException("Phieu giam gia khong ton tai");
    }
}
