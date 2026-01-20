package tourandtravelmanagementsoftware;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{
    
    Thread t;
    JProgressBar bar;
    String username;
    Loading(String username) {
        this.username = username;
        
        t = new Thread(this);
        
        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);      
        setResizable(false);  
        setTitle("DestiNations: Explore the World, Your Way");
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/prj.jpg")); 
        setIconImage(icon.getImage());


        

        setLayout(null);

        JLabel text = new JLabel("Travel and Tour Application");
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        text.setForeground(Color.BLACK);
        text.setBounds(50, 20, 600, 40);
        add(text);
        
        bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);
        
        JLabel loading = new JLabel("Please wait...");
        loading.setFont(new Font("Raleway", Font.BOLD, 15));
        loading.setForeground(Color.red);
        loading.setBounds(230, 130, 100, 30);
        add(loading);
        
        JLabel lblusername = new JLabel("Welcome "+this.username);
        lblusername.setFont(new Font("Raleway", Font.BOLD, 16));
        lblusername.setForeground(Color.red);
        lblusername.setBounds(20, 310, 400, 40);
        add(lblusername);
        
        
        t.start();
        setVisible(true);
    }
    public void run(){
            try{
                for(int i = 1; i <= 101; i++){
                    int max = bar.getMaximum();
                    int value = bar.getValue();
                    
                    
                    if(value < max){
                        
                        bar.setValue(bar.getValue() + 1)
                                ;
                    } else {
                        setVisible(false);
                        new DashBoard(this.username);
                    }
                    Thread.sleep(50);
                }
            
            
            
            
            }catch(Exception e){ e.printStackTrace();}
  
    
    }

    public static void main(String[] args) {
        new Loading("");
    }
}
