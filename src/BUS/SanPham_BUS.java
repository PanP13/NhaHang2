package BUS;

import DAO.SanPham_DAO;
import DTO.SanPham;
import java.util.List;

public class SanPham_BUS {
    private SanPham_DAO daoSP;
    
    public SanPham_BUS(){
        daoSP = new SanPham_DAO();
    }
    
    public List<SanPham> getAllSP(){
        return daoSP.getAllSP();
    }
    
    public SanPham getSPbyID(String maSP){
        return daoSP.getSPbyID(maSP);
    }
    
    public void addSP(SanPham sp){
        daoSP.addSP(sp);
    }
    
    public void updateSP(SanPham sp){
        daoSP.updateSP(sp);
    }
    
    public void deleteSP(String maSP){
        daoSP.deleteSP(maSP);
    }
    
    public List<String> searchSP(String s, int t){
        return daoSP.searchSP(s, t);
    }
    
    public void deleteCTHD (String id) {
        daoSP.deleteCTHD(id);
    }
    
    public List<String> getSP(){
        return daoSP.getSP();
    }
}
