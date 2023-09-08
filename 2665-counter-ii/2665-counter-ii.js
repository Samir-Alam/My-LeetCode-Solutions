/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */

let sum;
var createCounter = function(init) {
    sum = init
    return{
        increment: () => {
            return ++init
        },
        decrement: () => {
            return --init
        },
        reset: () => {
            init = sum
            return sum
        }
    }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */