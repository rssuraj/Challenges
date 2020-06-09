package com.dailycodingproblem.google.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem Statement ------
 * 
 * 	Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 *
 *	For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 *
 *	Bonus: Can you do this in one pass?
 * 
 * @author rssuraj
 *
 */

public class TwoNumbersSumToK {
	
	/**
	 * This is an extended solution to find triplets which sum up to the number k
	 */
	public static boolean hasATriplet(int[] input, int k) {
		
		for(int i = 0; i < input.length; i++ ) {
			Set<Integer> set = new HashSet<Integer>();
			
			if(input[i] < k) {
				
				int subValue = k - input[i]; 
				for(int j = i + 1; j < input.length; j++ ) {
					
					if(input[j] < subValue) {
						
						int subValue2 = subValue - input[j];
						if(set.contains(subValue2)) {
							
							System.out.printf("The triplet is %d, %d, %d", input[i], input[j], subValue2);
							System.out.println();
							return true;
						}
						
						set.add(input[j]);
					}
				}
			}
		}
		return false;
	}
	
	public static boolean hasAPair(int[] input, int k) {
		Set<Integer> set = new HashSet<Integer>();
		
		for(int num : input) {
			if(num < k) {
				
				int subValue = k - num;
				if(set.contains(subValue)) {
					
					System.out.printf("The pair is %d, %d", num, subValue);
					System.out.println();
					return true;
				}
				
				set.add(num);
			}
		}
		
		return false;
	}

	public static void main(String[] args) {

		int[] input = new int[] {10, 15, 3, 7};
		
		System.out.println("Has a Pair? " + hasAPair(input, 17));
		System.out.println();
		
		System.out.println("Has a Pair? " + hasAPair(input, 20));
		System.out.println();
		
		System.out.println("Has a Triplet? " + hasATriplet(input, 20));
		System.out.println();
		
		System.out.println("Has a Triplet? " + hasATriplet(input, 25));
		System.out.println();
		
		System.out.println("Has a Triplet? " + hasATriplet(input, 30));
		System.out.println();

	}

}
