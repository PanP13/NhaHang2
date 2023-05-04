package BUS;

import DAO.TaiKhoan_DAO;
import DTO.TaiKhoan;
import java.util.List;

public class TaiKhoan_BUS {
    private TaiKhoan_DAO daoTK;
    
    public TaiKhoan_BUS(){
        daoTK = new TaiKhoan_DAO();
    }
    
    public List<TaiKhoan> getAllTK(){
        return daoTK.getAllTK();
    }
    
    public TaiKhoan getTKbyUser(String id){
        return daoTK.getTaiKhoanbyID(id);
    }
    
    public void addTK(TaiKhoan tk){
        daoTK.addTK(tk);
    }
    
    public void updateTK(TaiKhoan tk){
        daoTK.updateTK(tk);
    }
    
    public void deleteTK(String id){
        daoTK.deleteTK(id);
    }
    
    public TaiKhoan getTK (String username, String password){
        return daoTK.getTK(username, password);
    }
}
