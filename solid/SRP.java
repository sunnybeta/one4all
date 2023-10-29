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

