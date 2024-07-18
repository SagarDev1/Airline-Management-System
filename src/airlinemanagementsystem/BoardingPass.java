package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class BoardingPass extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    JLabel tfname, tfnationality, lblsrc, lbldest, labelfname, labelfcode, labeldate;
    JButton fetchButton;
    
    public BoardingPass() {
       // getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         
        ImageIcon bgic = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/plane1.jpg"));
        Image i22 = bgic.getImage().getScaledInstance(1060, 500, Image.SCALE_DEFAULT);  //scaling down image
        ImageIcon bgimage = new ImageIcon(i22);
        JLabel image2 = new JLabel(bgimage);
        image2.setBounds(0,0 , 1060, 500);
        add(image2);
        
        JLabel heading = new JLabel("SKYZEN AIRLINES");
        heading.setBounds(380, 10, 450, 35);
        heading.setFont(new Font("Monospaced", Font.BOLD, 34));
        //heading.setForeground(Color.ORANGE);\
        heading.setForeground(new Color(255, 71, 26));
        image2.add(heading);
        
        JLabel subheading = new JLabel("Boarding Pass");
        subheading.setBounds(443, 50, 300, 30);
        subheading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        //subheading.setForeground(Color.RED);
        subheading.setForeground(new Color(57, 230, 0));
        image2.add(subheading);
        
        
        JLabel subheading1 = new JLabel("--------------------------------------------------------------");
        subheading1.setBounds(350,45, 1000, 13);
        subheading1.setFont(new Font("Tahoma", Font.BOLD, 13));
        subheading1.setForeground(new Color(255, 255, 26));
        image2.add(subheading1);
        
        
        JLabel lblaadhar = new JLabel("PNR DETAILS");
        lblaadhar.setBounds(60, 100, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblaadhar.setForeground(new Color(179, 255, 255));
        image2.add(lblaadhar);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 100, 150, 25);
        image2.add(tfpnr);
        
        fetchButton = new JButton("Enter");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 100, 120, 25);
        fetchButton.addActionListener(this);
        image2.add(fetchButton);
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 140, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblname.setForeground(new Color(179, 255, 255));
        image2.add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 140, 150, 25);
        image2.add(tfname);
        
        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnationality.setForeground(new Color(179, 255, 255));
        image2.add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        image2.add(tfnationality);
        
        JLabel lbladdress = new JLabel("SRC");
        lbladdress.setBounds(60, 220, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        image2.add(lbladdress);
        
        lblsrc = new JLabel();
        lblsrc.setBounds(220, 220, 150, 25);
        image2.add(lblsrc);
        
        JLabel lblgender = new JLabel("DEST");
        lblgender.setBounds(380, 220, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        image2.add(lblgender);
        
        lbldest = new JLabel();
        lbldest.setBounds(540, 220, 150, 25);
        image2.add(lbldest);
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 260, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        image2.add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220, 260, 150, 25);
        image2.add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(380, 260, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        image2.add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(540, 260, 150, 25);
        image2.add(labelfcode);
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 300, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        image2.add(lbldate);
        
        labeldate = new JLabel();
        labeldate.setBounds(220, 300, 150, 25);
        image2.add(labeldate);
        
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
//        Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
//        ImageIcon image = new ImageIcon(i2);
//        JLabel lblimage = new JLabel(image);
//        lblimage.setBounds(600, 0, 300, 300);
//        add(lblimage);
        
        setSize(1000, 450);
        setLocation(145, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String pnr = tfpnr.getText();

        try {
            Conn conn = new Conn();

            String query = "select * from reservation where PNR = '"+pnr+"'";

            ResultSet rs = conn.s.executeQuery(query);

            if (rs.next()) {
                tfname.setText(rs.getString("name")); 
                tfnationality.setText(rs.getString("nationality")); 
                lblsrc.setText(rs.getString("src")); 
                lbldest.setText(rs.getString("des"));  
                labelfname.setText(rs.getString("flightname"));  
                labelfcode.setText(rs.getString("flightcode"));  
                labeldate.setText(rs.getString("ddate")); 
            } else {
                JOptionPane.showMessageDialog(null, "Please enter correct PNR");                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BoardingPass();
    }
}