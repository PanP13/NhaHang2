/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.HoaDon;
import javax.swing.JFrame;

/**
 *
 * @author panpa
 */
public class CTHDManager {
    static JFrame frame1;
    static JFrame frame2;

    public static JFrame getFrame1()
    {
        if(frame1 == null)
            frame1 = new DatHang_GUI();
        return frame1;
    }

    public static JFrame getFrame2(HoaDon hd)
    {
        if(frame2!=null){
            frame2.dispose();
        }
        frame2 = new DatHang_GUI(hd);
        return frame2;
    }
}
