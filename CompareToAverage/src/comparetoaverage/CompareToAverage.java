// Avraham Moryose
// CS 207_3
// Assignment 5

package comparetoaverage;

import java.util.Random;

public class CompareToAverage
{
   public static void main(String [] args)
   {
      int [][] list = new int [7][7];
      int average = 0;
      int greaterThanAverage = 0;
      int equalToAverage = 0;
      int lessThanAverage = 0;
      
      loadArray(list);
      displayArray(list);
      
      average = average(list);
      
      System.out.println("\nThe average of all values is: " + average);
      greaterThanAverage = greaterThanAverage(list, average);
      
      System.out.println("\nThe number of values greater than average " +
                              " is: " + greaterThanAverage);
      equalToAverage = equalToAverage(list, average);
      
      System.out.println("\nThe number of values equal to average " +
                              " is: " + equalToAverage);
      lessThanAverage = lessThanAverage(list, average);
      
      System.out.println("\nThe number of values less than average " +
                              " is: " + lessThanAverage);      
   }
   
   public static void loadArray(int [][] a)
   {
      int max = 100; //cap for random values
      
      Random generator = new Random();
      
      int row, col;
      for(row = 0; row < a.length; row++)
      {
         for(col = 0; col < a[row].length; col++)
         {
            a[row][col] = generator.nextInt(max);
         }
      }
   }
   
   public static void displayArray(int [][] a)
   {
      int row, col;
      
      for(row = 0; row < a.length; row++)
      {
         for(col = 0; col < a[row].length; col++)
            System.out.print(a[row][col] + "\t");
            
         System.out.println();
      }
   }
   
   public static int average(int [][] a)
   {
       int avg = 0; //average
       int sum = 0;
       int count = 0;
       for(int row = 0; row < a.length; row++)
       {
           for(int col = 0; col < a[row].length; col++)
           {
               if(row == col)
               {
                  count = count + 1;
                  sum = sum + a[row][row];
                  avg = sum / count; 
               }   
            }
        }
       return(avg);
   }
   
   public static int greaterThanAverage(int [][] a, int avg)
   {
       int count = 0;
              
       for(int row = 0; row < a.length; row++)
       {
           for(int col = 0; col < a[row].length; col++)
           {
               if(a[row][col] > average(a))
                  count = count + 1;
           }
       }
       return(count);
   }
   
   public static int equalToAverage(int [][] a, int average)
   {
      int count = 0;
            
      for(int row = 0; row < a.length; row++)
      {
          for(int col = 0; col < a[row].length; col++)
          {
              if(a[row][col] == average(a))
               count = count + 1;
          }
      }
      return(count);
   }
   
   public static int lessThanAverage(int [][] a, int average)
   {
      int count = 0;
      average = average(a);
      
      for(int row = 0; row < a.length; row++)
      {
          for(int col = 0; col < a[row].length; col++)
          {
              if(a[row][col] < average)
               count = count + 1;
          }
      }
      return(count);
   } 
}