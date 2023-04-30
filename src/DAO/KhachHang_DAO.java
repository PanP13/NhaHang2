package DAO;

import DB.JDBCConnection;
import DTO.KhachHang;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class KhachHang_DAO {
    public List<KhachHang>getAllKH(){
        List<KhachHang> khs = new ArrayList<KhachHang>();
        
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM KhachHang";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                KhachHang kh = new KhachHang();
                
                kh.setMaKH(rs.getString("MaKH"));
                kh.setHoTen(rs.getString("HoTen"));
                kh.setGioiTinh(rs.getInt("GioiTinh"));
                kh.setSdt(rs.getString("Phone"));
                kh.setEmail(rs.getString("Email"));
                kh.setDiaChi(rs.getString("DiaChi"));
                
                khs.add(kh);
            }
            
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return khs;
    }
    
    public KhachHang getKHbyID(String maKH){
        Connection conn = JDBCConnection.getJDBCConnection();
        
        String sql = "SELECT * FROM KHACHHANG WHERE MAKH=?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maKH);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                KhachHang kh = new KhachHang();
                
                kh.setMaKH(rs.getString("MaKH"));
                kh.setHoTen(rs.getString("HOTEN"));
                kh.setGioiTinh(rs.getInt("GIOITINH"));
                kh.setSdt(rs.getString("Phone"));
                kh.setEmail(rs.getString("Email"));
                kh.setDiaChi(rs.getString("DiaChi"));
                
                return kh;
            }
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return null;
    }
    
    public void addKH(KhachHang kh){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO KHACHHANG VALUES (?,?,?,?,?,?)";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kh.getMaKH());
            ps.setString(2, kh.getHoTen());
            ps.setInt(3, kh.getGioiTinh());
            ps.setString(4, kh.getSdt());
            ps.setString(5, kh.getEmail());
            ps.setString(6,kh.getDiaChi());
            
            int rs = ps.executeUpdate();
            System.out.println(rs);
            
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void updateKH(KhachHang kh){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE KHACHHANG SET HOTEN=?, GIOITINH=?, PHONE=?, EMAIL=?, DIACHI=? WHERE MAKH=?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kh.getHoTen());
            ps.setInt(2, kh.getGioiTinh());
            ps.setString(3, kh.getSdt());
            ps.setString(4, kh.getEmail());
            ps.setString(5, kh.getDiaChi());
            ps.setString(6, kh.getMaKH());
            
            int rs = ps.executeUpdate();
            System.out.println(rs);
            
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void deleteKH(String maKH){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "DELETE FROM KHACHHANG WHERE MAKH=?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maKH);
            
            int rs = ps.executeUpdate();
            System.out.println(rs);
            
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public List<KhachHang> searchKH(String s, int t){
        List<KhachHang> khs = new ArrayList<KhachHang>();
        
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql="SELECT * FROM KHACHHANG";
        switch(t){
            case 0: sql = "SELECT * FROM KHACHHANG WHERE MAKH LIKE '%"+s+"%'"; break;
            case 1: sql = "SELECT * FROM KHACHHANG WHERE HOTEN LIKE '%"+s+"%'"; break;
            case 2: sql = "SELECT * FROM KHACHHANG WHERE GIOITINH="+s; break;
            case 3: sql = "SELECT * FROM KHACHHANG WHERE PHONE LIKE '%"+s+"%'"; break;
            case 4: sql = "SELECT * FROM KHACHHANG WHERE EMAIL LIKE '%"+s+"%'"; break;
            case 5: sql = "SELECT * FROM KHACHHANG WHERE DIACHI LIKE '%"+s+"%'"; break;
            default: break;
        }
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("MaKH"));
                kh.setHoTen(rs.getString("HoTen"));
                kh.setGioiTinh(rs.getInt("GioiTinh"));
                kh.setSdt(rs.getString("Phone"));
                kh.setEmail(rs.getString("Email"));
                kh.setDiaChi(rs.getString("DiaChi"));
                
                khs.add(kh);
            }
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return khs;
    }
}
