package com.practice.test.array;

import java.util.Arrays;

public class MoveZeros {
	public static void main(String[] args) {
		int input[] = { 0, 1, 3, 0, 0, 5, 7, 8, 0, 9, 0, 0, 5, 0 };
		// Index to keep track of index of last found Non-zero item
		int lastNonZeroIdx = -1;

		/*
		 * Loop through array, check for Non Zero items Then put all non-zero items one
		 * after another and replace their original position with ZERO.
		 */
		for (int i = 0; i < input.length; i++) {

			// First instance of non-zero item
			if (input[i] > 0 && lastNonZeroIdx == -1) {
				// if first item is non-zero, then set the lastNonZeroIdx to ZERO
				if (i == 0) {
					lastNonZeroIdx = 0;
				} else {
					// else move the non-zero items to first index and replace it's position with zero
					input[0] = input[i];
					input[i] = 0;
					lastNonZeroIdx = i - 1;
				}

				/*
				 * For rest of the non-zero items, put them one after another and replace their
				 * original position with Zero
				 */
			} else if (input[i] > 0 && lastNonZeroIdx >= 0) {
				input[lastNonZeroIdx + 1] = input[i];
				lastNonZeroIdx = lastNonZeroIdx + 1;
				input[i] = 0;
			}

		}

		System.out.println(Arrays.toString(input));
	}

}
