package com.practice.test.hashtable;

//2,5,0,5,2,0,1
//Improve o(n^2) nested for loop logic too return 5 instead of 2
public class FirstRecurringCharacter {
	
	private static Integer getFirstRecurringCharacter(int[] nums) {
		Integer val = null;
		//track the index for Last recurring character
		//initialize with =-1 at start
		int matchedItemLastIndex=-1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					/*when first matched item set the index
					OR 
					when next recurring characters matching index is less that previous one
					the update the matched item and it's syntax
					*/
					if(matchedItemLastIndex==-1 || (j<matchedItemLastIndex)) {
						matchedItemLastIndex = j;
						val = nums[i];
					}					
					break;
				}
			}
		}

		return val;
	}
	
	
	/**
	 * Hash table solution
	 * @param nums
	 * @return
	 */
	/*private static Integer getFirstRecurringCharacter(int[] nums) {
		Integer val = null;
		Hashtable<Integer, Integer> numTable = new Hashtable<>();
		for (int i = 0; i < nums.length; i++) {
			if(numTable.containsKey(nums[i])) {
				return nums[i];
			}else {
				numTable.put(nums[i], i);
			}
		}

		return val;
	}
	*/
	public static void main(String[] args) {

		int[] nums = { 2,5,0,5,2,0,1 };

		System.out.println(getFirstRecurringCharacter(nums));
	}

}
