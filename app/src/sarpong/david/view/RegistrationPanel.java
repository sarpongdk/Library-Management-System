package sarpong.david.view;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class RegistrationPanel extends JPanel
{
   private JTextField age, firstName, lastName, email;
   private JRadioButton admin, librarian;
   private JButton register;

   public RegistrationPanel()
   {
      super();
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

      firstName = new JTextField();
      lastName = new JTextField();
      email = new JTextField();
      age = new JTextField();
      register = new JButton("Register");

      add(firstName);
      add(lastName);
      add(email);
      add(age);
      add(register);
   }

   public String getFirstName()
   {
      return firstName.getText();
   }

   public String getLastName()
   {
      return lastName.getText();
   }

   public String getEmailAddress()
   {
      return email.getText();
   }

   public Integer getAge()
   {
      Integer val = new Integer(age.getText());

      return val;
   }

   public void addRegisterListener(ActionListener listener)
   {
      register.addActionListener(listener);
   }

   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      frame.add(new RegistrationPanel());
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}
