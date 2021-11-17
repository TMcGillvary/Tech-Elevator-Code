/**
 * Write a function called isAdmitted. It will check entrance
 * scores and return true if the student is admitted and
 * false if rejected. It takes three parameters:
 *
 *     * gpa
 *     * satScore (optional)
 *     * recommendation (optional)
 *
 * Admit them--return true--if:
 * gpa is above 4.0 OR
 * SAT score is above 1300 OR
 * gpa is above 3.0 and they have a recommendation OR
 * SAT score is above 1200 and they have a recommendation
 * OTHERWISE reject it
 *
 * @param {number} gpa the GPA of the student, between 4.2 and 1.0
 * @param {number} [satScore=0] the student's SAT score
 * @param {boolean} [recommendation=false] does the student have a recommendation
 * @returns {boolean} true if they are admitted
 */

function isAdmitted(gpa, satScore = 0, recommendation = false) {

    if (gpa > 4.0 || satScore > 1300 || (gpa > 3.0 && recommendation === true) || (satScore > 1200 && recommendation === true)) {
        return true;
    } else {
        return false;
    }
}

/**
 * Write a function called useParameterToFilterArray that takes a function and uses that in the 
 *`unfilteredArray` filter function. Return the result.
 *
 * @param {function} filterFunction the function to filter with
 * @returns {number[]} the filtered array
 */
let unfilteredArray = [1, 2, 3, 4, 5, 6];

function useParameterToFilterArray(filterFunction) {
    let filteredArray = [];
    filteredArray = unfilteredArray.filter(filterFunction);
    return filteredArray;
}

/**
 * Write a function called makeNumber that takes two strings
 * of digits, concatenates them together, and returns
 * the value as a number.
 *
 * So if two strings are passed in "42293" and "443", then this function
 * returns the number 42293443.
 *
 * @param {string} first the first string of digits to concatenate
 * @param {string} [second=''] the second string of digits to concatenate
 * @returns {number} the resultant number
 */

function makeNumber(first, second = '') {
    let number = parseInt(first + second);
    return number;
}

/**
 * Write a function called addAll that takes an unknown number of parameters
 * and adds all of them together. Return the sum.
 *
 * @param {...number} num a series of numbers to add together
 * @returns {number} the sum of all the parameters (or arguments)
 */

function addAll(num) {
    let sum = 0;

    for (let i = 0; i < arguments.length; i++) {
        sum += arguments[i];
    }

    return sum;
}

/*
 * Write and document a function called makeHappy that takes
 * an array and prepends 'Happy ' to the beginning of all the
 * words and returns them as a new array. Use the `map` function.
 */

/**
 * A function that takes an array and prepends "Happy " with a trailing space
 * to the beginning of every word, using the map function.
 * 
 * @param {string[]} stringArray an array of strings
 * @return {string[]} returns a new array of strings
 */

function makeHappy(stringArray) {
    return stringArray.map((string) => "Happy " + string);
}

/*
 * Write and document a function called getFullAddressesOfProperties
 * that takes an array of JavaScript objects. Each object contains the
 * following properties:
 *     * streetNumber
 *     * streetName
 *     * streetType
 *     * city
 *     * state
 *     * zip
 *
 * and returns an array of strings that turns the JavaScript objects
 * into a mailing address in the form of:
 *     streetNumber streetName streetType city state zip
 *
 * Use `map` and an anonymous function.
 */

/**
 * A function that takes an array of address objects, puts them into the correct order,
 * and outputs the addresses as a string array
 * 
 * @param {object} objectArray The array of Javascript Objects containing addresses
 * @returns {string[]} returns an array of string addresses
 */

function getFullAddressesOfProperties(objectArray) {
    let result = objectArray.map((address) => {
        let string = `${address.streetNumber} ${address.streetName} ${address.streetType} ${address.city} ${address.state} ${address.zip}`;
        return string;
    });

    return result;
}

/*
 * Write and document a function called findLargest.
 *
 * Using `forEach`, find the largest element in an array.
 * It must work for strings and numbers.
 */

/**
 * A function that finds the largest element in an array, whether it is an array
 * of strings or an array of numbers.
 * 
 * @param {[]} array an array of strings or numbers
 * @returns {element} returns the largest element in the array
 */

function findLargest(array) {
    let max = array[0];

    array.forEach((value) => {
        if (max < value) {
            max = value;
        }
    });

    return max;
}

/*
 * CHALLENGE
 * Write and document a function called getSumOfSubArrayValues.
 *
 * Take an array of arrays, adds up all sub values, and returns
 * the sum. For example, if you got this array as a parameter:
 * [
 *   [1, 2, 3],
 *   [2, 4, 6],
 *   [5, 10, 15]
 * ];
 *
 * The function returns 48. To do this, you will use two nested `reduce`
 * calls with two anonymous functions.
 *
 * Read the tests to verify you have the correct behavior.
 */



/**
 * A function that takes an array of number arrays, adds each sub array together, then
 * adds the total for each array together for the total sum.
 * 
 * @param {array[]} arrayContainer an array of arrays
 * @returns {number} returns the total of all sub arrays added together
 */
function getSumOfSubArrayValues(arrayContainer = []) {
    let sum = 0;

    sum = arrayContainer.reduce((runningTotal, currentArray) => {
        let newAmount = currentArray.reduce((previousNum, currentNum) => {
            return previousNum + currentNum;
        });
        return runningTotal + newAmount;
    }, 0);

    return sum;
}

