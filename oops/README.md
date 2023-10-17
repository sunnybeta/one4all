# Object-Oriented Programming System


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
- Languages use operator overloading and overriding to implement polymorphism concepts


### Overloading

- When methods with the same name is declared with different signatures, this is known as *function overloading*.

``` java
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

When a method in the childfrom the parent class with the same name and signature is inherited and modified in the child class, this is known as *function overriding*.

```java
class Inheritance {
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
- Languages uses `abstract classes` and `interfaces` to implement the concept of encapsulation.


```java
abstract class Compute{ 
  abstract void add(); 
  abstract void multiply(); 
  abstract void divide(); 
  abstract void modulo(); 
} 
```

- Any class which now impleemnts the `Compute` class must implement the `add`, `multiply`, `divide` and `modulo` functions.


## Encapsulation

- Encapsulation ensures that *sensitive* data is hidden from users.
- Declare class variables/attributes as private
- Provide public get and set methods to access and update the value of a private variable
