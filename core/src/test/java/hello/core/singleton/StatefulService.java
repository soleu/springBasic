package hello.core.singleton;
//cmd+shift+T
public class StatefulService {
    private int price;

    public static void order(String name,int price) {
        System.out.println("name = " + name +"price = "+price);
        this.price=price;//
    }

    public int getPrice() {
        return price;
    }
}
