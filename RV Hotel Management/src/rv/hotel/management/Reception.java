
package rv.hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author raani
 */
public class Reception extends JFrame implements ActionListener {
    
    JButton dashboard,newcustomer,rooms,department,allemployee,customerinfo,managerinfo,checkout,updatependingstatus,roomstatus,pickup,updatedriverservice,logout,isbox;
    
    Reception(){
        
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        JLabel heading = new JLabel("Reception");
        heading.setBounds(950,30,200,40);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);
        
        newcustomer = new JButton("New Customer Form");
        newcustomer.setBounds(880,100,300,40);
        newcustomer.setFont(new Font("serif",Font.PLAIN,20));
        newcustomer.setBackground(Color.WHITE);
        newcustomer.setForeground(Color.BLACK);
        newcustomer.addActionListener(this);
        add(newcustomer);
        
        rooms = new JButton("Rooms");
        rooms.setBounds(880,150,300,40);
        rooms.setFont(new Font("serif",Font.PLAIN,20));
        rooms.setBackground(Color.WHITE);
        rooms.setForeground(Color.BLACK);
        rooms.addActionListener(this);
        add(rooms);
        
        department = new JButton("Department");
        department.setBounds(880,200,300,40);
        department.setFont(new Font("serif",Font.PLAIN,20));
        department.setBackground(Color.WHITE);
        department.setForeground(Color.BLACK);
        department.addActionListener(this);
        add(department);
        
        allemployee = new JButton("All Employees");
        allemployee.setBounds(880,250,300,40);
        allemployee.setFont(new Font("serif",Font.PLAIN,20));
        allemployee.setBackground(Color.WHITE);
        allemployee.setForeground(Color.BLACK);
        allemployee.addActionListener(this);
        add(allemployee);
        
        customerinfo = new JButton("Customers Info");
        customerinfo.setBounds(880,300,300,40);
        customerinfo.setFont(new Font("serif",Font.PLAIN,20));
        customerinfo.setBackground(Color.WHITE);
        customerinfo.setForeground(Color.BLACK);
        customerinfo.addActionListener(this);
        add(customerinfo);
        
        checkout = new JButton("Checkout");
        checkout.setBounds(880,350,300,40);
        checkout.setFont(new Font("serif",Font.PLAIN,20));
        checkout.setBackground(Color.WHITE);
        checkout.setForeground(Color.BLACK);
        checkout.addActionListener(this);
        add(checkout);
        
        updatependingstatus = new JButton("Update Pending Status");
        updatependingstatus.setBounds(880,400,300,40);
        updatependingstatus.setFont(new Font("serif",Font.PLAIN,20));
        updatependingstatus.setBackground(Color.WHITE);
        updatependingstatus.setForeground(Color.BLACK);
        updatependingstatus.addActionListener(this);
        add(updatependingstatus);
        
        roomstatus = new JButton("Update Room Status");
        roomstatus.setBounds(880,450,300,40);
        roomstatus.setFont(new Font("serif",Font.PLAIN,20));
        roomstatus.setBackground(Color.WHITE);
        roomstatus.setForeground(Color.BLACK);
        roomstatus.addActionListener(this);
        add(roomstatus);
        
        pickup = new JButton("Pickup Service");
        pickup.setBounds(880,500,300,40);
        pickup.setFont(new Font("serif",Font.PLAIN,20));
        pickup.setBackground(Color.WHITE);
        pickup.setForeground(Color.BLACK);
        pickup.addActionListener(this);
        add(pickup);
        
        updatedriverservice = new JButton("Update Driver Service");
        updatedriverservice.setBounds(880,550,300,40);
        updatedriverservice.setFont(new Font("serif",Font.PLAIN,20));
        updatedriverservice.setBackground(Color.WHITE);
        updatedriverservice.setForeground(Color.BLACK);
        updatedriverservice.addActionListener(this);
        add(updatedriverservice);
        
        dashboard = new JButton("Dashboard");
        dashboard.setBounds(880,600,300,40);
        dashboard.setFont(new Font("serif",Font.PLAIN,20));
        dashboard.setBackground(Color.WHITE);
        dashboard.setForeground(Color.BLACK);
        dashboard.addActionListener(this);
        add(dashboard);
        
        isbox = new JButton("Issue Box");
        isbox.setBounds(880,650,300,40);
        isbox.setFont(new Font("serif",Font.PLAIN,20));
        isbox.setBackground(Color.WHITE);
        isbox.setForeground(Color.BLACK);
        isbox.addActionListener(this);
        add(isbox);
        
        logout = new JButton("Logout");
        logout.setBounds(880,700,300,40);
        logout.setFont(new Font("serif",Font.PLAIN,20));
        logout.setBackground(Color.WHITE);
        logout.setForeground(Color.BLACK);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/l7.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50,90,800,650);
        add(image);
        
        setBounds(80,60,1300,900);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getActionCommand().equals("New Customer Form")){
            setVisible(false);
            new AddCustomer();
        }else if(ae.getSource() == rooms){
            setVisible(false);
            new Room();
        }else if(ae.getSource() == department){
            setVisible(false);
            new Department();
        }else if(ae.getSource() == allemployee){
            setVisible(false);
            new EmployeesInfo();
        }else if(ae.getSource() == customerinfo){
            setVisible(false);
            new CustomerInfo();
        }else if(ae.getSource() == updatedriverservice){
            setVisible(false);
            new UpdateDriverService();
        }else if(ae.getSource() == updatependingstatus){
            setVisible(false);
            new UpdateCheck();
        }else if(ae.getSource() == roomstatus){
            setVisible(false);
            new UpdateRoom();
        }else if(ae.getSource() == pickup){
            setVisible(false);
            new PickUpService();
        }else if(ae.getSource() == checkout){
            setVisible(false);
            new Checkout();
        }else if(ae.getSource() == logout){
            setVisible(false);
            new AdminLogin();
        }else if(ae.getSource() == dashboard){
            setVisible(false);
            new Dashboard();
        }else if(ae.getSource() == isbox){
            setVisible(false);
            new RIssueBox();
        }
            
    }
    
    public static void main(String[] args){
        new Reception();
    }
    
}
