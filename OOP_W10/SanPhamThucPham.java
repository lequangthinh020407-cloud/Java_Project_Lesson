package lequangthinh25654411;

import java.time.LocalDate;

public class SanPhamThucPham extends SanPham {

	
	public SanPhamThucPham(String maSP, String tenSP, LocalDate ngaySanXuat, double giaNhap, int soLuongTonKho,
			int ngayHetHan) {
		super(maSP, tenSP, ngaySanXuat, giaNhap, soLuongTonKho);
		this.ngayHetHan = ngayHetHan;
	}
	private int ngayHetHan;
	public double tinhGiaBan() {
		return giaNhap+(giaNhap*0.05);
	}
	public int getNgayHetHan() {
		return ngayHetHan;
	}
	public void setNgayHetHan(int ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}
	@Override
	public String toString() {
		return "Thoi gian het han la: "+ ngayHetHan;
	}
}

