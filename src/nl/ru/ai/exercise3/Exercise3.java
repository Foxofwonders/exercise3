package nl.ru.ai.exercise3;

import java.util.ArrayList;

/**
 * @author Denise van Baalen (s4708237)
 * @author Anna Gansen (s4753755)
 */

public class Exercise3
{

  public static void main(String[] args)
  {
//    /*
//     * Create an ArrayList of names
//     */
//    ArrayList<String> names=new ArrayList<String>();
//    names.add("Sparky");
//    names.add("Nino");
//    names.add("Djamari");
//    names.add("Eireen");
//    names.add("Joan");
//    names.add("Haye");
//    names.add("Haye");
//    /*
//     * Print them (unsorted)
//     */
//    System.out.println("Unsorted: "+names);
//    /*
//     * Sort them
//     */
//    selectionSort(names,0);
//    /*
//     * Print them (sorted)
//     */
//    System.out.println("Sorted: "+names);
    printFibs3(45);
  }
  
  static int fib (int n, int[]memo)
  {
	  if ( n == 0 || n == 1 )
		  return 1 ;
	  
	  
	  
	  if(memo[n-1]!=0 && memo[n-2]!=0)
	  {
		  return memo[n-1] + memo[n-2];
	  }
	  else if(memo[n-2]!=0)
	  {
		  memo[n-1]=memo[n-2]+memo[n-3];
		  return fib (n-1, memo) + fib (n-2, memo);
	  }
	  else
	  {
		  return fib (n-1, memo) + fib (n-2, memo);
	  }
	  
  } 

  /*
   * Prints the first 42 (43) numbers of the fibonacci sequence very quickly, but slows down significantly after that.
   */
  private static void printFibs(int times)
  {
	  assert times>0: "Please choose a positive number of times to print fibonacci numbers.";
	  
	  int[] memo = new int [times];
	  memo[0]=1;
	  memo[1]=1;
		  
	  for(int i=0; i<=times; i++)
	  {
		  System.out.println("n " + i + "=" + fib(i, memo));
	  }
  }
  
  static int fib3 (int n, int[]memo)
  {
	  if ( n == 0 || n == 1 )
		  return 1 ;
	  
	  
	  
	  if(memo[3]!=0 && memo[4]!=0)
	  {
		  return memo[4] + memo[3];
	  }
	  else if(memo[3]!=0)
	  {
		  memo[4]=memo[3]+memo[2];
		  
		  int help1 = memo[3];
		  int help2 = memo[4];
		  
		  memo[2]= help1;
		  memo[3]= help2;
		  memo[4]= 0;
		  return fib (n-1, memo) + fib (n-2, memo);
	  }
	  else
	  {
		  return fib (n-1, memo) + fib (n-2, memo);
	  }
	  
  } 

  /*
   * Prints the first 42 (43) numbers of the fibonacci sequence very quickly, but slows down significantly after that.
   */
  private static void printFibs3(int times)
  {
	  assert times>0: "Please choose a positive number of times to print fibonacci numbers.";
	  
	  int[] memo = new int [5];
	  memo[0]=1;
	  memo[1]=1;
		  
	  for(int i=0; i<=times; i++)
	  {
		  System.out.println("n " + i + "=" + fib3(i, memo));
	  }
  }

/**
   * Sorts an array insitu in ascending order using selection sort
   * @param array
   * @oaram length
  /**
   * Sorts an ArrayList insitu in ascending order using selection sort
   * @param arraylist
   * @oaram sorted elements
   */
  static <T extends Comparable<T>> void selectionSort(ArrayList<T> arraylist, int sorted)
  {
	  assert arraylist!=null : "array should be initialized";
	  if(sorted==arraylist.size())
		  return;
	  else
	  {
		  swap(arraylist,sorted,indexOfSmallestValue(arraylist,new Slice(sorted,arraylist.size())));
		  selectionSort(arraylist,sorted+1);
	  }
  }
  /**
   * Finds index of smallest value in ArrayList slice
   * @param arraylist
   * @param slice
   * @return index of smallest value
   */
  static <T extends Comparable<T>> int indexOfSmallestValue(ArrayList<T> arraylist, Slice slice)
  {
    assert arraylist!=null : "Array should be initialized";
    assert slice.isValid()&&slice.upto<=arraylist.size() : "Slice should be valid";
    assert slice.upto-slice.from>0 : "Slice should be non-empty";
    
    int index=slice.from;
    int i=slice.from;
    if(i==slice.upto-1)
    	return index;
    else
    {
      if(arraylist.get(i).compareTo(arraylist.get(indexOfSmallestValue(arraylist,new Slice(i+1,arraylist.size()))))<0)
        return i;
    }
    return indexOfSmallestValue(arraylist,new Slice(i+1,arraylist.size()));
    
  }
  /**
   * Swap two elements in an ArrayList
   * @param arraylist
   * @param i
   * @param j
   */
  private static <T extends Comparable<T>> void swap(ArrayList<T> arraylist, int i, int j)
  {
    assert arraylist!=null : "Array should be initialized";
    assert i>=0&&i<arraylist.size() : "First index is invalid";
    assert j>=0&&j<arraylist.size() : "Second index is invalid";
    T help=arraylist.get(i);
    arraylist.set(i,arraylist.get(j));
    arraylist.set(j,help);
  }
}
