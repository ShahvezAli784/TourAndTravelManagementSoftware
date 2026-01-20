package tourandtravelmanagementsoftware;

import java.awt.Color;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;

public class DeleteAccount extends JFrame implements ActionListener {

    JTextField tfusername, tfpassword;
    JPanel p1;
    JButton dlt, back;

    DeleteAccount() {

        setBounds(350, 200, 450, 350);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("DestiNations: Explore the World, Your Way");

        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/prj.jpg"));
        setIconImage(icon.getImage());
        setResizable(false);

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 450, 350);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.black);
        p2.setBounds(0, 0, 450, 50);

        JLabel heading = new JLabel("Delete Account ");
        heading.setBounds(130, 10, 300, 40);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        p2.add(heading);

        JLabel lblusername = new JLabel("Username:");
        lblusername.setBounds(40, 80, 100, 25);
        lblusername.setFont(new Font("SAN SERIF", Font.PLAIN, 18));
        p1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(220, 80, 150, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(40, 150, 100, 25);
        lblPassword.setFont(new Font("SAN SERIF", Font.PLAIN, 18));
        p1.add(lblPassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(220, 150, 150, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        dlt = new JButton("Delete Account");
        dlt.setBounds(230, 230, 150, 50);
        dlt.setBackground(new Color(133, 193, 233));
        dlt.setForeground(Color.WHITE);
        dlt.setFocusable(false);
        dlt.addActionListener(this);
        dlt.setBorder(new LineBorder(new Color(133, 193, 233)));
        p1.add(dlt);

        back = new JButton("Back");
        back.setBackground(new Color(133, 193, 233));
        back.setForeground(Color.WHITE);
        back.setFocusable(false);
        back.setFont(new Font("Tahomn", Font.BOLD, 14));
        back.setBounds(30, 230, 150, 50);
        back.addActionListener(this);
        p1.add(back);

        add(p2);
        add(p1);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == dlt) {
            String usernameToDelete = tfusername.getText().trim();
            String password = tfpassword.getText().trim();

            // Validate inputs
            if (usernameToDelete.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username cannot be empty.");
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

            try {
                String deleteQuery = "DELETE FROM account WHERE username = '" + usernameToDelete + "' AND password = '" + password + "'";

                Conn c = new Conn();
                int rowsAffected = c.s.executeUpdate(deleteQuery);

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Account deleted successfully.");
                    setVisible(false);
                    new Login();
                } else {
                    JOptionPane.showMessageDialog(this, "Incorrect username or password.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred while deleting the account.");
            }

        } else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new DeleteAccount();
    }

}
