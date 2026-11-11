package leQuangThinh25654411;

public class PhongHocTN extends PhongHoc {
    private String chuyenNganh;
    private int sucChua;
    private boolean coBonRua;

    public PhongHocTN(String maPhong, String dayNha, double dienTich, int soBongDen, String chuyenNganh, int sucChua, boolean coBonRua) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.chuyenNganh = chuyenNganh;
        this.sucChua = sucChua;
        this.coBonRua = coBonRua;
    }

    public String getChuyenNganh() { return chuyenNganh; }
    public void setChuyenNganh(String chuyenNganh) { this.chuyenNganh = chuyenNganh; }
    public int getSucChua() { return sucChua; }
    public void setSucChua(int sucChua) { this.sucChua = sucChua; }
    public boolean isCoBonRua() { return coBonRua; }
    public void setCoBonRua(boolean coBonRua) { this.coBonRua = coBonRua; }

    @Override
    public boolean datChuan() {
        boolean duAnhSang = (soBongDen > 0) && (dienTich / soBongDen <= 10);
        return duAnhSang && coBonRua;
    }

    @Override
    public String toString() {
        return super.toString() + " [Loại: Thí nghiệm, Chuyên ngành: " + chuyenNganh + ", Sức chứa: " + sucChua + ", Bồn rửa: " + (coBonRua ? "Có" : "Không") + ", Đạt chuẩn: " + (datChuan() ? "Đạt" : "Không") + "]";
    }
}
