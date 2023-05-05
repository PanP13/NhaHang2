package DTO;

import java.util.Date;

public class LichSu {
    private int id, hanhDong;
    private String taiKhoan, chiTiet;
    private Date thoiGian;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHanhDong() {
        return hanhDong;
    }

    public void setHanhDong(int hanhDong) {
        this.hanhDong = hanhDong;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    @Override
    public String toString() {
        return "LichSu{" + "id=" + id + ", hanhDong=" + hanhDong + ", taiKhoan=" + taiKhoan + ", chiTiet=" + chiTiet + ", thoiGian=" + thoiGian + '}';
    }
    
}
