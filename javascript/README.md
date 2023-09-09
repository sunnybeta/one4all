# Javascrip Fundamentals

## Closure Function

A closure function is a function which has access to its parent scope even after the inner function has been closed.
Global variables can be made local / private with closures.

```javascript
function add() {
	counter = 0;
	counter += 1;
}

add();
add();
add();
// counter scope is global
// In the last add() function call, counter is set to 0 counter value is increased by 1
console.log(counter);
```

```javascript
let counter = 0;

function add() {
	counter += 1;
}

add();
add();
add();
// counter = 3
// PROBLEM: any code elsewhere now has the ability to update the counter
console.log(counter);
```

```javascript
let counter = 0;

function add() {
	let counter = 0;
	counter += 1;
}

add();
add();
add();
// counter = 0
// PROBLEM: counter is now local to the add() function and that is increased by 1; global counter is still 0 :(
console.log(counter);
```


```javascript
function incrementor() {
	let counter = 0;
	function increment() {
		counter+=1;
		console.log(counter);
		return counter;
	}
	return increment;
}

add = incrementor();
add();
add();
add();
// counter = 3
// We are done!
```

## Callbacks

- A callback is a function passed as an argument to another function.
- This technique allows a function to call another function.
- A callback function can run after another function has finished
- JavaScript functions are executed in the sequence they are called. Not in the sequence they are defined.


## Promises

A promise object in Java consists of both a `producing` code and calls to the `consuming` code.

```javascript
let myPromise = new Promise((resolve,reject) => {
    // process & call resolve / reject
});

myPromise.then(
    function() { /* code if successful */},
    function() { /* code if caught error */},
);
```

A Promise object can be:

- Pending
- Fulfilled
- Rejected

The Promise object supports two properties: `state` and `result`.

While a Promise object is _pending_ (working), the result is undefined.
When a Promise object is _fulfilled_, the result is a value.
When a Promise object is _rejected_, the result is an error object.


## == vs ===

The '==' operator does a loose quality comparison and performs type modifications if required for the comparison to be possible.
On the other hand, the '===' operator performs a strict comparison and expects the operands to have the same type.


## 3 - '3'

Subtraction operation is performed naturally with an integer
Addition with atleast string always converts it to a string.

```javascript
3-'3' === 0
'3'-'3' === 0
'3'-3) === 0
3-3 === 0
3+'3' === '33'
'3'+'3' === '33'
'3'+3 === '33'
3+3 === 6
```

*Note*

```javascript
'2'+'2'-'2' === 20 // true
1+'2'+3 === '123' // true
1+ +'2'+3 === 6 // true: the additional + before '2' type casts string '2' to an integer 2.
```


