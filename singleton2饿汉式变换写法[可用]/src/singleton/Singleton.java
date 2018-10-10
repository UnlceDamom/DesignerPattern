package singleton;

/**
 * 单例模式的饿汉式变换写法模板
 * (1)私有化该类的构造函数
 * (2)通过new在本类中创建一个本类对象
 * (3)定义一个公有的方法，将在该类中所创建的对象返回
 * 可以看到上面的代码是按照在2中分析的那三步来实现的，
 * 这中写法被称为饿汉式，因为它在类创建的时候就已经实例化了对象。
 * 其实4.2和4.1只是写法有点不同，都是在类初始化时创建对象的，
 * 它的优缺点和4.1一样，可以归为一种写法。
 */
public class Singleton {
    private static Singleton instance = null;
    
    static {
        instance = new Singleton();
    }
    
    private Singleton() {
    }
    
    public static Singleton getInstance() {
        return instance;
    }
}
