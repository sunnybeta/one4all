# Object-Oriented Programming System

*SOURCE*

![SudoCode](https://www.youtube.com/@sudocode)

![GeeksForGeeks](https://www.geeksforgeeks.org)

## Inheritance

- Inheritance is the concept in OOPs in which one class inherits the attributes and methods of another class.
- The class whose properties and methods are inherited is known as the *Parent class* or *Superclass*. And the class that inherits the properties from the parent class is the *Child class* or *Subclass*.
- Inheritance establishes a *is-a*  or *has-a* relation ship between two classes: `class A` *is-a* `class B`

```java
class Inheritance {
	public static void main(String[] args) {
		Person p = new Person("Sunny", "Beta");
		p.fullname();
		Employee e = new Employee("Cloudy", "Alpha", 10_00_000f);
		e.fullname();
	}
}

class Person {
	public String fname;
	public String lname;

	public Person(String firstName, String lastName) {
		fname = firstName;
		lname = lastName;
	}

	public void fullname() {
		System.out.println(fname + " " + lname);
	}
}

class Employee extends Person {
	float salary;

	public Employee(String firstName, String lastName, Float salaryAmount) {
		super(firstName, lastName);
		salary = salaryAmount;
	}
}
```

## Polymorphism

- Polymorphism is the ability of to take on different forms or behave in different ways depending on the context in which they are used.
- Programming Languages use operator overloading and overriding to implement polymorphism concepts.


### Overloading

When methods with the same name is declared with different signatures, this is known as *function overloading*.

```java
public class Area {
    public static void main(String[] args) {
        name("Sunny", "Beta");
        name("Sunny Beta");
    }

    public static void name(String firstname, String lastname) {
        System.out.println("First Name: " + firstname + ", Last Name: " + lastname);
    }

    public static void name(String fullname) {
        System.out.println("Full Name: " + fullname);
    }
}
```

### Overriding

When a method in the subclass with the same name and signature as its method from the superclass is inherited and modified in the child class, this is known as *function overriding*.

```java
class Overriding {
	public static void main(String[] args) {
		Person p = new Person("Sunny", "Beta");
		Employee e = new Employee("Cloudy", "Alpha", 10_00_000f);
		p.details();
		e.details();
	}
}


class Person {
	public String fname;
	public String lname;

	public Person(String firstName, String lastName) {
		fname = firstName;
		lname = lastName;
	}

	public void details() {
		System.out.println(fname + " " + lname);
	}
}


class Employee extends Person {
	float salary;

	public Employee(String firstName, String lastName, Float salaryAmount) {
		super(firstName, lastName);
		salary = salaryAmount;
	}

	public void details() {
		System.out.println(fname + " " + lname + " :: " + salary);
	}
}
```

## Abstraction

- Process of identifying the required characteristics and ignore the rest.
- Property by virtue of which only essential details are displayed.
- Languages uses `abstract` classes and `interface`s to implement the concept of encapsulation.


```java
class Abstraction {
	public static void main(String[] args) {
		Tech tech = new Tech();
		tech.add(1,2);
		tech.multiply(37,39);
		System.out.println(tech.divide(666664,166666));
		tech.modulo(1829,18);
		System.out.println(tech.power(6,6));
	}
}

public abstract class Compute {
	abstract void add(int a,int b);
	abstract void multiply(int a, int b);
	abstract float divide(int a,int b);
	abstract void modulo(int a,int b);
	abstract double power(int a, int b);
}

public class Tech extends Compute {

	public Tech() {}

	void add(int a, int b) {
		System.out.println(a + b);
	}

	void multiply(int a, int b) {
		System.out.println(a * b);
	}

	float divide(int a, int b) {
		return a / (float)b;
	}

	void modulo(int a, int b) {
		while (a > 0) {
			a -= b;
		}
		a += b;
		System.out.println(a);
	}

	@Override
	double power(int a, int b) {
		double ans = 1;
		while (b-- > 0) {
			ans *= a;
		}
		return ans;
	}
}
```


## Encapsulation

- Encapsulation ensures that *sensitive* data is hidden from users.
- Declare class variables/attributes and methods as `private` or `protected`
- Provide public *getter* and *setter* methods to access and update the value of a private variable


```java
public class Encapsulation {
	public static void main(String[] args) {
		Circle c = new Circle(10);
		System.out.println("Circle's Old Radius = " + c.getRadius());
		c.setRadius(11);
		System.out.println("Circle's New Radius = " + c.getRadius());
	}
}

class Circle {
	private int radius;

	public Circle() {
		radius = 1;
	};

	public Circle(int radius) {
		this.radius = radius;
	};

	public double Area() {
		return 22.0/7 * radius * radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int r) {
		radius = r;
	}
}
```
