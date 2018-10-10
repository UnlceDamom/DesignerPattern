package singleton;

/**
 * 内部类的方式创建对象
 */
public class Singleton {
    //私有化构造方法
    private Singleton() {
    }
    
    //创建静态的内部类
    public static class SingletonInner {
        //在内部类中创建对象
        public static Singleton instance = new Singleton();
    }
    
    //提供get方法
    public static Singleton getInstance(){
        return SingletonInner.instance;
    }
}
