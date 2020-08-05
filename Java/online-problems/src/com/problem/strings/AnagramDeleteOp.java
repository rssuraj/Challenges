package com.problem.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Find out the total number of characters to be deleted from 
 * the 2 given string values to make them anagrams
 * 
 * @author rssuraj
 *
 */
public class AnagramDeleteOp {

	public static void main(String[] args) {
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			Integer testCases = Integer.parseInt(br.readLine());

	        while(testCases > 0) {
	            String a = br.readLine();
	            String b = br.readLine();

	            int count[] = new int[26];
	            Integer deletions = 0;

	            for(int i = 0; i < a.length(); i++) {
	                count[a.charAt(i) - 'a']++;
	            }

	            for(int i = 0; i < b.length(); i++) {
	                count[b.charAt(i) - 'a']--;
	            }

	            for(int i = 0; i < count.length; i++) {
	                deletions += Math.abs(count[i]);
	            }
	            
	            System.out.println(deletions);

	            testCases--;
	        }
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
