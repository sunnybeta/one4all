# Design Patterns

## Adapter

You have to connect two interfaces which are not compatible with each other (for example, when legacy code needs to be integrated with new code).


## Factory Factory

- Creational Design Pattern
- Userful for creation of objects that fall under same categorization but still have different properties.
- Hleps in hiding complexity of object creation of various types

## Abstract Faoctory Method

- Creational Design Pattern
- A factory of factory pattern
- Great for abstraction and family of similar objects
- Loose coupling between client and actual / concrete code
- All classes follow Single Responsibility Principle and Open Closed Principle
- Code becomes complx
- Nested Pattern

## Singleton

- When you only need on instance of a class is needed (Shared Resource).
- Access is given to that instance from the whole application
- Example: DB Connection, Logger Instance
- We can define a global variable but every resource needs to ensure that the global variable is not overwritten and thus needs to be protected
- Singleton class should never accept a parameter
- Thread safety has to be ensured
- Hard for unit testing

**Eager Loading**: Instance is already initialized as soon as the application is up

```java
// Basic Implementation; NOT Thread Safe; Eager Loading;
public class Singleton {
    private static obj instance = new Singleton();
    private void Singleton() {
    }
    public void getInstance() {
        return instance;
    }
}
```

**Lazy Loading**: Instance is initialized only when App module calls for it.

```java
// Thread Safe; Lazy Loading
public class Singleton {
    private static obj instance = null;
    private void Singleton() {
    }
    public void getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

## Facade

- Structural Design Pattern: refactoring pattern, can be applied to both low and high level components
- Facade Class -> Hidden Systems : Instead of calling subsystems it simply calls the facade class
- Simplest Structural Design Pattern
- Good to think about API design

