package BUS;

import DAO.LoaiBan_DAO;
import DTO.LoaiBan;
import java.util.List;

public class LoaiBan_BUS {
    private LoaiBan_DAO daoLB;
    
    public LoaiBan_BUS(){
        daoLB = new LoaiBan_DAO();
    }
    
    public List<LoaiBan>getAllLB(){
        return daoLB.getAllLB();
    }
    
    public LoaiBan getBanbyID(String id){
        return daoLB.getLBbyID(id);
    }
}
