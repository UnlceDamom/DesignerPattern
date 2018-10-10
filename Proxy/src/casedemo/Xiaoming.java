package casedemo;

public class Xiaoming implements PersonInfo {
    @Override
    public void height() {
        System.out.println("身高150cm");
    }

    @Override
    public void job() {
        System.out.println("职位CEO");
    }

    @Override
    public void name() {
        System.out.println("小明");
    }

    @Override
    public void age() {
        System.out.println("年龄28");
    }
}
