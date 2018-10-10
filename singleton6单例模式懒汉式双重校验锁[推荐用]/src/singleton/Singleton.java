package singleton;

/**
 * 懒汉式变种，属于懒汉式中最好的写法，保证了：延迟加载和线程安全
 */
public class Singleton {
    private static volatile Singleton instance = null;
    
    private Singleton() {
    }
    
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {//加一次判断，这样当第二个线程进来时会发现对象已经创建了，不会走if里面的代码，也就不会再创建一个新的对象了
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
