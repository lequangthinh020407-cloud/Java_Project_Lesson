package lequangthinh25654411;

import java.time.LocalDate;

public class QuanLyThucPham {

    // ================= THUỘC TÍNH =================

    private HangThucPham[] danhSach;
    private int soLuong;
    private int khaNang;

    private static final int KICH_THUOC_BAN_DAU = 5;

    // ================= CONSTRUCTOR =================

    public QuanLyThucPham() {
        this.khaNang = KICH_THUOC_BAN_DAU;
        this.danhSach = new HangThucPham[khaNang];
        this.soLuong = 0;
    }

    // ================= MỞ RỘNG MẢNG =================

    private void moRongMang() {

        int kichThuocMoi = khaNang * 2;

        HangThucPham[] mangMoi =new HangThucPham[kichThuocMoi];

        for (int i = 0; i < soLuong; i++) {
            mangMoi[i] = danhSach[i];
        }

        danhSach = mangMoi;
        khaNang = kichThuocMoi;
    }

    // ================= TÌM VỊ TRÍ THEO MÃ =================

    public int timViTriTheoMa(String maHang) {

        if (maHang == null) {
            return -1;
        }

        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getMaHang().equalsIgnoreCase(maHang)) {
                return i;
            }
        }
        return -1;
    }

    // ================= TÌM VỊ TRÍ THEO ID =================

    public int timViTriTheoId(int id) {
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    // ================= THÊM =================

    public boolean them(HangThucPham h) {
        if (h == null) {
            return false;
        }
        if (timViTriTheoMa(h.getMaHang()) != -1) {

            System.out.println("Lỗi: Mã hàng '" +h.getMaHang() +"' đã tồn tại!");
            return false;
        }

        if (soLuong == khaNang) {
            moRongMang();
        }
        danhSach[soLuong] = h;
        soLuong++;

        return true;
    }

    // ================= XÓA THEO ID =================

    public boolean xoa(int id) {
        int viTri = timViTriTheoId(id);
        if (viTri == -1) {
            System.out.println("Không tìm thấy hàng có ID: " + id);
            return false;
        }
        for (int i = viTri; i < soLuong - 1; i++) {
            danhSach[i] = danhSach[i + 1];
        }
        danhSach[soLuong - 1] = null;
        soLuong--;
        return true;
    }

    // ================= SỬA THEO ID =================

    public boolean sua(
            int id,
            String tenMoi,
            LocalDate ngaySXMoi,
            LocalDate ngayHHMoi,
            float giaMoi) {
        int viTri = timViTriTheoId(id);
        if (viTri == -1) {
            System.out.println("Không tìm thấy hàng có ID: " + id);
            return false;
        }
        HangThucPham h = danhSach[viTri];

        /*
         * Các setter của HangThucPham
         * sẽ tự kiểm tra dữ liệu.
         */
        h.setTenHang(tenMoi);
        h.setNgaySanXuat(ngaySXMoi);
        h.setNgayHetHan(ngayHHMoi);
        h.setGia(giaMoi);
        return true;
    }

    // ================= TÌM THEO ID =================

    public HangThucPham timTheoId(int id) {
        int viTri = timViTriTheoId(id);
        if (viTri == -1) {
            return null;
        }
        return danhSach[viTri];
    }
    // ================= SẮP XẾP THEO ID =================
    
    public void sapXepTheoId(boolean tangDan) {
        for (int i = 0; i < soLuong - 1; i++) {
            for (int j = i + 1; j < soLuong; j++) {
                boolean canDoi;
                if (tangDan) {
                    canDoi =danhSach[i].compareTo(danhSach[j]) > 0;
                } else {
                    canDoi =danhSach[i].compareTo(danhSach[j]) < 0;
                }
                if (canDoi) {
                	HangThucPham temp = danhSach[i];
                    danhSach[i] = danhSach[j];
                    danhSach[j] = temp;
                }
            }
        }
    }

    // ================= SẮP XẾP THEO GIÁ =================

    public void sapXepTheoGia(boolean tangDan) {
        for (int i = 0; i < soLuong - 1; i++) {
            for (int j = i + 1; j < soLuong; j++) {
                boolean canDoi;
                if (tangDan) {
                    canDoi =danhSach[i].getGia()> danhSach[j].getGia();
                } else {
                    canDoi =danhSach[i].getGia()< danhSach[j].getGia();
                }
                if (canDoi) {
                    HangThucPham temp = danhSach[i];
                    danhSach[i] = danhSach[j];
                    danhSach[j] = temp;
                }
            }
        }
    }

    // ================= SẮP XẾP THEO NGÀY SẢN XUẤT =================

    public void sapXepTheoNgaySanXuat(boolean tangDan) {
        for (int i = 0; i < soLuong - 1; i++) {
            for (int j = i + 1; j < soLuong; j++) {
                boolean canDoi;
                if (tangDan) {
                    canDoi =danhSach[i].getNgaySanXuat().isAfter(danhSach[j].getNgaySanXuat());
                } else {
                    canDoi =danhSach[i].getNgaySanXuat().isBefore(danhSach[j].getNgaySanXuat());
                }
                if (canDoi) {
                    HangThucPham temp = danhSach[i];
                    danhSach[i] = danhSach[j];
                    danhSach[j] = temp;
                }
            }
        }
    }

    // ================= SẮP XẾP THEO NGÀY HẾT HẠN =================

    public void sapXepTheoNgayHetHan(boolean tangDan) {
        for (int i = 0; i < soLuong - 1; i++) {
            for (int j = i + 1; j < soLuong; j++) {
                boolean canDoi;
                if (tangDan) {
                    canDoi =danhSach[i].getNgayHetHan().isAfter(danhSach[j].getNgayHetHan());
                } else {
                    canDoi =danhSach[i].getNgayHetHan().isBefore(danhSach[j].getNgayHetHan());
                }
                if (canDoi) {
                    HangThucPham temp = danhSach[i];
                    danhSach[i] = danhSach[j];
                    danhSach[j] = temp;
                }
            }
        }
    }

    // ================= TÌM THEO TIỀN TỐ =================

    public QuanLyThucPham timTheoTienTo(String tuKhoa) {
        QuanLyThucPham ketQua =new QuanLyThucPham();
        if (tuKhoa == null) {
            return ketQua;
        }
        String tk = tuKhoa.trim().toLowerCase();
        for (int i = 0; i < soLuong; i++) {
            String ten =danhSach[i].getTenHang().toLowerCase();
            if (ten.startsWith(tk)) {
                ketQua.them(danhSach[i]);
            }
        }
        return ketQua;
    }

    // ================= TÌM THEO HẬU TỐ =================

    public QuanLyThucPham timTheoHauTo(String tuKhoa) {
        QuanLyThucPham ketQua =new QuanLyThucPham();
        if (tuKhoa == null) {
            return ketQua;
        }
        String tk = tuKhoa.trim().toLowerCase();
        for (int i = 0; i < soLuong; i++) {
            String ten =danhSach[i].getTenHang().toLowerCase();
            if (ten.endsWith(tk)) {
                ketQua.them(danhSach[i]);
            }
        }
        return ketQua;
    }

    // ================= TÌM GẦN GIỐNG =================

    public QuanLyThucPham timGanGiong(String tuKhoa) {
        QuanLyThucPham ketQua =new QuanLyThucPham();
        if (tuKhoa == null) {
            return ketQua;
        }
        String tk = tuKhoa.trim().toLowerCase();
        for (int i = 0; i < soLuong; i++) {
            String ten =danhSach[i].getTenHang().toLowerCase();
            if (ten.contains(tk)) {
                ketQua.them(danhSach[i]);
            }
        }
        return ketQua;
    }

    // ================= TRÍCH LỌC NGÀY SẢN XUẤT =================

    public QuanLyThucPham trichLocTheoNgaySanXuat(LocalDate tuNgay,LocalDate denNgay) {
        QuanLyThucPham ketQua =new QuanLyThucPham();
        if (tuNgay == null || denNgay == null) {
            return ketQua;
        }

        for (int i = 0; i < soLuong; i++) {

            LocalDate ngaySX =
                    danhSach[i].getNgaySanXuat();
            if (!ngaySX.isBefore(tuNgay)
                    && !ngaySX.isAfter(denNgay)) {

                ketQua.them(danhSach[i]);
            }
        }

        return ketQua;
    }

    // ================= TRÍCH LỌC NGÀY HẾT HẠN =================

    public QuanLyThucPham trichLocTheoNgayHetHan(
            LocalDate tuNgay,
            LocalDate denNgay) {
        QuanLyThucPham ketQua =new QuanLyThucPham();
        if (tuNgay == null || denNgay == null) {
            return ketQua;
        }
        for (int i = 0; i < soLuong; i++) {
            LocalDate ngayHH =
                    danhSach[i].getNgayHetHan();

            if (!ngayHH.isBefore(tuNgay)&& !ngayHH.isAfter(denNgay)) {
                ketQua.them(danhSach[i]);
            }
        }
        return ketQua;
    }

    // ================= TỔNG SỐ LƯỢNG =================

    public int tinhTongSoLuong() {
        return soLuong;
    }

    // ================= TỔNG GIÁ TRỊ =================

    public double tinhTongGiaTri() {
        double tong = 0;
        for (int i = 0; i < soLuong; i++) {
            tong += danhSach[i].getGia();
        }
        return tong;
    }

    // ================= THỐNG KÊ THEO THÁNG =================

    public void thongKeTheoThang() {
        if (soLuong == 0) {
            System.out.println(
                    "Danh sách trống."
            );
            return;
        }

        int[] demTheoThang = new int[13];
        for (int i = 0; i < soLuong; i++) {
            int thang =danhSach[i].getNgaySanXuat().getMonthValue();
            demTheoThang[thang]++;
        }

        System.out.println(
                "THỐNG KÊ SẢN PHẨM THEO THÁNG SẢN XUẤT:"
        );
        for (int thang = 1; thang <= 12; thang++) {
            if (demTheoThang[thang] > 0) {

                System.out.println("Tháng " + thang+ ": "+ demTheoThang[thang]+ " sản phẩm");
            }
        }
    }

    // ================= HIỂN THỊ =================

    public void hienThiDanhSach() {
        if (soLuong == 0) {
            System.out.println("Danh sách trống.");
            return;
        }
        System.out.println(
                "\n+---------+------------+----------------------+------------+------------+------------+");
        System.out.println(
                "|   ID    |  Mã hàng   |       Tên hàng       |  Ngày SX   |  Ngày HH   |    Giá     |");
        System.out.println(
                "+---------+------------+----------------------+------------+------------+------------+");
        for (int i = 0; i < soLuong; i++) {
            System.out.println(danhSach[i]);
        }
        System.out.println(
                "+---------+------------+----------------------+------------+------------+------------+");
        System.out.println(
                "Tổng: " + soLuong + " sản phẩm.");
    }

    // ================= LẤY SỐ LƯỢNG =================

    public int laySoLuong() {
        return soLuong;
    }
}
