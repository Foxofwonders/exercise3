package nl.ru.ai.exercise3;

import java.util.ArrayList;

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
//    /*
//     * Print them (unsorted)
//     */
//    System.out.println("Ongesorteerd: "+names);
//    /*
//     * Sort them
//     */
//    selectionSort(names);
//    /*
//     * Print them (sorted)
//     */
//    System.out.println("Gesorteerd: "+names);
	  printFibs(1000);
  }

  /*
   * Prints the first 42 (43) numbers of the fibonacci sequence very quickly, but slows down significantly after that.
   */
  private static void printFibs(int times)
  {
	  assert times>0: "Please choose a positive number of times to print fibonacci numbers.";
	  
	  for(int i=0; i<times; i++)
	  {
		  System.out.println("n" + i + "=" + fib(i));
	  }
  }

/**
   * Sorts an array insitu in ascending order using selection sort
   * @param array
   * @oaram length
   */
  static <T extends Comparable<T>> void selectionSort(ArrayList<T> array)
  {
    assert array!=null : "array should be initialized";
    for(int i=0;i<array.size();i++)
    {
      int j=indexOfSmallestValue(array,new Slice(i,array.size()));
      swap(array,i,j);
    }
  }
  /**
   * Finds index of smallest value in array slice
   * @param array
   * @param slice
   * @return index of smallest value
   */
  static <T extends Comparable<T>> int indexOfSmallestValue(ArrayList<T> array, Slice slice)
  {
    assert array!=null : "Array should be initialized";
    assert slice.isValid()&&slice.upto<=array.size() : "Slice should be valid";
    assert slice.upto-slice.from>0 : "Slice should be non-empty";
    int index=slice.from;
    for(int i=slice.from+1;i<slice.upto;i++)
      if(array.get(i).compareTo(array.get(index))<0)
        index=i;
    return index;
  }
  /**
   * Swap two elements in an array
   * @param array
   * @param i
   * @param j
   */
  private static <T extends Comparable<T>> void swap(ArrayList<T> array, int i, int j)
  {
    assert array!=null : "Array should be initialized";
    assert i>=0&&i<array.size() : "First index is invalid";
    assert j>=0&&j<array.size() : "Second index is invalid";
    T help=array.get(i);
    array.set(i,array.get(j));
    array.set(j,help);
  }
  
  static int fib ( int n )
  {
	  if ( n == 0 || n == 1 )
		  return 1 ;
		  else
		  return fib (n-1) + fib (n-2);
  } 
}
