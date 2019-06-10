package sarpong.david.view;

import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;

import sarpong.david.model.*;

public class ViewLibrarianPanel extends JPanel
{
   private static final int USERNAME_COLUMN = 2;

   private JTextField searchName;
   private JTable table;
   private JScrollPane scrollPane;
   private JButton delete;
   private LibrarianTableModel model;

   public ViewLibrarianPanel(LibrarianTableModel model)
   {
      super(new BorderLayout());

      this.model = model;

      setPreferredSize(new Dimension(View.WIDTH, View.HEIGHT));
      setBorder(BorderFactory.createTitledBorder("Librarians"));

      delete = new JButton("Delete");
      table = new JTable(model);
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      scrollPane = new JScrollPane(table);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      add(scrollPane, BorderLayout.CENTER);
      add(delete, BorderLayout.SOUTH);
   }

   public void deleteRow()
   {
      int row = table.getSelectedRow();
      model.deleteRow(row);
   }

   public String getSelectedLibrarianUsername()
   {
      int row = table.getSelectedRow();
      int column = USERNAME_COLUMN;

      return (String) table.getValueAt(row, column);
   }

   public void addDeleteLibrarianListener(ActionListener listener)
   {
      delete.addActionListener(listener);
   }

   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      LibrarianTableModel model = new LibrarianTableModel();
      ViewLibrarianPanel panel = new ViewLibrarianPanel(model);

      frame.add(panel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}
