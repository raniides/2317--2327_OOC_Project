
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

public class EmployeesInfo extends JFrame implements ActionListener{
    JTable table;
    JButton search,back;
    JComboBox job;
    
    EmployeesInfo(){
        
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        JLabel heading = new JLabel("EMPLOYEES INFO");
        heading.setBounds(550,10,400,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        add(heading);
        
        JLabel lbljob = new JLabel("JOB");
        lbljob.setBounds(100,50,40,30);
        lbljob.setFont(new Font("Tahoma", Font.PLAIN, 18)); 
        add(lbljob);
        
        job = new JComboBox(new String[]{"All","Front Desk Clerks","HouseKeeping","Security","IT staff","Human resource","Kitchen staff","Room Service","Accountant","Manager","Chef"});
        job.setBounds(150,50,180,30);
        job.setBackground(Color.WHITE);
        add(job);
        
        search = new JButton("Search");
        search.setForeground(Color.BLACK);
        search.setBackground(Color.WHITE);
        search.setBounds(330,50,100,30);
        search.addActionListener(this);
        add(search);
        
        JLabel l1=new JLabel("Employee_Name");
        l1.setBounds(15,90,140,20);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 18)); 
        add(l1);
        
        JLabel l2= new JLabel("Age");
        l2.setBounds(210,90,100,20);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 18)); 
        add(l2);
        
        JLabel l3= new JLabel("Gender");
        l3.setBounds(360,90,100,20);
        l3.setFont(new Font("Tahoma", Font.PLAIN, 18)); 
        add(l3);
        
        JLabel l4= new JLabel("Job");
        l4.setBounds(530,90,100,20);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 18)); 
        add(l4);
        
        JLabel l5= new JLabel("Salary");
        l5.setBounds(670,90,100,20);
        l5.setFont(new Font("Tahoma", Font.PLAIN, 18)); 
        add(l5);
        
        JLabel l6= new JLabel("Phone_NO");
        l6.setBounds(840,90,100,20);
        l6.setFont(new Font("Tahoma", Font.PLAIN, 18)); 
        add(l6);
        
        JLabel l7= new JLabel("Email_ID");
        l7.setBounds(1010,90,100,20);
        l7.setFont(new Font("Tahoma", Font.PLAIN, 18)); 
        add(l7);
        
        JLabel l8= new JLabel("Aadhar_NO");
        l8.setBounds(1160,90,100,20);
        l8.setFont(new Font("Tahoma", Font.PLAIN, 18)); 
        add(l8);
        
        table= new JTable();
        table.setBounds(0,120,1300,590);
        table.setBackground(Color.PINK);
        table.setFont(new Font("Tahoma", Font.PLAIN, 18)); 
        table.setRowHeight(30);
        add(table);
        
        try{
            Conn c =new Conn();
            ResultSet rs= c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs)); 
        }catch(Exception e){
            e.printStackTrace();
        }
        
        table.setShowGrid(true);
        table.setGridColor(Color.BLACK);
        
        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.setBounds(600,730,120,40);
        back.setFont(new Font("Tahoma", Font.PLAIN, 20));
        back.addActionListener(this);
        add(back);
        
        
        setBounds(80,60,1300,900);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            try {
             String employeeAll = (String) job.getSelectedItem();
                
            String query1 = "select * from employee where job = '"+job.getSelectedItem()+"'";
            String query2 = "select * from employee";
               
            
            Conn c = new Conn();
            ResultSet rs;
            
            rs = c.s.executeQuery(query1);
            
            if(employeeAll.equals("All")){
                    rs = c.s.executeQuery(query2);
             }
            
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == back){
        setVisible(false);
        new Reception();
        }
    }
    
    public static void main(String[] args){
        new EmployeesInfo();
    }
    
}
