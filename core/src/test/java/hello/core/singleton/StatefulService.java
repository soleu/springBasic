package hello.core.singleton;

//cmd+shift+T
public class StatefulService {
    private int price;

    public int order(String name, int price) {
        System.out.println("name = " + name + "price = " + price);
//        this.price=price; //여기서 값을 변경 X
        return price;
    }

    public int getPrice() {
        return price;
    }
}
