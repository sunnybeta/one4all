# Go

The documentation of any project is better than the concise notes made here.
Please make sure to read them as well ![here](https://go.dev/doc/).

## Features

1. Statically Typed
2. Strongly Typed
3. Compiled
4. Fast Compile Time
5. Built-in concurrency

## Contents

1. Getting Started
2. Modules & Packages
3. Hello World

### Getting Started

Go here :D

![https://go.dev/doc/install](https://go.dev/doc/install)

Follow the instructions and finally execute

```bash
go version # go version go1.21.1 linux/amd64
```

to confirm your installation.

### Modules & Packages

A *package* is a folder of go files.
A collection of packages is called a *module*.

```bash
go mod init my_awesome_module # creates a go.mod file
```

Every go file is the part of a package which is identified by the first line on top of the go file (which is in most cases same for every file in the folder).

```go
package my_decent_package
```

The `main` package is a special package name which tells the compiler to look for the entry point function, also named `main`, here.

### Hello World

Create a file `main.go` with the following contents.

```go
package main

import "fmt"

func main() {
    fmt.Println("Hello, World!");
}
```

To run the above program:

```go
go build main.go
./main
# go run main.go executes the above two commands at once
```


### Data Types 


#### Int

Signed Integer: `int`, `int8`, `int16`, `int32`, `int64`

Unsigned Integer: `uint`, `uint8`, `uint16`, `uint32`, `uint64`

- Maximum value of `int8` type is `127`. Trying to initialize `int8` to `127+1` will give rise to a compiler error. This overflow error will not occur at runtime.
- `int` defaults to int32 to int64 depending on your system architecture.

#### Float

`float32`, `float64`

- These are 32 and 64 bits data types used to store decimals.
- Think twice before you choose these data types. For example, to store RGB values unsigned 8 bit integers `uint8` is the best fit.


#### Arithmetic Operations

+, -, *, /, %

- We cannot perform arithmetic operations on different types. To perform this, we must cast one of the variables to the other type. `float32(myInt32Num)`
- Integer divison is rounded down
- 
#### Strings

Single Line: "This is a string on a single line"`

Multiple Line: `This is a string on the first

and the second line`

Concatenation: `"First String" + "Second String"`

Length: `var myShortString string = "abc" // len(myString) = 3`

#### Boolean

`true, `false`

`var myBool bool = true`

We now understand booleans in Go.

#### Default Values

Go assigns default values to all variables when declareed.

`(u)int(size)` `float(size)` `runes` ->  `0`

`string` -> ""

`bool` -> `false`

#### Note

1. Use every variable you declare or face the wrath of the compiler.
2. We can choose not to set the type if we initialize the variable so that the type is inferred. Also, we can drop the var and go short hand with `:=`.

```go
var myNiceVar = "noice one" // Congratulations: it's a string
myAnotherNiceVar := "noice one" // Congratulations: this is also a string
```

3. Initialize multiple variables at once.

```go
var1, var2 := 34, "thirty-four" // I have zero creativity
```

4. Constants are immutable variables which have to be initialized at declaration.
```go
const constIsConst string = "I cannot change *sigh*"
const pie float32 = 3.1415 
```

### Control

Use the `func` keyword followed by the name of the function followed by parenthesis block for parameters and its types, followed by another parenthesis block mentioning the return type(s) of the function, and finally a curly braces block for the logic.

```go
func myPoorFunction(firstName string, lastName string) (string) {
    return firstName + lastName)
}
```

#### Handling Errors

The standard way of capturing and handling errors is to expect an `err` variable of type error along with the result of the function. This is a common design pattern while programming in Go.

#### If-ElseIf-Else
```go
package main

import (
	"fmt"
	"errors"
)

func main(){
	a := 255
	b := 13
	q,r,err := divide(a,b)
	if err!=nil {
		fmt.Println(err)
	} else if r == 0 {
		fmt.Println("Factor")
	} else {
		fmt.Printf("Quotient = %v, Remainder = %v\n", q, r)
    }
	fmt.Printf("Quotient = %v, Remainder = %v\n", q, r)
}

func divide(a int, b int) (int,int,error) {
	var err error
	if b == 0 {
		err = errors.New("This is why education is so important")
		return 0,0,err
	}
	var q int = a / b;
	r := a % b
	return q,r,err
}
```

#### Switch

```go
// General purpose switch statement
switch {
    case err!=nil:
        fmt.Println(err)
    case r == 0:
        fmt.Println("Factor")
    default:
        fmt.Printf("Quotient = %v, Remainder = %v\n", q, r)
}

// Variable based switch statement
switch r{
    case 0:
        fmt.Println("Factor")
    case 1:
        fmt.Println("Close but not quite ~ Viper");
    default:
        fmt.Printf("What is this, a game of some sort?")
}
```

### Slice and Dice

#### Arrays

Data structure which contains a list of elements with the following properties.

* Fixed Length
* Same Type
* Indexable
* Data is stored in contiguous memory locations
* Zero Indexed

```go
// Declaration
var intArr[3] int32 // Initialized by default values [0,0,0]

// Element at index 1
intArr[1]

// Elements 2 and 3
intArr[1:3]

// Immediate initialization
var myArr[4] int32 = [4]int32{1,2,3,4}
myArr := [4]int32{1,2,3,4}
myArr := [...]int32{1,2,3,4}
```

#### Slice

Slice, similar to array, is another data structre whose size is not fixed and contains additional spacec for newer elements.

The length of the slice is the number of elements in the slice.

The capacity of the slice is the amount of space available. (Capacity is larger than slice)

We can use the spread operator `arr...` to `append` multiple values to our slice.
Using the `make` command we can specify the capcity of the slice. This is ideal if we have a rough idea on how much memory we will eventually need to avoid reallocation of memory.

```go
// Initialization: General
var arr[] int8 = []int8{4,5,6}

// Initialization: Make
var arr[] int8 = make(int8[], 3, 10) // Length = 3, Capacity = 10

// Append
arr = append(arr,7) // [4,5,6,7,*,*]

// Length
fmt.Printf("Length = %v Capacity = %v\n", len(arr), cap(arr))

// Spread Operator ... : Append multiple values ot slice
arr = append(arr, arr...) // [4,5,6,7,4,5,6,7,*,*]

```

#### Map

Map is a set of key-value pairs.

When accessing a map it return an optional value, which is `true` or `false` depending on whether the key exists or not.

```go
// Initialization
var myFirstMap map[uint8]string = make(map[uint8]string)

// Initialize immediately
var mySecondMap = map[uint8]string{1: "Beta", 2: "Alpha"}

// Access Map
var firstBoii string = mySecondMap[1] // "Beta"

// Optional value
var _, exists = mySecondMap[3]
if exists == false {
    fmt.Println("I give up!")
}

// Delete value
delete(mySecondMap, 2)
```

#### Loop

We use the `range` keyword within our `for` loop to iterate over maps and arrays.
```go
// Maps
for student_id, name := range(mySecondMap){
    fmt.Println(student_id, name)
}

// Arrays
arr := [3]int8{1,2,3}
for i, v := range(arr){ // i (index) can be ignored so that we iterate over values only
    fmt.Println(student_id, name)
}

// For Loop
for i:=0; i<10; i++ {
    fmt.Println(i)
}
```


### Go and UTF-8

- When are are working with strings in Go, we are working with the underlying representation is an array of bytes. Thus iterating over non-ascii characters with range can give us strange results. A better appraoch would be to cast the string to a rune array.

- Strings are immuateble in Go. `myString[1] = 'b'` is not allowed.

```go
// UTF-8, Runes and Strings
myName1 := "Sunny Béta"         // len = 11 x| because é takes up to 2 bytes
myName1 := []rune("Sunny Béta") // len = 10 :O because rune length is 10
```

#### String Builder

Concatenating characters from string arrays is not efficient.

```go
// Inefficient Strings
var myNewString = []string{"L","u","f","f","i"}
var s string
for _, c:=range myNewString{ 
    s += c // a new string is created everytime
}
fmt.Println(myNewString)
fmt.Println(s)
```

Instead we use Go's builtin string builder.

```go
// String Builder

import "strings"

var myNewString = []string{"L","u","f","f","i"}
var s strings.Builder
for i:=range myNewString{ 
    s.WriteString(myNewString[i]) // a new string is created everytime
}
var cast string = s.String()
fmt.Println(myNewString)
fmt.Println(cast)
```

### Structs

Structs are data strcutures which can contain fields of various types. Field types can be other structs as well.

```go
type myStruct struct {
    field1 string
    field2 uint8
}
```

We can initialize a field with or without the field names and the values be assigned in orders.

```go
var a myStruct = myStruct{50, "Old Value"}
a.field2 = 49
a.field1 = "New Value"
```

Structs defined anonymously are not resuable.

```go
var b = myStruct2 struct {
    hours uint8
    minutes uint8
}{4,20}

// To create a similar variable we need to rewrite the struct definition
```

Functions can be attached to structs as well.

```go
func (o myStruct) prettyPrint() {
    fmt.Println(o.field1, o.field2)
}
```

Now any variable of type `myStruct` will have access to this function.

### Interface

Suppose we have two structs which share or require similar implementatons of the same method, we can instead create an interface.

```go
type myInterface interface {
    mustFunction() string
}
```

Now when the above interface is the type of some parameter in a function, we must ensure that the struct or object passed must have `mustFunction` implemented.

```go
func interfaceTest(o myInterface, b string)(string) {
    return o.mustFunction() + b
}
// Note that o can be any structure with a mustFunction method attached to it.
```

### Pointers

Pointers are special type which store memory location.

```go
var p* int32 // p = nil
var i int32  // i = 0
var p* int32 = new(int32) // memory location with value 0
```

To access a pointer, we use the `*`symbol before the variable for *dereferencing*. If you don't assign a value to a memory address, accessing the value will raise a null pointer exception.

We use the `&` symbol to assign a pointer `p` the address of the variable `i`.

```go
p = &i
```

**Slices contains pointer to the underlying array**

Welcome to C.

## Good Luck

### Goroutines

Goroutines are a way to launch mltiple functions and have them execute concurrently.

To run a line of code asynchornously, we simply add `go` before the statement.

```go
func main(){
	t0 := time.Now()
	for i:=0; i<5; i++ {
		go dbcall(i)
	}
	fmt.Println("Total Time: ", time.Since(t0))
}

func dbcall(i int) { // function to simulate a db call
	var delay float32 = rand.Float32()*2000
	time.Sleep(time.Duration(delay) * time.Millisecond)
	fmt.Printf("The DB call is %v complete.\n", i)

}
```

#### Wait Groups

*Wait Groups* are counters which keeps track of the number of concurrent tasks. This avoids your to stop early before the async tasks are completed.


```go
package main

import (
	"fmt"
	"sync"
	"time"
)
var wg = sync.WaitGroup{} // Initialize a wait group

func main(){
	t0 := time.Now()
	for i:=0; i<5; i++ {
		wg.Add(1) // Increment Counter by 1
		go dbcall(i)
	}
	wg.Wait() // Waits for all tasks to be completed before going to the next line.
	fmt.Println("Total Time: ", time.Since(t0))
}

func dbcall(i int) {
	var delay float32 = 2000
	time.Sleep(time.Duration(delay) * time.Millisecond)
	fmt.Printf("The DB call is %v complete.\n", i)
	wg.Done() // Decrements counter by 1
}
```


#### Mutex

*What happens when a variable is being changed by multiple threads at the same time? This can lead to errors, corrupt data or imcomplete execution of the tasks.*

Mutex is short for mutual exclusion. It has two main methods: lock and unlock.

Whenever a goroutine reaches a lock method, it performs a check whether a lock has been set (locked) by another goroutine. If yes, then this goroutine waits until the lock has been released (unlocoked) and sets the lock itself.


```go
package main

import (
	"fmt"
	"sync"
	"time"
)


var wg = sync.WaitGroup{}
var m = sync.Mutex{}
var dbData = []string{"Alice","Bob","Charlie","David","Eve"}
var resData = []string{}

func main(){
	t0 := time.Now()
	for i:=0; i<len(dbData); i++ {
		wg.Add(1)
		go dbcall(i)
	}
	wg.Wait()
	fmt.Println("Total Time: ", time.Since(t0))
	fmt.Println(resData)
}

func dbcall(i int) {
	var delay float32 = 2000
	time.Sleep(time.Duration(delay) * time.Millisecond)
	fmt.Println("The DB call for ", i, " ", dbData[i], " is complete.")
	m.Lock()
	resData = append(resData, dbData[i])
	m.Unlock()
	wg.Done()
}
```

This lock is known as a *full lock*. Go also provides us with something known as a *read lock* and *read unlock*. This lock allows multiple goroutines to read from the same memory address only blocking potential writes.

```go
func log(i int) {
	m.RLock()
	fmt.Println("Reading Value ", dbData[i])
	m.RUnlock()
}
```


### Channels

Channels are a way to enable goroutines and pass wround information

* Hold data
* Thread Safe : Avoids data race
* Listen when data is added

#### Unbuffered Channel

```go

// Declare a channel
var c = make(chan int)

// Add value to a channel
c <- 1

// Pop value from a channel
<-c
```

When we write to an unbuffered channel, the code will block until something else reads from it. 

```go
package main

import "fmt"

func main(){
    var c = make(chan int)
    go process(c)
    fmt.Prinln(<-c)
    fmt.Prinln(<-c)
    fmt.Prinln(<-c)
    fmt.Prinln(<-c)
    fmt.Prinln(<-c)
}

func process(c chan int) {
    for i:=0; i<5; i++ {
        c <- i
    }
}
```

The above code will add a single value to the channel, and will now wait for someone to read from it. The `range` keyword works nicely wih channels and we can rewrite the above as follows.

```go
package main

import "fmt"

func main(){
	var c = make(chan int)
	go process(c)
	for i:=range c{
		fmt.Println(i)
	}
}

func process(c chan int) {
	defer close(c) // defer means do this before ending the function
	for i:=0; i<5; i++ {
		c <- i
	}
}
```

Note that we have to close the channel before ending the function because the for loop in main after the final iteration in process sits on top of the loop, waiting for another value to enter the channel, casuing a deadlock.

Closing the channel notifies the method that no more values should be expected.

 
#### Buffered Channel

In an unbuffered channel, the process stays active until the main function completes its tasks. Since there is no need for this, we can create an unbuffered channel allowing the process function to exit quickly.

```go
// Initialize Unbuffered Channel
var c = make(chan c int, 5)
```

Now the process function can exit immediately and the main function can finish the execution of its program.

```go
package main

import "fmt"

func main(){
	var c = make(chan int, 5)
	go process(c)
	for i:=range c{
		fmt.Println(i)
        time.Sleep(1*time.Seconds)
	}
}

func process(c chan int) {
	defer close(c)
	for i:=0; i<5; i++ {
		c <- i
	}
}
```

#### Select

The select statement is a switch statement for channels.

```go
select{
    case a:= <-channelA:
        fmt.Println("A message was received")
    case b:= <-channelB:
        fmt.Println("B message was received")
}
```


### Generics

If we have the same underlying logic for a function with different types, instead of writing them separately, we can use *generics* to write the function once, so that it works for all cases.

```go
package main

import "fmt"

var arr1 = []int8{1,23,4,56}
var arr2 = []float32{1.23, 45.6, 0.789}

func main(){
	fmt.Println(addArrayElements(arr1))
	fmt.Println(addArrayElements(arr2))
}

func addArrayElements[T int8|float32](nums []T) T {
	var sum T
	for _,num := range nums{
		sum += num
	}
	return sum
}
```

TO BE CONTINUED.
