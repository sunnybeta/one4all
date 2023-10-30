public class ISP {
	public static void main(String[] args) {
	}
}

public interface DBStoreInterface {
	public void save();
	public void delete();
	public void fetch();
}

public interface CacheStoreInterface {
	public void addKey();
	public void deleteKey();
	public void updateKey();
}

public class DBStore implements DBStoreInterface {
	public void save() {}
	public void delete() {}
	public void fetch() {}
}

public class CacheStore implements CacheStoreInterface {
	public void addKey() {};
	public void deleteKey() {};
	public void updateKey() {};
}
