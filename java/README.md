# Java Fundamentals

## Annotations

Annotations are metadata / supplemntal information into your Java code.
These do not affect the program directly but can be processed by the compiler or at runtime.

```java
// This annotation suppresses unused variables warnings
@SuppressWarnings("unused")
Object obj = new Obj("abc")
```

### Custom Annotation

`@Target(...)` annotation specifies which type of entity can e annotated with `@MyImportantAnnotation`.
`@Retention(...)` annotation specifies the availabilty of the annotation during the processing of the code.
`@FunctionalInterface` annotation tells the compiler that an interface has exactly one abstract method

- **RetentionPolicy.RUNTIME**: Available during the entire runtime of the application
- **RetentionPolicy.SOURCE**: Java gets rid of code before compiling
- **RetentionPolicy.CLASS**: Available during compilation and removed before runtime

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

// Target
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyImportantAnnotation {
    // Uncommenting the belowline will tell the annotation to support the integer paramter
    // int times() default 4;
}
```

### Accessing the annotation

```java
Object obj = new Obj("abc")

if (obj.getClass().isAnnotationPresent(MyImportantAnnotation.class)) {
    MyImportantAnnotation annotation = obj.getClass().getAnnotation(RunImmediately.class);
    for (int i = 0; i < annotation.times(); i++) {
        System.out.print("This object's class is very important and is annotated");
    }
}
```


## Lambda Expressions

```java
@FunctionalInterface
public interface OneMethodInterace {
    void print(String a, String b);
}
```

```java
(prefix, suffix) -> prefix + " WORD " + suffix;
```

_Lambdas_ can only be used in the context of a functional interface.
It is a shortcut to implementing a functional interface and allows you to treat interface as a parameter.


## Anonymous Inner Classes

Anonymous Inner Classes are used if we ever want to create only one instance of a class or interface in some specific part of the application.
These classes have no names and may have more than one methods defined in it.

```java
// Animal.java
public class Animal {
    public void makeNoise() {
        System.out.println("wee woo");
    }
}
```

```java
// AnonymousInnerClasses.java
public clas AnonymousInnerClasses {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        myAnimal.makeNoise();

        // anonymous subclass
        Animal bigfoot = new Animal() {
            public void makeNoise() {
                System.out.println("Groaijfdoinqleknal");
            }
        };
        bigfoot.makeNouse();

        // anonymous interface
        Runnable myAnonymouseRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("I'm an anony animal");
            }
        };
        myAnonymousRunnable.run();
    }
}
```

## Multithreading

- Multithreading is the ability to execute multiple different paths of code at the same time.
- `thread.start()` starts running a particular thread
- `thread.join()` waits for a thread to complete
- `thread.isAlive()` returns a boolean and checks if the thread is currently still running.


```java
public class Multithreading {
    public static void main(String[] args) {
        MultithreadThing myThread1 = new MultiThreadThing(1);
        MultithreadThing myThread2 = new MultiThreadThing(2);
        myThread1.start(); // special method to start multithreading
        myThread2.start();
    }
}
```


```java
public class MultithreadThing extends Thread {
    private int threadNumner;

    public MultithreadThing(int threadNumber) {
        this.threadNumber = threadNumber;
    } 

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + " printed by thread number " + threadNumber);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
```

- Even if a thread crashes, the other thread keeps running.

```java
// Alternate method where you can implement the Runnable interface
public class MultithreadThing implements Runnable {
    private int threadNumner;

    public MultithreadThing(int threadNumber) {
        this.threadNumber = threadNumber;
    } 

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + " printed by thread number " + threadNumber);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
```

- Implementing Runnable is better because you cannot extend multiple classes.


## Generics

Generics help you implement the exact same logic for different data types.

```java
// generic class Printer.java
public class Printer<T> {
    T toPrint;

    public Printer(T toPrint) {
        this.toPrint = toPrint;
    }

    public void print() {
        System.out.prinln(toPrint);
    }
}
```


```java
// main.java
public class GenericPrinter {
    public static void main(String[] args) {
        Printer<Integer> printer = new Printer<>(32);
        print.print();
        Printer<Double> doublePrinter = new Printer<>(32.14);
        print.print();
    }
}
```

```java
// generic class with extension Printer.java
// User <?> if you don't know the type 
public class Printer<T extends Vehicle & Animal> { // keep the class name first if it does exten a class
    T toPrint;

    public Printer(T toPrint) {
        this.toPrint = toPrint;
    }

    public void print() {
        toPrint.switchEngineOn(); // since T extends Vehicle, we have its methods available
        System.out.prinln(toPrint);
    }
}
```


## Streaming API

Stream API is a way to process collection of objects enabling us to perform operations like filtering, mapping, reducing and sorting.

- Stream takes input from collections, arrays or I/O channesl
- Each intermediate operation is lazily executed and returns a stream as a result.

### Intermediate Operation

#### Map

Map method is used to return a stream consisting of the results of applying the given functions to the elements of this stream.

```java
List nums = Arrays.asList(2,3,4,5);
List double = nums.stream().map(x -> x*2).collect(Collectors.toList());
```

#### Filter

Filter method is used to select elements based on certain conditions.

```java
List nums = Arrays.asList(2,3,4,5);
List double = nums.stream().filter(x -> x%2 == 1).collect(Collectors.toList());
```

#### Sorted

```java
List nums = Arrays.asList(5,4,3,2);
List double = nums.stream().sorted().collect(Collectors.toList());
```

### Terminate Operation

#### Collect

The collect method returns the result of the intermediate operations.

```java
List nums = Arrays.asList(5,4,3,2);
List double = nums.stream().map(x -> x*x).collect(Collectors.toSet());
```

#### For Each

This method is used to iterate through every element of the stream.

```java
List nums = Arrays.asList(5,4,3,2);
List double = nums.stream().map(x->x+1).forEach(y->System.out.println(y));
```

#### Reduce

Reduce method is used to reduce the stream to a single value.

```java
List nums = Arrays.asList(5,4,3,2);
int even = nums.stream().reduce(0, (ans, i) -> ans + i);
```


