
package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Home extends JFrame implements ActionListener {
         
    public Home(){
    setLayout(null);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/plane.jpg"));
    JLabel image=new JLabel(i1);
    image.setBounds(0,0,1600,1000);
    add(image);
    
    
    JLabel heading=new JLabel("AIR CANADA WELCOMES YOU");
    heading.setBounds(500,40,800,40);
    heading.setFont(new Font("Tahoma",Font.BOLD,36));
    heading.setForeground(new Color(139, 0, 0));
    image.add(heading);
    
    JMenuBar menuBar=new JMenuBar();
    setJMenuBar(menuBar);
    
    JMenu details=new JMenu("Details");
    menuBar.add(details);
    
    JMenuItem flight_details=new JMenuItem("Flight Details");
    flight_details.addActionListener(this);
    details.add(flight_details);
    
    JMenuItem customer_details=new JMenuItem("Customer Details");
    customer_details.addActionListener(this);
    details.add(customer_details);
    
    JMenuItem bookFlight=new JMenuItem("Book Flight");
    bookFlight.addActionListener(this);
    details.add(bookFlight);
    
    JMenuItem trip_details=new JMenuItem("Trip Details");
    trip_details.addActionListener(this);
    details.add(trip_details);
    
    JMenu ticket=new JMenu("Ticket");
    ticket.addActionListener(this);
    menuBar.add(ticket);
    
    JMenuItem boardingPass=new JMenuItem("Boarding Pass");
    boardingPass.addActionListener(this);
    ticket.add(boardingPass);
    
    JMenuItem canceldetails=new JMenuItem("Cancel Ticket");
    canceldetails.addActionListener(this);
    details.add(canceldetails);
       
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    getContentPane().setBackground(Color.WHITE);
    setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
     String text=ae.getActionCommand();
     
     if(text.equals("Customer Details")){
         new Customer();
     }
     else if(text.equals("Flight Details")){
         new FlightInfo();
     }
     else if(text.equals("Book Flight")){
         new BookFlight();
     }
     else if(text.equals("Trip Details")){
         new TripDetails();
     }
     else if(text.equals("Cancel Ticket")){
         new cancelTicket();
     } 
     else if(text.equals("Boarding Pass")){
         new BoardingPass();
     }
    }
    
    public static void main(String args[]){
    new Home();
    }
    
}
