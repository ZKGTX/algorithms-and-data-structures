package com.zerokikr.tutorial.arrays;

public class Factorial {

	public static int iterativeFactorial(int number) {
		if (number == 0) {
			return 1;
		}

		int factorial = 1;

		for (int i = 1; i <= number; i++) {
			factorial = factorial * i;
		}
		return factorial;
	}

	// 1! = 1 * 0! = 1
	// 2! = 2 * 1 = 2 * 1!
	// 3! = 3 * 2 * 1 = 3 * 2!
	// 4! = 4 * 3 * 2 * 1 = 4 * 3!
	// 5! = 5 * 4 * 3 * 2 * 1 = 5 * 4!

	// n! = n * (n - 1)!

	public static int recursiveFactorial(int number) {

		if (number == 0) {
			return 1;
		}

		return number * recursiveFactorial(number - 1); // at this point recursiveFctorial (number) gets pushed to call
														// stack and recursiveFactorial(number - 1) is called
	}

}
