package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 기존의 AppConfig,TestConfig도 함께 등록되므로 제외시킴(@Configuration을 모두 제외. 실무에서는 X)
        excludeFilters=@ComponentScan.Filter(type=FilterType.ANNOTATION,classes =Configuration.class))
public class AutoAppConfig {
  }