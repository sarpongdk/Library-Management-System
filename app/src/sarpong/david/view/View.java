package sarpong.david.view;

import sarpong.david.model.*;

import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;

public class View extends JFrame
{
   /**
    * 
    */
   private static final long serialVersionUID = -599898895348122949L;
   public static final int WIDTH = 650;
   public static final int HEIGHT = 450;

   private AddBookPanel addBookPanel;
   private ViewBookPanel viewBookPanel;
   private ViewLibrarianPanel viewLibrarianPanel;
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
      addBookPanel = new AddBookPanel();

      setLayout(new BorderLayout());
      setPreferredSize(new Dimension(WIDTH, HEIGHT));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      add(login, BorderLayout.CENTER);
      pack();
      setVisible(true);
   }

   public String getLibrarianToDeleteUsername()
   {
      return viewLibrarianPanel.getSelectedLibrarianUsername();
   }

   public void displayAddBook()
   {
      changePanel(addBookPanel);
   }

   public Book getBook()
   {
      String title = addBookPanel.getTitle();
      String author = addBookPanel.getAuthor();
      int year = addBookPanel.getYear();
      int isbn = addBookPanel.getISBN();
      boolean issued = addBookPanel.isIssued();

      return new Book(author, title, issued, year, isbn);
   }

   public void addBookListener(ActionListener listener)
   {
      librarian.addBooksListener(listener);
   }

   public void displayViewBook(BookTableModel model)
   {
      viewBookPanel = new ViewBookPanel(model);
      changePanel(viewBookPanel);
   }

   public void addViewBookListener(ActionListener listener)
   {
      librarian.addViewBooksListener(listener);
   }

   public void displayViewLibrarians(LibrarianTableModel model, ActionListener listener)
   {
      viewLibrarianPanel = new ViewLibrarianPanel(model);
      viewLibrarianPanel.addDeleteLibrarianListener(listener);

      changePanel(viewLibrarianPanel);
   }

   public void setRegistrationRole(Role role)
   {
      register.setRegistrationRole(role);
   }

   public String getLoginUsername()
   {
      return userLogin.getUsername();
   }

   public char[] getLoginPassword()
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

   public void updateDeletedLibrarian()
   {
      viewLibrarianPanel.deleteRow();
   }

   public String getRegistrationUsername()
   {
      return register.getUsername();
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

   public Role getRegistrationAccessRights()
   {
      return register.getAccessRights();
   }

   public Integer getRegistrationAge()
   {
      return register.getAge();
   }

   public char[] getRegistrationPassword()
   {
      return register.getPassword();
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
   
   public void addRegistrationListener(ActionListener listener)
   {
      register.addRegistrationListener(listener);
   }

   public void addLogoutListener(ActionListener listener)
   {
      admin.addLogoutListener(listener);
      librarian.addLogoutListener(listener);
   }

   public void addCreateAccountListener(ActionListener listener)
   {
      login.addRegistrationListener(listener);
   }
   
   public void addLibrarianListener(ActionListener listener)
   {
      admin.addLibrarianListener(listener);
   }
   
   public void addViewLibrarianListener(ActionListener listener)
   {
      admin.addViewLibrarianListener(listener);
   }
   
   public void clearLogin()
   {
      userLogin.clearLogin();
   }

   public void displayLoginError()
   {
      JOptionPane.showMessageDialog(new JFrame("Error"), "Username and/or password do not match");
   }
   public static void main(String[] args)
   {
      View view = new View();
   }
}
