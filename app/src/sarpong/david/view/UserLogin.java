package sarpong.david.view;

import sarpong.david.model.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class UserLogin extends JPanel
{
   /**
    * 
    */
   private static final long serialVersionUID = 1462397573602204861L;

   private static final int MAX_CHARACTERS = 30;

   private JTextField username;
   private JPasswordField password;
   private JButton login;

   public UserLogin()
   {
      super();
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      setPreferredSize(new Dimension(View.WIDTH, View.HEIGHT));

      username = new JTextField(MAX_CHARACTERS);
      password = new JPasswordField();
      login = new JButton("Login");

      add(username);
      add(password);
      add(login);
   }

   public void addLoginListener(ActionListener listener)
   {
      login.addActionListener(listener);
   }

   public char[] getPassword()
   {
      return password.getPassword();
   }

   public String getUsername()
   {
      return username.getText();
   }

   public void clearLogin()
   {
      username.setText("");
      password.setText("");
   }
}
