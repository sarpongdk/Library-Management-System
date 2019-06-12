package sarpong.david.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ButtonPanel extends JPanel
{
   public static final int WIDTH = 250;
   private static final long serialVersionUID = 6324484517731279704L;

   private HoverButton addLibrarian, viewLibrarian, logout;
   private HoverButton addBooks, viewBooks, issueBook, viewIssuedbooks, returnBook;
   private HoverButton login, register;

   public ButtonPanel()
   {
      super();
      addBooks = new HoverButton("Add Book");
      viewBooks = new HoverButton("View Books");
      issueBook = new HoverButton("Issue Book");
      viewIssuedbooks = new HoverButton("View Issued Book");
      returnBook = new HoverButton("Return Book");
      logout = new HoverButton("Logout");

      addLibrarian = new HoverButton("Add Librarian");
      viewLibrarian = new HoverButton("View Librarian");

      login = new HoverButton("Login");
      register = new HoverButton("Register");

      setPreferredSize(new Dimension(WIDTH, View.HEIGHT));
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
   }

   public void displayAdminSection()
   {
      removeAll();
      add(addLibrarian);
      add(viewLibrarian);
      add(logout);

      repaint();
      revalidate();
   }

   public void displayLibrarianSection()
   {
      removeAll();
      add(addBooks);
      add(viewBooks);
      add(issueBook);
      add(viewIssuedbooks);
      add(returnBook);
      add(logout);

      repaint();
   }

   public void displayUserLogin()
   {
      removeAll();
      add(login);
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
      viewIssuedbooks.addActionListener(listener);
   }   

   public void addReturnBookListener(ActionListener listener)
   {   
      returnBook.addActionListener(listener);
   } 

   public void addStaffLoginListener(ActionListener listener)
   {
      login.addActionListener(listener);
   }
    
   public void addRegistrationListener(ActionListener listener)
   {
      register.addActionListener(listener);
   }

   public static void main(String[] args)
   {
      ButtonPanel panel = new ButtonPanel();
      HoverButton btnA = new HoverButton("A");
      HoverButton btnB = new HoverButton("B");

      panel.add(btnA);
      panel.add(btnB);

      JFrame frame = new JFrame("Test");
      frame.add(panel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }


}
