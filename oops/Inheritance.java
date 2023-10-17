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
