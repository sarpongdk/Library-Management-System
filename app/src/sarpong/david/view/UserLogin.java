import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class UserLogin extends JPanel
{
   private static final int MAX_CHARACTERS = 30;

   private JTextField username;
   private JPasswordField password;
   private JButton login;

   public UserLogin()
   {
      username = new JTextField(MAX_CHARACTERS);
      password = new JPasswordField(MAX_CHARACTERS);
      login = new JButton("Login");
   }

   public void addLoginListener(ActionListener listener)
   {
      login.addActionListener(listener);
   }

   public String getPassword()
   {
      return password.getPassword();
   }

   public String getUsername()
   {
      return username.getText();
   }
}
