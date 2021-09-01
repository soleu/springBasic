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
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();//ctrl + alt + v
        for (String beanDefinitionName : beanDefinitionNames) { //iter +tab : for문 자동완성

            //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            //Role ROLE_INn
            if(beanDefintion.getRole()= BeanDefinition.ROLE_APPLICATION){
             Object bean =ac.getBean(beanDefinitionName);
                System.out.println("name = "+beanDefinitionName + "object= "+bean);
            }

        }
    }
}
