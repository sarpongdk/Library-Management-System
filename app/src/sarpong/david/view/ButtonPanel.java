package sarpong.david.view.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ButtonPanel extends JPanel
{
   public static final int WIDTH = 250;
   private static final long serialVersionUID = 6324484517731279704L;

   private JButton addLibrarian, viewLibrarian, logout;
   private JButton addBooks, viewBooks, issueBook, viewIssuedbooks, returnBook;
   private JButton adminLogin, librarianLogin, register;

   public ButtonPanel()
   {
      super();
      addBooks = new JButton("Add Book");
      viewBooks = new JButton("View Books");
      issueBook = new JButton("Issue Book");
      viewIssuedBooks = new JButton("View Issued Book");
      returnBook = new JButton("Return Book");
      logout = new JButton("Logout");

      addLibrarian = new JButton("Add Librarian");
      viewLibrarian = new JButton("View Librarian");

      adminLogin = new JButton("Admin Login");
      librarianLogin = new JButton("Librarian Login");
      register = new JButton("Register");

      setPreferredSize(new Dimension(WIDTH, View.HEIGHT));
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
   }

   public void displayAdminSection()
   {
      getContentPane().removeAll();
      add(addLibrarian);
      add(viewLibrarian);
      add(logout);

      repaint();
   }

   public void displayLibrarianSection()
   {
      getContentPane().removeAll();
      add(addBooks);
      add(viewBooks);
      add(issueBook);
      add(viewIssuedBooks);
      add(returnBook);
      add(logout);

      repaint();
   }

   public void displayUserLogin()
   {
      getContentPane().removeAll();
      add(adminLogin);
      add(librarianLogin);
      add(register);

      repaint();
   }

   public void addLibrarianListener(ActionListener listener)
   {   
      addLibrarian.addActionListener(listener);
   }   

   public void addViewLibrarianListener(ActionListener listener)
   {   
      viewLibrarian.addActionListener(listener);
   }   

   public void addLogoutListener(ActionListener listener)
   {   
      logout.addActionListener(listener);
   }  

   public void addBooksListener(ActionListener listener)
   {   
      addBooks.addActionListener(listener);
   }   

   public void addViewBooksListener(ActionListener listener)
   {   
      viewBooks.addActionListener(listener);
   }   

   public void addIssueBookListener(ActionListener listener)
   {   
      issueBook.addActionListener(listener);
   }   

   public void addViewIssuedBooksListener(ActionListener listener)
   {   
      viewIssuedBooks.addActionListener(listener);
   }   

   public void addReturnBookListener(ActionListener listener)
   {   
      returnBook.addActionListener(listener);
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
      ButtonPanel panel = new ButtonPanel();
      JButton btnA = new JButton("A");
      JButton btnB = new JButton("B");

      panel.add(btnA);
      panel.add(btnB);

      JFrame frame = new JFrame("Test");
      frame.add(panel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }


}
