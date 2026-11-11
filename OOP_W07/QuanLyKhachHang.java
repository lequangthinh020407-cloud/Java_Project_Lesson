package lequangthinh25654411;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuanLyKhachHang {
   List<KhachHang> ls;

   public QuanLyKhachHang() {
   }

   public void QUANLYKH() {
      this.ls = new ArrayList(2);
   }

   public Boolean themKH(KhachHang kh) {
      return this.ls.contains(kh) ? false : this.ls.add(kh);
   }

   public boolean CapNhat(String ma, double gia) {
      Iterator var5 = this.ls.iterator();
      if (var5.hasNext()) {
         KhachHang kh = (KhachHang)var5.next();
         if (kh.getMaKhachHang().equalsIgnoreCase(ma)) {
            kh.setDonGia(gia);
         }

         return true;
      } else {
         return true;
      }
   }

   public boolean XoaMa(String ma) {
      for(KhachHang kh : this.ls) {
         if (kh.getMaKhachHang().equalsIgnoreCase(ma)) {
            this.ls.remove(kh);
            return true;
         }
      }

      return true;
   }
}
