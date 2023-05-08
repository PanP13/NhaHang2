package DAO;

import DB.JDBCConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ThongKe_DAO {

    public String getTongKH() {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT COUNT(MaKH) AS TONGKH FROM KHACHHANG";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            String s = "";
            if (rs.next()) {
                s = String.valueOf(rs.getInt("TONGKH"));
            }
            conn.close();
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String getTongNV() {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT COUNT(MaNV) AS TONGNV FROM NHANVIEN";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            String s = "";
            if (rs.next()) {
                s = String.valueOf(rs.getInt("TONGNV"));
            }
            conn.close();
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String getTongBan() {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT COUNT(MaBan) AS TONGBAN FROM Ban";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            String s = "";
            if (rs.next()) {
                s = String.valueOf(rs.getInt("TONGBAN"));
            }
            conn.close();
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String getTongSP() {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT COUNT(MaSP) AS TONGSP FROM SANPHAM";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            String s = "";
            if (rs.next()) {
                s = String.valueOf(rs.getInt("TONGSP"));
            }
            conn.close();
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String getTongHD() {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT COUNT(MaHD) AS TONGHD FROM HOADON";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            String s = "";
            if (rs.next()) {
                s = String.valueOf(rs.getInt("TONGHD"));
            }
            conn.close();
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getTKHDbyKH() {
        List<String> khs = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM TKEKH_HD";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String kh = String.format("%s,%d,%d",
                        rs.getString("MaKH"),
                        rs.getInt("SoHD"),
                        rs.getInt("Tong"));
                khs.add(kh);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khs;
    }
    
    public List<String> getTKHDbySP(){
        List<String> sps = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM TKESP_HD";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String sp = String.format("%s,%d,%d,%d",
                        rs.getString("MaSP"),
                        rs.getInt("DonGia"),
                        rs.getInt("SoSP"),
                        rs.getInt("DoanhThu"));
                sps.add(sp);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sps;
    }
    
    public String getTong(){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT SUM(Tong) AS ThanhTien FROM TKEKH_HD";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String tong = rs.getString("ThanhTien");
                return tong;
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
