package sarpong.david.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class View extends JFrame
{
   public static final int WIDTH = 300;
   public static final int HEIGHT = 450;

   private UserLogin userLogin;
   private RegistrationPanel register;
   private LoginPanel login;
   private AdminPanel admin;
   private LibrarianPanel librarian;

   public View()
   {
      super("Library Management System");
      login = new LoginPanel();
      admin = new AdminPanel();
      librarian = new LibrarianPanel();
      register = new RegistrationPanel();
      userLogin = new UserLogin();

      setLayout(new BorderLayout());
      setPreferredSize(new Dimension(WIDTH, HEIGHT));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      add(login, BorderLayout.CENTER);
      pack();
      setVisible(true);
   }

   public String getLoginUsername()
   {
      return userLogin.getUsername();
   }

   public String getLoginPassword()
   {
      return userLogin.getPassword();
   }

   private void changePanel(JPanel panel)
   {
      getContentPane().removeAll();
      add(panel, BorderLayout.CENTER);
      pack();
      repaint();
      //revalidate();
   }

   public String getRegistrationFirstName()
   {
      return register.getFirstName();
   }

   public String getRegistrationLastName()
   {
      return register.getLastName();
   }

   public String getRegistrationEmailAddress()
   {
      return register.getEmailAddress();
   }

   public Gender getRegistrationGender()
   {
      return register.getGender();
   }

   public String getRegistrationAccessRights()
   {
      return register.getAccessRights();
   }

   public String getRegistrationAge()
   {
      return register.getAge();
   }

   public void displayLogin()
   {
      changePanel(login);
   }

   public void displayAdminSection()
   {
      changePanel(admin);
   }

   public void displayLibrarianSection()
   {
      changePanel(librarian);
   }

   public void displayRegistration()
   {
      changePanel(register);
   }

   public void displayUserLogin()
   {
      changePanel(userLogin);
   }

   public void addLoginListener(ActionListener listener)
   {
      userLogin.addLoginListener(listener);
   }

   public void addLibrarianLoginListener(ActionListener listener)
   {
      login.addLibrarianLoginListener(listener);
   }

   public void addAdminLoginListener(ActionListener listener)
   {
      login.addAdminLoginListener(listener);
   }

   public void addLogoutListener(ActionListener listener)
   {
      admin.addLogoutListener(listener);
      librarian.addLogoutListener(listener);
   }

   public void clearLogin()
   {
      userLogin.clearLogin();
   }

   public static void main(String[] args)
   {
      View view = new View();
   }
}
