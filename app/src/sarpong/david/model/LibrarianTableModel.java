package sarpong.david.model;

import sarpong.david.model.*;

import javax.swing.table.*;

import java.sql.*;
import java.util.ArrayList;

public class LibrarianTableModel extends AbstractTableModel
{
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   private static final String[] colNames = {"Name", "Email Address", "Username", "Age", "Gender", "Role"};
   private static final Class[] colClasses = {String.class, String.class, String.class, Integer.class, String.class, String.class};

   private ArrayList<Librarian> librarians;
   private ResultSet resultSet;

   public LibrarianTableModel() 
   {
      librarians = new ArrayList<>();
   }

   public LibrarianTableModel(ResultSet set)
   {
      resultSet = set;
      librarians = new ArrayList<>();
      
      try
      {
         parseResultSet();
      }
      catch (Exception e)
      {
         System.err.println("Cannot instantiate the LibrarianTableModel constructor");
      }
   }

   private void parseResultSet() throws SQLException
   {
      resultSet.beforeFirst();
     
      while (resultSet.next())
      {
         Gender sex = null;
         String name = resultSet.getString("name");
         Name librarianName = new Name(name);

         String email = resultSet.getString("email_address");
         Email emailAddress = new Email(email);

         String username = resultSet.getString("username");
         String role = resultSet.getString("role"); 
         
         String gender = resultSet.getString("gender");
         if (gender.equals("Male"))
         {
            sex = Gender.Male;
         }
         else
         {
            sex = Gender.Female;
         }

         int age = resultSet.getInt("age");

         Librarian librarian = new Librarian(librarianName, emailAddress, sex, age, username);
         librarians.add(librarian);
      }
   }

   public void deleteRow(int row)
   {
      librarians.remove(row);

      fireTableRowsDeleted(row, row);
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
         System.err.println("Cannot instantiate the LibrarianTableModel constructor");
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
      return librarians.size();
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
      Librarian librarian = librarians.get(row);
      Object val = null;
      
      try
      {
         switch (column)
         {
            case 0:
               val = librarian.getName().toString();
               break;

            case 1:
               val = librarian.getEmail().toString();
               break;

            case 2:
               val = librarian.getUsername();
               break;

            case 3:
               val = librarian.getAge();
               break;

            case 4:
               val = librarian.getGender().name();
               break;

            case 5:
               val = librarian.getRole().name();
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
