package qlSV;

import java.time.LocalDate;

public class SinhVien {
    protected String maSV;
    protected String hoTen;
    protected LocalDate ngaySinh;
    protected String lop;
    protected MonHoc monHoc;
    protected int soTinChi;

    // getter
    public void setMaSV(String maSV) { this.maSV = maSV; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public void setNgaySinh(LocalDate ngaySinh) { this.ngaySinh = ngaySinh; }
    public void setLop(String lop) { this.lop = lop; }
    public void setMonHoc(MonHoc monHoc) { this.monHoc = monHoc; }
    public void setSoTinChi(int soTinChi) { this.soTinChi = soTinChi; }
    public String getLoai() { return "Sinh viên"; }
    public String getThongTinRieng() { return ""; }
    
    // setter
    public String getMaSV() { return maSV; }
    public String getHoTen() { return hoTen; }
    public LocalDate getNgaySinh() { return this.ngaySinh; }
    public String getLop() { return this.lop; }
    public MonHoc getMonHoc() { return this.monHoc; }
    public int getSoTinChi() { return soTinChi; }
    public double thanhTien() { return soTinChi * monHoc.getDonGia(); }

    // contructor
    public SinhVien() {}
    public SinhVien(String maSV, String hoTen, LocalDate ngaySinh, String lop, int soTinChi, MonHoc monHoc) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.lop = lop;
        this.monHoc = monHoc;
        this.soTinChi = soTinChi;
    }

    @Override
    public String toString() {
        return String.format(
            "[%s] %s | Lớp: %s | NS: %s | Môn: %s (%d tín x %,.0f) | TT: %,.0f VNĐ",
            maSV, hoTen, lop, ngaySinh,
            monHoc.getTenMon(), soTinChi, monHoc.getDonGia(),
            thanhTien());
    }
}
