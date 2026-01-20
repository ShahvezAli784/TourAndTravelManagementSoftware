package tourandtravelmanagementsoftware;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;
import java.util.Objects;

public class ViewPkg extends JFrame implements ActionListener {
    
    JButton back;
    String username;
    ViewPkg(String username){
        this.username = username;
        
        setBounds(450,200,900,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);   
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
        setTitle("DestiNations: Explore the World, Your Way");
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/prj.jpg")); 
        setIconImage(icon.getImage());
        setResizable(false);

        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setBounds(60,10,300,30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        
        JLabel lb1UserName = new JLabel("Username:");
        lb1UserName.setBounds(30,50,150,25);
        add(lb1UserName);
        
        JLabel labe1UserName = new JLabel();
        labe1UserName.setBounds(220,50,150,25);
        add(labe1UserName);
        
        JLabel lb1ID = new JLabel("Package:");
        lb1ID.setBounds(30,90,150,25);
        add(lb1ID);
        
        JLabel labe1Pkg = new JLabel();
        labe1Pkg.setBounds(220,90,150,25);
        add(labe1Pkg);
        
        
        
        JLabel lb1number = new JLabel("Total Persons:");
        lb1number.setBounds(30,130,150,25);
        add(lb1number);
        
        JLabel lb1persons = new JLabel();
        lb1persons.setBounds(220,130,150,25);
        add(lb1persons);
        
         JLabel lb1name = new JLabel("ID:");
        lb1name.setBounds(30,170,150,25);
        add(lb1name);
        
        JLabel labe1ID = new JLabel();
        labe1ID.setBounds(220,170,150,25);
        add(labe1ID);
        
        
        
        JLabel lb1gender = new JLabel("Number:");
        lb1gender.setBounds(30,210,150,25);
        add(lb1gender);
        
        JLabel labe1number = new JLabel();
        labe1number.setBounds(220,210,150,25);
        add(labe1number);

        
         JLabel lb1country = new JLabel("Phone:");
        lb1country.setBounds(30,250,150,25);
        add(lb1country);
        
        JLabel labe1Phone = new JLabel();
        labe1Phone.setBounds(220,250,150,25);
        add(labe1Phone);
        
         JLabel lb1address = new JLabel("Price:");
        lb1address.setBounds(30,290,150,25);
        add(lb1address);
        
        JLabel labe1Price = new JLabel();
        labe1Price.setBounds(220,290,150,25);
        add(labe1Price);
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFocusable(false);
        back.setFont(new Font("Tahomn",Font.BOLD,14));
        back.setBounds(130,360,100,35);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("\\icons\\bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBackground(Color.BLACK);
        image.setBounds(450,20,500,400);
        add(image);
        
      
        
        
        
        try{
            String query = "select * from bookpackage where username = '"+ this.username +"'";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labe1UserName.setText(rs.getString("username"));           
                labe1number.setText(rs.getString("number"));
                labe1ID.setText(rs.getString("id"));
                labe1Pkg.setText(rs.getString("package")); 
                labe1Price.setText(rs.getString("price")); 
                labe1Phone.setText(rs.getString("phone")); 
                lb1persons.setText(rs.getString("persons"));

             }
        }catch(Exception e){
        e.printStackTrace();
        
        }
        
        
        
        
        setVisible(true);

        
    }
    public static void main(String[] args) {
        new ViewPkg("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            setVisible(false);
        }

    }
    
}
