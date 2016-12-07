package nl.ru.ai.exercise3;

/**
 * @author Denise van Baalen (s4708237)
 * @author Anna Gansen (s4753755)
 */

import java.util.Scanner;

public class Fibonacci 
{
	public static void main(String[] args)
	  {
		Scanner sc = new Scanner(System.in);
		boolean stop=false;
		while(!stop)
		{
		System.out.println("Which Function do you want to use?");
		System.out.println("(0) Regular Fib-Function");
		System.out.println("(1) Improved Fib-Function with Memory-Array");
		System.out.println("(2) Efficient Fib-Function with O(1) Space Complexity");
		System.out.println("(3) Stop");
		System.out.println("");
		System.out.println("Insert 0,1,2 or 3 and the n'th position up to which you want to know the sequence.");
		int choice = sc.nextInt();
		int n = sc.nextInt();
		if(choice==3)
		{
			stop=true;
		}else
		{
		printFibs(choice,n);
		}
		}
		sc.close();

	  }
	/**
	 * Prints the Fibonacci sequence up to the n'th position.
	 * @param choice
	 * @param n
	 */
	static void printFibs(int choice, int n)
	{
		assert choice==0||choice==1||choice==2:"Wrong input for the Choice";
		assert n>=0:"Wrong input for the n";
		if(choice==0)
		{
			for(int i=0; i<=n; i++)
			  {
				  System.out.println("n " + i + " = " + fib(i));
			  }
		}
		if(choice==1)
		{
			for(int i=0; i<=n; i++)
			  {
				  System.out.println("n " + i + " = " + improvedFib(i));
			  }
		}
		if(choice==2)
		{
			for(int i=0; i<=n; i++)
			  {
				  System.out.println("n " + i + " = " + efficientFib(i));
			  }
		}
	}

	  /**
	   * Returns the Fibonacci number at the n'th position of the Fibonacci sequence.
	   * @param n
	   * @return Fibonacci number at the n'th position in the sequence.
	   */
	  private static double fib(int n)
	  {
	    assert n>=0 : "n should be larger than 0";
	    if(n<2)
	      return 1;
	    else
	      return fib(n-1)+fib(n-2);
	  }
	  
	  /**
	   * Returns the Fibonacci number at the n'th position of the Fibonacci sequence.
	   * "Help-function" to create array and catch n=0 or n=1
	   * @param n
	   * @return the n'th Fibonacci number
	   */
	  private static double improvedFib(int n)
	  {
	    assert n>=0 : "invalid n";
	    double[] memo=new double[n];
	    if(n==0||n==1)
	      return 1;
	    else
	      return improvedFib(n,0,memo);
	  }
	  /**
	   * Finds the Fibonacci number at the n'th position using an array as a memory for found numbers.
	   * @param n
	   * @param i
	   * @param foundValues
	   * @return the n'th Fibonacci number
	   */
	  private static double improvedFib(int n, int i, double[] memo)
	  {
	    assert n>=0 : "n should be larger than 0";
	    assert n==memo.length : "n should be the length of the array";
	    assert i<=n&&i>=0 : "invalid position for i";
	    if(i==n)
	      return memo[i-1]+memo[i-2];
	    else if(i<2)
	    {
	    	memo[i]=1;
	      return improvedFib(n,i+1,memo);
	    } else
	    {
	    	memo[i]=memo[i-1]+memo[i-2];
	      return improvedFib(n,i+1,memo);
	    }
	  }

	  /**
	   * Returns the Fibonacci number at the n'th position of the Fibonacci sequence.
	   * "Help-function" to create array and catch n=0 or n=1
	   * @param n
	   * @return the n'th Fibonacci number
	   */
	  private static double efficientFib(int n)
	  {
	    assert n>=0 : "invalid n";
	    if(n==0||n==1)
	      return 1;
	    else
	      return efficientFib(n,0,0,0);
	  }
	  /**
	   * Returns the Fibonacci number at the n'th position with run-time complexity O(n) and space complexity O(1).
	   * @param n
	   * @param i
	   * @param previous1 (value at i-2)
	   * @param previous2 (value at i-1)
	   * @return the n'th Fibonacci number
	   */
	  private static double efficientFib(int n, int i, double previous1, double previous2)
	  {
	    assert n>=0 : "n should be larger than 0";
	    assert i<=n&&i>=0 : "invalid position for i";
	    if(i==n)
	      return previous1+previous2;
	    else if(i<2)
	    {
	      return efficientFib(n,2,1,1);
	    } else
	    {
	      return efficientFib(n,i+1,previous2,previous1+previous2);
	    }
	  }

}
