package BUS;

import DAO.ThongKe_DAO;
import java.util.List;

public class ThongKe_BUS {
    private ThongKe_DAO daoTKE;
    
    public ThongKe_BUS(){
        daoTKE = new ThongKe_DAO();
    }
    
    public String getTK(){
        return daoTKE.getTK();
    }
    
    public List<String> getTKHDbyKH(){
        return daoTKE.getTKHDbyKH();
    }
    
    public List<String> getTKHDbySP(){
        return daoTKE.getTKHDbySP();
    }
}
