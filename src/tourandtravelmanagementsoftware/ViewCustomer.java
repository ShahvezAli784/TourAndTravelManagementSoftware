package tourandtravelmanagementsoftware;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;
import java.util.Objects;

public class ViewCustomer extends JFrame implements ActionListener {
    
    JButton back;
    String username;
    ViewCustomer(String username){
        this.username = username;
        setBounds(450,180,870,625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);   
//        setDefaultCloseOperation(EXIT_ON_CLOSE);  
        setTitle("DestiNations: Explore the World, Your Way");
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/prj.jpg")); 
        setIconImage(icon.getImage());
        setResizable(false);


        
        JLabel lb1UserName = new JLabel("Username:");
        lb1UserName.setBounds(30,50,150,25);
        add(lb1UserName);
        
        JLabel labe1UserName = new JLabel();
        labe1UserName.setBounds(220,50,150,25);
        add(labe1UserName);
        
        JLabel lb1ID = new JLabel("ID:");
        lb1ID.setBounds(30,110,150,25);
        add(lb1ID);
        
        JLabel labe1ID = new JLabel();
        labe1ID.setBounds(220,110,150,25);
        add(labe1ID);
        
        
        
        JLabel lb1number = new JLabel("Number:");
        lb1number.setBounds(30,170,150,25);
        add(lb1number);
        
        JLabel labe1number = new JLabel();
        labe1number.setBounds(220,170,150,25);
        add(labe1number);
        
         JLabel lb1name = new JLabel("Name:");
        lb1name.setBounds(30,230,150,25);
        add(lb1name);
        
        JLabel labe1name = new JLabel();
        labe1name.setBounds(220,230,150,25);
        add(labe1name);
        
        
        
        JLabel lb1gender = new JLabel("Gender:");
        lb1gender.setBounds(30,290,150,25);
        add(lb1gender);
        
        JLabel labe1gender = new JLabel();
        labe1gender.setBounds(220,290,150,25);
        add(labe1gender);

        
         JLabel lb1country = new JLabel("Country:");
        lb1country.setBounds(500,50,150,25);
        add(lb1country);
        
        JLabel labe1country = new JLabel();
        labe1country.setBounds(700,50,150,25);
        add(labe1country);
        
         JLabel lb1address = new JLabel("Address:");
        lb1address.setBounds(500,110,150,25);
        add(lb1address);
        
        JLabel labe1address = new JLabel();
        labe1address.setBounds(700,110,150,25);
        add(labe1address);
        
        
        JLabel lb1phone = new JLabel("Phone:");
        lb1phone.setBounds(500,170,150,25);
        add(lb1phone);
        
        JLabel labe1phone = new JLabel();
        labe1phone.setBounds(700,170,150,25);
        add(labe1phone);

         JLabel lb1email = new JLabel("Email:");
        lb1email.setBounds(500,230,150,25);
        add(lb1email);
        
        JLabel labe1email = new JLabel();
        labe1email.setBounds(700,230,150,25);
        add(labe1email);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFocusable(false);
        back.setFont(new Font("Tahomn",Font.BOLD,14));
        back.setBounds(300,350,100,35);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("\\icons\\viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBackground(Color.BLACK);
        image.setBounds(20,400,600,200);
        add(image);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("\\icons\\viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i2);
        
        JLabel image2 = new JLabel(i6);
        image2.setBackground(Color.BLACK);
        image2.setBounds(600,400,600,200);
        add(image2);
        
        
        
        try{
            String query = "select * from customer where username = '"+ this.username +"'";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labe1UserName.setText(rs.getString("username"));           
                labe1name.setText(rs.getString("name"));            
                labe1number.setText(rs.getString("number"));
                labe1gender.setText(rs.getString("gender"));            
                labe1ID.setText(rs.getString("id"));
                labe1country.setText(rs.getString("country")); 
                labe1address.setText(rs.getString("address")); 
                labe1phone.setText(rs.getString("phone"));
                labe1email.setText(rs.getString("email"));
             }
        }catch(Exception e){
        e.printStackTrace();
        
        }
        
        
        
        
        setVisible(true);

        
    }
    public static void main(String[] args) {
        new ViewCustomer("shezy1");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            setVisible(false);
        }

    }
    
}
