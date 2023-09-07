package adapter;

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
