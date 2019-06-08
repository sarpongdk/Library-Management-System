package sarpong.david.model;

public abstract class AbstractStaff
{
   protected Name name;
   protected Email email;
   protected Gender gender;
   protected int age;
   protected String username;
   protected Role role;

   public AbstractStaff(Name name, Email email, Gender gender, int age, String username)
   {
      this.name = name;
      this.email = email;
      this.gender = gender;
      this.age = age;
      this.username = username;
   }

   public String getUsername()
   {
      return username;
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

   public Role getRole()
   {
      return role;
   }

   public void setAccessRights(Role rights)
   {
      role = rights;
   }

   @Override
   public String toString()
   {
      String staff = "Name: " + name.toString() + "\nEmail Address: " + email.toString() + "\nGender: " + gender.toString() + "\nStaff Position: " + role.toString();
      return staff;
   }
}
