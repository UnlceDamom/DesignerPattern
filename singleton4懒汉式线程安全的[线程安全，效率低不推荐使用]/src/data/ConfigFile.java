package data;

public class ConfigFile {
    int num1 = 1;
    int num2 = 2;
    //1.不允许其他程序用new对象,私有化该类的构造函数
    private static ConfigFile configFile = null;
    
    //2.在该类中创建对象,通过new在本类中创建一个本类对象
    private ConfigFile() {
    }
    
    //3.对外提供一个可以让其他程序获取该对象的方法,定义一个公有的方法，将在该类中所创建的对象返回
    public static synchronized ConfigFile getConfigFile() {
        if (configFile == null) {
            configFile = new ConfigFile();
        }
        return configFile;
    }
}
