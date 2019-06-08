package sarpong.david.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class LibrarianPanel extends JPanel
{
   /**
    * 
    */
   private static final long serialVersionUID = -5136974313100589343L;
   private JButton addBooks;
   private JButton viewBooks;
   private JButton issueBook, viewIssuedBooks;
   private JButton returnBook;
   private JButton logout;
   private JLabel title;

   public LibrarianPanel()
   {
      super();
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      setPreferredSize(new Dimension(View.WIDTH, View.HEIGHT));

      title = new JLabel("Librarian Section");
      addBooks = new JButton("Add Book");
      viewBooks = new JButton("View Books");
      issueBook = new JButton("Issue Book");
      viewIssuedBooks = new JButton("View Issued Book");
      returnBook = new JButton("Return Book");
      logout = new JButton("Logout");

      add(title);
      add(addBooks);
      add(viewBooks);
      add(issueBook);
      add(viewIssuedBooks);
      add(returnBook);
      add(logout);
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

   public void addLogoutListener(ActionListener listener)
   {
      logout.addActionListener(listener);
   }

   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      frame.add(new LibrarianPanel());
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}
