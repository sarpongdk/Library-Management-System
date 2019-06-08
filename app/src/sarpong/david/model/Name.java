package sarpong.david.model;

public class Name
{
   private String first, last;

   public Name(String first, String last) throws IllegalArgumentException
   {
      if (isValid(first) && isValid(last))
      {
         this.first = first;
         this.last = last;
      }
      else
      {
         throw new IllegalArgumentException();
      }
   }

   public String getFirstName()
   {
      return first;
   }

   public String getLastName()
   {
      return last;
   }

   private boolean isValid(String name)
   {
      return name.matches("[A-Za-z]+");
   }

   @Override
   public String toString()
   {
      return first + " " + last;
   }
}
