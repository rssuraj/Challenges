/*
  1. Write a function called sameFrequency. Given 2 positive integers.
  2. Find out if the 2 numbers have the same frequency of digits.
  3. Your solution MUST have the following complexities:
    - Time: O(N)
    
  Input1: 182, 281
  Output1: true
  
  Input1: 34, 14
  Output1: false
  
  Input1: 3589578, 5879385
  Output1: true
  
  Input4: 22, 222
  Output4: false
*/

// My Solution
// Time: O(N)
// Space: O(N)
function sameFrequency(num1, num2){
  // good luck. Add any arguments you deem necessary.
  let digits = {};
  
  num1 = num1 + '';
  num2 = num2 + '';
  
  if(num1.length != num2.length) {
      return false;
  }
  
  for(let i = 0; i < num1.length; i++) {
      digits[num1[i]] = (digits[num1[i]] || 0) + 1;
  }
  
  for(let i = 0; i < num2.length; i++) {
      if(!digits[num2[i]]) {
          return false;
      }
      
      digits[num2[i]] = digits[num2[i]] - 1;
  }
  
  return true;
}

// Colt Steel's Solution
// Time: O(N)
// Space: O(N)
function sameFrequency(num1, num2){
  let strNum1 = num1.toString();
  let strNum2 = num2.toString();
  if(strNum1.length !== strNum2.length) return false;
  
  let countNum1 = {};
  let countNum2 = {};
  
  for(let i = 0; i < strNum1.length; i++){
    countNum1[strNum1[i]] = (countNum1[strNum1[i]] || 0) + 1
  }
  
  for(let j = 0; j < strNum1.length; j++){
    countNum2[strNum2[j]] = (countNum2[strNum2[j]] || 0) + 1
  }
  
  for(let key in countNum1){
    if(countNum1[key] !== countNum2[key]) return false;
  }
 
  return true;
}