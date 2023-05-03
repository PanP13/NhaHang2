package DAO;

import DB.JDBCConnection;
import DTO.LoaiBan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoaiBan_DAO {

    public List<LoaiBan> getAllLB() {
        List<LoaiBan> ls = new ArrayList<LoaiBan>();

        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM LOAIBAN";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                LoaiBan l = new LoaiBan();

                l.setMaLB(rs.getInt("MaLB"));
                l.setSoGhe(rs.getInt("SoGhe"));

                ls.add(l);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ls;
    }

    public LoaiBan getLBbyID(String id) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM LOAIBAN WHERE MALB=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                LoaiBan l = new LoaiBan();
                l.setMaLB(rs.getInt("MaLB"));
                l.setSoGhe(rs.getInt("SoGhe"));

                conn.close();
                return l;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
