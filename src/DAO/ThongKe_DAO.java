package DAO;

import DB.JDBCConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ThongKe_DAO {

    public String getTK() {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM TKE";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            String s = "";
            if (rs.next()) {
                s = String.format("%d,%d,%d,%d,%d",
                        rs.getInt("TONGKH"),
                        rs.getInt("TONGNV"),
                        rs.getInt("TONGBAN"),
                        rs.getInt("TONGSP"),
                        rs.getInt("TONGHD"));
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
}
