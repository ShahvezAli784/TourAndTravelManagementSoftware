
package tourandtravelmanagementsoftware;

import javax.swing.*;
import java.awt.*;
public class Splash extends JFrame implements Runnable {
    Thread thread;
//    JFrame frame = new JFrame("Tour and travel manager.");
    Splash(){
        
       setSize(1200,600);
       setLocation(200,200);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       
       
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
       add(image);
       setVisible(true);
       thread = new Thread(this);
       thread.start();
       
      }
    public void run(){
        try{
            Thread.sleep(7000);
//            new login();
            setVisible(false);
        }
        catch(Exception e){}      
    }
    
    public static void main(String[] args) {
        Splash Frame = new Splash();
        
        int x =1;
        for(int i=0; i<500; x+=7, i+=6){
           Frame.setLocation(750- (x+i)/2,400-(i/2));
           Frame.setSize(x + i,i);
           
           try{
               Thread.sleep(10);
           }
         catch(Exception e){}
        }

    }
}
