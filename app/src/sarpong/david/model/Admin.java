package sarpong.david.model;

public class Admin extends AbstractStaff
{
   public Admin(Name name, Email email, Gender gender, int age)
   {
      super(name, email, gender, age);
      super.setAccessRights(AccessRights.Admin);
   }
}
