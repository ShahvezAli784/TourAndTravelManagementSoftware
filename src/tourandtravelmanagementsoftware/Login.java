//last wala h mera project
package tourandtravelmanagementsoftware;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;

import java.awt.*;

public class Login extends JFrame  implements ActionListener{

    JButton password,dlt;
    JButton signup , login;
    JTextField tfusername;
    JPasswordField tfpassword;
    
    Login() {
        setTitle("DestiNations: Explore the World, Your Way");
        setSize(900, 430);
        setLocation(350, 200);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/prj.jpg")); 
        setIconImage(icon.getImage());

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel(){
             @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon(getClass().getResource("/icons/plan.jpg"));
                Image image = imageIcon.getImage();
                double scaleFactor = Math.min(
                        (double) getWidth() / image.getWidth(null),
                        (double) getHeight() / image.getHeight(null)
                );
                int scaledWidth = (int) (image.getWidth(null) * scaleFactor);
                int scaledHeight = (int) (image.getHeight(null) * scaleFactor);
                int x = (getWidth() - scaledWidth) / 2;
                int y = (getHeight() - scaledHeight) / 2;
                g.drawImage(image, x, y, scaledWidth, scaledHeight, null);
            }
        };
        p1.setBackground(Color.WHITE);
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);

        
      
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
      
        

        add(p1);
        add(p2);

        JLabel lblusername = new JLabel("User Name:");
        lblusername.setBounds(60,10,100,25);
        lblusername.setFont(new Font("SAN SERIF",Font.PLAIN,18));
        p2.add(lblusername);
        
          
        tfusername = new JTextField(); 
        tfusername.setBounds(60,50,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        tfusername.setFont(new Font("SAN SERIF",Font.PLAIN,15));
        p2.add(tfusername);
        

        JLabel lblpassword = new JLabel("Password:");
        lblpassword.setBounds(60,100,100,25);
        lblpassword.setFont(new Font("SAN SERIF",Font.PLAIN,18));
        p2.add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(60,140,300,30);  
        tfpassword.setFont(new Font("SAN SERIF",Font.PLAIN,15));
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(60,190,130,30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);
        login.setFocusable(false);
        login.addActionListener(this);
        login.setBorder(new LineBorder(new Color(133,193,233)));

        p2.add(login);
        
        signup = new JButton("Sign up");
        signup.setBounds(230,190,130,30);
        signup.setBackground(new Color(133,193,233));
        signup.setForeground(Color.WHITE);
        signup.setFocusable(false);
        signup.addActionListener(this);
        signup.setBorder(new LineBorder(new Color(133,193,233)));

        p2.add(signup);
        
        password = new JButton("Forgot Password");
        password.setBounds(60,240,130,30);
        password.setBackground(new Color(133,193,233));
        password.setForeground(Color.WHITE);
        password.setFocusable(false);
        password.setBorder(new LineBorder(new Color(133,193,233)));
        password.addActionListener(this);

        p2.add(password);
        
        dlt = new JButton("Delete Account");
        dlt.setBounds(230,240,130,30);
        dlt.setBackground(new Color(133,193,233));
        dlt.setForeground(Color.WHITE);
        dlt.setFocusable(false);
        dlt.addActionListener(this);
        dlt.setBorder(new LineBorder(new Color(133,193,233)));

        p2.add(dlt);
        
        JLabel text = new JLabel("Trouble in login...");
        text.setBounds(350,277,150,20);
        text.setForeground(Color.red);
        p2.add(text);
        
      
        
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
    
        if(e.getSource() == login){
            try {
                   String username = tfusername.getText();
                   char[] passwordChars = tfpassword.getPassword(); 
                   String pass = new String(passwordChars); 


                   String query = "SELECT * FROM account WHERE username = '" + username + "' AND password = '" + pass + "'";

                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);

                        if(rs.next()) {
                            setVisible(false);
                            new Loading(username);
                         } else {
                            JOptionPane.showMessageDialog(null, "Incorrect username OR password");
                            }
              } catch(Exception ae){ae.printStackTrace();}         
        
        } else  if(e.getSource() == signup){        
            setVisible(false);
             new SignUp();
        }  else if (e.getSource() == dlt) {
            setVisible(false);
            new DeleteAccount();
         
        }else {
            setVisible(false);
            new ForgetPassword();
         }
    }
    

    public static void main(String[] args) {
        new Login();
    }
}
