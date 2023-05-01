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
}
