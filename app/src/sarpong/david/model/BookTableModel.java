package sarpong.david.model;

import javax.swing.*;
import javax.swing.table.*;

import java.sql.*;

public class BookTableModel extends AbstractTableModel
{
   private static final String[] colNames = {"Title", "Author", "Year", "ISBN", "Issued"};
   private static final Class[] colClasses = {String.class, String.class, Integer.class, Integer.class, Boolean.class};
   
   private ResultSet resultSet;
   private int rowCount;

   public BookTableModel() {}

   public BookTableModel(ResultSet set)
   {
      resultSet = set;
      
      try
      {
         resultSet.last();
         rowCount = resultSet.getRow();
         resultSet.beforeFirst();
      }
      catch (Exception e)
      {
         System.err.println("Cannot instantiate the BookTableModel constructor");
      }
   }

   public void setResultSet(ResultSet set)
   {
      resultSet = set;

      try
      {
         resultSet.last();
         rowCount = resultSet.getRow();
         resultSet.beforeFirst();
      }
      catch (Exception e)
      {
         System.err.println("Cannot instantiate the BookTableModel constructor");
      }
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
      return rowCount;
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
      int i = 0;
      Object val = null;
      
      try
      {
         while (resultSet.next())
         {
            if (i == row)
            {
               break;
            }
         
            i++;
         }
         
         switch (column)
         {
            case 0:
               val = resultSet.getString("title");
               break;

            case 1:
               val = resultSet.getString("author");
               break;

            case 2:
               val = resultSet.getInt("year");
               break;

            case 3:
               val = resultSet.getInt("isbn");
               break;

            case 4:
               val = resultSet.getBoolean("issued");
               break;
         }
      }
      catch (Exception e)
      {
         System.err.println("Cannot retrieve query from BookTableModel");
      }

      return val;
   }
}
