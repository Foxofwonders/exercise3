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
    /*
     * Create an ArrayList of names
     */
    ArrayList<String> names=new ArrayList<String>();
    names.add("Sparky");
    names.add("Nino");
    names.add("Djamari");
    names.add("Eireen");
    names.add("Joan");
    names.add("Haye");
    names.add("Haye");
    /*
     * Print them (unsorted)
     */
    System.out.println("Unsorted: "+names);
    /*
     * Sort them
     */
    selectionSort(names,0);
    /*
     * Print them (sorted)
     */
    System.out.println("Sorted: "+names);
  }
  
  

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
