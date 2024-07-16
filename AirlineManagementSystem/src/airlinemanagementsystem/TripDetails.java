

package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;



public class TripDetails extends JFrame implements ActionListener {
    
    JTable table;
    JTextField pnr;
    JButton show;
    
    public TripDetails(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        setTitle("TRIP DETAILS");
        
        JLabel lblpnr=new JLabel("PNR Details");
        lblpnr.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblpnr.setBounds(50,50,100,25);
        add(lblpnr);
        
        pnr=new JTextField();
        pnr.setBounds(160,50,120,25);
        add(pnr);
        
        show=new JButton("Show Details");
        show.setBounds(290,50,150,25);
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setOpaque(true);
        show.setBorderPainted(false);
        show.setFocusPainted(false);
        show.addActionListener(this);
        add(show);
        
        table=new JTable();
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,800,150);
        jsp.setBackground(Color.WHITE);
        add(jsp);
        
        
        setSize(800,600);
        setLocation(400,150);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            Conn conn=new Conn();
            
            ResultSet rs=conn.s.executeQuery("select * from reservation where PNR = '"+pnr.getText()+"'");
            if(!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "No Information Found");
                return;
            }
            
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    
    }
    
    public static void main(String args[]){
        new TripDetails();
    }
    
}

