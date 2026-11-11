package leQuangThinh25654411;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListPhongHoc ql = new ListPhongHoc();
        Scanner sc = new Scanner(System.in);
        
        // Thêm sẵn dữ liệu mẫu để dễ test
        ql.themPhongHoc(new PhongHocLyThuyet("LT01", "Dãy A", 80, 9, true)); // Đạt chuẩn (80/9 <= 10 và có máy chiếu)
        ql.themPhongHoc(new PhongHocLyThuyet("LT02", "Dãy C", 50, 4, false)); // Không đạt chuẩn (thiếu máy chiếu)
        ql.themPhongHoc(new PhongHocMayTinh("MT01", "Dãy B", 90, 10, 60)); // Đạt chuẩn (90/10<=10 và 90/60>=1.5)
        ql.themPhongHoc(new PhongHocTN("TN01", "Dãy A", 60, 5, "Hóa học", 30, true)); // Đạt chuẩn

        int luaChon;
        do {
            System.out.println("\n===== MENU QUẢN LÝ PHÒNG HỌC =====");
            System.out.println("1. Xuất toàn bộ danh sách phòng học");
            System.out.println("2. Tìm kiếm phòng học theo mã phòng");
            System.out.println("3. Xuất danh sách phòng học đạt chuẩn");
            System.out.println("4. Sắp xếp danh sách tăng dần theo dãy nhà");
            System.out.println("5. Sắp xếp danh sách giảm dần theo diện tích");
            System.out.println("6. Sắp xếp danh sách tăng dần theo số bóng đèn");
            System.out.println("7. Cập nhật số máy tính cho phòng máy tính");
            System.out.println("8. Xóa một phòng học (có xác nhận)");
            System.out.println("9. Xem tổng số phòng học");
            System.out.println("10. Xuất các phòng máy tính có đúng 60 máy");
            System.out.println("0. Thoát chương trình");
            System.out.print("Mời bạn chọn chức năng (0-10): ");
            luaChon = sc.nextInt();
            sc.nextLine(); // Xóa bộ nhớ đệm
            
            switch (luaChon) {
                case 1:
                    System.out.println("--- TOÀN BỘ DANH SÁCH PHÒNG HỌC ---");
                    for (PhongHoc p : ql.getToanBoDanhSach()) {
                        System.out.println(p);
                    }
                    break;
                case 2:
                    System.out.print("Nhập mã phòng cần tìm: ");
                    String maTim = sc.nextLine();
                    PhongHoc pTim = ql.timPhongHoc(maTim);
                    if (pTim != null) {
                        System.out.println("Kết quả tìm kiếm: " + pTim);
                    } else {
                        System.out.println("Không tìm thấy phòng học có mã: " + maTim);
                    }
                    break;
                case 3:
                    System.out.println("--- DANH SÁCH PHÒNG HỌC ĐẠT CHUẨN ---");
                    for (PhongHoc p : ql.getDanhSachDatChuan()) {
                        System.out.println(p);
                    }
                    break;
                case 4:
                    ql.sapXepTheoDayNha();
                    System.out.println("Đã sắp xếp tăng dần theo dãy nhà thành công! Chọn 1 để xem lại.");
                    break;
                case 5:
                    ql.sapXepTheoDienTichGiamDan();
                    System.out.println("Đã sắp xếp giảm dần theo diện tích thành công! Chọn 1 để xem lại.");
                    break;
                case 6:
                    ql.sapXepTheoSoBongDen();
                    System.out.println("Đã sắp xếp tăng dần theo số bóng đèn thành công! Chọn 1 để xem lại.");
                    break;
                case 7:
                    System.out.print("Nhập mã phòng máy tính cần cập nhật: ");
                    String maCapNhat = sc.nextLine();
                    System.out.print("Nhập số máy tính mới: ");
                    int soMayMoi = sc.nextInt();
                    if (ql.capNhatSoMayTinh(maCapNhat, soMayMoi)) {
                        System.out.println("Cập nhật số máy tính thành công!");
                    } else {
                        System.out.println("Cập nhật thất bại (Không tìm thấy phòng hoặc phòng không phải phòng máy tính)!");
                    }
                    break;
                case 8:
                    System.out.print("Nhập mã phòng cần xóa: ");
                    String maXoa = sc.nextLine();
                    PhongHoc pXoa = ql.timPhongHoc(maXoa);
                    if (pXoa != null) {
                        System.out.print("Bạn có CHẮC CHẮN muốn xóa phòng " + maXoa + " không? (Y/N): ");
                        String xacNhan = sc.nextLine();
                        if (xacNhan.equalsIgnoreCase("Y")) {
                            ql.xoaPhongHoc(maXoa);
                            System.out.println("Đã xóa thành công phòng học!");
                        } else {
                            System.out.println("Đã hủy bỏ thao tác xóa.");
                        }
                    } else {
                        System.out.println("Không tìm thấy phòng học mã " + maXoa + " để xóa.");
                    }
                    break;
                case 9:
                    System.out.println("Tổng số phòng học hiện tại: " + ql.tinhTongSoPhongHoc() + " phòng.");
                    break;
                case 10:
                    System.out.println("--- DANH SÁCH PHÒNG MÁY TÍNH CÓ ĐÚNG 60 MÁY ---");
                    for (PhongHocMayTinh pm : ql.getDanhSachPhongMay60May()) {
                        System.out.println(pm);
                    }
                    break;
                case 0:
                    System.out.println("Đang thoát chương trình... Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (luaChon != 0);
        
        sc.close();
    }
}
