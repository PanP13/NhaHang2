package BUS;

import DAO.ThongKe_DAO;
import java.util.List;

public class ThongKe_BUS {
    private ThongKe_DAO daoTKE;
    
    public ThongKe_BUS(){
        daoTKE = new ThongKe_DAO();
    }
    
    public String getTongKH(){
        return daoTKE.getTongKH();
    }
    
    public String getTongNV(){
        return daoTKE.getTongNV();
    }
    
    public String getTongBan(){
        return daoTKE.getTongBan();
    }
    
    public String getTongSP(){
        return daoTKE.getTongSP();
    }
    
    public String getTongHD(){
        return daoTKE.getTongHD();
    }
    
    public List<String> getTKHDbyKH(){
        return daoTKE.getTKHDbyKH();
    }
    
    public List<String> getTKHDbySP(){
        return daoTKE.getTKHDbySP();
    }
    
    public String getTong(){
        return daoTKE.getTong();
    }
}
