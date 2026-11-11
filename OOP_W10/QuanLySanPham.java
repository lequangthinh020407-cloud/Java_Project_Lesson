package lequangthinh25654411;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLySanPham {
	private List<SanPham> danhSachSP;

	public QuanLySanPham(List<SanPham> danhSachSP) {
		super();
		this.danhSachSP = new ArrayList<SanPham>();
	}
	public boolean themSanPham(SanPham sp) {
		boolean trungMa = danhSachSP.stream().anyMatch(s->s.getMaSP().equalsIgnoreCase(sp.getMaSP()));
		if(trungMa) {
			return false;
		}
		danhSachSP.add(sp);
		System.out.println("Them thanh cong");
		return true;
	}
	public boolean xoaSanPham(String maSP) {
		boolean xoa = danhSachSP.removeIf(s->s.getMaSP().equalsIgnoreCase(maSP));
		if(xoa) {
			System.out.println("Xoa thanh cong");
			return true;
		}
		return false;
	}
//	public boolean suaSoLuongTon(String maSP, int soLuongMoi) {
//		
//		
//	}
	public void xuatSanPhamTheoLoai(String loai) {
		List<SanPham> kq = new ArrayList<SanPham>();
		if(loai.equalsIgnoreCase("Dien tu")) {
			kq = danhSachSP.stream().filter(s->s instanceof SanPhamDienTu).collect(Collectors.toList());
		}
		else if(loai.equalsIgnoreCase("Thuc pham")) {
			kq = danhSachSP.stream().filter(s->s instanceof SanPhamThucPham).collect(Collectors.toList());
		}
	}
	public void xuatSanPhamGiaBanCaoNhat() {
		if(danhSachSP.isEmpty()) {
			return;
		}
		SanPham spMax = danhSachSP.stream().max(s1, s2)->Double.compare(s1.tinhGiaBan(), s2.tinhGiaBan()).orElse(Null);
	}
	
}
