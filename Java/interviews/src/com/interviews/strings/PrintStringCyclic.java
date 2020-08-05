package com.interviews.strings;

/**
 * Rotate a string to right till end and print it after every rotation
 * 
 * @author rssuraj
 *
 */
public class PrintStringCyclic {
	
	
	public static void main(String[] args) {
		String input = "Welcome";
		
//		for(int i = 0; i < input.length(); i++)
//		{
//			for(int j = i; j < input.length(); j++)
//			{
//				System.out.print(input.charAt(j));
//			}
//			
//			for(int j = 0; j < i; j++)
//			{
//				System.out.print(input.charAt(j));
//			}
//			
//			System.out.println();
//		}
		
		for(int i = 0; i < input.length(); i++)
		{
			String temp = input.substring(i);
			if(i > 0)
				temp += input.substring(0, i);
			System.out.println(temp);
		}
		
	}

}
