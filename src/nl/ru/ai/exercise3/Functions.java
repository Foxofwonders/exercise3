package nl.ru.ai.exercise3;

/**
 * @author Denise van Baalen (s4708237)
 * @author Anna Gansen (s4753755)
 */

public class Functions {
	
	public static void main(String[] args)
	  {
		int[] a = {2,4,5,1};
		System.out.println("Sum of 4: " + sum(4));
		System.out.println("2 to the power of 4: " + power(2,4));
		System.out.println("Minimum element of a up to the 4th element: " + minimum(a,4));
		System.out.println("Greatest Common Divisor of 100 and 110: " + gcd(100,110));
	  }
	
	/**
	 * Computes the Sum of n+(n-1)+(n-2)+...+0
	 * @param n
	 * @return sum
	 */
	private static int sum (int n) 
	{
		assert n>=0: "Invalid value";
		if(n==0)
			return n;
		else
			return n+sum(n-1);
	}
	/**
	 * Computes x^n
	 * @param x
	 * @param n
	 * @return x^n
	 */
	private static double power (double x, int n) 
	{
		assert n>=0: "Invalid value for n";
		if(n==0)
			return 1;
		else
			return x*power(x,n-1);
	}
	/**
	 * Returns the smallest element of the array up to the element n.
	 * @param a
	 * @param n
	 * @return smallest element
	 */
	private static int minimum (int[] a,int n) 
	{
		assert n>a.length: "Invalid Value for n";
		if(n==1)
			return a[0];
		else
			return Math.min(a[n-1],minimum(a,n-1));
	}
	/**
	 * Return greatest common divisor
	 * @param n
	 * @param m
	 * @return gcd
	 */
	private static int gcd (int n,int m) 
	{
		assert n>0 && m>=0: "Invalid value";
		if(m==0)
			return n;
		if (n<m)
			return gcd(m,n);
		else
			return gcd(m,n%m);
	}

}
