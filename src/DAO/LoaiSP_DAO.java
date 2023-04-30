package DAO;

import DB.JDBCConnection;
import DTO.LoaiSP;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class LoaiSP_DAO {
    public List<LoaiSP>getAllLSP(){
        List<LoaiSP> ls = new ArrayList<LoaiSP>();
        
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM LOAISP";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                LoaiSP l = new LoaiSP();
                
                l.setMaLSP(rs.getString("MaLSP"));
                l.setTenLSP(rs.getString("TenLSP"));
                
                ls.add(l);
            }
            
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return ls;
    }
    
    public LoaiSP getLSPbyID(String id){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM LOAISP WHERE MALSP=?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            
            LoaiSP l = new LoaiSP();
            l.setMaLSP(rs.getString("MaLSP"));
            l.setTenLSP(rs.getString("TenLSP"));
            
            conn.close();
            return l;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return null;
    }
}
