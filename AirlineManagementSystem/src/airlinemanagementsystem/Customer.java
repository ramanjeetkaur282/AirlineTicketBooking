package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Customer extends JFrame implements ActionListener{
    
    JTextField Vname, Vnationality, Vpassport, Vaddress, Vphone;
    JRadioButton male,female;
    ButtonGroup gendergroup;
    JButton save;
    
    public Customer(){
        setLayout(null);
        
        JLabel heading=new JLabel("Add Customer Details");
        heading.setBounds(220,20,500,35);
        heading.setFont(new Font("Tahoma",Font.BOLD,32));
        add(heading);
        
        JLabel lname=new JLabel("Name");
        lname.setBounds(60,80,150,25);
        lname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lname);
        
        Vname= new JTextField();
        Vname.setBounds(220,80,150,25);
        add(Vname);
        
        JLabel lnationality=new JLabel("Nationality");
        lnationality.setBounds(60,130,150,25);
        lnationality.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lnationality);
        
        Vnationality= new JTextField();
        Vnationality.setBounds(220,130,150,25);
        add(Vnationality);
        
        JLabel lpassport=new JLabel("Passport No");
        lpassport.setBounds(60,180,150,25);
        lpassport.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lpassport);
        
        Vpassport= new JTextField();
        Vpassport.setBounds(220,180,150,25);
        add(Vpassport);
        
        JLabel laddress=new JLabel("Address");
        laddress.setBounds(60,220,150,25);
        laddress.setFont(new Font("Tahoma",Font.BOLD,16));
        add(laddress);
        
        Vaddress= new JTextField();
        Vaddress.setBounds(220,220,150,25);
        add(Vaddress);
        
        
        JLabel lgender=new JLabel("Gender");
        lgender.setBounds(60,270,150,25);
        lgender.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lgender);
        
        male=new JRadioButton("Male");
        male.setBounds(220,280,70,25);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(300,280,90,25);
        add(female);
        
        gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        
        JLabel lphone=new JLabel("Phone");
        lphone.setBounds(60,320,150,25);
        lphone.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lphone);
        
        Vphone= new JTextField();
        Vphone.setBounds(220,320,150,25);
        add(Vphone);
        
        save=new JButton("Save");
        save.setBounds(270,370,100,40);
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setOpaque(true);
        save.setBorderPainted(false);
        save.setFocusPainted(false);
        save.addActionListener(this);
        add(save);
        
        ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("icons/employee.png"));
        JLabel limage=new JLabel(image);
        limage.setBounds(400,80,400,400);
        add(limage);
          
        getContentPane().setBackground(Color.WHITE);
        setSize(900,600);
        setLocation(300,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String name=Vname.getText();
        String nation=Vnationality.getText();
        String phoneN=Vphone.getText();
        String address=Vaddress.getText();
        String passport=Vpassport.getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";        
        }
        else if(female.isSelected()){
            gender="Female";
        }
               
        try{
            Conn c=new Conn(); 
            String query="insert into passenger values ('"+name+"','"+nation+"','"+phoneN+"','"+passport+"','"+address+"','"+gender+"')";
            c.s.executeUpdate(query);
            
            
            
           JOptionPane.showMessageDialog(null,"Customer Details Added Successfully!");
           setVisible(false);
            
        
        }
        catch(Exception e){
        e.printStackTrace();
        }
        
    
    }
    
    public static void main(String args[]){
      new Customer();
    
    }
    
}
