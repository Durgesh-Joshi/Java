
package chatting.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
public class Client extends JFrame implements ActionListener{
    
    JPanel p1 = new JPanel();    
    JTextField t1 = new JTextField();
    JButton b1 = new JButton("Send");
   static JTextArea ta = new JTextArea();
   
   static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    Boolean type;
    Client()
        {
            p1 = new JPanel();
            p1.setLayout(null);
            p1.setBackground(new Color(7,94,84));
            p1.setBounds(0,0,400,60);
            add(p1);
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/project_images/3.png"));
            Image i2 = i1.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel l1 = new JLabel(i3);
            l1.setBounds(8,20,20,20);
            
            l1.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent me)
                {
                    System.exit(0);
                }
            });
            p1.add(l1);
            
            ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/project_images/6.png"));
            Image i5 = i4.getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT);
            ImageIcon i6 = new ImageIcon(i5);
            JLabel l2 = new JLabel(i6);
            l2.setBounds(30,0,60,60);
            p1.add(l2);
            
            ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/project_images/15.png"));
            Image i8 = i7.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT);
            ImageIcon i9 = new ImageIcon(i8);
            JLabel l5 = new JLabel(i9);
            l5.setBounds(260,15,50,30);
            p1.add(l5);
            
            ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/project_images/14.png"));
            Image i11 = i10.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT);
            ImageIcon i12 = new ImageIcon(i11);
            JLabel l6 = new JLabel(i12);
            l6.setBounds(310,15,60,30);
            p1.add(l6);
            
            ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/project_images/4.png"));
            Image i14 = i13.getImage().getScaledInstance(15,25, Image.SCALE_DEFAULT);
            ImageIcon i15 = new ImageIcon(i14);
            JLabel l7 = new JLabel(i15);
            l7.setBounds(370,15,20,30);
            p1.add(l7);
              
         ImageIcon i16 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/project_images/camera.png"));
            Image i17 = i16.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT);
            ImageIcon i18 = new ImageIcon(i17);
            JLabel l8 = new JLabel(i18);
            l8.setBounds(323,550,30,60);
            add(l8);
            
            ImageIcon i19 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/project_images/pin.png"));
            Image i20 = i19.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT);
            ImageIcon i21 = new ImageIcon(i20);
            JLabel l9 = new JLabel(i21);
            l9.setBounds(293,550,30,60);
            add(l9);
            
            ImageIcon i22 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/project_images/smiley.png"));
            Image i23 = i22.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT);
            ImageIcon i24 = new ImageIcon(i23);
            JLabel l10 = new JLabel(i24);
            l10.setBounds(5,550,30,60);
            add(l10);
            
            ImageIcon i25 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/project_images/send.png"));
            Image i26 = i25.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT);
            ImageIcon i27 = new ImageIcon(i26);
            JLabel l11 = new JLabel(i27);
            l11.setBounds(360,550,30,60);
            add(l11);    
            l11.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent me)
                 {
                     
                     try
                    {
                        String s1 = t1.getText();
                        sendText(s1);
                        try
                        {
                        
                         ta.setText(ta.getText()+"\n\t\t"+s1);
                         dout.writeUTF(s1);
                          
                         t1.setText("");
                        }
                        
                        catch(IOException ex){}
                        
                        
                    }
                     
                     
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                     
                    
               
                 }
              
     public void sendText(String ms2)throws FileNotFoundException{
                    try(
                        FileWriter f = new FileWriter("ChatApplication.txt", true);
                        PrintWriter p1=new PrintWriter(f);
                       )                                                
                    {
                        
                        p1.println("\n Roan :"+ms2);
                    } catch(Exception e){
                    e.printStackTrace();
                    }
                    
                }
                   
              
                  
            });
            
            
            
            
//            JScrollPane sp = new JScrollPane(ta);
            
            JLabel l3 = new JLabel("Rohan");
            l3.setFont(new Font("Arial",Font.BOLD,18));
            l3.setForeground(Color.WHITE);
            l3.setBounds(90,10,90,20);
            p1.add(l3);
            
            JLabel l4 = new JLabel("Active Now");
            l4.setFont(new Font("Arial",Font.PLAIN,12));
            l4.setForeground(Color.WHITE);
            l4.setBounds(90,30,90,18);
            p1.add(l4);
             Timer t = new Timer(1,new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae)
             {
                 if(!type)
                {
                        l4.setText("Active Now");
                }
             }
             });
             t.setInitialDelay(2000);
            {
             addWindowListener(new WindowAdapter()
                {
                    @Override
                    public void windowClosing(WindowEvent e)
                        {
                            dispose();
                           }
                });
         }
            t1.setBounds(40,565,255,30);
            t1.setFont(new Font("Arial",Font.BOLD,15));
            b1.setBounds(315,570,75,25);
            b1.addActionListener(this);
            b1.setFont(new Font("Arial",Font.BOLD,15));
            b1.setBackground(new Color(7,94,84));
            b1.setForeground(Color.WHITE);
            ta.setFont(new Font("Arial",Font.BOLD,15));
            ta.setBounds(5, 65,390,495);
            ta.setEditable(false);
            ta.setLineWrap(true);
            ta.setWrapStyleWord(true);
            
            add(t1);
            t1.addKeyListener(new KeyAdapter(){
               @Override
               public void keyPressed(KeyEvent ke)
                    {
                        l4.setText("Typing....");
                        t.stop();
                        type = true;
                    }
               @Override
               public void keyReleased(KeyEvent ke)
                    {
                      
                      type = false;  
                      if(!t.isRunning())
                        {
                            t.start();
                        }
                    }

               
            });
                  
            
            //add(b1);
            add(ta);
            
            setLayout(null);
            setSize(400,600);
            setLocation(500,50);
            setUndecorated(true);
            setVisible(true);
        }
    @Override
        public void actionPerformed(ActionEvent ae)
        {
            
//            try{
//               
//                String s1 = t1.getText();
//                ta.setText(ta.getText()+"\n\t\t"+s1);
//                dout.writeUTF(s1);
//                t1.setText("");
//            }
//            catch(Exception e){}
//            
        }
        public static void main(String args[])
        {
           new Client();
            try
            {
                   s = new Socket("127.0.0.1",6001);
                   din = new DataInputStream(s.getInputStream());
                   dout = new DataOutputStream(s.getOutputStream());
                   while(true)
                   {
                    String msg = ""; 
                    msg=din.readUTF();
                    ta.setText(ta.getText()+"\n"+msg);
                    if(msg.equalsIgnoreCase("Stop")== true)
                    {
                        break;
                    }
                   }
                   
                
        }
        catch(Exception e)
        {

        }
            finally{
                try
                {
                    s.close();
                }
                catch(Exception e){
                    
                }
                }
        }
}
