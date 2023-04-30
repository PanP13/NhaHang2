package DAO;

import DB.JDBCConnection;
import DTO.TaiKhoan;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class TaiKhoan_DAO {
    public List<TaiKhoan> getAllTK(){
        List <TaiKhoan> tks = new ArrayList<TaiKhoan>();
        
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM TaiKhoan";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                TaiKhoan tk = new TaiKhoan();
                
                tk.setIdTK(rs.getInt("IDTK"));
                tk.setUsername(rs.getString("TenDN"));
                tk.setPassword(rs.getString("MatKhau"));
                tk.setLoaiTK(rs.getInt("MaLTK"));
                tk.setMaTK(rs.getString("MaTK"));
                
                tks.add(tk);
            }
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return tks;
    }
    
    public TaiKhoan getTaiKhoanbyID(String id){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM TAIKHOAN WHERE id=?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            
            TaiKhoan tk = new TaiKhoan();
            tk.setIdTK(rs.getInt("IDTK"));
            tk.setUsername(rs.getString("TenDN"));
            tk.setPassword(rs.getString("MatKhau"));
            tk.setLoaiTK(rs.getInt("MaLTK"));
            tk.setMaTK(rs.getString("MaTK"));
            
            conn.close();
            return tk;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void addTK(TaiKhoan tk){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO TAIKHOAN(TENDN, MATKHAU, MALTK, MATK) VALUES (?, ?, ?, ?)";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tk.getUsername());
            ps.setString(2, tk.getPassword());
            ps.setInt(3, tk.getLoaiTK());
            ps.setString(4, tk.getMaTK());
            
            int rs = ps.executeUpdate();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void updateTK(TaiKhoan tk){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE TAIKHOAN SET TENDN=?, MATKHAU=?, MALTK=?, MATK=? WHERE IDTK=?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tk.getUsername());
            ps.setString(2, tk.getPassword());
            ps.setInt(3, tk.getLoaiTK());
            ps.setString(4, tk.getMaTK());
            ps.setInt(5, tk.getIdTK());
            
            int rs = ps.executeUpdate();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void deleteTK(String id){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "DELETE FROM TAIKHOAN WHERE IDTK=?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            
            int rs = ps.executeUpdate();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
