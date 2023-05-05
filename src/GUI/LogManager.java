package GUI;

import java.io.File;  // Import the File class
import java.io.FileReader;
import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;

public class LogManager {

    public static void write(String log) {
        try {
            File myObj = new File("C:\\Users\\panpa\\OneDrive\\Máy tính\\Code\\Java\\NhaHang2\\log.txt");
            FileWriter writer = new FileWriter(myObj);
            
            writer.write(log);
            writer.close();
            
            System.out.println("Done!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public static String read(){
        String s = "";
        try{
            File myObj = new File("C:\\Users\\panpa\\OneDrive\\Máy tính\\Code\\Java\\NhaHang2\\log.txt");
            Scanner sc = new Scanner(myObj);    
            while(sc.hasNextLine()){
                s = s + sc.nextLine() + "\n";
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        return s;
    }
}
