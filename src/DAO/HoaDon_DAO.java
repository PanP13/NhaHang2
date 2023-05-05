package DAO;

import DB.JDBCConnection;
import DTO.HoaDon;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class HoaDon_DAO {

    public List<HoaDon> getAllHD() {
        List<HoaDon> hds = new ArrayList<>();

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
                hd.setTrangThai(rs.getInt("TrangThai"));
                hd.setThoiGian(rs.getDate("ThoiGian"));

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
                hd.setTrangThai(rs.getInt("TrangThai"));
                hd.setThoiGian(rs.getDate("ThoiGian"));

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
        String sql = "INSERT INTO HOADON VALUES (?,?,?,?,?,?)";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getMaHD());
            ps.setString(2, hd.getMaKH());
            ps.setString(3, hd.getMaNV());
            ps.setString(4, hd.getMaBan());
            ps.setInt(5, hd.getTrangThai());
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            String theDate = hd.getThoiGian() != null ? fmt.format(hd.getThoiGian()) : fmt.format(new Date());
            ps.setString(6, theDate);
            
            int rs = ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void updateHD (HoaDon hd){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE HOADON SET MAKH=?, MANV=?, MABAN=?, TRANGTHAI=?, THOIGIAN=? WHERE MAHD=?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getMaKH());
            ps.setString(2, hd.getMaNV());
            ps.setString(3, hd.getMaBan());
            ps.setInt(4, hd.getTrangThai());
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            String theDate = hd.getThoiGian() != null ? fmt.format(hd.getThoiGian()) : fmt.format(new Date());
            ps.setString(5, theDate);
            ps.setString(6, hd.getMaHD());
            
            ps.executeUpdate();
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
            
            ps.executeUpdate();
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
            case 4: sql="SELECT * FROM HOADON WHERE TRANGTHAI=?"; break;
            default: break;
        }
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            if(t==4) ps.setInt(1, Integer.parseInt(s));
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setMaKH(rs.getString("MaKH"));
                hd.setMaNV(rs.getString("MaNV"));
                hd.setMaBan(rs.getString("MaBan"));
                hd.setTrangThai(rs.getInt("TrangThai"));
                hd.setThoiGian(rs.getDate("ThoiGian"));
                
                hds.add(hd);
            }
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return hds;
    }
    
    public List<String> getView(){
        List<String> hds = new ArrayList<String>();

        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM HDTong";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
                String date = fmt.format(rs.getDate("ThoiGian"));
                String hd = String.format("%s,%s,%s,%s,%d,%s,%d",
                        rs.getString("MaHD"), 
                        rs.getString("MaKH"),
                        rs.getString("MaNV"),
                        rs.getString("MaBan"),
                        rs.getInt("TrangThai"),
                        date,rs.getInt("TongTien"));
                hds.add(hd);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hds;
    }
}
