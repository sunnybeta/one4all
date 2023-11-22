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
