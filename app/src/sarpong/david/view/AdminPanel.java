package sarpong.david.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class AdminPanel extends JPanel
{
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   private JButton add;
   private JButton view;
   private JButton delete;
   private JButton logout;

   public AdminPanel()
   {
      super();
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      setPreferredSize(new Dimension(View.WIDTH, View.HEIGHT));

      add = new JButton("Add Librarian");
      view = new JButton("View Librarian");
      delete = new JButton("Delete Librarian");
      logout = new JButton("Logout");

      add(add);
      add(view);
      add(delete);
      add(logout);
   }

   public void addLibrarianListener(ActionListener listener)
   {
      add.addActionListener(listener);
   }

   public void addViewLibrarianListener(ActionListener listener)
   {
      view.addActionListener(listener);
   }

   public void addDeleteLibrarianListener(ActionListener listener)
   {
      delete.addActionListener(listener);
   }

   public void addLogoutListener(ActionListener listener)
   {
      logout.addActionListener(listener);
   }

   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      frame.add(new AdminPanel());
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}
