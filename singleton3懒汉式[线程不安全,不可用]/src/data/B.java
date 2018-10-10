package data;

public class B {
    public static void print() throws Exception {
        int count = 0;
        count = ConfigFile.getConfigFile().num1 + ConfigFile.getConfigFile().num2;
        System.out.println("count=" + count);
    }
}
