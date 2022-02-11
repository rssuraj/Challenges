function median(arr1, arr2) {
    const totalLength = arr1.length + arr2.length;

    const medianIsEven = totalLength % 2 === 0;
    const medianIndex = Math.floor(totalLength / 2);

    let median = 0;

    if(totalLength === 0) {
        return median;
    }

    if(arr1.length === 0) {
        return medianIsEven ? (arr2[medianIndex] + arr2[medianIndex + 1]) / 2 : arr2[medianIndex];
    }

    if(arr2.length === 0) {
        return medianIsEven ? (arr1[medianIndex] + arr1[medianIndex + 1]) / 2 : arr1[medianIndex];
    }

    let i = 0;
    let j = 0;
    let m = 0;

    while (m <= medianIndex) {
        if(arr1[i] <= arr2[j]) {
            if(m === medianIndex) {
                median = arr1[i];
                break;
            }
            i++;
        }
        else {
            if(m === medianIndex){
                median = arr2[j];
                break;
            }
            j++;
        }

        m++;
    }

    if(i === arr1.length) {
        i--;
    }

    if(j === arr2.length) {
        j--;
    }

    if(medianIsEven) {
        if(arr1[i] === median) {
            if(arr1[i - 1] && arr1[i - 1] <= arr2[j]) {
                median = (median + arr1[i - 1]) / 2;
            }
            else {
                median = (median + arr2[j]) / 2;   
            }
        }
        else {
            if(arr2[j - 1] && arr2[j - 1] <= arr1[i]) {
                median = (median + arr2[j - 1]) / 2;
            }
            else {
                median = (median + arr1[i]) / 2;
            }
        }
    }

    return median;
};

function medainSorted(arr1, arr2) {
    const totalLength = arr1.length + arr2.length;
    const medianIsEven = totalLength % 2 === 0;
    const medianIndex = Math.floor(totalLength / 2);

    if(arr1.length === 0) {
        return medianIsEven ? (arr2[medianIndex] + arr2[medianIndex + 1]) / 2 : arr2[medianIndex];
    }

    if(arr2.length === 0) {
        return medianIsEven ? (arr1[medianIndex] + arr1[medianIndex + 1]) / 2 : arr1[medianIndex];
    }

    let sortedArray = [];

    let smallerArr = arr1.length > arr2.length ? arr2: arr1;
    let largerArr = arr1.length > arr2.length ? arr1: arr2;

    let j = 0;
    for(let i = 0; i < largerArr.length; i++) {
        if(smallerArr[j]) {
            if(largerArr[i] < smallerArr[j]) {
                sortedArray.push(largerArr[i]);
            }
            else {
                sortedArray.push(smallerArr[j]);
                j++;
                i--;
            }
        }
        else {
            sortedArray.push(largerArr[i]);
        }
    }

    if(j < smallerArr.length) {
        sortedArray = [ ...sortedArray, ...smallerArr.slice(j)];
    }

    return medianIsEven ? (sortedArray[medianIndex] + sortedArray[medianIndex - 1]) / 2 : sortedArray[medianIndex];

}

console.log(median([1,3], [2]));
console.log(median([1,2], [3,4]));
console.log(median([0,0], [0,0]));
console.log(median([], [1]));
console.log(median([2], []));


console.log("==============================================================");


console.log(medainSorted([1,3], [2]));
console.log(medainSorted([1,2], [3,4]));
console.log(medainSorted([0,0], [0,0]));
console.log(medainSorted([], [1]));
console.log(medainSorted([2], []));