package sarpong.david.model;

import sarpong.david.model.*;

import javax.swing.table.*;

import java.sql.*;
import java.util.ArrayList;

public class BookTableModel extends AbstractTableModel
{
   /**
    * 
    */
   private static final long serialVersionUID = 4413001103402558826L;
   private static final String[] colNames = {"Title", "Author", "Year", "ISBN", "Issued"};
   private static final Class[] colClasses = {String.class, String.class, Integer.class, Integer.class, Boolean.class};

   private ArrayList<Book> books;
   private ResultSet resultSet;

   public BookTableModel() 
   {
      books = new ArrayList<>();
   }

   public BookTableModel(ResultSet set)
   {
      resultSet = set;
      books = new ArrayList<>();
      
      try
      {
         parseResultSet();
      }
      catch (Exception e)
      {
         System.err.println("Cannot instantiate the BookTableModel constructor");
      }
   }

   private void parseResultSet() throws SQLException
   {
      resultSet.beforeFirst();
     
      while (resultSet.next())
      {
         String title = resultSet.getString("title");
         String author = resultSet.getString("author");
         int year = resultSet.getInt("year");
         int isbn = resultSet.getInt("isbn"); 
         boolean issued = resultSet.getBoolean("issued");

         Book book = new Book(author, title, issued, year, isbn);
         books.add(book);
      }
   }

   public void setResultSet(ResultSet set)
   {
      resultSet = set;

      try
      {
         parseResultSet();
      }
      catch (Exception e)
      {
         System.err.println("Cannot instantiate the BookTableModel constructor");
      }
   }

   public void deleteRow(int row)
   {
      books.remove(row);

      fireTableRowsDeleted(row, row);
   }

   @Override
   public String getColumnName(int column)
   {
      return colNames[column];
   }

   @Override
   public Class getColumnClass(int column)
   {
      return colClasses[column];
   }

   @Override
   public int getRowCount()
   {
      return books.size();
   }

   @Override
   public int getColumnCount()
   {
      return colNames.length;
   }

   // todo: complete this method
   @Override
   public Object getValueAt(int row, int column)
   {
      Object val = null;
      Book book = books.get(row);

      switch (column)
      {
         case 0:
            val = book.getTitle();
            break;

         case 1:
            val = book.getAuthor();
            break;

         case 2:
            val = book.getYear();
            break;

         case 3:
            val = book.getISBN();
            break;

         case 4:
            val = book.hasBeenIssued();
            break;
      }

      return val;
   }
}
