/*
	1. Write a function called maxSubarraySum which accepts an array of integers and a number called n.
	2. The function should calculate the maximum sum of n consecutive elements in the array.
	
	Input1: [1, 2, 5, 2, 8, 1, 5], 2
	Output1: 10
	
	Input2: [1, 2, 5, 2, 5, 1, 5], 4
	Output2: 17
	
	Input3: [4, 2, 1, 6], 1
	Output3: 6
	
	Input4: [4, 2, 1, 6, 2], 4
	Output4: 13
	
	Input5: [], 4
	Output5: null
*/

// Naive Solution
// Time: O(N^2)
// Space: O(1)
function maxSubarraySum(arr, num) {
	if( num > arr.length) {
		return null;
	}
	
	let max = -Infinity;
	for(let i = 0; i < arr.length - num + 1; i++) {
		let temp = 0;
		for(let j = 0; j < num; j++) {
			temp += arr[i + j];
		}
		
		if(temp > max) {
			max = temp;
		}
	}
	
	return max;
}

// Sliding Window Solution
// Time: O(N)
// Space: O(1)
function maxSubarraySum(arr, num) {
	let maxSum = 0;
	let tempSum = 0;
	
	if( num > arr.length) {
		return null;
	}
	
	for(let i = 0; i < num; i++) {
		maxSum += arr[i];
	}
	
	tempSum = maxSum;
	for(let i = num; i < arr.length - num + 1; i++) {
		tempSum = tempSum - arr[i - num] + arr[i];
		maxSum = Math.max(maxSum, tempSum);
	}
	
	return maxSum;
}