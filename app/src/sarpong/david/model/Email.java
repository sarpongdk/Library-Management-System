package sarpong.david.model;

public class Email
{
   private String localPart;
   private String domain;

   public Email(String address) throws IllegalArgumentException
   {
      String[] email = address.split("@");

      if (isValid(email[0], email[1]))
      {
         localPart = email[0];
         domain = email[1];
      }
      else
      {
         throw new IllegalArgumentException();
      }
   }

   public Email(String localPart, String domain) throws IllegalArgumentException
   {
      if (!isValid(localPart, domain))
      {
         throw new IllegalArgumentException();
      }

      this.localPart = localPart;
      this.domain = domain;
   }

   private boolean isValid(String localPart, String domain)
   {
      if (localPart.matches("[A-Za-z0-9]+") && domain.matches("[A-Za-z0-9]+.com"))
      {
         return true;
      }

      return false;
   }
}
