package DTO;

public class Ban {
    private String maBan, tenBan;
    private int trangThai, maLB;

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getMaLB() {
        return maLB;
    }

    public void setMaLB(int maLB) {
        this.maLB = maLB;
    }
    public String write(){
        String s = String.format("(%s, %s, %d, %d)", getMaBan(), getTenBan(), getTrangThai(), maLB);
        return s;
    }
}
