package DAO;

import DB.JDBCConnection;
import DTO.LichSu;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class LichSu_DAO {

    public List<LichSu> getAllLS() {
        List<LichSu> ls = new ArrayList<>();

        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM LICHSU";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                LichSu l = new LichSu();
                l.setId(rs.getInt("ID"));
                l.setTaiKhoan(rs.getString("TaiKhoan"));
                l.setHanhDong(rs.getInt("ThanhDong"));
                l.setChiTiet(rs.getString("ChiTiet"));
                l.setThoiGian(rs.getDate("ThoiGian"));
                ls.add(l);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    public List<LichSu> getLSbyUser(String user) {
        List<LichSu> ls = new ArrayList<>();

        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM LICHSU WHERE TaiKhoan=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                LichSu l = new LichSu();
                l.setId(rs.getInt("ID"));
                l.setTaiKhoan(rs.getString("TaiKhoan"));
                l.setHanhDong(rs.getInt("ThanhDong"));
                l.setChiTiet(rs.getString("ChiTiet"));
                l.setThoiGian(rs.getDate("ThoiGian"));
                ls.add(l);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    public List<LichSu> getLSbyModel(String model) {
        List<LichSu> ls = new ArrayList<>();

        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM LICHSU WHERE HanhDong=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, model);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                LichSu l = new LichSu();
                l.setId(rs.getInt("ID"));
                l.setTaiKhoan(rs.getString("TaiKhoan"));
                l.setHanhDong(rs.getInt("ThanhDong"));
                l.setChiTiet(rs.getString("ChiTiet"));
                l.setThoiGian(rs.getDate("ThoiGian"));
                ls.add(l);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    public void addLS (LichSu ls){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO LICHSU VALUES (?, ?, ?, ?)";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ls.getTaiKhoan());
            ps.setInt(2, ls.getHanhDong());
            ps.setString(3, ls.getChiTiet());
            //ps.setDate(4, (Date) ls.getThoiGian());
            int rs = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
