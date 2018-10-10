package cardemo;

public class Qq implements Car {
    @Override
    public void run() {
        System.out.println("Qq跑60迈...");
    }

    @Override
    public void stop() {
        System.out.println("QQ刹车...");
    }

    @Override
    public String addOil(int num) {
        return "Qq加"+num+"#号油";
    }
}
