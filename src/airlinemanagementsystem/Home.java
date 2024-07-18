package airlinemanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class Home extends JFrame implements ActionListener{
    JButton submit,reset,close;       // globally declare
    JTextField tfusername;
    JPasswordField tfpassword;    
    public Home(){      //constructor
        
        setLayout(null);
        
        ImageIcon bgic = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
        Image i22 = bgic.getImage().getScaledInstance(1290, 900, Image.SCALE_DEFAULT);  //scaling down image
        ImageIcon bgimage = new ImageIcon(i22);
        JLabel image = new JLabel(bgimage);
        image.setBounds(0,0 ,1290, 730);
        add(image);
        
        JLabel heading = new JLabel("SKYZEN AIRLINES WELCOMES YOU");
        heading.setBounds(363,40,607,40);
        heading.setForeground(Color.red);
        heading.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4)); // 4px black line border
        
        Font font= new Font("Monospaced",Font.BOLD, 36);      // Font belongs to java.awt package
        heading.setFont(font);
        image.add(heading);
        
       
        //------------------------------ MENU BAR -----------------------------
        
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details = new JMenu(" ✦ Details");
        menubar.add(details);
        
        JMenuItem flightDetails = new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        
        JMenuItem customerDetails = new JMenuItem("Add Customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        
        JMenuItem bookFlight = new JMenuItem("Book Flight");
        bookFlight.addActionListener(this);
        details.add(bookFlight);
        
        JMenuItem journeyDetails = new JMenuItem("Journey Details");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);
        
        JMenuItem ticketCancellation = new JMenuItem("Cancel Ticket");
        ticketCancellation.addActionListener(this);
        details.add(ticketCancellation);
        
         JMenu ticket = new JMenu(" ✦ Ticket");
        menubar.add(ticket);
        
        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
        boardingPass.addActionListener(this);
        ticket.add(boardingPass);
        
        
        JMenuItem resheduleJourney = new JMenuItem("Reshedule Journey");
        resheduleJourney.addActionListener(this);
        ticket.add(resheduleJourney);
        
        
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(470,210);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String text = ae.getActionCommand();
        if(text.equals("Add Customer Details")){
            new AddCustomer();
            
        } else if(text.equals("Flight Details")){
            new FlightInfo();
            
        } else if(text.equals("Book Flight")){
            new BookFlight();
            
        }else if(text.equals("Journey Details")){
            new JourneyDetails();
            
        }else if(text.equals("Cancel Ticket")){
            new Cancel();
        }else if(text.equals("Boarding Pass")){
            new BoardingPass();
        }else if(text.equals("Reshedule Journey")){
            new Reshedule();
        }
        
        
        
        
        
    }
    public static void main(String[] args){
        new Home(); 
    }
    
}
