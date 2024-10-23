package cscd210methods;

import java.util.Scanner;
import cscd210classes.Author;

/**
 * The methods for this lab
 * @NOTE all parameters will be passed as final and all preconditions will be met
 */
public class CSCD210Lab10Methods
{
   //FINISHED (by Stu)
   /** 
    * The basic menu method provided by me
    * @param kb Representing the Scanner object
    * @return int Representing the menu choice
    * @throws IllegalArgumentException if kb is null
    * @Post The input buffer is left clean
    */
   public static int menu(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("Bad param menu");
   
      int choice;
      do
      {
         System.out.println("Please choose from the following");
         System.out.println("1) Print the Array to the Screen");
         System.out.println("2) Add an item into the Array");
         System.out.println("3) Delete an item from the Array");
         System.out.println("4) Total Order based on reverse book and not reverse publisher");
         System.out.println("5) Quit");
         System.out.print("Choice --> ");
         choice = Integer.parseInt(kb.nextLine());
      
      }while(choice < 1 || choice > 5);
      
      return choice;
   }// end menu
   
   //FINISHED
   /** 
    * The fillArray method<br>
    * 1) Prompts for the number of authors and ensures it is greater than 0<br>
    * 2) Creates an array of Author for the total number
    * 3) reads the first, last name, publisher, and number of books
    * 4) Builds an author object<br>
    * 5) Puts that author object into the array<br>
    * 6) When done filling the array returns the array<br>
    * @param kb Representing the Scanner object
    * @return Author array Representing the filled array
    * @throws IllegalArgumentException if kb is null
    * @Post The input buffer will be left empty
    */
   public static Author [] fillArray(final Scanner kb)
   {
      if (kb == null)
         throw new IllegalArgumentException("Bad params fillArray");
      
      int numAuthors;
      do 
      {
         System.out.print("Enter the number of authors: ");
         numAuthors = Integer.parseInt(kb.nextLine());  
      } while (numAuthors <= 0);
      
      Author[] author = new Author[numAuthors];
      for(int x = 0; x < numAuthors; x++)
      {
         System.out.print("Please enter last name: ");
         String last = kb.nextLine();
         System.out.print("Please enter first name: ");
         String first = kb.nextLine();
         System.out.print("Please enter the publisher: ");
         String publisher = kb.nextLine();
         System.out.print("Please enter the number of books: ");
         int numBooks = Integer.parseInt(kb.nextLine());  
         
         author[x] = new Author(last, first, publisher, numBooks);
      }
      
      return author;
   }// end fillArray   
   
   //FINISHED
   /** 
    * The readAuthor method prompts the user for the first and last name
    * the publisher and the nubmer of books.  If any of the strings are null or empty or the books is less than 1
    * the user is reprompted.  <br>
    * Once all information has been read in and validated as not null or empty or less than 1
    * then an Author object is created and returned
    * @param kb Representing the Scanner object
    * @return Author Representing an Author object
    * @throws IllegalArgumentException if kb is null
    * @Post The input buffer is left clean
    */
   public static Author readAuthor(final Scanner kb)
   {  
      if(kb == null)
         throw new IllegalArgumentException ("Bad parameters in readAuthor");

      String first, last, publisher;
      int numBooks;
      
      
      do
      {
         System.out.print("Please enter first name: ");
         first = kb.nextLine();
      }while(first == null || first.isEmpty());
      
      do
      {
         System.out.print("Please enter last name: ");
         last = kb.nextLine();
      }while(last == null || last.isEmpty());
      
      do
      {
         System.out.print("Please enter the publisher: ");
         publisher = kb.nextLine();
      }while(publisher == null || publisher.isEmpty());
      
      do
      {
         System.out.print("Please enter the number of books: ");
         numBooks = Integer.parseInt(kb.nextLine());  
      }while(numBooks < 1);
 
      return new Author (last, first, publisher, numBooks);        
   }// end readAuthor

   //FINISHED (by Stu)
   /** 
    * The add method is passed the array and an Author object<br>
    * 1) A new Author array is created of length of the old array + 1<br>
    * 2) The Authors from the old array are copied into the new array<br>
    * 3) The new Author is added in the last index of the new array<br>
    * 4) The new array is returned
    * @param array Representing the Author array
    * @param item Representing the Author to be added into the array
    * @return Author [] Representing new array
    * @throws IllegalArgumentException if array or item is null or the array length is less than 0
    */
   public static Author[] add(final Author [] array, final Author item)
   {
      if(array == null || item == null || array.length < 0)
         throw new IllegalArgumentException("Bad param add");
   
      Author [] copy = new Author [array.length + 1];
      for(int x = 0; x < array.length; x++)
         copy[x] = array[x];
         
      copy[array.length] = item;
      
      return copy;
   }// end add
   
   
   /** 
    * The remove method is passed the array and an index<br>
    * 1) If the index is -1 or the array length is 0 then the original array is returned<br>
    * 2) A new Author array is created of length of the old array - 1<br>
    * 2) The Authors from the old array are copied into the new array except for the index that is being removed<br>
    * 4) The new array is returned
    * @param array Representing the Author array
    * @param index Representing the index to remove
    * @return Author [] Representing new array
    * @throws IllegalArgumentException if array or the array length is less than 0 or index is greater than or equal to the array length or index is less than -1
    */
   public static Author[] remove(final Author[] array, final int index)
   {
      if (array == null || array.length < 0 || index >= array.length || index < -1)
         throw new IllegalArgumentException("Bad parameters in remove.");
      
      if (index == -1 || array.length == 0 )
         return array;
      
      Author[] newArray = new Author[array.length - 1];
      int x = 0;
      for (int y = 0; y < array.length; y++) 
      {
         if (y != index) 
         {
            newArray[x] = array[y];
            x++;
         }
         
      }
      return newArray;
   }// end remove
   
}// end class
