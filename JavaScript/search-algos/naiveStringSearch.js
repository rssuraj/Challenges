/*
    1. Find the total number of matches a substring has in a bigger string

    Test cases:
    1. "I am a bigger string", "am"
            => 1
    2. "I am a bigger string", "big"
            => 1
*/

// My Solution
function stringSearch(bigger, search) {
    let count = 0;

    for(let i = 0; i < bigger.length; i++) {
        let loops = 0;
        let innerI = i;
        for(let j = 0; j < search.length; j++) {
            if(bigger[innerI] !== search[j]) {
                break;
            }
            innerI++;
            loops++;
        }

        if(loops === search.length) {
            count++;
        }
    }

    return count;
}

function stringSearch(long, short) {
    let count = 0;

    for(let i = 0; i < long.length; i++) {
        for(let j = 0; j < short.length; j++) {
            if(long[i + j] !== short[j]) {
                break;
            }
            if(j === short.length - 1) {
                count++;
            }
        }
    }

    return count;
}

//console.log(stringSearch("I am a bigger string", "g"));