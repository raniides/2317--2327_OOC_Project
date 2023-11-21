
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

public class SearchRoom extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    JComboBox bedType;
    JCheckBox available;
    
    SearchRoom(){
        
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        JLabel text = new JLabel("Search for Room");
        text.setBounds(530,40,400,30);
        text.setFont(new Font("Tahoma",Font.BOLD,25));
        add(text);
        
        JLabel lblbedType = new JLabel("Bed Type");
        lblbedType.setBounds(150,95,100,30);
        lblbedType.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblbedType);
        
        bedType = new JComboBox(new String[]{"Single Bed","Double Bed"});
        bedType.setBounds(260,100,150,25);
        bedType.setBackground(Color.WHITE);
        add(bedType);
        
        available = new JCheckBox("Only Display Available");
        available.setBounds(760,100,250,30);
        available.setBackground(Color.WHITE);
        available.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(available);
        
        JLabel l1=new JLabel("Room Number");
        l1.setBounds(50,160,130,20);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l1);
        
        JLabel l2= new JLabel("Availability");
        l2.setBounds(300,160,100,20);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l2);
        
        JLabel l3= new JLabel("Cleaning Status");
        l3.setBounds(550,160,130,20);
        l3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l3);
        
        JLabel l4= new JLabel("Price");
        l4.setBounds(870,160,100,20);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l4);
        
        JLabel l5= new JLabel("Bed Type");
        l5.setBounds(1100,160,100,20);
        l5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l5);
        
        table= new JTable();
        table.setBounds(0,200,1300,500);
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
        submit.setBounds(480,710,120,40);
        submit.setFont(new Font("Tahoma",Font.PLAIN,15));
        submit.addActionListener(this);
        add(submit);
        
        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.setBounds(680,710,120,40);
        back.setFont(new Font("Tahoma",Font.PLAIN,15));
        back.addActionListener(this);
        add(back);
        
        setBounds(80,60,1300,900);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            try {
                String query1 = "select * from room where bed_type = '"+bedType.getSelectedItem()+"'";
                String query2 = "select * from room where availability = 'Available' AND bed_type = '"+bedType.getSelectedItem()+"'";
                
                Conn c = new Conn();
                ResultSet rs;
                
                if(available.isSelected()){ //checkbox
                    rs = c.s.executeQuery(query2);
                }else {
                    rs = c.s.executeQuery(query1);
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
        new SearchRoom();
    }
    
}
