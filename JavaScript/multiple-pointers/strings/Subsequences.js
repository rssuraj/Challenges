/*
	1. Write a function called isSubsequence which takes in 2 strings.
	2. Checks whether the characters in the 1st string form a subsequence of the characters in the 2nd string.
	3. In other words, the function should check whether the characters in the 1st string appear somewhere in the 2nd string, without their order changing.
	
	Input1: 'hello', 'hello world'
	Output1: true
	
	Input1: 'sing', 'sting'
	Output1: true
	
	Input1: 'abc', 'abracadabra'
	Output1: true
	
	Input1: 'abc', 'acb'
	Output1: false
*/

// My Solution
// Time: O(N)
// Space: O(1)
function isSubsequence(str1, str2) {
  let i = 0, j = 0;
  
  while(i < str1.length && j < str2.length) {
      if(str1[i] === str2[j]) {
          i++;
      }
      
      j++;
  }
  
  if(i === str1.length) {
      return true;
  }
  return false;
}

// Colt Steel's Solution
// Time: O(N)
// Space: O(1)
function isSubsequence(str1, str2) {
  var i = 0;
  var j = 0;
  if (!str1) return true;
  while (j < str2.length) {
    if (str2[j] === str1[i]) i++;
    if (i === str1.length) return true;
    j++;
  }
  return false;
}

// Colt Steel's Solution
// Time: O(N)
// Space: O(N)
function isSubsequence(str1, str2) {
  if(str1.length === 0) return true
  if(str2.length === 0) return false
  if(str2[0] === str1[0]) return isSubsequence(str1.slice(1), str2.slice(1))  
  return isSubsequence(str1, str2.slice(1))
}