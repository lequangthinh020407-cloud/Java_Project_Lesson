package lequangthinh25654411;
import java.time.LocalDate;

public abstract class KhachHang {
   protected String maKhachHang;
   protected String hoTen;
   protected LocalDate ngayLapHoaDon;
   protected double soKW;
   protected double donGia;
   protected double ThanhTien;

   public String getMaKhachHang() {
      return this.maKhachHang;
   }

   public void setMaKhachHang(String maKhachHang) {
      this.maKhachHang = maKhachHang;
   }

   public String getHoTen() {
      return this.hoTen;
   }

   public void setHoTen(String hoTen) {
      this.hoTen = hoTen;
   }

   public LocalDate getNgay() throws Exception {
      if (this.ngayLapHoaDon.isBefore(LocalDate.now())) {
         return this.ngayLapHoaDon;
      } else {
         throw new Exception("Loi!");
      }
   }

   public void setNgayLapHoaDon(LocalDate ngayLapHoaDon) {
      this.ngayLapHoaDon = ngayLapHoaDon;
   }

   public double getSoKW() {
      return this.soKW;
   }

   public void setSoKW(double soKW) {
      this.soKW = soKW;
   }

   public double getDonGia() {
      return this.donGia;
   }

   public void setDonGia(double donGia) {
      this.donGia = donGia;
   }

   public float ThanhTien() {
      return (float)(this.getDonGia() * this.getSoKW());
   }

   public KhachHang(String maKhachHang, String hoTen, LocalDate ngayLapHoaDon, double soKW, double donGia) {
      this.ThanhTien = this.donGia * this.soKW;
      this.maKhachHang = maKhachHang;
      this.hoTen = hoTen;
      this.ngayLapHoaDon = ngayLapHoaDon;
      this.soKW = soKW;
      this.donGia = donGia;
   }

   public KhachHang() {
      this.ThanhTien = this.donGia * this.soKW;
   }

   public String toString() {
      return String.format("%s | %s | Ngay: %s | TT: %,.0f", this.maKhachHang, this.hoTen, this.ngayLapHoaDon, this.ThanhTien());
   }
}
