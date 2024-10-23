package cscd210comparators;

import java.util.Comparator;
import cscd210classes.Author;

public class ReverseNumBooksNotReversePublisherComparator implements Comparator<Author>   
{

   //FINISHED
   //Compares books and publishers for total order
   public int compare(final Author a1, final Author a2)
   {
      if( a1 == null || a2 == null)
         throw new IllegalArgumentException ("Bad parameters in compare.");
         
      int res = a2.getBooks() - a1.getBooks();
      if (res != 0) return res;
      
      return a1.getPublisher().compareTo(a2.getPublisher());
   }
   
   
   
}