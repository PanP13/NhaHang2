package DAO;

import DB.JDBCConnection;
import DTO.TaiKhoan;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class TaiKhoan_DAO {

    public List<TaiKhoan> getAllTK() {
        List<TaiKhoan> tks = new ArrayList<>();

        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM TaiKhoan";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();

                tk.setIdTK(rs.getInt("IDTK"));
                tk.setUsername(rs.getString("TenDN"));
                tk.setPassword(rs.getString("MatKhau"));
                tk.setLoaiTK(rs.getInt("MaLTK"));
                tk.setMaTK(rs.getString("MaTK"));

                tks.add(tk);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tks;
    }

    public TaiKhoan getTaiKhoanbyID(String id) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM TAIKHOAN WHERE MaTK=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setIdTK(rs.getInt("IDTK"));
                tk.setUsername(rs.getString("TenDN"));
                tk.setPassword(rs.getString("MatKhau"));
                tk.setLoaiTK(rs.getInt("MaLTK"));
                tk.setMaTK(rs.getString("MaTK"));

                conn.close();
                return tk;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addTK(TaiKhoan tk) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO TAIKHOAN(TENDN, MATKHAU, MALTK, MATK) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tk.getUsername());
            ps.setString(2, tk.getPassword());
            ps.setInt(3, tk.getLoaiTK());
            ps.setString(4, tk.getMaTK());

            int rs = ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTK(TaiKhoan tk) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE TAIKHOAN SET TENDN=?, MATKHAU=?, MALTK=? WHERE MATK=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tk.getUsername());
            ps.setString(2, tk.getPassword());
            ps.setInt(3, tk.getLoaiTK());
            ps.setString(4, tk.getMaTK());

            int rs = ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTK(String id) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "DELETE FROM TAIKHOAN WHERE MaTK=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            int rs = ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public TaiKhoan getTK (String username, String password){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM TAIKHOAN WHERE TenDN=? AND MatKhau=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setIdTK(rs.getInt("IDTK"));
                tk.setUsername(rs.getString("TenDN"));
                tk.setPassword(rs.getString("MatKhau"));
                tk.setLoaiTK(rs.getInt("MaLTK"));
                tk.setMaTK(rs.getString("MaTK"));

                conn.close();
                return tk;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
