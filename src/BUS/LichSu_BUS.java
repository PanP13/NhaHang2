package BUS;

import DAO.LichSu_DAO;
import DTO.LichSu;
import java.util.List;

public class LichSu_BUS {
    LichSu_DAO daoLS;

    public LichSu_BUS() {
        daoLS = new LichSu_DAO();
    }
    
    public List<LichSu> getAllLS(){
        return daoLS.getAllLS();
    }
    
    public List<LichSu> getLSbyUser(String user){
        return daoLS.getLSbyUser(user);
    }
    
    public List<LichSu> getLSbyModel(String model){
        return daoLS.getLSbyModel(model);
    }
    
    public void addLS(LichSu ls){
        daoLS.addLS(ls);
    }
}
