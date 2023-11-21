package rv.hotel.management;

/**
 *
 * @author raani
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public  class RVHotelManagement extends JFrame implements ActionListener{

    RVHotelManagement(){
        setBounds(80,60,1300,900);
        setLayout(null);
        
        ImageIcon i1 =new  ImageIcon(ClassLoader.getSystemResource("icons/l11.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1300,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1300,900); // Location of x, Location of , length, bredth 
        add(image);
        
        JLabel text = new JLabel("RV HOTEL MANAGEMENT");
        text.setBounds(20,720,1000,45);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.PLAIN, 60));
        image.add(text);
        
        JButton next = new JButton("next");
        next.setBounds(1100, 720, 150, 40);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        
        next.setFont(new Font("serif",Font.PLAIN, 20));
        image.add(next);
        next.addActionListener(this);        
        
        setVisible(true);
        
        
        while(true){  // infinite loop
            text.setVisible(false);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
            try {
                Thread.sleep(600);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new AdminLogin();
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        new RVHotelManagement();
    }
    
}
