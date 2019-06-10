package sarpong.david.view;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

public class AddBookPanel extends JPanel
{
   private JButton addButton; 
   private JTextField title, author, year;
   private JCheckBox isIssued;

   public AddBookPanel()
   {
      super();

      title = new JTextField();
      author = new JTextField();
      year = new JTextField();
      isIssued = new JCheckBox();
      addButton = new JButton("Add Book");

      setPreferredSize(new Dimension(View.WIDTH, View.HEIGHT));
      setBorder(new TitledBorder("Add Book"));

      add(title);
      add(author);
      add(year);
      add(isIssued);
      add(addButton);
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
