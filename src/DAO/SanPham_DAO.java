package DAO;

import DB.JDBCConnection;
import DTO.SanPham;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SanPham_DAO {

    public List<SanPham> getAllSP() {
        List<SanPham> sps = new ArrayList<>();

        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM SANPHAM";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setDonGia(rs.getInt("DonGia"));
                sp.setMaLSP(rs.getInt("MaLSP"));

                sps.add(sp);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sps;
    }

    public SanPham getSPbyID(String id) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM SANPHAM WHERE MASP=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setDonGia(rs.getInt("DonGia"));
                sp.setMaLSP(rs.getInt("MaLSP"));

                conn.close();
                return sp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addSP(SanPham sp) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO SANPHAM VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getTenSP());
            ps.setInt(3, sp.getDonGia());
            ps.setInt(4, sp.getMaLSP());
            int rs = ps.executeUpdate();
            conn.close();
            System.out.println("Add success!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSP(SanPham sp) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE SANPHAM SET TENSP=?, DONGIA=?, MALSP=? WHERE MASP=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, sp.getTenSP());
            ps.setInt(2, sp.getDonGia());
            ps.setInt(3, sp.getMaLSP());
            ps.setString(4, sp.getMaSP());
            int rs = ps.executeUpdate();
            conn.close();
            System.out.println("Update success!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSP(String id) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "DELETE FROM SANPHAM WHERE MASP=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            int rs = ps.executeUpdate();
            conn.close();
            System.out.println("Delete success!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<SanPham> searchSP(String s, int t) {
        List<SanPham> sps = new ArrayList<>();

        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM SANPHAM";
        switch (t) {
            case 0:
                sql = "SELECT * FROM SANPHAM WHERE MASP LIKE '%" + s + "%'";
                break;
            case 1:
                sql = "SELECT * FROM SANPHAM WHERE TENSP LIKE '%" + s + "%'";
                break;
            case 2:
                sql = "SELECT * FROM SANPHAM WHERE DONGIA=" + s;
                break;
            case 3:
                sql = "SELECT * FROM SANPHAM WHERE MALSP LIKE '%" + s + "%'";
                break;
            default:
                break;
        }

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setString(1, s);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setDonGia(rs.getInt("DonGia"));
                sp.setMaLSP(rs.getInt("MaLSP"));

                sps.add(sp);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sps;
    }

    public void deleteCTHD(String id){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "DELETE FROM CTHD WHERE MASP=?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            
            int rs = ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
