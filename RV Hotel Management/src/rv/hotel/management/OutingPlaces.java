
package rv.hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 *
 * @author raani
 */
public class OutingPlaces extends JFrame implements ActionListener{
    
    JButton back;
    private String username;
    private String password;
    
    OutingPlaces(String usern, String passw){
        
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        this.username = usern;
        this.password = passw;
        
        JLabel heading = new JLabel("Outing Places");
        heading.setFont(new Font("Tahoma",Font.BOLD,22));
        heading.setBounds(550,10,240,30);
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/o1.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(60,80,250,250);
        add(image1);
        
        JLabel o1=new JLabel("Shri Mallikarjuna Swami Temple");
        o1.setBounds(40,350,300,30);
        o1.setFont(new Font("Tahoma", Font.BOLD, 18)); 
        o1.setFont(underlineFont(o1.getFont()));
        addHoverEffect(o1);
        o1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebPage("https://www.google.com/maps/place/Shri+Mallikarjuna+Swami+Temple/@15.022721,74.0737887,17z/data=!3m1!4b1!4m6!3m5!1s0x3bbe5a801aea0a11:0x7556b751f03aa387!8m2!3d15.0227158!4d74.0763636!16s%2Fm%2F0crc4_0?entry=ttu"); 
            }
        });  
        add(o1);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/o2.jpeg"));
        Image i5 = i4.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(360,80,250,250);
        add(image2);
        
        JLabel o2=new JLabel("Goa Jungle Adventure");
        o2.setBounds(390,350,250,30);
        o2.setFont(new Font("Tahoma", Font.BOLD, 18)); 
        o2.setFont(underlineFont(o2.getFont()));
        addHoverEffect(o2);
        o2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebPage("https://www.google.com/maps/place/Goa+Jungle+Adventure/@15.0072664,74.0300512,17z/data=!3m1!4b1!4m6!3m5!1s0x3bbe5ab2f6a88637:0x722561c5e59dd2af!8m2!3d15.0072612!4d74.0326261!16s%2Fg%2F11f15n54r1?entry=ttu"); 
            }
        });  
        add(o2);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/o3.jpeg"));
        Image i8 = i7.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image3 = new JLabel(i9);
        image3.setBounds(660,80,250,250);
        add(image3);
        
        JLabel o3=new JLabel("Samson's Kiosk ");
        o3.setBounds(710,350,250,30);
        o3.setFont(new Font("Tahoma", Font.BOLD, 18)); 
        o3.setFont(underlineFont(o3.getFont()));
        addHoverEffect(o3);
        o3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebPage("https://www.google.com/maps/place/Samsons+Kiosk+(Kayak+,surf+%26+Sup+centre)/@15.0080852,74.0232285,17z/data=!3m1!4b1!4m6!3m5!1s0x3bbe454d9287224f:0x4a6f0f95ffd9e21d!8m2!3d15.00808!4d74.0258034!16s%2Fg%2F1tcy7bbj?entry=ttu"); 
            }
        });  
        add(o3);
        
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/o4.jpeg"));
        Image i11 = i10.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel image4 = new JLabel(i12);
        image4.setBounds(960,80,250,250);
        add(image4);
        
        JLabel o4=new JLabel("Shree Lakhaneshwar Temple");
        o4.setBounds(960,350,320,30);
        o4.setFont(new Font("Tahoma", Font.BOLD, 18)); 
        o4.setFont(underlineFont(o4.getFont()));
        addHoverEffect(o4);
        o4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebPage("https://www.google.com/maps/place/Shree+Lakhaneshwar+Temple/@15.0595543,73.9960866,17z/data=!3m1!4b1!4m6!3m5!1s0x3bbe4fb3bbb9f3dd:0xf98f40dc42a002e1!8m2!3d15.0595491!4d73.9986615!16s%2Fg%2F11g6hw1053?entry=ttu"); 
            }
        });  
        add(o4);
        
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/o5.jpeg"));
        Image i14 = i13.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel image5 = new JLabel(i15);
        image5.setBounds(60,410,250,250);
        add(image5);
        
        JLabel o5=new JLabel("Shanti Divers");
        o5.setBounds(120,680,250,30);
        o5.setFont(new Font("Tahoma", Font.BOLD, 18)); 
        o5.setFont(underlineFont(o5.getFont()));
        addHoverEffect(o5);
        o5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebPage("https://www.google.com/maps/place/Shanti+Divers/@15.0033016,74.0242193,17z/data=!3m1!4b1!4m6!3m5!1s0x3bbe45521bf31ced:0xc25a4437ca94bf76!8m2!3d15.0032964!4d74.0267942!16s%2Fg%2F11gbxbl75k?entry=ttu"); 
            }
        });  
        add(o5);
        
        ImageIcon i16 = new ImageIcon(ClassLoader.getSystemResource("icons/o6.jpeg"));
        Image i17 = i16.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i18 = new ImageIcon(i17);
        JLabel image6 = new JLabel(i18);
        image6.setBounds(360,410,250,250);
        add(image6);
        
        JLabel o6=new JLabel("Silent Noise Club");
        o6.setBounds(410,680,250,30);
        o6.setFont(new Font("Tahoma", Font.BOLD, 18)); 
        o6.setFont(underlineFont(o6.getFont()));
        addHoverEffect(o6);
        o6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebPage("https://www.google.com/maps/place/Silent+Noise+Club/@15.0033255,74.0238739,17z/data=!3m1!4b1!4m6!3m5!1s0x3bbe454b8c654e09:0x1099f1a33a11a090!8m2!3d15.0033203!4d74.0264488!16s%2Fg%2F11b75hbxvq?entry=ttu"); 
            }
        });  
        add(o6);
        
        ImageIcon i19 = new ImageIcon(ClassLoader.getSystemResource("icons/o7.jpeg"));
        Image i20 = i19.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i21 = new ImageIcon(i20);
        JLabel image7 = new JLabel(i21);
        image7.setBounds(660,410,250,250);
        add(image7);
        
        JLabel o7=new JLabel("Leopard Valley");
        o7.setBounds(720,680,250,30);
        o7.setFont(new Font("Tahoma", Font.BOLD, 18)); 
        o7.setFont(underlineFont(o7.getFont()));
        addHoverEffect(o7);
        o7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebPage("https://www.google.com/maps/place/Leopard+Valley+Goa/@15.0347989,74.0118731,17z/data=!3m1!4b1!4m6!3m5!1s0x3bbe5abfb41ff69b:0x2c1dbdab31dc17b3!8m2!3d15.0347937!4d74.014448!16s%2Fg%2F11b6gns735?entry=ttu"); 
            }
        });  
        add(o7);
        
        ImageIcon i22 = new ImageIcon(ClassLoader.getSystemResource("icons/o8.png"));
        Image i23 = i22.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i24 = new ImageIcon(i23);
        JLabel image8 = new JLabel(i24);
        image8.setBounds(960,410,250,250);
        add(image8);
        
        JLabel o8=new JLabel("Shiva Shakti Yoga");
        o8.setBounds(1000,680,250,30);
        o8.setFont(new Font("Tahoma", Font.BOLD, 18)); 
        o8.setFont(underlineFont(o8.getFont()));
        addHoverEffect(o8);
        o8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebPage("https://www.google.com/maps/place/Shiva+Shakti+Yoga+Goa,+India/@14.9962618,74.0319092,17z/data=!3m1!4b1!4m6!3m5!1s0x3bbe4ee3f811c0b9:0x12193634559482ab!8m2!3d14.9962566!4d74.0344841!16s%2Fg%2F1q69ywzx_?entry=ttu"); 
            }
        });  
        add(o8);
        
        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.setBounds(580,720,140,40);
        back.setFont(new Font("Tahoma",Font.PLAIN,16));
        back.addActionListener(this);
        add(back);
        
        setBounds(80,60,1300,900);
        setVisible(true);
    }
    
    private static Font underlineFont(Font font) {
        Map<TextAttribute, Object> attributes = new java.util.HashMap<>(font.getAttributes());
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        return font.deriveFont(attributes);
    }
    
    private void addHoverEffect(JLabel label) {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setForeground(Color.BLUE); // Change color on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setForeground(Color.BLACK); // Restore color when not hovering
            }
        });
    }
       
    // Method to open a web page in the default browser
    private static void openWebPage(String url) {
        try {
            URI uri = new URI(url);
            Desktop.getDesktop().browse(uri);
        } catch (URISyntaxException | IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
             setVisible(false);
             new NearBy(username, password);
        }
    }
    
    public static void main(String[] args){
        //new OutingPlaces();
    }
    
}
