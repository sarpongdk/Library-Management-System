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
   public static final int WIDTH = 950;
   public static final int HEIGHT = 650;

   private ButtonPanel buttonsPanel;
   private AddBookPanel addBookPanel;
   private ViewBookPanel viewBookPanel;
   private ViewLibrarianPanel viewLibrarianPanel;
   private UserLogin userLogin;
   private RegistrationPanel register;
   private LoginPanel buttonsPanel.
   private AdminPanel buttonsPanel;
   private LibrarianPanel buttonsPanel;

   public View()
   {
      super("Library Management System");
      buttonsPanel.= new LoginPanel();
      buttonsPanel = new AdminPanel();
      buttonsPanel = new LibrarianPanel();
      register = new RegistrationPanel();
      userLogin = new UserLogin();
      addBookPanel = new AddBookPanel();
      buttonsPanel = new ButtonPanel();

      buttonsPanel.displayUserLogin();
      setLayout(new BorderLayout());
      setPreferredSize(new Dimension(WIDTH, HEIGHT));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      add(buttonsPanel.BorderLayout.WEST);
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

   public void updateAddBookPanelListener(ActionListener listener)
   {
      addBookPanel.addOnAddBookListener(listener);
   }

   public void clearAddBookDetails()
   {
      addBookPanel.clearAddBookDetails();
   }

   public void addBookListener(ActionListener listener)
   {
      buttonsPanel.addBooksListener(listener);
   }

   public void displayViewBook(BookTableModel model)
   {
      viewBookPanel = new ViewBookPanel(model);
      changePanel(viewBookPanel);
   }

   public void addViewBookListener(ActionListener listener)
   {
      buttonsPanel.addViewBooksListener(listener);
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
      changePanel(buttonsPanel.;
   }

   public void displayAdminSection()
   {
      changePanel(buttonsPanel);
   }

   public void displayLibrarianSection()
   {
      changePanel(buttonsPanel);
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
      buttonsPanel.addLibrarianLoginListener(listener);
   }

   public void addAdminLoginListener(ActionListener listener)
   {
      buttonsPanel.addAdminLoginListener(listener);
   }
   
   public void addRegistrationListener(ActionListener listener)
   {
      register.addRegistrationListener(listener);
   }

   public void addLogoutListener(ActionListener listener)
   {
      buttonsPanel.addLogoutListener(listener);
      buttonsPanel.addLogoutListener(listener);
   }

   public void addCreateAccountListener(ActionListener listener)
   {
      buttonsPanel.addRegistrationListener(listener);
   }
   
   public void addLibrarianListener(ActionListener listener)
   {
      buttonsPanel.addLibrarianListener(listener);
   }
   
   public void addViewLibrarianListener(ActionListener listener)
   {
      buttonsPanel.addViewLibrarianListener(listener);
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
