
package rv.hotel.management;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;


/**
 *
 * @author raani
 */
public class RIssueBox extends JFrame  implements ActionListener{
    
    JButton back,update,check,search;
    JTable table;
    Choice croom;
    
    RIssueBox(){
        
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        JLabel heading = new JLabel("Issue Box");
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        heading.setBounds(530,30,350,40);
        add(heading);
        
        JLabel lblroom = new JLabel("Room number");
        lblroom.setBounds(200,90,130,35);
        lblroom.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblroom);
        
        croom = new Choice();
        croom.setBounds(350,95,200,30);
        add(croom);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from issuebox");
            
            while(rs.next()){
                 croom.add(rs.getString("roomnumber"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        search = new JButton("Search");
        search.setForeground(Color.BLACK);
        search.setBackground(Color.WHITE);
        search.setBounds(560,95,100,25);
        search.setFont(new Font("Tahoma",Font.PLAIN,16));
        search.addActionListener(this);
        add(search);
        
        JLabel lblrooom = new JLabel("Room number");
        lblrooom.setBounds(80,150,150,20);
        lblrooom.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblrooom);
        
        JLabel lblissuee = new JLabel("Issue");
        lblissuee.setBounds(530,150,100,20);
        lblissuee.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblissuee);
        
        JLabel lblstatus = new JLabel("Status");
        lblstatus.setBounds(1000,150,100,20);
        lblstatus.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblstatus);
        
        table = new JTable();
        table.setBounds(0, 180, 1300, 530);
        table.setBackground(Color.PINK);
        table.setFont(new Font("Tahoma", Font.PLAIN, 18)); 
        table.setRowHeight(30);
        table.setShowGrid(true);
        table.setGridColor(Color.BLACK);
        add(table);
        
        try{
            Conn c =new Conn();
            ResultSet rs= c.s.executeQuery("select * from issuebox");
            table.setModel(DbUtils.resultSetToTableModel(rs)); 
        }catch(Exception e){
            e.printStackTrace();
        }
        
        update = new JButton("Update");
        update.setForeground(Color.BLACK);
        update.setBackground(Color.WHITE);
        update.setBounds(480,710,120,40);
        update.setFont(new Font("Tahoma",Font.PLAIN,15));
        update.addActionListener(this);
        add(update);
        
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
        if(ae.getSource() == search){
            try {
                Conn c = new Conn();
                
                String roomnum = croom.getSelectedItem();
            
                String query = "select * from issuebox where roomnumber = '"+roomnum+"'";
                
                ResultSet rs3;
                
                rs3 = c.s.executeQuery(query);
                
                table.setModel(DbUtils.resultSetToTableModel(rs3));
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == update){
            try {
                Conn c = new Conn();
                
                String roomnum = croom.getSelectedItem();
                
                String query1 = "delete from issuebox where roomnumber = '"+roomnum+"'";
                
                c.s.executeUpdate(query1);
                
                ResultSet rs4;
                    
                String query2 = "select * from issuebox";
                
                rs4 = c.s.executeQuery(query2);
                
                table.setModel(DbUtils.resultSetToTableModel(rs4));
                
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new RIssueBox();
    }
}
