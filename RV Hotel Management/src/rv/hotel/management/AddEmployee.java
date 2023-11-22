
package rv.hotel.management;

/**
 *
 * @author raani
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField tfname, tfage,tfsalary,tfphone,tfemail,tfadhar;
    JRadioButton rbmale,rbfemale,rbother;
    JButton submit,back;
    JComboBox cbjob;
    
    AddEmployee() {
         
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD EMPLOYEE");
        heading.setBounds(150,30,400,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60,100,220,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(270,100,190,30);
        tfname.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(tfname);
        
        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60,180,220,30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(270,180,190,30);
        tfage.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(tfage);
        
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(50,260,150,30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblgender);
        
        ButtonGroup genderGroup = new ButtonGroup();
        
        rbmale = new JRadioButton("MALE");
        rbmale.setBounds(250,260,80,30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,16));
        rbmale.setBackground(Color.WHITE);
        genderGroup.add(rbmale);
        add(rbmale);
        
        rbfemale = new JRadioButton("FEMALE");
        rbfemale.setBounds(330,260,90,30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,16));
        rbfemale.setBackground(Color.WHITE);
        genderGroup.add(rbfemale);
        add(rbfemale);
        
        rbother = new JRadioButton("OTHERS");
        rbother.setBounds(420,260,100,30);
        rbother.setFont(new Font("Tahoma",Font.PLAIN,16));
        rbother.setBackground(Color.WHITE);
        genderGroup.add(rbother);
        add(rbother);
        
        JLabel lbljob = new JLabel("JOB");
        lbljob.setBounds(60,340,220,30);
        lbljob.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lbljob);
        
        String str[] = {"Front Desk Clerks","HouseKeeping","Security","IT staff","Human resource","Kitchen staff","Room Service","Accountant","Manager","Chef"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(270, 340, 190, 30);
        cbjob.setBackground(Color.WHITE);
        cbjob.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(cbjob);
        
        JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setBounds(60,420,220,30);
        lblsalary.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(270,420,190,30);
        tfsalary.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(tfsalary);
         
        JLabel lblphone = new JLabel("PHONE NO");
        lblphone.setBounds(60,500,220,30);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(270,500,190,30);
        tfphone.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(tfphone);
        
        JLabel lblemail = new JLabel("EMAIL ID");
        lblemail.setBounds(60,580,220,30);
        lblemail.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(270,580,190,30);
        tfemail.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(tfemail);
        
        JLabel lbladhar = new JLabel("AADHAR NO");
        lbladhar.setBounds(60,660,220,30);
        lbladhar.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lbladhar);
        
        tfadhar = new JTextField();
        tfadhar.setBounds(270,660,190,30);
        tfadhar.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
        add(tfadhar);
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.BLACK);
        submit.setBounds(90,720,150,30);
        submit.setFont(new Font("Tahoma",Font.PLAIN,15));
        submit.addActionListener(this);
        add(submit);
        
        back = new JButton("BACK");
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setBounds(300,720,150,30);
        back.setFont(new Font("Tahoma",Font.PLAIN,15));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/l4.png"));
        Image i2 = i1.getImage().getScaledInstance(750,720,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550,50,700,680);
        add(image);
        
       
        setBounds(80,60,1300,900);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String aadhar = tfadhar.getText();
        
        
        String gender = null;
        
        if (name.equals("")){
            JOptionPane.showMessageDialog(null, "name should not be empty");
            return;        
        }    
        
        if (rbmale.isSelected()){
            gender = "Male";
        }else if (rbfemale.isSelected()){
            gender = "Female";
        }
        
        String job = (String) cbjob.getSelectedItem();
        
        try{
            Conn conn = new Conn();
            
            String query = "insert into employee value('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
            
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"Employee added successfully");
            
            setVisible(false);
            new Dashboard();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Dashboard();
        }
         
        
    }
    
    public static void main(String[] args){
        new AddEmployee();
    }
}
