package DAO;
import DB.JDBCConnection;
import DTO.LoaiTK;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class LoaiTK_DAO {
    public List<LoaiTK> getAllLTK(){
        List<LoaiTK> ls = new ArrayList<>();
        
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM LOAITK";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                LoaiTK l = new LoaiTK();
                l.setMaLTK(rs.getInt("MaLTK"));
                l.setTenLTK(rs.getString("TenLTK"));
                
                ls.add(l);
            }
            
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return ls;
    }
    
    public LoaiTK getLTKbyID(int id){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM LOAITK WHERE MALTK=?";
        
        try{
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                LoaiTK l = new LoaiTK();
                l.setMaLTK(rs.getInt("MaLTK"));
                l.setTenLTK(rs.getString("TenLTK"));
                
                conn.close();
                return l;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
