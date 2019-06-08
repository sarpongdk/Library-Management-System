package sarpong.david.model;

public class Librarian extends AbstractStaff
{
   public Librarian(Name name, Email email, Gender gender, int age, String username)
   {
      super(name, email, gender, age, username);
      super.setAccessRights(Role.Librarian);
   }
}
