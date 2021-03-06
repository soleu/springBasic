package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();//ctrl + alt + v
        for (String beanDefinitionName : beanDefinitionNames) { //iter +tab : for문 자동완성
            Object bean = ac.getBean(beanDefinitionName); //type지정이 되지 않아 Object

            System.out.println("name = "+beanDefinitionName + "object= "+bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기") //내가 짠 코드만 보기
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();//ctrl + alt + v
        for (String beanDefinitionName : beanDefinitionNames) { //iter +tab : for문 자동완성
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);//beanDefinition : 각각의 bean에 관한 정보

            //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){ //getRole() : 내가 사용하기 위해 등록한 빈만 출력
             Object bean =ac.getBean(beanDefinitionName);
                System.out.println("name = "+beanDefinitionName + "object= "+bean);
            }

        }
    }
}
