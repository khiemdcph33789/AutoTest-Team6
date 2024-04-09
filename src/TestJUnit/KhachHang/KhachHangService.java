package TestJUnit.KhachHang;
import Model.KhachHang;
import Repository.KhachHangRepository;


public class KhachHangService {
    private KhachHangRepository khachHangRepo;

    public KhachHangService() {
        this.khachHangRepo = new KhachHangRepository();
    }

    public String themKhachHang(KhachHang khachHang) {
        try {
            validateKhachHang(khachHang);
            khachHangRepo.insert(khachHang);
            return "Thêm khách hàng thành công";
        } catch (IllegalArgumentException e) {
            return "Thêm khách hàng thất bại: " + e.getMessage();
        }
    }

    public String capNhatKhachHang(KhachHang khachHang) {
        try {
            validateKhachHang(khachHang);
            khachHangRepo.update(khachHang);

            return "Cập nhật khách hàng thành công";
        } catch (IllegalArgumentException e) {
            return "Cập nhập khách hàng thất bại: " + e.getMessage();
        }
    }

    private void validateKhachHang(KhachHang khachHang) {
        if (khachHang == null) {
            throw new IllegalArgumentException("Thông tin khách hàng không được null");
        }
        if (khachHang.getTenKhachHang() == null || khachHang.getTenKhachHang().isEmpty()) {
            throw new IllegalArgumentException("Tên khách hàng không được để trống");
        } else if (khachHang.getDiaChi() == null || khachHang.getDiaChi().isEmpty()) {
            throw new IllegalArgumentException("Địa chỉ khách hàng không được để trống");
        } else if (khachHang.getSoDienThoai() == null || khachHang.getSoDienThoai().isEmpty()) {
            throw new IllegalArgumentException("Số điện thoại khách hàng không được để trống");
        }
    }
}
