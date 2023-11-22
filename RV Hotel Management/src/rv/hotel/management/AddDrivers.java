
package rv.hotel.management;

/**
 *
 * @author raani
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDrivers extends JFrame implements ActionListener{
    
    JTextField tfname,tfage,tfcarcompany,tfcarmodel,tflocation;
    JComboBox gendercombo,availablecombo;
    JButton add, back;
    
    AddDrivers(){
      
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD DRIVERS");
        heading.setBounds(150,30,400,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,100,220,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(270,100,170,30);
        tfname.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(tfname);
        
        JLabel lblage = new JLabel("Age");
        lblage.setBounds(60,180,220,30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(270,180,170,30);
        tfage.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(tfage);
        
         JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,260,220,30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblgender);
        
        String genderOption[] = { "Male", "Female","Others"};
        gendercombo = new JComboBox(genderOption);
        gendercombo.setBounds(270,260,170,30);
        gendercombo.setBackground(Color.WHITE);
        gendercombo.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(gendercombo);
        
        
        JLabel lblcarcompany = new JLabel("Car Company");
        lblcarcompany.setBounds(60,340,220,30);
        lblcarcompany.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblcarcompany);
        
        tfcarcompany = new JTextField();
        tfcarcompany.setBounds(270,340,170,30);
        tfcarcompany.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(tfcarcompany);
        
        JLabel lblcarmodel = new JLabel("Car Model");
        lblcarmodel.setBounds(60,420,220,30);
        lblcarmodel.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblcarmodel);
        
        tfcarmodel = new JTextField();
        tfcarmodel.setBounds(270,420,170,30);
        tfcarmodel.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(tfcarmodel);
        
        JLabel lblavailable = new JLabel("Availaibility");
        lblavailable.setBounds(60,500,220,30);
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblavailable);
        
        String driverOption[] = { "Avaialble", "Busy"};
        availablecombo = new JComboBox(driverOption);
        availablecombo.setBounds(270,500,170,30);
        availablecombo.setBackground(Color.WHITE);
        availablecombo.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(availablecombo);
        
        JLabel lbllocation = new JLabel("Location");
        lbllocation.setBounds(60,580,220,30);
        lbllocation.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lbllocation);
        
        tflocation = new JTextField();
        tflocation.setBounds(270,580,170,30);
        tflocation.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(tflocation);
        
        add = new JButton("Add Driver");
        add.setForeground(Color.BLACK);
        add.setBackground(Color.WHITE);
        add.setBounds(80,660,130,40);
        add.setFont(new Font("Tahoma",Font.PLAIN,15));
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.setBounds(260,660,130,40);
        back.setFont(new Font("Tahoma",Font.PLAIN,15));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/l3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750,720,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550,50,700,680);
        add(image);
        
        setBounds(80,60,1300,900);
        setVisible(true);
        
    }
    
     public void actionPerformed(ActionEvent ae){
         if (ae.getSource() == add ){
             String name = tfname.getText();
             String age = tfage.getText();
             String gender = (String) gendercombo.getSelectedItem();
             String car_company = tfcarcompany.getText();
             String car_model = tfcarmodel.getText();
             String availability = (String) availablecombo.getSelectedItem();
             String location = tflocation.getText();
             
             try {
                 Conn conn =new Conn();
                 
                 String query = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+car_company+"','"+car_model+"','"+availability+"','"+location+"')";
                 
                 conn.s.executeUpdate(query);
                 
                 JOptionPane.showMessageDialog(null,"New Driver added successfully");
            
                 setVisible(false);
                 new Dashboard();
                 
             }catch (Exception e){
                 e.printStackTrace();
             }
             
         }else if(ae.getSource()==back){
             setVisible(false);
             new Dashboard();
         }
     }
    
     public static void main(String[] args){
        new AddDrivers();
    }
    
}
