package DTO;

public class Ban {
    private String maBan;
    private String tenBan;
    private String maLB;

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

    public String getMaLB() {
        return maLB;
    }

    public void setMaLB(String maLB) {
        this.maLB = maLB;
    }
    
    public String write(){
        return "(" + getMaBan() + ", "
                + getTenBan()+ ", "
                + getMaLB()+ ")";
    }
}
