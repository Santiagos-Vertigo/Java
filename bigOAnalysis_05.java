package uno;

public class bigOAnalysis_05 {


	public static void main(String[] args) {
		int n1 = 1000000;
		int n2 = 1000;
		int n3 = 10;
		int n4 = -1000;
		int n5 = -1000000;
		System.out.println();
		System.out.println();
		System.out.println("                          RUN TIME RESULT");
		System.out.println("________________________________________________________________________________");
		System.out.format("%-25s %1s %20s %20s", " N/Method ", "  Method 1 ", "  Method 2", "      Method 3" + "\n");
		calculate(n1);
		calculate(n2);
		calculate(n3);
		calculate(n4);
		calculate(n5);
	}
	//This method converts the numeric result into nanoTime for methods 1, 2 and 3.
	private static void calculate(long n) {
		long estimatedTime1 = 0;
		String returnVal = "";
		try {
			long startTime1 = System.nanoTime();
			Method1(n);
			returnVal = (System.nanoTime() - startTime1) + "";

		} catch (java.lang.StackOverflowError sto) {
			returnVal = "ERROR";
		}

		// metodo 2
		long estimatedTime2 = 0;
		long startTime2 = System.nanoTime();
		Method2(n);
		estimatedTime2 = System.nanoTime() - startTime2;

		// metodo 3
		long estimatedTime3 = 0;
		long startTime3 = System.nanoTime();
		Method3(n);
		estimatedTime3 = System.nanoTime() - startTime3;

		System.out.format("%-25s %1s %25s %25s", n, returnVal, estimatedTime2, estimatedTime3 + "\n");
	}
// Method 1:A recursive method with parameter N that used recursion to compute
// the Nth element in the series
	static long Method1(long n) {
		n = Math.abs(n);
		if (n == 1) // Base Case
			return 1;
		else
			return (n * n) + Method1(n - 1); // Reduction
	}

// Method 2:A brute method with parameter N that uses a loop to compute the Nth
// element in the series.
	static long Method2(long n) {
//		n = Math.abs(n);
		long result = 0;
		for (int i = 1; i <= n; i++) {
			result += (i * i);
		}
		return result;
	}

// Method 3:A mathematical method with parameter N that uses mathematic summation
// formula to compute the Nth element in the series.
	static long Method3(long n) {
		n = Math.abs(n);
		return (n * (n + 1) * (2 * n + 1)) / 6;
	}
}