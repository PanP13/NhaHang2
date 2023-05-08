package GUI;

import DTO.HoaDon;
import DTO.TaiKhoan;
import javax.swing.JFrame;

public class CTHDManager {
    static JFrame frame1;
    static JFrame frame2;

    public static JFrame getFrame1(TaiKhoan user)
    {
        if(frame1 != null)
            frame1.dispose();
        frame1 = new DatHang_GUI(user);
        return frame1;
    }

    public static JFrame getFrame2(TaiKhoan user, HoaDon hd)
    {
        if(frame2!=null){
            frame2.dispose();
        }
        frame2 = new DatHang_GUI(user, hd);
        return frame2;
    }
}
