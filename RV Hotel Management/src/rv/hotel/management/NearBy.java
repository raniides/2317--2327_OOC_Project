
package rv.hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author raani
 */
public class NearBy extends JFrame implements ActionListener{
    
    JButton restraurants,outingplaces,shoping,beaches,back;
    private String username;
    private String password;
            
    NearBy(String usern, String passw){
        
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        this.username = usern;
        this.password = passw;
        
        JLabel heading = new JLabel("NearBy Locations");
        heading.setFont(new Font("Tahoma",Font.BOLD,35));
        heading.setBounds(510,100,350,50);
        add(heading);
        
        restraurants = new JButton("Restraurants");
        restraurants.setFont(new Font("Tahoma",Font.PLAIN,25));
        restraurants.setBounds(550,190,220,45);
        restraurants.addActionListener(this);
        add(restraurants);
        
        outingplaces = new JButton("Outing Places");
        outingplaces.setFont(new Font("Tahoma",Font.PLAIN,25));
        outingplaces.setBounds(550,300,220,45);
        outingplaces.addActionListener(this);
        add(outingplaces);
        
        beaches = new JButton("Beaches");
        beaches.setFont(new Font("Tahoma",Font.PLAIN,25));
        beaches.setBounds(550,410,220,45);
        beaches.addActionListener(this);
        add(beaches);
        
        back = new JButton("Back");
        back.setFont(new Font("Tahoma",Font.PLAIN,18));
        back.setBounds(600,500,100,40);
        back.addActionListener(this);
        add(back);
        
        setBounds(80,60,1300,900);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == restraurants){
            setVisible(false);
            new Restraurants(username, password);
        }else if(ae.getSource() == outingplaces){
            setVisible(false);
            new OutingPlaces(username, password);
        }else if(ae.getSource() == beaches){
            setVisible(false);
            new Beaches(username, password);
        }else if(ae.getSource() == back){
            setVisible(false);
            new UserDashboard(username, password);
        }
    }
    
    public static void main(String[] args){
       //new NearBy();
    }
}
