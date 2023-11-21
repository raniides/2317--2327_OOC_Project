
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

public class PickUpService extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit,search;
    Choice typeofcar;
    
    PickUpService(){
        
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        JLabel text = new JLabel("Pick Up Service");
        text.setFont(new Font("Tahoma",Font.BOLD,30));
        text.setBounds(530,30,350,40);
        add(text);
        
        JLabel lblcartype = new JLabel("Type of Car");
        lblcartype.setBounds(200,100,130,35);
        lblcartype.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblcartype);
        
        typeofcar = new Choice();
        typeofcar.setBounds(350,100,200,30);
        typeofcar.setBackground(Color.PINK);
        add(typeofcar);
        
        try {
            Conn c = new Conn();
             ResultSet rs = c.s.executeQuery(" select * from driver");
             
             while(rs.next()){
                 typeofcar.add(rs.getString("car_model"));
             }
             
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel l1=new JLabel("Name");
        l1.setBounds(40,160,100,20);
        l1.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l1);
        
        JLabel l2= new JLabel("Age");
        l2.setBounds(230,160,100,20);
        l2.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l2);
        
        JLabel l3= new JLabel("Gender");
        l3.setBounds(410,160,100,20);
        l3.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l3);
        
        JLabel l4= new JLabel("Car Company");
        l4.setBounds(590,160,100,20);
        l4.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l4);
        
        JLabel l5= new JLabel("Car Model");
        l5.setBounds(770,160,100,20);
        l5.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l5);
        
        JLabel l6= new JLabel("Availability");
        l6.setBounds(950,160,100,20);
        l6.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l6);
        
        JLabel l7= new JLabel("Location");
        l7.setBounds(1150,160,100,20);
        l7.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l7);
        
        table= new JTable();
        table.setBounds(0,200,1300,500);
        table.setBackground(Color.PINK);
        table.setFont(new Font("Tahoma", Font.PLAIN, 18)); 
        table.setRowHeight(30);
        add(table);
        
        try{
            Conn c =new Conn();
            ResultSet rs= c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs)); 
        }catch(Exception e){
            e.printStackTrace();
        }
        
        table.setShowGrid(true);
        table.setGridColor(Color.BLACK);
        
        search = new JButton("Search");
        search.setForeground(Color.BLACK);
        search.setBackground(Color.WHITE);
        search.setBounds(570,100,120,30);
        search.setFont(new Font("Tahoma",Font.PLAIN,15));
        search.addActionListener(this);
        add(search);
        
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
        if(ae.getSource() == search){
            try {
                String query = "select * from driver where car_model = '"+typeofcar.getSelectedItem()+"'";
                
                Conn c = new Conn();
                ResultSet rs;
                
                rs = c.s.executeQuery(query);
                
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == submit){
            try {
                Conn c = new Conn();
                
                c.s.executeUpdate("update driver set availability = 'Not Available' where car_model = '"+typeofcar.getSelectedItem()+"'");
                
                JOptionPane.showMessageDialog(null,"Pick Up Service Assigned");
                
                setVisible(false);
                new Reception();
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new PickUpService();
    }
    
}
