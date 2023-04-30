package DAO;

import DB.JDBCConnection;
import DTO.NhanVien;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class NhanVien_DAO {
    public List<NhanVien>getAllNV(){
        List<NhanVien> nvs = new ArrayList<NhanVien>();
        
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM NhanVien";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                NhanVien nv = new NhanVien();
                
                nv.setMaNV(rs.getString("MaNV"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setGioiTinh(rs.getInt("GioiTinh"));
                nv.setSdt(rs.getString("Phone"));
                nv.setEmail(rs.getString("Email"));
                nv.setDiaChi(rs.getString("DiaChi"));
                
                nvs.add(nv);
            }
            
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return nvs;
    }
    
    public NhanVien getNVbyID(String id){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM NhanVien WHERE MaNV=?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            NhanVien nv = new NhanVien();
            nv.setMaNV(rs.getString("MaNV"));
            nv.setHoTen(rs.getString("HoTen"));
            nv.setGioiTinh(rs.getInt("GioiTinh"));
            nv.setSdt(rs.getString("Phone"));
            nv.setEmail(rs.getString("Email"));
            nv.setDiaChi(rs.getString("DiaChi"));
            
            conn.close();
            return nv;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return null;
    }
    
    public void addNV(NhanVien nv){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO NhanVien VALUES (?,?,?,?,?,?)";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getHoTen());
            ps.setInt(3,nv.getGioiTinh());
            ps.setString(4, nv.getSdt());
            ps.setString(5, nv.getEmail());
            ps.setString(6, nv.getDiaChi());
            
            int rs = ps.executeUpdate();
            System.out.println(rs);
            
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void updateNV(NhanVien nv){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE NHANVIEN SET HOTEN=?, GIOITINH=?, PHONE=?, EMAIL=?, DIACHI=? WHERE MaNV=?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getHoTen());
            ps.setInt(2, nv.getGioiTinh());
            ps.setString(3, nv.getSdt());
            ps.setString(4, nv.getEmail());
            ps.setString(5, nv.getDiaChi());
            ps.setString(6, nv.getMaNV());
            
            int rs = ps.executeUpdate();
            System.out.println(rs);
            
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void delNV(String id){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "DELETE FROM NHANVIEN WHERE MaNV=?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            int rs = ps.executeUpdate();
            System.out.println(rs);
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public List<NhanVien> searchNV(String s, int t){
        List<NhanVien> nvs = new ArrayList<NhanVien>();
        
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql="SELECT * FROM NHANVIEN";
        switch(t){
            case 0: sql = "SELECT * FROM NHANVIEN WHERE MANV LIKE '%"+s+"%'"; break;
            case 1: sql = "SELECT * FROM NHANVIEN WHERE HOTEN LIKE '%"+s+"%'"; break;
            case 2: sql = "SELECT * FROM NHANVIEN WHERE GIOITINH="+s; break;
            case 3: sql = "SELECT * FROM NHANVIEN WHERE PHONE LIKE '%"+s+"%'"; break;
            case 4: sql = "SELECT * FROM NHANVIEN WHERE EMAIL LIKE '%"+s+"%'"; break;
            case 5: sql = "SELECT * FROM NHANVIEN WHERE DIACHI LIKE '%"+s+"%'"; break;
            default: break;
        }
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setGioiTinh(rs.getInt("GioiTinh"));
                nv.setSdt(rs.getString("Phone"));
                nv.setEmail(rs.getString("Email"));
                nv.setDiaChi(rs.getString("DiaChi"));
                
                nvs.add(nv);
            }
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return nvs;
    }
}
