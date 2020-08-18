/*
	1. Write a function called findLongestSubstring.
	2. Which accepts a string and returns the length of the longest substring with all distinct charcters.
	
	Input1: ''
	Output1: 0
	
	Input2: 'rithmschool'
	Output2: 7
	
	Input3: 'thisisawesome'
	Output3: 6
	
	Input4: 'thecatinthehat'
	Output4: 7
	
	Input5: 'bbbbbb'
	Output5: 1
	
	Input6: 'longestsubstring'
	Output6: 8
	
	Input7: 'thisishowwedoit'
	Output7: 6
*/

// My Solution
// Time: O(N)
// Space: O(N)
function findLongestSubstring(str){
	let obj = {};
	obj[str[0]] = 0;
	let maxLen = 0;
	let i = 0;
  
	for(let j = 1; j < str.length; j++) {
		if(obj[str[j]] >= i && obj[str[j]] < j) {
			if(maxLen < j - i) {
				maxLen = j - i;
			}
            i = obj[str[j]] + 1;
		}
      
		obj[str[j]] = j;
	}

    if(maxLen < str.length - i) {
		maxLen = str.length - i;
    }
  
	return maxLen;
}

// Colt Steel's Solution
// Time: O(N)
// Space: O(N)
function findLongestSubstring(str) {
  let longest = 0;
  let seen = {};
  let start = 0;
 
  for (let i = 0; i < str.length; i++) {
    let char = str[i];
    if (seen[char]) {
      start = Math.max(start, seen[char]);
    }
    // index - beginning of substring + 1 (to include current in count)
    longest = Math.max(longest, i - start + 1);
    // store the index of the next char so as to not double count
    seen[char] = i + 1;
  }
  return longest;
}