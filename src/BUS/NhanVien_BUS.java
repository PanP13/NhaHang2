package BUS;

import DAO.NhanVien_DAO;
import DTO.NhanVien;
import java.util.List;

public class NhanVien_BUS {
    private NhanVien_DAO daoNV;
    
    public NhanVien_BUS(){
        daoNV = new NhanVien_DAO();
    }
    
    public List<NhanVien>getAllNV(){
        return daoNV.getAllNV();
    }
    
    public NhanVien getNVbyID(String maNV){
        return daoNV.getNVbyID(maNV);
    }
    
    public void addNV(NhanVien nv){
        daoNV.addNV(nv);
    }
    
    public void updateNV(NhanVien nv){
        daoNV.updateNV(nv);
    }
    
    public void deleteNV(String maNV){
        daoNV.delNV(maNV);
    }
    
    public List<NhanVien> searchNV(String s, int t){
        return daoNV.searchNV(s, t);
    }
    
    public boolean getHD(String maNV){
        return daoNV.getHD(maNV);
    }
}
