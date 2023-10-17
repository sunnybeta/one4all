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

	@Override
	public void details() {
		System.out.println(fname + " " + lname + " :: " + salary);
	}
}
