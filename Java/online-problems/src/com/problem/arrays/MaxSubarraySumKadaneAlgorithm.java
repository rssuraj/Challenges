package com.problem.arrays;

/**
 * LEETCODE
 * 
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

 * Example:

 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.

 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * 
 * @author rssuraj
 *
 */

public class MaxSubarraySumKadaneAlgorithm {

	public static void main(String[] args) {
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println("Max Sum is = " + maxSubArray(nums));
	}

	// Kadane's Algorithm
	private static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curMax = 0;
        
        for(int i = 0; i < nums.length; i++) {
            curMax += nums[i];
            
            if(max < curMax) {
                max = curMax;
            }
            
            if(curMax < 0) {
                curMax = 0;
            }
        }
        
        return max;
    }
	
	//TODO: Divide and Conquer Approach
	
}
