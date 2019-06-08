package sarpong.david.model;

import java.sql.*;

public class Model
{
   private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
   private static final String URL = "jdbc:mysql://localhost:3306/lib";
   private static final String USERNAME = "projects";
   private static final String PASSWORD = "password";

   private Connection connection;
   private Statement statement;
   private PreparedStatement preparedStatement;
   private ResultSet resultSet;

   public Model()
   {
      try
      {
         Class.forName(DRIVER_CLASS);
         connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
         statement = connection.createStatement();
         //preparedStatement = connection.prepareStatement();
      }
      catch (Exception e)
      {
         System.err.println("Cannot connect to the database");
         e.printStackTrace();
         System.exit(1);
      }
   }

   public boolean verifyLogin(AbstractStaff staff)
   {
      return true;
   }

   public void registerLibrarian()
   {
   
   }

   public void registerAdmin()
   {
    
   }

   public void addLibrarian(Librarian librarian)
   {
    
   }

   public void viewLibrarian()
   {
          
   }

   public void deleteLibrarian(Librarian librarian)
   {
    
   }

   public void addBook(Book book)
   {
    
   }

   public void viewBook()
   {
 
   }

   public static void main(String[] args)
   {
      Model model = new Model();
   }
}
