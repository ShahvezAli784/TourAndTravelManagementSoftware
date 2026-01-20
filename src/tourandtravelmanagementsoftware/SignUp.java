package tourandtravelmanagementsoftware;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.*;

public class SignUp extends JFrame implements ActionListener {

    JButton create;
    JButton back;

    JTextField tfusername, tfname, tfanswer;
    JPasswordField tfpassword;
    Choice security;

    SignUp() {
        setBounds(350, 200, 900, 360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("DestiNations: Explore the World, Your Way");

        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/prj.jpg"));
        setIconImage(icon.getImage());

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);

        JLabel lblusername = new JLabel("User Name:");
        lblusername.setFont(new Font("Tahomn", Font.BOLD, 14));
        lblusername.setBounds(50, 20, 125, 25);
        p1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(190, 20, 180, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        JLabel lblname = new JLabel("Name:");
        lblname.setFont(new Font("Tahomn", Font.BOLD, 14));
        lblname.setBounds(50, 60, 125, 25);
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(190, 60, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel lblpassword = new JLabel("Password:");
        lblpassword.setFont(new Font("Tahomn", Font.BOLD, 14));
        lblpassword.setBounds(50, 100, 125, 25);
        p1.add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(190, 100, 180, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        JLabel lblsecurity = new JLabel("Security Question:");
        lblsecurity.setFont(new Font("Tahomn", Font.BOLD, 12));
        lblsecurity.setBounds(50, 140, 125, 25);
        p1.add(lblsecurity);

        security = new Choice();
        security.add("Fav Character From MCU?");
        security.add("Rock OR Vin Diesel?");
        security.add("Your Lucky number?");
        security.add("Your ChildHood SuperHero?");
        security.setBounds(190, 140, 180, 125);
        security.setFont(new Font("Exo", Font.BOLD, 10));
        p1.add(security);

        JLabel lblanswer = new JLabel("Answer:");
        lblanswer.setFont(new Font("Tahomn", Font.BOLD, 14));
        lblanswer.setBounds(50, 180, 125, 25);
        p1.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(190, 180, 180, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        create = new JButton("Create");
        create.setFocusable(false);
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133, 193, 233));
        create.setFont(new Font("Tahomn", Font.BOLD, 14));
        create.setBounds(250, 250, 100, 30);

        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setFocusable(false);
        back.setForeground(new Color(133, 193, 233));
        back.setFont(new Font("Tahomn", Font.BOLD, 14));
        back.setBounds(80, 250, 100, 30);
        back.addActionListener(this);
        p1.add(back);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/signup.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(580, 50, 250, 250);
        add(image);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new Login();
        } else if (e.getSource() == create) {
            String username = tfusername.getText().trim();
            String name = tfname.getText().trim();
            String password = new String(tfpassword.getPassword()).trim();
            String question = security.getSelectedItem();
            String answer = tfanswer.getText().trim();

            // Validation
            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username cannot be empty.");
                return;
            }
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Name cannot be empty.");
                return;
            }
            if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Password cannot be empty.");
                return;
            }
            if (password.length() < 6) {
                JOptionPane.showMessageDialog(this, "Password must be at least 6 characters long.");
                return;
            }
            if (answer.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Security answer cannot be empty.");
                return;
            }

            String query = "INSERT INTO account VALUES('" + username + "', '" + name + "', '" + password + "', '" + question + "', '" + answer + "')";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Account created successfully.");
                setVisible(false);
                new Login();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error creating account. The username may already exist.");
            }
        }
    }

    public static void main(String[] args) {
        new SignUp();

    }
}
