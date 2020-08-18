/*
	1. Write a function called sumZero which accepts a sorted array of integers.
	2. The function should find the first pair where the sum is 0.
	3. Return an array that includes both values that sum to zero or undefined if a pir does not exist
	
	Input1: [-3, -2, -1, 0, 1, 2, 3]
	Output1: [-3, 3]
	
	Input2: [-2, 0, 1, 3]
	Output2: undefined
	
	Input3: [1, 2, 3]
	Output3: undefined
*/

// Naive Solution
// Time: O(N^2)
// Space: O(1)
function sumZero(arr) {
	for(let i = 0; i < arr.length; i++) {
		for(let j = i + 1; j < arr.length; j++) {
			if(arr[i] + arr[j] === 0) {
				return [arr[i], arr[j]];
			}
		}
	}
}

// Multiple Pointer Solution
// Time: O(N)
// Space: O(1)
function sumZero(arr) {
	let i = 0;
	let j = arr.length - 1;
	while(i < j) {
		if(arr[i] + arr[j] === 0) {
			return [arr[i], arr[j]];
		}
		
		if(arr[i] + arr[j] > 0) {
			j--;
		}
		else {
			i++;
		}
	}
}