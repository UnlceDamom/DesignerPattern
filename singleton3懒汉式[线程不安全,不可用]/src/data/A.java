package data;

public class A {
    public static void set() throws Exception {
        ConfigFile.getConfigFile().num1=2;
        B.print();
        System.out.println(ConfigFile.getConfigFile().num1);
    }
}
