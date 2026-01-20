package tourandtravelmanagementsoftware;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;
import java.util.Objects;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ViewBookedHotel extends JFrame implements ActionListener {

    JButton back;
    String username;
    JLabel labe1food,labe1ac,labe1days,labe1name; 
    ViewBookedHotel(String username) {
        this.username = username;

        setBounds(400, 200, 1000, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/prj.jpg"));
        setIconImage(icon.getImage());
        setResizable(false);

        JLabel text = new JLabel("VIEW Booked Hotel DETAILS");
        text.setBounds(60, 10, 300, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lb1UserName = new JLabel("Username:");
        lb1UserName.setBounds(30, 50, 150, 25);
        add(lb1UserName);

        JLabel labe1UserName = new JLabel();
        labe1UserName.setBounds(220, 50, 150, 25);
        add(labe1UserName);

        JLabel lb1ID = new JLabel("Hotel Name:");
        lb1ID.setBounds(30, 90, 150, 25);
        add(lb1ID);

        labe1name = new JLabel();
        labe1name.setBounds(220, 90, 150, 25);
        add(labe1name);

        JLabel lb1number = new JLabel("Total Persons:");
        lb1number.setBounds(30, 130, 150, 25);
        add(lb1number);

        JLabel lb1persons = new JLabel();
        lb1persons.setBounds(220, 130, 150, 25);
        add(lb1persons);

        JLabel lb1days = new JLabel("Total Days:");
        lb1days.setBounds(30, 170, 150, 25);
        add(lb1days);

         labe1days = new JLabel();
        labe1days.setBounds(220, 170, 150, 25);
        add(labe1days);
        
        
        JLabel lb1ac = new JLabel("AC/Non-AC:");
        lb1ac.setBounds(30, 210, 150, 25);
        add(lb1ac);

        labe1ac = new JLabel();
        labe1ac.setBounds(220, 210, 150, 25);
        add(labe1ac);
        
        
        JLabel lb1food = new JLabel("Food Included:");
        lb1food.setBounds(30, 250, 150, 25);
        add(lb1food);

        labe1food = new JLabel();
        labe1food.setBounds(220, 250, 150, 25);
        add(labe1food);

        JLabel lb1id = new JLabel("ID:");
        lb1id.setBounds(30, 290, 150, 25);
        add(lb1id);

        JLabel labe1ID = new JLabel();
        labe1ID.setBounds(220, 290, 150, 25);
        add(labe1ID);

        JLabel lb1gender = new JLabel("Number:");
        lb1gender.setBounds(30, 330, 150, 25);
        add(lb1gender);

        JLabel labe1number = new JLabel();
        labe1number.setBounds(220, 330, 150, 25);
        add(labe1number);

        JLabel lb1country = new JLabel("Phone:");
        lb1country.setBounds(30, 370, 150, 25);
        add(lb1country);

        JLabel labe1Phone = new JLabel();
        labe1Phone.setBounds(220, 370, 150, 25);
        add(labe1Phone);

        JLabel lb1address = new JLabel("Total Cost:");
        lb1address.setBounds(30, 410, 150, 25);
        add(lb1address);

        JLabel labe1Price = new JLabel();
        labe1Price.setBounds(220, 410, 150, 25);
        add(labe1Price);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFocusable(false);
        back.setFont(new Font("Tahomn", Font.BOLD, 14));
        back.setBounds(130, 460, 100, 35);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("\\icons\\bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBackground(Color.BLACK);
        image.setBounds(450, 20, 500, 400);
        add(image);

        try {
            String query = "select * from Bookhotel where username = '" + this.username + "'";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labe1UserName.setText(rs.getString("username"));
                labe1number.setText(rs.getString("number"));
                labe1ID.setText(rs.getString("id"));
                labe1Price.setText(rs.getString("price"));
                labe1Phone.setText(rs.getString("phone"));
                lb1persons.setText(rs.getString("persons"));
                
                labe1food.setText(rs.getString("food"));
                labe1ac.setText(rs.getString("ac"));
                labe1days.setText(rs.getString("days"));  
                labe1name.setText(rs.getString("hotel"));

            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        setVisible(true);

    }

    public static void main(String[] args) {
        new ViewBookedHotel("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
        }

    }

}
