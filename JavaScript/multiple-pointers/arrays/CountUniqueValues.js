/*
	1. Implement a function called countUniqueValues, which accepts a sorted array, and counts unique values in the array.
	2. There can be negative numbers in the array, but it will always be sorted.
	
	Input1: [1, 1, 1, 1, 1, 1, 2]
	Output1: 2
	
	Input2: [1, 2, 3, 4, 4, 4, 7, 7, 12, 12, 13]
	Output2: 7
	
	Input3: []
	Output3: 0
	
	Input4: [-2, -1, -1, 0, 1]
	Output4: 4
*/

// My Solution
// Time: O(N)
// Space: O(1)
function countUniqueValues(arr) {
	let i = 0;
	let j = 1;
	let count = 0;
	while(i < arr.length && j < arr.length) {
		if(arr[i] == arr[j]) {
			j++;
		}
		else {
			count++;
			i = j;
			j = i + 1;
		}
	}
	
	if(i < arr.length || j < arr.length) {
		count++;
	}
	
	return count;
}

// Colt Steel's Solution
// Time: O(N)
// Space: O(1)
function countUniqueValues(arr) {
	if(arr.length == 0)
		return 0;
	
	let i = 0;
	for(let j = 1; j < arr.length; j++) {
		if(arr[i] != arr[j]) {
			i++;
			arr[i] = arr[j];
		}
		console.log(arr);
	}
	
	return i + 1;
}