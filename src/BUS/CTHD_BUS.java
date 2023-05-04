package BUS;

import DAO.CTHD_DAO;
import DTO.CTHD;
import java.util.List;

public class CTHD_BUS {

    private CTHD_DAO daoCTHD;

    public CTHD_BUS() {
        daoCTHD = new CTHD_DAO();
    }

    public List<CTHD> getAllCTHD() {
        return daoCTHD.getAllCTHD();
    }

    public List<CTHD> getCTHDbyID(String id) {
        return daoCTHD.getCTHDbyID(id);
    }

    public void addCTHD(List<CTHD> cts) {
        for (CTHD ct : cts) {
            daoCTHD.addCTHD(ct);
        }
    }

    public void updateCTHD(List<CTHD> cts) {
        for (CTHD ct : cts) {
            if(daoCTHD.hasCTHD(ct.getMaHD(), ct.getMaSP()))
                daoCTHD.updateCTHD(ct);
            else daoCTHD.addCTHD(ct);
        }
    }

    public void deleteCTHD(String id) {
        daoCTHD.deleteCTHD(id);
    }
}
