/*
    Implement a bubble Sort
*/

function bubbleSort(arr) {
    for(let i = arr.length; i > 0; i--) {
        for(let j = 0; j <= i-1; j++ ) {
            if(arr[j] > arr[j + 1]) {
                [arr[j], arr[j + 1]] = [arr[j + 1], arr[j]]
            }
        }
    }
    return arr;
}

console.log(bubbleSort([10, 7, 5, 4, 2]));

// Optimized to stop when there are no swaps in a pass
function bubbleSortOptimized(arr) {
    let noSwaps;
    for(let i = arr.length; i > 0; i--) {
        noSwaps = true;
        for(let j = 0; j <= i-1; j++ ) {
            if(arr[j] > arr[j + 1]) {
                [arr[j], arr[j + 1]] = [arr[j + 1], arr[j]];
                noSwaps = false;
            }
        }

        if(noSwaps)
            break;
    }
    return arr;
}

console.log(bubbleSortOptimized([8, 1, 2, 3, 4, 5, 6, 7]));