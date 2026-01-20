
package tourandtravelmanagementsoftware;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;
public class UpdatePersonalDetails extends  JFrame implements ActionListener{


    JLabel Labelusername,lablename;
    JComboBox comboID;
    JTextField tfNumber,tfcountry ,tfAddress,tfMail,tfPhone,tfid,tfgender,tfaddress,tfemail,tfnumber;
    JRadioButton rmale,rfemale;

    JButton add,back;
     
     String userNames;

    UpdatePersonalDetails(String userNames){
        this.userNames = userNames;
        setBounds(500,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setTitle("DestiNations: Explore the World, Your Way");
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/prj.jpg")); 
        setIconImage(icon.getImage());
        setResizable(false);

        JLabel text = new JLabel("Update Customer Detatils");
        text.setBounds(150,5,300,25);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);

        
        JLabel lb1UserName = new JLabel("Username");
        lb1UserName.setBounds(30,50,150,25);
        add(lb1UserName);

        Labelusername = new JLabel();
        Labelusername.setBounds(220,50,150,25);
        add(Labelusername);

        JLabel lb1UserID = new JLabel("ID");
        lb1UserID.setBounds(30,90,150,25);
        add(lb1UserID);

        tfid =new JTextField();
        tfid.setBounds(220,90,150,25);
        add(tfid);

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
        
        tfgender= new JTextField("");
        tfgender.setBounds(220,210,150,25);
        add(tfgender);


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

        add = new JButton("Update");
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

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("\\icons\\update.png"));
        Image i2 = i1.getImage().getScaledInstance(400,  300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBackground(Color.BLACK);
        image.setBounds(400,100,500,300);
        add(image);
        
       try{
            String query = "select * from customer where username = '"+ this.userNames +"'";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                Labelusername.setText(rs.getString("username"));           
                lablename.setText(rs.getString("name"));            
                tfNumber.setText(rs.getString("number"));    
                tfgender.setText(rs.getString("gender"));            
                tfid.setText(rs.getString("id"));
                tfcountry.setText(rs.getString("country")); 
                tfAddress.setText(rs.getString("address")); 
                tfPhone.setText(rs.getString("phone"));
                tfMail.setText(rs.getString("email"));
             }
        }catch(Exception e){
        e.printStackTrace();
        
        }
       


        setVisible(true);
    }
    public static void main(String[] args) {
   new UpdatePersonalDetails("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     if (e.getSource() == back) {
            setVisible(false);
        } else {
            String username = Labelusername.getText();
            String id = tfid.getText();
            String number = tfNumber.getText();
            String name = lablename.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfAddress.getText();
            String email = tfMail.getText();
            String phone = tfPhone.getText();

            try {
                Conn c = new Conn();
             String query = "UPDATE customer SET username = '" + username + "', id = '" + id + "', number = '" + number + "', name = '" + name + "', gender = '" + gender + "', country = '" + country + "', address = '" + address + "', phone = '" + phone + "', email = '" + email + "'";
             c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer details updated successfully.");
                setVisible(false);
                
            } catch (Exception ae){
                ae.printStackTrace();
            }

        }
    }

}