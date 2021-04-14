package com.practice.test;

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
		Map<Integer, Boolean> sumPartner = new HashMap<>();
		for(Integer value: input) {
			if(sumPartner.containsKey(sum-value)) {
				//System.out.println(value +" "+(sum-value));
				return true;				
			}else {
				sumPartner.put((value),true);
			}
		}		
		
		return false;
	};

	public static void main(String[] args) {
		
		try {
			Integer input[]= {1,5,6,7,9};
			Integer targetSum = 7;
			
			System.out.println("Did we found matching pair sum? - "+doesSumPairExist.test(input, targetSum));
			
			
		} catch (Exception e) {
			System.err.println("An error occured:: " +e.getMessage());
		}
		
		
	
	}
	
	

}
