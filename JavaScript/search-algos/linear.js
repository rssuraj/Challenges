/*
    1. Write a function which accepts an array and a value.
    2. Loop through the array and check if the current array element is equal to the value.
	3. If it is, return the index at which the element is found.
	4. If the value is never found, return -1.

    Test Cases:
    1. [10, 15, 20, 25, 30], 15
            => 1
	2. [9, 8, 7, 6, 5, 4, 3, 2, 1, 0], 4
            => 5
	3. [100], 100
            => 0
	4. [1, 2, 3, 4, 5], 6
            => -1
	5. [9, 8, 7, 6, 5, 4, 3, 2, 1, 0], 10
            => -1
	6. [100], 200
            => -1
*/

function linearSearch(arr, value) {
    for(let i = 0; i < arr.length; i++) {
        if(arr[i] === value) {
            return i;
        }
    }
    return -1;
}

console.log(linearSearch([10, 15, 20, 25, 30], 15));
console.log(linearSearch([100], 200));