package com.practice.test.array;

import java.util.Arrays;

/**
 * Merge two sorted array
 * 
 * @author Abhishek Mondal
 *
 */
public class MergeSortedArray {

	public static void main(String[] args) {

		try {
			int arr1[] = { 1, 5, 7, 8, 10, 12 };
			int arr2[] = { 2, 5, 6, 9, 11 };

			int idx1 = 0, idx2 = 0, midx = 0;

			// create mergedArray length of arr1 arr2
			int[] mergedArray = new int[arr1.length + arr2.length];

			// checking elements of both array and adding the least element first in the
			// merged array.
			while (idx1 < arr1.length && idx2 < arr2.length) {
				if (arr1[idx1] < arr2[idx2]) {
					mergedArray[midx] = arr1[idx1];
					idx1++;
				} else {
					mergedArray[midx] = arr2[idx2];
					idx2++;
				}
				midx++;
			}

			// adding remaining elements of arr1/arr2 to merged array if any
			
			//arr1
			while (idx1 < arr1.length) {
				mergedArray[midx] = arr1[idx1];
				idx1++;
				midx++;
			}

			//arr2
			while (idx2 < arr2.length) {
				mergedArray[midx] = arr2[idx2];
				idx2++;
				midx++;
			}
			System.out.println("Merged array::" + Arrays.toString(mergedArray));

		} catch (Exception e) {
			System.err.println("An exception occured");
		}

	}

}
