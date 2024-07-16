
package airlinemanagementsystem;


import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;//to get calender
import java.awt.event.*;
import java.sql.*;



public class BookFlight extends JFrame implements ActionListener{
    
    JTextField  Vpassport;
    JLabel Vgender,Vaddress,Vnationality,Vname, VFname,lsource,ldestination,VFcode;
    Choice source,destination;
    JDateChooser VDate;
    JButton fetch,flight,book;
    
    public BookFlight(){
        setLayout(null);
        
        JLabel heading=new JLabel("Book Flight");
        heading.setBounds(420,20,500,35);
        heading.setFont(new Font("Tahoma",Font.BOLD,32));
        add(heading);
        
        
        JLabel lpassport=new JLabel("Passport");
        lpassport.setBounds(60,80,150,25);
        lpassport.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lpassport);
        
        Vpassport= new JTextField();
        Vpassport.setBounds(220,80,150,25);
        add(Vpassport);
        
        fetch=new JButton("Fetch User");
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
        
        JLabel lnationality=new JLabel("Nationality");
        lnationality.setBounds(60,180,150,25);
        lnationality.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lnationality);
        
        Vnationality= new JLabel();
        Vnationality.setBounds(220,180,150,25);
        add(Vnationality);
        
        JLabel laddress=new JLabel("Address");
        laddress.setBounds(60,230,150,25);
        laddress.setFont(new Font("Tahoma",Font.BOLD,16));
        add(laddress);
        
        Vaddress= new JLabel();
        Vaddress.setBounds(220,230,150,25);
        add(Vaddress);
              
        JLabel lgender=new JLabel("Gender");
        lgender.setBounds(60,280,150,25);
        lgender.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lgender);
        
        Vgender=new JLabel("Gender");
        Vgender.setBounds(220,280,150,25);
        add(Vgender);
        
        lsource=new JLabel("Source");
        lsource.setBounds(60,330,150,25);
        lsource.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lsource);
        
        source=new Choice();
        source.setBounds(220,330,120,25);
        add(source);
             
        ldestination=new JLabel("Destination");
        ldestination.setBounds(60,380,150,25);
        ldestination.setFont(new Font("Tahoma",Font.BOLD,16));
        add(ldestination);
        
        destination=new Choice();
        destination.setBounds(220,380,120,25);
        add(destination);
        
        try{
            Conn c=new Conn();
            String query="select * from flight";
            ResultSet rs=c.s.executeQuery(query);
            
            while(rs.next()){
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }          
        }
        catch(Exception e)
            {
            e.printStackTrace();
            }
        
        flight=new JButton("Fetch Flights");
        flight.setBounds(380,380,120,25);
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setOpaque(true);
        flight.setBorderPainted(false);
        flight.setFocusPainted(false);
        flight.addActionListener(this);
        add(flight);
               
        JLabel lFname=new JLabel("Flight Name");
        lFname.setBounds(60,430,150,25);
        lFname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lFname);
        
        VFname= new JLabel();
        VFname.setBounds(220,430,150,25);
        add(VFname);  
        
        JLabel lFcode=new JLabel("Flight Code");
        lFcode.setBounds(60,480,150,25);
        lFcode.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lFcode);
        
        VFcode= new JLabel();
        VFcode.setBounds(220,480,150,25);
        add(VFcode);
        
        JLabel lFDate=new JLabel("Date of Travel");
        lFDate.setBounds(60,530,150,25);
        lFDate.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lFDate);
        
        VDate= new JDateChooser();
        VDate.setBounds(220,530,150,25);
        add(VDate);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/list.png"));
        Image i2=i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image=new ImageIcon(i2);
        JLabel lblimage=new JLabel(image);
        lblimage.setBounds(550,80,400,410);
        add(lblimage);  
        
        book=new JButton("Book Flight");
        book.setBounds(220,580,150,25);
        book.setBackground(Color.BLACK);
        book.setForeground(Color.WHITE);
        book.setOpaque(true);
        book.setBorderPainted(false);
        book.setFocusPainted(false);
        book.addActionListener(this);
        add(book);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(1100,700);
        setLocation(200,50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource()==fetch){  
        String passport=Vpassport.getText();
       
            try{
                Conn c=new Conn(); 
                String query="select * from passenger where passport = '"+passport+"'";
                ResultSet rs=c.s.executeQuery(query);

                if(rs.next()){
                    Vname.setText(rs.getString("name"));
                    Vnationality.setText(rs.getString("nationality"));
                    Vaddress.setText(rs.getString("address"));
                    Vgender.setText(rs.getString("gender"));           
                } else {
                     JOptionPane.showMessageDialog(null,"Please enter correct passport!");
                }   
            }
            catch(Exception e)
            {
                 e.printStackTrace();
            }
        } 
      else if(ae.getSource()==flight){  
        String src=source.getSelectedItem();
        String dest=destination.getSelectedItem();
       
            try{
                Conn c=new Conn(); 
                String query="select * from flight where source = '"+src+"' and destination='"+dest+"'";
                ResultSet rs=c.s.executeQuery(query);

                if(rs.next()){
                    VFname.setText(rs.getString("f_name"));
                    VFcode.setText(rs.getString("f_code"));      
                } else {
                     JOptionPane.showMessageDialog(null,"No Flights Found!!");
                }   
            }
            catch(Exception e)
            {
                 e.printStackTrace();
            }
        }
      else{
            Random random=new Random();
            String passport=Vpassport.getText();
            String nationality=Vnationality.getText();
            String name=Vname.getText(); 
            String flightName=VFname.getText();
            String fsource=source.getSelectedItem();
            String fdestination=destination.getSelectedItem();
            String fcode=VFcode.getText();
            String ddate=((JTextField) VDate.getDateEditor().getUiComponent()).getText();
            
            try{
                Conn c=new Conn(); 
                String query="insert into reservation values('PNR-"+random.nextInt(1000000)+"','TIC-"+random.nextInt(10000)+"','"+passport+"','"+name+"','"+nationality+"','"+flightName+"','"+fcode+"','"+fsource+"','"+fdestination+"','"+ddate+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Ticket Booked Successfully!!");  
                setVisible(false);
            }
            catch(Exception e)
            {
                 e.printStackTrace();
            }
      
      
      }
}
    
    public static void main(String args[]){
      new BookFlight();
    
    }
    
}
