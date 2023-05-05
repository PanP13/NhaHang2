package DAO;

import DB.JDBCConnection;
import DTO.Ban;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class Ban_DAO {

    public List<Ban> getAllBan() {
        List<Ban> bs = new ArrayList<Ban>();

        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM BAN";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ban b = new Ban();

                b.setMaBan(rs.getString("MaBan"));
                b.setTenBan(rs.getString("TenBan"));
                b.setMaLB(rs.getInt("MaLB"));
                b.setTrangThai(rs.getInt("TrangThai"));

                bs.add(b);
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bs;
    }

    public Ban getBanbyID(String id) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM BAN WHERE MABAN=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ban b = new Ban();
                b.setMaBan(rs.getString("MaBan"));
                b.setTenBan(rs.getString("TenBan"));
                b.setMaLB(rs.getInt("MaLB"));
                b.setTrangThai(rs.getInt("TrangThai"));
                conn.close();
                return b;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addBan(Ban b) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO BAN VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, b.getMaBan());
            ps.setString(2, b.getTenBan());
            ps.setInt(3, b.getMaLB());
            ps.setInt(4, b.getTrangThai());
            int rs = ps.executeUpdate();
            System.out.println(rs);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBan(Ban b) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE BAN SET TenBan=?, TrangThai=?, MaLB=? WHERE MaBan=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, b.getTenBan());
            ps.setInt(2, b.getTrangThai());
            ps.setInt(3, b.getMaLB());
            ps.setString(4, b.getMaBan());
            int rs = ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBan(String id) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "DELETE FROM BAN WHERE MaBan=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            int rs = ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ban> searchBan(String s, int t) {
        List<Ban> bs = new ArrayList<>();

        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "";
        switch (t) {
            case 0:
                sql = "SELECT * FROM BAN WHERE MABAN LIKE '%" + s + "%'";
                break;
            case 1:
                sql = "SELECT * FROM BAN WHERE TENBAN LIKE '%" + s + "%'";
                break;
            case 2:
                sql = "SELECT * FROM BAN WHERE MALB LIKE '%" + s + "%'";
                break;
            case 3:
                sql = "SELECT * FROM BAN WHERE TRANGTHAI LIKE '%" + s + "%'";
                break;
            default:
                break;
        }

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setString(1, s);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ban b = new Ban();
                b.setMaBan(rs.getString("MaBan"));
                b.setTenBan(rs.getString("TenBan"));
                b.setMaLB(rs.getInt("MaLB"));
                b.setTrangThai(rs.getInt("TrangThai"));

                bs.add(b);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bs;
    }

    public boolean getHD(String id) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM HOADON WHERE MaBan=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<String> getBan(){
        List<String> bs = new ArrayList<>();
        for(Ban i : getAllBan()){
            String trangThai = i.getTrangThai()==0? "Trống" : "Bận",
                    loaiBan = i.getMaLB()==0? "2" : i.getMaLB()==1? "4" : i.getMaLB()==2? "8" : "16";
            String b = String.format("%s,%s,%s,%s", i.getMaBan(), i.getTenBan(), trangThai, loaiBan);
            bs.add(b);
        }
        return bs;
    }
}
