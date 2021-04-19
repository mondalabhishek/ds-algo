package com.practice.ds.array;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;

/**
 * This is a Solution to Google's interview problem
 * -https://www.youtube.com/watch?v=XKu_SEDAykw
 * 
 * @author Abhishek Mondal
 *
 */
public class FindSum {
	
	private static BiPredicate<Integer[], Integer> doesSumPairExist=(input, sum)->{
		Map<Integer, Integer> sumPartner = new HashMap<>();
		for(int i=0;i<input.length;i++) {
			int value=input[i];
			if(sumPartner.containsKey(sum-value)) {
				System.out.println("Indices are: ["+sumPartner.get(sum-value)+", "+i+"]");
				return true;				
			}else {
				sumPartner.put((value),i);
			}
		}		
		
		return false;
	};

	public static void main(String[] args) {
		
		try {
			Integer input[]= {2,7,11,15,9};
			Integer targetSum = 9;
			
			System.out.println("Did we found matching pair sum? - "+doesSumPairExist.test(input, targetSum));
			
			
		} catch (Exception e) {
			System.err.println("An error occured:: " +e.getMessage());
		}
		
		
	
	}
	
	

}
