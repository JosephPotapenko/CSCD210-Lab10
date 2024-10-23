package cscd210lab10;

import java.util.*;
import cscd210utils.*;
import cscd210classes.Author;
import cscd210methods.CSCD210Lab10Methods;
import cscd210comparators.ReverseNumBooksNotReversePublisherComparator;


/**
 * The provided class to test your code.
 * @NOTE You can't change this file, all parameters are passed as final and all pre and
 * post conditions are enforced.
 * <br>You will have 3 full output runs in a file named cscd210lab10out.txt
 * <br>Your zip will be named your last name first letter of first name lab10.zip (steinerslab10.zip)
 */
public class CSCD210Lab10
{
   /**
    * The main method
    * @param args Representing command line arguments
    */
   public static void main(String [] args)
   {
      Author [] myArray = null;
      Author anAuthor = null;
      int choice, total, index;
      Scanner kb = new Scanner(System.in);
      
      myArray = CSCD210Lab10Methods.fillArray(kb); // You write
            
      SortUtils.selectionSort(myArray);
      
      do
      {
         choice = CSCD210Lab10Methods.menu(kb);
         switch(choice)
         {
            case 1:	ArrayUtils.printArray(myArray, System.out);  
            		   break;
                     
            case 2:  anAuthor = CSCD210Lab10Methods.readAuthor(kb); // You write
                     myArray = CSCD210Lab10Methods.add(myArray, anAuthor); // You write
                     SortUtils.selectionSort(myArray);
                     ArrayUtils.printArray(myArray, System.out);
                     break;
                     
            case 3:  anAuthor = CSCD210Lab10Methods.readAuthor(kb);
                     index = SearchUtils.linearSearch(myArray, anAuthor); 
                     myArray = CSCD210Lab10Methods.remove(myArray, index); // You write
                     ArrayUtils.printArray(myArray, System.out);
                     break;
                     
            case 4:  Arrays.sort(myArray, new ReverseNumBooksNotReversePublisherComparator()); // You write
                     break;
                     
            default: System.out.println("Ending");
            
         }// end switch
      
      }while(choice != 5);
    
   }// end main
   
}// end class