package adapter;

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
