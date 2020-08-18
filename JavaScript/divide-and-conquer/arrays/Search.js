/*
	1. Given a sorted array of integers.
	2. Write a function called search, that accepts a value and returns the index where the value passed to the function is located.
	3. If the value is not found, return -1;
	
	Input1: [1, 2, 3, 4, 5, 6], 4
	Output1: 3
	
	Input2: [1, 2, 3, 4, 5, 6], 6
	Output2: 5
	
	Input3: [1, 2, 3, 4, 5, 6], 11
	Output3: -1
*/

// Naive Solution (Linear Search)
// Time: O(N)
// Space: O(1)
function search(arr, num) {
	for(let i = 0; i < arr.length; i++) {
		if(arr[i] == num) {
			return i;
		}
	}
	return -1;
}

// Efficient Solution (Binary Search)
// Time: O(logN)
// Space: O(1)
function search(arr, num) {
	let min = 0;
	let max  = arr.length - 1;
	
	while(min <= max) {
		let mid = Math.floor((min + max) / 2);
		let curEle = arr[mid];
		
		if(curEle < num) {
			min = mid + 1;
		}
		else if(curEle > num) {
			max = mid - 1;
		}
		else {
			return mid;
		}
	}
	return -1;
}