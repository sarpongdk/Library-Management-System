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

      this.view.addAdminLoginListener(adminLoginListener);
      this.view.addLibrarianLoginListener(librarianLoginListener);
      this.view.addLogoutListener(logoutListener);
   }

   private ActionListener adminLoginListener = new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e)
      {
         view.displayUserLogin(); 
      }
   };

   private ActionListener librarianLoginListener = new ActionListener() {
      
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
