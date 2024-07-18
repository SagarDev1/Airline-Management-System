package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class FlightInfo extends JFrame {
    public FlightInfo(){
        
        //getContentPane().setBackground(Color.CYAN);
        setLayout(null);
        
        ImageIcon bgic = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/bg5.jpg"));
        Image i22 = bgic.getImage().getScaledInstance(1290, 900, Image.SCALE_DEFAULT);  //scaling down image
        ImageIcon bgimage = new ImageIcon(i22);
        JLabel image2 = new JLabel(bgimage);
        image2.setBounds(0,0 , 800, 500);
        add(image2);
        
        JTable table = new JTable();
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from flight");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            image2.add(table);
           
            
                    
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,0,800,500);
        image2.add(jsp);
        
//        table.setBounds(0,0,800,500);
//        add(table);
        
        setSize(800,500);
        setLocation(240,69);
        setVisible(true);
    }


    public static void main(String[] args){
        new FlightInfo();
    
    }
}
