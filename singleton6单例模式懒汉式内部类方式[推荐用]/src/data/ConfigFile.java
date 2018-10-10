package data;

import singleton.Singleton;

public class ConfigFile {
    int num1 = 1;
    int num2 = 2;
    //1.私有化构造方法
    private ConfigFile() {
    }
    
    //2.创建静态的匿名内部类
    public static class ConfigFileInner{
        public static ConfigFile configFile = new ConfigFile();
    }
    
    //3.对外提供一个可以让其他程序获取该对象的方法,定义一个公有的方法，将在该类中所创建的对象返回
    public static synchronized ConfigFile getConfigFile() {
        return ConfigFileInner.configFile;
    }
}
