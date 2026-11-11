
import java.util.Scanner;

public class Main{
    public static void menu() {
        System.out.println("\n===== QUAN LY CONG NHAN =====");
        System.out.println("1. Hien thi tat ca cong nhan");
        System.out.println("2. Hien thi cong nhan co tu 200 san pham");
        System.out.println("3. Sap xep giam dan theo so san pham");
        System.out.println("0. Thoat");
        System.out.print("Lua chon: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so luong cong nhan: ");
        int numberOfEmployees = sc.nextInt();
        while (numberOfEmployees <= 0) {
            System.out.print("So luong phai lon hon 0. Nhap lai: ");
            numberOfEmployees = sc.nextInt();
        }

        DanhSachCongNhan employees = new DanhSachCongNhan(numberOfEmployees);
        sc.nextLine();

        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.println("\nCong nhan thu " + (i + 1) + ":");
            System.out.print("Nhap ho: ");
            String lastName = sc.nextLine();
            System.out.print("Nhap ten: ");
            String firstName = sc.nextLine();
            System.out.print("Nhap so san pham: ");
            int products = sc.nextInt();
            sc.nextLine();

            employees.addNew(lastName, firstName, products);
        }

        while (true) {
            menu();
            int choose = sc.nextInt();

            switch (choose) {
                case 1:
                    employees.getAll();
                    break;
                case 2:
                    employees.getEmployee200();
                    break;
                case 3:
                    employees.sortEmployees();
                    System.out.println("Da sap xep giam dan theo so san pham.");
                    employees.getAll();
                    break;
                case 0:
                    sc.close();
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }
}
