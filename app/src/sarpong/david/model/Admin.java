package sarpong.david.model;

public class Admin extends AbstractStaff
{
   public Admin(Name name, Email email, Gender gender, int age, String username)
   {
      super(name, email, gender, age, username);
      super.setAccessRights(Role.Admin);
   }
}
