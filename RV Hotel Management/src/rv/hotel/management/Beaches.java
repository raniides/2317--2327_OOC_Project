
package rv.hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.awt.font.TextAttribute;
import java.net.URISyntaxException;
import java.util.Map;

/**
 *
 * @author raani
 */
public class Beaches extends JFrame implements ActionListener {
    
    JButton back;
    private String username;
    private String password;
    
    Beaches(String usern, String passw){
        
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        this.username = usern;
        this.password = passw;
        
        JLabel heading = new JLabel("Beaches");
        heading.setFont(new Font("Tahoma",Font.BOLD,22));
        heading.setBounds(590,10,240,30);
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/b1.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(70,60,250,250);
        add(image);
        
        JLabel b1 = new JLabel("Palolem Beach");
        b1.setFont(new Font("Tahoma",Font.BOLD,18));
        b1.setBounds(130,330,250,30);
        b1.setFont(underlineFont(b1.getFont()));
        addHoverEffect(b1);
        b1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebPage("https://www.google.com/maps/place/Palolem+Beach/@15.0093045,74.0162473,16z/data=!3m1!4b1!4m16!1m9!4m8!1m0!1m6!1m2!1s0x3bbe4551d05b02bb:0x1e1bc67d4b0fbbf5!2sPalolem+Beach,+Goa!2m2!1d74.0232186!2d15.0099648!3m5!1s0x3bbe4551d05b02bb:0x1e1bc67d4b0fbbf5!8m2!3d15.0099648!4d74.0232186!16zL20vMDgxZ3B3?entry=ttu"); 
            }
        });      
        add(b1);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/b2.jpeg"));
        Image i5 = i4.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(370,60,250,250);
        add(image2);
        
        JLabel b2 = new JLabel("Cavelossim Beach");
        b2.setFont(new Font("Tahoma",Font.BOLD,18));
        b2.setBounds(420,330,250,30);
        b2.setFont(underlineFont(b2.getFont()));
        addHoverEffect(b2);
        b2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebPage("https://www.google.com/maps/place/Cavelossim+Beach/@15.1715011,73.9208936,14z/data=!4m15!1m8!3m7!1s0x3bbe4fbb85faee3d:0xef5d75dacb8f9d45!2sAgonda,+Goa!3b1!8m2!3d15.0455814!4d73.9888797!16s%2Fg%2F11ck8blfx2!3m5!1s0x3bbe4c9f49875f71:0x1eecdaee21ef7f51!8m2!3d15.1715011!4d73.941493!16s%2Fg%2F1vvr4pg2?entry=ttu"); 
            }
        });     
        add(b2);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/b3.jpeg"));
        Image i8 = i7.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i9= new ImageIcon(i8);
        JLabel image3 = new JLabel(i9);
        image3.setBounds(670,60,250,250);
        add(image3);
        
        JLabel b3 = new JLabel("Cola Beach");
        b3.setFont(new Font("Tahoma",Font.BOLD,18));
        b3.setBounds(740,330,250,30);
        b3.setFont(underlineFont(b3.getFont()));
        addHoverEffect(b3);
        b3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebPage("https://www.google.com/maps/place/Cola+Beach/@15.0565596,73.9688422,17z/data=!3m1!4b1!4m6!3m5!1s0x3bbe4f034b05b837:0xf52f19eaf1b9498a!8m2!3d15.0565544!4d73.9714171!16s%2Fg%2F11c2lgppwk?entry=ttu"); 
            }
        });    
        add(b3);
        
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/b4.jpeg"));
        Image i11 = i10.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i12= new ImageIcon(i11);
        JLabel image4 = new JLabel(i12);
        image4.setBounds(980,60,250,250);
        add(image4);
        
        JLabel b4 = new JLabel("Talpona Beach");
        b4.setFont(new Font("Tahoma",Font.BOLD,18));
        b4.setBounds(1030,330,250,30);
        b4.setFont(underlineFont(b4.getFont()));
        addHoverEffect(b4);
        b4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebPage("https://www.google.com/maps/place/Talpona+Beach/@14.9779652,74.0362513,16z/data=!3m1!4b1!4m6!3m5!1s0x3bbe5ad7867f6cad:0x1081cae1c2f991b9!8m2!3d14.9780088!4d74.0419464!16s%2Fg%2F12h_f061k?entry=ttu"); 
            }
        });  
        add(b4);
        
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/b5.jpg"));
        Image i14 = i13.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i15= new ImageIcon(i14);
        JLabel image5 = new JLabel(i15);
        image5.setBounds(70,400,250,250);
        add(image5);
        
        JLabel b5 = new JLabel("Butterfly Beach");
        b5.setFont(new Font("Tahoma",Font.BOLD,18));
        b5.setBounds(120,670,250,30);
        b5.setFont(underlineFont(b5.getFont()));
        addHoverEffect(b5);
        b5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebPage("https://www.google.com/maps/place/Butterfly+Beach/@15.0194887,73.9990261,17z/data=!3m1!4b1!4m6!3m5!1s0x3bbe4f8a16e887f1:0x894249fead443527!8m2!3d15.0196019!4d74.001647!16s%2Fg%2F1tdy2y40?entry=ttu"); 
            }
        });  
        add(b5);
        
        ImageIcon i16 = new ImageIcon(ClassLoader.getSystemResource("icons/b6.jpeg"));
        Image i17 = i16.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i18= new ImageIcon(i17);
        JLabel image6 = new JLabel(i18);
        image6.setBounds(370,400,250,250);
        add(image6);
        
        JLabel b6 = new JLabel("Galjibaga Beach");
        b6.setFont(new Font("Tahoma",Font.BOLD,18));
        b6.setBounds(420,670,250,30);
        b6.setFont(underlineFont(b6.getFont()));
        addHoverEffect(b6);
        b6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebPage("https://www.google.com/maps/place/Galgibaga+Beach/@14.9600472,74.0495654,16z/data=!4m6!3m5!1s0x3bbe5b3c39a8699f:0x9ec1bd1c29b6b529!8m2!3d14.9600472!4d74.0495654!16s%2Fg%2F11c705xllf?entry=ttu"); 
            }
        });  
        add(b6);
        
        ImageIcon i19 = new ImageIcon(ClassLoader.getSystemResource("icons/b7.jpeg"));
        Image i20 = i19.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i21= new ImageIcon(i20);
        JLabel image7 = new JLabel(i21);
        image7.setBounds(670,400,250,250);
        add(image7);
        
        JLabel b7 = new JLabel("Kakolem Beach");
        b7.setFont(new Font("Tahoma",Font.BOLD,18));
        b7.setBounds(720,670,250,30);
        b7.setFont(underlineFont(b7.getFont()));
        addHoverEffect(b7);
        b7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebPage("https://www.google.com/maps/place/Kakolem+Beach/@15.0729885,73.9517427,17z/data=!3m1!4b1!4m6!3m5!1s0x3bbe4ec36f2ce65b:0x77a1454699faf368!8m2!3d15.073137!4d73.9546265!16s%2Fg%2F1ptwd6vvv?entry=ttu"); 
            }
        });  
        add(b7);
        
        ImageIcon i22 = new ImageIcon(ClassLoader.getSystemResource("icons/b8.jpeg"));
        Image i23 = i22.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i24= new ImageIcon(i23);
        JLabel image8 = new JLabel(i24);
        image8.setBounds(980,400,250,250);
        add(image8);
        
        JLabel b8 = new JLabel("Patnem Beach");
        b8.setFont(new Font("Tahoma",Font.BOLD,18));
        b8.setBounds(1030,670,250,30);
        b8.setFont(underlineFont(b8.getFont()));
        addHoverEffect(b8);
        b8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openWebPage("https://www.google.com/maps/place/Patnem+Beach/@14.9968807,74.0296136,17z/data=!3m1!4b1!4m6!3m5!1s0x3bbe5aca9031b523:0xd1cdb7bf01d791!8m2!3d14.9968861!4d74.0335008!16s%2Fg%2F1tgdgfgw?entry=ttu"); 
            }
        });  
        add(b8);
        
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
        //new Beaches();
    }
}
