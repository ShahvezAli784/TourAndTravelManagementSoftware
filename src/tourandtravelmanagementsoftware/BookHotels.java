package tourandtravelmanagementsoftware;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;

public class BookHotels extends JFrame implements ActionListener {

    Choice cHotel, cAc, cFood;
    String username;
    JTextField tfpresons, tfdays;
    JLabel labe1UserName, lb1id, labe1number, labe1Phone, labe1Prize;
    JButton checkPrize, bookPakg, back;

    BookHotels(String username) {
        this.username = username;
        setBounds(350, 200, 1100, 600);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setTitle("DestiNations: Explore the World, Your Way");
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/prj.jpg"));
        setIconImage(icon.getImage());
        setResizable(false);

        JLabel text = new JLabel("Book Hotel");
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

        JLabel lb1Pkg = new JLabel("Select Hotel");
        lb1Pkg.setFont(new Font("Tahoma", Font.BOLD, 16));
        lb1Pkg.setBounds(40, 110, 150, 25);
        add(lb1Pkg);

        cHotel = new Choice();
        cHotel.setBounds(250, 110, 200, 20);
        add(cHotel);

        try {

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");

            while (rs.next()) {
                cHotel.add(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lb1Persons = new JLabel("Total Persons:");
        lb1Persons.setBounds(40, 150, 150, 25);
        lb1Persons.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lb1Persons);

        tfpresons = new JTextField("1");
        tfpresons.setBounds(250, 150, 200, 25);
        add(tfpresons);

        JLabel lb1Days = new JLabel("No. of Days:");
        lb1Days.setBounds(40, 190, 150, 25);
        lb1Days.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lb1Days);

        tfdays = new JTextField("1");
        tfdays.setBounds(250, 190, 200, 25);
        add(tfdays);

        JLabel lb1Ac = new JLabel("AC/Non-AC:");
        lb1Ac.setBounds(40, 230, 150, 25);
        lb1Ac.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lb1Ac);

        cAc = new Choice();
        cAc.setBounds(250, 230, 200, 20);
        cAc.add("AC");
        cAc.add("NON-AC");
        add(cAc);

        JLabel lb1food = new JLabel("Food Include:");
        lb1food.setBounds(40, 270, 150, 25);
        lb1food.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lb1food);

        cFood = new Choice();
        cFood.setBounds(250, 270, 200, 20);
        cFood.add("Yes");
        cFood.add("NO");
        add(cFood);

        JLabel lb1ID = new JLabel("ID:");
        lb1ID.setFont(new Font("Tahoma", Font.BOLD, 16));
        lb1ID.setBounds(40, 310, 150, 20);
        add(lb1ID);

        lb1id = new JLabel();
        lb1id.setBounds(250, 310, 200, 25);
        add(lb1id);

        JLabel lb1number = new JLabel("Number:");
        lb1number.setBounds(40, 350, 150, 25);
        lb1number.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lb1number);

        labe1number = new JLabel();
        labe1number.setBounds(250, 350, 150, 25);
        labe1number.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(labe1number);

        JLabel lb1Phone = new JLabel("Phone:");
        lb1Phone.setBounds(40, 390, 150, 25);
        add(lb1Phone);

        labe1Phone = new JLabel();
        labe1Phone.setBounds(250, 390, 200, 25);
        labe1Phone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(labe1Phone);

        JLabel lb1Prize = new JLabel("Total Prize:");
        lb1Prize.setBounds(40, 430, 150, 25);
        add(lb1Prize);

        labe1Prize = new JLabel();
        labe1Prize.setBounds(250, 430, 150, 25);
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

        checkPrize = new JButton("Check Hotel Price");
        checkPrize.setBounds(40, 490, 200, 25);
        checkPrize.setBackground(Color.BLACK);
        checkPrize.setForeground(Color.WHITE);
        checkPrize.setFocusable(false);
        checkPrize.setFont(new Font("Tahoma", Font.PLAIN, 14));
        checkPrize.addActionListener(this);
        add(checkPrize);

        bookPakg = new JButton("Book Hotel Package");
        bookPakg.setBounds(260, 490, 200, 25);
        bookPakg.setBackground(Color.BLACK);
        bookPakg.setForeground(Color.WHITE);
        bookPakg.setFocusable(false);
        bookPakg.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bookPakg.addActionListener(this);
        add(bookPakg);

        back = new JButton("Go Back");
        back.setBounds(480, 490, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFocusable(false);
        back.setFont(new Font("Tahoma", Font.PLAIN, 14));
        back.addActionListener(this);
        add(back);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("\\icons\\book.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(500, 50, 600, 400);
        add(image);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BookHotels("shezy1");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
        } else if (e.getSource() == checkPrize) {
            try {
                String query = "select * from hotel where name = '" + cHotel.getSelectedItem() + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {

                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int ac = Integer.parseInt(rs.getString("acroom"));

                    int persons = Integer.parseInt(tfpresons.getText());
                    int days = Integer.parseInt(tfdays.getText());

                    String acselected = cAc.getSelectedItem();
                    String foodselected = cAc.getSelectedItem();

                    if (persons * days > 0) {
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        labe1Prize.setText("Rs " + total);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please Enter Valid Values.");
                    }
                }
            } catch (Exception se) {
                se.printStackTrace();
            }

        } else {

            Conn c = new Conn();

            try {
                String q1 = "insert into Bookhotel values('" + labe1UserName.getText() + "', '" + cHotel.getSelectedItem() + "', '" + tfpresons.getText() + "', '" + tfdays.getText() + "', '" + cAc.getSelectedItem() + "', '" + cFood.getSelectedItem() + "', '" + lb1id.getText() + "', '" + labe1number.getText() + "', '" + labe1Phone.getText() + "', '" + labe1Prize.getText() + "')";
                c.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
            } catch (Exception ee) {
                System.out.println(ee.getMessage());
            }
        }

    }

}
