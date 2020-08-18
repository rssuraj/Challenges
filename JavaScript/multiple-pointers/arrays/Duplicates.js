/*
	1. Implement a function called areThereDuplicates which accepts a variable number of arguments.
	2. Checks whether there are any duplicates among the arguments passed in.
	3. You can solve this using the frequency counter pattern OR the multiple pointers pattern.
	
	Input1: 1, 2, 3
	Output1: false
	
	Input2: 1, 2, 2
	Output2: true
	
	Input3: 'a', 'b', 'c', 'a'
	Output3: true
*/

// My Solution (Frequency Counter)
// Time: O(N)
// Space: O(N)
function areThereDuplicates(...args) {
	let obj = {};
  
	for(let i = 0; i < args.length; i++) {
		if(obj[args[i]]) {
			return true;
		}
		obj[args[i]] = 1;
	}
	return false;
}

// My Solution (Multiple Pointers)
// Time: O(NlogN)
// Space: O(1)
function areThereDuplicates(...args) {
	if(args.length == 1) {
		return false;
	}
	
	let first = 0;
	
	args.sort();
  
	for(let i = 1; i < args.length; i++) {
		if(args[i] === args[first]) {
			return true;
		}
		first = i;
	}
	return false;
}

// Colt Steel's Solution (Frequency Counter)
// Time: O(N)
// Space: O(N)
function areThereDuplicates() {
  let collection = {}
  for(let val in arguments){
    collection[arguments[val]] = (collection[arguments[val]] || 0) + 1
  }
  for(let key in collection){
    if(collection[key] > 1) return true
  }
  return false;
}

// Colt Steel's Solution (Multiple Pointers)
// Time: O(NlogN)
// Space: O(1)
function areThereDuplicates(...args) {
  // Two pointers
  args.sort((a,b) => a > b);
  let start = 0;
  let next = 1;
  while(next < args.length){
    if(args[start] === args[next]){
        return true
    }
    start++
    next++
  }
  return false
}

// Colt Steel's Solution (One Linear)
// Time: O(N)
// Space: O(N)
function areThereDuplicates() {
  return new Set(arguments).size !== arguments.length;
}