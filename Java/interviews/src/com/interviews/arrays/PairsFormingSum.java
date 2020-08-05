package com.interviews.arrays;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find all pairs summing up to the given "sum" value
 * 
 * @author rssuraj
 *
 */
public class PairsFormingSum {
	
	public static void main(String[] args) {
		
		int arr1[] = new int[] {4, 8, 1, 16, 5, 6};
		int arr2[] = new int[] {19, 8, 9, 3, 25, 13};
		int sum = 10;
		
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		
		for(int i = 0; i < arr1.length; i++)
		{
			if(!map.containsKey(arr1[i]))
				map.put(arr1[i], new ArrayList<>());
			map.get(arr1[i]).add(i);
		}
		
		for(int i = 0; i < arr2.length; i++)
		{
			if(arr2[i] < sum)
			{
				int diff = sum - arr2[i];
				if(map.containsKey(diff))
				{
					System.out.println("Array2 index = " + i + " pairs with Array1 indices " + map.get(diff).toString());
				}
			}
		}
		
		try {
            System.out.printf("1");
            throw(new Exception());
        }
        catch(IOException e) {
            System.out.printf("2");
        }
        catch(Exception e) {
            System.out.printf("3");
        }
        finally {
            System.out.printf("4");
        }
	}

}
