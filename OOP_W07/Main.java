package lequangthinh25654411;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
   public Main() {
   }

   public static void main(String[] args) {
      ArrayList<KhachHang> ds = new ArrayList();
      KhachHang kh1 = new KhachHangVN("VN01", "Nguyen Van An", LocalDate.of(2026, 9, 10), (double)150.0F, (double)2000.0F, "Sinh hoat", (double)100.0F);
      KhachHang kh2 = new KhachHangVN("VN02", "Tran Thi Binh", LocalDate.of(2026, 9, 15), (double)80.0F, (double)2000.0F, "Kinh doanh", (double)100.0F);
      KhachHang kh3 = new KhachHangNuocNgoai("NN01", "John Smith", LocalDate.of(2026, 9, 20), (double)200.0F, (double)3000.0F, "My");
      ds.add(kh1);
      ds.add(kh2);
      ds.add(kh3);
      System.out.println("===== DANH SACH KHACH HANG =====");

      for(KhachHang kh : ds) {
         System.out.println(kh);
      }

      double tongTien = (double)0.0F;

      for(KhachHang kh : ds) {
         tongTien += (double)kh.ThanhTien();
      }

      System.out.printf("%nTong tien tat ca hoa don: %,.0f VND%n", tongTien);
   }
}
