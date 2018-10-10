package test;

import data.A;
import data.B;

public class SingletonTest {
    public static void main(String[] args) {
        A a = new A();
        a.set();
        B b = new B();
        b.print();
    }
}
