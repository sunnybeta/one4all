public class NonISP {
	public static void main(String[] args) {
	}
}

public interface IStore {
	public void save();
	public void delete();
	public void fetch();
	public void addKey();
	public void deleteKey();
	public void updateKey();
}

public class DBStore implements IStore {
	public void save() {}
	public void delete() {}
	public void fetch() {}
	public void addKey() {};
	public void deleteKey() {};
	public void updateKey() {};
}

public class CacheStore implements IStore {
	public void save() {}
	public void delete() {}
	public void fetch() {}
	public void addKey() {};
	public void deleteKey() {};
	public void updateKey() {};
}
