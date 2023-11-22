
package rv.hotel.management;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;
/**
 *
 * @author raani
 */
public class AddCustomer extends JFrame implements ActionListener{
    
    JTextField tfidnumber,tfname,tfcountry,tfdeposit,tfbed,tftotalmember,tfusername,tfpassword;
    JComboBox comboidname;
    JRadioButton rbmale,rbfemale,rbother;
    Choice croom;
    JLabel checkintime;
    JButton add, back,check;
    
    AddCustomer(){
        
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(150,30,400,30);
        text.setFont(new Font("Tahoma",Font.BOLD,30));
        add(text);
        
        JLabel lblroom = new JLabel("Allocated Room Number ");
        lblroom.setBounds(50,80,220,30);
        lblroom.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblroom);
        
        
        croom = new Choice();
        
        try {
            Conn conn = new Conn();
            
            String query = "select * from room where availability = 'Available' ";
            
            ResultSet rs = conn.s.executeQuery(query);
            
            while(rs.next()){
                croom.add(rs.getString("roomnumber"));
                
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        croom.setBounds(290,80,170,30);
        croom.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(croom);
        
        check = new JButton("Check");
        check.setForeground(Color.BLACK);
        check.setBackground(Color.WHITE);
        check.setBounds(480,80,80,30);
        check.addActionListener(this);
        add(check);
        
        JLabel lblbedtype = new JLabel("Bed Type");
        lblbedtype.setBounds(50,120,220,30);
        lblbedtype.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblbedtype);
        
        tfbed = new JTextField();
        tfbed.setBounds(290,120,170,30);
        tfbed.setFont(new Font("Tahoma",Font.PLAIN,20));
        tfbed.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(tfbed);
        
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(50,170,220,30);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblid);
        
        String idOption[] = { "Aadhar Card", "Passport","Driving License","Voter-id Card","Ration Card"};
        comboidname = new JComboBox(idOption);
        comboidname.setBounds(290,170,150,30);
        comboidname.setBackground(Color.WHITE);
        comboidname.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(comboidname);
        
        JLabel lblidnumber = new JLabel("ID Number");
        lblidnumber.setBounds(50,220,220,30);
        lblidnumber.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblidnumber);
        
        tfidnumber = new JTextField();
        tfidnumber.setBounds(290,220,170,30);
        tfidnumber.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(tfidnumber);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,270,220,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(290,270,170,30);
        tfname.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(tfname);
        
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(50,320,150,30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblgender);
        
        ButtonGroup genderGroup = new ButtonGroup();
        
        rbmale = new JRadioButton("MALE");
        rbmale.setBounds(250,320,80,30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,16));
        rbmale.setBackground(Color.WHITE);
        genderGroup.add(rbmale);
        add(rbmale);
        
        rbfemale = new JRadioButton("FEMALE");
        rbfemale.setBounds(330,320,90,30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,16));
        rbfemale.setBackground(Color.WHITE);
        genderGroup.add(rbfemale);
        add(rbfemale);
        
        rbother = new JRadioButton("OTHERS");
        rbother.setBounds(430,320,100,30);
        rbother.setFont(new Font("Tahoma",Font.PLAIN,16));
        rbother.setBackground(Color.WHITE);
        genderGroup.add(rbother);
        add(rbother);
        
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(50,370,220,30);
        lblcountry.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(290,370,170,30);
        tfcountry.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(tfcountry);
        
        JLabel lbltotalmember = new JLabel("Total Member");
        lbltotalmember.setBounds(50,420,220,30);
        lbltotalmember.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lbltotalmember);
        
        tftotalmember = new JTextField();
        tftotalmember.setBounds(290,420,170,30);
        tftotalmember.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(tftotalmember);
        
        JLabel lbltime = new JLabel("Checkin time");
        lbltime.setBounds(50,470,250,30);
        lbltime.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lbltime);
        
        Date date = new Date();
        
        checkintime = new JLabel("" + date);
        checkintime.setBounds(290,470,220,30);
        checkintime.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(checkintime);
        
        JLabel lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(50,520,220,30);
        lbldeposit.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lbldeposit);
        
        tfdeposit = new JTextField();
        tfdeposit.setBounds(290,520,170,30);
        tfdeposit.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(tfdeposit);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(50,570,220,30);
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(290,570,170,30);
        tfusername.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(50,620,220,30);
        lblpassword.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(290,620,170,30);
        tfpassword.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(tfpassword);
        
        add = new JButton("Add Customer");
        add.setForeground(Color.BLACK);
        add.setBackground(Color.WHITE);
        add.setFont(new Font("Tahoma",Font.PLAIN,15));
        add.setBounds(100,680,130,40);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.PLAIN,15));
        back.setBounds(300,680,130,40);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/l2.png"));
        Image i2 = i1.getImage().getScaledInstance(750,720,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(570,50,700,680);
        add(image);
        
        setBounds(80,60,1300,900);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == check){
            String roomnum = croom.getSelectedItem();
            String query1 = "select * from room where roomnumber = '"+roomnum+"'";
            
            try {
                Conn c =new Conn();
                ResultSet rs = c.s.executeQuery(query1);
                
                while(rs.next()){
                    tfbed.setText(rs.getString("bed_type")); 
                }
            }catch (Exception e){
                e.printStackTrace();
            }
                
         }else if (ae.getSource() == add){
            
            String id_name = (String) comboidname.getSelectedItem();
            String id_number = tfidnumber.getText();
            String name = tfname.getText();
            
            String gender = null;
            if(rbmale.isSelected()){
                gender = "Male";
            } else {
                gender = "Female";
            }
            
            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String checkin_time = checkintime.getText();
            String deposit = tfdeposit.getText();
            String bed_type = tfbed.getText();
            String total_members = tftotalmember.getText();
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            try {
                Conn conn = new Conn();
                
                String query = "insert into customer values('"+room+"','"+bed_type+"','"+id_name+"','"+id_number+"','"+name+"','"+gender+"','"+country+"','"+total_members+"','"+checkin_time+"','"+deposit+"')";
                
                String query2 = "insert into userlogin values('"+id_number+"','"+room+"','"+username+"','"+password+"')";
                
                String query3 = "update room set availability = 'Occupied' where roomnumber = '"+room+"'";
                
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null,"New Customer added successfully");

                setVisible(false);
                
                new Reception();
                
            }catch (Exception e){
                e.printStackTrace();
            }
            
            
           
            
        }else if (ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new AddCustomer();
    }
}
