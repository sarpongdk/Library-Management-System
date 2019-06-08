package sarpong.david.view;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class RegistrationPanel extends JPanel
{
   private static final int MAX_CHARACTERS = 30;

   private JTextField age, firstName, lastName, email;
   private JRadioButton admin, librarian, male, female, other;
   private ButtonGroup gender, role;
   private JButton register;
   private JPasswordField password;

   public RegistrationPanel()
   {
      super();
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

      firstName = new JTextField(MAX_CHARACTERS);
      lastName = new JTextField(MAX_CHARACTERS);
      email = new JTextField(MAX_CHARACTERS);
      age = new JTextField(MAX_CHARACTERS - (MAX_CHARACTERS - 5));
      password = new JPasswordField(MAX_CHARACTERS);
      register = new JButton("Register");

      role = new ButtonGroup();
      admin = new JRadioButton("Admin");
      librarian = new JRadioButton("Librarian");
      role.add(admin);
      role.add(librarian);

      gender = new ButtonGroup();
      male = new JRadioButton("Male");
      female = new JRadioButton("Female");
      other = new JRadioButton("Other");
      gender.add(male);
      gender.add(female);
      gender.add(other);

      add(firstName);
      add(lastName);
      add(email);
      add(password);
      add(age);
      add(gender);
      add(role);
      add(register);
   }

   public AccessRights getAccessRights()
   {
      AccessRights role;

      for (AbstractButton button: gender.getElements())
      {
         if (button.isSelected())
         {
            String text = button.getText();

            switch (text)
            {
               case "Admin":
                  role = AccessRights.Admin;
                  break;

               case "Librarian":
                  role = AccessRights.Librarian;
                  break;
            }

            return role;
         }
      }
   }

   public Gender getGender()
   {
      Gender gender;

      for (AbstractButton button: gender.getElements())
      {
         if (button.isSelected())
         {
            String text = button.getText();

            switch (text)
            {
               case "Male":
                  gender = Gender.Male;
                  break;

               case "Female":
                  gender = Gender.Female;
                  break;
            }

            return gender;
         }
      }
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

   public String getPassword()
   {
      return password.getPassword();
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
