package rv.hotel.management;

/**
 *
 * @author raani
 */
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateDriverService extends JFrame implements ActionListener {

    Choice cdriver;
    JTextField tfgender, tfcarmodel, tfcarcompany, tfavailaible;
    JButton back, check, update;

    UpdateDriverService() {

        getContentPane().setBackground(Color.PINK);
        setLayout(null);

        JLabel text = new JLabel("Update Driver Service");
        text.setBounds(160, 110, 400, 35);
        text.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(text);

        JLabel lbldriver = new JLabel("Name");
        lbldriver.setBounds(140, 230, 170, 30);
        lbldriver.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lbldriver);

        cdriver = new Choice();
        cdriver.setBounds(320, 230, 150, 25);
        cdriver.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(cdriver);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");

            while (rs.next()) {
                cdriver.add(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(140, 310, 170, 30);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblgender);

        tfgender = new JTextField();
        tfgender.setBounds(320, 310, 150, 25);
        tfgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfgender);

        JLabel lblcarmodel = new JLabel("Car Model");
        lblcarmodel.setBounds(140, 390, 170, 30);
        lblcarmodel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblcarmodel);

        tfcarmodel = new JTextField();
        tfcarmodel.setBounds(320, 390, 150, 25);
        tfcarmodel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfcarmodel);

        JLabel lblcarcompany = new JLabel("Car Company");
        lblcarcompany.setBounds(140, 470, 170, 30);
        lblcarcompany.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblcarcompany);

        tfcarcompany = new JTextField();
        tfcarcompany.setBounds(320, 470, 150, 25);
        tfcarcompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfcarcompany);

        JLabel lblavailaible = new JLabel("Availaibility");
        lblavailaible.setBounds(140, 550, 170, 30);
        lblavailaible.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblavailaible);

        tfavailaible = new JTextField();
        tfavailaible.setBounds(320, 550, 150, 25);
        tfavailaible.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfavailaible);

        check = new JButton("Check");
        check.setForeground(Color.BLACK);
        check.setBackground(Color.WHITE);
        check.setBounds(120, 630, 100, 35);
        check.setFont(new Font("Tahoma", Font.PLAIN, 20));
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setForeground(Color.BLACK);
        update.setBackground(Color.WHITE);
        update.setBounds(240, 630, 120, 35);
        update.setFont(new Font("Tahoma", Font.PLAIN, 20));
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.BLACK);
        back.setBounds(380, 630, 120, 35);
        back.setFont(new Font("Tahoma", Font.PLAIN, 20));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/l5.png"));
        Image i2 = i1.getImage().getScaledInstance(650, 720, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(630, 50, 600, 680);
        add(image);

        setBounds(80, 60, 1300, 900);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check) {
            try {
                String name = cdriver.getSelectedItem();
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from driver where name = '" + name + "'");

                while (rs.next()) {
                    tfgender.setText(rs.getString("gender"));
                    tfcarmodel.setText(rs.getString("car_model"));
                    tfcarcompany.setText(rs.getString("car_company"));
                    tfavailaible.setText(rs.getString("availability"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == update) {
            String name = cdriver.getSelectedItem();
            String available = tfavailaible.getText();

            try {
                Conn c = new Conn();
                c.s.executeUpdate("update driver set availability = '" + available + "'where name = '" + name + "'");

                JOptionPane.showMessageDialog(null, "Data Updated Successfully");

                setVisible(false);
                new Reception();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new UpdateDriverService();
    }

}
