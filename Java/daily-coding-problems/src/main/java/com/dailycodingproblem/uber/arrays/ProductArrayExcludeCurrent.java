package com.dailycodingproblem.uber.arrays;

/**
 * Problem Statement ------
 * 
 * 	Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
 *
 *	For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 *
 *	Follow-up: what if you can't use division?
 * 
 * @author sramanuj
 *
 */

public class ProductArrayExcludeCurrent {

	/**
	 * This solution is with division
	 * 
	 */
	private static void printProductExcludeCurrent(int[] input) {
		
		int prod = 1;
		for(int num : input) {
			prod *= num;
		}
		
		int[] result = new int[input.length];
		for(int i = 0; i < input.length; i++ ) {
			result[i] = prod / input[i];
		}
		
		for(int res : result) {
			System.out.print(res + " ");
		}		
	}
	
	public static void main(String[] args) {
		
		printProductExcludeCurrent(new int[] {1, 2, 3, 4, 5});
		System.out.println();
		
		printProductExcludeCurrent(new int[] {3, 2, 1});
		System.out.println();

	}
}
