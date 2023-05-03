package DTO;
public class LoaiBan {
    private int maLB, soGhe;

    public int getMaLB() {
        return maLB;
    }

    public void setMaLB(int maLB) {
        this.maLB = maLB;
    }
    public int getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }
    
    public String write(){
        String s = String.format("(%d, %d)", getMaLB(), getSoGhe());
        return s;
    }
}
