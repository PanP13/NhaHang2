package DTO;

import java.util.Date;

public class HoaDon {

    private String maHD, maKH, maNV, maBan;
    private int trangThai;
    private Date thoiGian;

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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maHD=" + maHD + ", maKH=" + maKH + ", maNV=" + maNV + ", maBan=" + maBan + ", trangThai=" + trangThai + ", thoiGian=" + thoiGian + '}';
    }
    
    public String toString2(){
        String s = String.format("%s,%s,%s,%s,%d,%s", maHD, maKH, maNV, maBan, trangThai, thoiGian.toString());
        return s;
    }
}
