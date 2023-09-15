# Singleton

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
