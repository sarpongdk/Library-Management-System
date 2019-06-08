package sarpong.david;

import sarpong.david.model.*;
import sarpong.david.view.*;
import sarpong.david.controller.*;

public class Driver
{
   public static void main(String[] args)
   {
      Model model = new Model();
      View view = new View();

      Controller controller = new Controller(model, view);
   }
}
