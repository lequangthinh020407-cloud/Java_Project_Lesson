package lequangthinh25654411;

import java.time.LocalDate;

public class SanPhamDienTu extends SanPham {

	public SanPhamDienTu(String maSP, String tenSP, LocalDate ngaySanXuat, double giaNhap, int soLuongTonKho,
			int thoiGianBaoHanh) {
		super(maSP, tenSP, ngaySanXuat, giaNhap, soLuongTonKho);
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}
	private int thoiGianBaoHanh;
	public double tinhGiaBan() {
		return giaNhap+(giaNhap*0.1)+(thoiGianBaoHanh*50000);
	}
	public int getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}
	public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}
	@Override
	public String toString() {
		return "Thoi gian bao hanh la: " + thoiGianBaoHanh;
	}
	
}
