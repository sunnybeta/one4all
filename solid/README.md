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


