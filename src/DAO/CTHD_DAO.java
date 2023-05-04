package DAO;

import DB.JDBCConnection;
import DTO.CTHD;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class CTHD_DAO {

    public List<CTHD> getAllCTHD() {
        List<CTHD> cts = new ArrayList<CTHD>();

        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM CTHD";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CTHD ct = new CTHD();

                ct.setMaHD(rs.getString("MaHD"));
                ct.setMaSP(rs.getString("MaSP"));
                ct.setSoLuong(rs.getInt("SoLuong"));

                cts.add(ct);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cts;
    }

    public List<CTHD> getCTHDbyID(String id) {
        List<CTHD> cts = new ArrayList<CTHD>();

        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM CTHD WHERE MAHD=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CTHD ct = new CTHD();

                ct.setMaHD(rs.getString("MaHD"));
                ct.setMaSP(rs.getString("MaSP"));
                ct.setSoLuong(rs.getInt("SoLuong"));

                cts.add(ct);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cts;
    }

    public void addCTHD(CTHD ct) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO CTHD VALUES (?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ct.getMaHD());
            ps.setString(2, ct.getMaSP());
            ps.setInt(3, ct.getSoLuong());
            int rs = ps.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCTHD(CTHD ct) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE CTHD SET SOLUONG=? WHERE MAHD=? AND MASP=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ct.getSoLuong());
            ps.setString(2, ct.getMaHD());
            ps.setString(3, ct.getMaSP());
            int rs = ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCTHD(String id) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "DELETE FROM CTHD WHERE MAHD=?";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            int rs = ps.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean hasCTHD (String idHD, String idSP){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM CTHD WHERE MAHD=? AND MASP=?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idHD);
            ps.setString(2, idSP);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) return true;
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
