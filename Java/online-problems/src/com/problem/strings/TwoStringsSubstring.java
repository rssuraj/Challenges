package com.problem.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * HACKERRANK
 * 
 * Given two strings, determine if they share a common substring. A substring may be as small as one character.
 * For example, the words "a", "and", "art" share the common substring a.
 * The words "be" and "cat" do not share a substring.

 * Function Description
 	- Complete the function twoStrings in the editor below. It should return a string, either YES or NO based on whether the strings share a common substring.
 	- twoStrings has the following parameter(s):
 		* s1, s2: two strings to analyze.

 * Input Format
 	- The first line contains a single integer p, the number of test cases.
 	- The following p pairs of lines are as follows:
 		* The first line contains string s1.
 		* The second line contains string s2.

 * Constraints
 	- s1 and s2 consist of characters in the range ascii[a-z].
 	- 1 <= p <= 10
 	- 1 <= |s1|, |s2| <= 10^5

 * Output Format
 	- For each pair of strings, return YES or NO.

 * Sample Input

		2
		hello
		world
		hi
		world

 * Sample Output

		YES
		NO

 * Explanation
 	- We have p = 2 pairs to check:
 		* s1 = "hello", s2 = "world". The substrings "o" and "l" are common to both strings.
 		* s1 = "hi", s2 = "world". s1 and s2 share no common substrings.
 * 
 * @author rssuraj
 *
 */

public class TwoStringsSubstring {

	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "world";
		
		System.out.println("Contains substring = " + twoStrings(s1, s2));
	}
	
	private static String twoStrings(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), 1);
        }

        for(int i = 0; i < s2.length(); i++) {
            if(map.containsKey(s2.charAt(i))) {
                return "YES";
            }
        }

        return "NO";
    }

}
