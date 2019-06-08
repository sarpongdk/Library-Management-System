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

      this.view.addAdminLoginListener(userLoginListener);
      this.view.addLibrarianLoginListener(userLoginListener);
      this.view.addLogoutListener(logoutListener);
      this.view.addLoginListener(loginListener);
      this.view.addRegistrationListener(registrationListener);
      this.view.addCreateAccountListener(createAccountListener);
   }

   private ActionListener loginListener = new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e)
      {
         view.clearLogin();

         String username = view.getLoginUsername(); 
         char[] password = view.getLoginPassword();

         if (model.validateLogin(username, password))
         {
            view.displayAdminSection();
         }
      }
   };

   private ActionListener registrationListener = new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e)
      {
         String first = view.getRegistrationFirstName();
         String last = view.getRegistrationLastName();
         Name name = new Name(first, last);
         
         String emailAddress = view.getRegistrationEmailAddress();
         Email email = new Email(emailAddress);

         char[] password = view.getRegistrationPassword();
         int age = view.getRegistrationAge();
         
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
    
      }
   };

   private ActionListener viewLibrarianListener = new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e)
      {
    
      }
   };

   private ActionListener deleteLibrarianListener = new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e)
      {
    
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
