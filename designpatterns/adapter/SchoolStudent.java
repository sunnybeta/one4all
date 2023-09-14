package adapter;

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
