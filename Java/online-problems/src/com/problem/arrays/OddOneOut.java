package com.problem.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * LEETCODE Problem
 * 
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.

 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 * Example 1:
	Input: [2,2,1]
	Output: 1

 * Example 2:
	Input: [4,1,2,1,2]
	Output: 4

 * @author rssuraj
 *
 */
public class OddOneOut {

	public static void main(String[] args) {
		
		int[] arr1 = {2, 2, 1};
		System.out.println("Space Utilizing Solution = " + singleNumberWithMap(arr1));
		
		int[] arr2 = {4, 1, 2, 1, 2};
		System.out.println("Efficient Solution = " + singleNumber(arr2));
	}
	
	// Space Utilizing Solution
	private static int singleNumberWithMap(int[] nums) {
        
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
        for(int num : nums) {
        	Integer count = map.get(num);
            if(count == null)
            {
            	count = 0;
            }
            
            map.put(num, count + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
        	if(entry.getValue() == 1)
        		return entry.getKey();
        }
        
        return -1;
    }
	
	// Efficient Solution
	private static int singleNumber(int[] nums) {
        
        int res = 0;
        for(int num : nums) {
            res ^= num;
        }
        return res;
    }

}
