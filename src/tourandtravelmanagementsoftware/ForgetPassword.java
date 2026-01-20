package tourandtravelmanagementsoftware;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener {

    JTextField tfusername;
    JTextField tfname;
    JTextField tfanswer;
    JTextField tfquestion;
    JButton search;
    JButton back;

    JTextField tfpassword;
    JButton retrieve;

    ;

    ForgetPassword() {
        setBounds(350, 200, 850, 380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("DestiNations: Explore the World, Your Way");

        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/prj.jpg"));
        setIconImage(icon.getImage());

        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 70, 200, 200);
        add(image);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 500, 280);

        JLabel lblusername = new JLabel("Username:");
        lblusername.setBounds(40, 20, 100, 25);
        lblusername.setFont(new Font("SAN SERIF", Font.PLAIN, 18));
        p1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(220, 20, 150, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        search = new JButton("Search");
        search.setBackground(Color.gray);
        search.setForeground(Color.white);
        search.setBounds(380, 20, 100, 25);
        search.setFocusable(false);
        search.addActionListener(this);
        p1.add(search);

        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(40, 60, 100, 25);
        lblname.setFont(new Font("SAN SERIF", Font.PLAIN, 18));
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220, 60, 150, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel lblquestion = new JLabel("Favourite MCU character:");
        lblquestion.setBounds(40, 100, 180, 25);
        lblquestion.setFont(new Font("Exo", Font.PLAIN, 15));
        p1.add(lblquestion);

        tfquestion = new JTextField();
        tfquestion.setBounds(220, 100, 150, 25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);

        JLabel lblanswer = new JLabel("Answer:");
        lblanswer.setBounds(40, 140, 180, 25);
        lblanswer.setFont(new Font("Exo", Font.PLAIN, 15));
        p1.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(220, 140, 150, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.gray);
        retrieve.setFocusable(false);
        retrieve.setForeground(Color.white);
        retrieve.setBounds(380, 140, 100, 25);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel lblpassword = new JLabel("Password:");
        lblpassword.setBounds(40, 180, 150, 25);
        lblpassword.setFont(new Font("Exo", Font.PLAIN, 15));
        p1.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(220, 180, 150, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        back = new JButton("Back");
        back.setBackground(Color.gray);
        back.setForeground(Color.white);
        back.setBounds(150, 230, 100, 25);
        back.setFocusable(false);
        back.addActionListener(this);
        p1.add(back);

        add(p1);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String username = tfusername.getText().trim();

            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username cannot be empty.");
                return;
            }

            try {
                String query = "SELECT * FROM account WHERE username = '" + username + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfquestion.setText(rs.getString("security"));
                    tfquestion.setEditable(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Username not found.");
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred during search.");
            }
        } else if (ae.getSource() == retrieve) {
            String username = tfusername.getText().trim();
            String answer = tfanswer.getText().trim();

            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username cannot be empty.");
                return;
            }
            if (answer.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Answer cannot be empty.");
                return;
            }

            try {
                String query = "SELECT * FROM account WHERE answer = '" + answer + "' AND username = '" + username + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    tfpassword.setText(rs.getString("password"));
                } else {
                    JOptionPane.showMessageDialog(this, "No matching answer found!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred during retrieval.");
            }

        } else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new ForgetPassword();

    }

}
