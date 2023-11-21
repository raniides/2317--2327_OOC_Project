
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
public class IssueBox extends JFrame  implements ActionListener{
    
    JTextField tfissue;
    JButton back,submit;
    JLabel roomnumber;
    private String username;
    private String password;
    
    IssueBox(String usern, String passw){
        
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        JLabel heading = new JLabel("Issue Box");
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        heading.setBounds(550,150,200,30);
        add(heading);
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(400,270,200,20);
        lblroom.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblroom);
        
        roomnumber = new JLabel();
        roomnumber.setBounds(650,270,150,20);
        roomnumber.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(roomnumber);
        
        JLabel lblissue = new JLabel("Any issues write here ");
        lblissue.setBounds(400,370,200,20);
        lblissue.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblissue);
        
        tfissue = new JTextField();
        tfissue.setBounds(650, 370, 250, 25);
        tfissue.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(tfissue);
        
        this.username = usern;
        this.password = passw;
        
        try {
            Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery("select * from userlogin where username = '"+usern+"' and password = '"+passw+"'");
            
            while(rs.next()){
                roomnumber.setText(rs.getString("room_allocated"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        submit = new JButton("Submit");
        submit.setForeground(Color.BLACK);
        submit.setBackground(Color.WHITE);
        submit.setBounds(480,500,140,40);
        submit.setFont(new Font("Tahoma",Font.PLAIN,20));
        submit.addActionListener(this);
        add(submit);
        
        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.setBounds(670,500,140,40);
        back.setFont(new Font("Tahoma",Font.PLAIN,20));
        back.addActionListener(this);
        add(back);
        
        //setBounds(400,200,450,250);
        setBounds(80,60,1300,900);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            
            try {
                Conn c = new Conn();
                
                String room_num = roomnumber.getText();
                String issue = tfissue.getText();
                
                String query = "insert into issuebox values('"+room_num+"','"+issue+"','ongoing')";
                
                c.s.executeUpdate(query); 
                
                JOptionPane.showMessageDialog(null,"Issue Added Successfully");
            
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new UserDashboard(username, password);
        }
    }
    
    public static void main(String[] args){
       // new IssueBox();
    }
}
