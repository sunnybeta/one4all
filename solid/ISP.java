public class ISP {
	public static void main(String[] args) {
	}
}

public interface DBStoreInterface {
	public void save();
	public void delete();
	public void fetch();
}

public interface CacheStoreIntefrace {
	public void addKey();
	public void deleteKey();
	public void updateKey();
}

public class DBStore implements DBStoreInterface {
	@Override
	public void save() {}
	@Override
	public void delete() {}
	@Override
	public void fetch() {}
}

public class CacheStore implements CacheStoreInterface {
	@Override
	public void addKey() {};
	@Override
	public void deleteKey() {};
	@Override
	public void updateKey() {};
}
