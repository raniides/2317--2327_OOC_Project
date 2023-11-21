
package rv.hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
/**
 *
 * @author raani
 */
public class Checkout extends JFrame implements ActionListener{
    
    Choice ccustomerid;
    JLabel lblcname,lblroomnumber,lblcheckintime,lblcheckouttime;
    JButton back,checkout,check;
    
    Checkout() {
        
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        JLabel text = new JLabel("CHECKOUT");
        text.setBounds(170,90,400,30);
        text.setFont(new Font("Tahoma",Font.BOLD,30));
        add(text);
        
        JLabel lblid = new JLabel("Customer ID");
        lblid.setBounds(60,220,190,30);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblid);
        
        ccustomerid = new Choice();
        ccustomerid.setBounds(250,220,170,30);
        ccustomerid.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(ccustomerid);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer ");
            
            while(rs.next()){
                 ccustomerid.add(rs.getString("id_number"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        check = new JButton("Check");
        check.setForeground(Color.BLACK);
        check.setBackground(Color.WHITE);
        check.setBounds(430,220,120,30);
        check.setFont(new Font("Tahoma",Font.PLAIN,15));
        check.addActionListener(this);
        add(check);
        
        JLabel lblname = new JLabel("Customer Name");
        lblname.setBounds(60,300,190,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblname);
        
        lblcname = new JLabel();
        lblcname.setBounds(250, 300, 170, 30);
        lblcname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblcname);
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(60,380,190,30);
        lblroom.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblroom);
        
        lblroomnumber = new JLabel();
        lblroomnumber.setBounds(250, 380, 170, 30);
        lblroomnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblroomnumber);
        
        JLabel lblcheckin = new JLabel("Checkin Time"); //local declaration
        lblcheckin.setBounds(60,460,190,30);
        lblcheckin.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblcheckin);
        
        lblcheckintime = new JLabel(); //global declaration
        lblcheckintime.setBounds(250, 460, 240, 30);
        lblcheckintime.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblcheckintime);
        
        JLabel lblcheckout = new JLabel("Checkout Time"); //local declaration
        lblcheckout.setBounds(60,540,190,30);
        lblcheckout.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblcheckout);
        
        Date date = new Date();
        
        lblcheckouttime = new JLabel(" " + date); //global declaration
        lblcheckouttime.setBounds(250, 540, 240, 30);
        lblcheckouttime.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblcheckouttime);
        
        checkout = new JButton("Checkout");
        checkout.setForeground(Color.BLACK);
        checkout.setBackground(Color.WHITE);
        checkout.setBounds(90,630,120,40);
        checkout.setFont(new Font("Tahoma",Font.PLAIN,15));
        checkout.addActionListener(this);
        add(checkout);
        
        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.setBounds(270,630,120,40);
        back.setFont(new Font("Tahoma",Font.PLAIN,15));
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/l6.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750,720,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(570,50,700,680);
        add(image);
        
        setBounds(80,60,1300,900);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() ==  check){
            String id_number = ccustomerid.getSelectedItem(); 
            try {
                Conn c =new Conn();
                String query = "select * from customer where id_number = '"+id_number+"'";
                ResultSet rs;
                 rs = c.s.executeQuery(query);
                
                while(rs.next()){
                 lblcname.setText(rs.getString("name"));
                 lblroomnumber.setText(rs.getString("room_allocated"));
                 lblcheckintime.setText(rs.getString("checkin_time"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == checkout){
            String query1 = "delete from customer where id_number = '"+ccustomerid.getSelectedItem()+"'";
            String query2 ="delete from userlogin where id_number = '"+ccustomerid.getSelectedItem()+"'";
            String query3 = "update room set availability = 'Available' where roomnumber = '"+lblroomnumber.getText()+"' ";
            try {
                Conn c = new Conn();
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null,"Checkout done");
                
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
        new Checkout();
    }
}
