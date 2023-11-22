
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
    JButton back,submit;
    JComboBox bedType;
    JCheckBox available;
    
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
        
        JLabel lblbedType = new JLabel("Bed Type");
        lblbedType.setBounds(30,65,100,30);
        lblbedType.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblbedType);
        
        bedType = new JComboBox(new String[]{"Single Bed","Double Bed","All"});
        bedType.setBounds(125,70,150,25);
        bedType.setBackground(Color.WHITE);
        add(bedType);
        
        available = new JCheckBox("Only Display Available");
        available.setBounds(320,65,250,30);
        available.setBackground(Color.WHITE);
        available.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(available);
        
        JLabel l1=new JLabel("Room Number");
        l1.setBounds(8,120,120,20);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(l1);
        
        JLabel l2= new JLabel("Availability");
        l2.setBounds(140,120,100,20);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(l2);
        
        JLabel l3= new JLabel("Status");
        l3.setBounds(270,120,100,20);
        l3.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(l3);
        
        JLabel l4= new JLabel("Price");
        l4.setBounds(390,120,100,20);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(l4);
        
        JLabel l5= new JLabel("Bed Type");
        l5.setBounds(490,120,100,20);
        l5.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(l5);
        
        table= new JTable();
        table.setBounds(0,150,600,400);
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

        submit = new JButton("Submit");
        submit.setForeground(Color.BLACK);
        submit.setBackground(Color.WHITE);
        submit.setBounds(170,710,120,40);
        submit.setFont(new Font("Tahoma",Font.PLAIN,15));
        submit.addActionListener(this);
        add(submit);
        
        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.setBounds(330,710,120,40);
        back.setFont(new Font("Tahoma", Font.PLAIN, 15)); 
        back.addActionListener(this);
        add(back);
        
        setBounds(80,60,1300,900);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            try {
                String bedTypeAll = (String) bedType.getSelectedItem();
                String query1 = "select * from room where bed_type = '"+bedType.getSelectedItem()+"'";
                String query2 = "select * from room where availability = 'Available' AND bed_type = '"+bedType.getSelectedItem()+"'";
                String query3 = "select * from room";
                
                Conn c = new Conn();
                ResultSet rs;
                
                if(available.isSelected()){ //checkbox
                    rs = c.s.executeQuery(query2);
                }else {
                    rs = c.s.executeQuery(query1);
                }
                
                
                
                if(bedTypeAll.equals("All")){
                    rs = c.s.executeQuery(query3);
                }
                
                
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new Room();
    }
    
}
