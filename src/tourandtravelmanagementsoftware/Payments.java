package tourandtravelmanagementsoftware;

import java.awt.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//import java.awt.Desktop;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JButton;
import javax.swing.JFrame;
public class Payments extends JFrame {

    public Payments() {
        setLayout(null);
        setBounds(600, 220, 800, 600);
        setTitle("DestiNations: Explore the World, Your Way");

        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/prj.jpg")); 
        setIconImage(icon.getImage());
        
        JLabel label = new JLabel("Pay using JazzCash");
        label.setFont(new Font("Raleway", Font.BOLD, 40));
        label.setBounds(50, 20, 500, 45);
        add(label);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/jazz.jpg"));
        Image i8 = i7.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l4 = new JLabel(i9);
        l4.setBounds(80, 200, 400, 300); 
        add(l4);

        JButton pay = new JButton("Pay");
        pay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                   try {
                    Desktop.getDesktop().browse(new URI("https://www.jazz.com.pk/"));
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });
        pay.setBounds(500, 30, 100, 30); 
        add(pay);

        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        back.setBounds(620, 30, 100, 30);
        add(back);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Payments();
    }
}
