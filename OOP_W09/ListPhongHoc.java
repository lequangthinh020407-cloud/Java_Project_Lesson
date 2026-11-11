package leQuangThinh25654411;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListPhongHoc {
    private List<PhongHoc> ls;

    public ListPhongHoc() { 
        ls = new ArrayList<>();
    }
    
    // Thêm một phòng học (không trùng mã)
    public boolean themPhongHoc(PhongHoc p) {
        if (ls.contains(p)) {
            return false;
        }
        return ls.add(p);
    }

    // Tìm kiếm phòng học theo mã phòng
    public PhongHoc timPhongHoc(String maPhong) {
        for (PhongHoc p : ls) {
            if (p.getMaPhong().equalsIgnoreCase(maPhong)) {
                return p;
            }
        }
        return null;
    }

    // Lấy thông tin toàn bộ danh sách
    public List<PhongHoc> getToanBoDanhSach() {
        return this.ls;
    }

    // Lấy thông tin các phòng học đạt chuẩn
    public List<PhongHoc> getDanhSachDatChuan() {
        List<PhongHoc> dsDatChuan = new ArrayList<>();
        for (PhongHoc p : ls) {
            if (p.datChuan()) {
                dsDatChuan.add(p);
            }
        }
        return dsDatChuan;
    }

    // Sắp xếp tăng dần theo dãy nhà
    public void sapXepTheoDayNha() {
        ls.sort(new Comparator<PhongHoc>() {
            @Override
            public int compare(PhongHoc p1, PhongHoc p2) {
                return p1.getDayNha().compareToIgnoreCase(p2.getDayNha());
            }
        });
    }

    // Sắp xếp giảm dần theo diện tích
    public void sapXepTheoDienTichGiamDan() {
        ls.sort(new Comparator<PhongHoc>() {
            @Override
            public int compare(PhongHoc p1, PhongHoc p2) {
                return Double.compare(p2.getDienTich(), p1.getDienTich()); // p2 trước p1 để giảm dần
            }
        });
    }

    // Sắp xếp tăng dần theo số bóng đèn
    public void sapXepTheoSoBongDen() {
        ls.sort(new Comparator<PhongHoc>() {
            @Override
            public int compare(PhongHoc p1, PhongHoc p2) {
                return Integer.compare(p1.getSoBongDen(), p2.getSoBongDen());
            }
        });
    }

    // Cập nhật số máy tính cho một phòng máy tính khi biết mã phòng
    public boolean capNhatSoMayTinh(String maPhong, int soMayMoi) {
        PhongHoc p = timPhongHoc(maPhong);
        if (p instanceof PhongHocMayTinh) {
            ((PhongHocMayTinh) p).setSoMayTinh(soMayMoi);
            return true;
        }
        return false;
    }

    // Xóa một phòng học khi biết mã phòng
    public boolean xoaPhongHoc(String maPhong) {
        PhongHoc p = timPhongHoc(maPhong);
        if (p != null) {
            return ls.remove(p);
        }
        return false;
    }

    // Tính tổng số phòng học
    public int tinhTongSoPhongHoc() {
        return ls.size();
    }

    // Lấy danh sách các phòng máy có đúng 60 máy
    public List<PhongHocMayTinh> getDanhSachPhongMay60May() {
        List<PhongHocMayTinh> dsPhongMay = new ArrayList<>();
        for (PhongHoc p : ls) {
            if (p instanceof PhongHocMayTinh) {
                PhongHocMayTinh pm = (PhongHocMayTinh) p;
                if (pm.getSoMayTinh() == 60) {
                    dsPhongMay.add(pm);
                }
            }
        }
        return dsPhongMay;
    }
}
