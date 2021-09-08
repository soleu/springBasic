package hello.core.singleton;

public class SingletonService {

    //자기자신을 내부의 static으로 선언
    private  static final SingletonService instance = new SingletonService();
    //조회
    public  static SingletonService getInstance(){
        return instance;
    }


    public static void main(String[] args){

    }

}
