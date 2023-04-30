package BUS;

import DAO.LoaiSP_DAO;
import DTO.LoaiSP;
import java.util.List;

public class LoaiSP_BUS {
    private LoaiSP_DAO daoLSP;
    
    public LoaiSP_BUS(){
        daoLSP = new LoaiSP_DAO();
    }
    
    public List<LoaiSP> getAllLSP(){
        return daoLSP.getAllLSP();
    }
    
    public LoaiSP getLSPbyID(String id){
        return daoLSP.getLSPbyID(id);
    }
}
