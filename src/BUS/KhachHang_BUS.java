package BUS;

import DAO.KhachHang_DAO;
import DTO.KhachHang;
import java.util.List;

public class KhachHang_BUS {
    private KhachHang_DAO daoKH;
    
    public KhachHang_BUS(){
        daoKH = new KhachHang_DAO();
    }
    
    public List<KhachHang>getAllKH(){
        return daoKH.getAllKH();
    }
    
    public KhachHang getKHbyID(String maKH){
        return daoKH.getKHbyID(maKH);
    }
    
    public void addKH(KhachHang kh){
        daoKH.addKH(kh);
    }
    
    public void updateKH(KhachHang kh){
        daoKH.updateKH(kh);
    }
    
    public void deleteKH(String maKH){
        daoKH.deleteKH(maKH);
    }
    
    public List<KhachHang> searchKH(String s, int t){
        return daoKH.searchKH(s, t);
    }
}
