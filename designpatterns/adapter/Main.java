package adapter;

public class Main {
	public static void main(String[] args) {
		StudentClient client = new StudentClient();
		for (Student student: client.getStudentList()) {
			System.out.println("Name: " + student.getName() + " :: " + "Age: " + student.getAge());
		}
	}
}
