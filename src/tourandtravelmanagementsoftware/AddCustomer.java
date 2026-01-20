package tourandtravelmanagementsoftware;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;
import java.util.Objects;

public class AddCustomer extends  JFrame implements ActionListener{
    JLabel Labelusername,lablename;
    JComboBox comboID;
    JTextField tfNumber,tfcountry ,tfAddress,tfMail,tfPhone;
    JRadioButton rmale,rfemale;

    JButton add,back;
     
     String userNames;

    AddCustomer(String userNames){
        this.userNames = userNames;
        setBounds(330,100,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setTitle("DestiNations: Explore the World, Your Way");
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/prj.jpg")); 
        setIconImage(icon.getImage());
        setResizable(false);

    
        
        JLabel lb1UserName = new JLabel("Username");
        lb1UserName.setBounds(30,50,150,25);
        add(lb1UserName);

        Labelusername = new JLabel();
        Labelusername.setBounds(220,50,150,25);
        add(Labelusername);

        JLabel lb1UserID = new JLabel("ID");
        lb1UserID.setBounds(30,90,150,25);
        add(lb1UserID);

        comboID  = new JComboBox(new String[] {"Passport","CNIC","Pin"});
        comboID.setBounds(220,90,150,25);
        comboID.setBackground(Color.WHITE);
        add(comboID);

        JLabel lb1UserNo = new JLabel("Number");
        lb1UserNo.setBounds(30,130,150,25);
        add(lb1UserNo);

        tfNumber =new JTextField();
        tfNumber.setBounds(220,130,150,25);
        add(tfNumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,170,150,25);
        add(lblname);

        lablename= new JLabel("");
        lablename.setBounds(220,170,150,25);
        add(lablename);
      
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);
        rmale =new JRadioButton("Male");
        rmale.setBounds(220,210,70,25);
        rmale.setBackground(Color.WHITE);
        add(rmale);

        rfemale =new JRadioButton("Female");
        rfemale.setBounds(300,210,70,25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);

        ButtonGroup bg =new ButtonGroup();

        bg.add(rmale);
        bg.add(rfemale);


        JLabel country = new JLabel("Country");
        country.setBounds(30,250,150,25);
        add(country);

        tfcountry = new JTextField();
        tfcountry.setBounds(220,250,150,25);
        add(tfcountry);

        JLabel address = new JLabel("Address");
        address.setBounds(30,290,150,25);
        add(address);
        
        tfAddress = new JTextField();
        tfAddress.setBounds(220,290,150,25);
        add(tfAddress);



        JLabel phone = new JLabel("Phone");
        phone.setBounds(30,330,150,25);
        add(phone);

        tfPhone = new JTextField();
        tfPhone.setBounds(220,330,150,25);
        add(tfPhone);


        JLabel mail = new JLabel("E-Mail");
        mail.setBounds(30,370,150,25);
        add(mail);

        tfMail = new JTextField();
        tfMail.setBounds(220,370,150,25);
        add(tfMail);

        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(220,450,100,25);
        add.addActionListener(this);
        add(add);


        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(70,450,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("\\icons\\newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBackground(Color.BLACK);
        image.setBounds(400,40,450,420);
        add(image);
      try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where username = '"+ this.userNames+"'");
            if (rs.next()) {
                Labelusername.setText(rs.getString("username"));
                lablename.setText(rs.getString("name"));
            } else  {
                JOptionPane.showMessageDialog(null, "No records found for the specified username.");
               }
        } catch (Exception e) {
            e.printStackTrace();
            }



        setVisible(true);
    }
    public static void main(String[] args) {
   new AddCustomer("");
    }

@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == back) {
        setVisible(false);
    } else {
        String username = Labelusername.getText();
        String id = (String) comboID.getSelectedItem();
        String number = tfNumber.getText().trim();
        String name = lablename.getText().trim();
        String gender = rmale.isSelected() ? "Male" : (rfemale.isSelected() ? "Female" : null);
        String country = tfcountry.getText().trim();
        String address = tfAddress.getText().trim();
        String phone = tfPhone.getText().trim();
        String email = tfMail.getText().trim();

        // === VALIDATIONS ===
        if (number.isEmpty() || !number.matches("\\d{4,20}")) {
            JOptionPane.showMessageDialog(this, "Enter a valid ID number (digits only, 4–20 characters).");
            return;
        }

        if (gender == null) {
            JOptionPane.showMessageDialog(this, "Please select a gender.");
            return;
        }

        if (country.isEmpty() || !country.matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(this, "Enter a valid country name (letters only).");
            return;
        }

        if (address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Address cannot be empty.");
            return;
        }

        if (!phone.matches("\\d{10,}")) {
            JOptionPane.showMessageDialog(this, "Phone number must be at least 10 digits.");
            return;
        }

        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address.");
            return;
        }

        // === IF VALID, THEN INSERT ===
        try {
            Conn c = new Conn();
            String query = "INSERT INTO customer (username, id, number, name, gender, country, address, phone, email) " +
                           "VALUES ('" + username + "', '" + id + "', '" + number + "', '" + name + "', '" + gender + "', '" + country + "', '" + address + "', '" + phone + "', '" + email + "')";
            c.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Customer details added successfully.");
            setVisible(false);
        } catch (Exception ae) {
            ae.printStackTrace();
        }
    }
}

}