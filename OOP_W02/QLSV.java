package QLSV;

import java.util.Scanner;

public class Main {
   public Main() {
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      SV sv1 = new SV(1001, "Nguyen Van A", (double)8.5F, (double)9.0F);
      SV sv2 = new SV(1002, "Tran Van B", (double)7.5F, (double)8.0F);
      SV sv3 = new SV();
      System.out.print("Nhap ma SV: ");
      int maSV = sc.nextInt();
      sc.nextLine();
      System.out.print("Nhap ho ten: ");
      String hoTen = sc.nextLine();
      System.out.print("Nhap diem LT: ");
      double diemLT = sc.nextDouble();
      System.out.print("Nhap diem TH: ");
      double diemTH = sc.nextDouble();
      sv3.setMaSV(maSV);
      sv3.setHoTen(hoTen);
      sv3.setDiemLT(diemLT);
      sv3.setDiemTH(diemTH);
      System.out.println("\nDANH SACH SINH VIEN");
      System.out.println("MSSV\tHo ten\tDiem LT\tDiem TH\tDiem TB");
      System.out.println(sv1);
      System.out.println(sv2);
      System.out.println(sv3);
      sc.close();
   }
}
