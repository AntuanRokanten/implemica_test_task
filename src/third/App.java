package third;

/**
 * @author AntonGarelykh
 */

/*
 *  This is the third task from the test paper.
 *  This program finds the sum of the digits in the number 100!.
 */
import java.math.BigInteger;

public class App {

	public static void main(String[] args) {
		BigInteger x = factorial(100); // we calculate the value of 100! at
										// first. Since it's going to be an
										// enormously big value, we use
										// BigInteger class for creating
										// objects.
		System.out.println("answer: " + sumOfDigits(x));
	}

	/*
	 * sample method for calculating factorial of variable
	 */
	public static BigInteger factorial(int number) {
		BigInteger result = BigInteger.valueOf(1);
		for (int i = 1; i <= number; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}

	/*
	 * this method returns an actual sum of digits of variable
	 */
	public static BigInteger sumOfDigits(BigInteger number) {
		BigInteger result = BigInteger.valueOf(0); // we assign result to zero
													// at the outset.
		while (!number.equals(BigInteger.ZERO)) { // loop performs until number contain unadded digits
			result = result.add(number.mod(BigInteger.valueOf(10))); // adding
																		// remainder
																		// of
																		// division
																		// by 10
																		// to
																		// "result"
																		// variable
			number = number.divide(BigInteger.valueOf(10)); // here we cutting
															// off the last digit
															// of number as it's
															// been already
															// added to the
															// result
		}
		return result;
	}
}
