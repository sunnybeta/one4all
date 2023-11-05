# Javascrip Fundamentals

## Execution Context

Everything in Javascript happens inside an **Execution Context**.
The execution context has two components:
- **Memory Component**: All variables and functions are stored here as key value pairs. This is also knowns as *variable environment*.
- **Coded Component**: Here the code is executed one line at a time. This is also known as *Thread of Execution*

Everytime a function is invoked, a new execution context is created.
This execution is immediately deleted after its job is complete.
**Javascript is a synchronous single-threaded language.**

## Call Stack

The call stack maintains the order of execution of the execution context.

Whenever a code is executed, a global execution context is pushed onto the stack. When a new function is invoked, it is pushed onto the stack. After the completion of a function, the execution context is then popped off the stack.

## Hoisting

Hoisting is a phenomenon in javascript by which we can access variable and functions without initializing it without an error.

Note: Arrow functions behave like variables. So it cannot be accessed before reaching the initialization.

## Hello World

```javascript
console.log("Hello, World!\n");
```

Whenever we run a javascript program: three global variables are created: a global object, a variable `this` which equals this global object.

## Scope

Scope of a variable is the parts of the code where the variable can be accessed.
When searching for a variable for reference, javascript looks for the variable in the lexical environment.

*Lexical environment is simply the current local environment and the parent environment*

By definition, we now also check for the variables in the parent lexical environment.
This creates a chain of scopes and is known as the *scope chain*.

## Temporal Dead Zone

The time between hoisting and initialization fo a variable is called its temporal dead zone.

To avoid temporal deadzone, tryi keeping all declarations and initilaizations on the top of your code (function).

### Let

The creation of a variable with `let` keyword provides some sainty in javascript. It is stricter than `var` in te following ways.

If a variable is created with the `let` keyword, accessing the hoister variable will throw a `Reference Error`.
Reinitialising the variable, will throw a `Syntax Error`.

### Const

Variable declared with `const` must be initalized as well. Finally, we cannot update a `const` variable.


## Protoype

Every object and function has its own property called *prototype*.

The prototype has its own property type which creates a *prototype chain*.

```javascript
let arr = [1,2,3,'a']
console.log(arr.__proto__)                     // Object(0) <[]>
console.log(arr.__proto__.__proto__)           // [Object: null prototype] {}
console.log(arr.__proto__.__proto__.__proto__) // null
```

When looking for a property, javascript looks at the top layer. If the property does not exist, then it looks for it in the prototype. If not then, we look in the prototype of the prototype and so on. This is known as `Prototypal Inheritance`.

We can use Prorotype to add properties and methods to a constructor function. Objects inherit the properties and methods from a prorotype.

```javascript
function Employee(fname, lname) {
    this.fname = fname
    this.lname = lname
}

Employee.prototype.gender = "Helicopter"
Employee.prototype.fullname = function() {return this.fname + " " + this.lname}

const e1 = Employee("Sunny","Beta")
const e2 = Employee("Cloudy","Alpha")

console.log(e1)
console.log(e2)
console.log(e1.fullname())
```

If a prototype value is changed, then all the new objects wil have the new proptotype value.

## Call, Apply, Bind

### Function Call & Borrowing

The `call` method is used to programatically call a function in javascript.

```javascript
myAwsomeFunction.call(object, param1, param2)
```

```javascript
myAwsomeFunction.apply(object, [param1, param2])
```

We can use a function in an object with an input of another object using the `call` method.

```javascript
object1.myAwesomeFunction.call(object2, param1, param2)
object1.myAwesomeFunction.apply(object2, [param1, param2])
```

### Bind

The `bind` method constructs a copy and return the function for later use.


```javascript
let myLaterFunction = myAwesomeFunction.bind(object2, param1, param2)
console.log(myLaterFunction)     // function (...)
console.log(myAwesomeFunction()) // executes the function
```

### Polyfill for Bind

```javascript
let o = {
	fname: 'Sunny',
	lname: 'Beta',
}

function pname(arg1, arg2) {console.log(this.fname + " " + this.lname + " " + arg1 + " " + arg2)}


let newFun = pname.bind(o,1,2,3)
newFun()


// NEW BIND

Function.prototype.bind2 = function(...args) {
	let fn = this
	let params = args.slice(1)
	return function(...fnargs) {
		console.log(params)
		console.log(fnargs)
		fn.apply(args[0], [...params, ...fnargs])
	}
}

let newFun2 = pname.bind2(o,1,2,3)
newFun2('a','b','c')
```

## Callbacks

- A callback is a function passed as an argument to another function.
- This technique allows a function to call another function.
- A callback function can run after another function has finished
- JavaScript functions are executed in the sequence they are called. Not in the sequence they are defined.

## Event Loop

### Call Stack

The *Call Stack* is a data structure which records where we are in the program.
If we step into a function, we push it onto the stack.
If we return from a function we return from the top of the stack.

### Blocking

There isn't any definition of what blocking is, Something is block just means that it is in some sense slow. Loops with large number of iterations, image processing, external URL requests are all examples of parts of programs which can be slow or in our case blocking.

The main application will be stuck or blocked in case there is some piece of code which is blocking.

### Task Queue

```javascript
console.log("Hello")

setTimeout(function callback() {
    console.log("Yes You");
}, 5000
);

console.log("Me ?");
```

- The first `console.log` is pushed onto the stack.
- `Hello` is logged.
- This function is now complete and is now popped out of the stack.

- `setTimeout` is pushed onto the stack
- A timer is set by the WebAPI or C++ API
- The function is popped off the stack.

- Similar to the first line, the last `console.log` is pushed onto the stack, executed and popped off.

*What happened to the callback of `setTimeout` ?*

After `5000 ms`, the `callback` function is now pushed onto the **Task Queue**. Now the flow is easy.
The *Event Loop*'s job is to look at the stack and the task queue.
If the stack is empty, it will look at the first item in the queue and push it onto the call stack.
The function in the stack is now executed and popped off.


## Closure Function

A *closure function* is a function which has access to its parent scope even after the inner function has been closed.
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

