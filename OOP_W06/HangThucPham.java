package lequangthinh25654411;

import java.time.LocalDate;

public class HangThucPham implements Comparable<HangThucPham> {

    private int id;
    private final String maHang;
    private String tenHang;
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;
    private float gia;

    private static int demSoLuong = 0;

    // ================= GETTER =================

    public int getId() {
        return id;
    }

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public float getGia() {
        return gia;
    }

    public static int getDemSoLuong() {
        return demSoLuong;
    }

    // ================= SETTER =================

    public void setTenHang(String tenHang) {
        if (tenHang == null || tenHang.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Ten hang khong duoc rong"
            );
        }

        this.tenHang = tenHang;
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {

        // Ngày sản xuất không được null và không được trong tương lai
        if (!KiemTraNgaySanXuat(ngaySanXuat)) {
            throw new IllegalArgumentException(
                    "Ngay san xuat khong duoc null hoac tuong lai"
            );
        }

        // Nếu đã có ngày hết hạn thì ngày sản xuất
        // phải trước ngày hết hạn
        if (this.ngayHetHan != null
                && !KiemTraNgayHetHan(ngaySanXuat, this.ngayHetHan)) {

            throw new IllegalArgumentException(
                    "Ngay san xuat phai truoc ngay het han"
            );
        }

        this.ngaySanXuat = ngaySanXuat;
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {

        // Phải có ngày sản xuất trước
        if (this.ngaySanXuat == null) {
            throw new IllegalArgumentException(
                    "Chua co ngay san xuat"
            );
        }

        // Ngày hết hạn phải sau ngày sản xuất
        if (!KiemTraNgayHetHan(this.ngaySanXuat, ngayHetHan)) {
            throw new IllegalArgumentException(
                    "Ngay het han phai sau ngay san xuat"
            );
        }

        this.ngayHetHan = ngayHetHan;
    }

    public void setGia(float gia) {

        if (gia <= 0) {
            throw new IllegalArgumentException(
                    "Gia ban phai lon hon 0"
            );
        }

        this.gia = gia;
    }

    // ================= CONSTRUCTOR MAC DINH =================

    public HangThucPham() {

        this.id = ++demSoLuong;

        this.maHang = "MH" + String.format("%03d", this.id);

        this.tenHang = "Hang mac dinh";

        this.ngaySanXuat = LocalDate.now();

        // Cho ngày hết hạn sau ngày sản xuất
        this.ngayHetHan = LocalDate.now().plusDays(1);

        this.gia = 1.0f;
    }

    // ================= CONSTRUCTOR CO THAM SO =================

    public HangThucPham(
            String maHang,
            String tenHang,
            LocalDate ngaySanXuat,
            LocalDate ngayHetHan,
            float gia) {

        // Kiểm tra mã hàng
        if (maHang == null || maHang.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Ma hang khong duoc de trong"
            );
        }

        // Kiểm tra tên hàng
        if (tenHang == null || tenHang.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Ten hang khong duoc de trong"
            );
        }

        // Kiểm tra giá
        if (gia <= 0) {
            throw new IllegalArgumentException(
                    "Gia phai lon hon 0"
            );
        }

        // Kiểm tra ngày sản xuất
        if (!KiemTraNgaySanXuat(ngaySanXuat)) {
            throw new IllegalArgumentException(
                    "Ngay san xuat khong duoc null hoac tuong lai"
            );
        }

        // Kiểm tra ngày hết hạn
        if (!KiemTraNgayHetHan(ngaySanXuat, ngayHetHan)) {
            throw new IllegalArgumentException(
                    "Ngay het han phai sau ngay san xuat"
            );
        }

        // Tăng số lượng và tạo ID
        this.id = ++demSoLuong;

        this.maHang = maHang;
        this.tenHang = tenHang;
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        this.gia = gia;
    }

    // ================= KIEM TRA NGAY SAN XUAT =================

    public boolean KiemTraNgaySanXuat(LocalDate ngaySanXuat) {

        return ngaySanXuat != null
                && !ngaySanXuat.isAfter(LocalDate.now());
    }

    // ================= KIEM TRA NGAY HET HAN =================

    public boolean KiemTraNgayHetHan(
            LocalDate ngaySanXuat,
            LocalDate ngayHetHan) {

        return ngaySanXuat != null
                && ngayHetHan != null
                && ngayHetHan.isAfter(ngaySanXuat);
    }

    // ================= KIEM TRA HET HAN =================

    public boolean KiemTraHetHan() {

        if (this.ngayHetHan == null) {
            return false;
        }

        return LocalDate.now().isAfter(this.ngayHetHan);
    }

    // ================= TRANG THAI CHI TIET =================

    public String TrangThaiChiTiet() {

        LocalDate homNay = LocalDate.now();

        if (homNay.isBefore(ngaySanXuat)) {
            return "Chua san xuat";
        }

        if (homNay.isAfter(ngayHetHan)) {
            return "Het han";
        }

        if (homNay.isEqual(ngayHetHan)) {
            return "Het han hom nay";
        }

        long con = ngayHetHan.toEpochDay()
                - homNay.toEpochDay();

        return "Con " + con + " ngay";
    }

    // ================= KHONG CHO CLONE =================

    @Override
    protected Object clone() throws CloneNotSupportedException {

        throw new CloneNotSupportedException(
                "Khong the sao chep HangThucPham"
        );
    }

    // ================= COMPARE TO =================

    @Override
    public int compareTo(HangThucPham o) {

        return Integer.compare(this.id, o.id);
    }

    // ================= TO STRING =================

    @Override
    public String toString() {

        return "HangThucPham ["
                + "id=" + id
                + ", maHang=" + maHang
                + ", tenHang=" + tenHang
                + ", ngaySanXuat=" + ngaySanXuat
                + ", ngayHetHan=" + ngayHetHan
                + ", gia=" + gia
                + "]";
    }
}
