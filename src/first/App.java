package first;

/**
 * @author AntonGarelykh
 */

/*
 * This is the first task from the test paper. 
 * This program calculates the number of  correct
 *  bracket expressions for N specified by user.
 */
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter N value: ");
		int n = scn.nextInt();
		System.out.println("Number of correct bracket expressions for N = " + n
				+ " is " + calculate(n) + ".");
	}

	/*
	 * Method returns number of correct bracket expressions. Calculation
	 * performs by means of defining a sequence of natural numbers. This
	 * sequence is called Catalan numbers. Method works using recursion.
	 */
	private static int calculate(int n) {
		if (n == 0)
			return 1;
		else {
			int count = 0;
			for (int i = 0; i < n; i++) {
				count += calculate(i) * calculate(n - 1 - i);
			}
			return count;
		}
	}

}
