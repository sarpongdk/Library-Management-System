package sarpong.david.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class PlaceHolderTextField extends JTextField implements FocusListener
{
   private String placeHolder;

   public PlaceHolderTextField(int n, String placeHolder)
   {
      super(n);

      this.placeHolder = placeHolder;
      addFocusListener(this);
   }

   public PlaceHolderTextField(String placeHolder)
   {
      super();

      this.placeHolder = placeHolder;
      addFocusListener(this);
   }

   public PlaceHolderTextField(String text, String placeHolder)
   {
      super(text);

      this.placeHolder = placeHolder;
      addFocusListener(this);
   }

   public String getPlaceHolder()
   {
      return placeHolder;
   }

    @Override
    public void focusGained(FocusEvent e) 
    {
       if (getText().equals(placeHolder)) 
       {
          setText("");
          setForeground(Color.BLACK);
       }
    }
    
    @Override
    public void focusLost(FocusEvent e) 
    {
      if (getText().isEmpty()) 
      {
         setForeground(Color.GRAY);
         setText(placeHolder);
      }
   }
}
