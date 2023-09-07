package adapter;

import java.util.ArrayList;
import java.util.List;


public class StudentClient {
	public List<Student> getStudentList() {
		List<Student> students = new ArrayList<>();
		CollegeStudent collegeStudent = new CollegeStudent("a", 23);
		SchoolStudent schoolStudent = new SchoolStudent("b", 23);
		students.add(collegeStudent);
		students.add(new SchoolStudentAdapter(schoolStudent));
		return students;
	}
}
