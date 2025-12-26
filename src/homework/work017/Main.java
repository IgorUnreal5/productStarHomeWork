package work017;

import org.apache.commons.lang3.StringUtils;

public class Main {
    public static void main(String[] args) {
        String text = "Hello, World!";

        // через Apache Commons Lang
        String reversedCommons = StringUtils.reverse(text);
        System.out.println("Через commons-lang3: " + reversedCommons);

        // через свою JAR-библиотеку
        // можно переимновать после того, как соберете проект
        // класс StringReverse.java, чтобы убедиться, что
        // работает от библиотеки
        String reversedMyLib = StringReverser.reverse(text);
        System.out.println("Через свою библиотеку (из JAR): " + reversedMyLib);

        StringReverser lib = new StringReverser();
        lib.sayHello();
    }
}