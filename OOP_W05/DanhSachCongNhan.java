

public class DanhSachCongNhan {
    private int capacity = 0;
    private int size = 0;
    private CongNhan[] employees;

    public DanhSachCongNhan() {
        this.capacity = capacity=Integer.MAX_VALUE-1;
        this.employees = new CongNhan[this.capacity];
    }

    public DanhSachCongNhan(int capacity) {
        if (capacity<=0 || capacity>=Integer.MAX_VALUE) capacity=Integer.MAX_VALUE-1;

        this.capacity = capacity;
        this.employees = new CongNhan[this.capacity];
    }

    public void addNew(String mHo, String mTen, int mSoSP) {
        if (this.size >= capacity) {
            System.err.println("[-] Them moi khong thanh cong.");
        } else {
            CongNhan cn = new CongNhan(mHo, mTen, mSoSP);

            this.employees[this.size] = cn;
            this.size++;

            System.err.println("[+] Them moi thanh cong.");
        }
    }

    public void getAll() {
        for (CongNhan employee : this.employees) {
            System.out.println(employee.toString());
            System.out.println("=================");
        }
    }

    public int getSize() {
        return this.size;
    }

    public void getEmployee200() {
        for (CongNhan employee : this.employees) {
            int soLuong = Integer.parseInt(employee.getter("mSoSP", false));

            if (soLuong >= 200) {
                System.out.println(employee.toString());
                System.out.println("=================");
            }
        }
    }

    public void sortEmployees() {
        int n = this.size;
        for (int i = 0; i < n - 1; i++) {
            int idx = i;

            for (int j = i + 1; j < n; j++) {
                int sp1 = Integer.parseInt(this.employees[j].getter("mSoSP", false));
                int sp2 = Integer.parseInt(this.employees[idx].getter("mSoSP", false));

                if (sp1 > sp2) {
                    idx = j;
                }
            }

            CongNhan temp = this.employees[i];
            this.employees[i] = this.employees[idx];
            this.employees[idx] = temp;           
        }
    }
}
