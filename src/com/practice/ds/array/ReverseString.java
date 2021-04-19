package com.practice.ds.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Reverse a Given input String
 * 
 * @author Abhishek Mondal
 *
 */
public class ReverseString {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {

			System.out.println("Enter your string::");
			String input = br.readLine();
			if (input.length() == 0) {
				System.out.println("None entered!");
			} else if (input.length() == 1) {
				System.out.println("Result:: " + input);
			}else {
				int inputLength = input.length() - 1;
	
				char output[] = new char[input.length()];
				for (int i = inputLength; i >= 0; i--) {
					output[i] = input.charAt(inputLength - i);
				}
				System.out.println("Result:: " + String.valueOf(output));
			}
		} catch (IOException e) {
			System.err.println("An exception occured");
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
