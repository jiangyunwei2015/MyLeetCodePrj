package Array;

import java.util.HashMap;
import java.util.HashSet;

/*
 * Given an array of integers that is already sorted in ascending order, find two 
 * numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up 
to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you 
may not use the same element twice.
Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * 
 * 
 * */
public class TwoSumIIInputarrayissorted {
	public int[] twoSum(int[] numbers, int target) {
       HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
       int[] result = new int[2];
       for(int i = 0;i<numbers.length;i++)
       {
    	   
    	   if(map.containsKey(target - numbers[i]))
    	   {
    		   return new int[] {map.get(target - numbers[i])+1,i+1};   		   
    	   }
    	   map.put(numbers[i], i);
    	   
       }
       return result;
    }
}


/*
 * Better solution from web: using the property that 1) the array is sorted in ascending order,
 * 2) there is only one solution
 * use two pointer that one starts from beginning and one starts from the end
 * 
 *   public int[] twoSum(int[] numbers, int target) {
		int l = 0, r = numbers.length - 1;
		while (l < r) {
			int sum = numbers[l] + numbers[r];
			if (sum == target) {
				return new int[] { l + 1, r + 1 };
			} else if (sum < target) {
				l++;
			} else {
				r--;
			}
		}
		return null;
    }
 * 
 * */
