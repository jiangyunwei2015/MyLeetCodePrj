package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Given a non-empty array of non-negative integers nums, the degree of this array 
 * is defined as the maximum frequency of any one of its elements.

	Your task is to find the smallest possible length of a (contiguous) subarray of nums, 
	that has the same degree as nums.
	
	Example 1:
	Input: [1, 2, 2, 3, 1]
	Output: 2
	Explanation: 
	The input array has a degree of 2 because both elements 1 and 2 appear twice.
	Of the subarrays that have the same degree:
	[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
	The shortest length is 2. So return 2.
	Example 2:
	Input: [1,2,2,3,1,4,2]
	Output: 6
	
	Note:
	nums.length will be between 1 and 50,000.
	nums[i] will be an integer between 0 and 49,999.
 * 
 * */
public class DegreeofanArray {
	public int findShortestSubArray(int[] nums) {
        //Using hashmap<integer,arraylist<Integer>> by store the numbers and indexes
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
		//first just store in map
		for(int i = 0;i<nums.length;i++)
		{
			if(map.containsKey(nums[i]))
			{
				map.get(nums[i]).add(i);
			}
			else
			{
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(nums[i], list);
			}
		}
		//find the subarray with the same frequency and also the smallest length
		Iterator it = map.entrySet().iterator();
		int degree = 0;
		int smallestLen = 0;
		while(it.hasNext())
		{
			Entry pair = (Entry) it.next();
			ArrayList<Integer> tmp = ((ArrayList)pair.getValue());
			int size = tmp.size();
			int tmpLen = tmp.get(size-1)-tmp.get(0)+1;
			if(degree < size)
			{
				//change degree to this 
				degree = size;
				smallestLen = tmpLen;
			}
			else if(degree == size)
			{
				//check the length
				//max = (a > b) ? a : b;
				smallestLen = (smallestLen > tmpLen) ?  tmpLen : smallestLen;
			}
		}
		return smallestLen;
    }

}
