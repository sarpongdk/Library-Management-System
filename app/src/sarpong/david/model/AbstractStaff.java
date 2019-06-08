package sarpong.david.model;

enum Gender
{
   Male, Female
};

enum AccessRights
{
   Librarian, Admin
};

public abstract class AbstractStaff
{
   protected Name name;
   protected Email email;
   protected Gender gender;
   protected AccessRights access;
   protected int age;

   public AbstractStaff(Name name, Email email, Gender gender, int age)
   {
      this.name = name;
      this.email = email;
      this.gender = gender;
      this.age = age;
   }

   public Name getName()
   {
      return name;
   }

   public int getAge()
   {
      return age;
   }

   public Email getEmail()
   {
      return email;
   }

   public Gender getGender()
   {
      return gender;
   }

   public void setAccessRights(AccessRights rights)
   {
      access = rights;
   }

   @Override
   public String toString()
   {
      String staff = "Name: " + name.toString() + "\nEmail Address: " + email.toString() + "\nGender: " + gender.toString() + "\nStaff Position: " + access.toString();
      return staff;
   }
}
