package BUS;

import DAO.LoaiTK_DAO;
import DTO.LoaiTK;
import java.util.List;

public class LoaiTK_BUS {
    private LoaiTK_DAO daoLTK;
    
    public LoaiTK_BUS(){
        daoLTK = new LoaiTK_DAO();
    }
    
    public List<LoaiTK> getAllLTK(){
        return daoLTK.getAllLTK();
    }
    
    public LoaiTK getLTKbyID(int id){
        return daoLTK.getLTKbyID(id);
    }
}
