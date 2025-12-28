package work018;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import work018.beans.PrototypeBean;
import work018.beans.SingletonBean;
import work018.config.AppConfig;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("\n=== Singleton scope ===");
        SingletonBean s1 = context.getBean(SingletonBean.class);
        SingletonBean s2 = context.getBean(SingletonBean.class);
        System.out.println("s1 == s2: " + (s1 == s2));  // true
        System.out.println("s1 hash: " + s1.hashCode());
        System.out.println("s2 hash: " + s2.hashCode());

        System.out.println("\n=== Prototype scope ===");
        PrototypeBean p1 = context.getBean(PrototypeBean.class);
        PrototypeBean p2 = context.getBean(PrototypeBean.class);
        System.out.println("p1 == p2: " + (p1 == p2));  // false
        System.out.println("p1 hash: " + p1.hashCode());
        System.out.println("p2 hash: " + p2.hashCode());

        System.out.println("\nПриложение успешно запущено. Все бины созданы с разными скоупами.");

        context.close();
    }
}