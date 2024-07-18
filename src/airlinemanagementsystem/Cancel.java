package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Cancel extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    JLabel tfname, cancellationno, lblfcode, lbldateoftravel;
    JButton fetchButton, flight;
    
    
    public Cancel() {
        //getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         
        ImageIcon bgic = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/bg11.jpg"));
        Image i22 = bgic.getImage().getScaledInstance(1000, 900, Image.SCALE_DEFAULT);  //scaling down image
        ImageIcon bgimage = new ImageIcon(i22);
        JLabel image2 = new JLabel(bgimage);
        image2.setBounds(0,0 , 930, 600);
        add(image2);
        
        Random random = new Random();
        
        
        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(280, 20, 250, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.RED);
        image2.add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(470,120,250,250);
        image2.add(image);
        
        
        JLabel lblaadhar = new JLabel("PNR Number");
        lblaadhar.setBounds(60, 80, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        image2.add(lblaadhar);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 150, 25);
        image2.add(tfpnr);
        
        fetchButton = new JButton("Show Details");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80, 120, 25);
        fetchButton.addActionListener(this);
        image2.add(fetchButton);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        image2.add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        image2.add(tfname);
        
        JLabel lblnationality = new JLabel("Cancellation No.");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        image2.add(lblnationality);
        
        cancellationno = new JLabel("" + random.nextInt(1000000));
        cancellationno.setBounds(220, 180, 150, 25);
        image2.add(cancellationno);
        
        JLabel lbladdress = new JLabel("Flight Code");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        image2.add(lbladdress);
        
        lblfcode = new JLabel();
        lblfcode.setBounds(220, 230, 150, 25);
        image2.add(lblfcode);
        
        JLabel lblgender = new JLabel("Date");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        image2.add(lblgender);
        
        lbldateoftravel = new JLabel();
        lbldateoftravel.setBounds(220, 280, 150, 25);
        image2.add(lbldateoftravel);
        
       
        flight = new JButton("Cancel");
        flight.setBackground(Color.RED);
        flight.setForeground(Color.BLACK);
        flight.setBounds(317,385, 120, 25);
        flight.addActionListener(this);
        image2.add(flight);
        
        
        setSize(800,500);     //frame size and location 
        setLocation(250,94);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetchButton) {
            String pnr = tfpnr.getText();
            
            try {
                Conn conn = new Conn();

                String query = "select * from reservation where PNR = '"+pnr+"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if (rs.next()) {
                    tfname.setText(rs.getString("name")); 
                    lblfcode.setText(rs.getString("flightcode")); 
                    lbldateoftravel.setText(rs.getString("ddate"));
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct PNR!");                
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == flight) {
            String name = tfname.getText();
            String pnr = tfpnr.getText();
            String cancelno = cancellationno.getText();
            String fcode = lblfcode.getText();
            String date = lbldateoftravel.getText();
            
            try {
                Conn conn = new Conn();

                String query = "insert into cancel values('"+pnr+"', '"+name+"', '"+cancelno+"', '"+fcode+"', '"+date+"')";
                conn.s.executeUpdate(query);
                conn.s.executeUpdate("delete from reservation where PNR = '"+pnr+"'");

                
                
                JOptionPane.showMessageDialog(null, "Ticket Cancelled");
                setVisible(false);                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
    }

    public static void main(String[] args) {
        new Cancel();
    }
}