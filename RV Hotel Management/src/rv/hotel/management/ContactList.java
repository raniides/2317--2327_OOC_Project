
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

public class ContactList extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    private String username;
    private String password;
    
    ContactList(String usern, String passw){
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        this.username = usern;
        this.password = passw;
        
        
        JLabel l1=new JLabel("Department");
        l1.setBounds(250,10,140,20);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20)); 
        add(l1);
        
        JLabel l2=new JLabel("Contact No");
        l2.setBounds(820,10,140,20);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 20)); 
        add(l2);
        
        table= new JTable();
        table.setBounds(0,50,1300,650);
        table.setBackground(Color.PINK);
        table.setFont(new Font("Tahoma", Font.PLAIN, 18)); 
        table.setRowHeight(30);
        add(table);
        
        try{
            Conn c =new Conn();
            ResultSet rs= c.s.executeQuery("select * from contactlist");
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
        if(ae.getSource() == back){
            setVisible(false);
            new UserDashboard(username, password);
        }
    }
    
    public static void main(String[] args){
        
    }
    
}
