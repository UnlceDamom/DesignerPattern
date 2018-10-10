package data;

public class A {
    public void set(){
        ConfigFile.getConfigFile().num1=2;
        System.out.println(ConfigFile.getConfigFile().num1);
    }
}
