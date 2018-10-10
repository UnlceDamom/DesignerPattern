package singleton;

/**
 * 单例模式懒汉式模板   对象锁(类.class)
 * [线程不安全，不可用]
 */
public class Singleton {
    private static Singleton instance = null;
    
    private Singleton() {
    }
    
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}
