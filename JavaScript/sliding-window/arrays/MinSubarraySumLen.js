/*
	1. Write a function called minSubArrayLen which accepts 2 parameters - an array of positive integers and a positive integer.
	2. This function should return the minimal length of a contiguos subarray of which the sum is greater than or equal to the integer passed to the function.
	3. If there isn't one, return 0 instead.
	
	Input1: [2, 3, 1, 2, 4, 3], 7
	Outpu1: 2 -> [4, 3]
	
	Input1: [2, 1, 6, 5, 4], 9
	Outpu1: 2 -> [5, 4]
	
	Input1: [3, 1, 7, 11, 2, 9, 8, 21, 62, 33, 19], 52
	Outpu1: 1 -> [62]
	
	Input1: [1, 4, 16, 22, 5, 7, 8, 9, 10], 39
	Outpu1: 3
	
	Input1: [1, 4, 16, 22, 5, 7, 8, 9, 10], 55
	Outpu1: 5
	
	Input1: [4, 3, 3, 8, 1, 2, 3], 11
	Outpu1: 2
	
	Input1: [1, 4, 16, 22, 5, 7, 8, 9, 10], 95
	Outpu1: 0
*/

// My Solution
// Time: O(N^2)
// Space: O(1)
function minSubArrayLen(arr, num) {
    for(let i = 1; i <= arr.length; i++) {
        let tempSum = 0;
        
        for(let j = 0; j < i; j++) {
            tempSum += arr[j];
        }
        
        if(tempSum >= num) {
            return i;
        }
        
        for(let j = i; j < arr.length; j++) {
            tempSum = tempSum - arr[j - i] + arr[j];
            if(tempSum >= num) {
                return i;
            }
        }
    }
    return 0;
}

// Colt Steel's Solution
// Time: O(N)
// Space: O(1)
function minSubArrayLen(nums, sum) {
  let total = 0;
  let start = 0;
  let end = 0;
  let minLen = Infinity;
 
  while (start < nums.length) {
    // if current window doesn't add up to the given sum then 
		// move the window to right
    if(total < sum && end < nums.length){
		total += nums[end];
		end++;
    }
    // if current window adds up to at least the sum given then
		// we can shrink the window 
    else if(total >= sum){
		minLen = Math.min(minLen, end-start);
		total -= nums[start];
		start++;
    } 
    // current total less than required total but we reach the end, need this or else we'll be in an infinite loop 
    else {
		break;
    }
  }
 
  return minLen === Infinity ? 0 : minLen;
}