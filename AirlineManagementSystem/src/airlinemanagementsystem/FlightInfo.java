
package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.table.JTableHeader;


public class FlightInfo extends JFrame implements ActionListener {
    
    public FlightInfo(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        setTitle("FLIGHT DETAILS");
        
        JTable table=new JTable();
        
        try{
            Conn c=new Conn();
            
            ResultSet rs=c.s.executeQuery("select * from flight");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        //Enable grid line
        table.setShowGrid(true);
        table.setGridColor(Color.BLACK);
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,0,800,500);
        add(jsp);
        
        
        setSize(800,500);
        setLocation(400,200);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
    
    }
    
    public static void main(String args[]){
        new FlightInfo();
    }
    
}
