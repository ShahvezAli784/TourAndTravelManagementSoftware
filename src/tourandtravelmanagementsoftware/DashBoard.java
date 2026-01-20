// last wala mera projct h.
package tourandtravelmanagementsoftware;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.io.File;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class DashBoard extends JFrame implements ActionListener {

    String username;
    JButton addPersonalInfo, viewPersonalInfo, updatePersonalInfo, chckPkgs, bookPkg, viewPkg, viewHotel, destinations, bookHotel,
            payments, calculator, notepad, about,viewBooked,dltPersonalInfo;

    DashBoard(String username) {
        this.username = username;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        ImageIcon icn = new ImageIcon(getClass().getResource("/icons/prj.jpg"));
        setIconImage(icn.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("DestiNations: Explore the World, Your Way");

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.BLACK);
        p1.setBounds(0, 0, 1600, 50);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("\\icons\\dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        JLabel heading = new JLabel("DashBoard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.BLACK);
        p2.setBounds(0, 50, 300, 900);
        add(p2);
        
        JPanel p3 = new JPanel();
        p3.setLayout(null);
        p3.setBackground(Color.BLACK);
        p3.setBounds(300, 50, 1300, 70);
        add(p3);
        
        JLabel text = new JLabel("DestiNations: Explore the World, Your Way");
        text.setBounds(100, 0, 1200, 70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Rale way", Font.PLAIN, 55));
        p3.add(text);
        addPersonalInfo = new JButton("Add Personl Details");
        addPersonalInfo.setBounds(0, 0, 300, 50);
        addPersonalInfo.setBackground(Color.BLACK);
        addPersonalInfo.setForeground(Color.WHITE);
        addPersonalInfo.setFocusable(false);
        addPersonalInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addPersonalInfo.setMargin(new Insets(0, 0, 0, 60));
        addPersonalInfo.setFocusable(false);
        addPersonalInfo.addActionListener(this);
        p2.add(addPersonalInfo);

        updatePersonalInfo = new JButton("Update Personl Details");
        updatePersonalInfo.setBounds(0, 50, 300, 50);
        updatePersonalInfo.setBackground(Color.BLACK);
        updatePersonalInfo.setForeground(Color.WHITE);
        updatePersonalInfo.setFocusable(false);
        updatePersonalInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        updatePersonalInfo.setMargin(new Insets(0, 0, 0, 60));
        updatePersonalInfo.setFocusable(false);
        updatePersonalInfo.addActionListener(this);
        p2.add(updatePersonalInfo);

        viewPersonalInfo = new JButton("View  Details");
        viewPersonalInfo.setBounds(0, 100, 300, 50);
        viewPersonalInfo.setBackground(Color.BLACK);
        viewPersonalInfo.setForeground(Color.WHITE);
        viewPersonalInfo.setFocusable(false);
        viewPersonalInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPersonalInfo.setMargin(new Insets(0, 0, 0, 130));
        viewPersonalInfo.addActionListener(this);
        viewPersonalInfo.setFocusable(false);
        p2.add(viewPersonalInfo);

        dltPersonalInfo = new JButton("Delete Personal Details");
        dltPersonalInfo.setBounds(0, 150, 300, 50);
        dltPersonalInfo.setBackground(Color.BLACK);
        dltPersonalInfo.setForeground(Color.WHITE);
        dltPersonalInfo.setFocusable(false);
        dltPersonalInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        dltPersonalInfo.setMargin(new Insets(0, 0, 0, 15));
        dltPersonalInfo.setFocusable(false);
        dltPersonalInfo.addActionListener(this);
        p2.add(dltPersonalInfo);

        chckPkgs = new JButton("Check Packages");
        chckPkgs.setBounds(0, 200, 300, 50);
        chckPkgs.setBackground(Color.BLACK);
        chckPkgs.setForeground(Color.WHITE);
        chckPkgs.setFocusable(false);
        chckPkgs.setFont(new Font("Tahoma", Font.PLAIN, 20));
        chckPkgs.setMargin(new Insets(0, 0, 0, 110));
        chckPkgs.setFocusable(false);
        chckPkgs.addActionListener(this);
        p2.add(chckPkgs);

        bookPkg = new JButton("Book Package");
        bookPkg.setBounds(0, 250, 300, 50);
        bookPkg.setBackground(Color.BLACK);
        bookPkg.setForeground(Color.WHITE);
        bookPkg.setFocusable(false);
        bookPkg.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookPkg.setMargin(new Insets(0, 0, 0, 120));
        bookPkg.setFocusable(false);
        bookPkg.addActionListener(this);
        p2.add(bookPkg);

        viewPkg = new JButton("View Package");
        viewPkg.setBounds(0, 300, 300, 50);
        viewPkg.setBackground(Color.BLACK);
        viewPkg.setForeground(Color.WHITE);
        viewPkg.setFocusable(false);
        viewPkg.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPkg.setMargin(new Insets(0, 0, 0, 120));
        viewPkg.setFocusable(false);
        viewPkg.addActionListener(this);
        p2.add(viewPkg);

        viewHotel = new JButton("View Hotels");
        viewHotel.setBounds(0, 350, 300, 50);
        viewHotel.setBackground(Color.BLACK);
        viewHotel.setForeground(Color.WHITE);
        viewHotel.setFocusable(false);
        viewHotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewHotel.setMargin(new Insets(0, 0, 0, 130));
        viewHotel.setFocusable(false);
        viewHotel.addActionListener(this);
        p2.add(viewHotel);

        bookHotel = new JButton("Book Hotel");
        bookHotel.setBounds(0, 400, 300, 50);
        bookHotel.setBackground(Color.BLACK);
        bookHotel.setForeground(Color.WHITE);
        bookHotel.setFocusable(false);
        bookHotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookHotel.setMargin(new Insets(0, 0, 0, 140));
        bookHotel.setFocusable(false);
        bookHotel.addActionListener(this);
        p2.add(bookHotel);

        viewBooked = new JButton("View Booked Hotel");
        viewBooked.setBounds(0, 450, 300, 50);
        viewBooked.setBackground(Color.BLACK);
        viewBooked.setForeground(Color.WHITE);
        viewBooked.setFocusable(false);
        viewBooked.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewBooked.setMargin(new Insets(0, 0, 0, 70));
        viewBooked.setFocusable(false);
        viewBooked.addActionListener(this);
        p2.add(viewBooked);

        destinations = new JButton("Destinations");
        destinations.setBounds(0, 500, 300, 50);
        destinations.setBackground(Color.BLACK);
        destinations.setForeground(Color.WHITE);
        destinations.setFocusable(false);
        destinations.setFont(new Font("Tahoma", Font.PLAIN, 20));
        destinations.setMargin(new Insets(0, 0, 0, 125));
        destinations.setFocusable(false);
        destinations.addActionListener(this);
        p2.add(destinations);

        payments = new JButton("Payments");
        payments.setBounds(0, 550, 300, 50);
        payments.setBackground(Color.BLACK);
        payments.setForeground(Color.WHITE);
        payments.setFocusable(false);
        payments.setFont(new Font("Tahoma", Font.PLAIN, 20));
        payments.setMargin(new Insets(0, 0, 0, 155));
        payments.setFocusable(false);
        payments.addActionListener(this);
        p2.add(payments);

        calculator = new JButton("Calculator");
        calculator.setBounds(0, 600, 300, 50);
        calculator.setBackground(Color.BLACK);
        calculator.setForeground(Color.WHITE);
        calculator.setFocusable(false);
        calculator.setFont(new Font("Tahoma", Font.PLAIN, 20));
        calculator.setMargin(new Insets(0, 0, 0, 145));
        calculator.setFocusable(false);
        calculator.addActionListener(this);
        p2.add(calculator);

        notepad = new JButton("NotePad");
        notepad.setBounds(0, 650, 300, 50);
        notepad.setBackground(Color.BLACK);
        notepad.setForeground(Color.WHITE);
        notepad.setFocusable(false);
        notepad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        notepad.setMargin(new Insets(0, 0, 0, 145));
        notepad.setFocusable(false);
        notepad.addActionListener(this);
        p2.add(notepad);

        about = new JButton("About");
        about.setBounds(0, 700, 300, 50);
        about.setBackground(Color.BLACK);
        about.setForeground(Color.WHITE);
        about.setFocusable(false);
        about.setFont(new Font("Tahoma", Font.PLAIN, 20));
        about.setMargin(new Insets(0, 0, 0, 175));
        about.setFocusable(false);
        about.addActionListener(this);
        p2.add(about);
        

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("\\icons\\splash.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1300, 700, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(300, 110, 1300, 700);
        add(image);

       

        setVisible(true);
    }

    public static void main(String[] args) {
        new DashBoard("");
    }
             
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addPersonalInfo) {
            new AddCustomer(this.username);
        } else if (e.getSource() == viewPersonalInfo) {
            new ViewCustomer(this.username);
        } else if (e.getSource() == updatePersonalInfo) {
            new UpdatePersonalDetails(this.username);
        } else if (e.getSource() == chckPkgs) {
            new CheckPkgs();
        } else if (e.getSource() == bookPkg) {
            new BookPkg(this.username);
        } else if (e.getSource() == viewPkg) {
            new ViewPkg(this.username);
        } else if (e.getSource() == viewHotel) {
            new CheckHotels();
        } else if (e.getSource() == destinations) {
            new Destinations();
        } else if (e.getSource() == bookHotel) {
            new BookHotels(this.username);
        } else if (e.getSource() == payments) {
            new Payments();
        } else if (e.getSource() == calculator) {
            try {
                Desktop.getDesktop().open(new File("C:\\Windows\\System32\\calc.exe"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == notepad) {
            try {
                Desktop.getDesktop().open(new File("C:\\Windows\\System32\\notepad.exe"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == about) {
            new About();
        } else if (e.getSource() == viewBooked) {
            new ViewBookedHotel(this.username);
        }
        else if (e.getSource() == dltPersonalInfo) {
            new DeleteDetails(this.username);
        }
    }
    

}
