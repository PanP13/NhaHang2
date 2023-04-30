package DTO;

public class HoaDon {
    private String maHD;
    private String maKH;
    private String maNV;
    private String maBan;

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }
    
    public String write(){
        return "(" + getMaHD() + ", "
                + getMaKH()+ ", "
                + getMaNV()+ ", "
                + getMaBan()+ ")";
    }
}
