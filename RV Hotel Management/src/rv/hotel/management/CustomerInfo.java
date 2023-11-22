
package rv.hotel.management;

/**
 *
 * @author raani
 */


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    
    CustomerInfo(){
        
        getContentPane().setBackground(Color.PINK); 
        setLayout(null);
        
        JLabel heading = new JLabel("CUSTOMERS INFO");
        heading.setBounds(530,10,400,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        add(heading);
        
        JLabel l1=new JLabel("Room_Number");
        l1.setBounds(10,60,130,20);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l1);
        
        JLabel l2= new JLabel("Bed_Type");
        l2.setBounds(160,60,100,20);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l2);
        
        JLabel l3=new JLabel("ID_Type");
        l3.setBounds(280,60,100,20);
        l3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l3);
        
        JLabel l4= new JLabel("ID_No");
        l4.setBounds(420,60,100,20);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l4);
        
        JLabel l5= new JLabel("Customer_Name");
        l5.setBounds(520,60,150,20);
        l5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l5);
        
        JLabel l6= new JLabel("Gender");
        l6.setBounds(670,60,100,20);
        l6.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l6);
        
        JLabel l7= new JLabel("Country");
        l7.setBounds(800,60,100,20);
        l7.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l7);
        
        JLabel l8= new JLabel("Total_Members");
        l8.setBounds(910,60,130,20);
        l8.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l8);
        
        JLabel l9= new JLabel("Checkin_Time");
        l9.setBounds(1050,60,120,20);
        l9.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l9);
        
        JLabel l10= new JLabel("Deposit");
        l10.setBounds(1200,60,100,20);
        l10.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l10);
        
        table= new JTable();
        table.setBounds(0,90,1300,600);
        table.setBackground(Color.PINK);
        table.setFont(new Font("Tahoma", Font.PLAIN, 18)); 
        table.setRowHeight(30);
        add(table);
        
        try{
            Conn c =new Conn();
            ResultSet rs= c.s.executeQuery("select * from customer ");
            table.setModel(DbUtils.resultSetToTableModel(rs)); 
        }catch(Exception e){
            e.printStackTrace();
        }
        
        table.setShowGrid(true);
        table.setGridColor(Color.BLACK);
        
        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.setBounds(580,700,120,40);
        back.setFont(new Font("Tahoma", Font.PLAIN, 20)); 
        back.addActionListener(this);
        add(back);
        
        
        setBounds(80,60,1300,900);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args){
        new CustomerInfo();
    }
    
}
