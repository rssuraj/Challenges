/*
	1. Write a function called same, which accepts 2 arrays.
	2. The function should return true if every value in the 1st array has its corresponding value squared in 2nd array.
	3. The frequency of values must be the same.
*/

// Naive Solution
// Time: O(N^2)
// Space: O(1)
function same(arr1, arr2) {
	if(arr1.length != arr2.length)
		return false;
	
	for(let i = 0; i < arr1.length; i++) {
		let ele = arr1[i];
		console.log(ele);
		let index = arr2.indexOf(ele * ele);
		console.log(index);
		if(index == -1)
			return false;
		
		arr2.splice(index, 1);
		console.log(arr2);
	}
	
	return true;
}

// Refactored Solution
// Time: O(N)
// Space: O(1)
function same(arr1, arr2) {
	if(arr1.length != arr2.length)
		return false;
	
	let frequency = {};
	for(let i = 0; i < arr1.length; i++) {
		frequency[arr1[i] ** 2] = (frequency[arr1[i] ** 2] + 1) || 1
	}
	
	console.log(frequency);
	
	for(let i = 0; i < arr2.length; i++) {
		console.log(arr2[i]);
		console.log(frequency[arr2[i]]);
		if(!frequency[arr2[i]])
			return false;
		
		frequency[arr2[i]] = frequency[arr2[i]] - 1;
		console.log(frequency[arr2[i]]);
	}
	
	return true;
}

// Colt Steel Refactored Solution
// Time: O(N)
// Space: O(1)
function same(arr1, arr2) {
	if(arr1.length != arr2.length)
		return false;
	
	let frequencyCounter1 = {};
	let frequencyCounter2 = {};
	
	for(let val of arr1) {
		frequencyCounter1[val] = (frequencyCounter1[val] || 0) + 1;
	}
	
	for(let val of arr2) {
		frequencyCounter2[val] = (frequencyCounter2[val] || 0) + 1;
	}
	
	for(let key in frequencyCounter1) {
		if(!(key ** 2 in frequencyCounter2))
			return false;
		
		if(frequencyCounter2[key ** 2] !== frequencyCounter1[key])
			return false;
	}
	
	return true;
}