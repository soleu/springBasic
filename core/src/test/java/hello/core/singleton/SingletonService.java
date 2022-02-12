package hello.core.singleton;

public class SingletonService {

    //자기자신을 내부의 static으로 선언(클래스 레벨에 올라가기 때문에 스태틱 영역에 딱 하나만 생성됨)
    private  static final SingletonService instance = new SingletonService();
    //조회(해당 메서드를 통해서만)
    public  static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){

    }
    public static void  logic(){
        System.out.printf("싱글톤 객체 로직 호출");
    }

}
