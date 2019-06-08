package sarpong.david.model;

public class Librarian extends AbstractStaff
{
   public Librarian(Name name, Email email, Gender gender, int age)
   {
      super(name, email, gender, age);
      super.setAccessRights(AccessRights.Librarian);
   }
}
