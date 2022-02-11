/*
    1. Write a function that accepts a sorted array and a value.
	2. Create a left pointer at the start of the array, and a right pointer at the end of the array.
	3. While the left pointer comes before the right pointer:
		- Create a pointer in the middle.
		- If you find the value you want, return the index.
		- If the value is too small, move the left pointer up.
		- If the value is too large, move the right pointer down.
	4. If you never find the value, return -1.

    Test Cases:
    1. [1, 2, 3, 4, 5], 2
            => 1
	2. [1, 2, 3, 4, 5], 3
            => 2
	3. [1, 2, 3, 4, 5], 5
            => 4
	4. [1, 2, 3, 4, 5], 6
            => -1
	5. [5, 6, 10, 13, 14, 18, 30, 34, 35, 37, 40, 44, 64, 79, 84, 86, 95, 96, 98, 99], 10
            => 2
	6. [5, 6, 10, 13, 14, 18, 30, 34, 35, 37, 40, 44, 64, 79, 84, 86, 95, 96, 98, 99], 95
            => 16
	7. [5, 6, 10, 13, 14, 18, 30, 34, 35, 37, 40, 44, 64, 79, 84, 86, 95, 96, 98, 99], 100
            => -1
*/

// My Solution
function binarySearch(arr, val) {
    let left = 0;
    let right = arr.length - 1;
    
    while(left <= right) {
        let mid = Math.floor(left + (right - left) / 2);
        
        if(arr[mid] === val) {
            return mid;
        }
        
        if(arr[mid] < val) {
            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
    }
    return -1;
}

// Colt's Solution
function binarySearch(arr, elem) {
    let start = 0;
    let end = arr.length - 1;
    let middle = Math.floor((start + end) / 2);

    while(arr[middle] !== elem && start <= end) {
        if(elem > arr[middle]) {
            end = middle - 1;
        }
        else {
            start = middle + 1;
        }

        middle = Math.floor((start + end) / 2);
    }

    return arr[middle] === elem ? middle : -1;
}

//binarySearch([2, 5, 6, 9, 13, 15, 28], 15);