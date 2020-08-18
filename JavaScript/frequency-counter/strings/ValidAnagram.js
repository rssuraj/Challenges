/*
	1. Given 2 strings, write a function to determine if the 2nd string is an anagram of the first.
	2. An anagram is a word, phrase, or name formed by rearranging the letters of another,
	3. For Example: cinema and iceman are anagrams

	Input1: '', ''
	Outpu1: true

	Input2: 'aaz', 'zza'
	Outpu2: false

	Input3: 'anagram', 'nagaram'
	Outpu3: true

	Input4: 'rat', 'car'
	Outpu4: false

	Input5: 'awesome', 'awesom'
	Outpu5: false

	Input6: 'qwerty', 'qeywrt'
	Outpu6: true

	Input7: 'texttwisttime', 'timetwisttext'
	Outpu7: true
*/

// My Solution & Colt Steel's Solution
// Time: O(N)
// Space: O(N)
function validAnagram(word1, word2) {
	if(word1.length != word2.length)
		return false;
	
	let frequency = {};
	
	for(let i = 0; i < word1.length; i++) {
		frequency[word1[i]] = (frequency[word1[i]] || 0) + 1;
	}
	
	for(let i = 0; i < word2.length; i++) {
		if(!frequency[word2[i]])
			return false;
		
		frequency[word2[i]] = frequency[word2[i]] - 1;
	}
	
	return true;
}