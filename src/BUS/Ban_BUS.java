package BUS;

import DAO.Ban_DAO;
import DTO.Ban;
import java.util.List;

public class Ban_BUS {
    private Ban_DAO daoB;
    
    public Ban_BUS(){
        daoB = new Ban_DAO();
    }
    
    public List<Ban> getAllBan(){
        return daoB.getAllBan();
    }
    
    public Ban getBanbyID(String id){
        return daoB.getBanbyID(id);
    }
    
    public void addBan(Ban b){
        daoB.addBan(b);
    }
    
    public void updateBan(Ban b){
        daoB.updateBan(b);
    }
    
    public void deleteBan(String id){
        daoB.deleteBan(id);
    }
    
    public List<Ban> searchBan(String s, int t){
        return daoB.searchBan(s, t);
    }
}
