package singleton;

/**
 * 通过枚举创建对象
 */
public enum SingletonEnum {
    instance;
    
    private SingletonEnum(){}
    
    public static SingletonEnum getInstance(){
        return instance;
    }
}
