
package airlinemanagementsystem;

/**
 *
 * @author ramanjeetkaur
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {
    
    JTextField username;
    JPasswordField password;
    JButton login,reset,close;
    
    public Login(){
    setLayout(null);
    
    JLabel L_username=new JLabel("Username");
    L_username.setBounds(20,20,100,20);
    add(L_username);
    
    username=new JTextField();
    username.setBounds(130,20,200,20);
    add(username);
    
    JLabel L_password=new JLabel("Password");
    L_password.setBounds(20,60,100,20);
    add(L_password);
    
    password=new JPasswordField();
    password.setBounds(130,60,200,20);
    add(password);
    
    reset=new JButton("Reset");
    reset.setBounds(40,120,120,20);
    reset.addActionListener(this);
    add(reset);
    
    login=new JButton("Login");
    login.setBounds(190,120,120,20);
    login.addActionListener(this);
    add(login);
    
    close=new JButton("Close");
    close.setBounds(120,160,120,20);
    close.addActionListener(this);
    add(close);
     
    
    setSize(400,250);
    setLocation(600,300);
    getContentPane().setBackground(Color.WHITE);
    setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
     if(ae.getSource()==close){
         setVisible(false);
     }
     else if(ae.getSource()==reset){
         username.setText("");
         password.setText("");
     }
     else if(ae.getSource()==login){
         String S_username=username.getText();
         String S_password=password.getText();
         
         
         try{
             Conn c=new Conn();
             String query="select * from login where username = '"+S_username+"' and password ='"+S_password+"'";
             
             ResultSet rs=c.s.executeQuery(query);            
             if(rs.next()){            
                new Home().setVisible(true);
                setVisible(false);
             }
             else{
             JOptionPane.showMessageDialog(null,"Invalid Username/Password");
             }
         }
         catch(Exception e){
             e.printStackTrace();
         }
     }
    
    }
    
    public static void main(String args[]){
    new Login();
    }
    
}
