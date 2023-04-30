package BUS;

import DAO.CTHD_DAO;
import DTO.CTHD;
import java.util.List;

public class CTHD_BUS {
    private CTHD_DAO daoCTHD;
    
    public CTHD_BUS(){
        daoCTHD = new CTHD_DAO();
    }
    
    public List<CTHD> getAllCTHD(){
        return daoCTHD.getAllCTHD();
    }
    
    public List<CTHD> getCTHDbyID(String id){
        return daoCTHD.getCTHDbyID(id);
    }
    
    public void addCTHD(List<CTHD> cts){
        daoCTHD.addCTHD(cts);
    }
    
    public void updateCTHD(List<CTHD> cts){
        daoCTHD.updateCTHD(cts);
    }
    
    public void deleteCTHD(String id){
        daoCTHD.deleteCTHD(id);
    }
} 
