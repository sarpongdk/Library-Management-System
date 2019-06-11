package sarpong.david.model;

public class Book
{
   private String author;
   private String title;
   private boolean issued;
   private int publicationYear;
   private int isbn;
 
   public Book(String author, String title, boolean issued, int publicationYear, int isbn)
   {
      this.author = author;
      this.title = title;
      this.issued = issued;
      this.isbn = isbn;
      this.publicationYear = publicationYear;
   }

   public int getISBN()
   {
      return isbn;
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

