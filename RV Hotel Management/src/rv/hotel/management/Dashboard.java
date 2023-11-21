
package rv.hotel.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author raani
 */
public class Dashboard extends JFrame implements ActionListener {
    
    Dashboard() {
        setBounds(80,60,1300,900);
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/l1.jpeg"));
        
        Image i2 = i1.getImage().getScaledInstance(1300,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1300,900);
        add(image);
        
        JLabel text = new JLabel("WELCOMES YOU IN LALIT RESORT");
        text.setBounds(290,100,1100,50);
        text.setFont(new Font("Tahoma",Font.PLAIN,46));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);
        
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        mb.add(hotel);
        
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);
        
        JMenuItem logout = new JMenuItem("LOGOUT");
        logout.addActionListener(this);
        hotel.add(logout);
		
	JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.RED);
	mb.add(admin);
        
        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
	addemployee.addActionListener(this);
        admin.add(addemployee);
      

        JMenuItem addrooms = new JMenuItem("ADD ROOMS");
	addrooms.addActionListener(this);
        admin.add(addrooms);
        
        
        JMenuItem adddrivers = new JMenuItem("ADD DRIVERS");
        adddrivers.addActionListener(this);
	admin.add(adddrivers);
               
	setVisible(true);
        

       
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
        }else if (ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms();
        }else if (ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDrivers();
        }else if (ae.getActionCommand().equals("RECEPTION")){
            setVisible(false);
            new Reception();
        }else if(ae.getActionCommand().equals("LOGOUT")){
            setVisible(false);
            new AdminLogin();
        }
    }
    
    public static void main(String[] args){
        new Dashboard();
    }
}
