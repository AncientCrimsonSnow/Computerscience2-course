
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;


public class BigOH {
	static BigInteger n;
	static int sum = 1;
	public static void main(String[] args) {
		
		/*for(int i = 10;i<=100000;i*=10) {
			Fragment1(i);	
		}
		

		for(int i = 10;i<=100000;i*=10) {
			System.out.println("O(" + i + ") = " +  GetBigOH_isPrime(i).toString());
		}
		
		//20 Bits numbers:
		BitPrime(20);
		//40 Bits numbers:
		BitPrime(40);
		
		for(int i = 10;i<=10000;i++) {
			System.out.println(sequence(i));	
		}
		/*
		 */
		boolean[] Primes = Eratosthenes(120);		
		for(int i = 2;i<Primes.length;i++) {
			if(Primes[i]) {
				System.out.println(i);			
			}
		}
		System.out.println("O(120) = " + sum);
	}
	
	//https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
	public static boolean[] Eratosthenes (int n){
		sum = 1;
		if(n<1) {
			return null;
		}
		//0 = 2
		boolean[] Primes = new boolean[n+1];
		Arrays.fill(Primes, true);
		for(int i = 2;i<Math.sqrt((double)n);i++){
			sum++;
			if(Primes[i]) {
				for(int j = (int) Math.pow(i, 2), k = 1; j<n; k++, j = (int) Math.pow(i, 2)+k*i) {
					Primes[j] = false;
					sum++;
				}
			}
		}		
		return Primes;
	}
	
	public static int sequence(int n) {	
		int sum = 0;
	    int i = n;
	    while (i > 1) {
	    	if (i%2 == 0) {  
	    		i = i/2;
	         } 
	    	else {  
	    		i = 3*i + 1;
	    	}
	    	sum++;
	    }
	    return sum;	
	}
	
	public static void BitPrime (int Bits) {
		
		BigInteger total0 = BigInteger.ONE;
		
		for(int i = 0; i<100;i++) {
			BigInteger Twenty_Bits = new BigInteger(Bits, new Random());
			sum = 1;
			isPrime(Twenty_Bits);
			total0 = total0.add(new BigInteger(Integer.toString(sum)));
		}
		System.out.println("O(100 (" + Bits + " Bit Numbers) = " +  total0.toString());
	}
	
	public static BigInteger GetBigOH_isPrime(int n) {
				
		BigInteger N = new BigInteger(Integer.toString(n));
		
		BigInteger total0 = BigInteger.ONE;

		for(BigInteger Index = BigInteger.ONE ; Index.compareTo(N) == -1; Index = Index.add(BigInteger.ONE)){
			sum = 1;
			if(isPrime(Index)) {}									
			total0 = total0.add(new BigInteger(Integer.toString(sum)));			
		}

		return total0;
	}
	
	//https://stackoverflow.com/questions/2385909/what-would-be-the-fastest-method-to-test-for-primality-in-java
	public static boolean isPrime (BigInteger n) {
			
		BigInteger THREE = BigInteger.TWO.add(BigInteger.ONE);
		
		if(0>n.compareTo(BigInteger.TWO))

			return false;
					 
		if(0 == n.compareTo(BigInteger.TWO) || 0 == n.compareTo(THREE))

			return true;
									 
		//https://www.tutorialspoint.com/java/math/biginteger_mod.htm 
		boolean first = n.mod(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0;
		boolean second = n.mod(THREE).compareTo(BigInteger.ZERO) == 0;
		if(first || second)
			return false;
							
		//https://www.geeksforgeeks.org/biginteger-sqrt-method-in-java/
		BigInteger sqrtN = n.sqrt().add(BigInteger.ONE);
		
		BigInteger SIX = new BigInteger("6");
		BigInteger negativOne = new BigInteger("-1");
		
		for(BigInteger i = SIX; sqrtN.compareTo(i) != -1; i = i.add(SIX)) {
			sum++;
			first = n.mod(SIX.add(negativOne)).compareTo(BigInteger.ZERO) == 0;
			second = n.mod(SIX.add(BigInteger.ONE)).compareTo(BigInteger.ZERO) == 0;
			if(first||second ) {
				return false;
			}				
		}		
		return true;
	}
	
		
	public static void Fragment1(int n) {
		BigInteger sum = BigInteger.ZERO;
		for ( int i = 0; i < n; i ++)
			sum = sum.add(BigInteger.ONE);
		System.out.println("#1 " + n + ":" + sum.toString());
		Fragment2(n);
	}
	public static void Fragment2(int n) {
		BigInteger sum = BigInteger.ZERO;
		for ( int i = 0; i < n; i ++)
		    for ( int j = 0; j < n; j ++)
		    	sum = sum.add(BigInteger.ONE);
		System.out.println("#2 " + n + ":" + sum);
		Fragment3(n);
	}
	public static void Fragment3(int n) {
		BigInteger sum = BigInteger.ZERO;
		for ( int i = 0; i < n; i ++)
		    for ( int j = i; j < n; j ++)
		    	sum = sum.add(BigInteger.ONE);
		System.out.println("#3 " + n + ":" + sum);
		Fragment4(n);
	}
	public static void Fragment4(int n) {
		BigInteger sum = BigInteger.ZERO;
		for ( int i = 0; i < n; i ++)
			sum = sum.add(BigInteger.ONE);
		    for ( int j = 0; j < n; j ++)
		    	sum.add(BigInteger.ONE);
		System.out.println("#4 " + n + ":" + sum);
		Fragment5(n);
	}
	public static void Fragment5(int n) {
		BigInteger sum = BigInteger.ZERO;
		for ( int i = 0; i < n; i ++)
		    for ( int j = 0; j < n*n; j ++)
		    	sum = sum.add(BigInteger.ONE);
		System.out.println("#5 " + n + ":" + sum);
		Fragment6(n);
	}
	public static void Fragment6(int n) {
		BigInteger sum = BigInteger.ZERO;
		for ( int i = 0; i < n; i ++)
		    for ( int j = 0; j < i; j ++)
		    	sum = sum.add(BigInteger.ONE);
		System.out.println("#6 " + n + ":" + sum);
		Fragment7(n);
	}
	public static void Fragment7(int n) {
		BigInteger sum = BigInteger.ZERO;
		for ( int i = 1; i < n; i ++)
		    for ( int j = 0; j < n*n; j ++)
		        if (j % i == 0)
		           for (int k = 0; k < j; k++)
		        	   sum = sum.add(BigInteger.ONE);
		System.out.println("#7 " + n + ":" + sum);
		Fragment8(n);
	}
	public static void Fragment8(int n) {
		BigInteger sum = BigInteger.ZERO;
		int i = n;
		while (i > 1) {
		    i = i / 2;
		    sum = sum.add(BigInteger.ONE); 
		}
		System.out.println("#8 " + n + ":" + sum);	
	}
}
