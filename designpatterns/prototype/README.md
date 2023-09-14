# Prototype

### Problem

We want objects of our class to be copied perfectly (including private
variables) into new objects of the same class. Writing a function which does
this is one solution, but we wouldn't want to write it for every similar class.

### Solution

1. **Abstract Parent Class** Write an abstract parent class which can be
extended into the class which requies the cloning functionality with a `clone`
method and two constructors: empty, same object parameter

2. **Clone Functions** Implement the `clone` method in the child class.


```java
/* Main */
class Proto {
	public static void main(String[] args) {
		System.out.println("Prototype Design Pattern");
		ChildItem pi1 = new ChildItem();
		pi1.height = 5.9f;
		pi1.name = "Beta";
		pi1.weight = 40;
		ChildItem pi2 = (ChildItem)pi1.clone();
		System.out.println(pi2.height);
		System.out.println(pi2.name);
		System.out.println(pi2.weight);
	}
}

/* Abstract Parent Class */
abstract class ParentItem {
	public float height;
	public String name;

	public ParentItem() {
	}

	public ParentItem(ParentItem target) {
		if (target != null) {
			this.height = target.height;
			this.name = target.name;
		}
	}

	public abstract ParentItem clone();
}

/* Child class extends Parent class */
class ChildItem extends ParentItem {
	public int weight;

	public ChildItem() {
	}

	public ChildItem(ChildItem target) {
		super(target);
		if (target != null) {
			this.weight = target.weight;
		}
	}

	@Override
	public ParentItem clone() {
		return new ChildItem(this);
	}
}
```
