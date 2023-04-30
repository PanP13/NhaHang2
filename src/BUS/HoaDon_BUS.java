package BUS;

import DAO.HoaDon_DAO;
import DTO.HoaDon;
import java.util.List;

public class HoaDon_BUS {
    private HoaDon_DAO daoHD;
    
    public HoaDon_BUS(){
        daoHD = new HoaDon_DAO();
    }
    
    public List<HoaDon> getAllHD(){
        return daoHD.getAllHD();
    }
    
    public HoaDon getHDbyID(String id){
        return daoHD.getHDbyID(id);
    }
}
