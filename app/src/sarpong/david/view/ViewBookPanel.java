package sarpong.david.view;

import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;

import sarpong.david.model.*;

public class ViewBookPanel extends JPanel
{
   private static final int ISBN_COLUMN = 3;

   private JTextField searchName;
   private JTable table;
   private JScrollPane scrollPane;
   private BookTableModel model;

   public ViewBookPanel(BookTableModel model)
   {
      super(new BorderLayout());

      this.model = model;

      setPreferredSize(new Dimension(View.WIDTH, View.HEIGHT));
      setBorder(BorderFactory.createTitledBorder("Books"));

      table = new JTable(model);
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      scrollPane = new JScrollPane(table);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      add(scrollPane, BorderLayout.CENTER);
   }

   public void deleteRow()
   {
      int row = table.getSelectedRow();
      model.deleteRow(row);
   }

   public String getSelectedBookISBN()
   {
      int row = table.getSelectedRow();
      int column = ISBN_COLUMN;

      return (String) table.getValueAt(row, column);
   }

   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      BookTableModel model = new BookTableModel();
      ViewBookPanel panel = new ViewBookPanel(model);

      frame.add(panel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}
