package lequangthinh25654411;

import java.time.LocalDate;

public abstract class SanPham {
	protected String maSP, tenSP;
	protected LocalDate ngaySanXuat;
	protected double giaNhap;
	protected int soLuongTonKho;
	public SanPham(String maSP, String tenSP, LocalDate ngaySanXuat, double giaNhap, int soLuongTonKho) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.ngaySanXuat = ngaySanXuat;
		this.giaNhap = giaNhap;
		this.soLuongTonKho = soLuongTonKho;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}
	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}
	public double getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}
	public int getSoLuongTonKho() {
		return soLuongTonKho;
	}
	public void setSoLuongTonKho(int soLuongTonKho) {
		this.soLuongTonKho = soLuongTonKho;
	}
	@Override
	public String toString() {
		return "|Ma SP = "+maSP+" | Ten SP = "+tenSP+" |Ngay san xuat = " + ngaySanXuat + "| Gia nhap = " + giaNhap
				+ "| So luong ton kho = "+soLuongTonKho+ "|";
	}
	
	
}
