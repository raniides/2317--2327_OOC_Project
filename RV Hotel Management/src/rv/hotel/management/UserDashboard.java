
package rv.hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


/**
 *
 * @author raani
 */
public class UserDashboard extends JFrame implements ActionListener {
    
    JLabel lblusername,lblidname,lblidnumber,lblroomnumber,lblbedtype,lbltotalmembers,lbltotalprice,lbldeposit,lblpendingamount,lblcheckintime;
    JButton logout,nearby,ibox,contact,restraurantmenu;
    private String username;
    private String password;
    
    UserDashboard(String usern, String passw) {
        
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        JLabel heading = new JLabel("Personal Details");
        heading.setBounds(516,40,400,35);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);
        
        JLabel lblname = new JLabel("User Name");
        lblname.setBounds(360, 110, 170, 30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblname);
        
        lblusername =new JLabel();
        lblusername.setBounds(550,110,170,30);
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblusername);
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(360, 160, 170, 30);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblid);
        
        lblidname =new JLabel();
        lblidname.setBounds(550,160,170,30);
        lblidname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblidname);
        
        JLabel lblidnu = new JLabel("ID Number");
        lblidnu.setBounds(360, 210, 170, 30);
        lblidnu.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblidnu);
        
        lblidnumber =new JLabel();
        lblidnumber.setBounds(550,210,170,30);
        lblidnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblidnumber);
        
        JLabel lblroomnu = new JLabel("Room Number");
        lblroomnu.setBounds(360, 260, 170, 30);
        lblroomnu.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblroomnu);
        
        lblroomnumber =new JLabel();
        lblroomnumber.setBounds(550,260,170,30);
        lblroomnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblroomnumber);
        
        JLabel lblbtype = new JLabel("Bed Type");
        lblbtype.setBounds(360, 310, 170, 30);
        lblbtype.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblbtype);
        
        lblbedtype =new JLabel();
        lblbedtype.setBounds(550,310,170,30);
        lblbedtype.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblbedtype);
        
        JLabel lblmember = new JLabel("Total Members");
        lblmember.setBounds(360, 360, 170, 30);
        lblmember.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblmember);
        
        lbltotalmembers =new JLabel();
        lbltotalmembers.setBounds(550,360,170,30);
        lbltotalmembers.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbltotalmembers);
        
        JLabel lblprice = new JLabel("Total Price");
        lblprice.setBounds(360, 410, 170, 30);
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblprice);
        
        lbltotalprice =new JLabel();
        lbltotalprice.setBounds(550,410,170,30);
        lbltotalprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbltotalprice);
        
        JLabel lbldamount = new JLabel("Deposit");
        lbldamount.setBounds(360, 460, 170, 30);
        lbldamount.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lbldamount);
        
        lbldeposit =new JLabel();
        lbldeposit.setBounds(550,460,170,30);
        lbldeposit.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldeposit);
        
        JLabel lblpamount = new JLabel("Pending Amount");
        lblpamount.setBounds(360, 510, 170, 30);
        lblpamount.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblpamount);
        
        lblpendingamount =new JLabel();
        lblpendingamount.setBounds(550,510,170,30);
        lblpendingamount.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblpendingamount);
        
        JLabel lblcheck = new JLabel("Checkin Time");
        lblcheck.setBounds(360, 560, 170, 30);
        lblcheck.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblcheck);
        
        lblcheckintime =new JLabel();
        lblcheckintime.setBounds(550,560,200,30);
        lblcheckintime.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblcheckintime);
        
        this.username = usern;
        this.password = passw;
        
         try{
            Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery("select * from userlogin where username = '"+usern+"' and password = '"+passw+"'");
            
            while(rs.next()){
                lblidnumber.setText(rs.getString("id_number"));
                lblroomnumber.setText(rs.getString("room_allocated"));
            
            String id_num = rs.getString("id_number");
            String room_num = rs.getString("room_allocated");
            
            ResultSet rs2 = c.s.executeQuery("select * from customer where id_number = '"+id_num+"' ");
            
            while(rs2.next()){
                lblusername.setText(rs2.getString("name"));
                lblidname.setText(rs2.getString("id_name"));
                lblbedtype.setText(rs2.getString("bed_type"));
                lbltotalmembers.setText(rs2.getString("total_members"));
                lbldeposit.setText(rs2.getString("deposit"));
                lblcheckintime.setText(rs2.getString("checkin_time"));
                
            String depo = rs2.getString("deposit");
            
            ResultSet rs3 = c.s.executeQuery("select * from room where roomnumber = '"+room_num+"'");
            
            while(rs3.next()){
                lbltotalprice.setText(rs3.getString("price"));
                String price = rs3.getString("price");
                    int amounttoPay = Integer.parseInt(price) - Integer.parseInt(depo);
                    lblpendingamount.setText(" " + amounttoPay);
            }
            
            }
          } 
       }catch(Exception e){
            e.printStackTrace();
        }
         
        nearby = new JButton("Near By Locations");
        nearby.setForeground(Color.BLACK);
        nearby.setBackground(Color.WHITE);
        nearby.setBounds(800,120,200,45);
        nearby.setFont(new Font("Tahoma",Font.PLAIN,20));
        nearby.addActionListener(this);
        add(nearby);
        
        ibox = new JButton("Issue Box");
        ibox.setForeground(Color.BLACK);
        ibox.setBackground(Color.WHITE);
        ibox.setBounds(800,260,200,45);
        ibox.setFont(new Font("Tahoma",Font.PLAIN,20));
        ibox.addActionListener(this);
        add(ibox);
        
        contact = new JButton("Contact List");
        contact.setForeground(Color.BLACK);
        contact.setBackground(Color.WHITE);
        contact.setBounds(800,400,200,45);
        contact.setFont(new Font("Tahoma",Font.PLAIN,20));
        contact.addActionListener(this);
        add(contact);
        
        restraurantmenu = new JButton("Food and Beverages");
        restraurantmenu.setForeground(Color.BLACK);
        restraurantmenu.setBackground(Color.WHITE);
        restraurantmenu.setBounds(800,540,200,45);
        restraurantmenu.setFont(new Font("Tahoma",Font.PLAIN,20));
        restraurantmenu.addActionListener(this);
        add(restraurantmenu);
        
        logout = new JButton("Logout");
        logout.setForeground(Color.BLACK);
        logout.setBackground(Color.WHITE);
        logout.setBounds(550,665,170,40);
        logout.setFont(new Font("Tahoma",Font.PLAIN,20));
        logout.addActionListener(this);
        add(logout);
        
        
        
        setBounds(80,60,1300,900);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == logout){
            setVisible(false);
            new UserLogin();
        }else if(ae.getSource() == contact){
            setVisible(false);
            new ContactList(username, password);
        }else if(ae.getSource() == restraurantmenu){
            setVisible(false);
            new FoodAndBeverages(username, password);
        }else if(ae.getSource() == nearby){
            setVisible(false);
            new NearBy(username, password);
        }else if(ae.getSource() == ibox){
            setVisible(false);
            new IssueBox(username, password);
        }
    }
    
    public static void main(String[] args){
        //new UserDashboard();
    }
}
