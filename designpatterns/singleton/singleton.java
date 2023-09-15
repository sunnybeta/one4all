/*
 * Basic Implementation
 * NOT Thread Safe
 * Eager Loading
 */
public class SingletonEager {
    private static obj instance = new SingletonEager();
    private void SingletonEager() {
    }
    public void getInstance() {
        return instance;
    }
}

/* Thread Safe
 * Lazy Loading
 */
public class SingletonLazy {
    private static obj instance = null;
    private void SingletonLazy() {
    }
    public void getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
