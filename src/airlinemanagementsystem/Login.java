
/**
 * @author Sagar Mandal
 */
package airlinemanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    JButton submit,reset,close;       // globally declared
    JTextField tfusername;
    JPasswordField tfpassword;    
    public Login(){
        //getContentPane().setBackground(new Color(204, 255, 255));
      
        setLayout(null);
        ImageIcon bgic = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front2.jpg"));
        Image i22 = bgic.getImage().getScaledInstance(450, 300, Image.SCALE_DEFAULT);  //scaling down image
        ImageIcon bgimage = new ImageIcon(i22);
        JLabel image2 = new JLabel(bgimage);
        image2.setBounds(0,0 , 400, 266);
        add(image2);
        

        JLabel lblusername = new JLabel("▸ Username");
        lblusername.setBounds(20,20,100,20);
        lblusername.setForeground(new Color(179, 255, 255));
        image2.add(lblusername);  //this method adds the label to our window
        
        tfusername = new JTextField();
        tfusername.setBounds(130,20,200,20);
        image2.add(tfusername);
        
        JLabel lblpassword = new JLabel("▸ Password");
        lblpassword.setBounds(20,60,100,20);
        lblpassword.setForeground(new Color(179, 255, 255));
        image2.add(lblpassword);  //this method adds the label to our window
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(130,60,200,20);
        image2.add(tfpassword);
        
        //----------------BUTTONS------------------------
        reset = new JButton("Reset");
        reset.setBounds(40,120,120,20);
        reset.addActionListener(this);
        image2.add(reset);
        
        submit = new JButton("Submit");
        submit.setBounds(190,120,120,20);
        submit.addActionListener(this);
        image2.add(submit);
        
        close = new JButton("Close");
        close.setBounds(120,160,120,20);
        close.addActionListener(this);
        image2.add(close);
        
        
        setSize(400,260);
        setLocation(470,210);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            try{
                Conn c = new Conn();
                String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    //System.out.println("Valid");
                    new Home();
                    setVisible(false);
                    
                } else{
                    JOptionPane.showMessageDialog(null, "Inavlid Username or Password!");
                    setVisible(false);
                }
            } catch(Exception e){
                e.printStackTrace();
                
            }
            
        } else if(ae.getSource() == close){
            setVisible(false);
            
        } else if(ae.getSource() == reset){
            tfusername.setText("");
            tfpassword.setText("");
            
        }
        
        
    }
    public static void main(String[] args){
        new Login(); 
    }
    
}
