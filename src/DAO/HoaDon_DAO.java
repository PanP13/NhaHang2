package DAO;

import DB.JDBCConnection;
import DTO.HoaDon;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoaDon_DAO {

    public List<HoaDon> getAllHD() {
        List<HoaDon> hds = new ArrayList<HoaDon>();

        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM HOADON";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                HoaDon hd = new HoaDon();

                hd.setMaHD(rs.getString("MaHD"));
                hd.setMaKH(rs.getString("MaKH"));
                hd.setMaNV(rs.getString("MaNV"));
                hd.setMaBan(rs.getString("MaBan"));

                hds.add(hd);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hds;
    }

    public HoaDon getHDbyID(String id) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM HOADON WHERE MAHD=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setMaKH(rs.getString("MaKH"));
                hd.setMaNV(rs.getString("MaNV"));
                hd.setMaBan(rs.getString("MaBan"));

                conn.close();
                return hd;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void addHD(HoaDon hd){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO HOADON(MAHD, MAKH, MANV, MABAN) VALUES (?,?,?,?)";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getMaHD());
            ps.setString(2, hd.getMaKH());
            ps.setString(3, hd.getMaNV());
            ps.setString(4, hd.getMaBan());
            
            int rs = ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void updateHD (HoaDon hd){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE HOADON SET MAKH=?, MANV=?, MABAN=? WHERE MAHD=?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getMaKH());
            ps.setString(2, hd.getMaNV());
            ps.setString(3, hd.getMaBan());
            ps.setString(4, hd.getMaHD());
            
            int rs = ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void deleteHD (String id){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "DELETE FROM HOADON WHERE MAHD=?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            
            int rs = ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public List<HoaDon> searchHD(String s, int t){
        List<HoaDon> hds = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "";
        
        switch(t){
            case 0: sql="SELECT * FROM HOADON WHERE MAHD LIKE '%" + s +"%'"; break;
            case 1: sql="SELECT * FROM HOADON WHERE MAKH LIKE '%" + s +"%'"; break;
            case 2: sql="SELECT * FROM HOADON WHERE MANV LIKE '%" + s +"%'"; break;
            case 3: sql="SELECT * FROM HOADON WHERE MABAN LIKE '%" + s +"%'"; break;
            default: break;
        }
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setString(1, s);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setMaKH(rs.getString("MaKH"));
                hd.setMaNV(rs.getString("MaNV"));
                hd.setMaBan(rs.getString("MaBan"));
                
                hds.add(hd);
            }
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return hds;
    }
}
