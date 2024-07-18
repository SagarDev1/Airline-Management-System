package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class JourneyDetails extends JFrame implements ActionListener{
    JTable table;
    JTextField pnr;
    JButton show;
    
    
    public JourneyDetails(){
        
        //getContentPane().setBackground(Color.RED);
        
        setLayout(null);
        
        ImageIcon bgic = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/bg5.jpg"));
        Image i22 = bgic.getImage().getScaledInstance(1290, 900, Image.SCALE_DEFAULT);  //scaling down image
        ImageIcon bgimage = new ImageIcon(i22);
        JLabel image2 = new JLabel(bgimage);
        image2.setBounds(0,0 , 800, 600);
        add(image2);
        
        JLabel lblpnr = new JLabel("PNR Details");
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN,16));
        lblpnr.setForeground(Color.WHITE);
        lblpnr.setBounds(50,50,100,25);
        image2.add(lblpnr);
        pnr = new JTextField();
        pnr.setBounds(160,50,120,25);
        image2.add(pnr);
        
        show = new JButton("Show Details");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(290,50,120,25);
        show.addActionListener(this);
        image2.add(show);
        
        
        table = new JTable();
        
        
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,800,150);
        //jsp.setBackground(Color.WHITE);
        image2.add(jsp);
        
//        table.setBounds(0,0,800,500);
//        add(table);
        
        setSize(800,600);
        setLocation(240,65);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from reservation where PNR = '"+pnr.getText()+"'");
            
            if(!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null,"No Information Found!");
                return;
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
                    
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
        new JourneyDetails();
    
    }
}
