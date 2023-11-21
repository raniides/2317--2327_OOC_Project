
package rv.hotel.management;

/**
 *
 * @author raani
 */
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateRoom extends JFrame implements ActionListener{
    
    Choice ccustomer;
    JTextField tfroom,tfavailable,tfstatus;
    JButton back,check,update;
    
    UpdateRoom(){
        
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        JLabel text = new JLabel("Update Room Status");
        text.setBounds(160,110,400,35);
        text.setFont(new Font("Tahoma",Font.BOLD,30));
        add(text);
        
        JLabel lblid = new JLabel("Customer id");
        lblid.setBounds(140,230,170,30);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(320,230,150,25);
        ccustomer.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(ccustomer);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            
            while(rs.next()){
                 ccustomer.add(rs.getString("id_number"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblroom = new JLabel("Room number");
        lblroom.setBounds(140,310,170,30);
        lblroom.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(320, 310, 150, 25);
        tfroom.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfroom);
        
        JLabel lblavailable = new JLabel("Availability");
        lblavailable.setBounds(140,390,170,30);
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblavailable);
        
        tfavailable = new JTextField();
        tfavailable.setBounds(320, 390, 150, 25);
        tfavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfavailable);
        
        JLabel lblstatus = new JLabel("Cleaning Status");
        lblstatus.setBounds(140,470,170,30);
        lblstatus.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblstatus);
        
        tfstatus = new JTextField();
        tfstatus.setBounds(320, 470, 150, 25);
        tfstatus.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfstatus);
        
        check = new JButton("Check");
        check.setForeground(Color.BLACK);
        check.setBackground(Color.WHITE);
        check.setBounds(120,600,100,35);
        check.setFont(new Font("Tahoma",Font.PLAIN,20));
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setForeground(Color.BLACK);
        update.setBackground(Color.WHITE);
        update.setBounds(240,600,120,35);
        update.setFont(new Font("Tahoma",Font.PLAIN,20));
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.BLACK);
        back.setBounds(380,600,120,35);
        back.setFont(new Font("Tahoma",Font.PLAIN,20));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/l5.png"));
        Image i2 = i1.getImage().getScaledInstance(650,720,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(630,50,600,680);
        add(image);
        
        setBounds(80,60,1300,900);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == check){
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where id_number = '"+id+"'";
            
            try {
                Conn c =new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                while(rs.next()){
                    tfroom.setText(rs.getString("room_allocated"));
                }
                
                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
                
                while(rs2.next()){
                    tfavailable.setText(rs2.getString("availability"));
                    tfstatus.setText(rs2.getString("cleaning_status"));
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == update){
            String id_number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String available = tfavailable .getText();
            String status = tfstatus.getText();
            
            try {
                Conn c = new Conn();
                c.s.executeUpdate("update room set availability = '"+available+"', cleaning_status = '"+status+"' where roomnumber = '"+room+"'");
                
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
               
                setVisible(false);
                new Reception();
                
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new UpdateRoom();
    }
    
}
