package sarpong.david.model;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

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

   public void createStaffAccount(AbstractStaff staff, String password)
   {
      Name name = staff.getName();
      Email email = staff.getEmail();
      String username = staff.getUsername();
      int age = staff.getAge();
      Gender gender = staff.getGender();
      Role role = staff.getRole();
      String sex, pos;

      if (gender == Gender.Male)
      {
         sex = "Male";
      }
      else
      {
         sex = "Female";
      }

      if (role == Role.Admin)
      {
         pos = "Admin";
      }
      else
      {
         pos = "Librarian";
      }

      try
      {
         String sql = "INSERT INTO lib.user_account VALUES (?, ?)";
         preparedStatement = connection.prepareStatement(sql);
         preparedStatement.setString(1, username);
         preparedStatement.setString(2, password);
         preparedStatement.executeUpdate();

         String sqlCommand = "INSERT INTO lib.user_profile VALUES (?, ?, ?, ?, ?, ?)";
         preparedStatement = connection.prepareStatement(sqlCommand);
         preparedStatement.setString(1, username);
         preparedStatement.setString(2, email.toString());
         preparedStatement.setString(3, name.toString());
         preparedStatement.setString(4, sex);
         preparedStatement.setString(5, pos);
         preparedStatement.setInt(6, age);
   
         preparedStatement.executeUpdate();
      }
      catch (Exception e)
      {
         System.err.println("Unable to create account");
         e.printStackTrace();
      }
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
      JFrame frame = new JFrame();
      JPasswordField pwdField = new JPasswordField(2);
      JButton button = new JButton();
          
      button.addActionListener(new ActionListener(){
         
         @Override
         public void actionPerformed(ActionEvent e) {
            char[] pwdChar = pwdField.getPassword();
            String password = new String(pwdChar);
            System.out.println(model.validateLogin("sarpongdk", pwdChar));
            System.out.println("Password: " + password);
         }
      });
         
      frame.setLayout(new BorderLayout());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(pwdField, BorderLayout.CENTER);
      frame.add(button, BorderLayout.EAST);
      frame.pack();
      frame.setVisible(true);
   }
}
