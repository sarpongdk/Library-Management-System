package sarpong.david.model;

public class Book
{
   private String author;
   private String title;
   private boolean issued;
   private int publicationYear;

   public Book(String author, String title, boolean issued, int publicationYear)
   {
      this.author = author;
      this.title = title;
      this.issued = issued;
      this.publicationYear = publicationYear;
   }

   public String getAuthor()
   {
      return author;
   }

   public String getTitle()
   {
      return title;
   }

   public boolean hasBeenIssued()
   {
      return issued;
   }

   public boolean isAvailableToBorrow()
   {
      return !issued;
   }

   public int getYear()
   {
      return publicationYear;
   }

   public String toString()
   {
      String book = "Author: " + author + "\nTitle: " + title + "\nYear: " + Integer.toString(publicationYear);

      return book;
   }
}

