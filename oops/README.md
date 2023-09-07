# Object-Oriented Programming System


## Inheritance

- Inheritance is the concept in OOPs in which one class inherits the attributes and methods of another class. The class whose properties and methods are inherited is known as the Parent class. And the class that inherits the properties from the parent class is the Child class.
- Establish relationship between classes
- `class A` *is-a* `class B`

## Polymorphism

- Polymorphism is the ability of to take on different forms or behave in different ways depending on the context in which they are used.
- Polymorphism is actually an implementation of inheritance
- Java uses operator overloading and overriding to implement polymorphism concepts

### Overloading

When methods with the same name is declared with different signatures, this is known as function overloading.

``` java
// Example of function overloading
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

When a method in the childfrom the parent class with the same name and signature is inherited and modified in the child class, this is known as function overriding.


## Abstraction

Property by virtue of which only essential details are displayed to the user.
Process of identifying the required characteristics and ignore the rest.
Java uses `abstract classes` and `interfaces` to implement the concept of encapsulation.


## Encapsulation

The meaning of Encapsulation, is to make sure that _sensitive_ data is hidden from users.
To achieve this, you must:

- declare class variables/attributes as private
- provide public get and set methods to access and update the value of a private variable

