package sarpong.david.view;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

public class HoverButton extends JButton implements MouseListener
{
   /**
    * 
    */
   private static final long serialVersionUID = 6324484517731279704L;
   private static final int HEIGHT = 50;

   private Color color;

   public HoverButton()
   {
      super();

      initButton();
   }

   public HoverButton(String label)
   {
      super(label);
      color = Color.WHITE;
      
      initButton();
   }

   private void initButton()
   {
      setFont(new Font("Arial", Font.PLAIN, 25));
      setBorder(new LineBorder(color));
      setOpaque(true);
      setPreferredSize(new Dimension(ButtonPanel.WIDTH, HEIGHT));
      addMouseListener(this);
   }

   @Override
   public Dimension getPreferredSize()
   {
      return new Dimension(ButtonPanel.WIDTH, HEIGHT);
   }

   @Override
   public void mouseClicked(MouseEvent e) {}

   @Override
   public void mouseReleased(MouseEvent e) {}

   @Override
   public void mousePressed(MouseEvent e) {}

   @Override
   public void mouseExited(MouseEvent e)
   {
      setBackground(Color.WHITE);
   }

   @Override
   public void mouseEntered(MouseEvent e)
   {
      setFont(new Font("Arial", Font.BOLD, 25));
      setBackground(Color.darkGray);
   }

   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Test");
      frame.add(new HoverButton("Test Vutton"));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}
