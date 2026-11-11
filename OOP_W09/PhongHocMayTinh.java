package leQuangThinh25654411;

public class PhongHocMayTinh extends PhongHoc {
    
    // Bạn có thể giữ lại hoặc xóa constructor 4 tham số này tùy nhu cầu bài toán
    public PhongHocMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen) {
        super(maPhong, dayNha, dienTich, soBongDen);
    }

    public int soMayTinh;

    public PhongHocMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soMayTinh) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.soMayTinh = soMayTinh;
    }

    public int getSoMayTinh() {
        return soMayTinh;
    }

    public void setSoMayTinh(int soMayTinh) {
        this.soMayTinh = soMayTinh;
    }

    
    @Override
    public String toString() {
        return super.toString() + ", soMayTinh=" + soMayTinh;
    }

    
    @Override
    public boolean datChuan() {
        // Điều kiện đạt chuẩn phòng máy tính: Đủ ánh sáng và diện tích bình quân >= 1.5m2/máy
        boolean duAnhSang = (soBongDen > 0) && (dienTich / soBongDen <= 10);
        boolean duMayTinh = (soMayTinh > 0) && (dienTich / soMayTinh >= 1.5);
        
        return duAnhSang && duMayTinh;
    }
}
