package sarpong.david.model;

import javax.swing.*;
import javax.swing.table.*;

import java.sql.*;

public class LibrarianTableModel extends AbstractTableModel
{
   private static final String[] colNames = {"Name", "Email Address", "Username", "Age", "Gender", "Role"};
   private static final Class[] colClasses = {String.class, String.class, String.class, Integer.class, String.class, String.class};
   
   private ResultSet resultSet;
   private int rowCount;

   public LibrarianTableModel() {}

   public LibrarianTableModel(ResultSet set)
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
               val = resultSet.getString("name");
               break;

            case 1:
               val = resultSet.getString("email_address");
               break;

            case 2:
               val = resultSet.getString("username");
               break;

            case 3:
               val = resultSet.getInt("age");
               break;

            case 4:
               val = resultSet.getString("gender");
               break;

            case 5:
               val = resultSet.getString("role");
               break;
         }

      }
      catch (Exception e)
      {
         System.err.println("Cannot get value from query in librarianTableModel");
      }
      
      return val;
   }
}
