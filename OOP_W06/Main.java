package lequangthinh25654411;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    // ================= KHAI BÁO =================
    static Scanner sc = new Scanner(System.in);
    // Đối tượng quản lý danh sách thực phẩm
    static QuanLyThucPham ql = new QuanLyThucPham();
    // Định dạng ngày
    static DateTimeFormatter df =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");


    // ================= MAIN =================
    public static void main(String[] args) {

        // Nạp dữ liệu mẫu
        duLieuMau();

        int chon = -1;
        do {
            menu();
            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
                continue;
            }

            switch (chon) {

                case 1:
                    themThucPham();
                    break;

                case 2:
                    xoaThucPham();
                    break;

                case 3:
                    suaThucPham();
                    break;

                case 4:
                    ql.hienThiDanhSach();
                    break;

                case 5:
                    sapXepMenu();
                    break;

                case 6:
                    timKiemMenu();
                    break;

                case 7:
                    trichLocTheoNgay();
                    break;

                case 8:
                    thongKe();
                    break;

                case 0:
                    System.out.println(
                            "Tạm biệt!"
                    );
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (chon != 0);

        sc.close();
    }


    // ================= MENU =================

    static void menu() {

        System.out.println(
                "\n╔════════════ QUẢN LÝ THỰC PHẨM ════════════╗"
        );
        System.out.println(
                "║  1. Thêm thực phẩm                        ║"
        );
        System.out.println(
                "║  2. Xóa theo ID                           ║"
        );
        System.out.println(
                "║  3. Sửa theo ID                           ║"
        );
        System.out.println(
                "║  4. Hiển thị danh sách                    ║"
        );
        System.out.println(
                "║  5. Sắp xếp                               ║"
        );
        System.out.println(
                "║  6. Tìm kiếm theo tên                     ║"
        );
        System.out.println(
                "║  7. Trích lọc theo khoảng ngày            ║"
        );
        System.out.println(
                "║  8. Thống kê                              ║"
        );
        System.out.println(
                "║  0. Thoát                                 ║"
        );
        System.out.println(
                "╚═══════════════════════════════════════════╝"
        );
        System.out.print("Chọn: ");
    }


    // ================= DỮ LIỆU MẪU =================

    static void duLieuMau() {

        HangThucPham h1 =
                new HangThucPham(
                        "TP001",
                        "Sữa tươi Vinamilk",
                        LocalDate.of(2026, 1, 15),
                        LocalDate.of(2026, 10, 15),
                        25000
                );

        HangThucPham h2 =
                new HangThucPham(
                        "TP002",
                        "Bánh quy Oreo",
                        LocalDate.of(2026, 3, 5),
                        LocalDate.of(2026, 12, 5),
                        15000
                );

        HangThucPham h3 =
                new HangThucPham(
                        "TP003",
                        "Nước ngọt Coca",
                        LocalDate.of(2026, 1, 20),
                        LocalDate.of(2026, 9, 20),
                        12000
                );

        HangThucPham h4 =
                new HangThucPham(
                        "TP004",
                        "Sữa chua TH True",
                        LocalDate.of(2026, 5, 10),
                        LocalDate.of(2026, 10, 25),
                        8000
                );

        HangThucPham h5 =
                new HangThucPham(
                        "TP005",
                        "Bánh mì Kinh Đô",
                        LocalDate.of(2026, 8, 1),
                        LocalDate.of(2026, 10, 15),
                        20000
                );

        // Thêm vào QuanLyThucPham
        ql.them(h1);
        ql.them(h2);
        ql.them(h3);
        ql.them(h4);
        ql.them(h5);

        System.out.println(
                "Đã nạp 5 sản phẩm mẫu."
        );
    }


    // ================= THÊM THỰC PHẨM =================

    static void themThucPham() {
        try {
            System.out.print("Mã hàng: ");
            String ma = sc.nextLine();
            System.out.print("Tên hàng: ");
            String ten = sc.nextLine();
            System.out.print("Ngày SX (dd/MM/yyyy): ");
            LocalDate ngaySanXuat =LocalDate.parse(sc.nextLine(),df);
            System.out.print("Ngày HH (dd/MM/yyyy): ");
            LocalDate ngayHetHan =LocalDate.parse(sc.nextLine(),df);
            System.out.print("Giá: ");
            float gia =Float.parseFloat(sc.nextLine());

            // Tạo đối tượng HangThucPham
            HangThucPham h =new HangThucPham(ma,ten,ngaySanXuat,ngayHetHan,gia);

            // Đưa HangThucPham vào QuanLyThucPham
            if (ql.them(h)) {
                System.out.println("Thêm thành công!");
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage()
            );
        }
    }


    // ================= XÓA THỰC PHẨM =================

    static void xoaThucPham() {

        try {
            System.out.print("Nhập ID cần xóa: ");
            int id =Integer.parseInt(sc.nextLine());
            if (ql.xoa(id)) {
                System.out.println("Đã xóa ID " + id);
            }
        } catch (NumberFormatException e) {
            System.out.println("ID phải là số!");
        }
    }

    // ================= SỬA THỰC PHẨM =================

    static void suaThucPham() {
        try {
            System.out.print("Nhập ID cần sửa: ");
            int id =Integer.parseInt(sc.nextLine());

            // Kiểm tra ID trước
            HangThucPham h =ql.timTheoId(id);
            if (h == null) {
                System.out.println("Không tìm thấy sản phẩm có ID "+ id);
                return;
            }
            System.out.println("Thông tin hiện tại:");
            System.out.println(h);
            System.out.print("Tên mới: ");
            String tenMoi =sc.nextLine();
            System.out.print("Ngày SX mới (dd/MM/yyyy): ");
            LocalDate ngaySXMoi =LocalDate.parse(sc.nextLine(),df);
            System.out.print("Ngày HH mới (dd/MM/yyyy): ");
            LocalDate ngayHHMoi =LocalDate.parse(sc.nextLine(),df);
            System.out.print("Giá mới: ");
            float giaMoi =Float.parseFloat(sc.nextLine());
            if (ql.sua(id,tenMoi,ngaySXMoi,ngayHHMoi,giaMoi)) {
                System.out.println("Đã sửa ID " + id);
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }


    // ================= MENU SẮP XẾP =================

    static void sapXepMenu() {
        System.out.println("\na. Giá tăng");

        System.out.println("b. Giá giảm");

        System.out.println("c. Ngày SX tăng");

        System.out.println("d. Ngày SX giảm");

        System.out.println("e. Ngày HH tăng");

        System.out.println("f. Ngày HH giảm");

        System.out.println("g. ID tăng");

        System.out.println("h. ID giảm");

        System.out.print("Chọn: ");
        String chon =sc.nextLine().toLowerCase();
        switch (chon) {
            case "a":
                ql.sapXepTheoGia(true);
                break;
                
            case "b":
                ql.sapXepTheoGia(false);
                break;

            case "c":
                ql.sapXepTheoNgaySanXuat(true);
                break;

            case "d":
                ql.sapXepTheoNgaySanXuat(false);
                break;

            case "e":
                ql.sapXepTheoNgayHetHan(true);
                break;

            case "f":
                ql.sapXepTheoNgayHetHan(false);
                break;

            case "g":
                ql.sapXepTheoId(true);
                break;

            case "h":
                ql.sapXepTheoId(false);
                break;

            default:
                System.out.println("Không hợp lệ!");
                return;
        }
        ql.hienThiDanhSach();
    }


    // ================= MENU TÌM KIẾM =================

    static void timKiemMenu() {

        System.out.println("\na. Tiền tố (bắt đầu)");

        System.out.println("b. Hậu tố (kết thúc)");

        System.out.println("c. Gần giống (chứa)");

        System.out.print("Chọn: ");
        String chon =sc.nextLine().toLowerCase();
        System.out.print("Nhập từ khóa: ");

        String tuKhoa =sc.nextLine();
        QuanLyThucPham ketQua;

        switch (chon) {
            case "a":
                ketQua =ql.timTheoTienTo(tuKhoa);
                break;

            case "b":
                ketQua =ql.timTheoHauTo(tuKhoa);
                break;

            case "c":
                ketQua =ql.timGanGiong(tuKhoa);
                break;

            default:
                System.out.println("Không hợp lệ!");
                return;
        }

        System.out.println("Tìm thấy "+ ketQua.laySoLuong()+ " kết quả:");
        ketQua.hienThiDanhSach();
    }


    // ================= TRÍCH LỌC THEO NGÀY =================

    static void trichLocTheoNgay() {

        try {

            System.out.println("\na. Lọc theo ngày SX");
            System.out.println("b. Lọc theo ngày HH");
            System.out.print("Chọn: ");
            String chon =sc.nextLine().toLowerCase();
            System.out.print("Từ ngày (dd/MM/yyyy): ");
            LocalDate tuNgay =LocalDate.parse(sc.nextLine(),df);
            System.out.print("Đến ngày (dd/MM/yyyy): ");
            LocalDate denNgay =LocalDate.parse(sc.nextLine(),df);
            QuanLyThucPham ketQua;
            if (chon.equals("a")) {
                ketQua =ql.trichLocTheoNgaySanXuat(tuNgay,denNgay);

            } else if (chon.equals("b")) {
                ketQua =ql.trichLocTheoNgayHetHan(tuNgay,denNgay);
            } else {

                System.out.println("Không hợp lệ!");
                return;
            }

            System.out.println("Trích lọc được "+ ketQua.laySoLuong()+ " kết quả:");
            ketQua.hienThiDanhSach();
        } catch (Exception e) {

            System.out.println("Lỗi: " + e.getMessage());
        }
    }


    // ================= THỐNG KÊ =================

    static void thongKe() {
        System.out.println("\n========== THỐNG KÊ ==========");
        int tongSoLuong =ql.tinhTongSoLuong();
        double tongGiaTri =ql.tinhTongGiaTri();
        System.out.println("Tổng số sản phẩm: "+ tongSoLuong);
        System.out.printf("Tổng giá trị: %,.0f VNĐ%n",tongGiaTri);
        if (tongSoLuong > 0) {
            System.out.printf("Giá trung bình: %,.0f VNĐ%n",tongGiaTri / tongSoLuong);
        }
        // Thống kê theo tháng sản xuất
        ql.thongKeTheoThang();
    }
}
