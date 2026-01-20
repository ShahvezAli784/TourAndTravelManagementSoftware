package tourandtravelmanagementsoftware;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;

public class BookPkg extends JFrame implements ActionListener {

    Choice cPkg;
    String username;
    JTextField tfpresons;
    JLabel labe1UserName, lb1id, labe1number, labe1Phone, labe1Prize;
    JButton checkPrize, bookPakg, back;

    BookPkg(String username) {
        this.username = username;
        setBounds(350, 200, 1100, 500);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setTitle("DestiNations: Explore the World, Your Way");
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/prj.jpg"));
        setIconImage(icon.getImage());
        setResizable(false);

        JLabel text = new JLabel("Book Package");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lb1UserName = new JLabel("Username:");
        lb1UserName.setFont(new Font("Tahoma", Font.BOLD, 16));
        lb1UserName.setBounds(40, 70, 100, 20);
        add(lb1UserName);

        labe1UserName = new JLabel();
        labe1UserName.setBounds(250, 70, 200, 20);
        labe1UserName.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(labe1UserName);

        JLabel lb1Pkg = new JLabel("Select Package");
        lb1Pkg.setFont(new Font("Tahoma", Font.BOLD, 16));
        lb1Pkg.setBounds(40, 110, 150, 25);
        add(lb1Pkg);

        cPkg = new Choice();
        cPkg.add("Gold Package");
        cPkg.add("Silver Package");
        cPkg.add("Bronze Package");
        cPkg.setBounds(250, 110, 200, 20);
        add(cPkg);

        JLabel lb1Persons = new JLabel("Total Persons:");
        lb1Persons.setBounds(40, 150, 150, 25);
        lb1Persons.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lb1Persons);

        tfpresons = new JTextField("1");
        tfpresons.setBounds(250, 150, 200, 25);
        add(tfpresons);

        JLabel lb1ID = new JLabel("ID:");
        lb1ID.setFont(new Font("Tahoma", Font.BOLD, 16));
        lb1ID.setBounds(40, 190, 150, 20);
        add(lb1ID);

        lb1id = new JLabel();
        lb1id.setBounds(250, 190, 200, 25);
        add(lb1id);

        JLabel lb1number = new JLabel("Number:");
        lb1number.setBounds(40, 230, 150, 25);
        lb1number.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lb1number);

        labe1number = new JLabel();
        labe1number.setBounds(250, 230, 150, 25);
        labe1number.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(labe1number);

        JLabel lb1Phone = new JLabel("Phone:");
        lb1Phone.setBounds(40, 270, 150, 25);
        add(lb1Phone);

        labe1Phone = new JLabel();
        labe1Phone.setBounds(250, 270, 200, 25);
        labe1Phone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(labe1Phone);

        JLabel lb1Prize = new JLabel("Total Prize:");
        lb1Prize.setBounds(40, 310, 150, 25);
        add(lb1Prize);

        labe1Prize = new JLabel();
        labe1Prize.setBounds(250, 310, 150, 25);
        labe1Prize.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(labe1Prize);

        try {
            String query = "select * from customer where username = '" + this.username + "'";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labe1UserName.setText(rs.getString("username"));
                labe1number.setText(rs.getString("number"));
                lb1id.setText(rs.getString("id"));
                labe1Phone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        checkPrize = new JButton("Price?");
        checkPrize.setBounds(60, 380, 120, 25);
        checkPrize.setBackground(Color.BLACK);
        checkPrize.setForeground(Color.WHITE);
        checkPrize.setFocusable(false);
        checkPrize.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkPrize.setFocusable(false);
        checkPrize.addActionListener(this);
        add(checkPrize);

        bookPakg = new JButton("Book Pkg");
        bookPakg.setBounds(200, 380, 120, 25);
        bookPakg.setBackground(Color.BLACK);
        bookPakg.setForeground(Color.WHITE);
        bookPakg.setFocusable(false);
        bookPakg.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookPakg.setFocusable(false);
        bookPakg.addActionListener(this);
        add(bookPakg);

        back = new JButton("Back");
        back.setBounds(340, 380, 120, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFocusable(false);
        back.setFont(new Font("Tahoma", Font.PLAIN, 20));
        back.setFocusable(false);
        back.addActionListener(this);
        add(back);
        
         ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("\\icons\\bookpackage.jpg"));
        Image i5 = i4.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(500,50,500,300);
        add(image);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BookPkg("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
        } else if (e.getSource() == checkPrize) {
            String pkg = cPkg.getSelectedItem();
            int cost = 0;
            if (pkg.equals("Gold Package")) {
                cost += 12000;
            } else if (pkg.equals("Silver Package")) {
                cost += 24000;
            } else {
                cost += 32000;
            }
            int person = Integer.parseInt(tfpresons.getText());
            cost *= person;
            labe1Prize.setText("Rs " + cost);

        } else {

            try {
                String query = "INSERT INTO bookpackage (username, package, persons, id, number, phone, price) VALUES (?, ?, ?, ?, ?, ?, ?)";
                Conn c = new Conn();
                PreparedStatement pstmt = c.prepareStatement(query);
                pstmt.setString(1, labe1UserName.getText());
                pstmt.setString(2, cPkg.getSelectedItem().toString());
                pstmt.setString(3, tfpresons.getText());
                pstmt.setString(4, lb1id.getText());
                pstmt.setString(5, labe1number.getText());
                pstmt.setString(6, labe1Phone.getText());
                pstmt.setString(7, labe1Prize.getText());

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Package booked successfully.");
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to book package.");
                }
            } catch (Exception ae) {
                ae.printStackTrace();
            }

        }

    }

}
