package com.problem.numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * LEETCODE
 * 
 * Write an algorithm to determine if a number n is "happy".

 * A happy number is a number defined by the following process: 
   - Starting with any positive integer, replace the number by the sum of the squares of its digits, 
   - and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
   - Those numbers for which this process ends in 1 are happy numbers.
 * Return True if n is a happy number, and False if not.

 * Example: 

	Input: 19
	Output: true
	Explanation: 
	12 + 92 = 82
	82 + 22 = 68
	62 + 82 = 100
	12 + 02 + 02 = 1

 * @author rssuraj
 *
 */
public class HappyNumber {

	public static void main(String[] args) {
		
		int number = 19;
		System.out.println("Number " + number + " is happy? = " + isHappy(number));
	}
	
	public static boolean isHappy(int n) {
        List<Integer> list = new ArrayList<Integer>();
        Integer res = 0;
        while(!res.equals(1))
        {
            res = getSquareSum(n);
            System.out.println(res);
            if(list.contains(res)) {
                return false;
            }
            list.add(res);
            n = res;
            System.out.println(list.toString());
        }
        return true;
    }
    
    public static Integer getSquareSum(int n) {
        Integer res = 0;
        while((n / 10) > 0) {
            int mod = n % 10;
            System.out.print(mod + " ");
            res += mod * mod;
            n = n / 10;
        }
        System.out.print(n);
        res += n * n;
        System.out.println();
        return res;
    }

}
