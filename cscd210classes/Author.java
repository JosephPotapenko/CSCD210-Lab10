package cscd210classes;
//the FINISHED notes are for myself to keep track of what I've done and what I haven't

public class Author implements Comparable<Author>
{
   //FINISHED
   //Initialized the variables
   private String first;
   private String last;
   private int numBooks;
   private String publisher;
  
   //FINISHED
   //Passes the values of params into the variables  
   public Author(String last, String first, String publisher, int numBooks)
   {
      if(last == null || first == null || publisher == null || last == " " || first == " " || publisher == " ")
         throw new IllegalArgumentException ("Bad parameters in Author");
    
     this.last = last; 
     this.first =  first;
     this.publisher = publisher;
     this.numBooks = numBooks; 
   }
   
   //FINISHED
   /*Returns the first name, last name, publisher, and number of books in 
     proper format. 
     @Override willcheck for overriding between the two classes which 
     have the same class but different params. (reference Overriding)
   */
   @Override
   public String toString()
   {
      String temp = this.first + " " + this.last + " - " + this.publisher + " - " + this.numBooks;
      return temp;
   }
   
   //FINISHED
   /* This compareTo method first compares by last name. If last names are 
      the same then it compares based on first names. If first names are 
      the same then it compares based on publisher. If the publishers are 
      the same it compares based on the number of books.
   */
   public int compareTo(Author another)
   {
      if(Author[].class == null)
         throw new IllegalArgumentException("Bad parameters compareTo");  
         
      int res = this.last.compareTo(another.last);
      if(res != 0)
         return res;

      res = this.first.compareTo(another.first);
      if(res != 0)
         return res;
      
      res = this.publisher.compareTo(another.publisher);
      if(res != 0)
         return res;
         
      return this.numBooks - another.numBooks;
   }

   //FINISHED
   /*This method returns true if this == obj, returns false if obj == null, 
     returns false if obj is not an instanceof Author,
     returns true if the this last is equals another last, 
     this first equals another first this publisher equals another publisher, 
     and this numBooks is equals to anothernumBooks. False otherwise
     @Override willcheck for overriding between the two classes which 
     have the same class but different params. (reference Overriding)
   */
   @Override
   public boolean equals(Object obj)
   {
      if(obj == this) return true;
      if(obj == null) return false;
      if(!(obj instanceof Author)) return false;
      Author another = (Author)obj;
      
      return this.first.equals(another.first) && this.last.equals(another.last) && this.publisher.equals(another.publisher) && this.numBooks == another.numBooks;
   }
   
   //FINISHED
   /*The hashCode adds all the hashCodes together for all the 
     private strings in the class and then the number of books.
     @Override willcheck for overriding between the two classes which 
     have the same class but different params. (reference Overriding)
   */
   @Override
   public int hashCode()
   {
      return this.first.hashCode() + this.last.hashCode() + this.publisher.hashCode() + numBooks;
   }
   
   //FINISHED
   //this method returns nuBooks when referenced
   public int getBooks(){return this.numBooks;}
   
   //this method returns publisher when referenced
   public String getPublisher(){return this.publisher;}


}