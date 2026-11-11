package leQuangThinh25654411;

public class PhongHocLyThuyet extends PhongHoc {
    private boolean coMayChieu;

    public PhongHocLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen, boolean coMayChieu) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.coMayChieu = coMayChieu;
    }

    public boolean isCoMayChieu() {
        return coMayChieu;
    }

    public void setCoMayChieu(boolean coMayChieu) {
        this.coMayChieu = coMayChieu;
    }

    @Override
    public boolean datChuan() {
        boolean duAnhSang = (soBongDen > 0) && (dienTich / soBongDen <= 10);
        return duAnhSang && coMayChieu;
    }

    @Override
    public String toString() {
        return super.toString() + " [Loại: Lý thuyết, Có máy chiếu: " + (coMayChieu ? "Có" : "Không") + ", Đạt chuẩn: " + (datChuan() ? "Đạt" : "Không") + "]";
    }
}
