package test;

import data.A;
import data.B;
import data.ConfigFileEnum;

public class SingletonTest {
    public static void main(String[] args) {
        ConfigFileEnum configFileEnum = ConfigFileEnum.configFileEnum.getConfigFileEnum();
        System.out.println(configFileEnum.hashCode());
    
        ConfigFileEnum configFileEnum1 = ConfigFileEnum.configFileEnum.getConfigFileEnum();
        System.out.println(configFileEnum1.hashCode());
    }
}
