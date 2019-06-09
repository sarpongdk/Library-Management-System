package sarpong.david.view;

import sarpong.david.model.*;


import javax.swing.*;

import java.awt.event.*;
import java.util.Enumeration;
import java.awt.*;

public class RegistrationPanel extends JPanel
{
   /**
    * 
    */
   private static final long serialVersionUID = 4652657270140176410L;

   private static final int MAX_CHARACTERS = 30;

   private PlaceHolderTextField age, firstName, lastName, email, username;
   private JRadioButton admin, librarian, male, female, other;
   private ButtonGroup gender, role;
   private JButton register;
   private JPasswordField password;

   public RegistrationPanel()
   {
      super();
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      setPreferredSize(new Dimension(View.WIDTH, View.HEIGHT));

      firstName = new PlaceHolderTextField(MAX_CHARACTERS, "First Name");
      lastName = new PlaceHolderTextField(MAX_CHARACTERS, "Last Name");
      email = new PlaceHolderTextField(MAX_CHARACTERS, "Email Address");
      username = new PlaceHolderTextField(MAX_CHARACTERS, "Username");
      age = new PlaceHolderTextField(MAX_CHARACTERS - (MAX_CHARACTERS - 5), "Age");
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
      add(username);
      add(password);
      add(age);
      add(male);
      add(female);
      add(other);
      add(librarian);
      add(admin);
      add(register);
   }
   
   public void setRegistrationRole(Role role)
   {
      switch (role)
      {
         case Librarian:
            librarian.setSelected(true);
            break;

         case Admin:
            admin.setSelected(true);
            break;
      }
   }

   public Role getAccessRights()
   {
      Role position = null;
      Enumeration<AbstractButton> buttons = role.getElements();

      while (buttons.hasMoreElements())
      {
         AbstractButton button = buttons.nextElement();
         
         if (button.isSelected())
         {
            String text = button.getText();

            switch (text)
            {
               case "Admin":
                  position = Role.Admin;
                  break;

               case "Librarian":
                  position = Role.Librarian;
                  break;
            }

            break;
         }
      }
      
      return position;
   }

   public Gender getGender()
   {
      Gender sex = null;
      Enumeration<AbstractButton> buttons = gender.getElements();

      while (buttons.hasMoreElements())
      {
         AbstractButton button = buttons.nextElement();
         
         if (button.isSelected())
         {
            String text = button.getText();

            switch (text)
            {
               case "Male":
                  sex = Gender.Male;
                  break;

               case "Female":
                  sex = Gender.Female;
                  break;
            }

            break;
         }
      }
      
      return sex;
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

   public char[] getPassword()
   {
      return password.getPassword();
   }

   public Integer getAge()
   {
      Integer val = new Integer(age.getText());

      return val;
   }

   public String getUsername()
   {
      return username.getText();
   }

   public void addRegistrationListener(ActionListener listener)
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
