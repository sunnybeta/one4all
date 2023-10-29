public class DependencyInversion {
	public static void main(String[] args) {
		User u = new User("Beta");
		u.printName();
		u.store();
	}
}


public class User {
	private String name;

	public User(String name) {
		this.name = name;
	}

	public void printName() {
		System.out.println("User ID: usr_" + name.toLowerCase());
	}

	public void store() {
		Store fancyStore = new FancyStore();
		fancyStore.save(name);
	}
}


public interface Store {
	public void save(String name);
}


public class FancyStore implements Store {
	public FancyStore() {}

	public void save(String name) {
		System.out.println("Data Saved: usr_" + name);
	}
}
