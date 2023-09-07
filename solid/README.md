# SOLID

## Single Responsibility Principle

- One class should have only one responsilibilty and only one reason to change
- Any software entities should have a reason to change by only one actor. 
- Software entities should cater changes to particular stakeholder

## Open-Closed Principle

- Software entities sholuld be open for extension but closed for modification
- In the below example, we can easily add a `Square` class which extends the `Shape`
class and calculates the area after overriding the `getArea()` method.

```java
// Abstract Shape Class
public abstract class Shape {
    abstract double getArea();
}
```

```java
// Circle
public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return 3.14*this.radius * this.radius;
    }
}
```

```java
// Rectangle
public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double getArea() {
        return this.width * this.height;
    }
}
```

```java
// Area (Main)
public class Area {
    public static void main(String[] args) {
        Circle c = new Circle(4);
        Rectangle r = new Rectangle(4,9);
        System.out.println(c.getArea());
        System.out.println(r.getArea());
    }
}
```


## Liskov Substitution Principle

Let f(x) be a property of provable about objects x of type T. Then f(y) should be true for objects y of type S where S is a subtype of T.
*If a function takes an instance of a class, then the same function should also be able to take an instance of the derived class.*
- This principle teaches you to inherit properly
- If inheritance is correct, then LSP is not violated. If LSP is violated, then inheritance is incorrect and code needs to be refactored.


## Iterface Segregation Principle

- No ocde should be forced to depend on function which it does not use.
- Design interfaces in such a way that the classes that implement those interfaces do not have unused functions.


## Dependency Inversion Principle

- _Dependency Inversion, Injection, Inversion Control are all diffent._
- _Principle of Dependency Inversion Application of Dependency Inversion also mean different things._
 
- High level modules should not depend on low level modules. Both should depend on abstraction
- Abstraction should not depend on implementation. Implementation should depend on abstraction.


- Suppose `class A` is dependent on `class B`, then we can invert dependency by introductin an `interface B`.
Now, `class A` depends on `interface B` and `class B` depends on `interface B`.

- Prevents mocking of dependencies during testing.
