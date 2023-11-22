# SOLID

## Single Responsibility Principle

- One class should have only one responsilibilty and only one reason to change
- Any software entities should have a reason to change by only one actor 
- Software entities should cater changes to particular stakeholder

Consider the below example.

```java
public class NonSRP {
	public static void main(String[] args) {
		Employee e = new Employee("Sunny", 21);
		e.save();
	}
}

public class Employee {
	private String name;
	private int age;

	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}

	private int getRegularHours() {
		// A change here breaks calculateSalary
		return 8;
	}

	public int calculateHours() {
		return getRegularHours() - 2;
	};

	public float calculateSalary() {
		return calculateHours() * 65f;
	}

	public void save() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Salary: " + calculateSalary());
	}
}
```

A better approach would be to split the classes by actors and the methods they can change.

```java
public class SRP {
	public static void main(String[] args) {
		Actor1 a1 = new Actor1("Sunny", 31);
		a1.save();
		Actor2 a2 = new Actor2("Forever", 21);
		a2.save();
	}
}

public abstract class EmployeeBase {
	private String name;
	private int age;

	public EmployeeBase(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void save() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Salary: " + calculateSalary());
		System.out.println();
	}

	protected abstract int getRegularHours();
	abstract int calculateHours();
	abstract float calculateSalary();
}

public class Actor1 extends EmployeeBase {
	public Actor1(String name, int age) {
		super(name, age);
	}

	protected int getRegularHours() {
		return 8;
	}

	public int calculateHours() {
		return getRegularHours() - 2;
	};

	public float calculateSalary() {
		return calculateHours() * 65f;
	}
}

public class Actor2 extends EmployeeBase {
	public Actor2(String name, int age) {
		super(name, age);
	}

	protected int getRegularHours() {
		return 6;
	}

	public int calculateHours() {
		return getRegularHours() - 2;
	};

	public float calculateSalary() {
		return calculateHours() * 105f;
	}
}
```

## Open-Closed Principle

- Software entities sholuld be open for extension but closed for modification
- In the below example, we can easily add a `Square` class which extends the `Shape`
class and calculates the area after overriding the `getArea()` method.

```java
public class OpenClosed {
	public static void main(String[] args) {
		Circle c = new Circle(4);
		Rectangle r = new Rectangle(4,9);
		c.displayArea();
		r.displayArea();
	}
}

public abstract class Shape {
	abstract double getArea();
	abstract void displayArea();

}

public class Circle extends Shape{
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return 3.14*radius * radius;
	}

	@Override
	void displayArea() {
		System.out.println(String.format("The area of the circle of radius %.2f is %.2f", radius, getArea()));
	}
}

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

	@Override
	void displayArea() {
		System.out.println(String.format("The area of the rectangle of height %.2f and width %.2f is %.2f", height, width, getArea()));
	}
}
```


## Liskov Substitution Principle

Let f(x) be a property of provable about objects x of type T. Then f(y) should be true for objects y of type S where S is a subtype of T.

*If a function takes an instance of a class, then the same function should also be able to take an instance of the derived class.*

- This principle teaches you to inherit properly
- If inheritance is correct, then LSP is not violated. If LSP is violated, then inheritance is incorrect and code needs to be refactored.

```java
public class Liskov {
	public static void main(String[] args) {
		Rectangle r = new Rectangle(8,9);
		Square s = new Square(11);

		Quadrilateral q1 = new Quadrilateral(r);
		Quadrilateral q2 = new Quadrilateral(s);

		q1.desc();
		q2.desc();
	}
}

public class Rectangle {
	private int length;
	private int breadth;

	public Rectangle(int l, int b) {
		length = l;
		breadth = b;
	}

	public int area() {
		return length * breadth;
	}
	
	public int perimeter() {
		return 2*(length + breadth);
	}
}

public class Square extends Rectangle {
	private int size;

	public Square(int l) {
		super(l, l);
	}
}

public class Quadrilateral {
	private Rectangle rect;

	public Quadrilateral(Rectangle rect) {
		this.rect = rect;
	}

	public void desc() {
		System.out.println(String.format("The area of the quadrilateral is %d\n and perimeter is %d.", rect.area(), rect.perimeter()));
	}
}
```


## Interface Segregation Principle

- No code should be forced to depend on function which it does not use.
- Design interfaces in such a way that the classes that implement those interfaces do not have unused functions.

Consider the following interface.

```java
public class NonISP {
	public static void main(String[] args) {
	}
}

public interface IStore {
	public void save();
	public void delete();
	public void fetch();
	public void addKey();
	public void deleteKey();
	public void updateKey();
}

public class DBStore implements IStore {
	public void save() {}
	public void delete() {}
	public void fetch() {}
	public void addKey() {};
	public void deleteKey() {};
	public void updateKey() {};
}

public class CacheStore implements IStore {
	public void save() {}
	public void delete() {}
	public void fetch() {}
	public void addKey() {};
	public void deleteKey() {};
	public void updateKey() {};
}
```

We need to implement all the six functions even when they are not needed. The above code can be refactored as follows.

```java
public class ISP {
	public static void main(String[] args) {
	}
}

public interface DBStoreInterface {
	public void save();
	public void delete();
	public void fetch();
}

public interface CacheStoreInterface {
	public void addKey();
	public void deleteKey();
	public void updateKey();
}

public class DBStore implements DBStoreInterface {
	public void save() {}
	public void delete() {}
	public void fetch() {}
}

public class CacheStore implements CacheStoreInterface {
	public void addKey() {};
	public void deleteKey() {};
	public void updateKey() {};
}
```


## Dependency Inversion Principle

- *Dependency Inversion, Injection, Inversion Control are all diffent.*
- *Principle of Dependency Inversion and  Application of Dependency Inversion also mean different things.*
 
- High level modules should not depend on low level modules. Both should depend on abstractions.
- Abstraction should not depend on implementation. Implementation should depend on abstraction.


- Suppose `class A` is dependent on `class B`, then we can invert dependency by introducing an `interface B`.
Now, `class A` depends on `interface B` and `class B` depends on `interface B`.

- Prevents mocking of dependencies during testing.

```java
public class DependencyInversion {
	public static void main(String[] args) {
		User u = new User("Beta");
		u.printName();
		u.store();
	}
}

public class User {
	private String name;

	public User(String name) {
		this.name = name;
	}

	public void printName() {
		System.out.println("User ID: usr_" + name.toLowerCase());
	}

	public void store() {
		Store fancyStore = new FancyStore();
		fancyStore.save(name);
	}
}

public interface Store {
	public void save(String name);
}

public class FancyStore implements Store {
	public FancyStore() {}

	public void save(String name) {
		System.out.println("Data Saved: usr_" + name);
	}
}
```
