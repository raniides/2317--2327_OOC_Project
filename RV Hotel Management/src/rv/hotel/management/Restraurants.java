
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
public class Restraurants extends JFrame implements ActionListener{
    
    JButton back;
    private String username;
    private String password;
    
    Restraurants(String usern, String passw){
        
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        this.username = usern;
        this.password = passw;
        
        JLabel heading = new JLabel("Restraurants");
        heading.setFont(new Font("Tahoma",Font.BOLD,22));
        heading.setBounds(550,10,240,30);
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/r1.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(60,80,250,250);
        add(image1);
        
        JLabel r1=new JLabel("Zest Cafe");
        r1.setBounds(150,350,250,30);
        r1.setFont(new Font("Tahoma", Font.BOLD, 18)); 
        r1.setFont(underlineFont(r1.getFont()));
        addHoverEffect(r1);
        r1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebPage("https://www.google.com/maps/place/Zest+Cafe/@15.0095717,74.0218038,17z/data=!3m1!4b1!4m6!3m5!1s0x3bbe4553ce08c791:0xa44aa5ab1f7ead13!8m2!3d15.0095665!4d74.0243787!16s%2Fg%2F11cmxw9k8z?entry=ttu"); 
            }
        });  
        add(r1);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/r2.jpg"));
        Image i5 = i4.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(360,80,250,250);
        add(image2);
        
        JLabel r2=new JLabel("Cortas");
        r2.setBounds(450,350,250,30);
        r2.setFont(new Font("Tahoma", Font.BOLD, 18)); 
        r2.setFont(underlineFont(r2.getFont()));
        addHoverEffect(r2);
        r2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebPage("https://www.google.com/maps/place/Cortas/@14.9910275,74.0375944,17z/data=!3m1!4b1!4m6!3m5!1s0x3bbe5abf9a6d425f:0xadb163920fc687c7!8m2!3d14.9910223!4d74.0401693!16s%2Fg%2F11byxgl5xz?entry=ttu"); 
            }
        });  
        add(r2);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/r3.jpeg"));
        Image i8 = i7.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image3 = new JLabel(i9);
        image3.setBounds(660,80,250,250);
        add(image3);
        
        JLabel r3=new JLabel("Hungry house");
        r3.setBounds(700,350,250,30);
        r3.setFont(new Font("Tahoma", Font.BOLD, 18)); 
        r3.setFont(underlineFont(r3.getFont()));
        addHoverEffect(r3);
        r3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebPage("https://www.google.com/maps/place/Hungry+house/@14.9976632,74.0352605,17z/data=!3m1!4b1!4m6!3m5!1s0x3bbe456ffdbbb135:0x4a373c25dee503a7!8m2!3d14.997658!4d74.0378354!16s%2Fg%2F11tjr0n_6p?entry=ttu"); 
            }
        });  
        add(r3);
        
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/r4.jpeg"));
        Image i11 = i10.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel image4 = new JLabel(i12);
        image4.setBounds(960,80,250,250);
        add(image4);
        
        JLabel r4=new JLabel("Sea B Q");
        r4.setBounds(1050,350,250,30);
        r4.setFont(new Font("Tahoma", Font.BOLD, 18)); 
        r4.setFont(underlineFont(r4.getFont()));
        addHoverEffect(r4);
        r4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebPage("https://www.google.com/maps/place/Sea+B+Q/@14.9907483,74.036997,17z/data=!3m1!4b1!4m6!3m5!1s0x3bbe5abf9a6d425f:0xd334735721d069f9!8m2!3d14.9907431!4d74.0395719!16s%2Fg%2F11byxghh1y?entry=ttu"); 
            }
        });  
        add(r4);
        
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/r5.jpg"));
        Image i14 = i13.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel image5 = new JLabel(i15);
        image5.setBounds(60,410,250,250);
        add(image5);
        
        JLabel r5=new JLabel("Femmy's Kitchen");
        r5.setBounds(100,680,250,30);
        r5.setFont(new Font("Tahoma", Font.BOLD, 18)); 
        r5.setFont(underlineFont(r5.getFont()));
        addHoverEffect(r5);
        r5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebPage("https://www.google.com/maps/place/Femmy+Kitchen+(+USSR+RESTAURANT+)/@14.9920509,74.0400071,17z/data=!3m1!4b1!4m6!3m5!1s0x3bbe5bed7e48e11d:0x7a943012b4c8df08!8m2!3d14.9920457!4d74.042582!16s%2Fg%2F11thhs6zzh?entry=ttu"); 
            }
        });  
        add(r5);
        
        ImageIcon i16 = new ImageIcon(ClassLoader.getSystemResource("icons/r6.jpg"));
        Image i17 = i16.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i18 = new ImageIcon(i17);
        JLabel image6 = new JLabel(i18);
        image6.setBounds(360,410,250,250);
        add(image6);
        
        JLabel r6=new JLabel("Sushi Cafe");
        r6.setBounds(420,680,250,30);
        r6.setFont(new Font("Tahoma", Font.BOLD, 18)); 
        r6.setFont(underlineFont(r6.getFont()));
        addHoverEffect(r6);
        r6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebPage("https://www.google.com/maps/place/Sushi+Cafe/@15.0037243,74.0274698,17z/data=!3m1!4b1!4m9!3m8!1s0x3bbe454b2e2c0251:0x5bb32dc28820952f!5m2!4m1!1i2!8m2!3d15.0037191!4d74.0300447!16s%2Fg%2F11_v54dmq?entry=ttu"); 
            }
        });  
        add(r6);
        
        ImageIcon i19 = new ImageIcon(ClassLoader.getSystemResource("icons/r7.jpg"));
        Image i20 = i19.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i21 = new ImageIcon(i20);
        JLabel image7 = new JLabel(i21);
        image7.setBounds(660,410,250,250);
        add(image7);
        
        JLabel r7=new JLabel("The Curry Leaf");
        r7.setBounds(710,680,250,30);
        r7.setFont(new Font("Tahoma", Font.BOLD, 18)); 
        r7.setFont(underlineFont(r7.getFont()));
        addHoverEffect(r7);
        r7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebPage("https://www.google.com/maps/place/The+Curry+Leaf/@14.9952847,74.0367238,17z/data=!3m1!4b1!4m6!3m5!1s0x3bbe5bf1703fff85:0x239466c476bbb7c3!8m2!3d14.9952795!4d74.0392987!16s%2Fg%2F11fp1f7fhd?entry=ttu"); 
            }
        });  
        add(r7);
        
        ImageIcon i22 = new ImageIcon(ClassLoader.getSystemResource("icons/r8.jpg"));
        Image i23 = i22.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i24 = new ImageIcon(i23);
        JLabel image8 = new JLabel(i24);
        image8.setBounds(960,410,250,250);
        add(image8);
        
        JLabel r8=new JLabel("Ourem 88");
        r8.setBounds(1030,680,250,30);
        r8.setFont(new Font("Tahoma", Font.BOLD, 18)); 
        r8.setFont(underlineFont(r8.getFont()));
        addHoverEffect(r8);
        r8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebPage("https://www.google.com/maps/place/88,+Ourem+Rd,+Mohanbagh,+Palolem,+Canacona,+Goa+403702/@15.0080121,74.0287956,17z/data=!3m1!4b1!4m5!3m4!1s0x3bbe454d42c042e7:0x76323e7e4b2d5412!8m2!3d15.0080121!4d74.0287956?entry=ttu"); 
            }
        });  
        add(r8);
        
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
        //new Restraurants();
    }
    
}
