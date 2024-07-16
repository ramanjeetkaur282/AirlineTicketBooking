
package airlinemanagementsystem;


import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;//to get calender
import java.awt.event.*;
import java.sql.*;



public class BoardingPass extends JFrame implements ActionListener{
    
    JTextField  Vpnr;
    JLabel VDate,Vnationality,Vname, VFname,lsource,ldestination,VFcode,destination,source;
    JButton fetch;
    
    public BoardingPass(){
        setLayout(null);
        
        JLabel heading=new JLabel("AIR CANADA");
        heading.setBounds(380,10,450,35);
        heading.setFont(new Font("Tahoma",Font.BOLD,32));
        add(heading);
        
        JLabel subheading=new JLabel("BOARDING PASS");
        subheading.setBounds(360,50,300,30);
        subheading.setFont(new Font("Tahoma",Font.BOLD,24));
        add(subheading);
        
        
        JLabel lpnr=new JLabel("PNR Details");
        lpnr.setBounds(60,100,150,25);
        lpnr.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lpnr);
        
        Vpnr= new JTextField();
        Vpnr.setBounds(220,100,150,25);
        add(Vpnr);
        
        fetch=new JButton("Enter");
        fetch.setBounds(380,100,120,25);
        fetch.setBackground(Color.BLACK);
        fetch.setForeground(Color.WHITE);
        fetch.setOpaque(true);
        fetch.setBorderPainted(false);
        fetch.setFocusPainted(false);
        fetch.addActionListener(this);
        add(fetch);
        
        JLabel lname=new JLabel("Name");
        lname.setBounds(60,140,150,25);
        lname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lname);
        
        Vname= new JLabel();
        Vname.setBounds(220,140,150,25);
        add(Vname);
        
        JLabel lnationality=new JLabel("Nationality");
        lnationality.setBounds(60,180,150,25);
        lnationality.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lnationality);
        
        Vnationality= new JLabel();
        Vnationality.setBounds(220,180,150,25);
        add(Vnationality);
       
        
        lsource=new JLabel("Source");
        lsource.setBounds(60,220,150,25);
        lsource.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lsource);
        
        source=new JLabel();
        source.setBounds(220,220,120,25);
        add(source);
             
        ldestination=new JLabel("Destination");
        ldestination.setBounds(380,220,150,25);
        ldestination.setFont(new Font("Tahoma",Font.BOLD,16));
        add(ldestination);
        
        destination=new JLabel();
        destination.setBounds(540,220,120,25);
        add(destination);
        
        JLabel lFname=new JLabel("Flight Name");
        lFname.setBounds(60,260,150,25);
        lFname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lFname);
        
        VFname= new JLabel();
        VFname.setBounds(220,260,150,25);
        add(VFname);  
        
        JLabel lFcode=new JLabel("Flight Code");
        lFcode.setBounds(380,300,150,25);
        lFcode.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lFcode);
        
        VFcode= new JLabel();
        VFcode.setBounds(540,300,150,25);
        add(VFcode);
        
        JLabel lFDate=new JLabel("Date of Travel");
        lFDate.setBounds(60,340,150,25);
        lFDate.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lFDate);
        
        VDate= new JLabel();
        VDate.setBounds(220,340,150,25);
        add(VDate);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/air-canada-logo-alt.png"));
        Image i2=i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon image=new ImageIcon(i2);
        JLabel lblimage=new JLabel(image);
        lblimage.setBounds(550,20,400,200);
        add(lblimage);  
        
        getContentPane().setBackground(Color.WHITE);
        setSize(1000,450);
        setLocation(300,150);
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
                    Vnationality.setText(rs.getString("nationality"));
                    VDate.setText(rs.getString("ddate"));
                    VFname.setText(rs.getString("flightName"));
                    VFcode.setText(rs.getString("fcode"));   
                    source.setText(rs.getString("fsource"));   
                    destination.setText(rs.getString("fdestination"));   
                              
                } else {
                     JOptionPane.showMessageDialog(null,"Please enter correct passport!");
                }   
            }
            catch(Exception e)
            {
                 e.printStackTrace();
            }
         
     
      
      }
}
    
    public static void main(String args[]){
      new BoardingPass();
    
    }
    
}
