package DTO;
public class LoaiTK {
    private int maLTK;
    private String tenLTK;

    public int getMaLTK() {
        return maLTK;
    }

    public void setMaLTK(int maLTK) {
        this.maLTK = maLTK;
    }

    public String getTenLTK() {
        return tenLTK;
    }

    public void setTenLTK(String tenLTK) {
        this.tenLTK = tenLTK;
    }
    
    public String write(){
        return "("+ getMaLTK()+ ", "+ getTenLTK()+ ")";
    }
}
