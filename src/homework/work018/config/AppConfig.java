package work018.config;

import work018.beans.PrototypeBean;
import work018.beans.SingletonBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    public SingletonBean singletonBean() {
        System.out.println(">>> Создаётся singleton-бин");
        return new SingletonBean();
    }

    @Bean
    @Scope("prototype")
    public PrototypeBean prototypeBean() {
        System.out.println(">>> Создаётся prototype-бин");
        return new PrototypeBean();
    }
}