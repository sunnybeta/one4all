# Observer Pattern

## Problem

You've logged into multiple devices for an application. When a message is received, we have to send a notification to all the devices.
How do we notify multiple stake holders based on a state change?

## Solution

```java
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;

public class Observer {
	public static void main(String[] args) {
		User u1 = new User("usr_1", "Alice");
		User u2 = new User("usr_2", "Bob");
		User u3 = new User("usr_3", "Charlie");

		Subject s = new Subject();
		s.registerUser(u1);
		s.notifyUsers();
		s.registerUser(u2);
		s.notifyUsers();
		s.registerUser(u2);
		s.unregisterUser(u3);
		s.registerUser(u3);
		s.notifyUsers();
		s.unregisterUser(u1);
		s.notifyUsers();

	}
}

class User {
	public String id;
	public String name;

	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}
}

class Subject {
	ArrayList<User> userCollection;

	public Subject() {
 		userCollection = new ArrayList<User>();
	}

	public void registerUser(User user) {
		if (userCollection.stream().filter(x -> x.id == user.id).collect(Collectors.toSet()).size() > 0) {
			System.out.println("--- EXISTS ---");
			System.out.println("User " + user.id + ":" + user.name + " already exists!");
			System.out.println("--- END ---");
		}
		else {
			userCollection.add(user);
		}
	}

	public void unregisterUser(User user) {
		for (int i = 0; i < userCollection.size(); i++) {
			if (userCollection.get(i).id == user.id) {
				userCollection.remove(i);
				System.out.println("--- UNREG ---");
				break;
			}
		}
	}

	public void notifyUsers() {
		System.out.println("--- NTF ---");
		for (User user: userCollection) {
			System.out.println(user.id + " " + user.name + " has been notified!");
		}
		System.out.println("--- END ---");
	}
}
```

