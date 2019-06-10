package sarpong.david.controller;

import java.awt.event.*;

import sarpong.david.view.*;
import sarpong.david.model.*;

public class Controller
{
   private Model model;
   private View view;

   public Controller(Model model, View view)
   {
      this.model = model;
      this.view = view;

      initResponsiveness();
   }

   private void initResponsiveness()
   {
      this.view.addAdminLoginListener(userLoginListener);
      this.view.addLibrarianLoginListener(userLoginListener);
      this.view.addLogoutListener(logoutListener);
      this.view.addLoginListener(loginListener);
      this.view.addRegistrationListener(registrationListener);
      this.view.addCreateAccountListener(createAccountListener);
      this.view.addLibrarianListener(addLibrarianListener);
      this.view.addViewLibrarianListener(viewLibrarianListener);
   }

   private ActionListener loginListener = new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e)
      {
         char[] password = view.getLoginPassword();
         String username = view.getLoginUsername();

         if (model.validateLogin(username, password))
         {
            view.displayAdminSection(); //todo: display correct section based on role
         }
         else
         {
            view.displayLoginError();
         }
         view.clearLogin();
      }
   };

   private ActionListener registrationListener = new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e)
      {
         String first = view.getRegistrationFirstName();
         String last = view.getRegistrationLastName();
         Name name = new Name(first, last);
         
         String username = view.getRegistrationUsername();
         String emailAddress = view.getRegistrationEmailAddress();
         Email email = new Email(emailAddress);

         char[] password = view.getRegistrationPassword();
         int age = view.getRegistrationAge();
         Gender gender = view.getRegistrationGender();
         Role role = view.getRegistrationAccessRights();
         AbstractStaff staff;

         if (role == Role.Admin)
         {
            staff = new Admin(name, email, gender, age, username);
         }
         else
         {
            staff = new Librarian(name, email, gender, age, username);
         }

         model.createStaffAccount(staff, new String(password));
         view.displayLogin();
      }
   };

   private ActionListener createAccountListener = new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e)
      {
         view.displayRegistration(); 
      }
   };
   
   private ActionListener userLoginListener = new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e)
      {
         view.displayUserLogin(); 
      }
   };

   private ActionListener addLibrarianListener = new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e)
      {
         view.displayRegistration();
         view.setRegistrationRole(Role.Librarian);
      }
   };

   private ActionListener viewLibrarianListener = new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e)
      {
         LibrarianTableModel librarianModel = model.viewLibrarianModel();
         view.displayViewLibrarians(librarianModel, deleteLibrarianListener);
      }
   };

   private ActionListener deleteLibrarianListener = new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e)
      {
         String username = view.getLibrarianToDeleteUsername();
         view.updateDeletedLibrarian();
         model.deleteLibrarian(username);
      }
   };

   private ActionListener logoutListener = new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e)
      {
         view.displayLogin();
      }
   };

   private ActionListener addBooksListener = new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e)
      {
    
      }
   };

   private ActionListener viewBooksListener = new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e)
      {
    
      }
   };

   private ActionListener issueBooksListener = new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e)
      {
    
      }
   };

   private ActionListener viewIssueBooksListener = new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e)
      {
    
      }
   };

   private ActionListener returnBookListener = new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e)
      {
    
      }
   };

   public static void main(String[] args)
   {
      Model model = new Model();
      View view = new View();

      Controller controller = new Controller(model, view);
   }
}
