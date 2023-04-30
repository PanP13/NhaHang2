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
                b.setMaLB(rs.getString("MaLB"));

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
                b.setMaLB(rs.getString("MaLB"));
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
        String sql = "INSERT INTO BAN VALUES (?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, b.getMaBan());
            ps.setString(2, b.getTenBan());
            ps.setString(3, b.getMaLB());
            int rs = ps.executeUpdate();
            System.out.println(rs);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBan(Ban b) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE BAN SET TenBan=?, MaLB=? WHERE MaBan=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, b.getTenBan());
            ps.setString(2, b.getMaLB());
            ps.setString(3, b.getMaBan());
            int rs = ps.executeUpdate();
            System.out.println(rs);
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
            System.out.println(rs);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ban> searchBan(String s, int t) {
        List<Ban> bs = new ArrayList<Ban>();

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
            //case 3: sql = "SELECT * FROM BAN WHERE PHONE LIKE '%"+s+"%'"; break;
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
                b.setMaLB(rs.getString("MaLB"));

                bs.add(b);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bs;
    }
}
