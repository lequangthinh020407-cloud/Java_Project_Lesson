
# Java_Project_Lesson
package QLSV;

import java.util.Scanner;

public class SV {
   private int maSV;
   private String hoTen;
   private Double diemLT;
   private Double diemTH;

   public int getMaSV() {
      return this.maSV;
   }

   public void setMaSV(int maSV) {
      if (maSV > 0) {
         this.maSV = maSV;
      } else {
         System.out.println("Loi ma < 0");
      }

   }

   public String getHoTen() {
      return this.hoTen;
   }

   public void setHoTen(String hoTen) {
      if (hoTen != null && !hoTen.trim().isEmpty()) {
         this.hoTen = hoTen;
      } else {
         this.hoTen = "";
      }

   }

   public double getDiemLT() {
      return this.diemLT;
   }

   public void setDiemLT(double diemLT) {
      if ((double)0.0F <= diemLT && diemLT <= (double)10.0F) {
         this.diemLT = diemLT;
      } else {
         System.out.println("loi diem < 0");
      }

   }

   public double getDiemTH() {
      return this.diemTH;
   }

   public void setDiemTH(double diemTH) {
      if ((double)0.0F <= diemTH && diemTH <= (double)10.0F) {
         this.diemTH = diemTH;
      } else {
         System.out.println("loi diem < 0");
      }

   }

   public SV(int maSV, String hoTen, double diemLT, double diemTH) {
      this.setMaSV(maSV);
      this.setHoTen(hoTen);
      this.setDiemLT(diemLT);
      this.setDiemTH(diemTH);
   }

   public SV() {
      this.maSV = 0;
      this.hoTen = "";
      this.diemLT = (double)0.0F;
      this.diemTH = (double)0.0F;
   }

   public double getDiemTB() {
      return (this.getDiemLT() + this.getDiemTH()) / (double)2.0F;
   }

   public static SV nhap() {
      Scanner sc = new Scanner(System.in);
      System.out.println("nhap ma SV: ");
      int maSV = sc.nextInt();
      sc.nextLine();
      System.out.println("Nhap ten SV: ");
      String hoTen = sc.nextLine();
      System.out.println("Nhap diem LT");
      Double diemLT = sc.nextDouble();
      System.out.println("Nhap diem TH");
      Double diemTH = sc.nextDouble();
      SV sv = new SV(maSV, hoTen, diemLT, diemTH);
      return sv;
   }

   public String toString() {
      int var10000 = this.maSV;
      return var10000 + "\t" + this.hoTen + "\t" + String.valueOf(this.diemLT) + "\t" + String.valueOf(this.diemTH) + "\t" + this.getDiemTB();
   }
}

