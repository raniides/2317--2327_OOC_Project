
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

public class Room extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    
    Room(){
        
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/l8.png"));
        Image i2 = i1.getImage().getScaledInstance(650,720,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(630,50,600,680);
        add(image);
        
        JLabel heading = new JLabel("ROOM INFO");
        heading.setBounds(200,10,400,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        add(heading);
        
        JLabel l1=new JLabel("Room Number");
        l1.setBounds(8,60,120,20);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(l1);
        
        JLabel l2= new JLabel("Availability");
        l2.setBounds(140,60,100,20);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(l2);
        
        JLabel l3= new JLabel("Status");
        l3.setBounds(270,60,100,20);
        l3.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(l3);
        
        JLabel l4= new JLabel("Price");
        l4.setBounds(390,60,100,20);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(l4);
        
        JLabel l5= new JLabel("Bed Type");
        l5.setBounds(490,60,100,20);
        l5.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(l5);
        
        table= new JTable();
        table.setBounds(0,90,600,400);
        table.setBackground(Color.PINK);
        table.setFont(new Font("Tahoma", Font.PLAIN, 18)); 
        table.setRowHeight(30);
        add(table);
        
        try{
            Conn c =new Conn();
            ResultSet rs= c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs)); 
        }catch(Exception e){
            e.printStackTrace();
        }
        
        table.setShowGrid(true);
        table.setGridColor(Color.BLACK);

        
        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.setBounds(240,730,120,35);
        back.setFont(new Font("Tahoma", Font.PLAIN, 15)); 
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
        new Room();
    }
    
}
