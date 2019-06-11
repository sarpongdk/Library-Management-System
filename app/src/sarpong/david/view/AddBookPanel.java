package sarpong.david.view;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

public class AddBookPanel extends JPanel
{
   private static final int MAX_CHARACTERS = 30;

   private JButton addButton; 
   private PlaceHolderTextField title, author, year, isbn;
   private JCheckBox isIssued;

   public AddBookPanel()
   {
      super();

      isbn = new PlaceHolderTextField(MAX_CHARACTERS, "ISBN");
      title = new PlaceHolderTextField(MAX_CHARACTERS, "Title");
      author = new PlaceHolderTextField(MAX_CHARACTERS, "Author");
      year = new PlaceHolderTextField(4, "Year");
      isIssued = new JCheckBox();
      addButton = new JButton("Add Book");

      setPreferredSize(new Dimension(View.WIDTH, View.HEIGHT));
      setBorder(new TitledBorder("Add Book"));

      add(title);
      add(author);
      add(year);
      add(isbn);
      add(isIssued);
      add(addButton);
   }

   public void clearAddBookDetails()
   {
      title.setText("");
      author.setText("");
      year.setText("");
      isbn.setText("");
      isIssued.setSelected(false);
   }

   public int getISBN()
   {
      return Integer.parseInt(isbn.getText());
   }

   public String getTitle()
   {
      return title.getText();
   }

   public String getAuthor()
   {
      return author.getText();
   }

   public int getYear()
   {
      return Integer.parseInt(year.getText());
   }

   public boolean isIssued()
   {
      return isIssued.isSelected();   
   }

   public void addOnAddBookListener(ActionListener listener)
   {
      addButton.addActionListener(listener);
   }
   
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      JPanel panel = new AddBookPanel();

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(panel);
      frame.pack();
      frame.setVisible(true);
   }
}
