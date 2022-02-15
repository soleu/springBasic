package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class AutowiredTest {
@Test
    void AutowiredOption(){
    ApplicationContext ac=new AnnotationConfigApplicationContext(TestBean.class);

}
static class TestBean{

    @Autowired(required = false) //bean의 값(의존관계가 없으면, 수정자 메서드 자체가 호출이 안됨)
    public void setNoBean1(Member noBean1){
        System.out.println("noBean1 = " + noBean1);// X
    }
    @Autowired //메서드는 호출이 되지만, null이 입력됨
    public void setNoBean2(@Nullable Member noBean2){
        System.out.println("noBean2 = " + noBean2);//null
    }
    @Autowired //Optional.empty가 입력됨
    public void setNoBean3(Optional <Member> noBean3){
        System.out.println("noBean3 = " + noBean3);//Optional.empty
    }
}

}
