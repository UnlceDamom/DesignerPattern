package singleton;

/**
 * 懒汉式线程安全的模板
 * [线程安全，效率低不推荐使用](加锁)
 */
public class Singleton {
    private static Singleton instance = null;
    
    private Singleton() {
    }
    
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
