
package airlinemanagementsystem;


import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;



public class cancelTicket extends JFrame implements ActionListener{
    
    JTextField  Vpnr;
    JLabel VDate,Vcancel,Vname, VFcode; 
    JButton fetch,flight;
    
    public cancelTicket(){
        setLayout(null);
        Random random=new Random();
        
        JLabel heading=new JLabel("Cancel Flight");
        heading.setBounds(420,20,500,35);
        heading.setFont(new Font("Tahoma",Font.BOLD,32));
        add(heading);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/icons8-cancel-96.png"));
        Image i2=i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon image=new ImageIcon(i2);
        JLabel lblimage=new JLabel(image);
        lblimage.setBounds(470,120,250,250);
        add(lblimage);  
        
        
        JLabel lpnr=new JLabel("PNR Number");
        lpnr.setBounds(60,80,150,25);
        lpnr.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lpnr);
        
        Vpnr= new JTextField();
        Vpnr.setBounds(220,80,150,25);
        add(Vpnr);
        
        fetch=new JButton("Show Details");
        fetch.setBounds(380,80,120,25);
        fetch.setBackground(Color.BLACK);
        fetch.setForeground(Color.WHITE);
        fetch.setOpaque(true);
        fetch.setBorderPainted(false);
        fetch.setFocusPainted(false);
        fetch.addActionListener(this);
        add(fetch);
        
        JLabel lname=new JLabel("Name");
        lname.setBounds(60,130,150,25);
        lname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lname);
        
        Vname= new JLabel();
        Vname.setBounds(220,130,150,25);
        add(Vname);
        
        JLabel lcancel=new JLabel("Cancellation No:");
        lcancel.setBounds(60,180,150,25);
        lcancel.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lcancel);
        
        Vcancel= new JLabel(""+random.nextInt(1000000));
        Vcancel.setBounds(220,180,150,25);
        add(Vcancel);
        
        JLabel lFcode=new JLabel("Flight Code");
        lFcode.setBounds(60,230,150,25);
        lFcode.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lFcode);
        
        VFcode= new JLabel();
        VFcode.setBounds(220,230,150,25);
        add(VFcode);
        
        JLabel lFDate=new JLabel("Date");
        lFDate.setBounds(60,280,150,25);
        lFDate.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lFDate);
        
        VDate= new JLabel();
        VDate.setBounds(220,280,150,25);
        add(VDate);
        
        
        flight=new JButton("Cancel");
        flight.setBounds(220,330,120,25);
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setOpaque(true);
        flight.setBorderPainted(false);
        flight.setFocusPainted(false);
        flight.addActionListener(this);
        add(flight);
               
        getContentPane().setBackground(Color.WHITE);
        setSize(800,450);
        setLocation(350,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource()==fetch){  
       String PNR=Vpnr.getText();
       
            try{
                Conn c=new Conn(); 
                String query="select * from reservation where PNR = '"+PNR+"'";
                ResultSet rs=c.s.executeQuery(query);

                if(rs.next()){
                    Vname.setText(rs.getString("name"));
                    VFcode.setText(rs.getString("fcode"));
                    Vname.setText(rs.getString("name"));
                    VDate.setText(rs.getString("ddate"));           
                } else {
                     JOptionPane.showMessageDialog(null,"Please enter correct PNR!");
                }   
            }
            catch(Exception e)
            {
                 e.printStackTrace();
            }
        } 
      else if(ae.getSource()==flight){  
        String name=Vname.getText();
        String pnr=Vpnr.getText();
        String cancel=Vcancel.getText();
        String fcode=VFcode.getText();
        String fdate=VDate.getText();
        
       
            try{
                Conn c=new Conn(); 
                String query="insert into cancel values('"+pnr+"','"+name+"','"+fcode+"','"+fdate+"')";
                c.s.executeUpdate(query);
                c.s.executeUpdate("delete from reservation where PNR ='"+pnr+"'");

                     JOptionPane.showMessageDialog(null,"Ticket Cancelled!!");
                     setVisible(false);
                  
            }
            catch(Exception e)
            {
                 e.printStackTrace();
            }
        }      
}
    
    public static void main(String args[]){
      new cancelTicket();
    
    }
    
}
