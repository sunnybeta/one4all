# Adapter Design Pattern

### Problem

We have code which does not behave in a certain manner, is incomptible, or some legacy code with a different API.
We would like this class / API to work in a certain way, implement particular functions and become compatible with the current practices.

### Solution

1. **Abstract the expected behaviour** Make sure that the current or required impementation is inherited from a parent abstract class or interface.

2. **Write an Adapter Class** Write a new class `ObjectAdapter` which take the unwwanted implementation as argument and then implement the new interface.

3. **Update Code** Whenever you receive an object from the ill-behaved class, pass it through the adapter to make it well-behaved.

```java
import java.util.ArrayList;
import java.util.List;

public class Adapter {
	public static void main(String[] args) {
		/* Test Data */
		List<Student> students = new ArrayList<>();
		CollegeStudent collegeStudent = new CollegeStudent("Doma", 123);
		SchoolStudent schoolStudent = new SchoolStudent("Kokushibo", 223);
		students.add(collegeStudent);
		students.add(new SchoolStudentAdapter(schoolStudent));

		/* Main */
		for (Student student: students) {
			System.out.println("Name: " + student.getName() + " ; " + "Age: " + student.getAge());
		}
	}
}


/* We have a `Student` interface */
public interface Student {
	public String getName();
	public int getAge();
}


/* The `CollegeStudent` class implements the `Student` interface correctly */
class CollegeStudent implements Student {
	private String name;
	private int age;
	
	public CollegeStudent(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public int getAge() {
		return age;
	}
}


/* We have another implementation of `Student` object via the `SchoolStudent` class */
class SchoolStudent  {
	private String fullname;
	private int umar;
	
	public SchoolStudent(String fullname, int umar) {
		this.fullname = fullname;
		this.umar = umar;
	}

	public String getFullName() {
		return fullname;
	}
	
	public int getUmar() {
		return umar;
	}
}


/* We can write an *adapter class* which implemnts the `Student` class through the incompatible `SchoolStudent` class */
class SchoolStudentAdapter implements Student {
	private SchoolStudent schoolStudent;

	public SchoolStudentAdapter(SchoolStudent schoolStudent) {
		this.schoolStudent = schoolStudent;
	}

	@Override
	public String getName() {
		return schoolStudent.getFullName();
	}

	@Override
	public int getAge() {
		return schoolStudent.getUmar();
	}
}

/* After passing the `SchoolStudent` through an adapter, the student is now well behaved. */
```
