package singleton;

/**
 * 单例模式的懒汉式模板
 * [线程不安全，不可用]
 */
public class Singleton {
    private static Singleton instance = null;
    
    private Singleton() {
    }
    
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
