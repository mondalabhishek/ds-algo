package com.practice.test.array;

import java.util.Arrays;


//TODO Pending!
public class MaximumSubarray {

	public static void main(String[] args) {
	
		int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
		
		
		if(nums.length==1) {
			System.out.println(Arrays.toString(nums));
		}else {
			int sum = Arrays.stream(nums).sum();
			int startIdx =0;
			int lastIdx=nums.length-1;
			
			
			
		}
		
	}

}
