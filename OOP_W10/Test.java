package lequangthinh25654411;

public class Test {
	public static void main(String[] args) {
		QuanLySanPham ql = new QuanLySanPham();
		SanPhamDienTu dt1 = new SanPhamDienTu("DT01", "Tu lanh", "20/8/2025", 8000000.0, 17, 2);
		SanPhamDienTu dt2 = new SanPhamDienTu("DT02", "May giat", "20/10/2025", 5000000.0, 20, 2);
		SanPhamDienTu dt3 = new SanPhamDienTu("DT03", "May lanh", "7/3/2025", 12000000.0, 8, 2);
		SanPhamThucPham tp1 = new SanPhamThucPham("TP01", "Thit ga", "29/10/2026", 100000.0, 30, 1);
		SanPhamThucPham tp2 = new SanPhamThucPham("TP02", "Thit bo", "29/10/2026", 300000.0, 18, 1);
		
		
		ql.themSanPham(dt1);
		ql.themSanPham(dt2);
		ql.themSanPham(dt3);
		ql.themSanPham(tp1);
		ql.themSanPham(tp2);
		
		ql.xoaSanPham("DT02");
		
		ql.xuatSanPhamTheoLoai("Dien tu");
		ql.xuatSanPhamTheoLoai("Thuc pham");
	}
}
