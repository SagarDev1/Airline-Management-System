package airlinemanagementsystem;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    
    JTextField tfname, tfphone, tfaadhar, tfnationality, tfaddress, tfemail;   //declaring globally
    JRadioButton rbmale, rbfemale, rbothers;
    
    public AddCustomer(){
        //getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
//        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/bg.jpg"));
//        JLabel image2 = new JLabel(i11);
//        image2.setBounds(0,0,1290,750);
//        add(image2);
        
        ImageIcon bgic = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/bg10.jpg"));
        Image i22 = bgic.getImage().getScaledInstance(1290, 900, Image.SCALE_DEFAULT);  //scaling down image
        ImageIcon bgimage = new ImageIcon(i22);
        JLabel image2 = new JLabel(bgimage);
        image2.setBounds(0,0 , 930, 600);
        add(image2);

        
        
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(270,20,500,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        heading.setForeground(Color.BLUE);
        image2.add(heading);
        
        //-----------FIELDS------------------
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,77,150,20);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        image2.add(lblname);
        
        tfname = new JTextField();    // basically gives a input field from user
        tfname.setBounds(220,78,185,25);
        image2.add(tfname);
        
        
        
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60,127,150,20);
        lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        image2.add(lblnationality);
        
        tfnationality = new JTextField();    // basically gives a input field from user
        tfnationality.setBounds(220,128,185,25);
        image2.add(tfnationality);
        
        
        
        JLabel lblaadhar = new JLabel("Aadhar No.");
        lblaadhar.setBounds(60,185,150,25);
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        image2.add(lblaadhar);
        
        tfaadhar = new JTextField();    // basically gives a input field from user
        tfaadhar.setBounds(220,186,185,25);
        image2.add(tfaadhar);
        
        
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60,243,150,20);
        lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
        image2.add(lbladdress);
        
        tfaddress = new JTextField();    // basically gives a input field from user
        tfaddress.setBounds(220,244,185,25);
        image2.add(tfaddress);
        
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,285,150,20);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        image2.add(lblgender);
        
        
        ButtonGroup gendergroup = new ButtonGroup();
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220, 286,55,25);
        //rbmale.setBackground(Color.WHITE);
        image2.add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(281, 286,68,25);
        //rbfemale.setBackground(Color.WHITE);
        image2.add(rbfemale);
        
        rbothers = new JRadioButton("Others");
        rbothers.setBounds(356, 286,68,25);
       // rbothers.setBackground(Color.WHITE);
        image2.add(rbothers);
        
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        gendergroup.add(rbothers);
        
        
        
        JLabel lblphone = new JLabel("Phone No.");
        lblphone.setBounds(60,333,150,20);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        image2.add(lblphone);
        
        tfphone = new JTextField();    // basically gives a input field from user
        tfphone.setBounds(220,334,185,25);
        image2.add(tfphone);
        
        
        JLabel lblemail = new JLabel("E-mail");
        lblemail.setBounds(60,388,150,20);
        lblemail.setFont(new Font("Tahoma",Font.PLAIN,16));
        image2.add(lblemail);
        
        tfemail = new JTextField();    // basically gives a input field from user
        tfemail.setBounds(220,389,185,25);
        image2.add(tfemail);
        
        JButton save = new JButton("SAVE");
        save.setBackground(Color.BLUE);
        save.setForeground(Color.WHITE);
        save.setBounds(370,482,150,30);
        save.addActionListener(this);
        image2.add(save);
        
        
//        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.jpg"));
//        JLabel lblimage = new JLabel(image);
//        lblimage.setBounds(450,80,283,400);
//        add(lblimage);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/customer.png"));
        Image i2 = i1.getImage().getScaledInstance(376, 370, Image.SCALE_DEFAULT);  //scaling down image
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(510, 80, 283, 400);
        image2.add(lblimage);
        
        setSize(900,600);
        setLocation(210,65);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String aadhar = tfaadhar.getText();
        String email = tfemail.getText();
        
        String gender = null;
        if(rbmale.isSelected()){
            gender = "Male";
        } else if(rbfemale.isSelected()){
            gender = "Female";
        } else{
            gender = "Others";
            
        }
        
        try{
            Conn conn = new Conn();
            
            String query = "insert into passenger values('"+name+"', '"+nationality+"', '"+phone+"', '"+address+"', '"+aadhar+"', '"+gender+"', '"+email+"')";
        
            
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully!");
            setVisible(false);
        } catch(Exception e){
            e.printStackTrace();
            
        }
        
    }
    public static void main(String[] args){
        new AddCustomer();
        
    }
    
}
