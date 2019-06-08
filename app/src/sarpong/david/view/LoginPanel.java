package sarpong.david.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class LoginPanel extends JPanel
{
   /**
    * 
    */
   private static final long serialVersionUID = 8286002791700727060L;
   private JLabel title;
   private JButton adminLogin, librarianLogin, register;

   public LoginPanel()
   {
      super();
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      setPreferredSize(new Dimension(View.WIDTH, View.HEIGHT));

      title = new JLabel("Library Management");
      adminLogin = new JButton("Admin Login");
      librarianLogin = new JButton("Librarian Login");
      register = new JButton("Register");

      add(title);
      add(adminLogin);
      add(librarianLogin);
      add(register);
   }

   public void addAdminLoginListener(ActionListener listener)
   {
      adminLogin.addActionListener(listener);
   }
   
   public void addLibrarianLoginListener(ActionListener listener)
   {
      librarianLogin.addActionListener(listener);
   }
   
   public void addRegistrationListener(ActionListener listener)
   {
      register.addActionListener(listener);
   }

   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      frame.add(new LoginPanel());
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}
