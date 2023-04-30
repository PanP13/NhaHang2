package DTO;
public class LoaiBan {
    private String maLB;
    private int soGhe;

    public String getMaLB() {
        return maLB;
    }

    public void setMaLB(String maLB) {
        this.maLB = maLB;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }
    
    public String write(){
        String s = String.format("(%s, %s)", getMaLB(), getSoGhe());
        return s;
    }
}
