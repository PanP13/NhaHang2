package DTO;

public class LoaiSP {
    private int maLSP;
    private String tenLSP;

    public Integer getMaLSP() {
        return maLSP;
    }

    public void setMaLSP(int maLSP) {
        this.maLSP = maLSP;
    }

    public String getTenLSP() {
        return tenLSP;
    }

    public void setTenLSP(String tenLSP) {
        this.tenLSP = tenLSP;
    }
    
    public String write(){
        String s = String.format("(%d, %s)", getMaLSP(), getTenLSP());
        return s;
    }
}
