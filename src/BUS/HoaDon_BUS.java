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
    
    public void addHD(HoaDon hd){
        daoHD.addHD(hd);
    }
    
    public void updateHD(HoaDon hd){
        daoHD.updateHD(hd);
    }
    
    public void deleteHD(String id){
        daoHD.deleteHD(id);
    }
    
    public List<HoaDon> searchHD(String s, int t){
        return daoHD.searchHD(s, t);
    }
    
    public List<String> getView(){
        return daoHD.getView();
    }
}
