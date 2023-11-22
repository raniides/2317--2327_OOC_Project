
package rv.hotel.management;

/**
 *
 * @author raani
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener{
    
    JTextField tfroomno,tfprice;
    JComboBox availablecombo,cleancombo,typecombo;
    JButton add, cancel;
    
    AddRooms(){
      
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD ROOMS");
        heading.setBounds(150,60,400,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);
        
        JLabel lblroomno = new JLabel("Room Number");
        lblroomno.setBounds(60,180,220,30);
        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblroomno);
        
        tfroomno = new JTextField();
        tfroomno.setBounds(270,180,170,30);
        tfroomno.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(tfroomno);
        
        JLabel lblavailable = new JLabel("Availability");
        lblavailable.setBounds(60,260,220,30);
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblavailable);
        
        String availableOption[] = { "Available", "Occupied"};
        availablecombo = new JComboBox(availableOption);
        availablecombo.setBounds(270,260,170,30);
        availablecombo.setBackground(Color.WHITE);
        availablecombo.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(availablecombo);
        
        JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setBounds(60,340,220,30);
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblclean);
        
        String cleanOption[] = { "Clean", "Dirty"};
        cleancombo = new JComboBox(cleanOption);
        cleancombo.setBounds(270,340,170,30);
        cleancombo.setBackground(Color.WHITE);
        cleancombo.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(cleancombo);
        
        
        JLabel lblprice = new JLabel(" Price");
        lblprice.setBounds(60,420,220,30);
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblprice);
        
        tfprice = new JTextField();
        tfprice.setBounds(270,420,170,30);
        tfprice.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(tfprice);
        
        JLabel lbltype = new JLabel("Bed Type");
        lbltype.setBounds(60,500,220,30);
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lbltype);
        
        String typeOption[] = { "Single Bed", "Double Bed"};
        typecombo = new JComboBox(typeOption);
        typecombo.setBounds(270,500,170,30);
        typecombo.setBackground(Color.WHITE);
        typecombo.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(typecombo);
        
        add = new JButton("Add Room");
        add.setForeground(Color.BLACK);
        add.setBackground(Color.WHITE);
        add.setBounds(90,620,130,40);
        add.setFont(new Font("Tahoma",Font.PLAIN,15));
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.BLACK);
        cancel.setBackground(Color.WHITE);
        cancel.setBounds(260,620,130,40);
        cancel.setFont(new Font("Tahoma",Font.PLAIN,15));
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/l5.png"));
        Image i2 = i1.getImage().getScaledInstance(750,720,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(570,50,700,680);
        add(image);
        
        setBounds(80,60,1300,900);

        setVisible(true);
        
    }
    
     public void actionPerformed(ActionEvent ae){
         if (ae.getSource() == add ){
             String roomnumber = tfroomno.getText();
             String availability = (String) availablecombo.getSelectedItem();
             String cleaning_status = (String) cleancombo.getSelectedItem();
             String price = tfprice.getText();
             String bed_type = (String) typecombo.getSelectedItem();
             
             try {
                 Conn conn =new Conn();
                 
                 String query = "insert into room values('"+roomnumber+"','"+availability+"','"+cleaning_status+"','"+price+"','"+bed_type+"')";
                 
                 conn.s.executeUpdate(query);
                 
                 JOptionPane.showMessageDialog(null,"Room added successfully");
            
                 setVisible(false);
                 new Dashboard();
                 
             }catch (Exception e){
                 e.printStackTrace();
             }
             
         }else if(ae.getSource()==cancel){
             setVisible(false);
             new Dashboard();
         }
     }
    
     public static void main(String[] args){
        new AddRooms();
    }
    
}
