
package rv.hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
/**
 *
 * @author raani
 */
public class FoodAndBeverages extends JFrame implements ActionListener{
    JTable table,table2,table3;
    JButton back;
    private String username;
    private String password;
    
    FoodAndBeverages(String usern, String passw){
        
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        this.username = usern;
        this.password = passw;
        
        JLabel heading = new JLabel("Food and Beverages");
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        heading.setBounds(550,10,240,30);
        add(heading);
        
        JLabel phoneno = new JLabel("Ph_no 9822510622");
        phoneno.setBounds(570,30,200,30);
        phoneno.setFont(new Font("Tahoma",Font.BOLD,15));
        add(phoneno);
        
        JLabel morning = new JLabel("Morning/Evening-Breakfast");
        morning.setBounds(200,60,240,20);
        morning.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(morning);
        
        JLabel l1=new JLabel("Dish_name");
        l1.setBounds(220,90,100,20);
        l1.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l1);
        
        JLabel l2=new JLabel("Price");
        l2.setBounds(820,90,100,20);
        l2.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l2);
        
        table = new JTable();
        table.setBounds(0,120,1300,120);
        table.setBackground(Color.PINK);
        add(table);
        
        try {
            Conn c = new Conn();
            
            String query = "select * from morning_evening_breakfast";
            
            ResultSet rs;
            
            rs = c.s.executeQuery(query);
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        table.setShowGrid(true);
        table.setGridColor(Color.BLACK);
        
        
        JLabel lunch = new JLabel("Lunch");
        lunch.setBounds(200,250,150,30);
        lunch.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lunch);
        
        JLabel l3=new JLabel("Dish_name");
        l3.setBounds(220,290,100,20);
        l3.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l3);
        
        JLabel l4=new JLabel("Price");
        l4.setBounds(820,290,100,20);
        l4.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l4);
        
        table2 = new JTable();
        table2.setBounds(0,320,1300,150);
        table2.setBackground(Color.PINK);
        add(table2);
        
        try {
            Conn c = new Conn();
            
            String query = "select * from lunch";
            
            ResultSet rs;
            
            rs = c.s.executeQuery(query);
            
            table2.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        table2.setShowGrid(true);
        table2.setGridColor(Color.BLACK);
        
        JLabel dinner = new JLabel("Dinner");
        dinner.setBounds(200,480,150,30);
        dinner.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(dinner);
        
        JLabel l5=new JLabel("Dish_name");
        l5.setBounds(220,520,100,20);
        l5.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l5);
        
        JLabel l6=new JLabel("Price");
        l6.setBounds(820,520,100,20);
        l6.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l6);
        
        table3 = new JTable();
        table3.setBounds(0,550,1300,180);
        table3.setBackground(Color.PINK);
        add(table3);
        
        try {
            Conn c = new Conn();
            
            String query = "select * from dinner";
            
            ResultSet rs;
            
            rs = c.s.executeQuery(query);
            
            table3.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        table3.setShowGrid(true);
        table3.setGridColor(Color.BLACK);
        
        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.setBounds(600,740,120,30);
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
        //new FoodAndBeverages();
    }
}
