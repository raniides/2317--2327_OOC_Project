
package rv.hotel.management;

/**
 *
 * @author raani
 */
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCheck extends JFrame implements ActionListener{
    
    Choice ccustomer;
    JTextField tfroom,tfname,tfcheckin,tfpaid,tfpending;
    JButton back,check,update;
    
    UpdateCheck(){
        
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        JLabel text = new JLabel("Update Status");
        text.setBounds(190,70,400,35);
        text.setFont(new Font("Tahoma",Font.BOLD,30));
        add(text);
        
        JLabel lblid = new JLabel("Customer id");
        lblid.setBounds(130,150,150,25);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(300,150,150,25);
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
        lblroom.setBounds(130,220,150,25);
        lblroom.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(300, 220, 150, 25);
        tfroom.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfroom);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(130,290,150,25);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(300, 290, 150, 25);
        tfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfname);
        
        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(130,360,150,25);
        lblcheckin.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblcheckin);
        
        tfcheckin = new JTextField();
        tfcheckin.setBounds(300, 360, 150, 25);
        tfcheckin.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfcheckin);
        
        JLabel lblpaid = new JLabel("Amount Paid");
        lblpaid.setBounds(130,430,150,25);
        lblpaid.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblpaid);
        
        tfpaid = new JTextField();
        tfpaid.setBounds(300, 430, 150, 25);
        tfpaid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfpaid);
        
        JLabel lblpending = new JLabel("Pending Amount");
        lblpending.setBounds(130,500,150,25);
        lblpending.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblpending);
        
        tfpending = new JTextField();
        tfpending.setBounds(300, 500, 150, 25);
        tfpending.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfpending);
        
        check = new JButton("Check");
        check.setForeground(Color.BLACK);
        check.setBackground(Color.WHITE);
        check.setBounds(100,600,100,35);
        check.setFont(new Font("Tahoma",Font.PLAIN,20));
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setForeground(Color.BLACK);
        update.setBackground(Color.WHITE);
        update.setBounds(220,600,120,35);
        update.setFont(new Font("Tahoma",Font.PLAIN,20));
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.BLACK);
        back.setBounds(360,600,120,35);
        back.setFont(new Font("Tahoma",Font.PLAIN,20));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/l10.png"));
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
                    tfname.setText(rs.getString("name"));
                    tfcheckin.setText(rs.getString("checkin_time"));
                    tfpaid.setText(rs.getString("deposit"));   
                }
                
                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
                
                while(rs2.next()){
                    String price = rs2.getString("price");
                    int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
                    tfpending.setText(" " + amountPaid);
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == update){
            String id_number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname .getText();
            String checkin = tfcheckin.getText();
            String deposit = tfpaid.getText();
            
            try {
                Conn c = new Conn();
                c.s.executeUpdate("update customer set room_allocated = '"+room+"', name = '"+name+"', checkin_time = '"+checkin+"', deposit = '"+deposit+"' where id_number = '"+id_number+"'");
                
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
        new UpdateCheck();
    }
    
}
