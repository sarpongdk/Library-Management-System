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

   public boolean validateLogin(String username, char[] password)
   {
      String pwd = new String(password);
      username = username.trim();
      
      String sqlCommand = "SELECT * FROM lib.user_account WHERE username='" + username + "' AND password='" + pwd + "'";

      try
      {
         resultSet = statement.executeQuery(sqlCommand);
         
         if (resultSet.next())
         {
            return true;
         }
         else
         {
            return false;
         }
      } 
      catch (SQLException e)
      {
         System.err.println("Cannot find query");
         e.printStackTrace();
         return false;
      }
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
      System.out.println(model.toString());
   }
}
